package com.agritrace.edairy.desktop.common.ui.reference;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmployeeReference {
	public static final String[][] DEPARTMENTS_AND_POSITIONS = { 
		{ "Accounting",  "Extensions Officer","Accountant", "Asst. Accountant","Accounts Clerk","Book-Keeper","Banking Supervisor","Payments Clerk","Payments Supervisor","Petty Cashier","Procurements Officer","Internal Auditor",},
		{ "Transportation", "Mechanic","Loader","Transport Supervisor","Driver", "Security",},
		{ "Administration", "Data Entry Clerk", "Secretary","Manager","Tea Girl","Cashier","I.T. Administrator", "Janitor",} ,
		{ "Stores", "Asst. Store Supervisor", "Store Clerk","Store Supervisor",},
		{ "Dairy", "Dairy Supervisor","Quantity Controller","Dairy Clerk","Can Controller", },
		{ "Veterinary", "A.I. Technician","Vet Surgeon","Veterinery Clerk", }
	};
	
	private static EmployeeReference INSTANCE = null;
	
	private static final EmployeeReference getInstance() {
		if (INSTANCE==null) {
			INSTANCE  = new EmployeeReference();
		}
		return INSTANCE;
	}
	
	private final List<String> departments, positions;
	
	private EmployeeReference() {
		int dept_count = DEPARTMENTS_AND_POSITIONS.length;
		departments = new LinkedList<String>();		
		positions = new LinkedList<String>();		
		for (int i = 0; i < dept_count; i++) {
			departments.add(DEPARTMENTS_AND_POSITIONS[i][0]);
			for (int j =0; j< DEPARTMENTS_AND_POSITIONS[i].length; j++) {
				positions.add(DEPARTMENTS_AND_POSITIONS[i][j]);
			}
		}
		Collections.sort(departments);
		Collections.sort(positions);
	}
	
	public static List<String> getDepartments() {
		return getInstance().departments;
	}

	public static String getDepartmentForPosition(String position) {
		for (String[] dept :DEPARTMENTS_AND_POSITIONS ) {
			for (int i = 1; i < dept.length; i++) {
				if (dept[i].equals(position)) {
					return dept[0];
				}
			}
		}
		return null;
	}

	public static List<String> getPositions() {
		return getInstance().positions;
	}

}
