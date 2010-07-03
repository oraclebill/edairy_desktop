package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Arrays;
import java.util.List;

public class EmployeeReference {
	public static final String[] DEPARTMENTS = { "Accounting", "Transportation", "Administration", "Sales",
			"Customer Service", };
	public static final String[] POSITIONS = { "Dairy Manager", "Assistant Manager", "Accountant", "Clerk", "Driver", };

	public static List<String> getDepartments() {
		return Arrays.asList(DEPARTMENTS);
	}

	public static List<String> getPositions() {
		return Arrays.asList(POSITIONS);
	}

}
