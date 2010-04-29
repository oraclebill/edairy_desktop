package com.agritrace.edairy.common.datamodel.common;

import javax.persistence.*;

@Embeddable
public class Location {

	// descriptive name for this location (e.g. "Main")
	private String _tag;

	// postal locators
	private String _address;
	private String _section;
	private String _estate;
	private String _village;
	private String _subLocation;
	private String _location;
	private String _division;
	private String _district;
	private String _postalCode;

	// gis locators
	private double _latitude;
	private double _longitude;

	// universal locators
	private String landmarkLocations;
	private String locationDirections;	

	// statutory locators
	private String _landReferenceNumber;

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getSection() {
		return _section;
	}

	public void setSection(String section) {
		_section = section;
	}

	public String getEstate() {
		return _estate;
	}

	public void setEstate(String estate) {
		_estate = estate;
	}

	public String getVillage() {
		return _village;
	}

	public void setVillage(String village) {
		_village = village;
	}

	public String getSubLocation() {
		return _subLocation;
	}

	public void setSubLocation(String subLocation) {
		_subLocation = subLocation;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getDistrict() {
		return _district;
	}

	public void setDistrict(String district) {
		_district = district;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public double getLatitude() {
		return _latitude;
	}

	public void setLatitude(double latitude) {
		_latitude = latitude;
	}

	public double getLongitude() {
		return _longitude;
	}

	public void setLongitude(double longitude) {
		_longitude = longitude;
	}

	public String getLandReferenceNumber() {
		return _landReferenceNumber;
	}

	public void setLandReferenceNumber(String landReferenceNumber) {
		_landReferenceNumber = landReferenceNumber;
	}

	public String getLandmarkLocations() {
		return landmarkLocations;
	}

	public void setLandmarkLocations(String landmarkLocations) {
		this.landmarkLocations = landmarkLocations;
	}

	public String getLocationDirections() {
		return locationDirections;
	}

	public void setLocationDirections(String locationDirections) {
		this.locationDirections = locationDirections;
	}

	
}
