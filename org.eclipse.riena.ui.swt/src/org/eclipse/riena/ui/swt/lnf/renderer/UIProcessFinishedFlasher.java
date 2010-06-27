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
package org.eclipse.riena.ui.swt.lnf.renderer;

import org.eclipse.riena.ui.core.marker.UIProcessFinishedMarker;
import org.eclipse.riena.ui.core.uiprocess.IUISynchronizer;
import org.eclipse.riena.ui.swt.uiprocess.SwtUISynchronizer;

/**
 * This class controls the flasher of a marker.
 */
public class UIProcessFinishedFlasher extends Thread {

	private static IUISynchronizer uiSynchronizer;

	private UIProcessFinishedMarker processMarker;
	private Runnable updater;

	/**
	 * Creates a new instance of {@link UIProcessFinishedMarker}.
	 * 
	 * @param processMarker
	 *            marker to control
	 * @param updater
	 *            the updater shows or hides the marker during and after
	 *            flashing.
	 */
	public UIProcessFinishedFlasher(UIProcessFinishedMarker processMarker, Runnable updater) {
		this.processMarker = processMarker;
		this.updater = updater;
		if (uiSynchronizer == null) {
			uiSynchronizer = new SwtUISynchronizer();
		}
	}

	/**
	 * While the marker is flashing show or hide the marker.
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while (processMarker.isFlashing()) {

			uiSynchronizer.syncExec(updater);
			processMarker.increase();
			processMarker.setOn(!processMarker.isOn());
			try {
				int sleepTime = 0;
				if (processMarker.isOn()) {
					sleepTime = processMarker.getTimeOn();
				} else {
					sleepTime = processMarker.getTimeOff();
				}
				if (sleepTime > 0) {
					Thread.sleep(sleepTime);
				}
			} catch (InterruptedException e) {
				e.getCause(); // ...can be swallowed because the flashing of the process
				// finished marked is not intended to be cancelable. If a caller invokes
				// .interrupt() on this thread it may be ignored. The pointless statement
				// avoids a Checkstyle warning.
			}
		}

		uiSynchronizer.syncExec(updater);

	}

}
