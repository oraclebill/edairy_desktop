package com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.INumericTextRidget;
import org.eclipse.riena.ui.ridgets.ISpinnerRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.IAssetInfoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.VehicleType;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controls.VehicleLogDetailBindConstants;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class VehicleEditDialogController  extends RecordDialogController<Vehicle> {
	private Vehicle editVehicle = null;
	

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editVehicle = getWorkingCopy();
		assert (null != editVehicle);
		bindVehicleInfo();
		bindAssetInfo();
	
	}
	
	private void bindVehicleInfo() {

		// Log Book Number
		final ITextRidget logNumber = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_LOG_NUM);
		logNumber.setDirectWriting(true);
		logNumber.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER.getName());
		logNumber.updateFromModel();

		// Driver Name Name
		final IComboRidget lastNameText = getRidget(IComboRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DRIVER_NAME);
		lastNameText.bindToModel(new WritableList(DairyRepository.getInstance().employeesByPosition("Driver"), Employee.class),
				Employee.class, "getFamilyName",
				EMFObservables.observeValue(editVehicle, DairyPackage.Literals.VEHICLE__DRIVER));
		lastNameText.updateFromModel();

		// Vehicle Type
		final IComboRidget vehicleTypeCombo = getRidget(IComboRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_VEHICLE_TYPE);
		vehicleTypeCombo.bindToModel(new WritableList(VehicleType.getValues(), String.class), String.class, null,
				EMFObservables.observeValue(editVehicle, DairyPackage.Literals.VEHICLE__TYPE));
		vehicleTypeCombo.updateFromModel();

		// Registration Number
		final ITextRidget regText = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_REG_NUM);
		regText.setDirectWriting(true);
		regText.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER.getName());
		regText.updateFromModel();
		//
		// Chassis Number
		final ITextRidget chasisText = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_CHASSIS_NUM);
		chasisText.setDirectWriting(true);
		chasisText.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__CHASSIS_NUMBER.getName());
		chasisText.updateFromModel();

		// Engine Number
		final ITextRidget engineNumber = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_ENGINE_NUM);
		engineNumber.setDirectWriting(true);
		engineNumber.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__ENGINE_NUMBER.getName());
		engineNumber.updateFromModel();

		// Description Group
		// Make
		final ITextRidget makeText = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DESC_MAKE);
		makeText.setDirectWriting(true);
		makeText.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__MAKE.getName());
		makeText.updateFromModel();

		// Model
		final ITextRidget modelText = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DESC_MODEL);
		modelText.setDirectWriting(true);
		modelText.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__MODEL.getName());
		modelText.updateFromModel();

		// Color
		final ITextRidget colorText = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DESC_COLOR);
		colorText.setDirectWriting(true);
		colorText.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__DOMINANT_COLOUR.getName());
		colorText.updateFromModel();

		// Year
		final ISpinnerRidget yearText = getRidget(ISpinnerRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DESC_YEAR);
		// yearText.setDirectWriting(true);
		yearText.setMaximum(2100);
		yearText.setMinimum(1900);
		yearText.setModelToUIControlConverter(StringToNumberConverter.toBigInteger());
		yearText.bindToModel(EMFObservables.observeValue(editVehicle, DairyPackage.Literals.VEHICLE__YEAR)); // resolves
																												// strange
																												// cce
																												// in
																												// binding
																												// code...
		yearText.updateFromModel();

		// Capacity
		final INumericTextRidget capacityText = getRidget(INumericTextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DESC_CAPACITY);
		capacityText.setDirectWriting(true);
		capacityText.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__CAPACITY_IN_TONNES.getName());
		capacityText.updateFromModel();

		// Insurance Info
		// Insurance Number
		final ITextRidget insuranceNumberText = getRidget(ITextRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_INSURANCE_NUMBER);
		insuranceNumberText.setDirectWriting(true);
		insuranceNumberText.bindToModel(editVehicle,
				DairyPackage.Literals.VEHICLE__INSURANCE_POLICY_NUMBER.getName());
		insuranceNumberText.updateFromModel();

		// Expiration Date
		final IDateTimeRidget expDateText = getRidget(IDateTimeRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_INSURANCE_EXP_DATE);
		expDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		// expDateText.setDirectWriting(true);
		expDateText.bindToModel(editVehicle, DairyPackage.Literals.VEHICLE__INSURANCE_EXPIRATION_DATE.getName());
		expDateText.updateFromModel();
	}
	
	private void bindAssetInfo() {
		IAssetInfoRidget assetInfo = getRidget(IAssetInfoRidget.class, IAssetInfoRidget.WIDGET_ID);
		assetInfo.bindToModel(PojoObservables.observeValue(editVehicle, "assetInfo"));
		assetInfo.updateFromModel();
	}




	@Override
	public Vehicle getWorkingCopy() {
		return (Vehicle) getContext("editObject");
	}

	@Override
	public void afterBind() {
		super.afterBind();
	}
}
