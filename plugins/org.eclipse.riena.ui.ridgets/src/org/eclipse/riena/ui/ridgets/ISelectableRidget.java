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

import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;

/**
 * A Ridget that supports single and multiple selection.
 */
public interface ISelectableRidget extends IMarkableRidget, ISelectionObservable {

	/**
	 * Property name of the selection property.
	 * <p>
	 * This property will be fired every time the selection changes. If the
	 * selection type is single selection, the selection will contain zero or
	 * one values. If the selection type is multiple selection, the selection
	 * will contain zero or more values. In both cases the old and new value of
	 * the PropertyChangeEvent are collections.
	 */
	String PROPERTY_SELECTION = "selection"; //$NON-NLS-1$

	/**
	 * The selection type.
	 */
	enum SelectionType {
		/** no selection */
		NONE,
		/** single selection */
		SINGLE,
		/** multiple selection */
		MULTI
	}

	/**
	 * @return The selection type.
	 */
	SelectionType getSelectionType();

	/**
	 * Sets the selection type.
	 * 
	 * @param selectionType
	 *            The new selection type. Never null.
	 * @throws RuntimeException
	 *             (a) if the given selectionType is not supported by the
	 *             ridget; (b) if selectionType is null
	 */
	void setSelectionType(SelectionType selectionType);

	/**
	 * Returns the value that holds the selection of this Ridget.
	 * 
	 * @return An observable value that holds the single selection of this
	 *         ridget. If the selection type is set to multiple selection the
	 *         single selection will contain one of the selected values.
	 */
	IObservableValue getSingleSelectionObservable();

	/**
	 * Binds an observable value to the single selection.
	 * 
	 * @param selectionValue
	 *            The observable holding the single selection.
	 * @see #getSingleSelectionObservable()
	 */
	void bindSingleSelectionToModel(IObservableValue selectionValue);

	/**
	 * Binds a property of selectionHolder to the single selection of this
	 * ridget.
	 * 
	 * @param selectionHolder
	 *            An object holding the single selection.
	 * @param selectionPropertyName
	 *            The name of the single selection property.
	 * @see #getSingleSelectionObservable()
	 */
	void bindSingleSelectionToModel(Object selectionHolder, String selectionPropertyName);

	/**
	 * Updates the single selection from the single selection model.
	 * 
	 * @see #bindSingleSelectionToModel(IObservableValue)
	 * @see #bindSingleSelectionToModel(Object, String)
	 */
	void updateSingleSelectionFromModel();

	/**
	 * Returns the list that holds the selection(s) of this Ridget.
	 * 
	 * @return An observable list that holds the multiple selection of this
	 *         ridget. If the selection type is set to single selection the
	 *         multiple selection will be either empty or contain the single
	 *         selected values.
	 */
	IObservableList getMultiSelectionObservable();

	/**
	 * Binds an observable list to the multiple selection.
	 * 
	 * @param observableList
	 *            The observable list holding the multiple selection.
	 * @see #getMultiSelectionObservable()
	 */
	void bindMultiSelectionToModel(IObservableList observableList);

	/**
	 * Binds a property of selection holder to the multiple selection of this
	 * ridget. The property must be a Collection.
	 * 
	 * @param selectionHolder
	 *            An object holding a list of selections.
	 * @param selectionPropertyName
	 *            The name of the multiple selection property.
	 * @see #getMultiSelectionObservable()
	 */
	void bindMultiSelectionToModel(Object selectionHolder, String selectionPropertyName);

	/**
	 * Updates the multiple selection from the multiple selection model.
	 * 
	 * @see #bindMultiSelectionToModel(IObservableList)
	 * @see #bindMultiSelectionToModel(Object, String)
	 */
	void updateMultiSelectionFromModel();

	/**
	 * Deselects all selected values.
	 */
	void clearSelection();

	/**
	 * Returns a list of the selected values.
	 * 
	 * @return list of selected values; never null; may be empty.
	 */
	List<Object> getSelection();

	/**
	 * Selects the given values. Values that are not in the set of selectable
	 * options will be ignored.
	 * 
	 * @param newSelection
	 *            a List of values to select. Never null. May be empty.
	 * @throws RuntimeException
	 *             (a) when there is no bound model to select from; (b) if
	 *             newSelection is null.
	 */
	void setSelection(List<?> newSelection);

	/**
	 * Selects the given value. If the value is not in the set of selectable
	 * options it will be ignored.
	 * 
	 * @param newSelection
	 *            value to select
	 * @throws RuntimeException
	 *             when there is no bound model to select from
	 */
	void setSelection(Object newSelection);

	/**
	 * Indicates whether the specified option is one of the options among which
	 * to select.
	 * 
	 * @param option
	 *            An option.
	 * @return true if the options is one of the selectable options, false
	 *         otherwise.
	 */
	boolean containsOption(Object option);
}
