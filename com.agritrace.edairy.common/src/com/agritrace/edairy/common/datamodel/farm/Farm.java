package com.agritrace.edairy.common.datamodel.farm;

import javax.persistence.*;
import com.agritrace.edairy.common.datamodel.common.Person;

@Entity
public class Farm {
	
	@Id
	private int farmId;
	private String name;
	private Person owner;
	
	// location info
	private double latitude;
	private double longitude;
	private String landmarkLocations;
	private String locationDirections;
	
}
