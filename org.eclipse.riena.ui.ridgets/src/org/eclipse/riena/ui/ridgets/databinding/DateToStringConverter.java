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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Converts a Date to a String with a given pattern.
 */
public class DateToStringConverter extends Converter {

	private final DateFormat format;
	private final TimeZone timezone;

	/**
	 * Creates a DateToStringConverter.
	 * 
	 * @param pattern
	 *            The pattern to match e.g. MM/dd/yyyy.
	 */
	public DateToStringConverter(String pattern) {
		super(Date.class, String.class);
		format = new SimpleDateFormat(pattern);
		if (!hasTimeZone(pattern)) {
			timezone = TimeZone.getDefault();
		} else {
			timezone = null;
		}
	}

	/**
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		if (fromObject == null) {
			return null;
		}
		synchronized (format) {
			Date localDate = createLocalDate((Date) fromObject);
			return format.format(localDate);
		}
	}

	// helping methods
	// ////////////////

	/**
	 * If necessary convert from GMT date into local Date.
	 */
	private Date createLocalDate(Date date) {
		Date result = date;
		if (timezone != null) {
			long time = date.getTime();
			int offset = timezone.getOffset(time);
			result = new Date(time - offset);
		}
		return result;
	}

	private boolean hasTimeZone(String pattern) {
		return pattern.contains("zzz") || pattern.contains("ZZZZ"); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
