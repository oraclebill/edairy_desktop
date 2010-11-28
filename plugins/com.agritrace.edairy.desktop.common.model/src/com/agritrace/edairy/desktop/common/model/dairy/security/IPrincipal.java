package com.agritrace.edairy.desktop.common.model.dairy.security;

/**
 * Represents a logged in entity. For the time being, all it can do is return the
 * username and display name. Later it will also return the security role.
 *
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public interface IPrincipal {
	String getName();
	String getDisplayName();
	boolean hasPermission(UIPermission perm);
}
