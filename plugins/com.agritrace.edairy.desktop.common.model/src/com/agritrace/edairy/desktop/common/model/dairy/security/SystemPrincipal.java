package com.agritrace.edairy.desktop.common.model.dairy.security;

import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;

/**
 * Principal based on an SystemUser instance.
 *
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class SystemPrincipal implements IPrincipal {
	private final SystemUser sysUser;

	public SystemPrincipal(SystemUser sysUser) {
		this.sysUser = sysUser;
	}

	@Override
	public String getDisplayName() {
		return sysUser.getUsername();
	}

	@Override
	public String getName() {
		return sysUser.getUsername();
	}

	@Override
	public boolean hasPermission(UIPermission perm) {
		// recognize 'admin' as superuser.
		if (sysUser.getUsername().equals("admin"))
			return true;
		
		final Role role = sysUser.getRole();
		return role == null ? false : role.getPermissions().contains(perm);
	}

	public final Employee getEmployee() {
		return sysUser.getRelatedEmployee();
	}

}
