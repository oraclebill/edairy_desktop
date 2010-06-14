package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

public class MilkCollectionLog extends AbstractRecordListView {

	public static final String ID = "milk-collection-log";

	public MilkCollectionLog() {
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		final Composite comp = new MilkCollectionLogFilterPanel(parent, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(3,-1).applyTo(comp);
	}

	@Override
	protected void createFilterButtons(Composite parent) {
		// prevent superclass from adding buttons..
	}


}
