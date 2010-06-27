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

import org.eclipse.riena.ui.core.uiprocess.UIProcess;

/**
 * Interface for showing the progress.
 * 
 * @see UIProcessControl
 */
public interface IProgressControl {

	/**
	 * Start showing progress/process.
	 */
	void start();

	/**
	 * Stop showing progress/process.
	 */
	void stop();

	/**
	 * Changes the window into processing state.
	 */
	void showProcessing();

	/**
	 * Visualizes a specific progress of the {@link UIProcess}.
	 * 
	 * @param value
	 *            the current value
	 * @param maxValue
	 *            the maximum value
	 */
	void showProgress(int value, int maxValue);

	/**
	 * Sets the description.
	 * 
	 * @param description
	 */
	void setDescription(String description);

	/**
	 * Sets the title.
	 * 
	 * @param title
	 */
	void setTitle(String title);

	/**
	 * Add an {@link ICancelListener} to be notified about cancel events.
	 * <p>
	 * 
	 * @param a
	 *            non-null listener
	 */
	void addCancelListener(ICancelListener listener);

	/**
	 * Removes an {@link ICancelListener} from the list of listeners.
	 * 
	 * @param a
	 *            non-null listener
	 */
	void removeCancelListener(ICancelListener listener);

}
