package com.agritrace.edairy.desktop.install.dbsetup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.ContactMethodType;
import com.agritrace.edairy.desktop.common.model.base.Gender;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
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
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleGroup;
import com.agritrace.edairy.desktop.common.model.dairy.MilkSaleType;
import com.agritrace.edairy.desktop.common.model.dairy.TransportRoute;
import com.agritrace.edairy.desktop.common.model.dairy.Trip;
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
public class TestDataGenerator extends DatabaseSetupUtil
{

	private int						sequence;
	private Dairy					currentDairy;
	private TestDataGeneratorConfig	config;

	/**
	 * 
	 */
	public TestDataGenerator()
	{
		this(new TestDataGeneratorConfig(100, new BigDecimal(3.0f), 10, 4, 4, 2, new Date(), new Date()));
	}

	/**
	 * @param config
	 */
	public TestDataGenerator(TestDataGeneratorConfig config)
	{
		this.config = config;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BasicConfigurator.configure();
		Logger.getLogger("org.eclipse.emf.teneo").setLevel(Level.INFO);
		Logger.getLogger("org.hibernate").setLevel(Level.WARN);
		TestDataGeneratorConfig config = new TestDataGeneratorConfig(args);
		TestDataGenerator generator = new TestDataGenerator(config);
		generator.run();
	}

	public void run()
	{
		Transaction tx;

		createDatabase();

		initializeDataStore();
		// generateSchema();

		setSession(openSession());

		tx = getSession().beginTransaction();
		initializeWorkingDairy();
		tx.commit();

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

	public void initializeWorkingDairy()
	{
		currentDairy = createDairy("TEST1");
		updateDairyProfile(currentDairy);
		createSeedData(currentDairy);
	}

	public Dairy getWorkingDairy()
	{
		return currentDairy;
	}

	private void updateDairyProfile(Dairy currentDairy)
	{
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

	public void generateEmployees(int count)
	{
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
		}
	}

	/**
	 * 
	 */
	private void generateDairyBins()
	{
		System.err.println("Generating Bins..." + getSession().contains(currentDairy));
		double binCapacity = 125.0d;
		int totalBinCount = (int) Math.floor((config.getCollectionsPerMember().doubleValue() * config.getMemberCount())
				/ binCapacity) * 4; // clean, dirty, spare, spare
		System.err.println("Total bin count " + totalBinCount);
		generateDairyBins(totalBinCount, binCapacity);
	}

	public void generateDairyBins(	int count,
									double capacity)
	{
		Assert.isLegal(getSession().contains(currentDairy));
		Bin container;
		for (TransportRoute route : currentDairy.getRoutes()) {
			for (int i = 0; i < count / currentDairy.getRoutes().size(); i++) {
				container = DairyFactory.eINSTANCE.createBin();
				container.setTrackingNumber(String.format("T%08d", ++sequence));
				container.setCapacity(capacity);
				container.setStatus("ACTIVE");
				container.setZone(route);
				System.err.println("Adding bin to dairy: " + container);
				currentDairy.getDairyBins().add(container);
			}
		}
	}

	private void generateCustomers()
	{
		System.err.println("Generating Customer...");
		int customerCount = currentDairy.getRoutes().size();
		generateCustomers(customerCount);
	}

	public void generateCustomers(int count)
	{
		Assert.isLegal(getSession().contains(currentDairy));
		Customer customer;
		for (int i = 0; i < count; i++) {
			customer = DairyFactory.eINSTANCE.createCustomer();
			customer.setCompanyName("Company " + i);
			customer.setCustomerNumber("Company " + i);
			customer.setCustomerType("Processor");
			customer.setLegalName("<legal name>");
			customer.setStatus("Active");
			customer.setPhoneNumber("123123123");
			customer.setLocation(DairyUtil.createLocation(null, null, null));
			currentDairy.getCustomers().add(customer);
		}
	}

	public void generateMembers(int memberCount)
	{
		Assert.isLegal(getSession().contains(currentDairy));
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
			farmLocation = DairyUtil.createLocation("address " + count, "section ", "estate", "village",
					"sub-location", "location", "Kiambu", "Kiambu", "Kiambu", "000000");
			farm = DairyUtil.createFarm("Farm " + count, farmLocation);
			animal = DairyUtil.createAnimal(farm, new Date(), "Farm: " + farm.getName() + " - Animal #" + count,
					Gender.FEMALE, breed, Purpose.DAIRY, RearingMode.ZEROGRAZE);
			farm.getAnimals().add(animal);
			farmer = DairyUtil.createFarmer("Farmer " + count, "", "Farmer " + count, "1231231234", farm);
			member = DairyUtil.createMembership(new Date(0), new Date(count * 10000), farmer);
			member.setMemberNumber(String.format("M%05d", count));
			member.getAccount().setAccountNumber(member.getMemberNumber());
			member.setDefaultRoute(currentDairy.getBranchLocations().get(count % centerCount));
			currentDairy.getMemberships().add(member);
		}
	}

