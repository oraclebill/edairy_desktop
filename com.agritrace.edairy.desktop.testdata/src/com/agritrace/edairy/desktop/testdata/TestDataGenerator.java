package com.agritrace.edairy.desktop.testdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSale;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.tracking.Purpose;
import com.agritrace.edairy.desktop.common.model.tracking.RearingMode;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.RegisteredAnimal;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;

/**
 * @author bjones
 * 
 *         TODO: finish me!!
 * 
 */
public class TestDataGenerator extends DatabaseSetup {

	private int sequence;
	private Dairy currentDairy;
	private TestDataGeneratorConfig config;

	/**
	 * 
	 */
	public TestDataGenerator() {
		this(new TestDataGeneratorConfig(100, new BigDecimal(3.0f), 10, 4, 4, 2, new Date(), new Date()));
	}

	/**
	 * @param config
	 */
	public TestDataGenerator(TestDataGeneratorConfig config) {
		this.config = config;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger.getLogger("org.eclipse.emf.teneo").setLevel(Level.INFO);
		Logger.getLogger("org.hibernate").setLevel(Level.WARN);
		TestDataGeneratorConfig config = new TestDataGeneratorConfig(args);
		TestDataGenerator generator = new TestDataGenerator(config);
		generator.run();
	}

	public void run() {

		createDatabase();

		initializeDataStore();
		// generateSchema();

		setSession(openSession());
		Dairy dairy = createDairy("TEST1");
		updateDairy(dairy);

		populateBaseReferenceData();

		Transaction tx;

		tx = getSession().beginTransaction();
		generateEmployees(config.getEmployeeCount());
		tx.commit();

		tx = getSession().beginTransaction();
		generateRoutesAndCollectionCenters(config.getRouteCount(), config.getCollectionCenterCount());
		tx.commit();

		tx = getSession().beginTransaction();
		generateDairyBins();
		tx.commit();

		tx = getSession().beginTransaction();
		generateCustomers();
		tx.commit();

		tx = getSession().beginTransaction();
		generateMembers(config.getMemberCount());
		tx.commit();

		tx = getSession().beginTransaction();
		generateCollectionData();
		tx.commit();
	}

	private void updateDairy(Dairy currentDairy) {
		System.err.println("Generating Dairy");

		String companyId = currentDairy.getRegistrationNumber();

		currentDairy.setCompanyName("Test company " + companyId);
		currentDairy.setDescription(companyId);
		currentDairy.setLegalName(companyId);
		currentDairy.setFederalPin("fed:" + companyId);
		currentDairy.setLicenseEffectiveDate(new Date(0l));
		currentDairy.setLocation(DairyUtil.createLocation(companyId + " address", companyId + " section", companyId
				+ " estate", companyId + " village", companyId + " subLocation", companyId + " location", companyId
				+ " district", companyId + " division", companyId + " province", companyId + " postCode"));
		currentDairy.setManagerName("mgr:" + companyId);
		currentDairy.setNhifNumber("nhif" + companyId);
		currentDairy.setNssfNumber("nssf:" + companyId);
		currentDairy.setPhoneNumber("phone:" + companyId);
		getSession().merge(currentDairy);
		this.currentDairy = currentDairy;
	}

	private void generateEmployees(int count) {
		System.err.println("Generating Employees");
		// we need one driver per route - they will be created in the dairy
		// setup..
		count -= config.getRouteCount();
		Assert.isLegal(count >= 0);
		config.setEmployeeCount(count);

		Employee employee;

		for (int i = 0; i < count; i++) {
			employee = createEmployee("Clerk");
			currentDairy.getEmployees().add(employee);
			getSession().persist(employee);
		}
	}

	private void generateDairyBins() {
		System.err.println("Generating Bins...");
		Bin container;
		double binCapacity = 125.0d;
		int totalBinCount = (int) Math.floor((config.getCollectionsPerMember().doubleValue() * config.getMemberCount())
				/ binCapacity) * 4; // clean, dirty, spare, spare
		System.err.println("Total bin count " + totalBinCount);
		for (TransportRoute route : currentDairy.getRoutes()) {
			for (int i = 0; i < totalBinCount / currentDairy.getRoutes().size(); i++) {
				container = DairyFactory.eINSTANCE.createBin();
				container.setTrackingNumber(String.format("T%08d", ++sequence));
				container.setCapacity(binCapacity);
				container.setStatus("ACTIVE");
				container.setZone(route);
				currentDairy.getDairyBins().add(container);
				getSession().persist(container);
			}
		}
	}

