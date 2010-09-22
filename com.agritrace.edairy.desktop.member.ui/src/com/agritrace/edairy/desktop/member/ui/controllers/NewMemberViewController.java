package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class NewMemberViewController extends MemberRegisterViewController {
	@Inject
	public NewMemberViewController(final IFarmRepository farmRepository,
			final IMemberRepository memberRepository,
			final Provider<AddFarmDialog> addDialogProvider, final Provider<ViewFarmDialog> viewDialogProvider) {
		super(farmRepository, memberRepository, addDialogProvider, viewDialogProvider);
	}

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
