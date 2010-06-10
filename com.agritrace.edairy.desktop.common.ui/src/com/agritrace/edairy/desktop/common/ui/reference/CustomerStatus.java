package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomerStatus {
	public static final CustomerStatus[] CUST_STATUS = { new CustomerStatus("Active"),
			new CustomerStatus("Inactive"), new CustomerStatus("Flagged") };
	
	public static final List<CustomerStatus> CUST_STATUS_LIST = 
		Collections.unmodifiableList(Arrays.asList(CUST_STATUS));
	
	public static List<CustomerStatus> getCustomerStatusList() {
		return CUST_STATUS_LIST;
	}

	CustomerStatus(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static CustomerStatus getByName(String name) {

		for (CustomerStatus cType : CUST_STATUS) {
			if (cType != null && cType.getName() != null && cType.getName().equals(name)) {
				return cType;
			}
		}
		return null;
	}

}
