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
 * compeople AG     - javadoc
 * IBM Corporation  – javadoc; copied from org.eclipse.swt.widgets.Slider.java 
 * 					  licensed under Eclipse Public License v1.0
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets;

/**
 * Ridget for a slider field.
 * <p>
 * <b>Note:</b> The behavior of this ridget differs from the
 * {@link ITraverseRidget}, because the thumb changes the maximum <-> value
 * relation. Refer to the implementation class for specific information on
 * allowed value ranges and automatic value adjustments.
 * 
 * @since 1.2
 */
public interface ISliderRidget extends ITraverseRidget {

	/**
	 * Property name of the 'thumb' property ({@value} ).
	 * 
	 * @see #getThumb()
	 * @see #setThumb(int)
	 */
	String PROPERTY_THUMB = "thumb"; //$NON-NLS-1$

	/**
	 * Returns the size of the ridget's thumb relative to the difference between
	 * its maximum and minimum values.
	 * <p>
	 * It is greater than zero.
	 */
	int getThumb();

	/**
	 * Sets the size of the ridget's thumb relative to the difference between
	 * its maximum and minimum values.
	 * 
	 * @param thumb
	 *            the new thumb value; 1 &lt;= thumb &lt;= maximum - minimum
	 */
	void setThumb(int thumb);
}
