package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanel;

public class MemberTransactionEditDialog extends RecordDialog<AccountTransaction, MemberTransactionEditController> {

	public MemberTransactionEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new AccountTransactionEditPanel(comp, SWT.NONE);

	}

	@Override
	protected MemberTransactionEditController createController() {
		final MemberTransactionEditController controller = new MemberTransactionEditController();
		return controller;
	}

}
