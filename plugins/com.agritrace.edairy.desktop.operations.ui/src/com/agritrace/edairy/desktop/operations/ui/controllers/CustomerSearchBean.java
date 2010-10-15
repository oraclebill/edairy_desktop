package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.ui.reference.CompanyStatus;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;

public class CustomerSearchBean extends AbstractBean {
	private static final String PROP_NAME = "name";
	private static final String PROP_STATUS = "status";
	private static final String PROP_TYPE = "type";

	private String nameSearchValue;
	private CompanyStatus statusSearchValue;
	private CustomerType typeSearchValue;

	public CustomerSearchBean() {
		nameSearchValue = "";
		typeSearchValue = null;
		statusSearchValue = null;
	}

	public String getNameSearchValue() {
		return nameSearchValue;
	}

	public CompanyStatus getStatusSearchValue() {
		return statusSearchValue;
	}

	public CustomerType getTypeSearchValue() {
		return typeSearchValue;
	}

	public void setNameSearchValue(String nameSearchValue) {
		final Object oldValue = this.nameSearchValue;
		this.nameSearchValue = nameSearchValue;
		firePropertyChanged(PROP_NAME, oldValue, nameSearchValue);
	}

	public void setStatusSearchValue(CompanyStatus statusSearchValue) {
		final Object oldValue = this.statusSearchValue;
		this.statusSearchValue = statusSearchValue;
		firePropertyChanged(PROP_STATUS, oldValue, statusSearchValue);
	}

	public void setTypeSearchValue(CustomerType typeSearchValue) {
		final Object oldValue = this.typeSearchValue;
		this.typeSearchValue = typeSearchValue;
		firePropertyChanged(PROP_TYPE, oldValue, typeSearchValue);
	}

}