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
package org.eclipse.riena.ui.swt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SwtUtilities;

/**
 * Represents a label of the status line that displays the current time.
 */
public class StatuslineTime extends AbstractStatuslineComposite {

	protected SimpleDateFormat format;
	private Date date;
	private CLabel timeLabel;
	private Timer timer;

	/**
	 * Creates a new instance of <code>StatuslineTime</code>.
	 * 
	 * @param parent
	 *            a widget which will be the parent of the new instance
	 *            (cannot be null)
	 * @param style
	 *            the style of widget to construct
	 */
	public StatuslineTime(Composite parent, int style) {

		super(parent, style | SWT.NO_FOCUS);
		timer = new Timer();
		StatuslineUpdateTask task = new StatuslineUpdateTask();
		timer.scheduleAtFixedRate(task, 0, 1000);

	}

	/**
	 * @see org.eclipse.riena.ui.swt.AbstractStatuslineComposite#createContents()
	 */
	@Override
	protected void createContents() {

		timeLabel = new CLabel(this, SWT.LEFT);
		timeLabel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.STATUSLINE_BACKGROUND));
		updateTime();

	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		super.dispose();

		if (timer != null) {
			timer.cancel();
			timer = null;
		}

		SwtUtilities.disposeWidget(timeLabel);

	}

	/**
	 * Returns the format of the date and/or time.
	 * 
	 * @return format
	 */
	protected SimpleDateFormat getFormat() {

		if (format == null) {
			format = new SimpleDateFormat("HH:mm"); //$NON-NLS-1$
		}
		return format;

	}

	/**
	 * Sets the current time.
	 */
	private void updateTime() {

		if (date == null) {
			date = new Date();
		}
		date.setTime(System.currentTimeMillis());
		String timeStrg = getFormat().format(date);
		if ((timeLabel != null) && (!timeLabel.isDisposed())) {
			timeLabel.setText(timeStrg);
		}

	}

	/**
	 * This task updates the time.
	 */
	private class StatuslineUpdateTask extends TimerTask {

		/**
		 * @see java.util.TimerTask#run()
		 */
		@Override
		public void run() {
			if (!isDisposed() && !getDisplay().isDisposed()) {
				getDisplay().asyncExec(new Runnable() {
					public void run() {
						updateTime();
					}
				});
			}
		}

	}

}
