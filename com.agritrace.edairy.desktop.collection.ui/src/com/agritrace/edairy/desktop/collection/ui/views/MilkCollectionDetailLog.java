package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;

public class MilkCollectionDetailLog extends AbstractRecordListView {

	public static final String ID = "milk-collection-detail-log";
	public static final int STD_LABEL_WIDTH = 120;

	public MilkCollectionDetailLog() {
	}


	@Override
	protected void createFilterConditions(Composite comp) {
		comp.setLayout(GridLayoutFactory.fillDefaults().create());
		new MilkCollectionDetailLogFilterPanel(comp, SWT.NONE);
		comp.pack();
	}

	@Override
	protected void createFilterButtons(Composite parent) {

		// prevent superclass from updating buttons.
	}



}