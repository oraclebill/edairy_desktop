/*******************************************************************************
 * Copyright (c) 2009 Florian Pirchner and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Florian Pirchner – initial API and implementation (based on other ridgets of 
 *                    compeople AG)
 * compeople AG     - adjustments for Riena v1.2
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets;

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * The link ridget displays text (String) that can be clicked. This text is
 * defined by two properties:
 * <ul>
 * <li>text - for example <i><b>Riena project home</b></i></li>
 * <li>link - for example <i><b>www.eclipse.org/riena</b></i></li>
 * </ul>
 * This ridget automatically merges the link and the text using an
 * {@link IConverter} to get an appropriate working string for the UI control --
 * see also {@link #setMergeConverter(IConverter)}
 * 
 * @since 1.2
 */
public interface ILinkRidget extends IValueRidget, ISelectionObservable {

	/**
	 * Property name of the text property ({@value} ).
	 * 
	 * @see #getText()
	 * @see #setText(String)
	 */
	String PROPERTY_TEXT = "text"; //$NON-NLS-1$

	/**
	 * Return the text displayed in this ridget.
	 * 
	 * @return the text; may be null
	 */
	String getText();

	/**
	 * Set the text to display in this ridget.
	 * 
	 * @param text
	 *            a String that conforms to the constraints dictated by the
	 *            underlying widget (for example an SWT Link). May be null.
	 */
	void setText(String text);

	/**
	 * Using the given text and link, construct a string that can be displayed
	 * by this ridget.
	 * <p>
	 * Implementation note: an implementation will take the given {@code text}
	 * and {@code link} values and construct a String that conforms to the
	 * constraints dictated by the underlying widget (for example an SWT Link).
	 * Use {@link #getText()} to access the result of this operation.
	 * 
	 * @param text
	 *            a String, may be null.
	 * @param link
	 *            a String; may be null; not necessarily a valid url.
	 */
	void setText(String text, String link);
}
