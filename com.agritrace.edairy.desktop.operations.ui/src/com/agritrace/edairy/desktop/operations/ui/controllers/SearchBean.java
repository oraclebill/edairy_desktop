package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.ui.reference.CustomerStatus;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;

public class SearchBean extends AbstractBean {
	private static final String PROP_NAME = "name";
	private static final String PROP_TYPE = "type";
	private static final String PROP_STATUS = "status";
	
	private String 			nameSearchValue;
	private CustomerType 	typeSearchValue;
	private CustomerStatus 	statusSearchValue;

	public SearchBean() {
		nameSearchValue = "";
		typeSearchValue = null;
		statusSearchValue = null;
	}
	
	public String getNameSearchValue() {
		return nameSearchValue;
	}

	public void setNameSearchValue(String nameSearchValue) {
		Object oldValue = this.nameSearchValue;
		this.nameSearchValue = nameSearchValue;
		firePropertyChanged(PROP_NAME, oldValue, nameSearchValue);
	}

	public CustomerType getTypeSearchValue() {
		return typeSearchValue;
	}

	public void setTypeSearchValue(CustomerType typeSearchValue) {
		Object oldValue = this.typeSearchValue;
		this.typeSearchValue = typeSearchValue;
		firePropertyChanged(PROP_TYPE, oldValue, typeSearchValue);
	}

	public CustomerStatus getStatusSearchValue() {
		return statusSearchValue;
	}

	public void setStatusSearchValue(CustomerStatus statusSearchValue) {
		Object oldValue = this.statusSearchValue;
		this.statusSearchValue = statusSearchValue;
		firePropertyChanged(PROP_STATUS, oldValue, statusSearchValue);
	}

}