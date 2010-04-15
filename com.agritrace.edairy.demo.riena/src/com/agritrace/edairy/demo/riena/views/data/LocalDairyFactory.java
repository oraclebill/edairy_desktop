package com.agritrace.edairy.demo.riena.views.data;

import java.util.ArrayList;
import java.util.List;

public class LocalDairyFactory {
	/**
 * Create a collection of persons.
 */
public static List<LocalDairy> createPersonList() {
	List<LocalDairy> newList = new ArrayList<LocalDairy>();

	LocalDairy person = new LocalDairy("Doe", "John");
	person.setId(1002);
	person.setFarm("John Family Farm");
	person.setPhoneNumber("(608)923-2345");
	person.setAddress("87 south Rd., Princeton Junction, NJ 08550");

	newList.add(person);

	person = new LocalDairy("Jackson", "Janet");
	person.setId(1045);
	person.setFarm("Green Farm");
	person.setPhoneNumber("(608)923-2488");
	person.setAddress("222 Rading Rd., Princeton Junction, NJ 08550");


	person.setGender(LocalDairy.FEMALE);
	newList.add(person);

	person = new LocalDairy("Jackson", "Jermaine");
	person.setId(1089);
	person.setFarm("River Farm");
	person.setPhoneNumber("(608)923-7856");
	person.setAddress("23 Grand Ave, Princeton Junction, NJ 08550");
	newList.add(person);

	person = new LocalDairy("Jackson", "John");
	person.setId(2056);
	person.setFarm("Jackson Family Farm");
	person.setPhoneNumber("(608)923-7656");
	person.setAddress("142 New Dr., Princeton Junction, NJ 08550");


	newList.add(person);

	person = new LocalDairy("JJ Jr. Shabadoo", "Joey");
	person.setId(3174);
	person.setFarm("Little Farm");
	person.setPhoneNumber("(608)923-1234");
	person.setAddress("786 New Dr., Princeton Junction, NJ 08550");


	newList.add(person);

	person = new LocalDairy("Johnson", "Jack"); //$NON-NLS-1$ //$NON-NLS-2$
	person.setId(7802);
	person.setFarm("New Farm");
	person.setPhoneNumber("(608)923-0000");
	person.setAddress("222 Campus Dr., Princeton Junction, NJ 08550");


	newList.add(person);

	person = new LocalDairy("Johnson", "Jane");
	person.setId(3243);
	person.setFarm("Golden Farm");
	person.setGender(LocalDairy.FEMALE);
	person.setPhoneNumber("(608)923-7777");
	person.setAddress("999 Victoria PI., Princeton Junction, NJ 08550");


	newList.add(person);

	person = new LocalDairy("Zappa", "Frank"); //$NON-NLS-1$ //$NON-NLS-2$
	person.setId(2122);
	person.setFarm("Havest Farm");
	person.setPhoneNumber("(608)923-8888");
	person.setAddress("656 last Rd., Princeton Junction, NJ 08550");

	newList.add(person);

	return newList;
}

}

