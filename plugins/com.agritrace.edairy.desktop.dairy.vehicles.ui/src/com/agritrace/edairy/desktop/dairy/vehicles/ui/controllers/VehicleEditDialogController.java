package com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.StringToNumberConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.ISpinnerRidget;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.IAssetInfoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.VehicleType;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controls.VehicleLogDetailBindConstants;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;

public class VehicleEditDialogController extends RecordDialogController<Vehicle> {
	private Vehicle editVehicle = null;
	private final IDairyRepository dairyRepo;

	@Inject
	public VehicleEditDialogController(final IDairyRepository dairyRepo) {
		this.dairyRepo = dairyRepo;
	}

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editVehicle = getWorkingCopy();
		assert null != editVehicle;
		bindVehicleInfo();
		bindAssetInfo();
	}

	private void bindVehicleInfo() {
		// Year bound manually so I can set max and min values..

		final ISpinnerRidget yearText = getRidget(ISpinnerRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DESC_YEAR);
		yearText.setMaximum(2100);
		yearText.setMinimum(1900);
		yearText.setModelToUIControlConverter(StringToNumberConverter.toBigInteger());
		yearText.bindToModel(EMFObservables.observeValue(editVehicle, DairyPackage.Literals.VEHICLE__YEAR));
		yearText.updateFromModel();

		// field mappings

		addTextMap(VehicleLogDetailBindConstants.BIND_ID_LOG_NUM, DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER);

		addComboMap(VehicleLogDetailBindConstants.BIND_ID_DRIVER_NAME,
				new WritableList(dairyRepo.employeesByPosition("Driver"), Employee.class),
				"getFamilyName",
				DairyPackage.Literals.VEHICLE__DRIVER);

		addComboMap(VehicleLogDetailBindConstants.BIND_ID_VEHICLE_TYPE,
				new WritableList(VehicleType.getValues(), String.class),
				null,
				DairyPackage.Literals.VEHICLE__TYPE);

		addTextMap(VehicleLogDetailBindConstants.BIND_ID_REG_NUM, DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_CHASSIS_NUM, DairyPackage.Literals.VEHICLE__CHASSIS_NUMBER);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_ENGINE_NUM, DairyPackage.Literals.VEHICLE__ENGINE_NUMBER);

		addTextMap(VehicleLogDetailBindConstants.BIND_ID_DESC_MAKE, DairyPackage.Literals.VEHICLE__MAKE);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_DESC_MODEL, DairyPackage.Literals.VEHICLE__MODEL);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_DESC_YEAR, DairyPackage.Literals.VEHICLE__YEAR);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_DESC_COLOR, DairyPackage.Literals.VEHICLE__DOMINANT_COLOUR);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_DESC_CAPACITY, DairyPackage.Literals.VEHICLE__CAPACITY_IN_TONNES);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_INSURANCE_NUMBER, DairyPackage.Literals.VEHICLE__INSURANCE_POLICY_NUMBER);
		addTextMap(VehicleLogDetailBindConstants.BIND_ID_INSURANCE_EXP_DATE, DairyPackage.Literals.VEHICLE__INSURANCE_EXPIRATION_DATE);

	}

	private void bindAssetInfo() {
		final IAssetInfoRidget assetInfo = getRidget(IAssetInfoRidget.class, IAssetInfoRidget.WIDGET_ID);
		assetInfo.bindToModel(PojoObservables.observeValue(editVehicle, "assetInfo"));
		assetInfo.updateFromModel();
	}

}
