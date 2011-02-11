package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.core.marker.ErrorMessageMarker;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupDialog;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ViewContainerDialogController extends BaseDialogController<Farm> implements ISelectionListener {

	public static final String FARM_MEMBER_NAME_LABEL_PREFIX = "Member Name :";

	ITextRidget capacity;
	Double capacityValue;
	ErrorMessageMarker capactiyError = new ErrorMessageMarker("Invalid number");
	IComboRidget farmCombo;
	List<Farm> farmList;
	ILabelRidget idLabel;
	IActionRidget okAction;
	Container selectedContainer;
	Farmer selectedMember;
	IComboRidget typeCombo;
	IComboRidget unitCombo;
	ITextRidget memberNameRidget;
	IActionRidget memberLookupBtn;
	private boolean enableLookupBtn;

	private final Provider<MemberLookupDialog> memberSearchProvider;

	@Inject
	public ViewContainerDialogController(final Provider<MemberLookupDialog> memberSearchProvider) {
		this.memberSearchProvider = memberSearchProvider;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void configureRidgets() {
		super.configureRidgets();

		idLabel = getRidget(ILabelRidget.class, ViewWidgetId.VIEW_CONTAINER_ID);
		typeCombo = getRidget(IComboRidget.class, ViewWidgetId.VIEW_CONTAINER_TYPE);
		farmCombo = getRidget(IComboRidget.class, ViewWidgetId.VIEW_CONTAINER_FARM);
		farmCombo.setMandatory(true);
		unitCombo = getRidget(IComboRidget.class, ViewWidgetId.VIEW_CONTAINER_UNIT);
		capacity = getRidget(ITextRidget.class, ViewWidgetId.VIEW_CONTAINER_COMPACITY);
		capacity.setModelToUIControlConverter(NumberToStringConverter.fromDouble(true));
		capacity.setMandatory(true);
		capacity.setDirectWriting(true);
		okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		okAction.setEnabled(true);

		memberNameRidget = getRidget(ITextRidget.class, ViewWidgetId.FARM_LIST_MEMBER_LOOKUP_TXT);
		memberNameRidget.setOutputOnly(true);
		memberNameRidget.setMandatory(true);
		memberNameRidget.setDirectWriting(true);
		memberLookupBtn = getRidget(IActionRidget.class, ViewWidgetId.FARM_LIST_SEARCH_BUTTON);
		memberLookupBtn.addListener(new MemberLookupAction());

		capacity.addValidationRule(new IValidator() {

			@Override
			public IStatus validate(Object arg0) {
				final String value = (String) arg0;
				try {
					capacityValue = Double.valueOf(value);
					capacity.removeAllMarkers();
					okAction.setEnabled(true);
				} catch (final NumberFormatException ex) {
					capacity.addMarker(capactiyError);
					okAction.setEnabled(false);
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getMessage(), ex);

				}
				return Status.OK_STATUS;
			}
		}, ValidationTime.ON_UI_CONTROL_EDIT);
		
		// Get selected member from context
		selectedMember = null;
		final Object selected = getContext(ControllerContextConstant.MEMBER_DIALOG_CONTXT_SELECTED_MEMBER);
		if (selected instanceof Membership) {
			selectedMember = ((Membership) selected).getFarmer();
		} else if (selected instanceof Farmer) {
			selectedMember = (Farmer) selected;
		}		
		
		// if dialog initialized with a member, populate text and disable lookup
		if (selectedMember != null) {
			memberNameRidget.setText(MemberUtil.formattedMemberName(selectedMember));
			memberLookupBtn.setEnabled(true);			
			// farms should have been set by caller to the list associated with the selected member...
			farmList = (List<Farm>) getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST);
			if (null == farmList || farmList.size() == 0) {
				Logger.getLogger(this.getClass().getName()).warning("WARNING: farmlist should not be null if member selected");
				System.err.println("WARNING: farmlist should not be null if member selected");				
			}
		}
				
		selectedContainer = (Container) getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
		if (selectedContainer != null) {
			if (selectedContainer.getContainerId() != null) {
				idLabel.setText(selectedContainer.getContainerId().toString());
			} else {
				idLabel.setText("<auto>");
			}

			capacity.bindToModel(selectedContainer, TrackingPackage.Literals.CONTAINER__CAPACITY.getName());
			capacity.updateFromModel();

			if (farmList == null && selectedContainer.getOwner() != null) {
				farmList = new ArrayList<Farm>();
				farmList.add(selectedContainer.getOwner());
			}
			
			if (farmList != null) {
				farmCombo.bindToModel(new WritableList(farmList, Farm.class), Farm.class, "getName",
						new WritableValue());
				farmCombo.updateFromModel();
				farmCombo.addSelectionListener(this);
				if (selectedContainer.getOwner() != null) {
					farmCombo.setSelection(selectedContainer.getOwner());
				} else if (farmList.size() > 0) {
					farmCombo.setSelection(0);
				}
			}

			unitCombo.bindToModel(Observables.staticObservableList(UnitOfMeasure.VALUES), UnitOfMeasure.class, null,
					new WritableValue());
			unitCombo.updateFromModel();
			unitCombo.addSelectionListener(this);
			unitCombo.setSelection(selectedContainer.getMeasureType());

// typeCombo.bindToModel(Observables.staticObservableList(ContainerType.VALUES), ContainerType.class, null,
// new WritableValue());
// typeCombo.updateFromModel();
// typeCombo.addSelectionListener(this);
// typeCombo.setSelection(selectedContainer.getType());
		}
		configureButtonsPanel();

	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == unitCombo) {
			if (selectedContainer != null) {
				selectedContainer.setMeasureType((UnitOfMeasure) unitCombo.getSelection());
			}
// } else if (event.getSource() == typeCombo) {
// if (selectedContainer != null) {
// selectedContainer.setType((ContainerType) typeCombo.getSelection());
// }
		} else if (event.getSource() == farmCombo) {
			if (selectedContainer != null) {
				selectedContainer.setOwner((Farm) farmCombo.getSelection());
				enableSaveButton(validate());
			}
		}

	}

	@Override
	protected void configureButtonsPanel() {

		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(OK);
				setContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER, selectedContainer);
				getWindowRidget().dispose();
			}
		});
		final IActionRidget cancelAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_CANCEL);
		cancelAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(CANCEL);
				getWindowRidget().dispose();
			}
		});

		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(true);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				setReturnCode(2);
				getWindowRidget().dispose();
			}
		});
	}

	/**
	 * Open member search dialog, IActionListener for search button
	 * 
	 */
	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberLookupDialog memberDialog = memberSearchProvider.get();
			;
			final int retVal = memberDialog.open();

			if (retVal == Window.OK) {
				final Membership memberShip = memberDialog.getSelectedMember();

				if (memberShip != null) {
					final String memberName = memberShip.getFarmer().getFormattedName();
					memberNameRidget.setText(memberName);
					farmList.clear();
					farmList.addAll(memberShip.getFarmer().getFarms());
					farmCombo.updateFromModel();
					farmCombo.setSelection(farmCombo.getEmptySelectionItem());
					enableSaveButton(false);
				}

			}
		}
	}

}
