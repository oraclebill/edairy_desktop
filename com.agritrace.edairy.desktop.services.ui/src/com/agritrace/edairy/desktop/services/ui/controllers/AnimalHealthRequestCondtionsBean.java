package com.agritrace.edairy.desktop.services.ui.controllers;

import java.util.Date;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

public class AnimalHealthRequestCondtionsBean {
	
	public static final String PROPERTY_FARM ="selectedFarm";

	private Date startDate;
	private Date endDate;
	private Farm selectedFarm;
	private Membership selectedMember;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Farm getSelectedFarm() {
		return selectedFarm;
	}

	public void setSelectedFarm(Farm selectedFarm) {
		this.selectedFarm = selectedFarm;
	}

	public Membership getSelectedMember() {
		return selectedMember;
	}

	public void setSelectedMember(Membership selectedMember) {
		this.selectedMember = selectedMember;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	private RequestType requestType;
}
