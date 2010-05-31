package com.agritrace.edairy.desktop.member.ui.controllers;

import java.io.IOException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionListener;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionManager;

public class MemberRegisterViewController extends SubModuleController implements MemberSearchSelectionListener{

	// private Membership workingCopy;
	private Membership selectedMember;
	
	private String generatedMemberId;

	// upper panel fields
	private ILabelRidget memberIdRidget;
	private ITextRidget nameRidget;
	
	MemberProfileWidgetController memberProfileController;

	// container tab
	MemberContainerWidgetController containerController;

	// live stock tab
	MemberLiveStockWidgetController liveStockController;

	// farm tab
	MemberFarmWidgetController farmController;

	// collection tab
	MemberCollectionRecordsWidgetController collectionController;
	// transaction tab
	MemberTransactionWidgetController transactionController;

	public MemberRegisterViewController() {
		MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
	}

	@Override
	public void configureRidgets() {
		getNavigationNode().addSimpleListener(new MemberSearchNodeListern());
		configureUpperPanel();
		memberProfileController = new MemberProfileWidgetController(this);
		farmController = new MemberFarmWidgetController(this);
		collectionController = new MemberCollectionRecordsWidgetController(this);
		liveStockController = new MemberLiveStockWidgetController(this);
		containerController = new MemberContainerWidgetController(this);
		transactionController = new MemberTransactionWidgetController(this);
		
		if (selectedMember != null) {
			updateBindings();
		}

		// search button
		((IActionRidget) getRidget(ViewWidgetId.memberInfo_searchButton)).addListener(new IActionListener() {
			@Override
			public void callback() {
				// saveMember();
				MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(true);
			}
		});

		// save button
		((IActionRidget) getRidget(ViewWidgetId.memberInfo_saveButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				saveMember();
				// MemberSearchSelectionManager.INSTANCE.getSearchNode().showView(false);
			}
		});
		// cancel button
		((IActionRidget) getRidget(ViewWidgetId.memberInfo_cacelButton)).addListener(new IActionListener() {

			@Override
			public void callback() {
				if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Cacel modificatin ",
						"Do you want to cacel membership modification?")) {
					MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
				}
			}
		});
	}

	private void configureUpperPanel() {
		memberIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberInfo_id);
		generatedMemberId = System.currentTimeMillis()+"";
		memberIdRidget.setText(generatedMemberId);
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

	private void updateUpperPanelBinding() {
		
		if(selectedMember.getMember() != null){
			nameRidget.setText(selectedMember.getMember().getFamilyName()+","+selectedMember.getMember().getGivenName());	
		}
		
//		nameRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),
//				ModelPackage.Literals.PERSON__FAMILY_NAME));
//		nameRidget.updateFromModel();

	}

	@Override
	public void memberSelectionChanged(Membership selectedMember) {
		if (this.selectedMember != selectedMember) {
			this.selectedMember = selectedMember;
			copySelectedMember();
		}
		updateBindings();
	}

	@Override
	public void memberModified(Membership modifiedMember) {
		this.selectedMember = modifiedMember;
		updateBindings();
	}

	private void copySelectedMember() {
		// if(selectedMember != null){
		// workingCopy = EcoreUtil.copy(selectedMember);
		// }
	}

	protected void saveMember() {
		if (selectedMember != null) {
			MemberSearchSelectionManager.INSTANCE.notifySelectionModified(this, selectedMember);
			try {
				DairyDemoResourceManager.INSTANCE.saveFarmResource();
				DairyDemoResourceManager.INSTANCE.saveDairyResource();
				MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
			} catch (final IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Activator.getDefault().logError(e, e.getMessage());
			} catch (final IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Activator.getDefault().logError(e, e.getMessage());

			}
		}
	}


	@Override
	public void refreshView(String viewId) {
		// empty;

	}

	private class MemberSearchNodeListern extends SimpleNavigationNodeAdapter {

		@Override
		public void activated(INavigationNode<?> source) {
			if (selectedMember != null) {
				updateBindings();
			}

		}

		@Override
		public void deactivated(INavigationNode<?> source) {

		}

		@Override
		public void disposed(INavigationNode<?> source) {

		}
	}
	

	public Membership getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedMember(Membership selectedMember) {
		this.selectedMember = selectedMember;
	}
	
}
