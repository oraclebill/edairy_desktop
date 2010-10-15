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

import org.eclipse.riena.ui.ridgets.IDateTextRidget;

/**
 * Helper class for validation related tasks.
 */
public final class Utils {

	private Utils() {
		// utility class
	}

	/**
	 * Returns a new String, which is a copy of the parameter without the
	 * whitespace.
	 * 
	 * @see Character#isWhitespace(char)
	 * @param string
	 *            the original String
	 * @return a new String which is a copy of the given String without
	 *         whitespace.
	 * @throws some_kind_of_runtime_exception
	 *             if parameter is <tt>null</tt>
	 */
	public static String removeWhitespace(final String string) {
		final StringBuffer sb = new StringBuffer(string.length());
		for (int t = 0; t < string.length(); ++t) {
			final char currentChar = string.charAt(t);
			if (!Character.isWhitespace(currentChar)) {
				sb.append(currentChar);
			}
		}
		return sb.toString();
	}

	/**
	 * checks if a char is empty, where empty means that it consists of
	 * whitespace only.
	 * 
	 * @param string
	 *            a string instance
	 * @return <tt>false</tt> if the string contains any character for which
	 *         {@link Character.isWhitespace(char)} is <tt>false</tt>;
	 * @throws some_kind
	 *             -of_runtime_exception if parameter is <tt>null</tt>
	 */
	// this method will not create a new String instance just for length
	// checking like "String#trim().length() > 0 " would.
	public static boolean isEmpty(final String string) {
		for (int t = 0; t < string.length(); ++t) {
			if (!Character.isWhitespace(string.charAt(t))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if a String is an empty date formatstring like "  .  .  "
	 * 
	 * @param input
	 *            a non-null String
	 * @see IDateTextRidget
	 * @since 1.2
	 */
	public static boolean isEmptyDate(String input) {
		return input.matches("[\\s\\.\\:\\/\\-]+"); //$NON-NLS-1$
	}

}
