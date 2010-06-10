package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;


public class CustomerType {

	public static final CustomerType[] CUST_TYPES = { new CustomerType("Milk Processor"),
			new CustomerType("Milk Bar"), new CustomerType("Other") };

	public static List<CustomerType> getCustomerTypeList() {
		return Arrays.asList(CUST_TYPES);
	}

	CustomerType(String name) {
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
	
	public static CustomerType getByName(String name) {
		
		for (CustomerType cType : CUST_TYPES)
		{
			if (cType!=null && cType.getName()!=null && cType.getName().equals(name))
			{
				return cType;
			}
		}
		return null;
	}

}
