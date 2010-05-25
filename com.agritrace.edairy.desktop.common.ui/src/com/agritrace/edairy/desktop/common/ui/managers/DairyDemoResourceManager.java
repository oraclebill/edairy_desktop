package com.agritrace.edairy.desktop.common.ui.managers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

import static com.agritrace.edairy.desktop.common.ui.managers.DairyUtil.*;

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
	public void createDairyResource() throws ParseException, IllegalArgumentException, IOException {
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
	public void createDairyResource(String baseDir) throws ParseException, IllegalArgumentException, IOException {
		final URI dairyResourceURI = URI.createFileURI(baseDir + "/dairyDB.dairy");

		dairyResource = ResourceManager.INSTANCE.createResource(dairyResourceURI);
		Dairy dairy = createDairyData();
		dairyResource.getContents().add(dairy);
		saveDairyResource();
	}

	public Dairy createDairyData() throws ParseException {

		// create dairy
		final SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM/dd/yyyy");

		final Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setCompanyName("Demo Dairy");
		dairy.setDairyId(1l);
		dairy.setFederalPin("");
		dairy.setLicenseEffectiveDate(new Date());
		dairy.setLicenseExpirationDate(new Date());
		dairy.setLocation(createLocation(
				createPostalLocation("1 Dairy Drive", "First Division", "Best Province", "123456"),
				createMapLocation(123.45d, -12.456d),
				createDescriptiveLocation("Left from the corner then right after the sign", "")));
		dairy.setNhifNumber("NHIF-12345678");
		dairy.setNssfNumber("NSSF-12345678");
		dairy.setPhoneNumber("123456789");
		dairy.setRegistrationNumber("KDB-123451234");

		// create some locations for later use
		//
		final Location location1 = createLocation("1 - Ngeche", "Section A", "Building B", "West Windosr",
				"Princeton Junction", "Princeton", "Central", "Mercer", "Western", "08550");
		final Location location2 = createLocation("2 -North Post", "Section A", "Building B", "West Windosr",
				"Princeton Junction", "Princeton", "Central", "Mercer", "Western", "08550");
		final Location location3 = createLocation("3 - Arista", "Section A", "Estate 2", "West Windosr Village",
				"Princeton Junction", "Princeton", "Central", "Mercer", "Western", "08550");

		// create some employees
		//
		final Employee driver1 = createEmployee("1", "Driver", sdf.parse("04/18/1998"), "Joseph", "Winston", "Limuru",
				"123-123-12345", location1, Collections.EMPTY_SET);
		final Employee driver2 = createEmployee("2", "Driver", sdf.parse("02/03/1994"), "John", "Smith", "Smith",
				"609-456-7898", location2, Collections.EMPTY_SET);
		final Employee driver3 = createEmployee("3", "Driver", sdf.parse("07/14/2010"), "Jason", "Winston", "Spencer",
				"609-478-5565", location3, Collections.EMPTY_SET);

		// add employees
		//
		dairy.getEmployees().add(driver1);
		dairy.getEmployees().add(driver2);
		dairy.getEmployees().add(driver3);

		// create some vehicles

		final Vehicle v1 = DairyFactory.eINSTANCE.createVehicle();
		v1.setCapacityInTonnes(2);
		v1.setChassisNumber("23489-1");
		final Date acquiredDate = sdf.parse("02/18/2008");
		// v1.setDateAcquired(acquiredDate);
		v1.setDriver(driver1);
		v1.setEngineNumber("21223-3");
		v1.setLogBookNumber("23001");
		v1.setMake("Toyota");
		v1.setModel("Tacoma");
		v1.setRegistrationNumber("1001- Toyota Tacoma");
		// v1.setTagType("");
		// v1.setTagValue("");
		v1.setType("v");
		v1.setVehicleId(1l);

		final Vehicle v2 = DairyFactory.eINSTANCE.createVehicle();
		// v2.setAssetId(new Long(1002));
		v2.setCapacityInTonnes(2);
		v2.setChassisNumber("45789-1");
		final Date acquiredDate2 = sdf.parse("07/21/2007");
		// v2.setDateAcquired(acquiredDate2);
		v2.setDriver(driver2);
		v2.setEngineNumber("45688-3");
		v2.setLogBookNumber("56558");
		v2.setMake("Toyota");
		v2.setModel("Tacoma");
		v2.setRegistrationNumber("1002- Toyota Tacoma");
		// v2.setTagType("");
		// v2.setTagValue("");
		v2.setType("v");
		v2.setVehicleId(2l);

		final Vehicle v3 = DairyFactory.eINSTANCE.createVehicle();
		// v3.setAssetId(new Long(1003));
		v3.setCapacityInTonnes(2);
		v3.setChassisNumber("47878-1");
		final Date acquiredDate3 = sdf.parse("07/27/2007");
		// v3.setDateAcquired(acquiredDate3);
		v3.setDriver(driver3);
		v3.setEngineNumber("45689-3");
		v3.setLogBookNumber("56559");
		v3.setMake("Toyota");
		v3.setModel("Tacoma");
		v3.setRegistrationNumber("1003- Toyota Tacoma");
		// v3.setTagType("");
		// v3.setTagValue("");
		v3.setType("v");
		v3.setVehicleId(3l);

		// add vehicles
		//
		dairy.getVehicles().add(v1);
		dairy.getVehicles().add(v2);
		dairy.getVehicles().add(v3);

		// create some branches
		//
		// final DairyLocation dLocation =
		// DairyFactory.eINSTANCE.createDairyLocation();
		final Route route1 = createRoute(1l, "NGE", "Ngeche", "The Ngech branch", Collections.EMPTY_SET);
		final Route route2 = createRoute(2l, "ORE", "Orengo", "The Orengo branch", Collections.EMPTY_SET);
		final Route route3 = createRoute(3l, "JDE", "jodongo", "The Jodongo branch", Collections.EMPTY_SET);
		final List<DairyFunction> functionList = Arrays
				.asList(DairyFunction.MILK_COLLECTION, DairyFunction.STORE_SALES);
		final Location loc1 = createLocation(
				createPostalLocation("ngeche address", "ngeche division", "ngeche province", "080451"),
				createMapLocation(-123.5d, 125.3d), createDescriptiveLocation("Ngeche location", "landmarks"));
		final Location loc2 = createLocation(
				createPostalLocation("Orengo address", "Orengo division", "Orengo province", "080451"),
				createMapLocation(-123.5d, 125.3d), createDescriptiveLocation("Orengo location", " Orengo landmarks"));
		final Location loc3 = createLocation(
				createPostalLocation("jodongo address", "jodongo division", "jodongo province", "080451"),
				createMapLocation(-123.5d, 125.3d), createDescriptiveLocation("jodongo location", "jodongo landmarks"));
		final DairyLocation dLocation1 = createDairyLocation(1l, "Ngeche", sdf.parse("4/21/1966"), "856.556.0606",
				null, "The Ngeche branch is a dairy location", "NGE", loc1, functionList);
		final DairyLocation dLocation2 = createDairyLocation(2l, "Orengo", sdf.parse("4/21/1966"), "856.556.0606",
				null, "The Orengo branch is a dairy location", "ORE", loc2, functionList);
		final DairyLocation dLocation3 = createDairyLocation(3l, "jodongo", sdf.parse("4/21/1966"), "856.556.0606",
				null, "The jodongo branch is a dairy location", "JDE", loc3, functionList);
		final DairyLocation dLocation2_1 = createDairyLocation(4l, "DLOC21", sdf.parse("4/21/1966"), "856.556.0606",
				null, "The DLOC21 branch is a dairy location", "D21",
				createLocation("DLOC21", "", "", "", "", "", "", "", "some province", ""), functionList);
		final DairyLocation dLocation2_2 = createDairyLocation(5l, "DLOC22", sdf.parse("4/21/1966"), "856.556.0606",
				null, "The DLOC22 branch is a dairy location", "D22",
				createLocation("DLOC22", "", "", "", "", "", "", "", "some province", ""), functionList);
		final DairyLocation dLocation2_3 = createDairyLocation(6l, "DLOC23", sdf.parse("4/21/1966"), "856.556.0606",
				null, "The DLOC23 branch is a dairy location", "D23",
				createLocation("DLOC23", "", "", "", "", "", "", "", "some province", ""), functionList);

		// add the locations to the dairy
		//
		dairy.getBranchLocations().add(dLocation1);
		dairy.getBranchLocations().add(dLocation2);
		dairy.getBranchLocations().add(dLocation3);
		dairy.getBranchLocations().add(dLocation2_1);
		dairy.getBranchLocations().add(dLocation2_2);
		dairy.getBranchLocations().add(dLocation2_3);

		// create some routes
		//
		route1.getStops().add(dLocation1);
		route1.getStops().add(dLocation2);
		route1.getStops().add(dLocation3);

		route2.getStops().add(dLocation2_1);
		route2.getStops().add(dLocation2_2);
		route2.getStops().add(dLocation2_3);

		// add the routes
		//
		dairy.getRoutes().add(route1);
		dairy.getRoutes().add(route2);

		// create some bins
		//
		final List<DairyContainer> bins = createDairyContainer(dairy, 10, 10000);
		dairy.getDairyBins().addAll(bins);

		// create members
		for (int i = 0; i < 20; i++) {
			final int farmId = 5000 + i * 100;
			final List<Farm> farms = createFarms(farmId);
			for (final Farm f : farms) {
				// farmResource.getContents().add(f);
			}
			final Membership member1 = DairyFactory.eINSTANCE.createMembership();
			member1.setMemberId("" + 1000 + i);
			member1.setMember(createFarmer(
					"Joseph - " + i,
					"X",
					"Limuru",
					"609-356-3400" + i,
					createFarm("Joseph - " + i + "'s farm",null)));

			member1.setApplicationDate(sdf.parse(i < 9 ? "02/0" + i + "/2007" : "02/" + i + "/2007"));

			final Date effectiveDate = sdf.parse("03/05/2007");
			member1.setDefaultRoute(route1);
			member1.setEffectiveDate(effectiveDate);
			member1.setStatus(MembershipStatus.ACTIVE);
			member1.getMember().getFarms().addAll(farms);
			if (i % 2 == 0) {
				member1.setDefaultRoute(route2);
			} else {
				member1.setDefaultRoute(route1);
			}
			dairy.getMemberships().add(member1);
		}

		// addRequests(dairy);
		// addSuppliers(dairy);

		return dairy;
	}

	private Route createRoute(long id, String code, String name, String description, Collection<DairyLocation> stops) {
		Route route = DairyFactory.eINSTANCE.createRoute();

		route.setId(id);
		route.setName(name);
		route.setCode(code);
		route.setDescription(description);
		route.getStops().addAll(stops);

		return route;
	}

	private DairyLocation createDairyLocation(long id, String name, Date openDate, String phone, Route route,
			String description, String code, Location location, List<DairyFunction> functions) {
		DairyLocation dLoc = DairyFactory.eINSTANCE.createDairyLocation();

		dLoc.setId(id);
		dLoc.setName(name);
		dLoc.setDateOpened(openDate);
		dLoc.setPhone(phone);
		dLoc.setRoute(route);
		dLoc.setDescription(description);
		dLoc.setCode(code);
		dLoc.setLocation(location);
		dLoc.getFunctions().addAll(functions);

		return dLoc;
	}

	private void addRequests(Dairy dairy) {
		try {
			createReq1(dairy);
			createReq2(dairy);
			createReq3(dairy);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}

	}

	private void addSuppliers(Dairy dairy) {
		try {
			createSupplier1(dairy);
			createSupplier2(dairy);
			createSupplier3(dairy);
		} catch (ParseException pe) {
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
		// //dairyResource.getContents().add(supplier);
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
		// dairyResource.getContents().add(supplier);

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

		supplier.getContacts().add(createPerson("Tommy", "B", "Chong", "212-555-1212"));
		supplier.getContacts().add(createPerson("Bruce", "B", "Willis", "408-555-1212"));

		// dairyResource.getContents().add(supplier);
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

	private void createFarmProperties(Farm farm, int containerNumber, int animalNumber, int containerId, int animalId)
			throws ParseException {
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
			animal1.setRegistrationId(10000 + i);
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

	private List<DairyContainer> createDairyContainer(Dairy dairy, int binNumber, int binId) {
		final List<DairyContainer> binList = new ArrayList<DairyContainer>();
		for (int i = 0; i < binNumber; i++) {
			final DairyContainer bin = DairyFactory.eINSTANCE.createDairyContainer();
			bin.setType(ContainerType.BIN);
			final int id = binId + i;
			bin.setContainerId("" + id);
			// bin.setAssetId(new Long(id).longValue());
			// bin.setTagType("BARCODE");
			// bin.setTagValue("1100100100100111");
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

	Membership randomOrNewMember(Dairy dairy) {
		Membership membership;
		int memberCount = dairy.getMemberships().size();
		if (memberCount > 2) {
			membership = dairy.getMemberships().get(new Random().nextInt(memberCount));
		} else {
			Location farmLocation = createLocation("generated address", "generated section", "generated estate",
					"generated village", "generated sublocation", "generated location",
					"generated district", "generated division", "generated division",
					"generated postcode");
			membership = createMembership(
					new Date(),
					new Date(),
					createFarmer(
							"Barry",
							"",
							"White",
							"1231231233",
							farmLocation,
							Collections.EMPTY_SET,
							Arrays.asList(createFarm("generated farm", farmLocation))));
			dairy.getMemberships().add(membership);
		}
		return membership;
	}

	private void createReq1(Dairy dairy) throws ParseException {
		final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
		req.setRequestId(1001l);
		req.setDate(DateTimeUtils.DATE_FORMAT.parse("05/03/2010"));
		req.setMember(randomOrNewMember(dairy));

		dairy.getAnimalHealthRequests().add(req);

		// MemberShiip
		req.setRequestingMember(randomOrNewMember(dairy));

		req.setType(RequestType.VETERINARY);
		req.setDateHeatDetected(Calendar.getInstance().getTime());
		req.setFirstTreatment(Calendar.getInstance().getTime());
		req.setSecondTreatment(Calendar.getInstance().getTime());
		req.setThirdTreatment(Calendar.getInstance().getTime());
		req.setReportedProblem("problem 1");

		final Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setFarmId(new Long(106001).longValue());
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
		// dairy.getMemberFarms().add(farm);
		// farmResource.getContents().add(farm);

	}

	private void createReq2(Dairy dairy) throws ParseException {
		final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
		req.setRequestId(1002l);
		req.setDate(DateTimeUtils.DATE_FORMAT.parse("04/01/2010"));

		dairy.getAnimalHealthRequests().add(req);

		// MemberShiip
		final Membership ship = randomOrNewMember(dairy);

		

		ship.setMember(createFarmer("Benjamin", "", "Linus", "123", (Farm)null));
		ship.setMemberId("1002");
		req.setRequestingMember(ship);

		req.setType(RequestType.INSEMINATION);
		req.setDateHeatDetected(Calendar.getInstance().getTime());
		req.setFirstTreatment(Calendar.getInstance().getTime());
		req.setSecondTreatment(Calendar.getInstance().getTime());
		req.setThirdTreatment(Calendar.getInstance().getTime());
		req.setReportedProblem("problem 2");

		final Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setFarmId(new Long(106002).longValue());
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
		// dairy.getMemberFarms().add(farm);
		// farmResource.getContents().add(farm);

	}

	private void createReq3(Dairy dairy) throws ParseException {
		final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();
		req.setRequestId(1003l);
		req.setDate(Calendar.getInstance().getTime());

		dairy.getAnimalHealthRequests().add(req);

		// MemberShiip
		final Membership ship = randomOrNewMember(dairy);

		final Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("12345678");
		person.setGivenName("John");
		person.setFamilyName("Smith");
		// dairy.getAnimalHealthRequests().add(person);

		ship.setMember(createFarmer("John", "", "Locke", "123", (Farm)null));
		ship.setMemberId("1003");
		req.setRequestingMember(ship);

		req.setType(RequestType.VETERINARY);
		req.setDateHeatDetected(Calendar.getInstance().getTime());
		req.setFirstTreatment(Calendar.getInstance().getTime());
		req.setSecondTreatment(Calendar.getInstance().getTime());
		req.setThirdTreatment(Calendar.getInstance().getTime());
		req.setReportedProblem("problem 3");

		final Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setFarmId(new Long(106003).longValue());
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
		// dairy.getMemberFarms().add(farm);
		// farmResource.getContents().add(farm);

	}
}
