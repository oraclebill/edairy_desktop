package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.dao.IFarmRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;
import com.agritrace.edairy.desktop.member.ui.dialog.LivestockEditDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewContainerDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ViewFarmDialogController extends FarmEditDialogController {

	private MemberLiveStockWidgetController liveStockController;
	// container tab
	private MemberContainerWidgetController containerController;

	private final IFarmRepository farmRepository;
	private final Provider<ViewContainerDialog> viewContainerProvider;
	private final Provider<LivestockEditDialog> viewLiveStockProvider;

	@Inject
	public ViewFarmDialogController(final IFarmRepository farmRepository,
			final Provider<ViewContainerDialog> viewContainerProvider,
			final Provider<LivestockEditDialog> viewLiveStockProvider) {
		this.farmRepository = farmRepository;
		this.viewContainerProvider = viewContainerProvider;
		this.viewLiveStockProvider = viewLiveStockProvider;
	}

	@Override
	protected void configureTabs(){
		super.configureTabs();
		liveStockController = new MemberLiveStockWidgetController(this, farmRepository,
				viewLiveStockProvider);
		containerController = new MemberContainerWidgetController(this, farmRepository, viewContainerProvider);
	}

	@Override
	protected void configureButtonsPanel() {
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(true);
	}

	@Override
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
