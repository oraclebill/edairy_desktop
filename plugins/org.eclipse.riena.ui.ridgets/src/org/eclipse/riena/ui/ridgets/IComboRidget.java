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
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * Ridget for a Combo (typically a read-only text widget with drop-down to
 * select from a list of choices).
 */
public interface IComboRidget extends IMarkableRidget, ISelectionObservable {

	/**
	 * The name of the bound read-write <em>selection</em> property.
	 */
	String PROPERTY_SELECTION = "selection"; //$NON-NLS-1$
	/**
	 * The name of the bound <em>text</em> property.
	 * 
	 * @since 2.0
	 */
	String PROPERTY_TEXT = "text"; //$NON-NLS-1$

	/**
	 * Binds the combo to the given model data and specifies which value is
	 * holding the selection.
	 * 
	 * @param optionValues
	 *            An observable list with a list of options.
	 * @param rowClass
	 *            The class of the objects in the list.
	 * @param renderingMethod
	 *            A property of rowClass that returns the value to display for
	 *            each option of the combo box combo box (examples: 'name' ->
	 *            getName(); null for {@code toString()}).
	 * @param selectionValue
	 *            A non-null observable value holding the selection.
	 */
	void bindToModel(IObservableList optionValues, Class<? extends Object> rowClass, String renderingMethod,
			IObservableValue selectionValue);

	/**
	 * Binds the combo to the given model data and specifies which object is
	 * holding the selection inside which property.
	 * 
	 * @param listHolder
	 *            An object holding a list of values (objects).
	 * @param listPropertyName
	 *            The property name to access the list.
	 * @param rowClass
	 *            The class of the objects in the list.
	 * @param renderingMethod
	 *            A property of rowClass that returns the value to display for
	 *            each option of the combo box combo box (examples: 'name' ->
	 *            getName(); null for {@code toString()}).
	 * @param selectionHolder
	 *            A non-null object holding the selection.
	 * @param selectionPropertyName
	 *            The property name to access the selection (non-null).
	 */
	void bindToModel(Object listHolder, String listPropertyName, Class<? extends Object> rowClass,
			String renderingMethod, Object selectionHolder, String selectionPropertyName);

	/**
	 * Returns the option that represents 'no selection'.
	 * <p>
	 * When this option is selected the ridget behaves just as if nothing was
	 * selected. This option could be represented by an empty value or something
	 * like "[Please select...]".
	 * 
	 * @return The option that represents 'no selection'.
	 */
	Object getEmptySelectionItem();

	/**
	 * Return the observable list holding the options.
	 * 
	 * @return the observable list of options.
	 */
	IObservableList getObservableList();

	/**
	 * Return the current selection. Will return null if either nothing or the
	 * "empty selection option" is selected.
	 * 
	 * @return the current selection or null if none.
	 * @see #setEmptySelectionItem(Object)
	 */
	Object getSelection();

	/**
	 * Return the index of the current selection. Will return -1 if either
	 * nothing or the "empty selection option" is selected.
	 * 
	 * @return index of the current selection or -1 if none
	 */
	int getSelectionIndex();

	/**
	 * Return the text value in the combo. Note that this may or may not
	 * correspond to a valid choice from the combo.
	 * <p>
	 * To get the currently selected value use {@link #getSelection()}.
	 * 
	 * @return a String; never null
	 * @since 2.0
	 */
	String getText();

	/**
	 * Return true if the mark-on-selection mode is on. When enabled, an error
	 * marker is shown when the text in the combo does not match any of the
	 * available choices in the combo.
	 * <p>
	 * The default value is false.
	 * 
	 * @since 2.0
	 */
	boolean isMarkSelectionMismatch();

	/**
	 * Sets the option that represents 'no selection'.
	 * <p>
	 * When this option is selected the ridget behaves just as if nothing was
	 * selected. This option could be represented by an value or something like
	 * "[Please select...]".
	 * 
	 * @param emptySelection
	 *            The option that represents 'no selection'.
	 */
	void setEmptySelectionItem(Object emptySelection);

	/**
	 * Enable or disable the mark-on-selection-mismatch mode. When enabled, an
	 * error marker is shown when the text in the combo does not match any of
	 * the available choices in the combo.
	 * <p>
	 * The default value is false.
	 * 
	 * @param mark
	 *            true to enable, false to disable
	 * 
	 * @since 2.0
	 */
	void setMarkSelectionMismatch(boolean mark);

	/**
	 * Sets the converter used when updating from the model to the UI-control.
	 * <p>
	 * Notes: Conversion between model-to-UI and UI-to-model must be
	 * symmetrical; eexample: FooToString and StirngToFoo. Changing the
	 * converters after the ridget is already bound to a model, requires calling
	 * {@link #updateFromModel()} to apply the new converters.
	 * 
	 * @param converter
	 *            The new converter, or {@code null} to revert to the default
	 *            converter.
	 * @since 1.2
	 */
	void setModelToUIControlConverter(IConverter converter);

	/**
	 * Set the current selection to index.
	 * 
	 * @param index
	 *            the 0-based index; -1 to unselect
	 */
	void setSelection(int index);

	/**
	 * Set the current selection to newSelection.
	 * 
	 * @param newSelection
	 */
	void setSelection(Object newSelection);

	/**
	 * Set the text value in the combo.
	 * <p>
	 * Note that this may or may not correspond to a valid choice from the
	 * combo. If text corresponds to a choice in the combo, this choice will be
	 * selected. Otherwise the selection will be cleared.
	 * 
	 * @param text
	 *            a String; never null
	 * @since 2.0
	 */
	void setText(String text);

	/**
	 * Sets the converter used when updating from the UI-control to the model.
	 * <p>
	 * Notes: Conversion between model-to-UI and UI-to-model must be
	 * symmetrical; eexample: FooToString and StirngToFoo. Changing the
	 * converters after the ridget is already bound to a model, requires calling
	 * {@link #updateFromModel()} to apply the new converters.
	 * 
	 * @param converter
	 *            The new converter, or {@code null} to revert to the default
	 *            converter.
	 * @since 1.2
	 */
	void setUIControlToModelConverter(IConverter converter);
}
