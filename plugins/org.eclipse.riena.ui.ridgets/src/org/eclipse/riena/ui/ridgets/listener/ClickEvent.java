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
package org.eclipse.riena.ui.ridgets.listener;

/**
 * Instances of this class provide information about a mouse click.
 * 
 * @since 2.0
 */
public final class ClickEvent {

	private final int columnIndex;
	private final int button;
	private final Object rowData;

	/**
	 * Create a new instance of this class
	 * 
	 * @param columnIndex
	 *            the 0-based index of a column, or -1
	 * @param button
	 *            the mouse button used; 1 for the first button, 2 for the 2nd,
	 *            3 for the 3rd, etc.
	 * @param rowData
	 *            the row clicked, or null if no row / column was determined
	 */
	public ClickEvent(int columnIndex, int button, Object rowData) {
		this.columnIndex = columnIndex;
		this.button = button;
		this.rowData = rowData;
	}

	/**
	 * The button that was pressed or released; 1 for the first button, 2 for
	 * the second button, and 3 for the third button, etc.
	 */
	public int getButton() {
		return button;
	}

	/**
	 * Returns the zero-based index of the column which was clicked.
	 * <p>
	 * May be -1 if no column could be determined. This is the case when the
	 * user manually resizes all columns to have 0 width (!).
	 */
	public int getColumnIndex() {
		return columnIndex;
	}

	/**
	 * The row element. May be null, if no column could be determined (see
	 * {@link #getColumnIndex()).
	 */
	public Object getRow() {
		return rowData;
	}

	@Override
	public String toString() {
		return String.format("ClickEvent [columnIndex=%d, button=%d, rowData=%s]", columnIndex, button, String //$NON-NLS-1$
				.valueOf(rowData));
	}

}
