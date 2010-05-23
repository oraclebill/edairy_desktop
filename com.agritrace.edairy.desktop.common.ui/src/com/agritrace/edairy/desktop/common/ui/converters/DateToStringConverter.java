package com.agritrace.edairy.desktop.common.ui.converters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Converts a Date to a String with a given pattern.
 */
public class DateToStringConverter extends Converter {

	private final DateFormat format;

	/**
	 * Creates a DateToStringConverter.
	 * 
	 * @param pattern
	 *            The pattern to match e.g. MM/dd/yyyy.
	 */
	public DateToStringConverter(String pattern) {
		super(Date.class, String.class);
		format = new SimpleDateFormat(pattern);
	}

	/**
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		if (fromObject == null) {
			return null;
		}
		synchronized (format) {
			return format.format((Date) fromObject);
		}
	}

}
