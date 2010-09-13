package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDetailPanelController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanel;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanelController;

public class AccountTransactionEditDialog extends RecordDialog<AccountTransaction> {

	public static class AccountTransactionEditController extends RecordDialogController<AccountTransaction> {

		private AccountTransactionEditPanelController panelController;

		public AccountTransactionEditController() {
			super();
			setReturnCode(ACTION_CANCEL);
		}

		@Override
		protected void configureUserRidgets() {
			panelController = new AccountTransactionEditPanelController();
			panelController.setModel(getWorkingCopy());
			panelController.setRidgetContainer(this);
		}

		@Override
		protected void handleSaveAction() {
			panelController.checkValid();
			super.handleSaveAction();
		}
		
		@Override
		public void afterBind() {
			super.afterBind();
			panelController.configureAndBind();
		}

	}

	public AccountTransactionEditDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new AccountTransactionEditPanel(comp, SWT.NONE);

	}

	@Override
	protected AccountTransactionEditController createController() {
		final AccountTransactionEditController controller = new AccountTransactionEditController();
		return controller;
	}

}
