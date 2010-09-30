package com.agritrace.edairy.desktop.collection.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.persistence.TestPersistenceModule;
import com.agritrace.edairy.desktop.internal.collection.services.MilkCollectionJournalLineRepository;
import com.google.inject.Guice;

public class ICollectionJournalLineQueryTest {
	private ICollectionJournalLineRepository repo;

	@Before
	public void setup() {
		repo = Guice.createInjector(new TestPersistenceModule()).getInstance(ICollectionJournalLineRepository.class);
	}

	// @Test
	public void testCountByMemberCenterDate() {
		assertEquals(0, repo.countByMemberCenterDate(null, null, null));
	}

	@Test
	public void testAllForDate() {
		// create some data
		assertNotNull(repo.allForDate(null));
		Date queryDate = new Date();		
		List<CollectionGroup> collections = repo.allForDate(queryDate);
		assertTrue(collections.size() > 1);
	}

	/*
	private void createSampleDairy() {
		Dairy dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setCompanyName("Test Company");
	}
	*/
}
