package com.agritrace.edairy.desktop.member.ui.controllers;

import java.io.IOException;
import java.util.Arrays;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.model.SimpleNavigationNodeAdapter;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionListener;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionManager;

public class MemberRegisterViewController extends SubModuleController implements MemberSearchSelectionListener,
		ISelectionListener {

	// private Membership workingCopy;
	private Membership selectedMember;

	// upper panel fields
	private ITextRidget memberIdRidget;
	private IComboRidget comboStatus;
	private ITextRidget phoneRidget;
	private ITextRidget nameRidget;
	private ITextRidget appliedDate;
	private ITextRidget effectiveDate;

	private ITextRidget addressTxt;
	private ITextRidget sectionTxt;
	private ITextRidget estateTxt;
	private ITextRidget locationTxt;
	private ITextRidget subLocationTxt;
	private ITextRidget villageTxt;
	private ITextRidget divisionTxt;
	private ITextRidget districtTxt;
	private IComboRidget provinceComo;
	private ITextRidget postalCodeTxt;

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
		appliedDate = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_applicationDate);
		effectiveDate = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_effectiveDate);
		comboStatus = getRidget(IComboRidget.class, ViewWidgetId.memberInfo_status);
		comboStatus.bindToModel(Observables.staticObservableList(MembershipStatus.VALUES), MembershipStatus.class,
				null, new WritableValue());
		comboStatus.updateFromModel();
		comboStatus.addSelectionListener(this);
		phoneRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_phone);
		nameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_firstName);

		addressTxt = getRidget(ITextRidget.class, ViewWidgetId.ADDRESS_TXT);
		sectionTxt = getRidget(ITextRidget.class, ViewWidgetId.SECTION_TXT);
		estateTxt = getRidget(ITextRidget.class, ViewWidgetId.ESTATE_TXT);
		locationTxt = getRidget(ITextRidget.class, ViewWidgetId.LOCATION_TXT);
		subLocationTxt = getRidget(ITextRidget.class, ViewWidgetId.SUBLOCATION_TXT);
		villageTxt = getRidget(ITextRidget.class, ViewWidgetId.VILLAGE_TXT);
		divisionTxt = getRidget(ITextRidget.class, ViewWidgetId.DIVISION_TXT);
		districtTxt = getRidget(ITextRidget.class, ViewWidgetId.DISTRICT_TXT);
		// provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
		postalCodeTxt = getRidget(ITextRidget.class, ViewWidgetId.POSTAL_CODE_TXT);
		provinceComo = getRidget(IComboRidget.class, ViewWidgetId.PROVINCE_TXT);
		provinceComo.bindToModel(Observables.staticObservableList(Arrays.asList(ViewWidgetId.PROVINCES_LIST)),
				String.class, null, new WritableValue());
		provinceComo.updateFromModel();
		provinceComo.addSelectionListener(this);

	}



	private void configureTransactionTab() {
	

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
		comboStatus = getRidget(IComboRidget.class, ViewWidgetId.memberInfo_status);
		comboStatus.updateFromModel();
		comboStatus.setSelection(selectedMember.getStatus().getValue());
		phoneRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),
				ModelPackage.Literals.PERSON__PHONE_NUMBER));
		phoneRidget.updateFromModel();
		nameRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),
				ModelPackage.Literals.PERSON__FAMILY_NAME));
		nameRidget.updateFromModel();

		final SimpleFormattedDateBean bean = new SimpleFormattedDateBean();
		if (selectedMember.getApplicationDate() != null) {
			bean.setDate(selectedMember.getApplicationDate());
		}
		appliedDate.setText(bean.getFormattedDate());

		if (selectedMember.getEffectiveDate() != null) {
			bean.setDate(selectedMember.getEffectiveDate());
		} else {
			bean.setFormattedDate("");
		}
		effectiveDate.setText(bean.getFormattedDate());

		if (selectedMember.getMember().getLocation() != null) {
			final PostalLocation location = selectedMember.getMember().getLocation().getPostalLocation();

			addressTxt.bindToModel(EMFObservables
					.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__ADDRESS));
			addressTxt.updateFromModel();
			sectionTxt.bindToModel(EMFObservables
					.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__SECTION));
			sectionTxt.updateFromModel();
			estateTxt.bindToModel(EMFObservables.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__ESTATE));
			estateTxt.updateFromModel();
			locationTxt.bindToModel(EMFObservables.observeValue(location,
					ModelPackage.Literals.POSTAL_LOCATION__LOCATION));
			locationTxt.updateFromModel();
			subLocationTxt.bindToModel(EMFObservables.observeValue(location,
					ModelPackage.Literals.POSTAL_LOCATION__SUB_LOCATION));
			subLocationTxt.updateFromModel();
			villageTxt.bindToModel(EMFObservables
					.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__VILLAGE));
			villageTxt.updateFromModel();
			divisionTxt.bindToModel(EMFObservables.observeValue(location,
					ModelPackage.Literals.POSTAL_LOCATION__DIVISION));
			divisionTxt.updateFromModel();
			districtTxt.bindToModel(EMFObservables.observeValue(location,
					ModelPackage.Literals.POSTAL_LOCATION__DISTRICT));
			districtTxt.updateFromModel();
			provinceComo.setSelection(location.getProvince());
			postalCodeTxt.bindToModel(EMFObservables.observeValue(location,
					ModelPackage.Literals.POSTAL_LOCATION__POSTAL_CODE));
			postalCodeTxt.updateFromModel();
		}
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
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == comboStatus) {
			if (selectedMember != null) {
				selectedMember.setStatus((MembershipStatus) event.getNewSelection().get(0));
			}
		} else if (event.getSource() == provinceComo) {
			if (selectedMember != null && selectedMember.getMember() != null
					&& selectedMember.getMember().getLocation() != null) {
				final PostalLocation location = selectedMember.getMember().getLocation().getPostalLocation();
				if (location != null) {
					location.setProvince((String) event.getNewSelection().get(0));
				}
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
