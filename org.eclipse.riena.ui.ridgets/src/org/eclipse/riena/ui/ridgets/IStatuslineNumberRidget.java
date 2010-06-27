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
 * Interface for the Adapter of the number component of the status line
 */
public interface IStatuslineNumberRidget extends IRidget {

	/**
	 * Returns the number that will be display in the status line.
	 * 
	 * @return the number of the status line
	 */
	Integer getNumber();

	/**
	 * Sets the number that will be display in the status line.
	 * 
	 * <b>Note: </b> If you set the number, the number string is set
	 * <code>null</code>
	 * 
	 * @param number
	 *            the new number of the status line
	 * @see #setNumberString(String)
	 */
	void setNumber(Integer number);

	/**
	 * Returns the string that will be display in the status line at the
	 * position of the number.
	 * 
	 * @return string in the status line at the position of the number
	 */
	String getNumberString();

	/**
	 * Sets the string, that will be display in the status line at the position
	 * of the number. <b>Note: </b> If you set the number string, the number is
	 * set 0
	 * 
	 * @param numberStrg
	 *            the string to displayed in the status line; null removes the
	 *            number string from the status line
	 * @see #setNumber(int)
	 */
	void setNumberString(String numberStrg);

}
