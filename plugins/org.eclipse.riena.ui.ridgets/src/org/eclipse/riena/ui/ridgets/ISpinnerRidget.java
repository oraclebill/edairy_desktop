/*******************************************************************************
 * Copyright © 2009 Florian Pirchner and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Florian Pirchner – initial API and implementation (based on other ridgets of compeople AG)
 * compeople AG     - javadoc
 * IBM Corporation  – javadoc; copied from org.eclipse.swt.widgets.Spinner.java 
 * 					  licensed under Eclipse Public License v1.0
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets;

/**
 * Ridget for a spinner field.
 * 
 * @since 1.2
 */
public interface ISpinnerRidget extends ITraverseRidget {

	/**
	 * Property name of the 'digits' property ({@value} ).
	 * 
	 * @see #getDigits()
	 * @see #setDigits(int)
	 */
	String PROPERTY_DIGITS = "digits"; //$NON-NLS-1$

	/**
	 * Property name of the 'text limit' property ({@value} ).
	 * 
	 * @see #getTextLimit()
	 * @see #setTextLimit(int)
	 */
	String PROPERTY_TEXT_LIMIT = "textLimit"; //$NON-NLS-1$

	/**
	 * Returns the maximum number of characters that the uiControl's text field
	 * is capable of holding to be the argument.
	 * <p>
	 * It is greater than zero.
	 * 
	 * @return the textLimit an integer zero or greater
	 */
	int getTextLimit();

	/**
	 * Sets the maximum number of characters that the uiControl's text field is
	 * capable of holding to be the argument.
	 * 
	 * <h3>Invalid values</h3> <li><b>textLimit &lt;= 0:</b> The set operation
	 * will be ignored.</li>
	 * 
	 * <h3>Property value adjustments</h3> <li><b>textLimit &lt; maximum number
	 * of characters allowed for the control:</b> The textLimit will be set to
	 * the controls text limit. If using swt this will be different for
	 * different platforms.</li> <li><b>textLimit &lt; digits:</b> The digits
	 * will be set to textLimit.</li>
	 * 
	 * @param textLimit
	 *            (an integer zero or greater)
	 */
	void setTextLimit(int textLimit);

	/**
	 * Returns the number of decimal places used by the uiControl.
	 * <p>
	 * It is zero or greater.
	 * 
	 * @return the digits (an integer zero or greater)
	 */
	int getDigits();

	/**
	 * Sets the number of decimal places used by the uiControl.
	 * <p>
	 * The digit setting is used to allow for floating point values in the
	 * uiControl. For example, to set the selection to a floating point value of
	 * 1.37 call setDigits() with a value of 2 and setSelection() with a value
	 * of 137. Similarly, if getDigits() has a value of 2 and getSelection()
	 * returns 137 this should be interpreted as 1.37.
	 * <p>
	 * <h3>Invalid values</h3>
	 * <li><b>digits &gt; textLimit:</b> The set operation will be ignored.</li>
	 * 
	 * <h3>Property value adjustments</h3>
	 * <li><b>digits &lt; 0:</b> Zero will be used.</li>
	 * 
	 * @param digits
	 *            an integer; zero or greater
	 */
	void setDigits(int digits);
}
