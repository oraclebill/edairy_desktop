package com.agritrace.edairy.desktop.ui.controllers;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.navigation.ApplicationNodeManager;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.security.DefaultPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.EmployeePrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.IPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.operations.services.employee.IEmployeeRepository;

public final class AuthController {
	private static void setPrincipal(IPrincipal principal) {
		PrincipalManager.getInstance().setPrincipal(principal);
		
		try {
			ApplicationNodeManager.getApplicationNode().setLabel(String.format("Welcome, %s!", principal.getDisplayName()));
		} catch (NullPointerException e) {
			// This is normal, we haven't created the window yet
		}
	}
	
	public static boolean authenticate(String username, String password) {
		// TODO: Developer version hack for empty username/password
		if (StringUtils.isEmpty(username)) {
			boolean valid = StringUtils.isEmpty(username);
			
			if (valid)
				setPrincipal(new DefaultPrincipal());
			
			return valid;
		}
		
		IEmployeeRepository repository = (IEmployeeRepository) RepositoryFactory.getRepository(Employee.class);
		Employee employee = repository.find(username, password);
		
		if (employee != null) {
			setPrincipal(new EmployeePrincipal(employee));
			return true;
		}
		
		return false;
	}
}
