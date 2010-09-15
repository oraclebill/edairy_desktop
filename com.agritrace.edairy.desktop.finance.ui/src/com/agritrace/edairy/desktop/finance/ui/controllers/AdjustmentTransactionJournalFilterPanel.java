package com.agritrace.edairy.desktop.finance.ui.controllers;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.finance.ui.controls.TransactionJournalFilterPanel;
import com.agritrace.edairy.desktop.finance.ui.controls.TransactionSourceComposite;

public final class AdjustmentTransactionJournalFilterPanel extends TransactionJournalFilterPanel {
	public AdjustmentTransactionJournalFilterPanel(Composite parent) {
		this(parent, SWT.NONE);
	}
	
	public AdjustmentTransactionJournalFilterPanel(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	public void addRefNumFilterLookup() {
		// Do nothing - hide reference number filter
	}

	@Override
	public void addSourceFilter() {
		final Composite rowComposite = new TransactionSourceComposite(this, true, "Type");
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(rowComposite);
	}
}
