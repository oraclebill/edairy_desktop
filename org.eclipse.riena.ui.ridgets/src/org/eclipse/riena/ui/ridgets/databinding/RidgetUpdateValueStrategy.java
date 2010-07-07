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

import java.util.GregorianCalendar;

import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;

/**
 * 
 */
public class RidgetUpdateValueStrategy extends UpdateValueStrategy {

	public RidgetUpdateValueStrategy() {
		super();
	}

	public RidgetUpdateValueStrategy(int updatePolicy) {
		super(updatePolicy);
	}

	public RidgetUpdateValueStrategy(boolean provideDefaults, int updatePolicy) {
		super(provideDefaults, updatePolicy);
	}

	/**
	 * @see org.eclipse.core.databinding.UpdateStrategy#createConverter(java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	protected IConverter createConverter(Object fromType, Object toType) {
		// whj: types will not be java.lang.Class when binding to EMF models.
		if (fromType instanceof Class && toType instanceof Class) {
			if (fromType == String.class) {
				if (toType == Double.TYPE) {
					return StringToNumberAllowingNullConverter.toPrimitiveDouble();
				} else if (toType == Float.TYPE) {
					return StringToNumberAllowingNullConverter.toPrimitiveFloat();
				} else if (toType == Long.TYPE) {
					return StringToNumberAllowingNullConverter.toPrimitiveLong();
				} else if (toType == Integer.TYPE) {
					return StringToNumberAllowingNullConverter.toPrimitiveInteger();
				} else if (toType == GregorianCalendar.class) {
					return new StringToGregorianCalendarConverter();
				}
			}
			if (fromType == GregorianCalendar.class) {
				if (toType == String.class) {
					return new GregorianCalendarToStringConverter();
				}
			}
		}
		return super.createConverter(fromType, toType);
	}

}
