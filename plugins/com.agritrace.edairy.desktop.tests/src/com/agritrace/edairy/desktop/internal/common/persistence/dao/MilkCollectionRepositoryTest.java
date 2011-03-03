package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;


public class MilkCollectionRepositoryTest
{
	private MilkCollectionRepository	testRepository;
	private TestDataSessionProvider			sessionProvider;

	@Before
	public void setUp()
	{
		sessionProvider = new TestDataSessionProvider();
		testRepository = new MilkCollectionRepository(sessionProvider);

		sessionProvider.setSession(sessionProvider.openSession());

		Transaction tx;
		
		tx = sessionProvider.getSession().beginTransaction();
		sessionProvider.generateRoutesAndCollectionCenters(1, 1);
		sessionProvider.generateDairyBins(2, 50.0d);
		sessionProvider.generateCustomers(1);
		sessionProvider.generateMembers(10);
		tx.commit();
	}

	@Test
	public void testSetup()
	{
		assertTrue(sessionProvider.getSession().createCriteria("Customer").list().size() == 1);
		
	}

	@Test
	public void testFindCollectionGroups()
	{
	}

	@Test
	public void testSumCollections()
	{
		fail("Not yet implemented");
	}

	@Test
	public void testFindCollections()
	{
		fail("Not yet implemented");
	}

}
