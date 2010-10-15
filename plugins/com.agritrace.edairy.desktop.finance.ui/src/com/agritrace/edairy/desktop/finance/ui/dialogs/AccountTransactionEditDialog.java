package com.agritrace.edairy.desktop.finance.ui.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanel;
import com.agritrace.edairy.desktop.finance.ui.controls.AccountTransactionEditPanelController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class AccountTransactionEditDialog extends RecordDialog<AccountTransaction> {

	public static class AccountTransactionEditController extends RecordDialogController<AccountTransaction> {
		private final AccountTransactionEditPanelController panelController;

		@Inject
		public AccountTransactionEditController(final AccountTransactionEditPanelController panelController) {
			super();
			this.panelController = panelController;
			setReturnCode(ACTION_CANCEL);
		}

		@Override
		protected void configureUserRidgets() {
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

	@Inject
	public AccountTransactionEditDialog(final @Named("current") Shell parentShell,
			final AccountTransactionEditController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void buildWorkArea(Composite comp) {
		new AccountTransactionEditPanel(comp, SWT.NONE);

	}

}
