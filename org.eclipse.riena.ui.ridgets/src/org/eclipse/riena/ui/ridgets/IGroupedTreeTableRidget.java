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
 * A ridget that supports "grouping" of columns.
 * <p>
 * When grouping is <b>enabled</b>, rows containing expandable/collapsable tree
 * nodes will be rendered as "grouping rows" with the tree columns spanning all
 * the columns in the table, instead of normal data rows that have several
 * columns.
 * <p>
 * Example of a row in "grouped" mode:
 * 
 * <pre>
 * +------------+-------------------+-----------+
 * + [+] \Home                                  | 
 * +------------+-------------------+-----------+
 * </pre>
 * 
 * Same row in "ungrouped" mode:
 * 
 * <pre>
 * +------------+-------------------+-----------+
 * + [+] \Home  |          column_2 |  column_3 | 
 * +------------+-------------------+-----------+
 * </pre>
 */
public interface IGroupedTreeTableRidget extends ITreeTableRidget {

	/**
	 * Property indicating whether rows associated with folder nodes in the tree
	 * should be rendered as grouping rows with the tree column spanning the
	 * entire table or rather as normal data rows like their children.
	 */
	String PROPERTY_GROUPING_ENABLED = "groupingEnabled"; //$NON-NLS-1$

	/**
	 * Indicates whether grouping is enabled. As grouped table without grouping
	 * looks like a normal table.
	 * 
	 * @return true if grouping is enabled, false otherwise.
	 */
	boolean isGroupingEnabled();

	/**
	 * Sets whether grouping is enabled. As grouped table without grouping looks
	 * like a normal table.
	 * <p>
	 * Fires a {@link IGroupedTreeTableRidget#PROPERTY_GROUPING_ENABLED} event.
	 * 
	 * @param grouping
	 *            The new grouping state.
	 */
	void setGroupingEnabled(boolean grouping);
}
