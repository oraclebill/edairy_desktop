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

/**
 * Ridget for a date text field.
 * <p>
 * Input must conform to the formatting pattern given via
 * {@link #setFormat(String)}.
 */
public interface IDateTextRidget extends ITextRidget {

	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_DDMMYYYY = "dd.MM.yyyy"; //$NON-NLS-1$
	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_DDMMYY = "dd.MM.yy"; //$NON-NLS-1$
	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_DDMM = "dd.MM"; //$NON-NLS-1$
	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_MMYYYY = "MM.yyyy"; //$NON-NLS-1$
	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_YYYY = "yyyy"; //$NON-NLS-1$
	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_HHMMSS = "HH:mm:ss"; //$NON-NLS-1$
	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_HHMM = "HH:mm"; //$NON-NLS-1$
	/** Formatting pattern for {@value} . See {@link #setFormat(String)}. */
	String FORMAT_DDMMYYYYHHMM = "dd.MM.yyyy HH:mm"; //$NON-NLS-1$

	/**
	 * Sets the date pattern and adds validators and converters to convert to a
	 * java.util.Date in the model.
	 * <p>
	 * In general, supported patterns consist of several segments of 1-n digits
	 * followed by zero or more groups that either contain a single separator or
	 * another segment, i.e.:
	 * 
	 * <pre>
	 * segment(separator,segment)*
	 * </pre>
	 * 
	 * The following characters are treated as digits: {@code d, M, y, H, m, s}.
	 * <p>
	 * The following characters are treated as separators: {@code ., :, /, -,
	 * ' ' (space)}.
	 * <p>
	 * Separators are copied verbatim into the output string and cannot be
	 * modified. Digits within a segment will be right aligned.
	 * <p>
	 * Examples for patterns are: {@code dd.MM.yyyy} for strings like
	 * '27.02.1980' or {@code HH:mm} for strings like '13:55'
	 * 
	 * @param datePattern
	 *            The date pattern; never null
	 */
	void setFormat(String datePattern);

}
