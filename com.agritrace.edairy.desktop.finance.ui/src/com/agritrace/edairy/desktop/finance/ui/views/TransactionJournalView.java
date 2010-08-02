package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.finance.ui.FinanceBindingConstants;
import com.agritrace.edairy.desktop.finance.ui.controls.TransactionJournalFilterPanel;

public class TransactionJournalView extends AbstractDirectoryView {

	public final static String ID = "member.account.transaction.journal";

	public TransactionJournalView() {
	}

	@Override
	public void setFocus() {
		super.setFocus();
	}

	@Override
	protected void createButtonPanel(Composite parent, String viewButtonId, String addButtonId) {
		final Composite buttonsPanel = UIControlsFactory.createComposite(parent, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(3, false));

		final Button viewButton = UIControlsFactory.createButton(buttonsPanel, "View", viewButtonId);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(viewButton);

		final Button addButton = UIControlsFactory.createButton(buttonsPanel, "Add", addButtonId);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(addButton);

		final Button batchButton = UIControlsFactory.createButton(buttonsPanel, "Batch Entry", FinanceBindingConstants.ID_BTN_BATCH_ENTRY);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(batchButton);
	}

	
	@Override
	protected void createFilterConditions(Composite parent) {
		Composite comp = UIControlsFactory.createComposite(parent);
		comp.setLayoutData(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comp.setLayout(
				new GridLayout(2, false));
		
		GridDataFactory.fillDefaults().applyTo(
				new TransactionJournalFilterPanel(comp));

		final Composite composite_1 = new Composite(comp, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(composite_1);
		composite_1.setBackground(
				LnfManager.getLnf().getColor(
						LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

}
