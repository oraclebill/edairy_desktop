package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public class MilkCollectionRepositoryTest {
	private MilkCollectionRepository testRepository;
	private TestDataSessionProvider sessionProvider;

	@Before
	public void setUp() {
		sessionProvider = new TestDataSessionProvider();
		testRepository = new MilkCollectionRepository(sessionProvider);

		sessionProvider.setSession(sessionProvider.openSession());

		Transaction tx;

		tx = sessionProvider.getSession().beginTransaction();
		sessionProvider.initializeWorkingDairy();
		sessionProvider.generateRoutesAndCollectionCenters(1, 1);
		sessionProvider.generateDairyBins(2, 50.0d);
		sessionProvider.generateCustomers(1);
		sessionProvider.generateMembers(10);
		tx.commit();
	}

//	@Test
//	public void testSetup() {
//		assertTrue(sessionProvider.getSession().createCriteria("Customer").list().size() == 1);
//
//	}

	@SuppressWarnings("deprecation")
	@Test
	public void testFindCollectionGroups() {
		Session session;
		Transaction tx;
		Dairy dairy;
		CollectionGroup group;
		DairyLocation center;
		CollectionSession collectionSession;

		dairy = sessionProvider.getWorkingDairy();
		center = dairy.getBranchLocations().get(0);		
		collectionSession = dairy.getCollectionSessions().get(0);
		
		session = sessionProvider.getOrCreateSession();
		tx = session.beginTransaction();
		
		group = sessionProvider.createCollectionGroup(center, new Date(12, 31, 1999), collectionSession);
		session.persist(group);
		group = sessionProvider.createCollectionGroup(center, new Date(1, 1, 2000), collectionSession);
		session.persist(group);
		group = sessionProvider.createCollectionGroup(center, new Date(1, 2, 2000), collectionSession);
		session.persist(group);
		group = sessionProvider.createCollectionGroup(center, new Date(2, 2, 2000), collectionSession);
		session.persist(group);

		tx.commit();
		
		List<CollectionGroup> groups = testRepository.findCollectionGroups(null, null, new Date(1, 1, 2000), new Date(
				2, 1, 2000), null, null, null, null);
		assertNotNull(groups);
		assertEquals(groups.size(), 2);
	}

	
	@Test
	public void testSumCollections() {
		Session session;
		Transaction tx;
		Dairy dairy;
		DairyLocation center;
		Bin  bin;
		CollectionSession collectionSession;
		CollectionGroup group;
		CollectionJournalLine line;
		Membership member0, member1, member2;
		List<CollectionJournalLine> entries;
		
		dairy = sessionProvider.getWorkingDairy();
		center = dairy.getBranchLocations().get(0);		
		collectionSession = dairy.getCollectionSessions().get(0);
		bin = dairy.getDairyBins().get(0);
		member0 = dairy.getMemberships().get(0);
		member1 = dairy.getMemberships().get(1);
		member2 = dairy.getMemberships().get(2);
		
		session = sessionProvider.getOrCreateSession();
		tx = session.beginTransaction();
		
		group = sessionProvider.createCollectionGroup(center, new Date(12, 31, 1999), collectionSession);
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member0, BigDecimal.ONE));
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member1, BigDecimal.ONE));
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member2, BigDecimal.ONE));
		session.persist(group);
		
		group = sessionProvider.createCollectionGroup(center, new Date(1, 1, 2000), collectionSession);
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member0, BigDecimal.ONE));
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member1, BigDecimal.ONE));
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member2, BigDecimal.ONE));
		session.persist(group);
		
		group = sessionProvider.createCollectionGroup(center, new Date(1, 2, 2000), collectionSession);
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member0, BigDecimal.ONE));
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member1, BigDecimal.ONE));
		group.getJournalEntries().add(sessionProvider.createCollectionEntry(group, bin, member2, BigDecimal.ONE));
		session.persist(group);
		
		group = sessionProvider.createCollectionGroup(center, new Date(2, 2, 2000), collectionSession);
		session.persist(group);

		tx.commit();

		Membership membership;
		Date startDate, endDate;
		Boolean isMissing, isRejected;
		
		membership = member0;
		startDate = new Date(1,1,2000);
		endDate = new Date(2,1,2000);
		
		isMissing = Boolean.FALSE;
		isRejected = Boolean.FALSE;
		
		entries = testRepository.findCollections(membership, null, null, startDate, endDate, isMissing, isRejected, null);
		
		assertNotNull(entries);
		assertEquals(entries.size(), 1);

		isMissing = Boolean.FALSE;
		isRejected = Boolean.TRUE;
		
		entries = testRepository.findCollections(membership, null, null, startDate, endDate, isMissing, isRejected, null);
		
		assertNotNull(entries);
		assertEquals(entries.size(), 1);

		isMissing = Boolean.TRUE;
		isRejected = Boolean.FALSE;
		
		entries = testRepository.findCollections(membership, null, null, startDate, endDate, isMissing, isRejected, null);
		
		assertNotNull(entries);
		assertEquals(entries.size(), 1);

		isMissing = Boolean.TRUE;
		isRejected = Boolean.TRUE;
		
		entries = testRepository.findCollections(membership, null, null, startDate, endDate, isMissing, isRejected, null);
		
		assertNotNull(entries);
		assertEquals(entries.size(), 1);		
	}

	@Test
	public void testFindCollections() {
		fail("Not yet implemented");
	}

}
