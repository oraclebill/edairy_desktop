package com.agritrace.edairy.common.model.core;

import java.util.List;
import javax.persistence.*;

@Embeddable
public abstract class Party {
	
	// address info
	private String _address;
	private String _section;
	private String _estate;
	private String _village;
	private String _subLocation;
	private String _location;
	private String _division;
	private String _district;
	private String _postal_code;

	// domicile / location
	private String _addressDescription; // directions...

	// contact methods
	private List<ContactMethod> _contactMethods;

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

	public String getPostal_code() {
		return _postal_code;
	}

	public void setPostal_code(String postal_code) {
		_postal_code = postal_code;
	}

	public String getAddressDescription() {
		return _addressDescription;
	}

	public void setAddressDescription(String addressDescription) {
		_addressDescription = addressDescription;
	}

	public List<ContactMethod> getContactMethods() {
		return _contactMethods;
	}

	public void setContactMethods(List<ContactMethod> contactMethods) {
		_contactMethods = contactMethods;
	}

}
