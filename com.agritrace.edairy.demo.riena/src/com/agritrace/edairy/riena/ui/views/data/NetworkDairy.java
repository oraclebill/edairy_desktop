package com.agritrace.edairy.riena.ui.views.data;

import java.util.Arrays;
import java.util.List;


public class NetworkDairy extends LocalDairy {
	
	private ORGANIZATIONTYPE organizationType;
	private String organizationName;
	
	
	
	//Dairy", "Processor", or "AgriTrace
	public enum ORGANIZATIONTYPE{
		DAIRY,
		PROCESSOR,
		AGRITRACE;
		
		final static ORGANIZATIONTYPE[] TYPES = {ORGANIZATIONTYPE.DAIRY,ORGANIZATIONTYPE.PROCESSOR,ORGANIZATIONTYPE.AGRITRACE};

		
	}

	public NetworkDairy(String lastname, String firstname) {
		super(lastname, firstname);
		// TODO Auto-generated constructor stub
	}


	public ORGANIZATIONTYPE getOrganizationType() {
		return organizationType;
	}

	public List<ORGANIZATIONTYPE> getOrganizationTypes() {
		return  Arrays.asList(ORGANIZATIONTYPE.TYPES);
	}

	public String getOrganizationName() {
		return organizationName;
	}


	public void setOrganizationType(ORGANIZATIONTYPE organizationType) {
		this.organizationType = organizationType;
	}


	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}
