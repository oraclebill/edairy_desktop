package com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers;

import org.eclipse.riena.beans.common.AbstractBean;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;

public class VehicleSearchBean extends AbstractBean {
	private static final String PROP_YEAR = "year";
	private static final String PROP_TYPE = "type";
	private static final String PROP_DRIVER = "driver";


	private int year;
	private String type;
	private Employee driver;

	public VehicleSearchBean() {
		year = 0;
		type = null;
		driver = null;

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		final int oldValue = this.year;
		this.year = year;
		firePropertyChanged(PROP_YEAR, oldValue, year);

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		final String oldValue = this.type;
		this.type = type;
		firePropertyChanged(PROP_TYPE, oldValue, type);
	}

	public Employee getDriver() {
		return driver;
	}

	public void setDriver(Employee driver) {
		final Employee oldValue = this.driver;
		this.driver = driver;
		firePropertyChanged(PROP_DRIVER, oldValue, driver);
	}

}
