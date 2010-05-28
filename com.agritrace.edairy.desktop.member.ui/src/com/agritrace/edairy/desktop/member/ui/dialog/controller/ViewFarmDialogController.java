package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controllers.FarmListViewController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberCollectionRecrodsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberLiveStockController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberTransactionWidgetController;
import com.agritrace.edairy.desktop.member.ui.data.FarmListViewTableNode;

public class ViewFarmDialogController extends AbstractWindowController{

	public static final String DIALOG_TITLE = "Membership";
	
	private String generatedFarmId;

	protected Farm selectedFarm;

	// upper panel fields
	private ILabelRidget memberIdRidget;
	private ITextRidget nameRidget;

	private MemberProfileWidgetController memberProfileController;

	// container tab
	private MemberContainerWidgetController containerController;

	// live stock tab
	private MemberLiveStockController liveStockController;

	public ViewFarmDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		selectedFarm = (Farm) getContext("selectedFarm");

		configureUpperPanel();
		
		memberProfileController = new MemberProfileWidgetController(this);
	
	
		liveStockController = new MemberLiveStockController(this);
		containerController = new MemberContainerWidgetController(this);
	

	
		if (selectedFarm != null) {
			updateBindings();
		}
		configureButtonsPanel();
		
	}
	
	protected void configureButtonsPanel(){
		final IActionRidget okAction = (IActionRidget) getRidget(ViewWidgetId.memberInfo_saveButton);
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(OK);
				setContext("selectedFarm",selectedFarm);
				getWindowRidget().dispose();
			}
		});
		final IActionRidget cancelAction = (IActionRidget) getRidget(ViewWidgetId.memberInfo_cacelButton);
		cancelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(CANCEL);
				getWindowRidget().dispose();
			}
		});
		
		final IActionRidget deleteAction = (IActionRidget) getRidget(ViewWidgetId.deleteButton);
		deleteAction.setVisible(false);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(2);
				getWindowRidget().dispose();
			}
		});
	}

	protected  void configureUpperPanel() {
//		memberIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberInfo_id);
////		generatedMemberId = System.currentTimeMillis()+"";
////		memberIdRidget.setText(generatedMemberId);
//		nameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_firstName);

	}

	private void updateBindings() {
		updateUpperPanelBinding();
		memberProfileController.setInputModel(selectedFarm);
		liveStockController.setInputModel(selectedFarm);		
		containerController.setInputModel(selectedFarm);
		
	}

	protected void updateUpperPanelBinding() {
		if(selectedFarm.eContainer() != null){
			Farmer farmer =(Farmer)selectedFarm.eContainer();
//			memberIdRidget.bindToModel(EMFObservables.observeValue(selectedMember,	DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
//			memberIdRidget.updateFromModel();
			nameRidget.setText(farmer.getFamilyName()+","+farmer.getGivenName());	
		}
	}



	private void copySelectedMember() {
		// if(selectedMember != null){
		// workingCopy = EcoreUtil.copy(selectedMember);
		// }
	}

	protected void saveMember() {
		if (selectedFarm != null) {
			//			MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this, selectedMember);
			//			try {
			//				DairyDemoResourceManager.INSTANCE.saveFarmResource();
			//				DairyDemoResourceManager.INSTANCE.saveDairyResource();
			//				MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
			//			} catch (final IllegalArgumentException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//				Activator.getDefault().logError(e, e.getMessage());
			//			} catch (final IOException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//				Activator.getDefault().logError(e, e.getMessage());
			//
			//			}
		}
	}


}
