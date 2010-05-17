package com.agritrace.edairy.desktop.setup.ui.controllers;

import org.eclipse.core.runtime.CoreException;

import com.agritrace.edairy.desktop.common.ui.controllers.CommonSubModuleViewController;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.setup.core.StaffInfoResourceManager;
import com.agritrace.edairy.model.dairy.Employee;

/**
 * Employee info view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class StaffInfoViewController extends CommonSubModuleViewController {

    public static final String ID = StaffInfoViewController.class.getName();

    public StaffInfoViewController() {
	super();
	initModel();
    }

    /**
     * Currently we load EMF models from file In the future this code should be
     * replaced teneo/eclipselink framework to load DB objects to EMF models
     */
    private void initModel() {
	try {
	    this.getModelObjects().addAll(DairyDemoResourceManager.INSTANCE.getObjectsFromDairyModel(Employee.class));
	} catch (final CoreException e) {
	    // TODO
	    e.printStackTrace();
	}
    }

    @Override
    protected void addSubModuleControllers() {
	this.addSubModuleControllerDelegate(new StaffInfoControllerDelegate(this));
    }

}
