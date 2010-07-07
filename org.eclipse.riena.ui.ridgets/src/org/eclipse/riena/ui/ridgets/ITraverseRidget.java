/*******************************************************************************
 * Copyright © 2009 Florian Pirchner and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Florian Pirchner – initial API and implementation (based on other ridgets of 
 *                    compeople AG)
 * compeople AG     - adjustments for Riena v1.2
 * IBM Corporation  – javadoc; copied from org.eclipse.swt.widgets.Spinner.java and Slider.java 
 * 					  licensed under Eclipse Public License v1.0
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets;

/**
 * This interface is an abstraction for all traverse ridgets.
 * <p>
 * Such ridgets typically store a value that can be manipulated through some
 * mechanism like: buttons or a slider-bar or a scrollbar. It it possible to
 * specify a minimum and maximum allowed range for this value.
 * <p>
 * Traverse ridgets also support tooltips with a replacable value.
 * <p>
 * Please refer to the implementation class for additional information on
 * allowed value ranges and automatic value adjustments.
 * 
 * @since 1.2
 */
public interface ITraverseRidget extends IEditableRidget, IMarkableRidget {

	/**
	 * This placeholder can be used in tooltips to designate the actual value.
	 * <p>
	 * If a toolTipText is set, which contains the {@value #VALUE_PATTERN}, this
	 * is replaced by the current value of this ridget each time the value
	 * changes. Example: "Value is [VALUE]" creates the tooltip "Value is 7"
	 * <p>
	 * You can reset the pattern mode, by setting a toolTipText which does not
	 * contain this pattern. Example: {@code null} or a String without
	 * {@value #VALUE_PATTERN} resets the pattern and no replacements are
	 * processed anymore.</li>
	 * <p>
	 * Note: setting the currently used tooltip "Value is 7" does not disable
	 * the pattern mode. So on changing the value to 6, the tooltip will be
	 * "Value is 6".
	 */
	String VALUE_PATTERN = "[VALUE]"; //$NON-NLS-1$

	/**
	 * Property name of the 'value' property ({@value} ).
	 * 
	 * @see #getValue()
	 * @see #setValue(int)
	 */
	String PROPERTY_VALUE = "value"; //$NON-NLS-1$

	/**
	 * Property name of the 'page increment' property ({@value} ).
	 * 
	 * @see #getPageIncrement()
	 * @see #setPageIncrement(int)
	 */
	String PROPERTY_PAGE_INCREMENT = "pageIncrement"; //$NON-NLS-1$

	/**
	 * Property name of the 'increment' property ({@value} ).
	 * 
	 * @see #getIncrement()
	 * @see #setIncrement(int)
	 */
	String PROPERTY_INCREMENT = "increment"; //$NON-NLS-1$

	/**
	 * Property name of the 'maximum' property ({@value} ).
	 * 
	 * @see #getMaximum()
	 * @see #setMaximum(int)
	 */
	String PROPERTY_MAXIMUM = "maximum"; //$NON-NLS-1$

	/**
	 * Property name of the 'minimum' property ({@value} ).
	 * 
	 * @see #getMinimum()
	 * @see #setMinimum(int)
	 */
	String PROPERTY_MINIMUM = "minimum"; //$NON-NLS-1$

	/**
	 * Add a listener to call back. The listener is notified, if the selection
	 * of the ridget changes.
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param listener
	 *            a non-null action listener.
	 */
	void addListener(IActionListener listener);

	/**
	 * Remove a listener.
	 * 
	 * @param listener
	 *            the action listener.
	 */
	void removeListener(IActionListener listener);

	/**
	 * Sets the value, which is the ridget's selection.
	 * <p>
	 * It has to be zero or greater and in the range of minimum and maximum.
	 * 
	 * @param value
	 *            the new value
	 */
	void setValue(int value);

	/**
	 * Returns the 'selection', which is the ridget's value.
	 * <p>
	 * It is greater / equal zero.
	 * 
	 * @return the value.
	 */
	int getValue();

	/**
	 * Sets the amount that the ridget's value will be modified by when the
	 * up/down (or right/left) arrows are pressed.
	 * 
	 * @param increment
	 *            the new increment (must be greater than zero.)
	 */
	void setIncrement(int increment);

	/**
	 * Returns the amount that the ridget's value will be modified by when the
	 * up/down (or right/left) arrows are pressed.
	 * <p>
	 * It is greater than zero.
	 * 
	 * @return the increment.
	 */
	int getIncrement();

	/**
	 * Returns the maximum value which the ridget will allow.
	 * <p>
	 * It is zero or greater.
	 * 
	 * @return the maximum.
	 */
	int getMaximum();

	/**
	 * Sets the maximum value which the ridget will allow.
	 * <p>
	 * It has to be equal or greater than zero.
	 * 
	 * @param maximum
	 *            the maximum.
	 */
	void setMaximum(int maximum);

	/**
	 * Returns the minimum value which the ridget will allow.
	 * <p>
	 * It is zero or greater.
	 * 
	 * @return the minimum.
	 */
	int getMinimum();

	/**
	 * Sets the minimum value which the ridget will allow.
	 * <p>
	 * It has to be equal or greater than zero.
	 * 
	 * @param minimum
	 *            the minimum value.
	 */
	void setMinimum(int minimum);

	/**
	 * Returns the amount that the ridget's value will be modified by when the
	 * page increment/decrement areas are selected.
	 * <p>
	 * It is greater than zero.
	 * 
	 * @return the pageIncrement.
	 */
	int getPageIncrement();

	/**
	 * Sets the amount that the ridget's value will be modified by when the page
	 * increment/decrement areas are selected.
	 * 
	 * @param pageIncrement
	 *            the page increment (must be greater than zero)
	 */
	void setPageIncrement(int pageIncrement);

	/**
	 * Triggers the listener of the ridget manually. Should only be used in
	 * Controller Tests.
	 * 
	 * @since 2.0
	 */
	void triggerListener();

}
