package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class NewMemberViewController extends MemberRegisterViewController {
	
	@Override
	public void configureRidgets() {
		super.configureRidgets();
		((IActionRidget) getRidget(ViewWidgetId.memberInfo_searchButton)).setVisible(false);

	}

	@Override
	protected void saveMember() {
		super.getMemberRepository().saveNew(getSelectedMember());
	}

}
