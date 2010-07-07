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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.riena.core.util.ArraysUtil;
import org.eclipse.riena.core.util.PropertiesUtils;

/**
 * 
 */
public class MaxNumberLength extends MaxLength {

	private DecimalFormatSymbols symbols;
	private Locale locale;

	/**
	 * Creates a MexLength rule for numbers.
	 */
	public MaxNumberLength() {
		this(0, Locale.getDefault());
	}

	/**
	 * Creates a MexLength rule for numbers.
	 * 
	 * @param length
	 *            The maximum number of characters excluding a leading minus
	 *            sign.
	 */
	public MaxNumberLength(final int length) {
		this(length, Locale.getDefault());
	}

	/**
	 * Creates a MexLength rule for numbers.
	 * 
	 * @param length
	 *            The maximum number of characters excluding a leading minus
	 *            sign.
	 */
	public MaxNumberLength(final int length, final Locale locale) {
		super(length);
		this.locale = locale;
	}

	/**
	 * @see org.eclipse.riena.ui.internal.ridgets.validation.MaxLength#validate(java.lang.Object)
	 */
	@Override
	public IStatus validate(final Object value) {
		if (value == null) {
			return ValidationRuleStatus.ok();
		}
		if (value instanceof String) {
			String string = removeWhitespaceAndGroupingCharacter((String) value);
			if (string.length() > 0) {
				if (string.charAt(0) == getSymbols().getMinusSign()) {
					string = string.substring(1);
				} else if (string.charAt(string.length() - 1) == getSymbols().getMinusSign()) {
					// for Arab locales
					string = string.substring(0, string.length() - 1);
				}
			}
			return super.validate(string);
		}
		throw new ValidationFailure(getClass().getName() + " can only validate objects of type String."); //$NON-NLS-1$
	}

	// TODO: move this and the copy in ValidDecimal to a common utility class
	private String removeWhitespaceAndGroupingCharacter(final String string) {
		final StringBuffer sb = new StringBuffer(string.length());
		for (int t = 0; t < string.length(); ++t) {
			final char currentChar = string.charAt(t);
			if (!(Character.isWhitespace(currentChar) || currentChar == getSymbols().getGroupingSeparator())) {
				sb.append(currentChar);
			}
		}
		return sb.toString();
	}

	/**
	 * This method is called on a newly constructed extension for validation.
	 * After creating a new instance of {@code ValidInteger} this method is
	 * called to initialize the instance. The argument for initialization are in
	 * the parameter {@code data}. Is the data a string the arguments are
	 * separated with ','. The order of the arguments in data is equivalent to
	 * the order of the parameters of one of the constructors.<br>
	 * If data has more than one argument. The last arguments are used to set
	 * the Local for this validator.
	 * 
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 * @see org.eclipse.riena.ui.ridgets.validation.ValidDecimal#setLocal(java.lang.String[])
	 */
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

		if (data instanceof String) {
			String[] args = PropertiesUtils.asArray(data);
			int localStart = 0;
			if (args.length > 0) {
				this.maxLength = Integer.parseInt(args[0]);
				localStart++;
			}
			if (args.length > localStart) {
				String[] localArgs = ArraysUtil.copyRange(args, localStart, args.length);
				setLocal(localArgs);
			}
		}

	}

	/**
	 * Creates and sets the Local for this validator.
	 * 
	 * @param localArgs
	 *            language, country, variant
	 */
	protected void setLocal(String[] localArgs) {
		if (localArgs.length > 0) {
			String language = localArgs[0];
			String country = ""; //$NON-NLS-1$
			String variant = ""; //$NON-NLS-1$
			if (localArgs.length > 1) {
				country = localArgs[1];
			}
			if (localArgs.length > 2) {
				variant = localArgs[2];
			}
			setLocale(new Locale(language, country, variant));
		}

	}

	/**
	 * Gets the s DecimalFormatSymbols of this rule's {@link #format}. Changes
	 * on the symbols will change the rule's format accordingly. As
	 * DecimalFormat is not thread safe, changes to the symbols must be properly
	 * synchronized with accessing the format.
	 * 
	 * @see #getFormat()
	 */
	protected DecimalFormatSymbols getSymbols() {
		if (symbols == null) {
			DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance(locale);
			symbols = format.getDecimalFormatSymbols();
		}
		return symbols;
	}

	private void setLocale(Locale locale) {
		this.locale = locale;
	}

}
