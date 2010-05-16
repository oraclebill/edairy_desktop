package com.agritrace.edairy.desktop.ui.views.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.beans.common.Address;

import com.agritrace.edairy.desktop.ui.views.data.MemberShip.CREDIT;

public class MemberFactory {

    private MemberFactory() {

    }

    /**
     * Create a collection of persons.
     */
    public static List<MemberShip> createMemberList() {
	final List<MemberShip> newList = new ArrayList<MemberShip>();

	MemberShip person = new MemberShip("Joseph", "Limuru");
	person.setId(1002);
	person.setPhoneNumber("(608)923-2345");
	person.setAddress("87 south Rd., Princeton Junction, NJ 08550");
	person.setActive(true);
	person.setCreditEnum(CREDIT.GOOD);
	Address address = new Address();
	address.setPostalCode(8550);
	address.setStreetAndNumber("87 south Rd.");
	address.setTown("Princeton Junction");
	person.setAddressInfo(address);
	person.setBalance(122489.32);

	newList.add(person);

	person = new MemberShip("John", "Smith");
	person.setId(1045);
	person.setPhoneNumber("(608)923-2488");
	person.setAddress("222 Rading Rd., Princeton Junction, NJ 08550");
	person.setActive(true);
	person.setCreditEnum(CREDIT.GOOD);
	address = new Address();
	address.setPostalCode(8550);
	address.setStreetAndNumber("222 Rading Rd.");
	address.setTown("Princeton Junction");
	person.setAddressInfo(address);
	person.setBalance(12899.65);

	newList.add(person);

	// person = new Staff("Jackson", "Jermaine");
	// person.setId(1089);
	// person.setDepartment("HR");
	// person.setPhoneNumber("(608)923-7856");
	// person.setAddress("23 Grand Ave, Princeton Junction, NJ 08550");
	// newList.add(person);
	//
	// person = new Staff("Jackson", "John");
	// person.setId(2056);
	// person.setDepartment("Accounting");
	// person.setPhoneNumber("(608)923-7656");
	// person.setAddress("142 New Dr., Princeton Junction, NJ 08550");
	//
	//
	// newList.add(person);
	//
	// person = new Staff("JJ Jr. Shabadoo", "Joey");
	// person.setId(3174);
	// person.setDepartment("Engineering");
	// person.setPhoneNumber("(608)923-1234");
	// person.setAddress("786 New Dr., Princeton Junction, NJ 08550");
	//
	//
	// newList.add(person);

	return newList;
    }
}
