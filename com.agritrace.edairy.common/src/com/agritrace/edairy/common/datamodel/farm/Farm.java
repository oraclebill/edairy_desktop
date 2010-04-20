package com.agritrace.edairy.common.datamodel.farm;

import com.agritrace.edairy.common.datamodel.common.Party;
import com.agritrace.edairy.common.datamodel.common.Person;

public class Farm {
	
	private int farmId;
	private String name;
	private Person owner;
	
	// location info
	private double latitude;
	private double longitude;
	private String landmarkLocations;
	private String locationDirections;
	
}
