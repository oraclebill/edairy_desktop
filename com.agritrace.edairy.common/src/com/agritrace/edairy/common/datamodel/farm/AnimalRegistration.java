package com.agritrace.edairy.common.datamodel.farm;

import java.awt.Image;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.common.datamodel.common.DomainElement;

public class AnimalRegistration {
	
	public enum Gender { MALE, FEMALE }
	public enum Purpose { DAIRY, BEEF, BREEDING, HIDE, TRANSPORT, OTHER }
	public enum RearingMode { GRAZE, ZEROGRAZE, PASTORALHERD, OTHER }
	public enum AcquisitionType { BIRTH, PURCHASE, OTHER }
	
	private Long animnalRegistrationId;
	
	private Farm location;
	
	private Image photo;
	private String givenName;
	private Gender gender;
	private ReferenceAnimalType animalType; 
	private ReferenceAnimalType sireType;
	private Purpose purpose;
	private Date dateOfAcquisition;
	private AcquisitionType acquisitionType;
	private List<AnimalIdentifier> identifiers;
	private String identifyingFeatures;
	private RearingMode rearingMode;
	private List<String> pastOwners;
	private String insuranceNumber;
	


	// feeding
	
}
