package com.agritrace.edairy.desktop.common.persistence.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.collections.scaledata.beans.ScaleRecord;
import com.agritrace.edairy.desktop.collections.scaledata.importer.ScaleImporter;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroupType;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.dao.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.PersistenceModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;

public class MilkCollectionJournalLineQueryTest {

	static class SessionProvider implements Provider<Session> {
		private SessionFactory sessionFactory;
		private Session session;

		@Inject
		protected SessionProvider(HbDataStore hbds) {
			sessionFactory = hbds.getSessionFactory();
		}

		@Override
		public Session get() {
			if (session == null || !session.isOpen()) {
				session = sessionFactory.openSession();
			}
			return session;
		}
	}

//	Injector injector = Guice.createInjector(new AbstractModule() {
//		@Override
//		protected void configure() {
//			final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
//			bind(HbDataStore.class).toProvider(provider);
//			bind(Session.class).toProvider(SessionProvider.class);
//			bind(ICollectionJournalLineRepository.class).to(MilkCollectionJournalLineRepository.class);
//		}
//	});

	final Injector injector = Guice.createInjector(new PersistenceModule());

	ICollectionJournalLineRepository repo;

	@Before
	public void setup() {
		repo = injector.getInstance(ICollectionJournalLineRepository.class);
	}

	@Test
	public void testStatistics() throws Exception {
//		repo = liveInjector.getInstance(ICollectionJournalLineRepository.class);
		Map<String, Double> statMap ;
		
		statMap = repo.collectionStatistics(createDate(2010, 5, 1), createDate(2010, 5, 2), null, null);
		assertNotNull(statMap);
		
		statMap = repo.collectionStatistics(createDate(2010, 5, 1), createDate(2010, 5, 1), null, null);
		assertNotNull(statMap);
		
		System.err.println(statMap.entrySet());
		
	}

