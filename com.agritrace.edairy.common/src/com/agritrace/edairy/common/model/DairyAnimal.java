package com.agritrace.edairy.common.model;

import java.awt.Image;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.common.model.reference.AnimalBreed;
import com.agritrace.edairy.common.model.reference.AnimalType;

public class DairyAnimal {
	
	public enum Gender { MALE, FEMALE }
	public enum Purpose { DAIRY, BEEF, BREEDING, HIDE, TRANSPORT, OTHER }
	public enum Status { CALF, PRODUCING, INACTIVE, SOLD, DECEASED }
	public enum HousingSystem { FREE_RANGE, ZERO_GRAZE, PASTORAL_HERD, OTHER }
	
	private int _dairyAnimalId;
	
	private Farm _location;
	
	private Image _photo;
	private String _givenName;
	private Gender _gender;
	private AnimalType _animalType; 
	private AnimalBreed _primaryBreed;	
	private Purpose _purpose;
	private Status _status;
	
	private Date _dateOfBirth;
	private Date _dateOfDeath;
	private Date _dateOfAcquisition;
	private Date _dateOfDisposal;
	
	// identification
	private List<DairyAnimalIdentifier> _identifiers;
	private String identifyingFeatures;
	private String previousOwnerName;
	private String previousOwnerCity;

	// feeding
	private HousingSystem _farmingType;
	private List<DairyAnimalOwner> _pastOwners;
	
}
