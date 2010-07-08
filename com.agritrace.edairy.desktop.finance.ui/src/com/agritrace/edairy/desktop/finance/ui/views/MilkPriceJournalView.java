package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.finance.ui.controls.MilkPriceJournalFilterPanel;

public class MilkPriceJournalView extends AbstractDirectoryView {

	public static final String ID = "milk.price.journal"; //$NON-NLS-1$

	public MilkPriceJournalView() {
	}

	@Override
	protected void createFilterConditions(Composite comp) {
		Composite control = new MilkPriceJournalFilterPanel(comp, SWT.NONE);
		comp.setLayout(new GridLayout());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
	}

}