	private void generateCustomers() {
		System.err.println("Generating Customer...");
		Customer customer;
		int customerCount = currentDairy.getRoutes().size();
		for (int i = 0; i < customerCount; i++) {
			customer = DairyFactory.eINSTANCE.createCustomer();
			customer.setCompanyName("Company " + i);
			customer.setCustomerNumber("Company " + i);
			customer.setCustomerType("Processor");
			customer.setLegalName("");
			customer.setStatus("Active");
			customer.setPhoneNumber("123123123");
			customer.setLocation(DairyUtil.createLocation(null, null, null));
			currentDairy.getCustomers().add(customer);
			getSession().persist(customer);
		}
	}

	private void generateMembers(int memberCount) {
		System.err.println("Generating Members...");
		Location farmLocation;
		Membership member;
		Farmer farmer;
		Farm farm;
		RegisteredAnimal animal;
		ReferenceAnimalType breed;

		breed = TrackingFactory.eINSTANCE.createReferenceAnimalType();
		breed.setBreed("Friesian");
		breed.setSpecies("Cattle");
		getSession().persist(breed);

		int centerCount = currentDairy.getBranchLocations().size();
		for (int count = 0; count < memberCount; count++) {
			farmLocation = DairyUtil.createLocation(null, null, null);
			farm = DairyUtil.createFarm("Farm " + count, farmLocation);
			getSession().persist(farm);
			animal = DairyUtil.createAnimal(farm, new Date(), "Farm: " + farm.getName() + " - Animal #" + count,
					Gender.FEMALE, breed, Purpose.DAIRY, RearingMode.ZEROGRAZE);
			farm.getAnimals().add(animal);
			getSession().persist(animal);
			farmer = DairyUtil.createFarmer("Farmer " + count, "", "Farmer " + count, "1231231234", farm);
			getSession().persist(farmer);
			member = DairyUtil.createMembership(new Date(0), new Date(count * 10000), farmer);
			member.setMemberNumber(String.format("M%05d", count));
			member.getAccount().setAccountNumber(member.getMemberNumber());
			member.setDefaultRoute(currentDairy.getBranchLocations().get(count % centerCount));
			currentDairy.getMemberships().add(member);
			getSession().persist(member);
		}
	}

	private void generateRoutesAndCollectionCenters(int routeCount,
			int totalStops) {
		System.out.format("Generating %d Routes and %d Collection Centers...\n", routeCount, totalStops);
		int centersPerRoute = totalStops / routeCount;
		Assert.isLegal(centersPerRoute > 0);

		int stopCount = 0;
		TransportRoute route = null;
		for (int routeNum = 0; routeNum < routeCount; routeNum++) {
			System.err.println("\tGenerating Route: " + routeNum);
			route = createRouteVehicleAndDriver(routeNum);
			for (int i = 0; i < centersPerRoute; i++) {
				stopCount += 1;
				System.err.println("\t\tGenerating Center: " + stopCount);
				createCenterForRoute(route, stopCount);
			}
		}
		for (; stopCount < totalStops; stopCount++) {
			createCenterForRoute(route, stopCount);
		}
	}

	private TransportRoute createRouteVehicleAndDriver(int routeCount) {
		Vehicle vehicle;
		TransportRoute route;
		Employee driver;
		driver = createEmployee("Driver");
		currentDairy.getEmployees().add(driver);
		getSession().persist(driver);

		vehicle = DairyUtil.createVehicle(String.format("VL%s", driver.getEmployeeNumber()),
				String.format("REG%s", driver.getEmployeeNumber()), 1990, "Mitsu", "FUSO", "White", 4495.0d,
				"TA260283", new Date(0), "TA260283", driver, null, null);
		currentDairy.getVehicles().add(vehicle);
		getSession().persist(vehicle);

		route = DairyFactory.eINSTANCE.createTransportRoute();
		route.setName(vehicle.getLogBookNumber());
		route.setVehicle(vehicle);
		currentDairy.getRoutes().add(route);
		getSession().persist(route);

		return route;
	}

