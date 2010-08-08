package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.riena.beans.common.AbstractBean;

public class ContainerSearchBean extends AbstractBean {
	public static final String PROP_TRACKINGNUMBER = "trackingNumber";
	

	private String trackingNumber;

	public ContainerSearchBean() {
		trackingNumber = "";
	
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		String oldValue = this.trackingNumber;
		this.trackingNumber = trackingNumber;
		firePropertyChanged(PROP_TRACKINGNUMBER, oldValue, trackingNumber);

	}

	
}

