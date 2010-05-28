package com.agritrace.edairy.desktop.common.ui.managers;

import static com.agritrace.edairy.desktop.common.ui.managers.DairyUtil.createVehicle;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsFactory;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.AnimalIdentifier;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
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
		if (pLoc == null && mLoc == null && dLoc == null)
			dLoc = createDescriptiveLocation("", "");
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

	/**
	 * Create a person, ensuring proper initialization.
	 * 
	 * @param givenName
	 * @param middleName
	 * @param familyName
	 * @param phoneNumber
	 * @param location
	 * @param contactMethods
	 * @return
	 */
	public static Person createPerson(String givenName, String middleName, String familyName, String phoneNumber,
			Location location, Collection<ContactMethod> contactMethods) {

		Person p = ModelFactory.eINSTANCE.createPerson();
		initPersonInfo(p, givenName, middleName, familyName, phoneNumber, location, contactMethods);
		return p;
	}

	private static void initPersonInfo(Person p, String givenName, String middleName, String familyName,
			String phoneNumber, Location location, Collection<ContactMethod> contactMethods) {
		p.setGivenName(givenName);
		p.setMiddleName(middleName);
		p.setFamilyName(familyName);
		p.setPhoneNumber(phoneNumber);
		if (null == location)
			location = createLocation(null, null, null);
		p.setLocation(location);
		if (null != contactMethods)
			p.getContactMethods().addAll(contactMethods);
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

	public static Employee createEmployee(String id, String jobFunction, Date startDate, String givenName,
			String middleName, String familyName, String phoneNumber, Location location,
			Collection<ContactMethod> contactMethods) {
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

	public static Vehicle createVehicle(String logNo, String regNo, String modelYear, String make, String model,
			String color, double tonnage, String chassisNo, Date acquiredDate, String engineNo, Employee driver,
			String tagType, String tagValue) {
		final Vehicle v1 = DairyFactory.eINSTANCE.createVehicle();

		v1.setLogBookNumber(logNo);
		v1.setRegistrationNumber(regNo);
		v1.setYear(modelYear);
		v1.setMake(make);
		v1.setModel(model);
		v1.setDominantColour(color);
		v1.setCapacityInTonnes(tonnage);
		v1.setChassisNumber(chassisNo);
		v1.setEngineNumber(engineNo);
		v1.setDriver(driver);
		v1.setAssetInfo(createAssetInfo(tagType, tagValue, acquiredDate));

		return v1;

	}

	private static Asset createAssetInfo(String tagType, String tagValue, Date acquiredDate) {
		final Asset asset = DairyFactory.eINSTANCE.createAsset();
		// asset.setAssetId(assetId);
		asset.setTagType(tagType);
		asset.setTagValue(tagValue);
		return asset;
	}

	/**
	 * Create a farmer with the most common 'Person' related fields set.
	 * 
	 * @param givenName
	 * @param middleName
	 * @param familyName
	 * @param phoneNumber
	 * @param location
	 * @param contactMethods
	 * @param farms
	 * @return
	 */
	public static Farmer createFarmer(String givenName, String middleName, String familyName, String phoneNumber,
			Location location, Collection<ContactMethod> contactMethods, Collection<Farm> farms) {
		Farmer toBe = TrackingFactory.eINSTANCE.createFarmer();

		initPersonInfo(toBe, givenName, middleName, familyName, phoneNumber, location, contactMethods);
		if (null != farms) toBe.getFarms().addAll(farms);
		
		return toBe;
	}
	
	/**
	 * Create a farmer using the location of his first farm as the farmers location. If there are no farms, 
	 * use a 'blank' location.
	 * 
	 * @param givenName
	 * @param middleName
	 * @param familyName
	 * @param phoneNumber
	 * @param farms
	 * @return
	 */
	public static Farmer createFarmer(String givenName, String middleName, String familyName, String phoneNumber,
			Collection<Farm> farms) {
		Location loc = null;
		if (null != farms && farms.size() > 0)
			loc = farms.iterator().next().getLocation();
		return createFarmer(givenName, middleName, familyName, phoneNumber, loc, null, farms);
	}	

	/**
	 * Create a farmer who resides at the location of their one and only farm - probably the most common case.
	 * 
	 * @param givenName
	 * @param middleName
	 * @param familyName
	 * @param phoneNumber
	 * @param farm
	 * @return
	 */
	public static Farmer createFarmer(String givenName, String middleName, String familyName, String phoneNumber,
			Farm farm) {
		Location loc = null;
		if (null != farm )
			loc = farm.getLocation();
			
		return createFarmer(givenName, middleName, familyName, phoneNumber, loc, null, null != farm ? Arrays.asList(farm) : null);
	}	
	
	public static RegisteredAnimal createAnimal(Farm farm, Date birthDate, String name,
			Gender gender, ReferenceAnimalType breed, Purpose purpose, 
			RearingMode rearingMode, ReferenceAnimalType sireBreed, String features, String insuranceNo,  
			Collection<AnimalIdentifier> identifierList, Collection<String> pastOwnerList, AcquisitionType acquisitionType, Date acquisitionDate  ) {
		RegisteredAnimal animal = TrackingFactory.eINSTANCE.createRegisteredAnimal();
		
		if (null == identifierList) identifierList = Collections.EMPTY_LIST;
		if (null == pastOwnerList) pastOwnerList = Collections.EMPTY_LIST;
		
		animal.setLocation(farm);
		animal.setDateOfBirth(birthDate);		
		animal.setGivenName(name);
		animal.setGender(gender);
		animal.setAnimalType(breed);
		animal.setSireType(sireBreed);
		animal.setAcquisitionType(acquisitionType);
		animal.setDateOfAcquisition(acquisitionDate);
		animal.setIdentifyingFeatures(features);
		animal.setInsuranceNumber(insuranceNo);
		animal.setPurpose(purpose);
		animal.setRearingMode(rearingMode);
		animal.getIdentifiers().addAll(identifierList);
		animal.getPastOwners().addAll(pastOwnerList);
		
		return animal;		
	}

	public static RegisteredAnimal createAnimal(Farm farm, Date birthDate, String name,
			Gender gender, ReferenceAnimalType breed, Purpose purpose, RearingMode rearingMode ) {
		return createAnimal(farm, birthDate, name, gender, breed, purpose, rearingMode, null, null, null, null, null, null, null);
	}
	
	/**
	 * Create a new membership.
	 * 
	 * @param memberId
	 * @param applicationDate
	 * @param effectiveDate
	 * @param farmer
	 * @return
	 */
	public static Membership createMembership(Date applicationDate, Date effectiveDate, Farmer farmer) {
		Membership member = DairyFactory.eINSTANCE.createMembership();

		member.setMember(farmer);
		member.setEffectiveDate(effectiveDate);
		member.setApplicationDate(applicationDate);
		return member;
	}

	/**
	 * Create a generic request that can be specialized to Vet or AI.
	 * 
	 * @param dairy
	 * @param member
	 * @param farm
	 * @param reqDate
	 * @return
	 */
	public static AnimalHealthRequest createGenericRequest(Dairy dairy, Membership member, Farm farm, Date reqDate) {
		final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
		req.setDairy(dairy);
		req.setType(RequestType.VETERINARY);
		// req.setRequestId(id);
		req.setDate(reqDate);
		req.setFarm(farm);
		req.setMember(member);
		req.setRequestingMember(member);
		return req;
	}

	public static AnimalHealthRequest addVeterinaryRequest(Dairy dairy, Membership member, Farm farm, Date reqDate,
			String problemReport, RegisteredAnimal animal, Supplier referral) {
		final AnimalHealthRequest req = createGenericRequest(dairy, member, farm, reqDate);
		req.setReportedProblem(problemReport);
		req.setReportedAnimal(animal);
		req.setReferredTo(referral);

		dairy.getAnimalHealthRequests().add(req);

		return req;
	}

	public static AnimalHealthRequest addInseminationRequest(Dairy dairy, Membership member, Farm farm, Date reqDate,
			Date heatDetected, Date treat1, Date treat2, Date treat3) {
		final AnimalHealthRequest req = createGenericRequest(dairy, member, farm, reqDate);

		req.setDateHeatDetected(Calendar.getInstance().getTime());
		req.setFirstTreatment(Calendar.getInstance().getTime());
		req.setSecondTreatment(Calendar.getInstance().getTime());
		req.setThirdTreatment(Calendar.getInstance().getTime());

		return req;
	}

	public static Farm createFarm(String name, Location farmLocation) {
		Farm farm = TrackingFactory.eINSTANCE.createFarm();

		farm.setName(name);
		farm.setLocation(farmLocation);

		return farm;
	}
}