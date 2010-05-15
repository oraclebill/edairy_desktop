package com.agritrace.edairy.ui.views.data;

public class MilkRecord {

    private String centerName;

    private String clerkName;

    private String date;

    private String scale;

    private String memberName;

    private String farmName;

    private String canNumber;

    private String binNumber;

    private double amount;

    private TestResult result;

    public MilkRecord() {

    }

    public enum TestResult {
	PASS, FAIL;

	final static TestResult[] RESULTS = { TestResult.PASS, TestResult.FAIL };

    }

    public String getCenterName() {
	return centerName;
    }

    public void setCenterName(String centerName) {
	this.centerName = centerName;
    }

    public String getClerkName() {
	return clerkName;
    }

    public void setClerkName(String clerkName) {
	this.clerkName = clerkName;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getScale() {
	return scale;
    }

    public void setScale(String scale) {
	this.scale = scale;
    }

    public String getMemberName() {
	return memberName;
    }

    public void setMemberName(String memberName) {
	this.memberName = memberName;
    }

    public String getFarmName() {
	return farmName;
    }

    public void setFarmName(String farmName) {
	this.farmName = farmName;
    }

    public String getCanNumber() {
	return canNumber;
    }

    public void setCanNumber(String canNumber) {
	this.canNumber = canNumber;
    }

    public String getBinNumber() {
	return binNumber;
    }

    public void setBinNumber(String binNumber) {
	this.binNumber = binNumber;
    }

    public double getAmount() {
	return amount;
    }

    public void setAmount(double amount) {
	this.amount = amount;
    }

    public TestResult getResult() {
	return result;
    }

    public void setResult(TestResult result) {
	this.result = result;
    }

}
