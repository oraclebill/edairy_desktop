package com.agritrace.edairy.desktop.common.ui.converters;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Converts a Date to a String with a given pattern.
 */
public class NumberToStringConverter extends Converter {

	private Object fromClass;

	/**
	 * Creates a DateToStringConverter.
	 * 
	 * @param pattern
	 *            The pattern to match e.g. MM/dd/yyyy.
	 */
	public NumberToStringConverter(Object fromClass) {
		super(fromClass, String.class);
		this.fromClass = fromClass;

	}

	/**
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		if (fromObject == null) {
			return null;
		}
		if (this.fromClass == Double.class)
		{
			return (((Double)fromObject)).toString();
		}
		return null;
	}

}
