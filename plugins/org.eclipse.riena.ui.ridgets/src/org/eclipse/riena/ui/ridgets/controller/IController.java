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
package org.eclipse.riena.ui.ridgets.controller;

import org.eclipse.riena.ui.ridgets.IRidgetContainer;

/**
 * Controller for a view. Must have a property for every UI control added to the
 * view. The type of the property must be a Ridget matching the type of the
 * UI-control.
 */
public interface IController extends IRidgetContainer {

	/**
	 * Invoked after the controller was bound to a view.
	 */
	void afterBind();

	/**
	 * Blocks of unblocks the user input for the view to which this controller
	 * is bound.
	 * 
	 * @param blocked
	 *            {@code true} if input is blocked for the view; otherwise
	 *            {@code false}
	 */
	void setBlocked(boolean blocked);

	/**
	 * Returns true if user input for the view to which this controller is bound
	 * is blocked.
	 * 
	 * @return {@code true} if input is blocked for the view; otherwise {@code
	 *         false}
	 */
	boolean isBlocked();
}
