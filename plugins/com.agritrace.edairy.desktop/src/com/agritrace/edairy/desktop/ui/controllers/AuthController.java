package com.agritrace.edairy.desktop.ui.controllers;

import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.navigation.ApplicationNodeManager;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.security.DefaultPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.EmployeePrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.IPrincipal;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.operations.services.employee.IEmployeeRepository;
import com.google.inject.Inject;

public final class AuthController {
	private final IEmployeeRepository repo;

	@Inject
	public AuthController(final IEmployeeRepository repo) {
		this.repo = repo;
	}

	private void setPrincipal(IPrincipal principal) {
		PrincipalManager.getInstance().setPrincipal(principal);

		try {
			ApplicationNodeManager.getApplicationNode().setLabel(String.format("Welcome, %s!", principal.getDisplayName()));
		} catch (final NullPointerException e) {
			// This is normal, we haven't created the window yet
		}
	}

	public boolean authenticate(String username, String password) {
		// TODO: Developer version hack for empty username/password
		if (StringUtils.isEmpty(username)) {
			final boolean valid = StringUtils.isEmpty(username);

			if (valid) {
				setPrincipal(new DefaultPrincipal());
			}

			return valid;
		}

		final Employee employee = repo.find(username, password);

		if (employee != null) {
			setPrincipal(new EmployeePrincipal(employee));
			return true;
		}

		return false;
	}
}
