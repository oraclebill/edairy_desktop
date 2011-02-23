package com.agritrace.edairy.desktop.finance.ui.paymentrequest;

public enum Frequency {
	
	MONTHLY(12, "Monthly"), BIWEEKLY(26, "Bi-Weekly"), WEEKLY(52, "Weekly");
	
	int timesPerYear;
	private String prettyName;

	private Frequency(int frequency, String name) {
		this.timesPerYear = frequency;
		this.prettyName = name;
	}

	public String toString() {
		return prettyName;
	}
}