package com.agritrace.edairy.desktop.common.ui.dialogs;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Shell;

/**
 * Member Search Dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class FarmSearchDialog extends CommonLookupDialog {

	/**
	 * Default constructor
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public FarmSearchDialog(Shell shell) {
		super(shell);
	}

	protected void configureShell(Shell newShell) {
		newShell.setSize(450, 500);
		super.configureShell(newShell);
		setTitle("Farm Lookup");
	}

	@Override
	protected AbstractWindowController createController() {
		return new FarmLookupDialogController();
	}
}
