//package com.agritrace.edairy.desktop.member.ui.dialog.controller;
//
//import java.util.List;
//
//import org.eclipse.riena.ui.ridgets.IActionRidget;
//
//import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
//import com.agritrace.edairy.desktop.common.model.dairy.Membership;
//import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
//import com.agritrace.edairy.desktop.common.persistence.IMilkCollectionRepository;
//import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
//import com.agritrace.edairy.desktop.common.ui.DialogConstants;
//import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
//import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
//import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
//import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;
//import com.agritrace.edairy.desktop.member.ui.dialog.AddFarmDialog;
//import com.agritrace.edairy.desktop.member.ui.dialog.ViewFarmDialog;
//import com.google.inject.Inject;
//import com.google.inject.Provider;
//
//public class ViewMemberDialogController extends MemberEditDialogController {
////	@Inject	private IFarmRepository farmRepository;
////	@Inject	private IMemberRepository memberRepository;
////	@Inject	private Provider<AddFarmDialog> addDialogProvider;
////	@Inject private Provider<ViewFarmDialog> viewDialogProvider;
////	@Inject private ITransactionRepository transactionRepository;
////	@Inject private IMilkCollectionRepository collectionsRepository;
//
//	// collection tab
//	private MemberCollectionRecordsWidgetController collectionController;
//	// farm tab
//	private MemberFarmWidgetController farmController;
//	// transaction tab
//	private MemberTransactionWidgetController transactionController;
//
//	protected ViewMemberDialogController(List<DairyLocation> centerList) {
//		super(centerList);
//	}
//	
//	@Override
//	protected void configureButtonsPanel() {
//		System.err.println(" ##### configureButtonsPanel");
//		super.configureButtonsPanel();
//		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
//		deleteAction.setVisible(true);
//	}
//
//
//	@Override
//	protected void updateBindings() {
//		System.err.println(" ##### updateBindings");
//		super.updateBindings();
//	}
//
//	@Override
//	protected void configureTabs() {
//		System.err.println(" ##### configureTabs");
//		super.configureTabs();
////		farmController = new MemberFarmWidgetController(this, farmRepository, memberRepository,
////				addDialogProvider, viewDialogProvider);
////		collectionController = new MemberCollectionRecordsWidgetController(this, collectionsRepository);
////		transactionController = new MemberTransactionWidgetController(transactionRepository, this);
//	}
//
//
//	@Override
//	public void afterBind() {
//		System.err.println(" ##### afterBind");
//		super.afterBind();
//		final Membership selectedMember = getWorkingCopy();
//		farmController.setInputModel(selectedMember);
//		collectionController.setInputModel(selectedMember);
//		transactionController.setInputModel(selectedMember);
//	}
//	
//	
//}
