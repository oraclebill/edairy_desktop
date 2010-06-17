package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

public class VehicleType {
	public static final String[] TypeNames = { "Truck", "Other" };
	
	public static final List<String> getValues() { 
		return Arrays.asList(TypeNames);
	}
}
