package com.agritrace.edairy.common.model.dairy;

import com.agritrace.edairy.common.model.core.Party;
import com.agritrace.edairy.common.model.core.Person;

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
