package com.agritrace.edairy.riena.ui.views.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.riena.beans.common.Address;


public class Member extends Staff {

	public static final String PROPERTY_STATUS = "status"; //$NON-NLS-1$
	public static final String PROPERTY_CREDIT = "credit"; //$NON-NLS-1$
	public static final String PROPERTY_BALANCE = "balance"; //$NON-NLS-1$
	public static final String PROPERTY_ADDRESS_INFO = "addressInfo"; //$NON-NLS-1$
	
	/**
	 * Types of Pets a person can have.
	 */
	public enum STATUS {
		ACTIVE,
		INACTIVE;
		
		final static STATUS[] STATUSES = { STATUS.ACTIVE,STATUS.INACTIVE };

	}
	/**
	 * Types of Pets a person can have.
	 */
	public static enum CREDIT {
		BAD, FAIR, GOOD, EXCELLENT
	}

	private double balance;
	private boolean isActive;
	private int crdit;
	private Address addressInfo;
	private List<Farm> farmList; 

	public Member(String lastname, String firstname) {
		super(lastname, firstname);
		addressInfo = new Address();
		farmList =  new ArrayList<Farm>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param newCredit
	 */
	public void credit(Integer newCredit) {
		if (newCredit != null) {
			setCredit(newCredit.intValue());
		}
	}

	/**
	 * @param v
	 */
	public void setCredit(int credit) {
		int oldCrdit = credit;
		this.crdit = credit;
		firePropertyChanged(PROPERTY_CREDIT, Integer.valueOf(oldCrdit), Integer
				.valueOf(credit));
	}

	/**
	 * @param value
	 */
	public void setCreditEnum(CREDIT credit) {
		switch (credit) {
		case BAD:
			setCredit(-1);
			break;
		case FAIR:
			setCredit(0);
		case GOOD:
			setCredit(1);
			break;
		case EXCELLENT:
			setCredit(2);
			break;
		}
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		if (this.isActive != isActive) {
			this.isActive = isActive;
			firePropertyChanged(PROPERTY_STATUS, null, getStatus());
		}
	}
	
	public STATUS getStatus(){
		if(isActive){
			return STATUS.ACTIVE;
		}
		return STATUS.INACTIVE;
		
	}
	
	public CREDIT getCredit(){
		switch(crdit){
		case -1:
			return CREDIT.BAD;
		case 0:
			return CREDIT.FAIR;
		case 1:
			return CREDIT.GOOD;
		case 2:
			return CREDIT.EXCELLENT;
		}
		return CREDIT.GOOD;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		double oldBalance = balance;
		this.balance = balance;
		firePropertyChanged(PROPERTY_BALANCE, oldBalance,  balance);
	}

	public Address getAddressInfo() {
		return addressInfo;
	}

	public void setAddressInfo(Address addressInfo) {
		this.addressInfo = addressInfo;
	}
	
	public List<STATUS> getStatuses() {
		return Arrays.asList(STATUS.STATUSES);
	}

	public List<Farm> getFarmList() {
		return farmList;
	}

	public void setFarmList(List<Farm> farmList) {
		this.farmList = farmList;
	}

}
