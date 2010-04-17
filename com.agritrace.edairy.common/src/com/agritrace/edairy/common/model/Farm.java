package com.agritrace.edairy.common.model;

import com.agritrace.edairy.common.model.base.Party;

public class Farm {
	private int _farmId;
	private String _name;
	private Party _owner;
	
	// location info
	private double _latitude;
	private double _longitude;
	private String _landmarkLocations;
	private String _locationDirections;
	
}
