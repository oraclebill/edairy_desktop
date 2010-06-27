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
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Converts <code>String</code> to <code>GregorianCalendar</code>.
 */
public class StringToGregorianCalendarConverter extends Converter {

	private final static DateFormat FORMAT = DateFormat.getDateInstance(DateFormat.MEDIUM);

	/**
	 * Creates a new instance of the converter and specifies the <i>fromType</i>
	 * and the <i>toType</i>.
	 */
	public StringToGregorianCalendarConverter() {
		super(String.class, GregorianCalendar.class);
	}

	/**
	 * Parses and converts the given object to <code>GregorianCalendar</code>.<br>
	 * If the given object can not be parsed, the converter returns
	 * <code>null</code>.
	 * 
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {

		if ((fromObject == null) || "".equals(fromObject)) { //$NON-NLS-1$
			return null;
		}

		try {
			synchronized (FORMAT) {
				Date date = FORMAT.parse(fromObject.toString());
				Calendar calendar = GregorianCalendar.getInstance();
				calendar.setTime(date);
				return calendar;
			}
		} catch (ParseException e) {
			throw new ConversionFailure("Cannot convert \"" + fromObject + "\" to GregorianCalendar.", e); //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

}
