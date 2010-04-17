package com.agritrace.edairy.common.model.base;

public class Location {	
	
	// descriptive name for this location (e.g. "Main") 
	String _tag;
	
	// postal locators
	private String _address;
	private String _section;
	private String _estate;
	private String _village;
	private String _subLocation;
	private String _location;
	private String _division;
	private String _district;
	private String _postal_code;

	// gis locators
	private double _latitude;
	private double _longitude;
	
	// statutory locators
	private String _landReferenceNumber;

}
