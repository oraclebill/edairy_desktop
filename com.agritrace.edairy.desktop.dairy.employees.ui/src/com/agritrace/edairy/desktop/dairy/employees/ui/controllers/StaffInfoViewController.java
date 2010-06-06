package com.agritrace.edairy.desktop.dairy.employees.ui.controllers;

import org.eclipse.core.runtime.CoreException;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controllers.CommonSubModuleViewController;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.operations.services.employee.EmployeeRepository;
import com.agritrace.edairy.desktop.operations.services.employee.IEmployeeRepository;

/**
 * Employee info view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class StaffInfoViewController extends CommonSubModuleViewController {

	public static final String ID = StaffInfoViewController.class.getName();

	protected IEmployeeRepository employeeRepo = new EmployeeRepository();
	
	public StaffInfoViewController() {
		super();
		getModelObjects().addAll(employeeRepo.all());
	}

	@Override
	protected void addSubModuleControllers() {
		this.addSubModuleControllerDelegate(new StaffInfoControllerDelegate(this));
	}

}
