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

import org.apache.oro.text.perl.Perl5Util;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.osgi.util.NLS;

import org.eclipse.riena.core.util.PropertiesUtils;
import org.eclipse.riena.ui.ridgets.nls.Messages;

/**
 * Implementation for a regular expression check. If the rule fails it will
 * prevent updating the ridget and model values. The rule will not block invalid
 * input to the widget.
 * <p>
 * Note that the value <tt>null</tt> will be treated as an empty string. The
 * option <tt>i</tt>, <tt>m</tt> and <tt>x</tt>, as featured in the Perl5 native
 * format <quote>[m]/pattern/[i][m][s][x]</quote> are supported through the
 * {@link Option} enumeration.
 * <p>
 * At the moment this class supports Perl5 regular expressions. It is however
 * recommended to stick to common standards between
 * {@linkplain java.util.regex.Pattern java.util.regex} and Perl5 regular
 * expressions, if possible.
 * <p>
 * This validation rule does not support partial correctness checking.
 * <p>
 * 
 * @see org.apache.oro.text.perl.Perl5Util#match(String, String)
 * @see java.util.regex.Pattern
 */
public class ValidExpression implements IValidator, IExecutableExtension {

	/** <code>GERMAN_ZIP</code> */
	public static final String GERMAN_ZIP = "^[0-9]{5}$"; //$NON-NLS-1$

	/**
	 * @see http://de.wikipedia.org/wiki/SWIFT
	 */
	public static final String SWIFT_BIC = "^([a-zA-Z]{6}[a-zA-Z\\d]{2})([a-zA-Z\\d]{3})?$"; //$NON-NLS-1$

	/**
	 * Option postfixes.
	 * 
	 * @see org.apache.oro.text.perl.Perl5Util#match(String, String)
	 * @see java.util.regex.Pattern
	 */
	public static enum Option {
		/** Enables case insensitive matching. */
		CASE_INSENSITIVE('i'),
		/** Treats input as it would consist of multiple lines. */
		MULTIPLE_LINE('m'),
		/** Enables the extended expression syntax with whitespace and comments. */
		ENABLE_EXTENDED_SYNTAX('x');
		private final char symbol;

		private Option(final char symbol) {
			this.symbol = symbol;
		}
	}

	/*
	 * Concurrent access is okay as long as #getMatch() is not used.
	 * 
	 * @see org.apache.oro.text.perl.Perl5Util
	 */
	private final Perl5Util matcher = new Perl5Util();

	private String pattern;
	private final StringBuffer options;

	/**
	 * Constructs a new ValidExpression rule with the given options.
	 */
	public ValidExpression() {
		this("*"); //$NON-NLS-1$
	}

	/**
	 * Constructs a new ValidExpression rule with the given options.
	 * 
	 * @param regex
	 *            the regular expression to check against
	 * @see org.apache.oro.text.perl.Perl5Util#match(String, String)
	 * @see java.util.regex.Pattern#matches(String, CharSequence)
	 * @throws some_kind_of_runtime_exception
	 *             if parameter is <tt>null</tt>, pattern is a String of length
	 *             zero, or pattern is malformed.
	 */
	public ValidExpression(final String pattern, final Option... options) {
		Assert.isNotNull(pattern, "pattern must not be null"); //$NON-NLS-1$
		Assert.isLegal(pattern.length() > 0, "pattern must not be empty"); //$NON-NLS-1$
		this.pattern = pattern;
		this.options = new StringBuffer(4);
		for (final Option option : options) {
			this.options.append(option.symbol);
		}
	}

	/**
	 * Matches the given object against this rule's regular expression.
	 * 
	 * @see org.eclipse.core.databinding.validation.IValidator#validate(java.lang.Object)
	 */
	public IStatus validate(final Object value) {
		if (!(value == null || value instanceof String)) {
			throw new ValidationFailure(getClass().getSimpleName() + " can only validate objects of type " //$NON-NLS-1$
					+ String.class.getName());
		}
		final String string = value == null ? "" : (String) value; //$NON-NLS-1$
		// validates if char is not either whitespace or ignored.
		if (matcher.match("/" + pattern + "/" + options, string)) { //$NON-NLS-1$//$NON-NLS-2$
			return ValidationRuleStatus.ok();
		}
		String message = NLS.bind(Messages.ValidExpression_error_noMatch, string, pattern);
		return ValidationRuleStatus.error(false, message);
	}

	/**
	 * This method is called on a newly constructed extension for validation.
	 * After creating a new instance of {@code ValidExpression} this method is
	 * called to initialize the instance. The argument for initialization is in
	 * the parameter {@code data}. Is the data a string the argument is the
	 * initial value of {@code pattern}.
	 * 
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(org.eclipse.core.runtime.IConfigurationElement,
	 *      java.lang.String, java.lang.Object)
	 */
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {

		if (data instanceof String) {
			String[] args = PropertiesUtils.asArray(data);
			pattern = args[0];
		}

	}

}
