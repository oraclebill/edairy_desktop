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

import java.util.Arrays;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.osgi.util.NLS;

import org.eclipse.riena.core.util.PropertiesUtils;
import org.eclipse.riena.ui.ridgets.nls.Messages;

/**
 * Implementation for a plausibility rule which checks if the typed character is
 * contained in a set of allowed characters. <br>
 */
public class ValidCharacters implements IValidator, IExecutableExtension {

	/** <code>VALID_NUMBERS</code> defines 0-9 */
	public static final String VALID_NUMBERS = "0123456789"; //$NON-NLS-1$
	/** <code>VALID_UPPERCASE</code> defines A-Z */
	public static final String VALID_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //$NON-NLS-1$
	/** <code>VALID_LOWERCASE</code> defines a-z */
	public static final String VALID_LOWERCASE = "abcdefghijklmnopqrstuvwxyz"; //$NON-NLS-1$
	/** <code>VALID_LETTER</code> defines A-Za-z */
	public static final String VALID_LETTER = VALID_UPPERCASE + VALID_LOWERCASE;
	/** <code>VALID_ALPHANUMERIC</code> defines A-Za-z0-9 */
	public static final String VALID_ALPHANUMERIC = VALID_LETTER + VALID_NUMBERS;

	private String allowedChars;
	private char[] allowedCharsSorted = new char[0];

	/**
	 * Constructs a valid characters check plausibilisation rule
	 */
	public ValidCharacters() {
		setAllowedChars(null);
	}

	/**
	 * Constructs a valid characters check plausibilisation rule
	 * 
	 * @param chars
	 */
	public ValidCharacters(final String allowedChars) {
		setAllowedChars(allowedChars);
	}

	/**
	 * @see org.eclipse.core.databinding.validation.IValidator#validate(java.lang.Object)
	 */
	public IStatus validate(final Object value) {
		if (value != null) {
			if (!(value instanceof String)) {
				throw new ValidationFailure("ValidCharacters can only validate objects of type String."); //$NON-NLS-1$
			}
			final String string = (String) value;
			if (allowedChars != null) {
				for (int t = 0; t < string.length(); ++t) {
					final char currentChar = string.charAt(t);
					if (Arrays.binarySearch(allowedCharsSorted, currentChar) < 0) {
						String message = NLS.bind(Messages.ValidCharacters_error_invalidChar, Character
								.valueOf(currentChar), string);
						return ValidationRuleStatus.error(true, message);
					}
				}
			}
		}
		return ValidationRuleStatus.ok();
	}

	/**
	 * @return the allowedChars.
	 */
	public String getAllowedChars() {
		return allowedChars;
	}

	/**
	 * @param allowedChars
	 *            The allowedChars to set.
	 */
	public void setAllowedChars(final String allowedChars) {
		this.allowedChars = allowedChars;
		// operate on a sorted copy, so getter returns the same value as set.
		allowedCharsSorted = allowedChars == null ? new char[0] : allowedChars.toCharArray();
		Arrays.sort(allowedCharsSorted);
	}

	/**
	 * This method is called on a newly constructed extension for validation.
	 * After creating a new instance of {@code ValidCharacters} this method is
	 * called to initialize the instance. The argument for initialization is in
	 * the parameter {@code data}. Is the data a string the argument is the
	 * initial value of {@code allowedChars}.
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

		if (data instanceof String) {
			String[] args = PropertiesUtils.asArray(data);
			setAllowedChars(args[0]);
		}

	}

}
