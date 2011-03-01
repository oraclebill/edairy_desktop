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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.Person;
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

	private String[] args = {};

	private int memberCount = 100;
	private BigDecimal collectionsPerMember = new BigDecimal(3.0f);

	private int employeeCount = 10;
	private int collectionCenterCount = 4;
	private int storeCount = 4;
	private int routeCount = 2;

	private Date startDate = new Date();
	private Date endDate = new Date();

	private Dairy currentDairy;

	public TestDataGenerator() {
		Calendar cal = Calendar.getInstance();
		endDate = new Date();
		cal.setTime(endDate);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		endDate = cal.getTime();

		cal.add(Calendar.DAY_OF_YEAR, -30);
		startDate = cal.getTime();
	}

	/**
	 * @return the args
	 */
	public String[] getArgs() {
		return args;
	}

	/**
	 * @param args
	 *            the args to set
	 */
	public void setArgs(String[] args) {
		this.args = args;
	}

	/**
	 * @return the memberCount
	 */
	public int getMemberCount() {
		return memberCount;
	}

	/**
	 * @param memberCount
	 *            the memberCount to set
	 */
	public void setMemberCount(int memberCount) {
		this.memberCount = memberCount;
	}

	/**
	 * @return the collectionsPerMember
	 */
	public float getCollectionsPerMember() {
		return collectionsPerMember.floatValue();
	}

	/**
	 * @param collectionsPerMember
	 *            the collectionsPerMember to set
	 */
	public void setCollectionsPerMember(float collectionsPerMember) {
		this.collectionsPerMember = new BigDecimal(collectionsPerMember);
	}

	/**
	 * @return the employeeCount
	 */
	public int getEmployeeCount() {
		return employeeCount;
	}

	/**
	 * @param employeeCount
	 *            the employeeCount to set
	 */
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	/**
	 * @return the collectionCenterCount
	 */
	public int getCollectionCenterCount() {
		return collectionCenterCount;
	}

	/**
	 * @param collectionCenterCount
	 *            the collectionCenterCount to set
	 */
	public void setCollectionCenterCount(int collectionCenterCount) {
		this.collectionCenterCount = collectionCenterCount;
	}

	/**
	 * @return the storeCount
	 */
	public int getStoreCount() {
		return storeCount;
	}

	/**
	 * @param storeCount
	 *            the storeCount to set
	 */
	public void setStoreCount(int storeCount) {
		this.storeCount = storeCount;
	}

	/**
	 * @return the routeCount
	 */
	public int getRouteCount() {
		return routeCount;
	}

	/**
	 * @param routeCount
	 *            the routeCount to set
	 */
	public void setRouteCount(int routeCount) {
		this.routeCount = routeCount;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger.getLogger("org.eclipse.emf.teneo").setLevel(Level.INFO);
		Logger.getLogger("org.hibernate").setLevel(Level.WARN);
		TestDataGenerator generator = new TestDataGenerator();
		generator.run(args);
	}

	/**
	 * @param args
	 */
	public void run(String[] args) {
		setArgs(args);
		run();
	}

	public void run() {

		processCommandLineArgs();

		createDatabase();

		initializeDataStore();
		// generateSchema();

		setSession(openSession());
		Dairy dairy = createDairy("TEST1");
		updateDairy(dairy);

		populateBaseReferenceData();

		Transaction tx;

		tx = getSession().beginTransaction();
		generateEmployees(getEmployeeCount());
		tx.commit();

		tx = getSession().beginTransaction();
		generateRoutesAndCollectionCenters(getRouteCount(), getCollectionCenterCount());
		tx.commit();

		tx = getSession().beginTransaction();
		generateDairyBins();
		tx.commit();

		tx = getSession().beginTransaction();
		generateCustomers();
		tx.commit();

		tx = getSession().beginTransaction();
		generateMembers(getMemberCount());
		tx.commit();

		tx = getSession().beginTransaction();
		generateCollectionData();
		tx.commit();
	}

	/**
	 * @param args
	 */
	protected void processCommandLineArgs() {
		for (String arg : getArgs()) {
			String[] split = arg.split("=");
			try {
				BeanUtils.setProperty(this, split[0], split[1]);
			} catch (Exception e) {
				System.err.println(e.getMessage() + ": Failed to set property: " + split[0] + " to " + split[1]);
			}
		}
	}

	private void updateDairy(Dairy currentDairy) {
		System.out.println("Generating Dairy");

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
		System.out.println("Generating Employees");
		// we need one driver per route - they will be created in the dairy
		// setup..
		count -= getRouteCount();
		Assert.isLegal(count >= 0);
		setEmployeeCount(count);

		Person person;
		Employee employee;

		for (int i = 0; i < count; i++) {
			employee = createEmployee("Clerk");
			currentDairy.getEmployees().add(employee);
			getSession().persist(employee);
		}
	}

	private int binSequence = 0;

	private void generateDairyBins() {
		System.out.println("Generating Bins...");
		Bin container;
		int routeCount = currentDairy.getRoutes().size();
		double binCapacity = 125.0d;
		int totalBinCount = (int) Math.floor((collectionsPerMember.doubleValue() * memberCount) / binCapacity) * 3; // clean,
// dirty,
// spare
		for (TransportRoute route : currentDairy.getRoutes()) {
			for (int i = 0; i < totalBinCount / currentDairy.getRoutes().size(); i++) {
				container = DairyFactory.eINSTANCE.createBin();
				container.setTrackingNumber(String.format("T%08d", ++binSequence));
				container.setCapacity(binCapacity);
				container.setStatus("ACTIVE");
				container.setZone(route);
				currentDairy.getDairyBins().add(container);
				getSession().persist(container);
			}
		}
	}

	private void generateCustomers() {
		System.out.println("Generating Customer...");
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
		System.out.println("Generating Members...");
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
			System.out.println("\tGenerating Route: " + routeNum);
			route = createRouteVehicleAndDriver(routeNum);
			for (int i = 0; i < centersPerRoute; i++) {
				stopCount += 1;
				System.out.println("\t\tGenerating Center: " + stopCount);
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
		Person person;
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
		currentDate.setTime(getStartDate());

		endDate = Calendar.getInstance();
		endDate.setTime(getEndDate());

		for (; currentDate.before(endDate); currentDate.add(Calendar.DAY_OF_YEAR, 1)) {
			generateCollectionData(currentDate.getTime());
		}
	}

	/**
	 * @param collectionDate
	 */
	private void generateCollectionData(Date collectionDate) {
		System.out.println("Generating Collection Data for " + collectionDate);
		Map<TransportRoute, Collection<CollectionGroup>> groupMap;
		BigDecimal collectionAmount = new BigDecimal(getCollectionsPerMember());
		for (CollectionSession session : currentDairy.getCollectionSessions()) {
			System.out.println("\tSession " + session);
			groupMap = 
				generateSessionCollections(collectionDate, session, collectionAmount);
			generateSessionSales(groupMap, session);
			collectionAmount = collectionAmount.divide(new BigDecimal(3.0d));
		}

	}

	private void generateSessionSales(Map<TransportRoute, Collection<CollectionGroup>> groupMap,
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
	}

	private Map<TransportRoute, Collection<CollectionGroup>> generateSessionCollections(Date collectionDate,
			CollectionSession session, BigDecimal memberCollectionAmount) {
		Map<TransportRoute, Collection<CollectionGroup>> groupMap;
		List<Membership> filteredMembers;
		List<Bin> binList;
		Collection<CollectionGroup> collectionSet;
		CollectionGroup group;
		Bin bin;
		CollectionJournalLine entry;
		groupMap = new HashMap<TransportRoute, Collection<CollectionGroup>>();
		for (DairyLocation center : currentDairy.getBranchLocations()) {
			System.out.println("\t\tCenter " + center);
			filteredMembers = filterMembersByDefaultRoute(center);
			group = createCollectionGroup(center, collectionDate, session);
			collectionSet = groupMap.get(center.getRoute());
			if (collectionSet == null) {
				collectionSet = new ArrayList<CollectionGroup>();
				groupMap.put(center.getRoute(), collectionSet);
			}
			collectionSet.add(group);
// System.out.println("\t\tGroup " + group );
			binList = getBinsForCenterAndSession(center, session);
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
			if (bin.getQuantity() == 0d && bin.getStatus() == "ACTIVE") {
				binList.add(bin);
			}
		}
		return binList;
	}

	private Bin getNextAvailableBin(List<Bin> binList,
			BigDecimal amount) {
		for (Bin bin : binList) {
			if (bin.getQuantity() + amount.doubleValue() < bin.getCapacity())
				return bin;
		}
		return null;
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

	/**
	 * @param center
	 * @param collectionDate
	 * @param session
	 * @return
	 */
	int referenceCounter = 0;

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
		group.setReferenceNumber(String.format("REF%05d", ++referenceCounter));
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
		bin.setQuantity(bin.getQuantity() + amount.doubleValue());
		entry.setFlagged(false);
		return entry;
	}

	private int empCount = 0;

	private Employee createEmployee(String jobFunction) {
		final Employee emp = DairyFactory.eINSTANCE.createEmployee();
		++empCount;
		emp.setEmployeeNumber(String.format("M%05d", empCount));

		// copy person fields
		emp.setGivenName(String.format("first:%d", empCount));
		emp.setMiddleName(String.format("middle:%d", empCount));
		emp.setFamilyName(String.format("last:%d", empCount));
		emp.setLocation(DairyUtil.createLocation(null, null, null));

		emp.setStartDate(startDate);
		emp.setJobFunction(jobFunction);
		emp.setNssfNumber(String.format("NSSF:%s", empCount));
		emp.setNationalId(String.format("NATID:%s", empCount));

		return emp;
	}

}
