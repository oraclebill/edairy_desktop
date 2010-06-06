package com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers;


import com.agritrace.edairy.desktop.common.ui.controllers.CommonSubModuleViewController;
import com.agritrace.edairy.desktop.operations.services.vehicles.DairyVehicleRepository;
import com.agritrace.edairy.desktop.operations.services.vehicles.IVehicleRepository;

/**
 * Vehicle log view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class VehicleLogViewController extends CommonSubModuleViewController {

	public static final String ID = VehicleLogViewController.class.getName();
	
	protected final IVehicleRepository vehicleRepository;

	public VehicleLogViewController() {
		super();
		vehicleRepository = new DairyVehicleRepository();
		this.getModelObjects().addAll(vehicleRepository.all());
	}

	@Override
	protected void addSubModuleControllers() {
		this.addSubModuleControllerDelegate(new VehicleControllerDelegate(this));
	}

}
