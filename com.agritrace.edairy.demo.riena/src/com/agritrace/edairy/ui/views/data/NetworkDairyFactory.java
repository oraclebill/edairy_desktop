package com.agritrace.edairy.ui.views.data;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.ui.views.data.NetworkDairy.ORGANIZATIONTYPE;

public class NetworkDairyFactory {
	

	/**
 * Create a collection of persons.
 */
public static List<NetworkDairy> createPersonList() {
	List<NetworkDairy> newList = new ArrayList<NetworkDairy>();

	NetworkDairy person = new NetworkDairy("Doe", "John");
	person.setId(1002);
	person.setFarm("John Family Farm");
	person.setPhoneNumber("(608)923-2345");
	person.setAddress("87 south Rd., Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.DAIRY);
	person.setOrganizationName("");

	newList.add(person);

	person = new NetworkDairy("Jackson", "Janet");
	person.setId(1045);
	person.setFarm("Green Farm");
	person.setPhoneNumber("(608)923-2488");
	person.setAddress("222 Rading Rd., Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.DAIRY);
	person.setOrganizationName("");

	person.setGender(LocalDairy.FEMALE);
	newList.add(person);

	person = new NetworkDairy("Jackson", "Jermaine");
	person.setId(1089);
	person.setFarm("River Farm");
	person.setPhoneNumber("(608)923-7856");
	person.setAddress("23 Grand Ave, Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.DAIRY);
	person.setOrganizationName("Dairy association");

	newList.add(person);

	person = new NetworkDairy("Jackson", "John");
	person.setId(2056);
	person.setFarm("Jackson Family Farm");
	person.setPhoneNumber("(608)923-7656");
	person.setAddress("142 New Dr., Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.AGRITRACE);
	person.setOrganizationName("Agriculture foundation");


	newList.add(person);

	person = new NetworkDairy("JJ Jr. Shabadoo", "Joey");
	person.setId(3174);
	person.setFarm("Little Farm");
	person.setPhoneNumber("(608)923-1234");
	person.setAddress("786 New Dr., Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.DAIRY);
	person.setOrganizationName("");


	newList.add(person);

	person = new NetworkDairy("Johnson", "Jack"); //$NON-NLS-1$ //$NON-NLS-2$
	person.setId(7802);
	person.setFarm("New Farm");
	person.setPhoneNumber("(608)923-0000");
	person.setAddress("222 Campus Dr., Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.DAIRY);
	person.setOrganizationName("");


	newList.add(person);

	person = new NetworkDairy("Johnson", "Jane");
	person.setId(3243);
	person.setFarm("Golden Farm");
	person.setGender(LocalDairy.FEMALE);
	person.setPhoneNumber("(608)923-7777");
	person.setAddress("999 Victoria PI., Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.DAIRY);
	person.setOrganizationName("");

	newList.add(person);

	person = new NetworkDairy("Zappa", "Frank"); //$NON-NLS-1$ //$NON-NLS-2$
	person.setId(2122);
	person.setFarm("Havest Farm");
	person.setPhoneNumber("(608)923-8888");
	person.setAddress("656 last Rd., Princeton Junction, NJ 08550");
	person.setOrganizationType(ORGANIZATIONTYPE.DAIRY);
	person.setOrganizationName("");

	newList.add(person);

	return newList;
}



}
