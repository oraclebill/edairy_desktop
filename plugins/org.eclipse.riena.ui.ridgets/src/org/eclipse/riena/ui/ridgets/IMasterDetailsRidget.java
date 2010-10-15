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

import org.eclipse.core.databinding.observable.list.IObservableList;

/**
 * A ridget with two areas. The master area shows a table of objects, from which
 * one can be selected. The details are allows the user to edit some details of
 * the currently selected object/row.
 * <p>
 * This ridget is an {@link IComplexRidget} an {@link ITableRidget} to show the
 * available objects and several {@link IActionRidget}s to add, delete, update
 * the row elements.
 * <p>
 * The UI of the details area is created by implementing an
 * MasterDetailComposite. The binding between UI and ridgets is done by
 * implementing an {@link IMasterDetailsDelegate} and introducing it to this
 * ridget via {@link #setDelegate(IMasterDetailsDelegate)}.
 */
public interface IMasterDetailsRidget extends IRidget, IComplexRidget {

	/**
	 * Binds the table to the model data.
	 * 
	 * @param rowObservables
	 *            An observable list of objects (non-null).
	 * @param rowClass
	 *            The class of the objects in the list.
	 * @param columnPropertyNames
	 *            The list of property names that are to be displayed in the
	 *            columns. One property per column. Each object in
	 *            rowObservables must have a corresponding getter. This
	 *            parameter must be a non-null String array.
	 * @param columnHeaders
	 *            The titles of the columns to be displayed in the header. May
	 *            be null if no headers should be shown for this table.
	 *            Individual array entries may be null, which will show an empty
	 *            title in the header of that column.
	 * @throws RuntimeException
	 *             when columnHeaders is non-null and the the number of
	 *             columnHeaders does not match the number of
	 *             columnPropertyNames
	 */
	void bindToModel(IObservableList rowObservables, Class<? extends Object> rowClass, String[] columnPropertyNames,
			String[] columnHeaders);

	/**
	 * @param listHolder
	 *            An object that has a property with a list of objects.
	 * @param listPropertyName
	 *            Property for accessing the list of objects.
	 * @param rowClass
	 *            Property for accessing the list of objects.
	 * @param columnPropertyNames
	 *            The list of property names that are to be displayed in the
	 *            columns. One property per column. Each object in
	 *            rowObservables must have a corresponding getter. This
	 *            parameter must be a non-null String array.
	 * @param headerNames
	 *            The titles of the columns to be displayed in the header. May
	 *            be null if no headers should be shown for this table.
	 *            Individual array entries may be null, which will show an empty
	 *            title in the header of that column.
	 */
	void bindToModel(Object listHolder, String listPropertyName, Class<? extends Object> rowClass,
			String[] columnPropertyNames, String[] headerNames);

	/**
	 * Return the current {@link IMasterDetailsDelegate} or null, if none has
	 * (yet) been set.
	 * 
	 * @return the current {@link IMasterDetailsDelegate} or null
	 * @since 2.0
	 */
	IMasterDetailsDelegate getDelegate();

	/**
	 * Returns the currently object corresponding to the currently selected row
	 * in the ridget.
	 * 
	 * @return the actual selection in the ridget or null (if nothing is
	 *         selected)
	 */
	Object getSelection();

	/**
	 * Returns the directWriting setting. The default is false.
	 * <p>
	 * See {@link #setDirectWriting(boolean)} for details.
	 * 
	 * @return true if 'directWriting' is enabled; otherwise false
	 * 
	 * @since 1.2
	 */
	boolean isDirectWriting();

	/**
	 * Return true if the 'Apply' button enables on the condition that all
	 * ridgets in the Details are have <b>no</b> error markers.
	 * <p>
	 * The default setting for this option is false.
	 * 
	 * @return true if the 'Apply' button enables on the condition that all
	 *         ridgets in the Details are have <b>no</b> error markers;
	 *         otherwise false
	 * 
	 * @since 2.0
	 */
	boolean isApplyRequiresNoErrors();

	/**
	 * Return true if the 'Apply' button enables on the condition that all
	 * ridgets in the Details are have <b>no</b> mandatory markers.
	 * <p>
	 * The default setting for this option is false.
	 * 
	 * @return true if the 'Apply' button enables on the condition that all
	 *         ridgets in the Details are have <b>no</b> mandatory markers;
	 *         otherwise false
	 * 
	 * @since 2.0
	 */
	boolean isApplyRequiresNoMandatories();

