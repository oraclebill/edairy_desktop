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

/**
 * Callback invoked after a validation.
 * 
 * @since 1.2
 */
public interface IValidationCallback {

	/**
	 * Invoked after a validation was performed.
	 * 
	 * @param validationRule
	 *            the validationRule that was checked; never null
	 * @param status
	 *            The result of the validation; never null
	 */
	void validationRuleChecked(IValidator validationRule, IStatus status);

	/**
	 * Invoked after all validations are performed.
	 * 
	 * @param status
	 *            The aggregate result of the validation.
	 */
	void validationResult(IStatus status);
}
