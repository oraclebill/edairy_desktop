package com.agritrace.edairy.common.datamodel.farm;

import javax.persistence.*;

@Entity
public class ReferenceAnimalType {
	private Long _animalTypeId;
	private String _species;  // e.g. cow, goat, buffalo
	private String _breed;	  // e.g. jersey, guernsey, zebu, etc
	
	@Id
	public Long getAnimalTypeId() {
		return _animalTypeId;
	}

	public String getSpecies() {
		return _species;
	}

	public void setSpecies(String species) {
		_species = species;
	}

	public String getBreed() {
		return _breed;
	}

	public void setBreed(String breed) {
		_breed = breed;
	}

	public void setAnimalTypeId(Long animalTypeId) {
		_animalTypeId = animalTypeId;
	}

	
}
