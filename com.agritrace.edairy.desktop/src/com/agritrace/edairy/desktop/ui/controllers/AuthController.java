package com.agritrace.edairy.desktop.ui.controllers;

import org.eclipse.riena.core.util.StringUtils;

import com.agritrace.edairy.desktop.EDairyActivator;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.operations.services.employee.IEmployeeRepository;
import com.agritrace.edairy.desktop.security.DefaultPrincipal;
import com.agritrace.edairy.desktop.security.EmployeePrincipal;

public class AuthController {
	public static boolean authenticate(String username, String password) {
		// TODO: Developer version hack for empty username/password
		if (StringUtils.isEmpty(username)) {
			boolean valid = StringUtils.isEmpty(username);
			
			if (valid) {
				EDairyActivator.getDefault().setPrincipal(new DefaultPrincipal());
			}
			
			return valid;
		}
		
		IEmployeeRepository repository = (IEmployeeRepository) RepositoryFactory.getRepository(Employee.class);
		Employee employee = repository.find(username, password);
		
		if (employee != null) {
			EDairyActivator.getDefault().setPrincipal(new EmployeePrincipal(employee));
			return true;
		}
		
		return false;
	}
}
