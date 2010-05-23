package com.agritrace.edairy.desktop.common.ui.managers;

import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;

public class DairyUtil {

	public static PostalLocation createPostalLocation(String address, String division, String province, String postCode) {
		return createPostalLocation(address, division, null, province, postCode);
	}

	public static PostalLocation createPostalLocation(String address, String village, String division, String province,
			String postCode) {
		return createPostalLocation(address, null, null, village, null, null, null, division, province, postCode);
	}

	public static PostalLocation createPostalLocation(String address, String estate, String section, String village,
			String division, String province, String postCode) {
		return createPostalLocation(address, estate, section, village, null, null, null, division, province, postCode);
	}

	public static PostalLocation createPostalLocation(String address, String section, String estate, String village,
			String subLocation, String location, String district, String division, String province, String postCode) {
		PostalLocation loc = ModelFactory.eINSTANCE.createPostalLocation();
		loc.setAddress(address);
		loc.setSection(section);
		loc.setEstate(estate);
		loc.setVillage(village);
		loc.setSubLocation(subLocation);
		loc.setLocation(location);
		loc.setDistrict(district);
		loc.setDivision(division);
		loc.setProvince(province);
		loc.setPostalCode(postCode);
		return loc;
	}

	public static DescriptiveLocation createDescriptiveLocation(String directions, String landmarks) {
		DescriptiveLocation dLoc = ModelFactory.eINSTANCE.createDescriptiveLocation();
		dLoc.setDirections(directions);
		dLoc.setLandmarks(landmarks);
		return dLoc;
	}

	public static MapLocation createMapLocation(double lattitude, double longitude) {
		MapLocation mLoc = ModelFactory.eINSTANCE.createMapLocation();
		mLoc.setLatitude(lattitude);
		mLoc.setLongitude(longitude);
		return mLoc;
	}

	public static Location createLocation(String address, String section, String estate, String village,
			String subLocation, String location, String district, String division, String province, String postCode) {
		return createLocation(
				createPostalLocation(address, section, estate, village, subLocation, location, district, division,
						province, postCode), null, null);

	}

	public static Location createLocation(PostalLocation pLoc, MapLocation mLoc, DescriptiveLocation dLoc) {
		Location loc = ModelFactory.eINSTANCE.createLocation();
		if (null != pLoc)
			loc.setPostalLocation(pLoc);
		if (null != mLoc)
			loc.setMapLocation(mLoc);
		if (null != dLoc)
			loc.setDescriptiveLocation(dLoc);
		return loc;
	}

	public static Person createPerson(String givenName, String middleName, String familyName, String phoneNumber,
			Location location) {
		return createPerson(givenName, middleName, familyName, phoneNumber, location, Collections.EMPTY_SET);
	}

	public static Person createPerson(String givenName, String middleName, String familyName, String phoneNumber) {
		return createPerson(givenName, middleName, familyName, phoneNumber, ModelFactory.eINSTANCE.createLocation(),
				Collections.EMPTY_SET);
	}

	public static Person createPerson(String givenName, String middleName, String familyName, String phoneNumber,
			Location location, Collection<ContactMethod> contactMethods) {

		Person p = ModelFactory.eINSTANCE.createPerson();
		p.setGivenName(givenName);
		p.setMiddleName(middleName);
		p.setFamilyName(familyName);
		p.setPhoneNumber(phoneNumber);
		p.setLocation(location);
		if (null != contactMethods)
			p.getContactMethods().addAll(contactMethods);

		return p;
	}

	public static Supplier createSupplier(long id, String companyName, String legalName, VendorStatus status,
			Date expirationDate, Collection<String> categories, Collection<Person> contacts) throws ParseException {
		return createSupplier(id, companyName, legalName, status, expirationDate, categories, contacts,
				Collections.EMPTY_SET);
	}

	public static Supplier createSupplier(long id, String companyName, String legalName, VendorStatus status,
			Date expirationDate, Collection<String> categories) throws ParseException {
		return createSupplier(id, companyName, legalName, status, expirationDate, categories, Collections.EMPTY_SET,
				Collections.EMPTY_SET);
	}

	public static Supplier createSupplier(long id, String companyName, String legalName, VendorStatus status,
			Date expirationDate) throws ParseException {
		return createSupplier(id, companyName, legalName, status, expirationDate, Collections.EMPTY_SET,
				Collections.EMPTY_SET, Collections.EMPTY_SET);
	}

	public static Supplier createSupplier(long id, String companyName, String legalName, VendorStatus status,
			Date expirationDate, Collection<String> categories, Collection<Person> contacts,
			Collection<ContactMethod> contactMethods) throws ParseException {
		Supplier supplier = DairyFactory.eINSTANCE.createSupplier();
		supplier.setSupplierId(id);
		supplier.setCompanyName(companyName);
		supplier.setLegalName(legalName);
		supplier.setStatus(status);
		supplier.setExpirationDate(expirationDate);
		if (null != categories)
			supplier.getCategories().addAll(categories);
		if (null != contacts)
			supplier.getContacts().addAll(contacts);
		if (null != contactMethods)
			supplier.getContactMethods().addAll(contactMethods);

		return supplier;
	}

	public static Route createRoute(long id, String name, String code, String description) {
		Route route = DairyFactory.eINSTANCE.createRoute();

		route.setId(id);
		route.setName(name);
		route.setCode(code);
		route.setDescription(description);

		return route;
	}

	public static DairyLocation createDairyLocation(String name, String code, String phone, String description,
			Date dateOpened, Location location, Route route) {
		DairyLocation branch = DairyFactory.eINSTANCE.createDairyLocation();

		branch.setName(name);
		branch.setCode(code);
		branch.setPhone(phone);
		branch.setDateOpened(dateOpened);
		branch.setDescription(description);
		branch.setLocation(location);
		branch.setRoute(route);

		return branch;
	}

	public static Employee createEmployee(String id, String jobFunction, Date startDate, String givenName, String middleName,
			String familyName, String phoneNumber, Location location, Collection<ContactMethod> contactMethods) {
		return createEmployee(createPerson(givenName, middleName, familyName, phoneNumber, location, contactMethods),
				id, startDate, jobFunction);
	}

	public static Employee createEmployee(Person p, String id, Date startDate, String jobFunction) {
		return createEmployee(p, id, startDate, jobFunction, null, null);
	}

	public static Employee createEmployee(Person p, String id, Date startDate, String jobFunction, String nssfNumber,
			String nationalId) {
		Employee emp = DairyFactory.eINSTANCE.createEmployee();

		// copy person fields
		emp.setHonorific(p.getHonorific());
		emp.setGivenName(p.getGivenName());
		emp.setMiddleName(p.getMiddleName());
		emp.setFamilyName(p.getFamilyName());
		emp.setAdditionalNames(p.getAdditionalNames());
		emp.setSuffix(p.getSuffix());
		emp.setLocation(p.getLocation());
		emp.setNickName(p.getNickName());
		emp.setPhoto(p.getPhoto());

		emp.setId(id);
		emp.setStartDate(startDate);
		emp.setJobFunction(jobFunction);
		emp.setNssfNumber(nssfNumber);
		emp.setNationalId(nationalId);

		return emp;
	}

	public static Farm createFarm(long id, String name, Location farmLocation) {
		Farm farm = TrackingFactory.eINSTANCE.createFarm();

		farm.setFarmId(id);
		farm.setName(name);
		farm.setLocation(farmLocation);

		return farm;
	}
}
