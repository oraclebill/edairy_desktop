package com.agritrace.edairy.ui.views.data;

public class CreditRecord {
	
	private String store;
	private String date;
	private String reference;
	private String record;
	private String member;
	private int amount;
	
	public CreditRecord(){
		
	}
	public String getStore() {
		return store;
	}
	public String getDate() {
		return date;
	}
	public String getReference() {
		return reference;
	}
	public String getRecord() {
		return record;
	}
	public String getMember() {
		return member;
	}
	public int getAmount() {
		return amount;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
