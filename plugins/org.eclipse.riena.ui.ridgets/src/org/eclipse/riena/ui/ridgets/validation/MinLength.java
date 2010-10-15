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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.osgi.util.NLS;

import org.eclipse.riena.core.util.PropertiesUtils;
import org.eclipse.riena.ui.ridgets.nls.Messages;

/**
 * 
 */
public class MinLength implements IValidator, IExecutableExtension {

	private int minLength;

	public MinLength() {
	}

	public MinLength(final int minLength) {
		this.minLength = minLength;
	}

	/**
	 * @see org.eclipse.core.databinding.validation.IValidator#validate(java.lang.Object)
	 */
	public IStatus validate(final Object value) {
		if (value == null) {
			if (minLength > 0) {
				String message = NLS.bind(Messages.MinLength_error_nullValue, Integer.valueOf(minLength));
				return ValidationRuleStatus.error(false, message);
			}
			return ValidationRuleStatus.ok();
		}
		if (value instanceof String) {
			final String string = (String) value;
			if (string.length() >= minLength) {
				return ValidationRuleStatus.ok();
			}
			String message = NLS.bind(Messages.MinLength_error_tooShort, string, Integer.valueOf(minLength));
			return ValidationRuleStatus.error(false, message);
		}
		throw new ValidationFailure(getClass().getName() + " can only validate objects of type " //$NON-NLS-1$
				+ String.class.getName());
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(this.getClass().getSimpleName());
		buffer.append("[minLength="); //$NON-NLS-1$
		buffer.append(minLength);
		buffer.append("]"); //$NON-NLS-1$
		return buffer.toString();
	}

	/**
	 * This method is called on a newly constructed extension for validation.
	 * After creating a new instance of {@code MinLength} this method is called
	 * to initialize the instance. The argument for initialization is in the
	 * parameter {@code data}. Is the data a string the argument is the initial
	 * value of {@code minLength}.
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

		if (data instanceof String) {
			String[] args = PropertiesUtils.asArray(data);
			minLength = Integer.parseInt(args[0]);
		}

	}

}
