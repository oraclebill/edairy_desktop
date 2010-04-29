package com.agritrace.edairy.common.datamodel.dairy;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Vehicle {

	public static final double CAPACITY_IN_TONNES_DEFAULT = 0.0d;
	public static final String CHASSIS_NUMBER_DEFAULT = null;
	public static final String DISPOSAL_DATE_DEFAULT = null;
	public static final String DOMINANT_COLOUR_DEFAULT = null;
	public static final String ENGINE_NUMBER_DEFAULT = null;
	public static final String INSURANCE_POLICY_NUMBER_DEFAULT = null;
	public static final String INSURANCE_PURCHASE_DATE_DEFAULT = null;
	public static final String LOG_BOOK_NUMBER_DEFAULT = null;
	public static final String MAKE_DEFAULT = null;
	public static final String MODEL_DEFAULT = null;
	public static final String REGISTRATION_NUMBER_DEFAULT = null;
	public static final String TYPE_DEFAULT = null;

	private Long vehicleId;
	private String type = TYPE_DEFAULT;
	private String registrationNumber = REGISTRATION_NUMBER_DEFAULT;
	private String make = MAKE_DEFAULT;
	private String model = MODEL_DEFAULT;
	private int modelYear ;
	private double capacityInTonnes = CAPACITY_IN_TONNES_DEFAULT;
	private String chassisNumber = CHASSIS_NUMBER_DEFAULT;
	private String dominantColour = DOMINANT_COLOUR_DEFAULT;
	private String engineNumber = ENGINE_NUMBER_DEFAULT;
	private String insurancePolicyNumber = INSURANCE_POLICY_NUMBER_DEFAULT;
	private Date insurancePurchaseDate = null;
	private String logBookNumber = LOG_BOOK_NUMBER_DEFAULT;
	
	private AssetData assetData;
	
	@Id @GeneratedValue
	public Long getVehicleId() {
		return this.vehicleId;
	}
	public void setVehicleId(Long id) {
		this.vehicleId = id;
	}
	
	public double getCapacityInTonnes() {
		return capacityInTonnes;
	}
	public void setCapacityInTonnes(double capacityInTonnes) {
		this.capacityInTonnes = capacityInTonnes;
	}
	public String getChassisNumber() {
		return chassisNumber;
	}
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}
	public String getDominantColour() {
		return dominantColour;
	}
	public void setDominantColour(String dominantColour) {
		this.dominantColour = dominantColour;
	}
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}
	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}
	@Temporal(TemporalType.DATE)
	public Date getInsurancePurchaseDate() {
		return insurancePurchaseDate;
	}
	public void setInsurancePurchaseDate(Date insurancePurchaseDate) {
		this.insurancePurchaseDate = insurancePurchaseDate;
	}
	public String getLogBookNumber() {
		return logBookNumber;
	}
	public void setLogBookNumber(String logBookNumber) {
		this.logBookNumber = logBookNumber;
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
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public AssetData getAssetData() {
		return assetData;
	}
	public void setAssetData(AssetData assetData) {
		this.assetData = assetData;
	}
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}
	
}
