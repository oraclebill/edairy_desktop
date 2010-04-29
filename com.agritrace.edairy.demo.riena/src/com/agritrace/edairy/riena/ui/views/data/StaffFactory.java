package com.agritrace.edairy.riena.ui.views.data;

import java.util.ArrayList;
import java.util.List;

public class StaffFactory {

	private StaffFactory() {
		// prevent instantation
	}

	/**
	 * Create a collection of persons.
	 */
	public static List<Staff> createPersonList() {
		List<Staff> newList = new ArrayList<Staff>();

		Staff person = new Staff("Doe", "John");
		person.setId(1002);
		person.setDepartment("Engineering");
		person.setPhoneNumber("(608)923-2345");
		person.setAddress("87 south Rd., Princeton Junction, NJ 08550");

		newList.add(person);

		person = new Staff("Jackson", "Janet");
		person.setId(1045);
		person.setDepartment("Accounting");
		person.setPhoneNumber("(608)923-2488");
		person.setAddress("222 Rading Rd., Princeton Junction, NJ 08550");


		person.setGender(Staff.FEMALE);
		newList.add(person);

		person = new Staff("Jackson", "Jermaine");
		person.setId(1089);
		person.setDepartment("HR");
		person.setPhoneNumber("(608)923-7856");
		person.setAddress("23 Grand Ave, Princeton Junction, NJ 08550");
		newList.add(person);

		person = new Staff("Jackson", "John");
		person.setId(2056);
		person.setDepartment("Accounting");
		person.setPhoneNumber("(608)923-7656");
		person.setAddress("142 New Dr., Princeton Junction, NJ 08550");


		newList.add(person);

		person = new Staff("JJ Jr. Shabadoo", "Joey");
		person.setId(3174);
		person.setDepartment("Engineering");
		person.setPhoneNumber("(608)923-1234");
		person.setAddress("786 New Dr., Princeton Junction, NJ 08550");


		newList.add(person);

		person = new Staff("Johnson", "Jack"); //$NON-NLS-1$ //$NON-NLS-2$
		person.setId(7802);
		person.setDepartment("Marketing");
		person.setPhoneNumber("(608)923-0000");
		person.setAddress("222 Campus Dr., Princeton Junction, NJ 08550");


		newList.add(person);

		person = new Staff("Johnson", "Jane");
		person.setId(3243);
		person.setDepartment("Sales");
		person.setGender(Staff.FEMALE);
		person.setPhoneNumber("(608)923-7777");
		person.setAddress("999 Victoria PI., Princeton Junction, NJ 08550");


		newList.add(person);

		person = new Staff("Zappa", "Frank"); //$NON-NLS-1$ //$NON-NLS-2$
		person.setId(2122);
		person.setDepartment("Sales");
		person.setPhoneNumber("(608)923-8888");
		person.setAddress("656 last Rd., Princeton Junction, NJ 08550");

		newList.add(person);

		return newList;
	}

}
