package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class AddFarmDialogController extends ViewFarmDialogController {

	private ITextRidget farmNameTextRidget;
	private ILabelRidget farmIdRidget;
	private ILabelRidget memberNameRidget;
	private ILabelRidget memberIdRidget;

	protected void configureUpperPanel() {
		farmNameTextRidget = getRidget(ITextRidget.class, ViewWidgetId.VIEW_FARM_NAME_TXT);
		farmIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_ID);
		memberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_MEMBER_NAME);
		memberIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_MEMBER_ID);

	}

	protected void updateUpperPanelBinding() {
		if (selectedNode != null && selectedNode.getMembership() != null) {
			Farmer farmer = (Farmer) selectedNode.getMembership().getMember();
			Farm selectedFarm = selectedNode.getFarm();
			farmNameTextRidget.bindToModel(EMFObservables.observeValue(selectedNode.getFarm(),
					TrackingPackage.Literals.FARM__NAME));
			if (farmIdRidget != null) {
				farmIdRidget.setText(FARM_ID_LABEL_PREFIX + selectedFarm.getFarmId());
			}
			if (memberIdRidget != null) {
				memberIdRidget.setText(FARM_MEMBER_ID_LABEL_PREFIX + selectedNode.getMembership().getMemberId());
			}
			if (memberNameRidget != null) {
				memberNameRidget.setText(FARM_MEMBER_NAME_LABEL_PREFIX + farmer.getFamilyName() + ","
						+ farmer.getGivenName());
			}
		}
	}

	protected void configureButtonsPanel() {
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.deleteButton);
		deleteAction.setVisible(false);
	}
}
