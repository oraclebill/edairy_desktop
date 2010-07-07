package com.agritrace.edairy.desktop.services.ui.controllers;

import java.util.Date;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;

public class AnimalHealthRequestCondtionsBean {

	public static final String PROPERTY_ENDDATE = "endDate";
	public static final String PROPERTY_FARM = "selectedFarm";
	public static final String PROPERTY_MEMBERSHIP = "selectedMember";
	public static final String PROPERTY_STARTDATE = "startDate";

	private Date endDate;
	private RequestType requestType;
	private Farm selectedFarm;
	private Membership selectedMember;

	private Date startDate;

	public Date getEndDate() {
		return endDate;
	}

	public RequestType getRequestType() {
		return requestType;
	}

	public Farm getSelectedFarm() {
		return selectedFarm;
	}

	public Membership getSelectedMember() {
		return selectedMember;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setRequestType(RequestType requestType) {
		this.requestType = requestType;
	}

	public void setSelectedFarm(Farm selectedFarm) {
		this.selectedFarm = selectedFarm;
	}

	public void setSelectedMember(Membership selectedMember) {
		this.selectedMember = selectedMember;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
