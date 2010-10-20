package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;
import com.agritrace.edairy.desktop.member.ui.dialog.AddContainerDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.AddLiveStockDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewContainerDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewLiveStockDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ViewFarmDialogController extends AddFarmDialogController {

	private MemberLiveStockWidgetController liveStockController;
	// container tab
	private MemberContainerWidgetController containerController;

	private final IFarmRepository farmRepository;
	private final Provider<AddContainerDialog> addContainerProvider;
	private final Provider<ViewContainerDialog> viewContainerProvider;
	private final Provider<AddLiveStockDialog> addLiveStockProvider;
	private final Provider<ViewLiveStockDialog> viewLiveStockProvider;

	@Inject
	public ViewFarmDialogController(final IFarmRepository farmRepository,
			final Provider<AddContainerDialog> addContainerProvider,
			final Provider<ViewContainerDialog> viewContainerProvider,
			final Provider<AddLiveStockDialog> addLiveStockProvider,
			final Provider<ViewLiveStockDialog> viewLiveStockProvider) {
		this.farmRepository = farmRepository;
		this.addContainerProvider = addContainerProvider;
		this.viewContainerProvider = viewContainerProvider;
		this.addLiveStockProvider = addLiveStockProvider;
		this.viewLiveStockProvider = viewLiveStockProvider;
	}

	@Override
	protected void configureTabs(){
		super.configureTabs();
		liveStockController = new MemberLiveStockWidgetController(this, farmRepository,
				addLiveStockProvider, viewLiveStockProvider);
		containerController = new MemberContainerWidgetController(this, farmRepository,
				addContainerProvider, viewContainerProvider);
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