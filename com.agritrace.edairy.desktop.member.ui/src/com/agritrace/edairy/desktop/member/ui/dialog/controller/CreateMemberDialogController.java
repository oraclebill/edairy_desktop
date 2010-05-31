package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;

public class CreateMemberDialogController extends AbstractWindowController{

	public static final String DIALOG_TITLE = "Membership";
	
	private String generatedMemberId;

	protected Membership selectedMember;

	// upper panel fields
	private ILabelRidget memberIdRidget;
	private ITextRidget nameRidget;

	private MemberProfileWidgetController memberProfileController;

	// container tab
	private MemberContainerWidgetController containerController;

	// live stock tab
	private MemberLiveStockWidgetController liveStockController;

	// farm tab
	private MemberFarmWidgetController farmController;

	// collection tab
	private MemberCollectionRecordsWidgetController collectionController;
	
	// transaction tab
	private MemberTransactionWidgetController transactionController;

	private MemberRepository repository;

	public CreateMemberDialogController() {

	}
	
	public MemberRepository getRepository() {
		return repository;
	}

	public void setRepository(MemberRepository repository) {
		this.repository = repository;
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		selectedMember = (Membership) getContext("selectedMember");

		configureUpperPanel();
		
		memberProfileController = new MemberProfileWidgetController(this);
		farmController 			= new MemberFarmWidgetController(this);
		collectionController 	= new MemberCollectionRecordsWidgetController(this);
		liveStockController 	= new MemberLiveStockWidgetController(this);
		containerController 	= new MemberContainerWidgetController(this);
		transactionController 	= new MemberTransactionWidgetController(this);

		if (selectedMember != null) {
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
				setContext("selectedMember",selectedMember);
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
		memberIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberInfo_id);
//		generatedMemberId = System.currentTimeMillis()+"";
//		memberIdRidget.setText(generatedMemberId);
		nameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_firstName);

	}

	private void updateBindings() {
		updateUpperPanelBinding();
		memberProfileController.setInputModel(selectedMember);
		farmController.setInputModel(selectedMember);
		collectionController.setInputModel(selectedMember);
		liveStockController.setInputModel(selectedMember);		
		containerController.setInputModel(selectedMember);
		transactionController.setInputModel(selectedMember);
	}

	protected void updateUpperPanelBinding() {
		if(selectedMember.getMember() != null){
			memberIdRidget.bindToModel(EMFObservables.observeValue(selectedMember,	DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
			memberIdRidget.updateFromModel();
			nameRidget.setText(selectedMember.getMember().getFamilyName()+","+selectedMember.getMember().getGivenName());	
		}
	}



	private void copySelectedMember() {
		// if(selectedMember != null){
		// workingCopy = EcoreUtil.copy(selectedMember);
		// }
	}

	protected void saveMember() {
		if (selectedMember != null) {
			repository.update(selectedMember);

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



	public Membership getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedMember(Membership selectedMember) {
		this.selectedMember = selectedMember;
	}

}