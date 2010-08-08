package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;

public class ViewFarmDialogController extends AddFarmDialogController {
	
	private MemberLiveStockWidgetController liveStockController;
	// container tab
	private MemberContainerWidgetController containerController;	
	
	protected void configureTabs(){
		super.configureTabs();
		liveStockController = new MemberLiveStockWidgetController(this);
		containerController = new MemberContainerWidgetController(this);
	}
	@Override
	protected void configureButtonsPanel() {
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(true);
	}

	protected void updateBindings() {
		super.updateBindings();
		if (selectedNode != null) {
			final Farm selectedFarm = selectedNode.getFarm();
			if (selectedFarm != null) {
				updateUpperPanelBinding();
				liveStockController.setInputModel(selectedFarm);
				containerController.setInputModel(selectedFarm);
			}
		}

	}

}
