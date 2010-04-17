package com.agritrace.edairy.common.model;

public class DairyAnimalIdentifier {
	public enum Mechanism { BRAND, BADGE, COLLAR, EARTAG, RFID, GSMGPRS, OTHER }
	
	private Mechanism _mechanism;
	private String _issuer;
	private String _value;
}
