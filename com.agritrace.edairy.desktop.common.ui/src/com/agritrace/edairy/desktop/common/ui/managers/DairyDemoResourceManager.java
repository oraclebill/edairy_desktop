package com.agritrace.edairy.desktop.common.ui.managers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsFactory;
import com.agritrace.edairy.desktop.common.model.tracking.AcquisitionType;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.ui.util.ServiceUtils;

public class DairyDemoResourceManager implements IDairyResourceManager {

    public static DairyDemoResourceManager INSTANCE = new DairyDemoResourceManager();
    private Resource farmResource;

    private Resource dairyResource;

    private DairyDemoResourceManager() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#createFarmResource()
     */
    @Override
    public void createFarmResource() {
	final URI farmResourceURI = URI.createFileURI(XMLDB_BASE + "/farmDB.farm");
	farmResource = ResourceManager.INSTANCE.createResource(farmResourceURI);
    }

    private List<Farm> createFarms(int farmId) throws ParseException {
	final List<Farm> farms = new ArrayList<Farm>();
	final Farm farm = TrackingFactory.eINSTANCE.createFarm();
	farm.setFarmId(new Long(farmId).longValue());
	farm.setName("Green Farm_" + farmId);
	final Location location1 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
	defaultLocation.setAddress("2 - Ngeche");
	defaultLocation.setSection("Section A");
	defaultLocation.setEstate("Building B");
	defaultLocation.setVillage("West Windosr");
	defaultLocation.setSubLocation("Princeton Junction");
	defaultLocation.setLocation("Princeton");
	defaultLocation.setDivision("Mercer");
	defaultLocation.setDistrict("Central");
	defaultLocation.setProvince("Western");
	defaultLocation.setPostalCode("08550");
	location1.setPostalLocation(defaultLocation);
	farm.setLocation(location1);
	createFarmProperties(farm, 20, 20, 8000, 9000);
	farms.add(farm);

	final Farm farm1 = TrackingFactory.eINSTANCE.createFarm();
	farm1.setFarmId(new Long(farmId + 1).longValue());
	farm1.setName("Farm_" + farmId);
	final Location location2 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation pLocation2 = ModelFactory.eINSTANCE.createPostalLocation();
	pLocation2.setAddress("12 -North Post");
	pLocation2.setSection("Section A");
	pLocation2.setEstate("Estate 1");
	pLocation2.setVillage("West Windosr");
	pLocation2.setSubLocation("Princeton Junction");
	pLocation2.setLocation("Princeton");
	pLocation2.setDivision("Mercer");
	pLocation2.setDistrict("Central");
	pLocation2.setProvince("Western");
	pLocation2.setPostalCode("08550");
	location2.setPostalLocation(pLocation2);
	farm1.setLocation(location2);
	createFarmProperties(farm1, 10, 15, 8050, 9050);
	farms.add(farm1);

	return farms;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#createDairyResource()
     */
    @Override
    public void createDairyResource() throws ParseException {
	createDairyResource(XMLDB_BASE);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.agritrace.edairy.ui.IDairyResourceManager#createDairyResource(java
     * .lang.String)
     */
    @Override
    public void createDairyResource(String baseDir) throws ParseException {
	final URI dairyResourceURI = URI.createFileURI(baseDir + "/dairyDB.dairy");

	dairyResource = ResourceManager.INSTANCE.createResource(dairyResourceURI);

	final SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("MM/dd/yyyy");
	// location
	final Location location1 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
	defaultLocation.setAddress("2 - Ngeche");
	defaultLocation.setSection("Section A");
	defaultLocation.setEstate("Building B");
	defaultLocation.setVillage("West Windosr");
	defaultLocation.setSubLocation("Princeton Junction");
	defaultLocation.setLocation("Princeton");
	defaultLocation.setDivision("Mercer");
	defaultLocation.setDistrict("Central");
	defaultLocation.setProvince("Western");
	defaultLocation.setPostalCode("08550");
	location1.setPostalLocation(defaultLocation);
	//
	//
	final Location location2 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation pLocation2 = ModelFactory.eINSTANCE.createPostalLocation();
	pLocation2.setAddress("12 -North Post");
	pLocation2.setSection("Section A");
	pLocation2.setEstate("Estate 1");
	pLocation2.setVillage("West Windosr");
	pLocation2.setSubLocation("Princeton Junction");
	pLocation2.setLocation("Princeton");
	pLocation2.setDivision("Mercer");
	pLocation2.setDistrict("Central");
	pLocation2.setProvince("Western");
	pLocation2.setPostalCode("08550");
	location2.setPostalLocation(pLocation2);
	//
	final Location location3 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation pLocation3 = ModelFactory.eINSTANCE.createPostalLocation();
	pLocation3.setAddress("12 -North Post");
	pLocation3.setSection("Section A");
	pLocation3.setEstate("Estate 1");
	pLocation3.setVillage("Edison");
	pLocation3.setSubLocation("New ");
	pLocation3.setLocation("Princeton");
	pLocation3.setDivision("Middlesex ");
	pLocation3.setDistrict("Central");
	pLocation3.setProvince("Western");
	pLocation3.setPostalCode("08550");
	location3.setPostalLocation(pLocation3);

	// add locations to contents
	// dairyResource.getContents().add(location1);
	// dairyResource.getContents().add(location2);
	// dairyResource.getContents().add(location3);

	// drivers
	final Employee driver1 = DairyFactory.eINSTANCE.createEmployee();
	// driver1.setName("Joseph Limuru");
	driver1.setGivenName("Joseph");
	driver1.setFamilyName("Limuru");
	driver1.setLocation(location1);
	driver1.setPhoneNumber("609-356-3421");
	driver1.setJobFunction("Driver");
	final Date startDate = sdf.parse("04/18/1998");
	driver1.setStartDate(startDate);
	//
	final Employee driver2 = DairyFactory.eINSTANCE.createEmployee();
	// driver2.setName("John Smith");
	driver2.setGivenName("John");
	driver2.setFamilyName("Smith");
	driver2.setLocation(location2);
	driver2.setPhoneNumber("609-456-7898");
	driver2.setJobFunction("Driver");
	final Date startDate2 = sdf.parse("02/03/1994");
	driver2.setStartDate(startDate2);
	//
	final Employee driver3 = DairyFactory.eINSTANCE.createEmployee();
	// driver3.setName("Jason Spencer");
	driver3.setGivenName("Jason");
	driver3.setFamilyName("Spencer");
	driver3.setLocation(location3);
	driver3.setPhoneNumber("609-478-5565");
	driver3.setJobFunction("Driver");
	final Date startDate3 = sdf.parse("07/14/1994");
	driver3.setStartDate(startDate3);
	// add drivers to contents
	// dairyResource.getContents().add(driver1);
	// dairyResource.getContents().add(driver2);
	// dairyResource.getContents().add(driver3);

	// create vehicles
	final Vehicle v1 = DairyFactory.eINSTANCE.createVehicle();
	v1.setAssetId(new Long(1001));
	v1.setCapacityInTonnes("2");
	v1.setChassisNumber("23489-1");
	final Date acquiredDate = sdf.parse("02/18/2008");
	v1.setDateAcquired(acquiredDate);
	v1.setDriver(driver1);
	v1.setEngineNumber("21223-3");
	v1.setLogBookNumber("23001");
	v1.setMake("Toyota");
	v1.setModel("Tacoma");
	v1.setRegistrationNumber("1001- Toyota Tacoma");

	final Vehicle v2 = DairyFactory.eINSTANCE.createVehicle();
	v2.setAssetId(new Long(1002));
	v2.setCapacityInTonnes("2");
	v2.setChassisNumber("45789-1");
	final Date acquiredDate2 = sdf.parse("07/21/2007");
	v2.setDateAcquired(acquiredDate2);
	v2.setDriver(driver2);
	v2.setEngineNumber("45688-3");
	v2.setLogBookNumber("56558");
	v2.setMake("Toyota");
	v2.setModel("Tacoma");
	v2.setRegistrationNumber("1002- Toyota Tacoma");

	final Vehicle v3 = DairyFactory.eINSTANCE.createVehicle();
	v3.setAssetId(new Long(1003));
	v3.setCapacityInTonnes("2");
	v3.setChassisNumber("47878-1");
	final Date acquiredDate3 = sdf.parse("07/27/2007");
	v3.setDateAcquired(acquiredDate3);
	v3.setDriver(driver3);
	v3.setEngineNumber("45689-3");
	v3.setLogBookNumber("56559");
	v3.setMake("Toyota");
	v3.setModel("Tacoma");
	v3.setRegistrationNumber("1003- Toyota Tacoma");

	// add vehicles
	// dairyResource.getContents().add(v1);
	// dairyResource.getContents().add(v2);
	// dairyResource.getContents().add(v3);
	//
	//
	// //dairyLocation
	final DairyLocation dLocation = DairyFactory.eINSTANCE.createDairyLocation();
	dLocation.setName("stop1");
	final Date openDate = sdf.parse("04/27/2005");
	dLocation.setDateOpened(openDate);
	dLocation.setCode("DL001");
	dLocation.setPhone("609-457-8989");
	dLocation.getFunctions().add(DairyFunction.MILK_COLLECTION);
	final Location dairyLocation1 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation p1 = ModelFactory.eINSTANCE.createPostalLocation();
	p1.setAddress("22 - Ngeche");
	p1.setSection("Section A");
	p1.setEstate("Building B");
	p1.setVillage("West Windosr");
	p1.setSubLocation("Princeton Junction");
	p1.setLocation("Princeton");
	p1.setDivision("Mercer");
	p1.setDistrict("Central");
	p1.setProvince("Western");
	p1.setPostalCode("08550");
	dairyLocation1.setPostalLocation(p1);
	dLocation.setLocation(dairyLocation1);
	//
	final DairyLocation dLocation2 = DairyFactory.eINSTANCE.createDairyLocation();
	dLocation2.setName("stop2");
	final Date openDate2 = sdf.parse("04/27/2005");
	dLocation2.setDateOpened(openDate2);
	dLocation2.setCode("DL002");
	dLocation2.setPhone("609-457-1234");
	dLocation2.getFunctions().add(DairyFunction.MILK_COLLECTION);
	final Location dairyLocation2 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation p2 = ModelFactory.eINSTANCE.createPostalLocation();
	p2.setAddress("122 - Ngeche");
	p2.setSection("Section A");
	p2.setEstate("Building B");
	p2.setVillage("West Windosr");
	p2.setSubLocation("Princeton Junction");
	p2.setLocation("Princeton");
	p2.setDivision("Mercer");
	p2.setDistrict("Central");
	p2.setProvince("Western");
	p2.setPostalCode("08550");
	dairyLocation2.setPostalLocation(p2);
	dLocation2.setLocation(dairyLocation2);
	//
	final DairyLocation dLocation3 = DairyFactory.eINSTANCE.createDairyLocation();
	dLocation3.setName("stop3");
	final Date openDate3 = sdf.parse("04/27/2005");
	dLocation3.setDateOpened(openDate3);
	dLocation3.setCode("DL003");
	dLocation3.setPhone("609-457-8989");
	dLocation3.getFunctions().add(DairyFunction.MILK_COLLECTION);
	//
	final Location dairyLocation3 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation p3 = ModelFactory.eINSTANCE.createPostalLocation();
	p3.setAddress("566 - Ngeche");
	p3.setSection("Section A");
	p3.setEstate("Building B");
	p3.setVillage("West Windosr");
	p3.setSubLocation("Princeton Junction");
	p3.setLocation("Princeton");
	p3.setDivision("Mercer");
	p3.setDistrict("Central");
	p3.setProvince("Western");
	p3.setPostalCode("08550");
	dairyLocation3.setPostalLocation(p3);
	dLocation3.setLocation(dairyLocation3);
	//
	//
	final DairyLocation dLocation2_1 = DairyFactory.eINSTANCE.createDairyLocation();
	dLocation2_1.setName("route2_stop1");
	final Date openDate2_1 = sdf.parse("03/26/2008");
	dLocation2_1.setDateOpened(openDate2_1);
	dLocation2_1.setCode("DL021");
	dLocation2_1.setPhone("609-457-8989");
	dLocation2_1.getFunctions().add(DairyFunction.MILK_COLLECTION);
	final Location location2_1 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation p2_1 = ModelFactory.eINSTANCE.createPostalLocation();
	p2_1.setAddress("50 - North Post");
	p2_1.setSection("Section A");
	p2_1.setEstate("Building B");
	p2_1.setVillage("West Windosr");
	p2_1.setSubLocation("Princeton Junction");
	p2_1.setLocation("Princeton");
	p2_1.setDivision("Mercer");
	p2_1.setDistrict("Central");
	p2_1.setProvince("Western");
	p2_1.setPostalCode("08550");
	location2_1.setPostalLocation(p2_1);
	dLocation2_1.setLocation(location2_1);
	//
	final DairyLocation dLocation2_2 = DairyFactory.eINSTANCE.createDairyLocation();
	dLocation2_2.setName("route2_stop2");
	final Date openDate2_2 = sdf.parse("03/26/2008");
	dLocation2_2.setDateOpened(openDate2_2);
	dLocation2_2.setCode("DL022");
	dLocation2_2.setPhone("609-457-1234");
	dLocation2_2.getFunctions().add(DairyFunction.MILK_COLLECTION);
	final Location location2_2 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation p2_2 = ModelFactory.eINSTANCE.createPostalLocation();
	p2_2.setAddress("750 - North Post");
	p2_2.setSection("Section A");
	p2_2.setEstate("Building B");
	p2_2.setVillage("West Windosr");
	p2_2.setSubLocation("Princeton Junction");
	p2_2.setLocation("Princeton");
	p2_2.setDivision("Mercer");
	p2_2.setDistrict("Central");
	p2_2.setProvince("Western");
	p2_2.setPostalCode("08550");
	location2_2.setPostalLocation(p2_2);
	dLocation2_2.setLocation(location2_2);
	//
	final DairyLocation dLocation2_3 = DairyFactory.eINSTANCE.createDairyLocation();
	dLocation2_3.setName("route2_stop3");
	final Date openDate2_3 = sdf.parse("04/27/2008");
	dLocation2_3.setDateOpened(openDate2_3);
	dLocation2_3.setCode("DL023");
	dLocation2_3.setPhone("609-457-8989");
	dLocation2_3.getFunctions().add(DairyFunction.MILK_COLLECTION);
	final Location location2_3 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation p2_3 = ModelFactory.eINSTANCE.createPostalLocation();
	p2_3.setAddress("1250 - North Post");
	p2_3.setSection("Section A");
	p2_3.setEstate("Building B");
	p2_3.setVillage("West Windosr");
	p2_3.setSubLocation("Princeton Junction");
	p2_3.setLocation("Princeton");
	p2_3.setDivision("Mercer");
	p2_3.setDistrict("Central");
	p2_3.setProvince("Western");
	p2_3.setPostalCode("08550");
	location2_3.setPostalLocation(p2_3);
	//
	dLocation2_3.setLocation(location2_3);
	//
	// //add dairyLocations
	// dairyResource.getContents().add(dLocation);
	// dairyResource.getContents().add(dLocation2);
	// dairyResource.getContents().add(dLocation3);
	// dairyResource.getContents().add(dLocation2_1);
	// dairyResource.getContents().add(dLocation2_2);
	// dairyResource.getContents().add(dLocation2_3);
	// //route
	final Route route1 = DairyFactory.eINSTANCE.createRoute();
	route1.setCode("R0001");
	route1.setName("Route 1");
	route1.getStops().add(dLocation);
	route1.getStops().add(dLocation2);
	route1.getStops().add(dLocation3);

	final Route route2 = DairyFactory.eINSTANCE.createRoute();
	route2.setCode("R0002");
	route2.setName("Route 2");
	route2.getStops().add(dLocation2_1);
	route2.getStops().add(dLocation2_2);
	route2.getStops().add(dLocation2_3);
	// dairyResource.getContents().add(route1);
	// dairyResource.getContents().add(route2);
	//
	if (farmResource == null) {
	    createFarmResource();
	}

	// dairy conatiner
	final List<DairyContainer> bins = createDairyContianer(10, 10000);

	final Dairy dairy = DairyFactory.eINSTANCE.createDairy();
	dairy.setCompanyName("Demo Dairy");
	// dairy.setName("Demo Dairy");
	dairy.setDairyId(new Long("30001"));
	dairy.getEmployees().add(driver1);
	dairy.getEmployees().add(driver2);
	dairy.getEmployees().add(driver3);
	dairy.getVehicles().add(v1);
	dairy.getVehicles().add(v2);
	dairy.getVehicles().add(v3);
	dairy.getBranchLocations().add(dLocation);
	dairy.getBranchLocations().add(dLocation2);
	dairy.getBranchLocations().add(dLocation3);
	dairy.getBranchLocations().add(dLocation2_1);
	dairy.getBranchLocations().add(dLocation2_2);
	dairy.getBranchLocations().add(dLocation2_3);

	dairy.getRoutes().add(route1);
	dairy.getRoutes().add(route2);
	dairy.getDairyBins().addAll(bins);

	for (int i = 0; i < 20; i++) {
	    final int farmId = 5000 + i * 100;
	    final List<Farm> farms = createFarms(farmId);
	    for (final Farm f : farms) {
		farmResource.getContents().add(f);
	    }
	    final Membership member1 = DairyFactory.eINSTANCE.createMembership();
	    member1.setMemberId("" + 1000 + i);
	    final Person member = ModelFactory.eINSTANCE.createPerson();
	    member.setGivenName("Joseph" + "_" + i);
	    member.setFamilyName("Limuru");
	    member.setPhoneNumber("609-356-3400" + i);
	    member1.setMember(member);

	    final Location memberLocation = ModelFactory.eINSTANCE.createLocation();

	    final PostalLocation mLocation = ModelFactory.eINSTANCE.createPostalLocation();
	    mLocation.setAddress(i + " - Ngeche");
	    mLocation.setSection("Section A");
	    mLocation.setEstate("Building B");
	    mLocation.setVillage("West Windosr");
	    mLocation.setSubLocation("Princeton Junction");
	    mLocation.setLocation("Princeton");
	    mLocation.setDivision("Mercer");
	    mLocation.setDistrict("Central");
	    mLocation.setProvince("Western");
	    mLocation.setPostalCode("08550");
	    memberLocation.setPostalLocation(mLocation);
	    member.setLocation(memberLocation);

	    final String dateString = i < 9 ? "02/0" + i + "/2007" : "02/" + i + "/2007";
	    final Date applicationDate = sdf.parse(dateString);
	    member1.setApplicationDate(applicationDate);

	    final Date effectiveDate = sdf.parse("03/05/2007");
	    member1.setDefaultRoute(route1);
	    member1.setEffectiveDate(effectiveDate);
	    member1.setStatus(MembershipStatus.ACTIVE);
	    member1.getFarms().addAll(farms);
	    if (i % 2 == 0) {
		member1.setDefaultRoute(route2);
	    } else {
		member1.setDefaultRoute(route1);
	    }
	    dairy.getMemberships().add(member1);
	}
	
	addRequests(dairy);
	addSuppliers(dairy);
	dairyResource.getContents().add(dairy);
	try {
	    saveFarmResource();
	    saveDairyResource();

	} catch (final IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (final IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    private void addRequests(Dairy dairy) {
	try {
	    createReq1(dairy);
	    createReq2(dairy);
	    createReq3(dairy);
	}
	catch (ParseException pe) {
	    pe.printStackTrace();
	}
	
    }
    
    private void addSuppliers(Dairy dairy) {
    	try {
    		createSupplier1(dairy);
    		createSupplier2(dairy);
    		createSupplier3(dairy);
    	}
    	catch (ParseException pe) {
    		pe.printStackTrace();
    	}
    	
    }

    private void createSupplier1(Dairy dairy) throws ParseException {
    	Supplier supplier = DairyFactory.eINSTANCE.createSupplier();
		supplier.setSupplierId(10001l);
		supplier.setCompanyName("John Inventory Ltd ");
		supplier.setLegalName("JHVEN");
		supplier.setStatus(VendorStatus.VALID);
		final SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		supplier.setExpirationDate(sdf.parse("01/01/2011"));
		// Categories
		supplier.getCategories().add("Category 1");
		supplier.getCategories().add("Category 2");
		dairy.getSuppliers().add(supplier);
		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("343432322");
		person.setGivenName("Edward");
		person.setFamilyName("Clinton");		
		supplier.getContacts().add(person);
		dairyResource.getContents().add(supplier);
	}
    
    private void createSupplier2(Dairy dairy) throws ParseException {
    	Supplier supplier = DairyFactory.eINSTANCE.createSupplier();
		supplier.setSupplierId(10002l);
		supplier.setCompanyName("Tom  Amusement Ltd ");
		supplier.setLegalName("TAL");
		supplier.setStatus(VendorStatus.VALID);
		final SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		supplier.setExpirationDate(sdf.parse("02/01/2011"));
		dairy.getSuppliers().add(supplier);
		supplier.getCategories().add("Category 4");
		supplier.getCategories().add("Category 5");
		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("434212");
		person.setGivenName("Tracy");
		person.setFamilyName("Bill");		
		supplier.getContacts().add(person);
		dairyResource.getContents().add(supplier);
		
	}
    
    private void createSupplier3(Dairy dairy) throws ParseException {

    	Supplier supplier = DairyFactory.eINSTANCE.createSupplier();
		supplier.setSupplierId(10003l);
		supplier.setCompanyName("Gold Store Ltd ");
		supplier.setLegalName("GSLD");
		supplier.setStatus(VendorStatus.INVALID);
		final SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");
		supplier.setExpirationDate(sdf.parse("03/01/2011"));
		dairy.getSuppliers().add(supplier);
		supplier.getCategories().add("Category 6");
		supplier.getCategories().add("Category 7");

		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("13816442241");
		person.setGivenName("Spark");
		person.setFamilyName("Wan");		
		supplier.getContacts().add(person);
		
		Person person2 = ModelFactory.eINSTANCE.createPerson();
		person2.setPhoneNumber("13816442241");
		person2.setGivenName("John");
		person2.setFamilyName("Smith");		
		supplier.getContacts().add(person2);
		
		dairyResource.getContents().add(supplier);
	}

	/*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#loadFarmResources()
     */
    @Override
    public void loadFarmResources() {
	final URI farmResourceURI = URI.createFileURI(XMLDB_BASE + "/farmDB.farm");
	farmResource = ResourceManager.INSTANCE.loadResource(farmResourceURI);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#loadDairyResources()
     */
    @Override
    public void loadDairyResources() {

	loadFarmResources();

	final URI dairyResourceURI = URI.createFileURI(XMLDB_BASE + "/dairyDB.dairy");
	dairyResource = ResourceManager.INSTANCE.loadResource(dairyResourceURI);
	// try {
	// Dairy dairy = getObjectsFromDairyModel(Dairy.class).get(0);
	//
	// } catch (CoreException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#reLoadDairyResource()
     */
    @Override
    public void reLoadDairyResource() {
	if (farmResource.isLoaded()) {
	    farmResource.unload();
	}
	if (dairyResource.isLoaded()) {
	    dairyResource.unload();
	}
	loadDairyResources();
    }

    private Dairy localDairy = null;

    /*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#getLocalDairy()
     */
    @Override
    public synchronized Dairy getLocalDairy() {
	try {
	    if (null == localDairy) {
		final List<Dairy> localDairyList = getObjectsFromDairyModel(Dairy.class);
		if (localDairyList != null) {
		    localDairy = localDairyList.get(0);
		}
	    }
	} catch (final Exception e) {
	    e.printStackTrace();
	}
	return localDairy;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.agritrace.edairy.ui.IDairyResourceManager#getObjectsFromDairyModel
     * (java.lang.Class)
     */
    @Override
    public <T extends EObject> List<T> getObjectsFromDairyModel(Class<T> type) throws CoreException {
	final List<T> objectList = new ArrayList<T>();
	if (dairyResource == null) {
	    loadDairyResources();
	}
	if (dairyResource == null) {
	    throw new CoreException(new Status(IStatus.ERROR, getClass().getName(), "can't load dairy module"));
	}
	final List<EObject> objects = dairyResource.getContents();
	for (final EObject object : objects) {
	    if (type.isAssignableFrom(object.getClass())) {
		objectList.add((T) object);
	    }
	}
	return objectList;
    }

    private void createFarmProperties(Farm farm, int containerNumber, int animalNumber, int containerId, int animalId) throws ParseException {
	final SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("MM/dd/yyyy");
	for (int i = 0; i < containerNumber; i++) {
	    final Container container = TrackingFactory.eINSTANCE.createContainer();
	    container.setType(ContainerType.CAN);
	    final int id = containerId + i;
	    container.setContainerId("" + id);
	    container.setOwner(farm);
	    container.setMeasureType(UnitOfMeasure.LITRE);
	    container.setCapacity(50);
	    farm.getCans().add(container);
	}

	for (int i = 0; i < animalNumber; i++) {
	    final RegisteredAnimal animal1 = TrackingFactory.eINSTANCE.createRegisteredAnimal();
	    animal1.setAnimnalRegistrationId(10000 + i);
	    animal1.setGivenName("animal_" + i);
	    animal1.setLocation(farm);
	    final int n = (int) (10.0 * Math.random());
	    final int m = n < 3 ? 10 + n : n + 3;
	    final String date = m > 9 ? "0" + n + "/" + m + "/200" + n : "0" + n + "/0" + m + "/200" + n;
	    final Date effectedDate = sdf.parse(date);
	    animal1.setDateOfAcquisition(effectedDate);
	    animal1.setPurpose(Purpose.DAIRY);
	    if (i % 2 == 0) {
		animal1.setGender(Gender.FEMALE);
	    } else {
		animal1.setGender(Gender.MALE);
	    }
	    final int rearingModelValue = i % 7;
	    animal1.setRearingMode(RearingMode.get(rearingModelValue));
	    final int acquisionType = i % 5;
	    animal1.setAcquisitionType(AcquisitionType.get(acquisionType));

	    final ReferenceAnimalType animal1_type = TrackingFactory.eINSTANCE.createReferenceAnimalType();
	    animal1_type.setAnimalTypeId(animalId + i);
	    animal1_type.setSpecies("Cow");
	    animal1_type.setBreed("Western");
	    animal1.setAnimalType(animal1_type);
	    farm.getAnimals().add(animal1);
	}
    }

    private List<DairyContainer> createDairyContianer(int binNumber, int binId) {
	final List<DairyContainer> binList = new ArrayList<DairyContainer>();
	for (int i = 0; i < binNumber; i++) {
	    final DairyContainer bin = DairyFactory.eINSTANCE.createDairyContainer();
	    bin.setType(ContainerType.BIN);
	    final int id = binId + i;
	    bin.setContainerId("" + id);
	    bin.setAssetId(new Long(id).longValue());
	    bin.setMeasureType(UnitOfMeasure.LITRE);
	    bin.setCapacity(200);
	    binList.add(bin);
	}
	return binList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.agritrace.edairy.ui.IDairyResourceManager#addFarm(com.agritrace.edairy
     * .model.tracking.Farm)
     */
    @Override
    public void addFarm(Farm newFarm) {
	if (farmResource == null) {
	    loadFarmResources();
	}
	if (farmResource != null) {
	    farmResource.getContents().add(newFarm);

	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#saveDairyResource()
     */
    @Override
    public void saveDairyResource() throws IllegalArgumentException, IOException {
	ResourceManager.INSTANCE.saveResource(dairyResource);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.agritrace.edairy.ui.IDairyResourceManager#saveFarmResource()
     */
    @Override
    public void saveFarmResource() {
	try {
	    ResourceManager.INSTANCE.saveResource(farmResource);
	} catch (final IllegalArgumentException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (final IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Override
    public void store(EObject updatedObject) {
	try {
	    saveDairyResource();
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}

    }

    @Override
    public AccountTransaction[] findAccountTransaction(Date start, Date end, Long memberId, Set<TransactionType> typeSet) {
	Dairy current = getLocalDairy();
	Membership member = current.getMemberships().get(0);

	Account tstAccount = AccountFactory.eINSTANCE.createAccount();
	tstAccount.setAccountId(2112l);
	tstAccount.setEstablished(new Date());
	tstAccount.setMember(member);
	tstAccount.setType("test");
	member.setAccount(tstAccount);

	AccountTransaction tstTransaction = AccountFactory.eINSTANCE.createAccountTransaction();
	tstTransaction.setAccount(tstAccount);
	tstTransaction.setTransactionId(789123l);
	tstTransaction.setTransactionType(TransactionType.CREDIT);
	tstTransaction.setTransactionDate(new Date());
	tstTransaction.setSource("test source");
	tstTransaction.setDescription("test transaction description");
	tstTransaction.setAmount(200d);
	tstTransaction.setAccount(tstAccount);

	return new AccountTransaction[] { tstTransaction };
    }

   
    private void createReq1(Dairy dairy) throws ParseException {
	final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
	req.setRequestId(1001l);
	req.setDate(ServiceUtils.DATE_FORMAT.parse("05/03/2010"));

	dairy.getAnimalHealthRequests().add(req);

	// MemberShiip
	final Membership ship = DairyFactory.eINSTANCE.createMembership();
	dairy.getMemberships().add(ship);

	final Person person = ModelFactory.eINSTANCE.createPerson();
	person.setPhoneNumber("13816442241");
	person.setGivenName("Spark");
	person.setFamilyName("Wan");
//	dairy.getAnimalHealthRequests().add(person);

	ship.setMember(person);
	ship.setMemberId("1001");
	req.setRequestingMember(ship);

	req.setType(RequestType.VETERINARY);
	req.setDateHeatDetected(Calendar.getInstance().getTime());
	req.setFirstTreatment(Calendar.getInstance().getTime());
	req.setSecondTreatment(Calendar.getInstance().getTime());
	req.setThirdTreatment(Calendar.getInstance().getTime());
	req.setReportedProblem("problem 1");

	final Farm farm = TrackingFactory.eINSTANCE.createFarm();
	farm.setFarmId(new Long(5001).longValue());
	farm.setName("Green Farm");
	final Location location1 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
	defaultLocation.setAddress("2 - Ngeche");
	defaultLocation.setSection("Section A");
	defaultLocation.setEstate("Building B");
	defaultLocation.setVillage("West Windosr");
	defaultLocation.setSubLocation("Princeton Junction");
	defaultLocation.setLocation("Princeton");
	defaultLocation.setDivision("Mercer");
	defaultLocation.setDistrict("Central");
	defaultLocation.setProvince("Jersey");
	defaultLocation.setPostalCode("08550");
	location1.setPostalLocation(defaultLocation);
	farm.setLocation(location1);
	createFarmProperties(farm, 20, 20, 8000, 9000);

	req.setFarm(farm);
	ship.getFarms().add(farm);

    }

    private void createReq2(Dairy dairy) throws ParseException {
	final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
	req.setRequestId(1002l);
	req.setDate(ServiceUtils.DATE_FORMAT.parse("04/01/2010"));

	dairy.getAnimalHealthRequests().add(req);

	// MemberShiip
	final Membership ship = DairyFactory.eINSTANCE.createMembership();
	dairy.getMemberships().add(ship);

	final Person person = ModelFactory.eINSTANCE.createPerson();
	person.setPhoneNumber("13816424140");
	person.setGivenName("Tracy");
	person.setFamilyName("Copper");
//	dairy.getAnimalHealthRequests().add(person);

	ship.setMember(person);
	ship.setMemberId("1002");
	req.setRequestingMember(ship);

	req.setType(RequestType.INSEMINATION);
	req.setDateHeatDetected(Calendar.getInstance().getTime());
	req.setFirstTreatment(Calendar.getInstance().getTime());
	req.setSecondTreatment(Calendar.getInstance().getTime());
	req.setThirdTreatment(Calendar.getInstance().getTime());
	req.setReportedProblem("problem 2");

	final Farm farm = TrackingFactory.eINSTANCE.createFarm();
	farm.setFarmId(new Long(5001).longValue());
	farm.setName("Blue Farm");
	final Location location1 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
	defaultLocation.setAddress("2 - Ngeche");
	defaultLocation.setSection("Section A");
	defaultLocation.setEstate("Building B");
	defaultLocation.setVillage("West Windosr");
	defaultLocation.setSubLocation("Princeton Junction");
	defaultLocation.setLocation("Princeton");
	defaultLocation.setDivision("Mercer");
	defaultLocation.setDistrict("Central");
	defaultLocation.setProvince("Jersey");
	defaultLocation.setPostalCode("08550");
	location1.setPostalLocation(defaultLocation);
	farm.setLocation(location1);
	createFarmProperties(farm, 20, 20, 8000, 9000);

	req.setFarm(farm);
	ship.getFarms().add(farm);

    }

    private void createReq3(Dairy dairy) throws ParseException {
	final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
	req.setRequestId(1003l);
	req.setDate(Calendar.getInstance().getTime());

	dairy.getAnimalHealthRequests().add(req);

	// MemberShiip
	final Membership ship = DairyFactory.eINSTANCE.createMembership();
	dairy.getMemberships().add(ship);

	final Person person = ModelFactory.eINSTANCE.createPerson();
	person.setPhoneNumber("12345678");
	person.setGivenName("John");
	person.setFamilyName("Smith");
//	dairy.getAnimalHealthRequests().add(person);

	ship.setMember(person);
	ship.setMemberId("1003");
	req.setRequestingMember(ship);

	req.setType(RequestType.VETERINARY);
	req.setDateHeatDetected(Calendar.getInstance().getTime());
	req.setFirstTreatment(Calendar.getInstance().getTime());
	req.setSecondTreatment(Calendar.getInstance().getTime());
	req.setThirdTreatment(Calendar.getInstance().getTime());
	req.setReportedProblem("problem 3");

	final Farm farm = TrackingFactory.eINSTANCE.createFarm();
	farm.setFarmId(new Long(5001).longValue());
	farm.setName("Yellow Farm");
	final Location location1 = ModelFactory.eINSTANCE.createLocation();
	final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();
	defaultLocation.setAddress("2 - Ngeche");
	defaultLocation.setSection("Section A");
	defaultLocation.setEstate("Building B");
	defaultLocation.setVillage("West Windosr");
	defaultLocation.setSubLocation("Princeton Junction");
	defaultLocation.setLocation("Princeton");
	defaultLocation.setDivision("Mercer");
	defaultLocation.setDistrict("Central");
	defaultLocation.setProvince("Jersey");
	defaultLocation.setPostalCode("08550");
	location1.setPostalLocation(defaultLocation);
	farm.setLocation(location1);
	createFarmProperties(farm, 20, 20, 8000, 9000);

	req.setFarm(farm);
	ship.getFarms().add(farm);

    }
}
