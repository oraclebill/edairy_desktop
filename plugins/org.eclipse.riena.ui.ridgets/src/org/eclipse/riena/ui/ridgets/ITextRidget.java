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

import org.eclipse.core.databinding.conversion.IConverter;

/**
 * Ridget for a text field.
 */
public interface ITextRidget extends IEditableRidget, IMarkableRidget {

	/**
	 * Property name of the text property.
	 * 
	 * @see #getText()
	 * @see #setText(String)
	 */
	String PROPERTY_TEXT = "text"; //$NON-NLS-1$

	/**
	 * Returns current text of the text field if directWriting is set to true.
	 * If directWriting is set to false the last text that was submitted by
	 * pressing enter or by moving the focus out of the text field is returned.
	 * 
	 * @return The text.
	 */
	String getText();

	/**
	 * Indicates when a ValueChangeEvent should be fired to update the model. If
	 * true an update will be triggered every time a key is typed. If false the
	 * model will be updated only when the text is submitted by pressing enter
	 * or by moving the focus out of the text field.
	 * 
	 * @return The directWriting setting.
	 */
	boolean isDirectWriting();

	/**
	 * Sets when a ValueChangeEvent should be fired to update the model. If true
	 * an update will be triggered every time a key is typed. If false the model
	 * will be updated only when the text is submitted by pressing enter or by
	 * moving the focus out of the text field.
	 * 
	 * @param directWriting
	 *            The new direct writing setting.
	 */
	void setDirectWriting(boolean directWriting);

	/**
	 * Sets the converter to be used between the user's input and the
	 * UI-control.
	 * <p>
	 * When set, this String-to-String converter will intercept the user's input
	 * and convert it before it is shown in the UI-control.
	 * <p>
	 * The default value is null.
	 * 
	 * @param converter
	 *            a String-to-String converter, or null to stop converting
	 * 
	 * @since 2.0
	 */
	void setInputToUIControlConverter(IConverter converter);

	/**
	 * Sets the text of the text field. Fires a ValueChangeEvent to update the
	 * model - even if directWriting is set to false. This behavior is different
	 * from getUIControl().setText(text) which will cause the model to be
	 * updated depending on the directWriting setting.
	 * 
	 * @see #setDirectWriting(boolean)
	 * @param text
	 *            The new text value. Passing a null value will 'clear' the text
	 *            what that means is implementation specific.
	 */
	void setText(String text);

}
