package com.agritrace.edairy.common.model;

import java.util.Date;
import java.util.Map;

import com.agritrace.edairy.common.model.base.Location;

public class Dairy {
	
	// identification info
	private int _dairyId;
	private String _dairyName;
	
	// licensing info
	private String _kdbLicenseNum;
	private Date _kdbLicenseEffectiveDate;
	private Date _kdbLicenseExpirationDate;

	// locations
	private Location _primaryLocation;
	private Map<String, Location> _branchLocations;
	
	// members
	
	// employees
	
	// vehicles
	
	// 
}
