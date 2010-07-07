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

import java.math.BigDecimal;
import java.math.BigInteger;

import com.ibm.icu.text.NumberFormat;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;

/**
 * A factory for converters (implementing interface <code>IConverter</code>) of
 * some type to a string value.
 * 
 * @since 2.0
 */
public final class ToStringConverterFactory {

	private ToStringConverterFactory() {
		super();
	}

	public static IConverter createNumberConverter(Class<?> type, int precision) {
		IConverter result = null;

		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(precision);
		if (BigDecimal.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromBigDecimal(nf);
		} else if (BigInteger.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromBigInteger(nf);
		} else if (Byte.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromByte(nf, false);
		} else if (Double.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromDouble(nf, false);
		} else if (Float.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromFloat(nf, false);
		} else if (Integer.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromInteger(nf, false);
		} else if (Long.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromLong(nf, false);
		} else if (Short.class.isAssignableFrom(type)) {
			result = NumberToStringConverter.fromShort(nf, false);
		}

		return result;
	}
}
