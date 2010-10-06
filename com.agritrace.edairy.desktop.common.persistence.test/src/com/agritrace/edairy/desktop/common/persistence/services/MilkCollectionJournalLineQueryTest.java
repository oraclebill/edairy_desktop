package com.agritrace.edairy.desktop.common.persistence.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.collection.services.TestingPersistenceModule;
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
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.MembershipStatus;
import com.agritrace.edairy.desktop.common.model.dairy.MilkPrice;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.google.inject.Guice;
import com.ibm.icu.text.DateFormat;

public class MilkCollectionJournalLineQueryTest {

	ICollectionJournalLineRepository repo;
	
	@Before
	public void setup() {
		repo = Guice.createInjector(new TestingPersistenceModule()).getInstance(ICollectionJournalLineRepository.class);
	}

	@Test
	public void testCountByMemberCenterDate() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");

		Membership membership = null;
		for (Membership m : DAIRY.getMemberships()) {
			if (m.getMemberNumber().equals("1975")
					|| m.getMemberNumber().equals("01975")) {
				membership = m;
				break;
			}
		}

		DairyLocation centerBad = DairyFactory.eINSTANCE.createDairyLocation();
		centerBad.setName("test");
		centerBad.setLocation(DairyUtil.createLocation(null, null, null));
		centerBad.setCode("RXXX");
		DAIRY.getBranchLocations().add(centerBad);
		repo.save(DAIRY);

		DairyLocation centerGood = (DairyLocation) centers.get("R012");
		Date date = DateFormat.getDateInstance().parse("June 20, 2010");

		assertEquals(1,
				repo.countByMemberCenterDate(membership, centerGood, date));
		assertEquals(0,
				repo.countByMemberCenterDate(membership, centerBad, date));
		// assertEquals(0, repo.countByMemberCenterDate(null, null, null));
	}

	@Test
	public void testAllForDate() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");
//		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();

		Date queryDate = DateFormat.getDateInstance().parse("Jun 2, 2010");
		assertEquals(2, repo.allForDate(queryDate).size());

		queryDate = DateFormat.getDateInstance().parse("Jun 2, 2011");
		assertEquals(0, repo.allForDate((queryDate)).size());
	}

	@Test
	public void testGetMilkPrice() throws Exception {
		initTestContext();
//		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();

		// initially empty
		assertEquals(0, DAIRY.getPriceHistory().size());

		// create some data
		long queryDate = 100000;
		MilkPrice milkPrice = DairyFactory.eINSTANCE.createMilkPrice();
		milkPrice.setEnteredBy(DEFAULT_DRIVER);
		milkPrice.setEntryDate(new Date(queryDate));
		milkPrice.setMonth(1);
		milkPrice.setYear(1990);
		milkPrice.setValue(new BigDecimal("23.22"));

		DAIRY.getPriceHistory().add(milkPrice);
		repo.save(DAIRY);

		assertEquals(1, DAIRY.getPriceHistory().size());
		BigDecimal rate = repo.getMilkPrice(1, 1990);
		assertEquals(new BigDecimal("23.22"), rate);

	}

	@Test
	public void testGetMembersWithDeliveriesFor() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");

		Membership newMember = createMember("newMember");
//		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();
		List<Membership> members = repo.getMembersWithDeliveriesFor(6, 2010);
		assertEquals(3, members.size());
		members = repo.getMembersWithDeliveriesFor(7, 2010);
		assertEquals(2, members.size());

	}

	@Test
	public void testGetPayableDeliveriesForMember() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");
//		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();

		Membership member = null;
		for (Membership m : DAIRY.getMemberships()) {
			if (m.getMemberNumber().equals("1975")
					|| m.getMemberNumber().equals("01975")) {
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

	@Test
	public void testGetSumOfPayableDeliveries() throws Exception {
		initTestContext("../test-data/collections/test-collections.csv");
//		ICollectionJournalLineRepository repo = new MilkCollectionJournalLineRepository();

		Membership member = null;
		for (Membership m : DAIRY.getMemberships()) {
			if (m.getMemberNumber().equals("1975")
					|| m.getMemberNumber().equals("01975")) {
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

		DEFAULT_DRIVER = DairyUtil.createEmployee(null, "Driver", new Date(
				100000), "Strom", "", "Thurmond", "", null, null);
		DAIRY.getEmployees().add(DEFAULT_DRIVER);
	}

	
	
	private void initTestContext() throws Exception {
		initTestContext(null);
	}

	private void initTestContext(String testFile) throws Exception {
//		testPM = new HsqldbMemoryPersistenceManager();
//		System.setProperty("riena.test", "true");
//		PersistenceManager.reset(testPM);

		initSampleDairy();

		if (testFile != null) {
			System.err.println("importing " + testFile);
			ScaleImporter importer = new ScaleImporter(new File(testFile));
			importer.readRecords();
			List<ScaleRecord> results = importer.getResults();

			for (final ScaleRecord record : results) {
				final CollectionJournalLine line = DairyFactory.eINSTANCE
						.createCollectionJournalLine();
				line.setRecordedMember(record.getMemberNumber());
				line.setValidatedMember(getMembership(record.getMemberNumber()));
				line.setQuantity(new BigDecimal(record.getQuantity()));

				final CollectionGroup group = getCollectionGroup(
						record.getRouteNumber(), record.getSessionCode(),
						record.getValidDate());
				line.setCollectionJournal(group);
				group.getJournalEntries().add(line);
				group.setEntryCount(group.getEntryCount() + 1);
				group.setRecordTotal(group.getRecordTotal().add(
						line.getQuantity()));
			}
			for (CollectionGroup group : groups.values()) {
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

	private CollectionGroup getCollectionGroup(String routeNumber,
			String sessionCode, Date date) {
		if (date == null)
			throw new IllegalArgumentException("date cannot be null");
		String key = String.format("%5s-%2s-%tF", routeNumber, sessionCode,
				date);
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
		Farmer farmer = DairyUtil.createFarmer(accountNo, "", "", "",
				(Farm) null);
		farmer.setNickName(accountNo);

		Membership member = DairyUtil.createMembership(new Date(), new Date(),
				farmer);
		member.setMemberNumber(accountNo);
		member.setStatus(MembershipStatus.ACTIVE);

		DAIRY.getMemberships().add(member);
		repo.save(DAIRY);

		return member;
	}

}
