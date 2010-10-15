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
package org.eclipse.riena.ui.ridgets.databinding;

import java.text.DateFormat;
import java.util.GregorianCalendar;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Converts <code>GregorianCalendar</code> to <code>String</code>.
 */
public class GregorianCalendarToStringConverter extends Converter {

	private final static DateFormat FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM);

	/**
	 * Creates a new instance of the converter and specifies the <i>fromType</i>
	 * and the <i>toType</i>.
	 */
	public GregorianCalendarToStringConverter() {
		super(GregorianCalendar.class, String.class);
	}

	/**
	 * Formats/Converts the given object to <code>String</code>.<br>
	 * If the given object is not a <code>GregorianCalendar</code>, the
	 * converter returns an empty string.
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {

		if ((fromObject != null) && (fromObject.getClass() == getFromType())) {
			GregorianCalendar calendar = (GregorianCalendar) fromObject;
			synchronized (FORMAT) {
				return FORMAT.format(calendar.getTime());
			}
		}
		return ""; //$NON-NLS-1$

	}

}
