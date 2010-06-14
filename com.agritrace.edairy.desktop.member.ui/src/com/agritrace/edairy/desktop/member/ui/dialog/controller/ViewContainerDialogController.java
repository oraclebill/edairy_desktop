package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.ui.core.marker.ErrorMessageMarker;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.converters.NumberToStringConverter;
import com.agritrace.edairy.desktop.member.ui.Activator;
import com.agritrace.edairy.desktop.member.ui.ControllerContextConstant;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class ViewContainerDialogController extends BaseDialogController<Farm> implements ISelectionListener {

	ILabelRidget idLabel;

	IComboRidget typeCombo;

	IComboRidget farmCombo;

	IComboRidget unitCombo;

	ITextRidget capacity;

	Container selectedContainer;

	List<Farm> farmList;

	IActionRidget okAction;

	Double capacityValue;

	ErrorMessageMarker capactiyError = new ErrorMessageMarker("Invalid number");

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
		capacity.setModelToUIControlConverter(new NumberToStringConverter(Double.class));
		capacity.setMandatory(true);
		capacity.setDirectWriting(true);
		selectedContainer = (Container) getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_SELECTED_CONTAINER);
		farmList = (List<Farm>) getContext(ControllerContextConstant.CONTAINER_DIALOG_CONTXT_FARM_LIST);
		okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		okAction.setEnabled(true);

		if (selectedContainer != null) {
			if(selectedContainer.getContainerId() != null){
				idLabel.setText(selectedContainer.getContainerId().toString());
			}else{
				idLabel.setText("<auto>");
			}
			
			capacity.bindToModel(selectedContainer,	TrackingPackage.Literals.CONTAINER__CAPACITY.getName());
			capacity.updateFromModel();
			capacity.addValidationRule(new IValidator() {

				@Override
				public IStatus validate(Object arg0) {
					String value = (String) arg0;
					try {
						capacityValue = Double.valueOf(value);
						capacity.removeAllMarkers();
						okAction.setEnabled(true);
					} catch (NumberFormatException ex) {
						capacity.addMarker(capactiyError);
						okAction.setEnabled(false);
						return new Status(Status.ERROR, Activator.PLUGIN_ID, ex.getMessage(), ex);

					}
					return Status.OK_STATUS;
				}

			}, ValidationTime.ON_UI_CONTROL_EDIT);

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
				} else if(farmList.size()>0){
					farmCombo.setSelection(0);
				}
			}

			unitCombo.bindToModel(Observables.staticObservableList(UnitOfMeasure.VALUES), UnitOfMeasure.class, null,
					new WritableValue());
			unitCombo.updateFromModel();
			unitCombo.addSelectionListener(this);
			unitCombo.setSelection(selectedContainer.getMeasureType());

			typeCombo.bindToModel(Observables.staticObservableList(ContainerType.VALUES), ContainerType.class, null,
					new WritableValue());
			typeCombo.updateFromModel();
			typeCombo.addSelectionListener(this);
			typeCombo.setSelection(selectedContainer.getType());
		}
		configureButtonsPanel();

	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == unitCombo) {
			if (selectedContainer != null) {
				selectedContainer.setMeasureType((UnitOfMeasure) unitCombo.getSelection());
			}
		} else if (event.getSource() == typeCombo) {
			if (selectedContainer != null) {
				selectedContainer.setType((ContainerType) typeCombo.getSelection());
			}
		} else if (event.getSource() == farmCombo) {
			if (selectedContainer != null) {
				selectedContainer.setOwner((Farm) farmCombo.getSelection());
			}
		}

	}

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

}
