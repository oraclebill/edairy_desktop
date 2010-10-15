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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.eclipse.core.databinding.conversion.Converter;

import org.eclipse.riena.ui.ridgets.validation.Utils;

/**
 * Converts a String that matches a given pattern to a Date.
 */
public class StringToDateConverter extends Converter {

	private final DateFormat format;
	private final TimeZone timezone;

	/**
	 * Creates a StringToDateConverter.
	 * 
	 * @param pattern
	 *            The pattern to match e.g. MM/dd/yyyy.
	 */
	public StringToDateConverter(String pattern) {
		super(String.class, Date.class);
		format = new SimpleDateFormat(pattern);
		if (!hasTimeZone(pattern)) {
			timezone = TimeZone.getDefault();
		} else {
			timezone = null;
		}
	}

	public Object convert(Object fromObject) {
		if (fromObject == null || "".equals(fromObject) //$NON-NLS-1$
				|| Utils.isEmptyDate(((String) fromObject))) {
			return null;
		}
		try {
			synchronized (format) {
				Date parsedDate = format.parse((String) fromObject);
				return createGMTDate(parsedDate);
			}
		} catch (ParseException e) {
			throw new ConversionFailure("Cannot convert \"" + fromObject + "\" to a java.util.Date.", e); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	// helping methods
	// ////////////////

	/**
	 * If necessary convert from 'local' date into a GMT Date.
	 */
	private Date createGMTDate(Date date) {
		Date result = date;
		if (timezone != null) {
			long time = date.getTime();
			int offset = timezone.getOffset(time);
			result = new Date(time + offset);
		}
		return result;
	}

	private boolean hasTimeZone(String pattern) {
		return pattern.contains("zzz") || pattern.contains("ZZZZ"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
