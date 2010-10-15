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

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;

/**
 * Converts String to numbers.
 * 
 * @see org.eclipse.core.databinding.conversion.StringToNumberConverter
 */
public class StringToNumberAllowingNullConverter extends Converter {

	public static IConverter toPrimitiveDouble() {
		return new StringToNumberAllowingNullConverter(Double.TYPE, StringToNumberConverter.toDouble(true));
	}

	public static IConverter toPrimitiveFloat() {
		return new StringToNumberAllowingNullConverter(Float.TYPE, StringToNumberConverter.toFloat(true));
	}

	public static IConverter toPrimitiveLong() {
		return new StringToNumberAllowingNullConverter(Long.TYPE, StringToNumberConverter.toLong(true));
	}

	public static IConverter toPrimitiveInteger() {
		return new StringToNumberAllowingNullConverter(Integer.TYPE, StringToNumberConverter.toInteger(true));
	}

	private IConverter delegate;

	protected StringToNumberAllowingNullConverter(Object toType, IConverter delegate) {
		super(String.class, toType);
		this.delegate = delegate;
	}

	/**
	 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
	 */
	public Object convert(Object fromObject) {
		if ("".equals(fromObject) || fromObject == null) { //$NON-NLS-1$
			if (delegate.getToType() == Double.TYPE) {
				return 0.0;
			} else if (delegate.getToType() == Float.TYPE) {
				return 0.0f;
			} else if (delegate.getToType() == Long.TYPE) {
				return 0L;
			} else if (delegate.getToType() == Integer.TYPE) {
				return 0;
			}
		}
		return delegate.convert(fromObject);
	}

}
