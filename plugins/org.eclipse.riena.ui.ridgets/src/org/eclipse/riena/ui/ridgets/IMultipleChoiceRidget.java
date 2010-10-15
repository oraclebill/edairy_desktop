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

/**
 * A multiple choice ridget that allows the selection of multiple options.
 */
public interface IMultipleChoiceRidget extends IChoiceRidget {

	/**
	 * Return the observable list holding the selected options.
	 * 
	 * @return the observable list of selected options.
	 */
	IObservableList getObservableSelectionList();

	/**
	 * Creates the bindings for this ridget.
	 * <p>
	 * The method will use the values provided by optionValues to create the
	 * choices shown by this ridget. The method will bind the selections kept by
	 * this ridget to selectionValues.
	 * 
	 * @param optionValues
	 *            An observable list with a list of options.
	 * @param selectionValues
	 *            An observable value holding the list of selected options.
	 */
	void bindToModel(IObservableList optionValues, IObservableList selectionValues);

	/**
	 * Creates the bindings for this ridget.
	 * <p>
	 * The method will use the values provided by the listHolder to create the
	 * choices shown by this ridget. The method will bind the selections kept by
	 * this ridget to the to the attribute in selectionHolder specified by
	 * selectionPropertyName.
	 * 
	 * @param listHolder
	 *            An object holding the list of options.
	 * @param listPropertyName
	 *            The property name to access the list.
	 * @param selectionHolder
	 *            An object holding the list of selected options.
	 * @param selectionPropertyName
	 *            The property name to access the selection.
	 */
	void bindToModel(Object listHolder, String listPropertyName, Object selectionHolder, String selectionPropertyName);

	/**
	 * Creates the bindings for this ridget.
	 * <p>
	 * It will use the labels (Strings) provided by optionLabels to create the
	 * choices shown by this ridget. Each label corresponds to one option from
	 * optionValues, based on the position in each list. The method will bind
	 * the selections kept by this ridget to the attribute in selectionHolder
	 * specified by selectionPropertyName.
	 * 
	 * @param optionValues
	 *            The list of values to provide as choice list.
	 * @param optionLabels
	 *            The list of labels to present the choice list.
	 * @param selectionHolder
	 *            An object holding the list of selected options.
	 * @param selectionPropertyName
	 *            The property name to access the selection.
	 */
	void bindToModel(List<? extends Object> optionValues, List<String> optionLabels, Object selectionHolder,
			String selectionPropertyName);

	/**
	 * Return the selection.
	 * 
	 * @return the selection list.
	 */
	List<?> getSelection();

	/**
	 * Set the selection.
	 * 
	 * @param selection
	 *            the selection list.
	 */
	void setSelection(List<?> selection);
}
