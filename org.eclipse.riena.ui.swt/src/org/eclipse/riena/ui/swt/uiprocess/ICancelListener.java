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
 * A {@code ICancelListener} observes the
 * {@link org.eclipse.jface.window.ApplicationWindow}´s cancel state
 */
public interface ICancelListener {

	/**
	 * Notifies that either the window is closed or the cancel button is
	 * pressed. Closing the window leads to all
	 * {@link org.eclipse.riena.ui.core.uiprocess.UIProcess} being stopped.
	 * Cancel only stops the current visualized
	 * {@link org.eclipse.riena.ui.core.uiprocess.UIProcess}.
	 * 
	 * @param windowClosing
	 *            flag indicating if the whole window has been closed
	 * 
	 */
	void canceled(boolean windowClosing);

}
