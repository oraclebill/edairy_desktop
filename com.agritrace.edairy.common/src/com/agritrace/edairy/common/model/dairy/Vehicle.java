package com.agritrace.edairy.common.model.dairy;

import javax.persistence.*;

@Entity
public class Vehicle {

	private Long vehicleId;
	private String make;
	private String model;
	private int modelYear;
	private String color;
	private String registrationNumber;
	private String vehicleIdentificationNumber;

	@Id
	@GeneratedValue
	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getVehicleIdentificationNumber() {
		return vehicleIdentificationNumber;
	}

	public void setVehicleIdentificationNumber(
			String vehicleIdentificationNumber) {
		this.vehicleIdentificationNumber = vehicleIdentificationNumber;
	}
}
