package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
	protected Composite createButtons(Composite parent) {
		final Composite buttonPanel = super.createButtons(parent);
		final GridLayout layout = (GridLayout) buttonPanel.getLayout();
		layout.numColumns = layout.numColumns + 1;
		UIControlsFactory.createButton(buttonPanel, "Batch Entry", FinanceBindingConstants.ID_BTN_BATCH_ENTRY);
		buttonPanel.layout();
		return buttonPanel;
	}

	@Override
	protected void createFilterConditions(Composite comp) {
		comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		comp.setLayoutDeferred(true);
		comp.setLayout(new GridLayout(2, false));
		
		new TransactionJournalFilterPanel(comp);
		comp.setLayoutDeferred(false);

		final Composite composite_1 = new Composite(comp, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite_1.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

}
