package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.ui.dialog.controller.AddFarmDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Add Farm dialog has "Address" "Directions" "Map" tabs.
 *
 *
 */
public class AddFarmDialog extends ViewFarmDialog {
	@Inject
	public AddFarmDialog(@Named("current") Shell parentShell, AddFarmDialogController controller) {
		super(parentShell, controller);
	}

	@Override
	protected void createTabs(Composite parent){
		new FarmTabFolder(parent,true);
	}

}
