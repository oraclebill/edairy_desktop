package com.agritrace.edairy.desktop.finance.ui.controllers;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AdjustmentTransaction;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;

public class AdjustmentTransactionEditDialog extends RecordDialog<AdjustmentTransaction, AdjustmentTransactionEditController> {

	public AdjustmentTransactionEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected AbstractWindowController createController() {
		return new AdjustmentTransactionEditController();
	}

}
