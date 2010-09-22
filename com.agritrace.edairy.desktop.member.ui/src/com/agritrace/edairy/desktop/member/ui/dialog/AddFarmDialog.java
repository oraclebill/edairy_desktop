package com.agritrace.edairy.desktop.member.ui.dialog;

import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
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
	public AddFarmDialog(@Named("current") Shell parentShell, IFarmRepository farmRepository) {
		super(parentShell, farmRepository);
	}

	@Override
	protected AbstractWindowController createController() {
		return new AddFarmDialogController();
	}
	
	protected void createTabs(Composite parent){
		new FarmTabFolder(parent,true);
	}

}
