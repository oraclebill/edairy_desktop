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

/**
 * Listener for the {@link IUIProcessWindow}.
 * 
 */
public interface IProcessWindowListener {

	/**
	 * Method that will be called, when the window is about to close.
	 * <p>
	 * {@link UIProcessWindow#close() }
	 */
	void windowAboutToClose();
}
