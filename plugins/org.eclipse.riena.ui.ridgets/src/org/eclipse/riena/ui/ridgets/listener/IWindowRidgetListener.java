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
package org.eclipse.riena.ui.ridgets.listener;

import org.eclipse.riena.ui.ridgets.IWindowRidget;

/**
 * Listener notifies, if something with the frame happens.
 * 
 * @see IWindowRidget
 */
public interface IWindowRidgetListener {

	/**
	 * This method is called if the underlying {@link IWindowRidget} gets
	 * closed.
	 */
	void closed();

	/**
	 * This method is called if the underlying {@link IWindowRidget} gets
	 * activated.
	 */
	void activated();

}
