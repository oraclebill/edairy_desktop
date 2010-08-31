package com.agritrace.edairy.desktop.security;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;

/**
 * Principal based on an Employee instance.
 * 
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class EmployeePrincipal implements IPrincipal {
	private Employee employee;

	public EmployeePrincipal(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String getDisplayName() {
		return employee.getGivenName() + " " + employee.getFamilyName();
	}

	@Override
	public String getName() {
		return employee.getUsername();
	}

}
