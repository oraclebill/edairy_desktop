package com.agritrace.edairy.desktop.finance.ui.dialogs;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanelController;

public class AccountTransactionEditController extends RecordDialogController<AccountTransaction> {

	private AccountTransactionEditPanelController panelController;

	public AccountTransactionEditController() {
		super();
	}

	@Override
	protected void configureUserRidgets() {
		panelController = new AccountTransactionEditPanelController();
		panelController.setModel(getWorkingCopy());
		panelController.setRidgetContainer(this);
		panelController.configureAndBind();
	}

	@Override
	protected void handleSaveAction() {
		panelController.checkValid();
		super.handleSaveAction();
	}

}
