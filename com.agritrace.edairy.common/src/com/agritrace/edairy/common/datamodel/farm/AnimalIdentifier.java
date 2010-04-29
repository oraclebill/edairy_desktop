package com.agritrace.edairy.common.datamodel.farm;

public class AnimalIdentifier {
	public enum Mechanism {
		BRAND, BADGE, COLLAR, EARTAG, RFID, GSMGPRS, OTHER
	}

	private Mechanism mechanism;
	private String issuer;
	private String value;

	public Mechanism getMechanism() {
		return mechanism;
	}

	public void setMechanism(Mechanism mechanism) {
		this.mechanism = mechanism;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
