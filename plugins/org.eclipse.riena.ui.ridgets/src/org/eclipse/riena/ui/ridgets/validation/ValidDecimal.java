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
import java.text.ParseException;
import java.util.Locale;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.osgi.util.NLS;

import org.eclipse.riena.core.util.ArraysUtil;
import org.eclipse.riena.core.util.PropertiesUtils;
import org.eclipse.riena.ui.ridgets.nls.Messages;

/**
 * Checks if a given string could be safely converted to a decimal number, that
 * is a number with a fraction part. <br>
 * <br>
 * 
 * This rule supports partial correctness checking. Partial correct means that
 * we do not treat missing fraction as error, where &quot;missing fraction&quot;
 * means there no fraction digit.
 */
public class ValidDecimal implements IValidator, IExecutableExtension {

	private static final char FRENCH_GROUPING_SEPARATOR = (char) 0xA0;
	private boolean partialCheckSupported;
	private DecimalFormat format;
	private DecimalFormatSymbols symbols;
	private int numberOfFractionDigits;
	private int maxLength;
	private Locale locale;

	/**
	 * Constructs a decimal type check plausibilisation rule with no
	 * partialChecking and the default Locale.
	 * 
	 */
	public ValidDecimal() {
		this(Locale.getDefault());
	}

	/**
	 * Constructs a decimal type check plausibilisation rule with no
	 * partialChecking and the given Locale.
	 * 
	 * @param locale
	 *            the locale.
	 */
	public ValidDecimal(final Locale locale) {
		this(false, locale);
	}

	/**
	 * Constructs a decimal type check plausibilisation rule.
	 * 
	 * @param partialCheckSupported
	 *            <tt>true</tt> if partial checking is required.
	 * @param locale
	 *            the locale.
	 */
	public ValidDecimal(final boolean partialCheckSupported, final Locale locale) {
		this(partialCheckSupported, 15, 2, false, locale);
	}

	/**
	 * Constructs a decimal type check plausibilisation rule.
	 * 
	 * @param partialCheckSupported
	 *            <tt>true</tt> if partial checking is required.
	 * @param numberOfFractionDigits
	 *            number of fraction digits.
	 * @param maxLength
	 *            number of integer digits.
	 * @param withSign
	 *            use sign or not.
	 * @param locale
	 *            the locale.
	 */
	public ValidDecimal(final boolean partialCheckSupported, int numberOfFractionDigits, int maxLength,
			boolean withSign, final Locale locale) {
		Assert.isNotNull(locale);
		this.partialCheckSupported = partialCheckSupported;
		this.numberOfFractionDigits = numberOfFractionDigits;
		this.maxLength = maxLength;
		// TODO: Configure format with withSign?!
		this.locale = locale;
	}

	/**
	 * Validates the given object. If the object is no String instance, a
	 * {@link ValidationFailure} will be thrown. The rule validates if the given
	 * object is a string, a well formed decimal according to the rule's
	 * {@linkplain Locale}.
	 * 
	 * @param object
	 *            the object to validate, must be of type String.
	 */
	public IStatus validate(final Object value) {
		if (value != null) {
			if (!(value instanceof String)) {
				throw new ValidationFailure("ValidCharacters can only validate objects of type String."); //$NON-NLS-1$
			}
			final String string = Utils.removeWhitespace((String) value);

			if (string.length() > 0) {
				final ScanResult scanned = scan(string);
				if (!partialCheckSupported) {
					if (scanned.decimalSeperatorIndex < 0) {
						Character decSep = Character.valueOf(getSymbols().getDecimalSeparator());
						String message = NLS.bind(Messages.ValidDecimal_error_noDecSep, decSep, string);
						return ValidationRuleStatus.error(true, message);
					}
					// test if grouping character is behind decimal separator:
					if (scanned.groupingSeparatorIndex > scanned.decimalSeperatorIndex) {
						Character groupSep = Character.valueOf(getSymbols().getGroupingSeparator());
						Character decSep = Character.valueOf(getSymbols().getDecimalSeparator());
						String message = NLS.bind(Messages.ValidDecimal_error_trailingGroupSep, new Object[] {
								groupSep, decSep, string });
						return ValidationRuleStatus.error(true, message);
					}
				}
				// test if alien character present:
				if (scanned.lastAlienCharIndex > -1) {
					String message = NLS.bind(Messages.ValidDecimal_error_alienChar, Character
							.valueOf(scanned.lastAlienCharacter), string);
					return ValidationRuleStatus.error(true, message);
				}
				try {
					synchronized (getFormat()) {// NumberFormat not threadsafe!
						getFormat().parse(string);
					}
				} catch (final ParseException e) {
					String message = NLS.bind(Messages.ValidDecimal_error_cannotParse, string);
					return ValidationRuleStatus.error(true, message);
				}
			}
		}
		return ValidationRuleStatus.ok();
	}

