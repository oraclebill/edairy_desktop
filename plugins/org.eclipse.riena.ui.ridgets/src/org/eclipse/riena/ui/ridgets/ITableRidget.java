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

import java.util.Comparator;

import org.eclipse.core.databinding.observable.list.IObservableList;

import org.eclipse.riena.ui.common.ISortableByColumn;
import org.eclipse.riena.ui.ridgets.listener.ClickEvent;
import org.eclipse.riena.ui.ridgets.listener.IClickListener;

/**
 * Ridget for a table.
 */
public interface ITableRidget extends ISelectableIndexedRidget, ISortableByColumn {

	/**
	 * Adds the listener to the collection of listeners who will be notified
	 * when a row is clicked. The listener will receive information about the
	 * column, moues button, row via a {@link ClickEvent}.
	 * 
	 * @param listener
	 *            a non-null {@link IClickListener} instance
	 * @since 2.0
	 */
	void addClickListener(IClickListener listener);

	/**
	 * Adds the listener to the collection of listeners who will be notified
	 * when the bound control is double-clicked.
	 * <p>
	 * Adding the same listener several times has no effect.
	 * 
	 * @param listener
	 *            a non-null {@link IActionListener} instance
	 * @throws RuntimeException
	 *             if listener is null
	 */
	void addDoubleClickListener(IActionListener listener);

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
	 *            The titles of the columns to be displayed in the table header.
	 *            May be null if no headers should be shown for this table.
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
	 * Binds the table to the model data.
	 * 
	 * @param listHolder
	 *            An object that has a property with a list of objects.
	 * @param listPropertyName
	 *            Property for accessing the list of objects.
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
	void bindToModel(Object listHolder, String listPropertyName, Class<? extends Object> rowClass,
			String[] columnPropertyNames, String[] columnHeaders);

	/**
	 * Return an observable list of objects which can be selected through this
	 * ridget.
	 * 
	 * @return an IObservableList instance or null, if the ridget has not been
	 *         bound to a model
	 */
	IObservableList getObservableList();

	/**
	 * Return true, if this table allows columns to be re-arranged by the user.
	 * The default value is false.
	 * 
	 * @return true if table allows columns to be re-arranged; otherwise false
	 */
	boolean hasMoveableColumns();

	/**
	 * Refresh the given row or rows in the control.
	 * <p>
	 * This is useful when the values shown by the ridget do not fire property
	 * change notifications when they are changed (pojos).
	 * <p>
	 * Does not have an effect when no control is bound.
	 * 
	 * @param node
	 *            the row value that should be refreshed or null to refresh all
	 *            rows
	 * @since 2.0
	 */
	void refresh(Object node);

	/**
	 * Removes the listener from the collection of listeners who will be
	 * notified when a row is clicked.
	 * 
	 * @param listener
	 *            a non-null {@link IClickListener} instance
	 * @since 2.0
	 */
	void removeClickListener(IClickListener listener);

	/**
	 * Removes the listener from the collection of listeners who will be
	 * notified when the bound control is double-clicked.
	 * 
	 * @param listener
	 *            a non-null {@link IActionListener} instance
	 * @throws RuntimeException
	 *             if listener is null
	 */
	void removeDoubleClickListener(IActionListener listener);

	/**
	 * Set the {@link ColumnFormatter} to be used for the column at columnIndex.
	 * <p>
	 * Note: changing column formatters on a table ridget that is already bound
	 * to a model, requires calling {@link #updateFromModel()} to apply the new
	 * format.
	 * 
	 * @param columnIndex
	 *            a columnIndex in the allowed range ( 0 &lt;= columnIndex &lt;
	 *            numColumns )
	 * @param formatter
	 *            an IColumnFormatter instance; null removes the previously used
	 *            formatter from the selected column
	 */
	void setColumnFormatter(int columnIndex, IColumnFormatter formatter);

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
	 *            distributed equally to all columns
	 * @since 1.2
	 */
	void setColumnWidths(Object[] widths);

	/**
	 * Set the {@link Comparator} to be used when sorting column at columnIndex.
	 * 
	 * @param columnIndex
	 *            a columnIndex in the allowed range: ( 0 &lt;= columnIndex &lt;
	 *            numColumns )
	 * @param comparator
	 *            a Comparator instance; may be null
	 * @throws RuntimeException
	 *             if columnIndex is out of range
	 */
	void setComparator(int columnIndex, Comparator<Object> comparator);

	/**
	 * Set to true, if this table should allow columns to be re-arranged by the
	 * user.
	 * 
	 * @param moveableColumns
	 *            true, if column should be rearrangeable by the user; false
	 *            otherwise.
	 */
	void setMoveableColumns(boolean moveableColumns);
}
