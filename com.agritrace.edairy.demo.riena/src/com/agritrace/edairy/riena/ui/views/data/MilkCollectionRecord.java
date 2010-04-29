package com.agritrace.edairy.riena.ui.views.data;

public class MilkCollectionRecord {
	
	private String line;
	private String memberId;
	private String canId;
	private double quantity;
	boolean nPRMissing;
	boolean rejected;

	public MilkCollectionRecord(){
		
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getCanId() {
		return canId;
	}
	public void setCanId(String canId) {
		this.canId = canId;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public boolean isnPRMissing() {
		return nPRMissing;
	}
	public void setnPRMissing(boolean nPRMissing) {
		this.nPRMissing = nPRMissing;
	}
	public boolean isRejected() {
		return rejected;
	}
	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}
	
}
