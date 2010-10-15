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
 * Provides formatting options for a single column. Can be used with
 * column-based ridgets (ITableRidget, ITreeTableRidget).
 * <p>
 * Toolkits may provide (and ridgets may require) a specific implementation of
 * this interface. See ColumnFormatter for an SWT-specific implementation.
 * <p>
 * <i> Note: not every property will be used for every kind of table Ridget!
 * </i>
 * 
 * @see ITableRidget#setColumnFormatter(int, ColumnFormatter)
 * @see ITreeTableRidget#setColumnFormatter(int, ColumnFormatter)
 */
public interface IColumnFormatter {

	/**
	 * Returns the text for a column's row.
	 * 
	 * @param element
	 *            the row element
	 * @return a text (String) for this element, or null, if no text should be
	 *         shown
	 */
	String getText(Object element);

	/**
	 * Returns the image for a column's row.
	 * 
	 * @param element
	 *            the row element
	 * @return an image for this element, or null, if no image should be shown.
	 *         Implementors may return a type specific to their ui-toolkit.
	 */
	Object getImage(Object element);

	/**
	 * Returns the foreground color for a column's row.
	 * 
	 * @param element
	 *            the row element
	 * @return the foreground color for this element or null to use the default
	 *         foreground color. Implementors may return a type specific to
	 *         their ui-toolkit.
	 */
	Object getForeground(Object element);

	/**
	 * Returns the background color for a column's row.
	 * 
	 * @param element
	 *            the row element
	 * @return the background color for this element or null to use the default
	 *         background color. Implementors may return a type specific to
	 *         their ui-toolkit.
	 */
	Object getBackground(Object element);

	/**
	 * Returns the font for a column's row.
	 * 
	 * @param element
	 *            the row element
	 * @return the font color for this element or null to use the default font.
	 *         Implementors may return a type specific to their ui-toolkit.
	 */
	Object getFont(Object element);

	/**
	 * Returns the horizontal alignment for a column's row.
	 * <p>
	 * <i>Currently not used for {@link ITableRidget} and
	 * {@link ITreeTableRidget}!</i>
	 * 
	 * @param element
	 *            the row element
	 * @return horizontal alignment ({@code SWT.LEFT}, {@code SWT.CENTER},
	 *         {@code SWT.RIGHT} or {@code SWT.DEFAULT})
	 * @since 1.2
	 */
	int getHorizontalAlignment(Object element);

	/**
	 * Returns the number of indents that should be added before the content of
	 * a cell.
	 * <p>
	 * The number of indents is multiplied with a setting of the Riena (SCP)
	 * Look&Feel ({@code SCPLnfKeyConstants.MATRIX_ADDTIONAL_PADDING_LEFT}). So
	 * the pixels for left padding is computed.
	 * <p>
	 * <i>Currently not used for {@link ITableRidget} and
	 * {@link ITreeTableRidget}!</i>
	 * 
	 * @param element
	 *            the row element
	 * @return number of indents
	 * @since 2.0
	 */
	int getLeftIndent(Object element);

}