	/**
	 * @param route
	 * @param stopCount
	 */
	private void createCenterForRoute(TransportRoute route,
			int stopCount) {
		DairyLocation center;
		String centerCode = String.format("L%04d", stopCount);
		center = DairyUtil.createDairyLocation("Center: " + centerCode, centerCode, "999-999-9999", "Description for "
				+ centerCode, new Date(10 * 86400 + stopCount * 86400), DairyUtil.createLocation(null, null, null),
				route);
		currentDairy.getBranchLocations().add(center);
		getSession().persist(center);
	}

	/**
	 * @param collectionDate
	 */
	private void generateCollectionData() {
		Calendar currentDate, endDate;

		currentDate = Calendar.getInstance();
		currentDate.setTime(config.getStartDate());

		endDate = Calendar.getInstance();
		endDate.setTime(config.getEndDate());

		for (; currentDate.before(endDate); currentDate.add(Calendar.DAY_OF_YEAR, 1)) {
			generateCollectionData(currentDate.getTime());
		}
	}

	/**
	 * @param collectionDate
	 */
	private void generateCollectionData(Date collectionDate) {
		System.err.println("Generating Collection Data for " + collectionDate);
		Map<TransportRoute, Collection<CollectionGroup>> groupMap;
		BigDecimal collectionAmount = config.getCollectionsPerMember();
		for (CollectionSession session : currentDairy.getCollectionSessions()) {
			System.err.println("\tSession Collections " + session);
			resetBinQuantities();
			groupMap = generateSessionCollections(collectionDate, session, collectionAmount);
			System.err.println("\tSession Sales " + session);
			generateSessionSales(collectionDate, groupMap, session);
			collectionAmount = collectionAmount.divide(new BigDecimal(2));
		}

	}

	private void resetBinQuantities() {
		for (Bin bin : currentDairy.getDairyBins()) {
			bin.setQuantity(0);
		}
	}

	private void generateSessionSales(Date saleDate, Map<TransportRoute, Collection<CollectionGroup>> groupMap,
			CollectionSession session) {
		Set<Bin> binSet;

		binSet = new HashSet<Bin>();
		for (Collection<CollectionGroup> groups : groupMap.values()) {
			for (CollectionGroup group : groups) {
				for (CollectionJournalLine entry : group.getJournalEntries()) {
					if (!binSet.contains(entry.getBin())) {
						binSet.add(entry.getBin());
					}
				}
			}
		}
		MilkGrade grade = null;
		Customer customer = null;
		double unitPrice = 22.0d;
		for (Bin bin : binSet) {
			double quantity = bin.getQuantity();
			MilkSale sale = DairyFactory.eINSTANCE.createMilkSale();
			sale.setBin(bin);
			sale.setContractSale(true);
			sale.setCustomer(customer);
			sale.setGrade(grade);
			sale.setQuantity(new BigDecimal(quantity));
			sale.setReferenceNumber(String.format("SALE%05d", ++sequence));
			sale.setSaleAmount(new BigDecimal(unitPrice * quantity));
			sale.setSaleDate(saleDate);
			sale.setRejected(false);
			sale.setSaleType(MilkSaleType.CREDIT);
			sale.setStoreOrRoute(null); // should be the last center from the route? 
			sale.setUnitPrice(new BigDecimal(unitPrice));
			getSession().persist(sale);
		}
	}

	private Map<TransportRoute, Collection<CollectionGroup>> generateSessionCollections(Date collectionDate,
			CollectionSession session,
			BigDecimal memberCollectionAmount) {
		Map<TransportRoute, Collection<CollectionGroup>> groupMap;
		List<Membership> filteredMembers;
		List<Bin> binList;
		Collection<CollectionGroup> collectionSet;
		CollectionGroup group;
		Bin bin;
		CollectionJournalLine entry;
		groupMap = new HashMap<TransportRoute, Collection<CollectionGroup>>();
		for (DairyLocation center : currentDairy.getBranchLocations()) {
			System.err.println("\t\tCenter " + center);
			filteredMembers = filterMembersByDefaultRoute(center);
			group = createCollectionGroup(center, collectionDate, session);
			collectionSet = groupMap.get(center.getRoute());
			if (collectionSet == null) {
				collectionSet = new ArrayList<CollectionGroup>();
				groupMap.put(center.getRoute(), collectionSet);
			}
			collectionSet.add(group);
// System.err.println("\t\tGroup " + group );
//			binList = getBinsForCenterAndSession(center, session);
			binList = center.getRoute().getBins();
			for (Membership member : filteredMembers) {
				bin = getNextAvailableBin(binList, memberCollectionAmount);
				entry = createCollectionEntry(group, bin, member, memberCollectionAmount);
			}
			getSession().persist(group);
		}
		return groupMap;
	}

