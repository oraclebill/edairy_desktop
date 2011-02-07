package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.util.ArrayList;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ContainerEditDialogController extends RecordDialogController<Container> {

	// Label idLabelValue ViewWidgetId.VIEW_CONTAINER_ID
	// Text searchText ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT
	// ImageButton lookupButton ViewWidgetId.FARM_LIST_SEARCH_BUTTON
	// CCombo farmCombo ViewWidgetId.VIEW_CONTAINER_FARM
	// CCombo measureCombo ViewWidgetId.VIEW_CONTAINER_UNIT
	// Text capacityText ViewWidgetId.VIEW_CONTAINER_COMPACITY

	final private Provider<MemberSearchDialog> memberSearchProvider;
	final private IObservableList farmList;

	private ITextRidget memberNameText;
	private IComboRidget farmCombo;

	@Inject
	public ContainerEditDialogController(final Provider<MemberSearchDialog> memberSearchProvider) {
		super("Milk Container");
		this.memberSearchProvider = memberSearchProvider;
		farmList = new WritableList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController#configureUserRidgets()
	 */
	@Override
	protected void configureUserRidgets() {
		memberNameText = getRidget(ITextRidget.class, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		memberNameText.setOutputOnly(true);
		getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON).addListener(new IActionListener() {
			@Override
			public void callback() {
				final MemberSearchDialog memberDialog = memberSearchProvider.get();
				if (memberDialog.open() == Window.OK) {
					updateMember(memberDialog.getSelectedMember());
				}
			}
		});
		farmCombo = getRidget(IComboRidget.class, ViewWidgetId.VIEW_CONTAINER_FARM);
		farmCombo.bindToModel(farmList, Farm.class, "getName", 
				BeansObservables.observeValue(getWorkingCopy(), "owner"));

		addTextMap(ViewWidgetId.VIEW_CONTAINER_COMPACITY, TrackingPackage.Literals.CONTAINER__CAPACITY);
//		addComboMap(ViewWidgetId.VIEW_CONTAINER_FARM, farmList, "getName", TrackingPackage.Literals.CONTAINER__OWNER);
		addComboMap(ViewWidgetId.VIEW_CONTAINER_UNIT, UnitOfMeasure.VALUES, "getName",
				TrackingPackage.Literals.CONTAINER__MEASURE_TYPE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController#afterBind()
	 */
	@Override
	public void afterBind() {
		Container selectedContainer = getWorkingCopy();
		Farm farm = selectedContainer.getOwner();
		Farmer farmer = (farm == null) ? null : farm.getOwner();

		getRidget(ILabelRidget.class, ViewWidgetId.VIEW_CONTAINER_ID).setText(
				selectedContainer.getTrackingNumber() == null ? "<new>" : selectedContainer.getTrackingNumber());

		updateMember(farmer != null ? farmer.getMembership() : null);
		
		if (farm != null || farmer != null) {
			memberNameText.setEnabled(false);
			getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON).setEnabled(false);
		}
		if (farm != null) {
			farmCombo.setEnabled(false);
		}

		super.afterBind();
	}

	protected void updateMember(Membership membership) {
		if (membership != null) {
			memberNameText.setText(membership.getFarmer().getFormattedName());
			farmList.clear();
			farmList.addAll(membership.getFarmer().getFarms());
			System.err.println("ADDING: " + membership.getFarmer().getFarms());
			System.err.println("ADDING: " + membership.getFarmer().getFarms().size());
			farmCombo.updateFromModel();
			farmCombo.setSelection(farmCombo.getEmptySelectionItem());
		} else {
			memberNameText.setText("");
			farmList.clear();
		}
	}
}
