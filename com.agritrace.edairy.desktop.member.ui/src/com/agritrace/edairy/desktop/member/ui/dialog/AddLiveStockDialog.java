package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddLiveStockDialogController;
import com.google.inject.Inject;

public class AddLiveStockDialog extends ViewLiveStockDialog {
	@Inject
	public AddLiveStockDialog(Shell parentShell, AddLiveStockDialogController controller) {
		super(parentShell, controller);
	}
}
