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

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;

import org.eclipse.riena.ui.ridgets.nls.Messages;

/**
 * Validation checking that a String is non-null at has at least one
 * non-whitespace character.
 */
public class NotEmpty implements IValidator {

	public IStatus validate(Object value) {
		if (value instanceof String && !Utils.isEmpty((String) value)) {
			return ValidationRuleStatus.ok();
		}
		return ValidationRuleStatus.error(false, Messages.NotEmpty_error_empty);
	}

}
