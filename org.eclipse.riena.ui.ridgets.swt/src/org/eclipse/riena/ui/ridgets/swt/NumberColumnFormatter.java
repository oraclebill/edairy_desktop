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

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * A column formatter for numbers (convenience class).
 * 
 * @since 2.0
 */
public abstract class NumberColumnFormatter extends ColumnFormatter {

	private final IConverter converter;

	/**
	 * A number formatter for the given type and precision.
	 * 
	 * @param type
	 *            the type.
	 * @param precision
	 *            the precision.
	 */
	public NumberColumnFormatter(Class<?> type, int precision) {
		super();
		converter = ToStringConverterFactory.createNumberConverter(type, precision);
	}

	@Override
	public String getText(Object element) {
		String result = null;
		Number number = getValue(element);
		if (number != null) {
			result = (String) converter.convert(number);
		}
		return result;
	}

	/**
	 * Subclasses must provide code to extract a number from the given row
	 * element.
	 * 
	 * @param element
	 *            the row element.
	 * @return a number or null.
	 */
	protected abstract Number getValue(Object element);
}
