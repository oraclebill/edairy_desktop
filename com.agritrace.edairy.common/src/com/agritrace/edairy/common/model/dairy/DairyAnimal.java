package com.agritrace.edairy.common.model.dairy;

import java.awt.Image;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.common.model.reference.AnimalBreed;
import com.agritrace.edairy.common.model.reference.AnimalType;

public class DairyAnimal {
	
	public enum Gender { MALE, FEMALE }
	public enum Purpose { DAIRY, BEEF, BREEDING, HIDE, TRANSPORT, OTHER }
	public enum Status { CALF, PRODUCING, INACTIVE, SOLD, DECEASED }
	public enum HousingSystem { GRAZE, ZEROGRAZE, PASTORALHERD, OTHER }
	
	private int dairyAnimalId;
	
	private Farm location;
	
	private Image photo;
	private String givenName;
	private Gender gender;
	private AnimalType animalType; 
	private AnimalBreed primaryBreed;	
	private Purpose purpose;
	private Status status;
	
	private Date dateOfBirth;
	private Date dateOfDeath;
	private Date dateOfAcquisition;
	private Date dateOfDisposal;
	
	// identification
	private List<DairyAnimalIdentifier> identifiers;
	private String identifyingFeatures;
	private String previousOwnerName;
	private String previousOwnerCity;

	// feeding
	private HousingSystem farmingType;
	private List<DairyAnimalOwner> pastOwners;
	
}
