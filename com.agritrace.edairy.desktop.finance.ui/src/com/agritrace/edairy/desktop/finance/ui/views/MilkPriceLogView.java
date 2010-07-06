package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.finance.ui.controls.MilkPriceLogFilterPanel;

public class MilkPriceLogView extends AbstractDirectoryView {

	public static final String ID = "milk.price.log"; //$NON-NLS-1$

	public MilkPriceLogView() {
	}

	@Override
	protected void createFilterPanel(Composite comp) {
		new MilkPriceLogFilterPanel(comp, SWT.NONE);		
	}

}
