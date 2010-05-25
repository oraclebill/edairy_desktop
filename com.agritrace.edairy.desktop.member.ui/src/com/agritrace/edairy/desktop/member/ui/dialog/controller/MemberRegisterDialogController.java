package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberCollectionRecrodsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberLiveStockController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberTransactionWidgetController;

public class MemberRegisterDialogController extends AbstractWindowController{

	public static final String DIALOG_TITLE = "Membership";

	private Membership selectedMember;

	// upper panel fields
	private ITextRidget memberIdRidget;
	private ITextRidget nameRidget;

	MemberProfileWidgetController memberProfileController;

	// container tab
	MemberContainerWidgetController containerController;

	// live stock tab
	MemberLiveStockController liveStockController;

	// farm tab
	MemberFarmWidgetController farmController;

	// collection tab
	MemberCollectionRecrodsWidgetController collectionController;
	// transaction tab
	MemberTransactionWidgetController transactionController;

	public MemberRegisterDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		selectedMember = (Membership) getContext("selectedMember");

		configureUpperPanel();
		farmController = new MemberFarmWidgetController(this);
		collectionController = new MemberCollectionRecrodsWidgetController(this);
		liveStockController = new MemberLiveStockController(this);
		containerController = new MemberContainerWidgetController(this);
		transactionController = new MemberTransactionWidgetController(this);

		if (selectedMember != null) {
			updateBindings();
		}

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
	}

	private void configureUpperPanel() {
		memberIdRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_id);
		nameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_firstName);
		memberProfileController = new MemberProfileWidgetController(this);

	}

	private void updateBindings() {
		updateUpperPanelBinding();
		farmController.setInputModel(selectedMember);
		collectionController.setInputModel(selectedMember);
		liveStockController.setInputModel(selectedMember);		
		containerController.setInputModel(selectedMember);
		transactionController.setInputModel(selectedMember);
	}

	private void updateUpperPanelBinding() {
		memberIdRidget.bindToModel(EMFObservables.observeValue(selectedMember,
				DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
		memberIdRidget.updateFromModel();

		if(selectedMember.getMember() != null){
			nameRidget.setText(selectedMember.getMember().getFamilyName()+","+selectedMember.getMember().getGivenName());	
		}
		memberProfileController.setInputModel(selectedMember);
	}



	private void copySelectedMember() {
		// if(selectedMember != null){
		// workingCopy = EcoreUtil.copy(selectedMember);
		// }
	}

	protected void saveMember() {
		if (selectedMember != null) {
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
