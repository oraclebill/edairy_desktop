package com.agritrace.edairy.desktop.setup.ui.controllers;

import org.eclipse.core.runtime.CoreException;

import com.agritrace.edairy.desktop.services.ui.controllers.CommonSubModuleViewController;
import com.agritrace.edairy.desktop.setup.core.VehicleLogResourceManager;
import com.agritrace.edairy.model.dairy.Vehicle;

/**
 * Vehicle log view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class VehicleLogViewController extends CommonSubModuleViewController {

    public static final String ID = VehicleLogViewController.class.getName();

    public VehicleLogViewController() {
	super();
	initModel();
    }

    /**
     * Currently we load EMF models from file In the future this code should be
     * replaced teneo/eclipselink framework to load DB objects to EMF models
     */
    private void initModel() {
	// ServiceRequestResourceManager.INSTANCE.loadResources();
	try {
	    this.getModleOjects().addAll(VehicleLogResourceManager.INSTANCE.getObjectsFromDairyModel(Vehicle.class));
	} catch (final CoreException e) {
	    // TODO
	    e.printStackTrace();
	}
    }

    @Override
    protected void addSubModuleControllers() {
	this.addSubModuleControllerDelegate(new VehicleControllerDelegate(this));
    }

}
