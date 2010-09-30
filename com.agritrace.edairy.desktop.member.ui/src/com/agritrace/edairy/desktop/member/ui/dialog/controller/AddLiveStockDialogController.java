package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AddLiveStockDialogController extends ViewLiveStockDialogController {
	@Inject
	public AddLiveStockDialogController(final Provider<MemberSearchDialog> memberSearchProvider) {
		super(memberSearchProvider);
	}

	@Override
	protected void configureButtonsPanel() {
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(false);
	}

}
