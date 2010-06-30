package com.agritrace.edairy.desktop.finance.ui.dialogs;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.finance.ui.controls.TransactionEntryPanelController;

public class MemberTransactionEditController2 extends RecordDialogController<AccountTransaction> {

	private TransactionEntryPanelController panelController;
	public MemberTransactionEditController2() {
		super();
	}

	
	@Override
	protected void configureUserRidgets() {
		panelController = new TransactionEntryPanelController();
		panelController.setModel(getWorkingCopy());
		panelController.setRidgetContainer(this);
		panelController.configureAndBind();
	}


	@Override
	protected void handleSaveAction() {
		panelController.checkValid();
		super.handleSaveAction();
	}

	private void checkValid() {
		
		
	}

	
}