	/**
	 * Return true, if a sucessfull 'Apply' triggers the 'New' action. If the
	 * 'New' action is unavailable, the method returns false regardless of the
	 * setting.
	 * <p>
	 * The default setting for this option is false.
	 * 
	 * @return Return true, if a sucessfull 'Apply' triggers the 'New' action. *
	 *         If the 'New' action is unavailable, the method returns false
	 *         regardless of the setting.
	 * 
	 * @since 2.0
	 */
	boolean isApplyTriggersNew();

	/**
	 * When set to true, the 'Apply' button will only enable when all ridgets in
	 * the Details area have <b>no</b> error markers.
	 * <p>
	 * The default setting for this option is false.
	 * 
	 * @param requiresNoErrors
	 *            The new setting for this option.
	 * 
	 * @since 1.2
	 */
	void setApplyRequiresNoErrors(boolean requiresNoErrors);

	/**
	 * When set to true, the 'Apply' button will only enable when all ridgets in
	 * the Details area have <b>no</b> mandatory markers.
	 * <p>
	 * The default setting for this option is false.
	 * 
	 * @param requiresNoMandatories
	 *            The new setting for this option.
	 * 
	 * @since 2.0
	 */
	void setApplyRequiresNoMandatories(boolean requiresNoMandatories);

	/**
	 * When set to true, a sucessfull 'Apply' will trigger a 'New'. This will
	 * only happen if the 'New' action is available.
	 * <p>
	 * The default setting for this option is false.
	 * 
	 * @param triggersNew
	 *            The new settings for this option.
	 * 
	 * @since 2.0
	 */
	void setApplyTriggersNew(boolean triggersNew);

	/**
	 * Adjust the column widths of the ridget's table control according to the
	 * information in the {@code widths} array.
	 * <p>
	 * When running on SWT: {@code widths} may only contain subclasses of
	 * ColumnLayoutData. The following layout managers are supported:
	 * TableLayout, TableColumnLayout, other. See ColumnUtils for implementation
	 * details.
	 * 
	 * @param widths
	 *            an Array with width information, one instance per column. The
	 *            array may be null, in that case the available width is
	 *            distributed equally to all columns.
	 * 
	 * @since 1.2
	 */
	void setColumnWidths(Object[] widths);

	/**
	 * Provide this ridget with an {@link IMasterDetailsDelegate} instance,
	 * which will manage the content of details area.
	 * 
	 * @param delegate
	 *            an {@link IMasterDetailsDelegate}; never null
	 */
	void setDelegate(IMasterDetailsDelegate delegate);

	/**
	 * When direct writing is enabled, changes in the details area will be
	 * Immediately and automatically applied back to the model. When adding new
	 * rows, these will be immediately added to the table. Since there is no
	 * need to apply, the 'Apply' button will not be shown.
	 * <p>
	 * The default setting for direct writing is false.
	 * 
	 * @param directWriting
	 *            The new direct writing setting.
	 * 
	 * @since 1.2
	 */
	void setDirectWriting(boolean directWriting);

	/**
	 * Set the new selection. This behaves exactly like an interactive selection
	 * change (i.e. the user selecting another value).
	 * 
	 * @param newSelection
	 *            the newly selected value of this ridget, or null to clear the
	 *            selection
	 */
	void setSelection(final Object newSelection);

	/**
	 * Suggest the given object as a 'new' entry. It will be made editable in
	 * the details area. The apply button will enable.
	 * 
	 * @param entry
	 *            a non-null object
	 * @since 2.0
	 */
	void suggestNewEntry(Object entry);

	/**
	 * Toggles the 'Apply' button state, according to the presence of changes in
	 * the details area. It will use delegate.isChanged(...) to compare the data
	 * in the details area with the original and enable the 'Apply' button if it
	 * differs.
	 * <p>
	 * Use this method when the data in the details has been modified without
	 * sending a notification to the IMasterDetailsRidget (for example, in a
	 * separate dialog that was opened).
	 * 
	 * @since 2.0
	 */
	void updateApplyButton();
}
