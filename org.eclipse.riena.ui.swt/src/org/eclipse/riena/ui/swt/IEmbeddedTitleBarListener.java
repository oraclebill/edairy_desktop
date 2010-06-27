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

import org.eclipse.swt.events.MouseEvent;

/**
 * Listener for embedded title bars.
 */
public interface IEmbeddedTitleBarListener {

	/**
	 * Called if mouse was clicked over an inactive title bar.
	 * 
	 * @param e
	 *            origin mouse event.
	 */
	void windowActivated(MouseEvent e);

	/**
	 * Called if mouse was clicked over the close button of the title bar.
	 * 
	 * @param e
	 *            origin mouse event.
	 */
	void windowClosed(MouseEvent e);

}
