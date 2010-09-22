package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;
import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ViewMemberDialogController extends AddMemberDialogController {
	// TODO: Get rid of static injection here
	@Inject	private static IFarmRepository farmRepository;
	@Inject	private static IMemberRepository memberRepository;
	@Inject	private static Provider<AddFarmDialog> addDialogProvider;
	@Inject private static Provider<ViewFarmDialog> viewDialogProvider;
	
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
		farmController = new MemberFarmWidgetController(this, farmRepository, memberRepository,
				addDialogProvider, viewDialogProvider);
		collectionController = new MemberCollectionRecordsWidgetController(this);
		transactionController = new MemberTransactionWidgetController(this);
	}
}
