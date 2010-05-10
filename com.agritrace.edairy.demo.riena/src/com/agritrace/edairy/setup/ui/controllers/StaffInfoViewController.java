package com.agritrace.edairy.setup.ui.controllers;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.service.ui.controllers.CommonSubModuleViewController;
import com.agritrace.edairy.setup.core.StaffInfoResourceManager;

/**
 * Employee info view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class StaffInfoViewController extends CommonSubModuleViewController {

	public static final String ID = StaffInfoViewController.class.getName();
	private List<Employee> employees;

	public StaffInfoViewController() {
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
			this.getModleOjects().addAll(
					StaffInfoResourceManager.INSTANCE
							.getObjectsFromDairyModel(Employee.class));
		} catch (CoreException e) {
			// TODO
			e.printStackTrace();
		}
	}

	@Override
	protected void addSubModuleControllers() {
		this.addSubModuleControllerDelegate(new StaffInfoControllerDelegate(
				this));
	}

}
