package com.agritrace.edairy.desktop.common.ui.ridgets;

import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.riena.internal.ui.ridgets.swt.TableRidgetLabelProvider;
import org.eclipse.riena.ui.ridgets.swt.SortableComparator;

/**
 * Default table comparator
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class TableComparator extends ViewerComparator {

	TableComparator(SortableComparator comparator) {
		super(comparator);
	}

	@SuppressWarnings("restriction")
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {

		final int cat1 = category(e1);
		final int cat2 = category(e2);

		if (cat1 != cat2) {
			return cat1 - cat2;
		}

		final int sortedColumn = getComparator().getSortedColumn();
		if ((viewer instanceof ContentViewer) && (sortedColumn != -1)) {
			final IBaseLabelProvider prov = ((ContentViewer) viewer).getLabelProvider();
			if (prov instanceof TableRidgetLabelProvider) {
				final TableRidgetLabelProvider lprov = (TableRidgetLabelProvider) prov;
				final Object value1 = lprov.getColumnValue(e1, sortedColumn);
				final Object value2 = lprov.getColumnValue(e2, sortedColumn);
				return getComparator().compare(value1, value2);
			}
		}

		return super.compare(viewer, e1, e2);
	}

	@Override
	protected SortableComparator getComparator() {
		return (SortableComparator) super.getComparator();
	}
}
