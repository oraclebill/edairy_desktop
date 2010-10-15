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
package org.eclipse.riena.internal.ui.ridgets.swt;

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

import org.eclipse.riena.ui.ridgets.swt.SortableComparator;

/**
 * This comparator uses the values of the column the table is sorted by.
 */
final class TableComparator extends ViewerComparator {

	TableComparator(SortableComparator comparator) {
		super(comparator);
	}

	@Override
	protected SortableComparator getComparator() {
		return (SortableComparator) super.getComparator();
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {

		int cat1 = category(e1);
		int cat2 = category(e2);

		if (cat1 != cat2) {
			return cat1 - cat2;
		}

		int sortedColumn = getComparator().getSortedColumn();
		if ((viewer instanceof ContentViewer) && (sortedColumn != -1)) {
			IBaseLabelProvider prov = ((ContentViewer) viewer).getLabelProvider();
			if (prov instanceof TableRidgetLabelProvider) {
				TableRidgetLabelProvider lprov = (TableRidgetLabelProvider) prov;
				Object value1 = lprov.getColumnValue(e1, sortedColumn);
				Object value2 = lprov.getColumnValue(e2, sortedColumn);
				return getComparator().compare(value1, value2);
			}
		}

		return super.compare(viewer, e1, e2);
	}

}