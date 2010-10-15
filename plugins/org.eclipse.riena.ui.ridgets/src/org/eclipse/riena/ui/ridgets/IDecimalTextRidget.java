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
 * Ridget for decimal text fields.
 * <p>
 * On the view-side we have to use the appropriate control-creation method of
 * the UIControlsFactory (see UIControlsFactory.createTextDecimal() /
 * UIControlFactory.createSegmentedDecimalValueTextField())
 * <p>
 * It is recommended to use String, Double or BigDecimal based-values as the
 * model for this ridget (see {@link #bindToModel(Object, String)}. Model values
 * have to conform to the maximum length, precision and signage settings.
 * <p>
 * The input will be formatted using the decimal and grouping separator of the
 * default locale.
 */
public interface IDecimalTextRidget extends INumericTextRidget {

	/**
	 * Name of the property <i>precision</i>.
	 */
	String PROPERTY_PRECISION = "precision"; //$NON-NLS-1$

	/**
	 * Sets the number of fractional digits of this text field, that is the
	 * number of digits behind the decimal-separator.
	 * <p>
	 * Note that {@link #setText(String)} and {@link #updateFromModel()} will
	 * throw a RuntimeException when the number of fractional digits is
	 * exceeded.
	 * 
	 * @param numberOfFractionDigits
	 *            a value equal or greater than 0
	 */
	void setPrecision(int numberOfFractionDigits);

	/**
	 * Gets the number of fraction digits.
	 * 
	 * @return the number of fraction digits
	 */
	int getPrecision();

}
