package com.agritrace.edairy.desktop.common.model.dairy.security;

public class PrincipalManager {
	private static final class InstanceHolder {
		static final PrincipalManager INSTANCE = new PrincipalManager();
	}
	
	private IPrincipal principal;
	
	public static PrincipalManager getInstance() {
		return InstanceHolder.INSTANCE;
	}

	/**
	 * For internal use by AuthController
	 */
	public void setPrincipal(IPrincipal principal) {
		this.principal = principal;
	}

	/**
	 * Get the user logged into the system.
	 * 
	 * @return the principal
	 */
	public IPrincipal getPrincipal() {
		return principal;
	}
	
	public boolean hasPermission(Permission perm) {
		return principal == null ? false : principal.hasPermission(perm);
	}
}