	public void generateRoutesAndCollectionCenters(	int routeCount,
													int totalStops)
	{
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

	private TransportRoute createRouteVehicleAndDriver(int routeCount)
	{
		Vehicle vehicle;
		TransportRoute route;
		Employee driver;
		driver = createEmployee("Driver");
		currentDairy.getEmployees().add(driver);

		vehicle = DairyUtil.createVehicle(String.format("VL%s", driver.getEmployeeNumber()),
				String.format("REG%s", driver.getEmployeeNumber()), 1990, "Mitsu", "FUSO", "White", 4495.0d,
				"TA260283", new Date(0), "TA260283", driver, null, null);
		currentDairy.getVehicles().add(vehicle);

		route = DairyFactory.eINSTANCE.createTransportRoute();
		route.setName(vehicle.getLogBookNumber());
		route.setVehicle(vehicle);
		currentDairy.getRoutes().add(route);

		return route;
	}

	/**
	 * @param route
	 * @param stopNumber
	 */
	private void createCenterForRoute(	TransportRoute route,
										int stopNumber)
	{
		DairyLocation center;
		String centerCode = String.format("L%04d", stopNumber);
		Location location = EcoreUtil.copy(getWorkingDairy().getLocation());
		Assert.isNotNull(location);
		center = DairyUtil.createDairyLocation("Center: " + centerCode, centerCode, "999-999-9999", "Description for "
				+ centerCode, new Date(10 * 86400 + stopNumber * 86400), location, route);
		route.getStops().add(center);
		currentDairy.getBranchLocations().add(center);
	}

	/**
	 * @param collectionDate
	 */
	private void generateCollectionData()
	{
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
	private void generateCollectionData(Date collectionDate)
	{
		System.err.println("Generating Collection Data for " + collectionDate);
		BigDecimal collectionAmount = config.getCollectionsPerMember();
		System.err.println("\tSession Collections "
				+ ((Dairy) getSession().load("Dairy", new Long(1))).getCollectionSessions());
		for (CollectionSession session : currentDairy.getCollectionSessions()) {
			System.err.println("\tSession Collections " + getSession().load("Dairy", new Long(1)));
// resetBinQuantities();
			generateTripsForSession(collectionDate, session, collectionAmount);
			System.err.println("\tSession Sales " + session);
			collectionAmount = collectionAmount.divide(new BigDecimal(2));
		}

	}

// private void resetBinQuantities()
// {
// for (Bin bin : currentDairy.getDairyBins()) {
// bin.setQuantity(0);
// }
// }

	/**
	 * Generate a set of trips, one per session-date. Use memberCollectionAmount as the amount each member contributes
	 * in AM.
	 * 
	 * @param collectionDate
	 * @param session
	 * @param memberCollectionAmount
	 * @return
	 */
	private List<Trip> generateTripsForSession(	Date collectionDate,
												CollectionSession session,
												BigDecimal memberCollectionAmount)
	{
		List<Trip> tripList;

		tripList = new ArrayList<Trip>();

		for (TransportRoute route : currentDairy.getRoutes()) {
			Trip trip = generateTrip(route, collectionDate, session, memberCollectionAmount);
			getSession().persist(trip);
			tripList.add(trip);
		}

		return tripList;
	}

	/**
	 * Generate a single trip for a particular route-session-date.
	 * 
	 * @param route
	 * @param collectionDate
	 * @param session
	 * @param memberCollectionAmount
	 * @return
	 */
	private Trip generateTrip(	TransportRoute route,
								Date collectionDate,
								CollectionSession session,
								BigDecimal memberCollectionAmount)
	{
		Trip trip;

		trip = createTrip(route, collectionDate, session);
		generateTripCollections(trip, route, collectionDate, session, memberCollectionAmount);
		generateTripSales(trip, route, collectionDate, session);

		return trip;
	}

	/**
	 * Generate collections for a trip.
	 * 
	 * @param trip
	 * @param route
	 * @param collectionDate
	 * @param session
	 * @param memberCollectionAmount
	 */
	private void generateTripCollections(	Trip trip,
											TransportRoute route,
											Date collectionDate,
											CollectionSession session,
											BigDecimal memberCollectionAmount)
	{
		System.err.format("@@@ Generating trip collections: %s : %s : %s\n", trip, session, route);
		List<Bin> binList = new LinkedList<Bin>();
		CollectionGroup group;

		binList.addAll(route.getBins());
		for (Bin bin : binList) {
			bin.setQuantity(0);
		}
		for (DairyLocation center : route.getStops()) {
			group = generateTripCollectionGroup(center, collectionDate, session, binList, memberCollectionAmount);
			trip.getCollections().add(group);
		}
	}

	/**
	 * Generate sales for a trip.
	 * 
	 * 
	 * @param trip
	 * @param route
	 * @param collectionDate
	 * @param session
	 */
	private void generateTripSales(	Trip trip,
									TransportRoute route,
									Date collectionDate,
									CollectionSession session)
	{
		DairyLocation center;
		MilkSaleGroup saleGroup;
		MilkSale sale;
		Map<Bin, List<CollectionJournalLine>> centerBinCollections;
		int binCount;
		System.err.format("\t@@@ Generating trip sales: %s : %s : %s\n", trip, session, route);

		MilkGrade grade = getBaseGrade();
		double unitPrice = 22.0d;

		for (CollectionGroup group : trip.getCollections()) {
			center = group.getCollectionCenter();

			centerBinCollections = sortCollectionsByBin(group);
			binCount = centerBinCollections.keySet().size() / 2;

			// create iterator for all bins
			Iterator<Bin> binIter = centerBinCollections.keySet().iterator();

			// create cash sale group with half the bins
			if (binCount > 0) {
				saleGroup = createMilkSaleGroup(route, collectionDate, session, null);
				while (binIter.hasNext() && binCount > 0) {
					Bin bin = binIter.next();
					binCount--;

					System.err.format("\t\t@@@ Generating cash sale from bin: %s\n", bin);
					sale = createMilkSale(center, collectionDate, session, grade, null, unitPrice, bin,
							calculateCollectionVolume(centerBinCollections.get(bin)));
					saleGroup.getSales().add(sale);
				}
				trip.getDeliveries().add(saleGroup);
			}

			// create customer sale group for remaining bins
			Customer customer = findCustomersForTransportRoute(route).get(0);
			saleGroup = createMilkSaleGroup(route, collectionDate, session, customer);
			while (binIter.hasNext()) {
				Bin bin = binIter.next();

				System.err.format("\t\t@@@ Generating credit sale from bin: %s\n", bin);
				sale = createMilkSale(center, collectionDate, session, grade, customer, unitPrice, bin,
						calculateCollectionVolume(centerBinCollections.get(bin)));
				saleGroup.getSales().add(sale);
			}
			trip.getDeliveries().add(saleGroup);
		}
	}

	private Map<Bin, List<CollectionJournalLine>> sortCollectionsByBin(CollectionGroup group)
	{
		Map<Bin, List<CollectionJournalLine>> centerBinCollections;
		centerBinCollections = new HashMap<Bin, List<CollectionJournalLine>>();
		for (CollectionJournalLine entry : group.getEntries()) {
			List<CollectionJournalLine> binCollections = centerBinCollections.get(entry.getBin());
			if (binCollections == null) {
				binCollections = new ArrayList<CollectionJournalLine>();
				centerBinCollections.put(entry.getBin(), binCollections);
			}
			binCollections.add(entry);
		}
		return centerBinCollections;
	}

	private double calculateCollectionVolume(List<CollectionJournalLine> collectionList)
	{
		double sum = 0.0d;
		for (CollectionJournalLine entry : collectionList) {
			BigDecimal entryValue = entry.getQuantity();
			if (!entry.isRejected() && entryValue != null) {
				sum += entryValue.doubleValue();
			}
		}
		return sum;
	}

	private CollectionGroup generateTripCollectionGroup(DairyLocation center,
														Date collectionDate,
														CollectionSession session,
														List<Bin> binList,
														BigDecimal memberCollectionAmount)
	{
		List<Membership> filteredMembers;
		CollectionGroup group;
		Bin bin;
		double binFree;

		group = createCollectionGroup(center, collectionDate, session);
		filteredMembers = findFarmersForCollectionCenter(center);
		bin = binList.remove(0);
		binFree = bin.getCapacity();
		for (Membership member : filteredMembers) {
			binFree = binFree - memberCollectionAmount.doubleValue();
			if (binFree < 0) {
				System.err.format("### Switching bins %s - %s\n", binFree, bin);
				bin = binList.remove(0);
				binFree = bin.getCapacity();
				System.err.format("### new bin %s \n", bin);
			}
			createCollectionEntry(group, bin, member, memberCollectionAmount);
		}
		return group;
	}

	private List<Customer> findCustomersForTransportRoute(TransportRoute route)
	{
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		customerList.add(currentDairy.getCustomers().get(0));
		return customerList;
	}

	private List<Membership> findFarmersForCollectionCenter(DairyLocation center)
	{
		LinkedList<Membership> l = new LinkedList<Membership>();
		for (Membership m : currentDairy.getMemberships()) {
			if (m.getDefaultRoute() == center) {
				l.add(m);
			}
		}
		return l;
	}

	public CollectionGroup createCollectionGroup(	DairyLocation center,
													Date collectionDate,
													CollectionSession session)
	{
		Assert.isNotNull(center);
		Assert.isNotNull(collectionDate);
		Assert.isNotNull(session);

		CollectionGroup group;
		group = DairyFactory.eINSTANCE.createCollectionGroup();
		group.setId(Long.valueOf(group.hashCode()));
		group.setCollectionDate(collectionDate);
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
	public CollectionJournalLine createCollectionEntry(	CollectionGroup group,
														Bin bin,
														Membership member,
														BigDecimal amount)
	{
		Assert.isLegal((bin.getQuantity() + amount.doubleValue()) <= bin.getCapacity(), "bin capacity exceeded");

		CollectionJournalLine entry = DairyFactory.eINSTANCE.createCollectionJournalLine();

		entry.setLineNumber(++sequence);
		entry.setGroup(group);
		entry.setBin(bin);
		entry.setRecordedMember(member.getMemberNumber());
		entry.setValidatedMember(member);
		entry.setQuantity(amount);
		entry.setFlagged(false);

		System.err.format("\t@@@ %s to bin %s\n", amount.doubleValue(), bin);
		bin.setQuantity(bin.getQuantity() + amount.doubleValue());

		return entry;
	}

	private Employee createEmployee(String jobFunction)
	{
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

		emp.setLocation(getWorkingDairy().getLocation());

		ContactMethod contactInfo = ModelFactory.eINSTANCE.createContactMethod();
		contactInfo.setCmType(ContactMethodType.PHONE);
		contactInfo.setCmValue(String.format("+254 0722 123 %04d", sequence));
		emp.getContactMethods().add(contactInfo);

		if (jobFunction.equalsIgnoreCase("Driver")) {
			emp.setLicenseNo("LICENSE000" + sequence);
		}
		return emp;
	}

	private MilkSale createMilkSale(DairyLocation center,
									Date saleDate,
									CollectionSession session,
									MilkGrade grade,
									Customer customer,
									double unitPrice,
									Bin bin,
									double quantity)
	{
		MilkSale sale = DairyFactory.eINSTANCE.createMilkSale();
		sale.setBin(bin);
		sale.setContractSale(true);
		sale.setSession(session);
		sale.setCustomer(customer);
		sale.setGrade(grade);
		sale.setQuantity(new BigDecimal(quantity));
		sale.setReferenceNumber(String.format("SALE%05d", ++sequence));
		sale.setSaleAmount(new BigDecimal(unitPrice * quantity));
		sale.setSaleDate(saleDate);
		sale.setRejected(false);
		if (customer != null)
			sale.setSaleType(MilkSaleType.CREDIT);
		else
			sale.setSaleType(MilkSaleType.CASH);
		sale.setStoreOrRoute(center);
		sale.setUnitPrice(new BigDecimal(unitPrice));
		return sale;
	}

	@SuppressWarnings("deprecation")
	private MilkSaleGroup createMilkSaleGroup(	TransportRoute route,
												Date collectionDate,
												CollectionSession session,
												Customer customer)
	{
		MilkSaleGroup group = DairyFactory.eINSTANCE.createMilkSaleGroup();
		group.setCustomer(customer);
		group.setRoute(route);
		group.setSession(session);
		group.setDate(collectionDate);
		group.setVehicle(route.getVehicle());
		group.setDriver(route.getVehicle().getDriver());
		group.setReferenceNumber(String.format("%s-%04d%02d%02d-%s[%s-%05d]", route.getName(),
				collectionDate.getYear(), collectionDate.getMonth(), collectionDate.getDay(), session.getCode(),
				customer == null ? "CASH" : customer.getCustomerNumber(), ++sequence));
		return group;
	}

	private Trip createTrip(TransportRoute route,
							Date collectionDate,
							CollectionSession session)
	{
		Trip trip;
		// create the trip
		trip = DairyFactory.eINSTANCE.createTrip();
		trip.setStarted(collectionDate);
		trip.setEnded(collectionDate);
		return trip;
	}

}
