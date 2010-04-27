package com.agritrace.edairy.common.datamodel.farm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Party;
import com.agritrace.edairy.common.datamodel.common.Person;
import com.agritrace.edairy.common.datamodel.dairy.CollectionCenter;

@Entity
public class Farm extends Party {
	
	@Id
	private int farmId;
	private String name;
	private Person owner;
	private String licenseNumber;
	
	private CollectionCenter defaultCollectionCenter;
	
	// location info
	private double latitude;
	private double longitude;
	private String landmarkLocations;
	private String locationDirections;
	
	
	
	public List<RegisteredAnimal> getAnimals() {
//        throw new UnimplementedException(); 
		List<RegisteredAnimal> animals = new ArrayList<RegisteredAnimal>();
		return animals;
	    
    }
    
    public int getAnimalCount() {
//        throw new UnimplementedException();
    	return 0;
    }
	
}
