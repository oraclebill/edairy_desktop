package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class ViewMemberDialogController extends AddMemberDialogController {

	private ILabelRidget memberName;
	private ILabelRidget memberId;
	private ILabelRidget memberbalance;
	private ILabelRidget memberPhoto;

	protected void configureUpperPanel() {
		memberName = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_NAME_HEADER);
		memberId = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_ID);
		memberbalance = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_BALANCE);
		memberPhoto = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_MEMBER_NAME_PHOTO);
	}

	protected void updateUpperPanelBinding() {
		final Membership selectedMember = getWorkingCopy();
		if (selectedMember != null) {
			memberName.setText("Member Name : " + selectedMember.getMember().getFamilyName() + ","
					+ selectedMember.getMember().getGivenName());
			memberId.setText("Member ID : " + selectedMember.getMemberId());
			memberbalance.setText("Current Balance : ");
		}
	}

	protected void configureButtonsPanel() {
		super.configureButtonsPanel();
		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(true);
	}
}
