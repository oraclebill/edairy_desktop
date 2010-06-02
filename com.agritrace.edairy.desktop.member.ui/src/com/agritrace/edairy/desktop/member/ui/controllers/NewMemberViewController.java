package com.agritrace.edairy.desktop.member.ui.controllers;

import java.io.IOException;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionManager;

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
