package com.agritrace.edairy.common.datamodel.farm;

import java.util.List;

import javax.persistence.*;

import com.agritrace.edairy.common.datamodel.common.Location;
import com.agritrace.edairy.common.datamodel.common.Person;
import com.agritrace.edairy.common.datamodel.dairy.DairyLocation;

@Entity
public class Farm  {
	
	@Id
	private int farmId;
	private String name;
	private Person owner;
	private String licenseNumber;
	private Location location;
	
	// location info
	private DairyLocation defaultCollectionCenter;
	
		
	public List<RegisteredAnimal> getAnimals() {
        throw new UnsupportedOperationException(); 
	    
    }
    
    public int getAnimalCount() {
        throw new UnsupportedOperationException(); 
    }

	public int getFarmId() {
		return farmId;
	}

	public void setFarmId(int farmId) {
		this.farmId = farmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public DairyLocation getDefaultCollectionCenter() {
		return defaultCollectionCenter;
	}

	public void setDefaultCollectionCenter(DairyLocation defaultCollectionCenter) {
		this.defaultCollectionCenter = defaultCollectionCenter;
	}
	
}
