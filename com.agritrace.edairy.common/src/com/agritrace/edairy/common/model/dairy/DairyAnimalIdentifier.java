package com.agritrace.edairy.common.model.dairy;

public class DairyAnimalIdentifier {
	public enum Mechanism { BRAND, BADGE, COLLAR, EARTAG, RFID, GSMGPRS, OTHER }
	
	private Mechanism mechanism;
	private String issuer;
	private String value;
}
