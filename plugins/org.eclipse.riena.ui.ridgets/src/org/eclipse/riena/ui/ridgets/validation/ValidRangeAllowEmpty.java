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
package org.eclipse.riena.ui.ridgets.validation;

import java.util.Locale;

import org.eclipse.core.runtime.IStatus;

/**
 * Implementation of ValidRange that response to empty value with no error.
 * Empty value can be null or empty string.
 * 
 * @since 2.0
 */
public class ValidRangeAllowEmpty extends ValidRange {

	/**
	 * @see ValidRange()
	 */
	public ValidRangeAllowEmpty() {
		super();
	}

	/**
	 * @see ValidRange(Number min, Number max)
	 */
	public ValidRangeAllowEmpty(Number min, Number max) {
		super(min, max);
	}

	/*
	 * @see ValidRange(Number min, Number max, Locale locale)d
	 */
	public ValidRangeAllowEmpty(Number min, Number max, Locale locale) {
		super(min, max, locale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.ridgets.validation.ValidRange#validate(java.lang
	 * .Object)
	 */
	@Override
	public IStatus validate(Object value) {
		if (value == null) {
			return ValidationRuleStatus.ok();
		}
		if (value instanceof String) {
			if (((String) value).length() == 0) {
				return ValidationRuleStatus.ok();
			}
		}
		return super.validate(value);
	}
}
