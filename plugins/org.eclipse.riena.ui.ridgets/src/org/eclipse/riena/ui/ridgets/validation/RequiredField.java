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
import org.eclipse.core.runtime.IStatus;

import org.eclipse.riena.ui.ridgets.nls.Messages;

/**
 * Implementation for a required field validation. This rule accepts any String
 * which is not either <tt>null</tt>, empty or all whitespace including ignored
 * characters.
 */
public class RequiredField implements IValidator {

	private String ignoreCharacters = ""; //$NON-NLS-1$
	private char[] sortedIgnoreCharacters = new char[0];

	/**
	 * @return the ignoreCharacters.
	 */
	public String getIgnoreCharacters() {
		return ignoreCharacters;
	}

	/**
	 * Specifies a set of characters which have to be ignored when rule is going
	 * to be checked. Example: a date text field contains initially blanks and
	 * separator characters. So checking the contents only for empty string is
	 * not sufficient, blanks and separator have to be ignored.
	 * 
	 * @param ignoreCharacters
	 *            The ignoreCharacters to set.
	 */
	public void setIgnoreCharacters(final String ignoreCharacters) {
		this.ignoreCharacters = ignoreCharacters;
		// sort to enable binary search on ignore characters.
		// to make the getter and setter returns the same value
		// this is done on a copy
		sortedIgnoreCharacters = ignoreCharacters == null ? new char[0] : ignoreCharacters.toCharArray();
		Arrays.sort(sortedIgnoreCharacters);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.databinding.validation.IValidator#validate(java.lang
	 * .Object)
	 */
	public IStatus validate(final Object value) {
		if (value == null) {
			return ValidationRuleStatus.error(true, Messages.RequiredField_error_nullValue);
		}
		if (!(value instanceof String)) {
			throw new ValidationFailure(getClass().getSimpleName() + " can only validate objects of type " //$NON-NLS-1$
					+ String.class.getName());
		}
		final String toBeChecked = (String) value;
		// validates if char is not either whitespace or ignored.
		for (int t = 0; t < toBeChecked.length(); ++t) {
			final char currentChar = toBeChecked.charAt(t);
			if (!Character.isWhitespace(currentChar) && Arrays.binarySearch(sortedIgnoreCharacters, currentChar) < 0) {
				return ValidationRuleStatus.ok();
			}
		}
		return ValidationRuleStatus.error(false, Messages.RequiredField_error_blankValue);
	}
}
