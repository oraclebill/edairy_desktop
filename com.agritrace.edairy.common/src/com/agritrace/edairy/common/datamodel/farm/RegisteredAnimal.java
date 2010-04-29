package com.agritrace.edairy.common.datamodel.farm;

import java.awt.Image;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class RegisteredAnimal {

	public enum Gender {
		MALE, FEMALE
	}

	public enum Purpose {
		DAIRY, BEEF, BREEDING, HIDE, TRANSPORT, OTHER
	}

	public enum RearingMode {
		GRAZE, ZEROGRAZE, PASTORALHERD, OTHER
	}

	public enum AcquisitionType {
		BIRTH, PURCHASE, OTHER
	}

	@Id
	@GeneratedValue
	private Long animnalRegistrationId;

	@ManyToOne
	private Farm location;

	@Transient
	private Image photo;
	
	@Column(nullable = false)
	private String givenName;
	
	@Column(nullable = false)
	private Gender gender;
	
	@ManyToOne 
	private ReferenceAnimalType animalType;
	
	@ManyToOne 
	private ReferenceAnimalType sireType; // optional
	
	@Column(nullable = false)
	private Purpose purpose;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfAcquisition;
	
	private AcquisitionType acquisitionType;
	// @OneToMany
	private List<AnimalIdentifier> identifiers;
	private String identifyingFeatures;
	private RearingMode rearingMode;
	private List<String> pastOwners; // in ui,
	private String insuranceNumber;

	public Long getAnimnalRegistrationId() {
		return animnalRegistrationId;
	}

	public void setAnimnalRegistrationId(Long animnalRegistrationId) {
		this.animnalRegistrationId = animnalRegistrationId;
	}

	public Farm getLocation() {
		return location;
	}

	public void setLocation(Farm location) {
		this.location = location;
	}

	public Image getPhoto() {
		return photo;
	}

	public void setPhoto(Image photo) {
		this.photo = photo;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ReferenceAnimalType getAnimalType() {
		return animalType;
	}

	public void setAnimalType(ReferenceAnimalType animalType) {
		this.animalType = animalType;
	}

	public ReferenceAnimalType getSireType() {
		return sireType;
	}

	public void setSireType(ReferenceAnimalType sireType) {
		this.sireType = sireType;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public Date getDateOfAcquisition() {
		return dateOfAcquisition;
	}

	public void setDateOfAcquisition(Date dateOfAcquisition) {
		this.dateOfAcquisition = dateOfAcquisition;
	}

	public AcquisitionType getAcquisitionType() {
		return acquisitionType;
	}

	public void setAcquisitionType(AcquisitionType acquisitionType) {
		this.acquisitionType = acquisitionType;
	}

	public List<AnimalIdentifier> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(List<AnimalIdentifier> identifiers) {
		this.identifiers = identifiers;
	}

	public String getIdentifyingFeatures() {
		return identifyingFeatures;
	}

	public void setIdentifyingFeatures(String identifyingFeatures) {
		this.identifyingFeatures = identifyingFeatures;
	}

	public RearingMode getRearingMode() {
		return rearingMode;
	}

	public void setRearingMode(RearingMode rearingMode) {
		this.rearingMode = rearingMode;
	}

	public List<String> getPastOwners() {
		return pastOwners;
	}

	public void setPastOwners(List<String> pastOwners) {
		this.pastOwners = pastOwners;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	// feeding

}
