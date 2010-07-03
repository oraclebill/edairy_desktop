package com.agritrace.edairy.desktop.finance.ui.controls;

import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class TransactionBatchEntryPanel extends MasterDetailsComposite {

	public TransactionBatchEntryPanel(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void createDetails(Composite details) {
		new TransactionEntryPanel(details, SWT.NONE);
	}
}
