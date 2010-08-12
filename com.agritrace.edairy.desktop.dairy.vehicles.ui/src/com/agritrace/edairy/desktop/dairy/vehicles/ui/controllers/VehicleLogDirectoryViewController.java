package com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.reference.VehicleType;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.util.MatchUtil;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controls.VehicleLogDetailBindConstants;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.dialogs.VehicleEditDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.edairy.desktop.operations.services.vehicle.VehicleRepository;

public class VehicleLogDirectoryViewController extends BasicDirectoryController<Vehicle>{

	private final VehicleSearchBean searchBean = new VehicleSearchBean();
	private VehicleRepository vehicleRepository = new VehicleRepository();
	private final IDairyRepository dairyRepository =  DairyRepository.getInstance();
	private final Dairy localDairy = dairyRepository.getLocalDairy();
	private IComboRidget vehicleTypeCombo;
	private IComboRidget driverCombo;

	public VehicleLogDirectoryViewController() {
		super();
		setEClass(DairyPackage.Literals.VEHICLE);
		setRepository(vehicleRepository);
	
		addTableColumn("Log Book Number", DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER);
		addTableColumn("VIN Nubmer", DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER);
		addTableColumn("Type", DairyPackage.Literals.VEHICLE__TYPE);
		addTableColumn("Make", DairyPackage.Literals.VEHICLE__MAKE);
		addTableColumn("Model", DairyPackage.Literals.VEHICLE__MODEL);
		addTableColumn("Color", DairyPackage.Literals.VEHICLE__DOMINANT_COLOUR);
		addTableColumn("Capacity", DairyPackage.Literals.VEHICLE__CAPACITY_IN_TONNES);

	}

	@Override
	protected void configureFilterRidgets() {
		
		driverCombo = getRidget(IComboRidget.class,
				VehicleLogDetailBindConstants.BIND_ID_DRIVER_NAME);
		driverCombo.bindToModel(new WritableList(dairyRepository.employeesByPosition("Driver"), Employee.class),
				Employee.class, "getFamilyName",BeansObservables.observeValue(searchBean, "driver"));
		driverCombo.updateFromModel();
		
		vehicleTypeCombo = getRidget(IComboRidget.class,VehicleLogDetailBindConstants.BIND_ID_VEHICLE_TYPE);
		vehicleTypeCombo.bindToModel(new WritableList(VehicleType.getValues(), String.class), String.class, null,
				BeansObservables.observeValue(searchBean, "type"));
		vehicleTypeCombo.updateFromModel();
	
	}

	/**
	 * Create new model while creating a new record
	 * 
	 * @return
	 */
	@Override
	protected Vehicle createNewModel() {
		final Vehicle vehicle = DairyFactory.eINSTANCE.createVehicle();
		EMFUtil.populate(vehicle);
		return vehicle;
	}

	@Override
	protected List<Vehicle> getFilteredResult() {
		final List<Vehicle> filtered = new ArrayList<Vehicle>();
		final List<Vehicle> allVehicles =  vehicleRepository.all();
		System.err.println("allVehicles: " + allVehicles);
		for (final Vehicle v: allVehicles) {
			if ((searchBean.getDriver() == null || MatchUtil.matchEquals(searchBean.getDriver().getPersonId(),v.getDriver().getPersonId())) 
				&&(searchBean.getType() == null || MatchUtil.matchContains(searchBean.getType(),v.getType()))	){
				filtered.add(v);
			}
		}
		System.err.println("Filtered: " + filtered);
		return filtered;
	}

	@Override
	protected RecordDialog<Vehicle> getRecordDialog(Shell shell) {
		VehicleEditDialog dialog = new VehicleEditDialog(shell);
		dialog.setTitle("Edit Vehicle Information");
		return dialog;
	}

	@Override
	protected void resetFilterConditions() {
		driverCombo.setSelection(driverCombo.getEmptySelectionItem());
		vehicleTypeCombo.setSelection(vehicleTypeCombo.getEmptySelectionItem());
	}

	@Override
	protected void deleteEntity(Vehicle deletableEntity) {
		localDairy.getVehicles().remove(deletableEntity);
		super.deleteEntity(deletableEntity);
		dairyRepository.save(localDairy);
	}
}
