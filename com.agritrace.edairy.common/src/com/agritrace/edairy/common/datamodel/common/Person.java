package com.agritrace.edairy.common.datamodel.common;

import javax.persistence.*;

@Entity
public class Person {

	private Long personId;
	
	// name info
	private String honorific;
	private String given_name;
	private String middleName;
	private String familyName;
	private String[] additionalNames;
	private String suffix;
	
	public String getHonorific() {
		return honorific;
	}

	public void setHonorific(String honorific) {
		this.honorific = honorific;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String[] getAdditionalNames() {
		return additionalNames;
	}

	public void setAdditionalNames(String[] additionalNames) {
		this.additionalNames = additionalNames;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Id
	@GeneratedValue
	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

}
