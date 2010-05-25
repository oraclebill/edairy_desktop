package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;



public class ViewMemberDialogController extends MemberRegisterDialogController {
	
	private ILabelRidget memberName;
	private ILabelRidget memberId;
	private ILabelRidget memberbalance;
	private ILabelRidget memberPhoto;
	
	protected  void configureUpperPanel() {
		memberName = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_NAME_HEADER);
		memberId = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_ID);
		memberbalance = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_BALANCE);
		memberPhoto = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_NAME_PHOTO);

	}
	
	protected void updateUpperPanelBinding() {
		if( selectedMember != null){
			memberName.setText("Member Name : "+selectedMember.getMember().getFamilyName()+","+selectedMember.getMember().getGivenName());
			memberId.setText("Member ID : "+selectedMember.getMemberId());
			memberbalance.setText("Current Balance : ");
		}
	}
	
	protected void configureButtonsPanel(){
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(ViewWidgetId.deleteButton);
		deleteAction.setVisible(true);
	}
}
