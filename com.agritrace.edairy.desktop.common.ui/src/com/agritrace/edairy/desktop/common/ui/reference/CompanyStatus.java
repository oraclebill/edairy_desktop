package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CompanyStatus {
	public static final CompanyStatus[] CUST_STATUS = { new CompanyStatus("Active"), new CompanyStatus("Inactive"),
			new CompanyStatus("Flagged") };

	public static final List<CompanyStatus> CUST_STATUS_LIST = Collections.unmodifiableList(Arrays.asList(CUST_STATUS));

	public static CompanyStatus getByName(String name) {

		for (final CompanyStatus cType : CUST_STATUS) {
			if (cType != null && cType.getName() != null && cType.getName().equals(name)) {
				return cType;
			}
		}
		return null;
	}

	public static List<CompanyStatus> getCustomerStatusList() {
		return CUST_STATUS_LIST;
	}

	public static List<String> getCustomerStatusStringList() {
		final List<String> names = new ArrayList<String>();
		for (final CompanyStatus cType : CUST_STATUS) {
			if (cType != null && cType.getName() != null ) {
				names.add(cType.getName());
			}
		}
		return names;
	}

	private final String name;

	CompanyStatus(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}

}
