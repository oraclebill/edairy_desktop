package com.agritrace.edairy.desktop.collection.ui.views;

import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.collection.ui.components.MilkCollectionDetailLogFilterPanel;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class MilkCollectionDetailLog extends AbstractDirectoryView {

	public static final String ID = "milk-collection-detail-log";
	public static final int STD_LABEL_WIDTH = 120;

	public MilkCollectionDetailLog() {
	}


	@Override
	protected void createFilterPanel(Composite comp) {
		comp.setLayout(GridLayoutFactory.fillDefaults().create());
		new MilkCollectionDetailLogFilterPanel(comp, SWT.NONE);
		comp.pack();
	}

	@Override
	protected void createFilterButtons(Composite parent) {

		// prevent superclass from updating buttons.
	}



}
