package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.beans.common.AbstractBean;

public class SearchBean extends AbstractBean {
	private static final String PROP_NAME = "name";
	private static final String PROP_TYPE = "type";
	private static final String PROP_STATUS = "status";
	
	private String nameSearchValue;
	private String typeSearchValue;
	private String statusSearchValue;

	public SearchBean() {
		nameSearchValue = "";
		typeSearchValue = "";
		statusSearchValue = "";
	}
	
	public String getNameSearchValue() {
		return nameSearchValue;
	}

	public void setNameSearchValue(String nameSearchValue) {
		Object oldValue = this.nameSearchValue;
		this.nameSearchValue = nameSearchValue;
		firePropertyChanged(PROP_NAME, oldValue, nameSearchValue);
	}

	public String getTypeSearchValue() {
		return typeSearchValue;
	}

	public void setTypeSearchValue(String typeSearchValue) {
		Object oldValue = this.typeSearchValue;
		this.typeSearchValue = typeSearchValue;
		firePropertyChanged(PROP_TYPE, oldValue, typeSearchValue);
	}

	public String getStatusSearchValue() {
		return statusSearchValue;
	}

	public void setStatusSearchValue(String statusSearchValue) {
		Object oldValue = this.statusSearchValue;
		this.statusSearchValue = statusSearchValue;
		firePropertyChanged(PROP_STATUS, oldValue, statusSearchValue);
	}

}