	private Date createDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, day);

		return cal.getTime();
	}

	// @Test
	public void testCountByMemberCenterDate() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");

		Membership membership = null;
		for (final Membership m : DAIRY.getMemberships()) {
			if (m.getMemberNumber().equals("1975") || m.getMemberNumber().equals("01975")) {
				membership = m;
				break;
			}
		}

		final DairyLocation centerBad = DairyFactory.eINSTANCE.createDairyLocation();
		centerBad.setName("test");
		centerBad.setLocation(DairyUtil.createLocation(null, null, null));
		centerBad.setCode("RXXX");
		DAIRY.getBranchLocations().add(centerBad);
		repo.save(DAIRY);

		final DairyLocation centerGood = centers.get("R012");
		final Date date = DateFormat.getDateInstance().parse("June 20, 2010");

		assertEquals(1, repo.countByMemberCenterDate(membership, centerGood, date));
		assertEquals(0, repo.countByMemberCenterDate(membership, centerBad, date));
		// assertEquals(0, repo.countByMemberCenterDate(null, null, null));
	}

	// @Test
	// public void testAllForDate() throws Exception {
	// initTestContext("../test-data/collections/test-collections.csv");
	//
	// Date startDate = DateFormat.getDateInstance().parse("Jun 2, 2010");
	// Date endDate = DateFormat.getDateInstance().parse("Jun 2, 2010");
	// assertEquals(2, repo.allForDate(startDate, endDate).size());
	//
	// queryDate = DateFormat.getDateInstance().parse("Jun 2, 2011");
	// assertEquals(0, repo.allForDate(queryDate).size());
	// }

	@Test
	public void testGetMilkPrice() throws Exception {
		initTestContext();

		// initially empty
		assertEquals(0, DAIRY.getPriceHistory().size());

		// create some data
		final long queryDate = 100000;
		final MemberPayment milkPrice = DairyFactory.eINSTANCE.createMemberPayment();
		milkPrice.setEnteredBy(DEFAULT_DRIVER);
		milkPrice.setEntryDate(new Date(queryDate));
		milkPrice.setMonth(1);
		milkPrice.setYear(1990);
		milkPrice.setPaymentRate(new BigDecimal("23.22"));

		DAIRY.getPriceHistory().add(milkPrice);
		repo.save(DAIRY);

		assertEquals(1, DAIRY.getPriceHistory().size());
		final BigDecimal rate = repo.getMilkPrice(1, 1990);
		assertEquals(new BigDecimal("23.22"), rate);

	}

	// @Test
	public void testGetMembersWithDeliveriesFor() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");

		createMember("newMember");

		List<Membership> members = repo.getMembersWithDeliveriesFor(6, 2010);
		assertEquals(3, members.size());
		members = repo.getMembersWithDeliveriesFor(7, 2010);
		assertEquals(2, members.size());

	}

	// @Test
	public void testGetPayableDeliveriesForMember() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");
		// ICollectionJournalLineRepository repo = new
		// MilkCollectionJournalLineRepository();

		Membership member = null;
		for (final Membership m : DAIRY.getMemberships()) {
			if (m.getMemberNumber().equals("1975") || m.getMemberNumber().equals("01975")) {
				member = m;
				break;
			}
		}
		assertNotNull(member);

		List<CollectionJournalLine> collections;

		collections = repo.getPayableDeliveriesForMember(member, 6, 2010);
		assertEquals(6, collections.size());
		collections = repo.getPayableDeliveriesForMember(member, 7, 2010);
		assertEquals(0, collections.size());
		collections = repo.getPayableDeliveriesForMember(member, 8, 2010);
		assertEquals(17, collections.size());
	}

	// @Test
	public void testGetSumOfPayableDeliveries() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");
		// ICollectionJournalLineRepository repo = new
		// MilkCollectionJournalLineRepository();

		Membership member = null;
		for (final Membership m : DAIRY.getMemberships()) {
			if (m.getMemberNumber().equals("1975") || m.getMemberNumber().equals("01975")) {
				member = m;
				break;
			}
		}
		assertNotNull(member);

		assertEquals(new BigDecimal("88.6"), repo.getSumOfPayableDeliveries(member, 6, 2010));
	}

	Dairy DAIRY;
	Employee DEFAULT_DRIVER;

	private void initSampleDairy() {
		DAIRY = DairyFactory.eINSTANCE.createDairy();
		DAIRY.setCompanyName("test");
		DAIRY.setDescription("");
		DAIRY.setRegistrationNumber("");
		DAIRY.setLocation(DairyUtil.createLocation(null, null, null));
		DAIRY.setPhoneNumber("");

		DEFAULT_DRIVER = DairyUtil.createEmployee(null, "Driver", new Date(100000), "Strom", "", "Thurmond", "", null,
				null);
		DAIRY.getEmployees().add(DEFAULT_DRIVER);
	}

	private void initTestContext() throws Exception {
		initTestContext(null);
	}

	private void initTestContext(String testFile) throws Exception {
		// testPM = new HsqldbMemoryPersistenceManager();
		// System.setProperty("riena.test", "true");
		// PersistenceManager.reset(testPM);

		initSampleDairy();

		if (testFile != null) {
			System.err.println("importing " + testFile);
			final ScaleImporter importer = new ScaleImporter(new File(testFile));
			importer.readRecords();
			final List<ScaleRecord> results = importer.getResults();

			for (final ScaleRecord record : results) {
				final CollectionJournalLine line = DairyFactory.eINSTANCE.createCollectionJournalLine();
				line.setRecordedMember(record.getMemberNumber());
				line.setValidatedMember(getMembership(record.getMemberNumber()));
				line.setQuantity(new BigDecimal(record.getQuantity()));

				final CollectionGroup group = getCollectionGroup(record.getRouteNumber(), record.getSessionCode(),
						record.getValidDate());
				line.setCollectionJournal(group);
				group.getJournalEntries().add(line);
				group.setEntryCount(group.getEntryCount() + 1);
				group.setRecordTotal(group.getRecordTotal().add(line.getQuantity()));
			}
			for (final CollectionGroup group : groups.values()) {
				repo.save(group);
			}
		}
	}

	HashMap<String, DairyLocation> centers = new HashMap<String, DairyLocation>();

	private DairyLocation getCenter(String key) {
		DairyLocation center = centers.get(key);
		if (center == null) {
			center = DairyFactory.eINSTANCE.createDairyLocation();
			center.setCode(key);
			center.setName(key);
			center.setLocation(DairyUtil.createLocation(null, null, null));
			DAIRY.getBranchLocations().add(center);
			repo.save(center);
			centers.put(key, center);
		}
		return center;
	}

	HashMap<String, CollectionGroup> groups = new HashMap<String, CollectionGroup>();

	private CollectionGroup getCollectionGroup(String routeNumber, String sessionCode, Date date) {
		if (date == null) {
			throw new IllegalArgumentException("date cannot be null");
		}
		final String key = String.format("%5s-%2s-%tF", routeNumber, sessionCode, date);
		CollectionGroup group = groups.get(key);
		if (group == null) {
			group = DairyFactory.eINSTANCE.createCollectionGroup();
			group.setReferenceNumber(key);
			group.setJournalDate(date);
			group.setStatus(JournalStatus.COMPLETE);
			group.setDriver(DEFAULT_DRIVER);
			group.setType(CollectionGroupType.JOURNAL_GROUP);
			group.setCollectionCenter(getCenter(routeNumber));
			groups.put(key, group);
		}
		return group;
	}

	HashMap<String, Membership> memberships = new HashMap<String, Membership>();

	private Membership getMembership(String memberNumber) {
		Membership member = memberships.get(memberNumber);
		if (member == null) {
			member = createMember(memberNumber);
			memberships.put(memberNumber, member);
		}
		return member;
	}

	protected Membership createMember(String accountNo) {
		final Farmer farmer = DairyUtil.createFarmer(accountNo, "", "", "", (Farm) null);
		farmer.setNickName(accountNo);

		final Membership member = DairyUtil.createMembership(new Date(), new Date(), farmer);
		member.setMemberNumber(accountNo);
		member.setStatus(MembershipStatus.ACTIVE);

		DAIRY.getMemberships().add(member);
		repo.save(DAIRY);

		return member;
	}

}
