package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

public class SupplierCategory {
	public static final String[] CATEGORIES = {
		"Feed",
		"Office Supplies",
		"Office Equipment",
		"Milk Processing Equipment",
		"Veterinary Services",
		"Veterinary Supplies",
		"Transportation Services",
		"Vehicle Repair",
		"Vehicle Sales",
		"Other"
	};
	
	public List<String> getCategories() { return Arrays.asList(CATEGORIES); }	

}
