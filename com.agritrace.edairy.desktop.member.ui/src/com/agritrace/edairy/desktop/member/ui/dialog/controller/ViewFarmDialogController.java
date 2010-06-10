package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;

public class ViewFarmDialogController extends AbstractWindowController {

	public static final String DIALOG_TITLE = "Farm";

	private String generatedFarmId;

	protected FarmListViewTableNode selectedNode;

	// upper panel fields
	private ILabelRidget farmNameRidget;
	private ILabelRidget farmIdRidget;
	private ILabelRidget memberNameRidget;
	private ILabelRidget memberIdRidget;

	private LocationProfileWidgetController locationProfileController;

	// container tab
	private MemberContainerWidgetController containerController;

	// live stock tab
	private MemberLiveStockWidgetController liveStockController;

	public static final String FARM_ID_LABEL_PREFIX = "Farm Id :";
	public static final String FARM_NAME_LABEL_PREFIX = "Farm Name :";
	public static final String FARM_MEMBER_ID_LABEL_PREFIX = "Member Id :";
	public static final String FARM_MEMBER_NAME_LABEL_PREFIX = "Member Name :";

	public ViewFarmDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		selectedNode = (FarmListViewTableNode) getContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM);
		configureUpperPanel();
		locationProfileController = new LocationProfileWidgetController(this);
		liveStockController = new MemberLiveStockWidgetController(this);
		containerController = new MemberContainerWidgetController(this);

		if (selectedNode != null) {
			updateBindings();
		}
		configureButtonsPanel();

	}

	protected void configureButtonsPanel() {
		final IActionRidget okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(OK);
				setContext(ControllerContextConstant.FARM_DIALOG_CONTXT_SELECTED_FARM, selectedNode);
				getWindowRidget().dispose();
			}
		});
		final IActionRidget cancelAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_CANCEL);
		cancelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(CANCEL);
				getWindowRidget().dispose();
			}
		});

		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(true);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(2);
				getWindowRidget().dispose();
			}
		});
	}

	protected void configureUpperPanel() {

		farmNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_NAME);
		farmIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_ID);
		memberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_MEMBER_NAME);
		memberIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_FARM_MEMBER_ID);

	}

	private void updateBindings() {
		if (selectedNode != null) {
			Farm selectedFarm = selectedNode.getFarm();
			if (selectedFarm != null) {
				updateUpperPanelBinding();
				locationProfileController.setInputModel(selectedFarm.getLocation());
				liveStockController.setInputModel(selectedFarm);
				containerController.setInputModel(selectedFarm);
			}
		}

	}

	protected void updateUpperPanelBinding() {
		if (selectedNode != null && selectedNode.getMembership() != null) {
			Farmer farmer = (Farmer) selectedNode.getMembership().getMember();
			Farm selectedFarm = selectedNode.getFarm();
			if (farmNameRidget != null) {
				farmNameRidget.setText(FARM_NAME_LABEL_PREFIX + selectedFarm.getName());
			}
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

	private void copySelectedMember() {
		// if(selectedMember != null){
		// workingCopy = EcoreUtil.copy(selectedMember);
		// }
	}

	protected void saveMember() {
		// if (selectedFarm != null) {
		// MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this,
		// selectedMember);
		// try {
		// DairyDemoResourceManager.INSTANCE.saveFarmResource();
		// DairyDemoResourceManager.INSTANCE.saveDairyResource();
		// MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
		// } catch (final IllegalArgumentException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// Activator.getDefault().logError(e, e.getMessage());
		// } catch (final IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// Activator.getDefault().logError(e, e.getMessage());
		//
		// }
		// }
	}

}
