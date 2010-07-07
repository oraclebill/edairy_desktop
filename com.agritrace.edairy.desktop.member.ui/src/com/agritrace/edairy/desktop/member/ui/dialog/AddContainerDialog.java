package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddContainerDialogController;

public class AddContainerDialog extends ViewContainerDialog {

	public AddContainerDialog(Shell shell) {
		super(shell);
	}

	@Override
	protected AbstractWindowController createController() {
		return new AddContainerDialogController();
	}

}
