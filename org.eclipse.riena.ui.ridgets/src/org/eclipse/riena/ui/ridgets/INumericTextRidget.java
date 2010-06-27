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
 * Ridget for a numeric text field.
 * <p>
 * On the view-side we have to use the appropriate control-creation method of
 * the UIControlsFactory (see UIControlsFactory.createTextNumeric()).
 * <p>
 * The ridget uses strings internally. It can be bound to any model that is
 * supported by the JFace databinding, provided the bounds value can be
 * converted to a string representing a number. Model values have to conform to
 * signage setting of the ridget.
 */
public interface INumericTextRidget extends ITextRidget {

	/**
	 * Property name of the singed property ("signed").
	 */
	String PROPERTY_SIGNED = "signed"; //$NON-NLS-1$

	/**
	 * Property name of the max length property ("maxLength").
	 * 
	 * @since 2.0
	 */
	String PROPERTY_MAXLENGTH = "maxLength"; //$NON-NLS-1$

	/**
	 * @return Indicates whether grouping is used to separate thousands.
	 */
	boolean isGrouping();

	/**
	 * Sets whether grouping is used to separate thousands.
	 * <p>
	 * This will use the grouping separator of the default locale.
	 * 
	 * @param useGrouping
	 *            The new grouping state.
	 */
	void setGrouping(boolean useGrouping);

	/**
	 * @return Indicates whether negative values are allowed. The default value
	 *         is true.
	 */
	boolean isSigned();

	/**
	 * Sets whether negative values are allowed.
	 * <p>
	 * Note that {@link #setText(String)} and {@link #updateFromModel()} will
	 * throw a RuntimeException with negative values after
	 * {@code setSigned(false)} has been called.
	 * 
	 * @param signed
	 *            The new signed state.
	 */
	void setSigned(boolean signed);

	/**
	 * @return true if negative value should be marked
	 */
	boolean isMarkNegative();

	/**
	 * @param mustBeMarked
	 *            whether to mark or not a negative value
	 */
	void setMarkNegative(boolean mustBeMarked);

	/**
	 * Sets the number of allowed decimal digits, that it , the number of digits
	 * before the comma separator. Note that the grouping separators ( i.e. the
	 * dots between "1.034.235.123" ) do not count towards reaching this limit.
	 * <p>
	 * Note that {@link #setText(String)} and {@link #updateFromModel()} will
	 * throw a RuntimeException when the number of decimal digits is exceeded.
	 * 
	 * @param maxLength
	 *            a value greater than 0
	 * @since 2.0
	 */
	void setMaxLength(int maxLength);

	/**
	 * Returns the maximum number of decimal digits (excluding separators and
	 * the minus sign). May be -1 if no limit is set.
	 * 
	 * @return the number of decimal digits
	 * @since 2.0
	 */
	int getMaxLength();
}
