package com.agritrace.edairy.desktop.birt.data;

public class FarmerPayablesYearData {
	private String farmerName;
	private String memberNumber;
	private String accountNumber;
	private String income;
	private String credits;
	private String adjustments;
	private String payables;

	public FarmerPayablesYearData(String farmerName, String memberNumber, String accountNumber, String income,
			String credits, String adjustments, String payables) {
		super();
		this.farmerName = farmerName;
		this.memberNumber = memberNumber;
		this.accountNumber = accountNumber;
		this.income = income;
		this.credits = credits;
		this.adjustments = adjustments;
		this.payables = payables;
	}

	public String getFarmerName() {
		return (farmerName == null || farmerName.isEmpty()) ? "" : farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getMemberNumber() {
		return (memberNumber == null || memberNumber.isEmpty()) ? "" : memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getAccountNumber() {
		return (accountNumber == null || accountNumber.isEmpty()) ? "" : accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(String adjustments) {
		this.adjustments = adjustments;
	}

	public String getPayables() {
		return payables;
	}

	public void setPayables(String payables) {
		this.payables = payables;
	}

}