	private List<Bin> getBinsForCenterAndSession(DairyLocation center,
			CollectionSession session) {
		TransportRoute route = center.getRoute();
		List<Bin> binList = new LinkedList<Bin>();
		for (Bin bin : route.getBins()) {
			System.err.println("Testing bin : " + bin);			
			if (bin.getQuantity() < bin.getCapacity()  && bin.getStatus() == "ACTIVE") {
				binList.add(bin);
			}
		}
		return binList;
	}

	private Bin getNextAvailableBin(List<Bin> binList,
			BigDecimal amount) {
		Assert.isLegal(binList.size() > 0);
		System.err.println("checking binList: " + binList);		
		for (Bin bin : binList) {
			System.err.println("checking bin: " + bin);
			if (bin.getQuantity() + amount.doubleValue() < bin.getCapacity())
				return bin;
		}
		throw new RuntimeException("Bin not found: " + binList.size());
	}

	private List<Membership> filterMembersByDefaultRoute(DairyLocation center) {
		LinkedList<Membership> l = new LinkedList<Membership>();
		for (Membership m : currentDairy.getMemberships()) {
			if (m.getDefaultRoute() == center) {
				l.add(m);
			}
		}
		return l;
	}

	private CollectionGroup createCollectionGroup(DairyLocation center,
			Date collectionDate,
			CollectionSession session) {
		CollectionGroup group;

		group = DairyFactory.eINSTANCE.createCollectionGroup();
		group.setJournalId(Long.valueOf(group.hashCode()));
		group.setJournalDate(collectionDate);
		group.setCollectionCenter(center);
		group.setSession(session);
		group.setType(CollectionGroupType.JOURNAL_GROUP);
		group.setVehicle(center.getRoute().getVehicle());
		group.setDriver(group.getVehicle().getDriver());
		group.setReferenceNumber(String.format("REF%05d", ++sequence));
		return group;
	}

	/**
	 * @param group
	 * @param bin
	 * @param member
	 * @param amount
	 * @return
	 */
	private CollectionJournalLine createCollectionEntry(CollectionGroup group,
			Bin bin,
			Membership member,
			BigDecimal amount) {
		Assert.isLegal((bin.getQuantity() + amount.doubleValue()) <= bin.getCapacity(), "bin capacity exceeded");

		CollectionJournalLine entry = DairyFactory.eINSTANCE.createCollectionJournalLine();

		entry.setCollectionJournal(group);
		entry.setBin(bin);
		entry.setRecordedMember(member.getMemberNumber());
		entry.setValidatedMember(member);
		entry.setQuantity(amount);
		entry.setFlagged(false);

		bin.getCollections().add(entry);
		bin.setQuantity(bin.getQuantity() + amount.doubleValue());

		return entry;
	}

	private Employee createEmployee(String jobFunction) {
		final Employee emp = DairyFactory.eINSTANCE.createEmployee();
		++sequence;
		emp.setEmployeeNumber(String.format("M%05d", sequence));

		// copy person fields
		emp.setGivenName(String.format("first:%d", sequence));
		emp.setMiddleName(String.format("middle:%d", sequence));
		emp.setFamilyName(String.format("last:%d", sequence));
		emp.setLocation(DairyUtil.createLocation(null, null, null));

		emp.setStartDate(config.getStartDate());
		emp.setJobFunction(jobFunction);
		emp.setNssfNumber(String.format("NSSF:%s", sequence));
		emp.setNationalId(String.format("NATID:%s", sequence));

		return emp;
	}

}
