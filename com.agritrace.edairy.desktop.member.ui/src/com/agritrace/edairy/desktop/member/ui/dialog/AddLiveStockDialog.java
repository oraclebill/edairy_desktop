package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddLiveStockDialogController;

public class AddLiveStockDialog extends ViewLiveStockDialog {

	public AddLiveStockDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected AbstractWindowController createController() {
		// TODO Auto-generated method stub
		return new AddLiveStockDialogController();
	}

}
