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

import org.eclipse.riena.ui.common.ISortableByColumn;

/**
 * Ridget for a tree table.
 */
public interface ITreeTableRidget extends ITreeRidget, ISortableByColumn {

	/**
	 * Creates a binding between the Tree Ridget and the specified treeRoots.
	 * <p>
	 * Each tree element must have an accessor that provides a list of children
	 * (List), an accessor that provides a parent (null for the a root element)
	 * and an accessor that provides a value (Object) for each child. It is
	 * assumed that the rootElement and all children are of the same type.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * MyType[] rootElements = { root1 };
	 * String[] valueAccessors = { &quot;fistname&quot; ,&quot;lastname&quot; };
	 * String[] columnHeaders = { &quot;First Name&quot;, &quot;Last Name&quot; }
	 * treeRidget.bind(rootElements, MyType.class, &quot;children&quot;, 
	 *                 &quot;parent&quot;, valueAccessors, columnHeaders);
	 * </pre>
	 * <p>
	 * In the example above MyType must have the methods specified in the
	 * bind(...) invocation, i.e.: getChildren(), getParent(), getFirstname(),
	 * getLastname(). It is suggested that MyType follows the 'beans' convention
	 * by providing add / removePropertyChangeListener(PropertyChangeListener)
	 * methods and firing events on containment or value modifications. This
	 * will keep the tree in sync automatically. Otherwise
	 * {@link #updateFromModel()} has to be called to resync.
	 * <p>
	 * Note that invoking this method will discard any queued expand/collapse
	 * operations on the ridget.
	 * 
	 * @param treeRoots
	 *            the root elements of the tree (non-null, non-empty).
	 * @param treeElementClass
	 *            the type of the elements in the tree (i.e. for treeRoot and
	 *            all children).
	 * @param childrenAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining a List of children from an object in the tree. For
	 *            example "children" specifies "getChildren()". The returned
	 *            children will be shown underneath their parent.
	 * @param parentAccessor
	 *            a non-null, non-empty String specifying an accessor for
	 *            obtaining the parent Object from an object in the tree. The
	 *            accessor is allowed to return null for root elements. For
	 *            example "parent" specifies "getParent()". The parents are used
	 *            when determining the correct way to expand or collapse a tree
	 *            element.
	 * @param valueAccessors
	 *            a non-null; non-empty array of Strings. Each String specifies
	 *            an accessor for obtaining an Object value from each child
	 *            object (example "value" specifies "getValue()"). The order in
	 *            the array corresponds to the initial order of the columns,
	 *            i.e. the 1st accessor will be used for column one/the tree,
	 *            the 2nd for column two, the 3rd for column three and so on.
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

	void bindToModel(Object[] treeRoots, Class<? extends Object> treeElementClass, String childrenAccessor,
			String parentAccessor, String[] valueAccessors, String[] columnHeaders);

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
	 * Adjust the column widths of the ridget's tree control according to the
	 * information in the {@code widths} array.
	 * <p>
	 * When running on SWT: {@code widths} may only contain sublasses of
	 * ColumnLayoutData. The following layout managers are supported:
	 * TableLayout, TreeColumnLayout, other. See ColumnUtils for implementation
	 * details.
	 * 
	 * @param widths
	 *            an Array with width information, one instance per column. The
	 *            array may be null, in that case the available width is
	 *            distributed equally to all columns
	 * @since 1.2
	 */
	void setColumnWidths(Object[] widths);
}