	/**
	 * Contains the result of the {@link ValidDecimal#scan(String)} method.
	 */
	protected static final class ScanResult {
		/**
		 * The index of the decimal-separator character. If more than one is
		 * present, this will hold the last index.
		 */
		protected int decimalSeperatorIndex = -1;
		/**
		 * The index of the last grouping-separator character found.
		 */
		protected int groupingSeparatorIndex = -1;
		/**
		 * The index of the last minus sign character found.
		 */
		protected int minusSignIndex = -1;

		/**
		 * The last alien character found. Where &quot;alien&quot; means no
		 * digit, minus-sign, decimal-separator or grouping-separator. In case
		 * the grouping-character is <tt>(char)0xa0</tt>, like for the French
		 * locale's NumberFormat, whitespace is not considered alien either.
		 * 
		 * @see Character#isDigit(char)
		 * @see Character#isWhitespace(char)
		 * @see DecimalFormatSymbols
		 */
		protected char lastAlienCharacter;
		/**
		 * The index of the last alien character found. Where &quot;alien&quot;
		 * means no digit, minus-sign, decimal-separator or grouping-separator.
		 * In case the grouping-character is <tt>(char)0xa0</tt>, like for the
		 * French locale's NumberFormat, whitespace is not considered alien
		 * either.
		 * 
		 * @see Character#isDigit(char)
		 * @see Character#isWhitespace(char)
		 * @see DecimalFormatSymbols
		 */
		protected int lastAlienCharIndex = -1;

		private ScanResult() {
			// empty
		}
	}

	/**
	 * Scans the parameter's String instance and returns Information about
	 * indexes of different characters.
	 * 
	 * @param string
	 *            the string
	 * @return a ScanResult instance
	 */
	protected ScanResult scan(final String string) {
		final ScanResult result = new ScanResult();
		final boolean acceptWhitespaceAsGroupingSeperator = Character.isWhitespace(getSymbols().getGroupingSeparator())
				|| getSymbols().getGroupingSeparator() == FRENCH_GROUPING_SEPARATOR;
		final char minusSign = getSymbols().getMinusSign();
		for (int t = 0; t < string.length(); ++t) {
			final char currentChar = string.charAt(t);
			if (currentChar == getSymbols().getDecimalSeparator()) {
				result.decimalSeperatorIndex = t;
			} else if (currentChar == getSymbols().getGroupingSeparator()
					|| (Character.isWhitespace(currentChar) && acceptWhitespaceAsGroupingSeperator)) {
				result.groupingSeparatorIndex = t;
			} else if (currentChar == minusSign) {
				result.minusSignIndex = t;
			} else if (!Character.isDigit(currentChar)) {
				result.lastAlienCharacter = currentChar;
				result.lastAlienCharIndex = t;
			}
		}
		return result;
	}

	/**
	 * Gets this rule's NumberFormat to parse a string. Accessing the format
	 * must be synchronized, as it is not thread safe.
	 * 
	 * @see DecimalFormatSymbols
	 * @return a {@linkplain DecimalFormat} instance
	 */
	protected DecimalFormat getFormat() {
		if (format == null) {
			format = (DecimalFormat) DecimalFormat.getInstance(locale);
			format.setMaximumFractionDigits(numberOfFractionDigits);
			format.setMaximumIntegerDigits(maxLength);
		}
		return format;
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
			symbols = getFormat().getDecimalFormatSymbols();
		}
		return symbols;
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

	private void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * This method is called on a newly constructed extension for validation.
	 * After creating a new instance of {@code ValidDecimal} this method is
	 * called to initialize the instance. The arguments for initialization are
	 * in the parameter {@code data}. Is the data a string the arguments are
	 * separated with ','. The order of the arguments in data is equivalent to
	 * the order of the parameters of one of the constructors.
	 * 
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 * @see org.eclipse.riena.ui.ridgets.validation.ValidDecimal#setLocal(java.lang.String[])
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

		if (data instanceof String) {
			String[] args = PropertiesUtils.asArray(data);
			int localStart = 0;
			if (args.length > 0) {
				if (args[0].equals(Boolean.TRUE.toString())) {
					this.partialCheckSupported = true;
					localStart++;
				} else if (args[0].equals(Boolean.FALSE.toString())) {
					this.partialCheckSupported = false;
					localStart++;
				}
			}
			if ((args.length > 1) && (args[1].length() > 0)) {
				try {
					this.numberOfFractionDigits = Integer.parseInt(args[1]);
					localStart++;
					if ((args.length > 2) && (args[2].length() > 0)) {
						this.maxLength = Integer.parseInt(args[2]);
						localStart++;
						if ((args.length > 3) && (args[3].length() > 0)) {
							if (args[3].equals(Boolean.TRUE.toString())) {
								// TODO: Configure format with withSign?!
								localStart++;
							} else if (args[3].equals(Boolean.FALSE.toString())) {
								// TODO: Configure format with withSign?!
								localStart++;
							}
						}
					}
				} catch (NumberFormatException e1) {
				}
			}
			if (args.length > localStart) {
				String[] localArgs = ArraysUtil.copyRange(args, localStart, args.length);
				setLocal(localArgs);
			}
		}

	}

}
