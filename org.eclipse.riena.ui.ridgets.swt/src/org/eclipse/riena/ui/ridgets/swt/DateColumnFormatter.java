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
package org.eclipse.riena.ui.ridgets.swt;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.riena.ui.ridgets.databinding.DateToStringConverter;

/**
 * A column formatter for dates (convenience class).
 */
public abstract class DateColumnFormatter extends ColumnFormatter {

	private final IConverter converter;

	/**
	 * Creates a DateColumnFormatter.
	 * 
	 * @param pattern
	 *            The formatting pattern (example: MM/dd/yyyy). Must not be
	 *            null. Must be compatible with formatting strings as expected
	 *            by {@link SimpleDateFormat}.
	 */
	public DateColumnFormatter(String format) {
		converter = new DateToStringConverter(format);
	}

	/**
	 * Returns a formatted date for this cell.
	 */
	@Override
	public String getText(Object element) {
		String result = null;
		Date date = getDate(element);
		if (date != null) {
			result = (String) converter.convert(date);
		}
		return result;
	}

	/**
	 * Subclasses must provide code to extract a Date from the given row
	 * element.
	 * 
	 * @param element
	 *            the row element
	 * @return a Date or null
	 */
	protected abstract Date getDate(Object element);

}