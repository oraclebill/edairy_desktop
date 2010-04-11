package com.agritrace.edairy.demo.riena.views.data;

import java.util.Date;

import org.eclipse.riena.beans.common.AbstractBean;

public class ServiceRequest extends AbstractBean {

	public static String PROPERTY_DATA = "date";
	public static String PROPERTY_MEMBER_ID = "id";
	public static String PROPERTY_MEMBER_NAME = "name";
	public static String PROPERTY_FARM_LOCATION = "location";

	private Date date;
	private int id;
	private String name;
	public String location;
	
	public ServiceRequest(){
		date = new Date();
		id =1000;
		name ="";
		location ="";
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		Date oldDate = this.date;
		this.date = date;
		firePropertyChanged(PROPERTY_DATA,oldDate,date);
	}
	public int getId() {
		return id;
		
	}
	public void setId(int id) {
		int oldId = this.id;
		this.id = id;
		firePropertyChanged(PROPERTY_MEMBER_ID,oldId,id);

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		firePropertyChanged(PROPERTY_MEMBER_NAME,oldName,name);

	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		String oldLocation = this.location;
		this.location = location;
		firePropertyChanged(PROPERTY_FARM_LOCATION,oldLocation,location);

	}
}
