package com.agritrace.edairy.common.datamodel.dairy;

import java.util.Date;
import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Location;

@Entity
public class DairyLocation {
	public enum DairyFunction { STORE_SALES, MILK_COLLECTION, WAREHOUSE, MILK_PROCESSING, MILK_STORAGE, OFFICES } 
	
	@Id @GeneratedValue
	private Long collectionCentreId;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date dateOpened;
	private Route route;
	private String colorCode;
	private String phoneNumber;	
	private Location location;	
	private String description;
	private DairyFunction function;
	public Long getCollectionCentreId() {
		return collectionCentreId;
	}
	public void setCollectionCentreId(Long collectionCentreId) {
		this.collectionCentreId = collectionCentreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DairyFunction getFunction() {
		return function;
	}
	public void setFunction(DairyFunction function) {
		this.function = function;
	} 
	
	
}
