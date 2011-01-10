package com.agritrace.edairy.desktop.common.model.dairy.security;

import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;

/**
 * Principal based on an Employee instance.
 *
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class EmployeePrincipal implements IPrincipal {
	private final Employee employee;

	public EmployeePrincipal(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String getDisplayName() {
		return employee.getGivenName() + " " + employee.getFamilyName();
	}

	@Override
	public String getName() {
		return employee.getSystemIdentity().getUsername();
	}

	@Override
	public boolean hasPermission(UIPermission perm) {
		final Role role = employee.getSystemIdentity() != null ? employee.getSystemIdentity().getRole() : null;

		return role == null ? false : role.getPermissions().contains(perm);
	}

	public final Employee getEmployee() {
		return employee;
	}

}
