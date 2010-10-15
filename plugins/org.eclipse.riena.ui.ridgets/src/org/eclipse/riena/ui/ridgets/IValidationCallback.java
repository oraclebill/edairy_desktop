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
package org.eclipse.riena.ui.ridgets;

import org.eclipse.core.runtime.IStatus;

import org.eclipse.riena.ui.ridgets.validation.IValidationRuleStatus;

/**
 * Callback invoked after a validation.
 * 
 * @deprecated see
 *             {@link org.eclipse.riena.ui.ridgets.validation.IValidationCallback}
 */
public interface IValidationCallback {

	/**
	 * Invoked after a validation was performed.
	 * 
	 * @see IValidationRule
	 * @see IValidationRuleStatus
	 * 
	 * @param status
	 *            The result of the validation.
	 * @deprecated
	 */
	void validationRulesChecked(IStatus status);

}
