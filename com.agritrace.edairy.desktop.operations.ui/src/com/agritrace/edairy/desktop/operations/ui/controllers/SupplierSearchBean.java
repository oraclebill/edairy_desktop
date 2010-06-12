package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.ui.reference.SupplierCategory;

public class SupplierSearchBean extends AbstractBean {
	private static final String PROP_NAME = "name";
	private static final String PROP_CATEGORY = "category";
	private static final String PROP_STATUS = "status";

	private String name;
	private SupplierCategory category;
	private VendorStatus status;

	public SupplierSearchBean() {
		name = "";
		category = null;
		status = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String nameSearchValue) {
		Object oldValue = this.name;
		this.name = nameSearchValue;
		firePropertyChanged(PROP_NAME, oldValue, nameSearchValue);
	}

	public SupplierCategory getCategory() {
		return category;
	}

	public void setCategory(SupplierCategory typeSearchValue) {
		Object oldValue = this.category;
		this.category = typeSearchValue;
		firePropertyChanged(PROP_CATEGORY, oldValue, typeSearchValue);
	}

	public VendorStatus getStatus() {
		return status;
	}

	public void setStatus(VendorStatus statusSearchValue) {
		Object oldValue = this.status;
		this.status = statusSearchValue;
		firePropertyChanged(PROP_STATUS, oldValue, statusSearchValue);
	}

}
