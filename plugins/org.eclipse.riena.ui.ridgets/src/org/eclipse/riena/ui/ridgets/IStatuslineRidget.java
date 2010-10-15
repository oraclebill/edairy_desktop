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
package org.eclipse.riena.ui.ridgets;

/**
 * Ridget for a status line. The status line consists of at least a message and
 * an icon.
 */
public interface IStatuslineRidget extends IComplexRidget {

	/**
	 * Show an info message (and icon) in the status line.
	 * 
	 * @param message
	 *            The info message; never null; may be empty
	 */
	void info(String message);

	/**
	 * Show a warning message (and icon) in the status line.
	 * 
	 * @param message
	 *            The warning message; never null; may be empty
	 */
	void warning(String message);

	/**
	 * Show an error message (and icon) in the status line.
	 * 
	 * @param message
	 *            The error message; never null; may be empty
	 */
	void error(String message);

	/**
	 * Clears the message and the icon from the status line.
	 */
	void clear();

	/**
	 * Returns the message shown in the status line.
	 * 
	 * @return a String; never null; may be empty
	 */
	String getMessage();

	/**
	 * Shows the given message in the status line.
	 * 
	 * @param message
	 *            The message to set; never null; may be empty.
	 */
	void setMessage(String message);

	/**
	 * Return the {@link IStatuslineUIProcessRidget} for this status line, if
	 * available.
	 * 
	 * @return an {@link IStatuslineUIProcessRidget} or null.
	 */
	IStatuslineUIProcessRidget getStatuslineUIProcessRidget();

	/**
	 * Return the {@link IStatuslineNumberRidget} for this status line, if
	 * available.
	 * 
	 * @return an {@link IStatuslineNumberRidget} or null.
	 */
	IStatuslineNumberRidget getStatuslineNumberRidget();

}
