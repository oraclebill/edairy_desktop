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

import java.util.Date;

/**
 * Ridget for a date / time field.
 * 
 * @see IDateTextRidget
 */
public interface IDateTimeRidget extends ITextRidget {

	/**
	 * Property name of the date property.
	 * <p>
	 * 
	 * @see #getDate()
	 * @see #setDate(Date)
	 */
	String PROPERTY_DATE = "date"; //$NON-NLS-1$

	/**
	 * Get the date value of this ridget.
	 * <p>
	 * 
	 * @return the date
	 */
	Date getDate();

	/**
	 * Set the date value of this ridget.
	 * <p>
	 * 
	 * @param date
	 *            a Date value
	 */
	void setDate(Date date);

}
