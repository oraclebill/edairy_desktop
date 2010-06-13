package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddFarmDialogController;

public class AddFarmDialog extends ViewFarmDialog {

	public AddFarmDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	protected AbstractWindowController createController() {
		return new AddFarmDialogController();
	}

}
