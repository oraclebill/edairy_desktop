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
package org.eclipse.riena.internal.ui.ridgets.swt.uiprocess;

import org.eclipse.core.runtime.Assert;

import org.eclipse.riena.ui.core.uiprocess.IProgressVisualizer;
import org.eclipse.riena.ui.core.uiprocess.UIProcess;
import org.eclipse.riena.ui.swt.uiprocess.ProcessState;
import org.eclipse.riena.ui.swt.uiprocess.ProgressInfoDataObject;

/**
 * class holding detail information about a running {@link UIProcess}
 */
public class ProcessDetail {

	private static volatile int keyDec = 0;

	private static int nextKey() {
		return keyDec++;
	}

	// the maximum value a pending process can reach
	private static final int PENDING_MAXWORK = 100;
	private static final int PENDING_STEP = 10;

	private final IProgressVisualizer visualizer;

	// state
	private ProcessState state = ProcessState.PENDING;

	// steady changing progress when in state pending (triggered by update thread)
	private int pendingProgress = 0;

	//state of work
	private int progress = 0;

	// startup time in millis [TS = time stamp]
	private final long startupTS;

	private final int key = nextKey();

	public ProcessDetail(long startupTS, IProgressVisualizer visualizer) {
		this.startupTS = startupTS;
		this.visualizer = visualizer;
	}

	public IProgressVisualizer getVisualizer() {
		return visualizer;
	}

	/**
	 * @return the time the {@link IProgressVisualizer} was first "seen"
	 */
	public long getStartupTS() {
		return startupTS;
	}

	public boolean isPending() {
		return ProcessState.PENDING.equals(state) || getVisualizer().getProcessInfo().getMaxProgress() < 0;
	}

	/**
	 * called by timer when {@link #isPending()} == true
	 */
	public void triggerPending() {
		Assert.isTrue(isPending(), ":-( triggerPending called in working state"); //$NON-NLS-1$
		if (pendingProgress <= PENDING_MAXWORK) {
			// go on
			pendingProgress += PENDING_STEP;
		} else {
			// reset
			pendingProgress = 0;
		}
	}

	/**
	 * @return depends on {@link #isPending()} if {@link #totalWork} or
	 *         {@link #PENDING_MAXWORK} is returned
	 */
	public int getMaxValue() {
		return isPending() ? PENDING_MAXWORK : getVisualizer().getProcessInfo().getMaxProgress();
	}

	/**
	 * @return depends on {@link #isPending()} if {@link #pendingProgress} or
	 *         {@link #progress} is returned
	 */
	public int getValue() {
		return isPending() ? pendingProgress : progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getProgress() {
		return progress;
	}

	/**
	 * sets the state of the process
	 * 
	 * @param state
	 */
	public void setState(ProcessState state) {
		this.state = state;
	}

	/**
	 * @return the state
	 */
	public ProcessState getState() {
		return state;
	}

	private int calculatePercentage() {
		return calculatePercentage(getValue(), getMaxValue());
	}

	private static int calculatePercentage(int ivalue, int imaxValue) {
		double dmaxValue = imaxValue;
		double dValue = ivalue;
		return (int) ((dValue / dmaxValue) * 100);
	}

	/**
	 * 
	 * @return a data object describing the {@link ProcessDetail}
	 */
	public ProgressInfoDataObject toPido() {
		return new ProgressInfoDataObject(key, getMaxValue(), calculatePercentage(), getVisualizer().getProcessInfo()
				.getTitle(), state);
	}

}