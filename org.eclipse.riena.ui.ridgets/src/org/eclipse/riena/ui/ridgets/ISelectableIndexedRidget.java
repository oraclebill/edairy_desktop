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

/**
 * A specialization of {@link ISelectableRidget} that allows manipulating the
 * selection using index numbers. Indices are 0-based. The maximum index number
 * can be determined by {@link #getOptionCount()}.
 * <p>
 * Example:
 * 
 * <pre>
 * // select first three elements
 * ridget.setSelection(new int[] { 0, 1, 2 });
 * </pre>
 */
public interface ISelectableIndexedRidget extends ISelectableRidget {

	/**
	 * Returns one of the options among which to select.
	 * <p>
	 * If the ridget is sorted, the index refers to the sorted order. The index
	 * should not be stored since it will change when the sort order is
	 * modified.
	 * 
	 * @param index
	 *            the index of the option. If the ridget is sorted, the index
	 *            refers to the sorted order.
	 * @return the option at the given index
	 * @throws RuntimeException
	 *             if the index is out of bounds (index &lt; 0 || index &gt;=
	 *             getOptionCount())
	 */
	Object getOption(int index);

	/**
	 * Returns the number of options among which to select.
	 * 
	 * @return number of options
	 */
	int getOptionCount();

	/**
	 * Return the index of the first selected item or -1 if none.
	 * <p>
	 * If no control is bound to the ridget, the method always returns -1.
	 * <p>
	 * If the ridget is sorted, the index refers to the sorted order. The index
	 * should not be stored since it will change when the sort order is
	 * modified.
	 * 
	 * @return index of the first selected item or -1 if none. If the ridget is
	 *         sorted, the index refers to the sorted order.
	 */
	int getSelectionIndex();

	/**
	 * Returns an array of indices of the selected items. *
	 * <p>
	 * If no control is bound to the ridget, the method always returns -1.
	 * <p>
	 * If the ridget is sorted, the indices refer to the sorted order. The
	 * indices should not be stored since they will change when the sort order
	 * is modified.
	 * 
	 * @return indices of the selected items; never null; may be empty. If the
	 *         ridget is sorted, the indices refer to the sorted order.
	 */
	int[] getSelectionIndices();

	/**
	 * Index of the option among the selectable options.
	 * <p>
	 * If no control is bound to the ridget, the method always returns -1.
	 * <p>
	 * If the ridget is sorted, the index refers to the sorted order. The index
	 * should not be stored since it will change when the sort order is
	 * modified.
	 * 
	 * @param option
	 *            An option.
	 * @return The index of the option or -1 if the given option is not amongst
	 *         the selectable options. If the ridget is sorted, the index refers
	 *         to the sorted order.
	 */
	int indexOfOption(Object option);

	/**
	 * Selects the item of the given row.
	 * 
	 * @param index
	 *            a 0-based index of the row to select. If the ridget is sorted,
	 *            the index refers to the current sort order.
	 * @throws RuntimeException
	 *             (a) if the index is out of bounds (index &lt; 0 || index &ge;
	 *             getOptionCount()); (b) when there is no bound model to select
	 *             from
	 */
	void setSelection(int index);

	/**
	 * Selects the items of the given rows.
	 * 
	 * @param indices
	 *            indices of the rows to select. If the ridget is sorted, the
	 *            indices refer to the current sort order.
	 * @throws RuntimeException
	 *             (a) if the index is out of bounds (index &lt; 0 || index &ge;
	 *             getOptionCount()); (b) when there is no bound model to select
	 *             from
	 */
	void setSelection(int[] indices);
}
