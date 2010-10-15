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

import org.eclipse.core.runtime.IStatus;

/**
 * Validator minimum length but it allows empty values
 * 
 * @since 1.2
 * 
 */
public class MinLengthAllowEmpty extends MinLength {

	public MinLengthAllowEmpty() {
		super();
	}

	public MinLengthAllowEmpty(final int minLength) {
		super(minLength);
	}

	/*
	 * First check for empty or null value and return ok. Else call the regular
	 * MinLength Validator (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.riena.ui.ridgets.validation.MinLength#validate(java.lang.
	 * Object)
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

	@Override
	public String toString() {
		return super.toString() + "<allowEmpty"; //$NON-NLS-1$
	}

}
