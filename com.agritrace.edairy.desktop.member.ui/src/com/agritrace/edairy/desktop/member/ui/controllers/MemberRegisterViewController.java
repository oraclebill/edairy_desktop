package com.agritrace.edairy.desktop.member.ui.controllers;

import java.io.IOException;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionListener;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionManager;

public class MemberRegisterViewController extends SubModuleController implements MemberSearchSelectionListener{

	// private Membership workingCopy;
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

	public MemberRegisterViewController() {
		MemberSearchSelectionManager.INSTANCE.addSearchSelectionListener(this);
	}

	@Override
	public void configureRidgets() {
		getNavigationNode().addSimpleListener(new MemberSearchNodeListern());
		configureUpperPanel();
		farmController = new MemberFarmWidgetController(this);
		collectionController = new MemberCollectionRecrodsWidgetController(this);
		liveStockController = new MemberLiveStockController(this);
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
		
//		nameRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),
//				ModelPackage.Literals.PERSON__FAMILY_NAME));
//		nameRidget.updateFromModel();

		memberProfileController.setInputModel(selectedMember);
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
