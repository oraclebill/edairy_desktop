package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;

public class ViewMemberDialogController extends AddMemberDialogController {

//	private ILabelRidget memberbalance;
//	private ILabelRidget memberId;
//	private ILabelRidget memberName;
//	private ILabelRidget memberPhoto;
	
	// collection tab
	private MemberCollectionRecordsWidgetController collectionController;
	// farm tab
	private MemberFarmWidgetController farmController;
	
	// transaction tab
	private MemberTransactionWidgetController transactionController;

	@Override
	protected void configureButtonsPanel() {
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(true);
	}

//	@Override
//	protected void configureUpperPanel() {
//		memberName = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_NAME_HEADER);
//		memberId = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_ID);
//		memberbalance = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_BALANCE);
//		memberPhoto = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_NAME_PHOTO);
//	}

//	@Override
//	protected void updateUpperPanelBinding() {
//		final Membership selectedMember = getWorkingCopy();
//		if (selectedMember != null) {
//			memberName.setText("Member Name : " + selectedMember.getMember().getFamilyName() + ","
//					+ selectedMember.getMember().getGivenName());
//			memberId.setText("Member ID : " + selectedMember.getMemberId());
//			memberbalance.setText("Current Balance : ");
//		}
//	}
	
	protected void updateBindings() {
		super.updateBindings();
		final Membership selectedMember = getWorkingCopy();
		farmController.setInputModel(selectedMember);
		collectionController.setInputModel(selectedMember);
		transactionController.setInputModel(selectedMember);
	}
	
	@Override
	protected void configureTabs() {
		super.configureTabs();
		farmController = new MemberFarmWidgetController(this);
		collectionController = new MemberCollectionRecordsWidgetController(this);
		transactionController = new MemberTransactionWidgetController(this);
	}
	
	
}
