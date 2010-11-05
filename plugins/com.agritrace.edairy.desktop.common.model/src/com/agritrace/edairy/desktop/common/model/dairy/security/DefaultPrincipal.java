package com.agritrace.edairy.desktop.common.model.dairy.security;

/**
 * Administrator principal with
 *
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public final class DefaultPrincipal implements IPrincipal {

	@Override
	public String getDisplayName() {
		return "System Administrator";
	}

	@Override
	public String getName() {
		return "root";
	}

	@Override
	public boolean hasPermission(AllPermissions perm) {
		return true;
	}

}
