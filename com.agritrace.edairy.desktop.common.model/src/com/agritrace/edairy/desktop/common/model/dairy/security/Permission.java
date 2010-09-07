package com.agritrace.edairy.desktop.common.model.dairy.security;

/**
 * Security permissions used in the system.
 * 
 * @author Matvey Kozhev <inetperson@gmail.com>
 *
 */
public enum Permission {
	// Milk namespace
	VIEW_MILK_COLLECTIONS(Namespace.MILK, "View Milk Collections"),
	VIEW_MILK_DELIVERIES(Namespace.MILK, "View Milk Deliveries"),
	EDIT_DRIVER_TOTAL(Namespace.MILK, "Edit Driver Total"),
	
	// Membership namespace
	VIEW_MEMBER_LIST(Namespace.MEMBERSHIP, "View Member List"),
	ADD_MEMBER(Namespace.MEMBERSHIP, "Add Member"),
	DELETE_MEMBER(Namespace.MEMBERSHIP, "Delete Member"),
	VIEW_MEMBER(Namespace.MEMBERSHIP, "View Member"),
	EDIT_MEMBER(Namespace.MEMBERSHIP, "Edit Member"),
	VIEW_FARMS(Namespace.MEMBERSHIP, "View Member List"),
	VIEW_LIVESTOCK(Namespace.MEMBERSHIP, "View Livestock"),
	VIEW_CONTAINERS(Namespace.MEMBERSHIP, "View Containers"),

	// Finance namespace
	VIEW_TRANSACTIONS(Namespace.FINANCE, "View Transactions"),
	VIEW_MILK_PRICES(Namespace.FINANCE, "View Milk Prices"),
	
	// Clinical namespace
	VIEW_ANIMAL_HEALTH_REQUESTS(Namespace.CLINICAL, "View Animal Health Requests"),
	
	// Operations namespace
	VIEW_DAIRY_PROFILE(Namespace.OPERATIONS, "View Dairy Profile"),
	VIEW_EMPLOYEES(Namespace.OPERATIONS, "View Employees"),
	VIEW_VEHICLES(Namespace.OPERATIONS, "View Vehicles"),
	VIEW_DAIRY_BINS(Namespace.OPERATIONS, "View Dairy Bins"),
	VIEW_DAIRY_LOCATIONS(Namespace.OPERATIONS, "View Dairy Locations"),
	VIEW_ROUTES(Namespace.OPERATIONS, "View Routes"),
	VIEW_EVENTS(Namespace.OPERATIONS, "View Events"),
	VIEW_CUSTOMERS(Namespace.OPERATIONS, "View Customers"),
	VIEW_SUPPLIERS(Namespace.OPERATIONS, "View Suppliers"),
	
	// System namespace
	VIEW_ROLES(Namespace.SYSTEM, "View Roles"),
	EDIT_ROLE(Namespace.SYSTEM, "Edit Role"),
	ADD_ROLE(Namespace.SYSTEM, "Add Role"),
	DELETE_ROLE(Namespace.SYSTEM, "Delete Role");
	
	private Namespace namespace;
	private String displayName;
	
	private Permission(Namespace namespace, String displayName) {
		this.namespace = namespace;
		this.displayName = displayName;
	}
	
	public Namespace getNamespace() {
		return namespace;
	}
	
	/**
	 * Returns the human-readable display name of the permission, like "View Member List". 
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Returns the human-readable display name of the permission, like "View Member List". 
	 */
	public String toString() {
		return displayName;
	}
}
