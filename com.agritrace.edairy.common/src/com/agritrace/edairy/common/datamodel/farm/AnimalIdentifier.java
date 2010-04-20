package com.agritrace.edairy.common.datamodel.farm;

public class AnimalIdentifier {
	public enum Mechanism { BRAND, BADGE, COLLAR, EARTAG, RFID, GSMGPRS, OTHER }
	
	private Mechanism mechanism;
	private String issuer;
	private String value;
}
