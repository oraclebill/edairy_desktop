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
 * Blocking 'maximum length' validation rule.
 * <p>
 * This rule will flag strings that exceed a certaing length as 'not valid' and
 * will block changes if the <b>resulting</b> string exceeds the specified
 * length.
 */
public class MaxLength implements IValidator, IExecutableExtension {

	/**
	 * The maximum length of a valid string (>= 0).
	 */
	protected int maxLength;

	private boolean isBlocking;

	public MaxLength() {
		this(0, true);
	}

	public MaxLength(int length) {
		this(length, true);
	}

	/**
	 * @since 1.2
	 */
	protected MaxLength(int length, boolean isBlocking) {
		this.maxLength = length;
		this.isBlocking = isBlocking;
	}

	public IStatus validate(Object value) {

		if (value == null || maxLength < 0) {
			return ValidationRuleStatus.ok();
		}

		if (value instanceof String) {
			String string = (String) value;
			int length = string.length();

			if (length > maxLength) {
				String message = NLS.bind(Messages.MaxLength_error_tooLong, string, Integer.valueOf(maxLength));
				return ValidationRuleStatus.error(isBlocking, message);
			}
			return ValidationRuleStatus.ok();
		} else {
			throw new ValidationFailure("MaxLength can only validate objects of type String."); //$NON-NLS-1$
		}
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder(this.getClass().getSimpleName());
		buffer.append("[maxLength="); //$NON-NLS-1$
		buffer.append(maxLength);
		buffer.append("]"); //$NON-NLS-1$
		return buffer.toString();
	}

	/**
	 * This method is called on a newly constructed extension for validation.
	 * After creating a new instance of {@code MaxLength} this method is called
	 * to initialize the instance. The argument for initialization is in the
	 * parameter {@code data}. Is the data a string the argument is the initial
	 * value of {@code maxLength}.
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

		if (data instanceof String) {
			String[] args = PropertiesUtils.asArray(data);
			maxLength = Integer.parseInt(args[0]);
		}

	}

}
