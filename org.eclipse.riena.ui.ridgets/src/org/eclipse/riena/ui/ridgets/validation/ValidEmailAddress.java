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

import org.apache.commons.validator.GenericValidator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.osgi.util.NLS;

import org.eclipse.riena.ui.ridgets.nls.Messages;

/**
 * Implementation for a email address validation. This rule accepts any String
 * which is either <tt>null</tt>, empty, all whitespace or a valid email
 * address.
 * <p>
 * If the rule fails it will prevent updating the ridget and model values. The
 * rule will not block invalid input to the widget.
 */
public class ValidEmailAddress implements IValidator {

	public IStatus validate(final Object value) {
		if (value == null) {
			return ValidationRuleStatus.ok();
		}
		// note: null instanceof String == false
		if (!(value instanceof String)) {
			throw new ValidationFailure(getClass().getSimpleName() + " can only validate objects of type " //$NON-NLS-1$
					+ String.class.getName());
		}
		final String toBeChecked = (String) value;
		if (toBeChecked.length() == 0 || GenericValidator.isEmail(toBeChecked)) {
			return ValidationRuleStatus.ok();
		}
		String message = NLS.bind(Messages.ValidEmailAddress_error_notValid, toBeChecked);
		return ValidationRuleStatus.error(false, message);
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(this.getClass().getSimpleName());
		return buffer.toString();
	}

}
