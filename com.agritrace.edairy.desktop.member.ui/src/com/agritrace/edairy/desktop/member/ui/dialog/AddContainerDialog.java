package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddContainerDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class AddContainerDialog extends ViewContainerDialog {
	@Inject
	public AddContainerDialog(@Named("current") final Shell shell, final AddContainerDialogController controller) {
		super(shell, controller);
	}
}
