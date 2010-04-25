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

	@Id
	@GeneratedValue
	public Long getAnimnalRegistrationId() {
		return animnalRegistrationId;
	}

	public void setAnimnalRegistrationId(Long animnalRegistrationId) {
		this.animnalRegistrationId = animnalRegistrationId;
	}

	@Column(nullable=false)
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

	@Column(nullable=false)
	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	@Column(nullable=false)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Column(nullable=false)
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

	@Column(nullable=false)
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

	@Column(nullable=false)
	public String getIdentifyingFeatures() {
		return identifyingFeatures;
	}

	public void setIdentifyingFeatures(String identifyingFeatures) {
		this.identifyingFeatures = identifyingFeatures;
	}

	@Column(nullable=false)
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
