package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.controllers.AdjustmentTransactionEditController;
import com.agritrace.edairy.desktop.finance.ui.controls.AdjustmentTransactionEditPanel;

public class AdjustmentTransactionEditDialog extends RecordDialog<AdjustmentTransaction> {

	public AdjustmentTransactionEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new AdjustmentTransactionEditPanel(comp, SWT.NONE);

	}

	@Override
	protected AdjustmentTransactionEditController createController() {
		final AdjustmentTransactionEditController controller = new AdjustmentTransactionEditController();
		return controller;
	}

}
