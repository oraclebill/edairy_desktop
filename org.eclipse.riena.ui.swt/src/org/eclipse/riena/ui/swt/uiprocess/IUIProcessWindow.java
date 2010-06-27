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

import org.eclipse.swt.widgets.ProgressBar;

import org.eclipse.riena.ui.core.uiprocess.UIProcess;

/**
 * Interface describing a window for the {@link UIProcess}.
 */
public interface IUIProcessWindow {

	/**
	 * opens the window.
	 */
	void openWindow();

	/**
	 * closes the window.
	 */
	void closeWindow();

	/**
	 * sets the description of the uiProcess.
	 * 
	 * @param description
	 */
	void setDescription(String description);

	/**
	 * Add an window listener to this UIProcessWindow.
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param listener
	 *            a non-null window listener.
	 */
	void addProcessWindowListener(IProcessWindowListener listener);

	/**
	 * Returns the {@link ProgressBar}.
	 * 
	 * @return the Progressbar
	 */
	ProgressBar getProgressBar();

}
