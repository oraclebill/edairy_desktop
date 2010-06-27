/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.swt.uiprocess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.osgi.service.log.LogService;

import org.eclipse.core.runtime.Assert;
import org.eclipse.equinox.log.Logger;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.ui.core.uiprocess.IUISynchronizer;

/**
 * Serializes a runnable to the SWT-Thread
 * 
 */
public class SwtUISynchronizer implements IUISynchronizer {

	private static List<FutureSyncLatch> syncJobs = Collections.synchronizedList(new ArrayList<FutureSyncLatch>());
	private static List<Runnable> asyncJobs = Collections.synchronizedList(new ArrayList<Runnable>());
	private static Thread displayObserver;
	private static AtomicBoolean workbenchShutdown = new AtomicBoolean(false);

	/**
	 * @see IUISynchronizer#syncExec(Runnable)
	 */
	public void syncExec(Runnable runnable) {
		execute(new SyncExecutor(), runnable);
	}

	/**
	 * @see IUISynchronizer#asyncExec(Runnable)
	 */
	public void asyncExec(Runnable runnable) {
		execute(new ASyncExecutor(), runnable);
	}

	/*
	 * Executes the given runnable using the executor. First checks if there is
	 * a display available.
	 */
	private void execute(Executor executor, Runnable runnable) {
		if (isWorkbenchShutdown()) {
			return;
		}
		if (!hasDisplay()) {
			waitForDisplay(15000);
		}
		Display display = getDisplay();
		if (executeOnDisplay(executor, runnable, display)) {
			return;
		}

		if (display == null || getDisplay().isDisposed()) {
			if (isSyncExecutor(executor)) {
				waitForDisplayInitialisation(runnable);
			} else {
				queueRunnable(executor, runnable);
			}

		}

	}

	private void startObserver() {
		synchronized (SwtUISynchronizer.class) {
			if (displayObserver == null) {
				displayObserver = new DisplayObserver();
				displayObserver.start();
			}
		}
	}

	private void queueRunnable(Executor executor, Runnable runnable) {
		synchronized (SwtUISynchronizer.class) {
			asyncJobs.add(runnable);
		}
		startObserver();
	}

	private class DisplayObserver extends Thread {

		@Override
		public void run() {

			while (PlatformUI.isWorkbenchRunning() && getDisplay() == null || getDisplay().isDisposed()) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					getLogger().log(LogService.LOG_ERROR, e.getMessage());
				}
			}

			synchronized (SwtUISynchronizer.class) {

				// notify job waiters (syncExec)
				Iterator<FutureSyncLatch> syncIter = syncJobs.iterator();
				while (syncIter.hasNext()) {
					SwtUISynchronizer.FutureSyncLatch futureSyncLatch = (SwtUISynchronizer.FutureSyncLatch) syncIter
							.next();
					futureSyncLatch.countDown();
					syncIter.remove();
				}

				// execute jobs (asyncExec)
				Iterator<Runnable> asyncIter = asyncJobs.iterator();
				while (asyncIter.hasNext()) {
					Runnable next = (Runnable) asyncIter.next();
					if (!isWorkbenchShutdown()) {
						new ASyncExecutor().execute(getDisplay(), next);
					}
					asyncIter.remove();

				}
				displayObserver = null;
			}

		}
	}

	private void waitForDisplayInitialisation(Runnable job) {
		FutureSyncLatch latch = new FutureSyncLatch(1, job);
		synchronized (SwtUISynchronizer.class) {
			syncJobs.add(latch);
		}
		startObserver();
		try {

			latch.await();
		} catch (InterruptedException e) {
			getLogger().log(LogService.LOG_ERROR, e.getMessage());
		}
	}

	private boolean isSyncExecutor(Executor executor) {
		return executor instanceof SyncExecutor;
	}

	private class FutureSyncLatch extends CountDownLatch {

		private Runnable job;

		public FutureSyncLatch(int count, Runnable job) {
			super(count);
			this.job = job;
		}

		@Override
		public void await() throws InterruptedException {
			super.await();
			if (!isWorkbenchShutdown()) {
				new SyncExecutor().execute(getDisplay(), job);
			}
		}

	}

	private boolean executeOnDisplay(Executor executor, Runnable runnable, Display display) {
		if (null != display && !display.isDisposed()) {
			executor.execute(display, runnable);
			return true;
		}
		return false;
	}

	public Display getDisplay() {
		if (hasDisplay()) {
			return PlatformUI.getWorkbench().getDisplay();
		}
		return null;
	}

	private Logger getLogger() {
		return Log4r.getLogger(org.eclipse.riena.internal.ui.swt.Activator.getDefault(), SwtUISynchronizer.class);
	}

	protected boolean hasDisplay() {
		return PlatformUI.isWorkbenchRunning() && PlatformUI.getWorkbench().getDisplay() != null;
	}

	/**
	 * Wait for display in 500ms increments, up to timeoutMs
	 * 
	 * @param timeoutMs
	 *            time out in ms (positive)
	 */
	private void waitForDisplay(int timeoutMs) {

		Assert.isTrue(timeoutMs >= 0);

		int time = 0;

		do {
			try {
				Thread.sleep(500);
				time += 500;
			} catch (InterruptedException e) {
				return;
			}
		} while (time < timeoutMs && !hasDisplay());
	}

	private interface Executor {
		void execute(Display display, Runnable runnable);
	}

	private static class SyncExecutor implements Executor {
		public void execute(Display display, Runnable runnable) {
			display.syncExec(runnable);
		}
	}

	private static class ASyncExecutor implements Executor {
		public void execute(Display display, Runnable runnable) {
			display.asyncExec(runnable);
		}
	}

	/**
	 * @return if true if the workbench has been shutdown
	 */
	public static boolean isWorkbenchShutdown() {
		return workbenchShutdown.get();
	}

	/**
	 * @param workbenchShutdown
	 *            the workbenchShutdown to set
	 */
	public static void setWorkbenchShutdown(boolean workbenchShutdown) {
		SwtUISynchronizer.workbenchShutdown.set(workbenchShutdown);
	}
}
