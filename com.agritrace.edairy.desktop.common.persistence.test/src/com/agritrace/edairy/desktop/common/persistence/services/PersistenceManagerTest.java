package com.agritrace.edairy.desktop.common.persistence.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;

public class PersistenceManagerTest {
	PersistenceManager testPM;
	Session testSession;
	
	@Before
	public void setUp() throws Exception {
		testPM = new HsqldbMemoryPersistenceManager();
		testSession = testPM.getSession();
	}

	@After
	public void tearDown() throws Exception {
		if (testSession != null && testSession.isOpen() ) {
			testSession.clear();
			testSession.close();
			testSession = null;
		}
	}

	@Test
	public void testPersistenceManagerEntities() {
		testSession.getEntityMode();
		Map<?,?> classMetaMap = testSession.getSessionFactory().getAllClassMetadata();

		assertNotNull(classMetaMap.get("Container"));
		assertNotNull(classMetaMap.get("Dairy"));
		assertNotNull(classMetaMap.get("Route"));
		assertNotNull(classMetaMap.get("CollectionJournalLine"));

		// for (Object k : classMetaMap.keySet())
		// System.err.println( k + ": " + classMetaMap.get(k));
				
	}
	
	public void testPersistenceManagerPersistence() {
		double testValue = 3.1415927;
		
		Container container = DairyUtil.createContainer(ContainerType.BIN, UnitOfMeasure.KILOGRAM, null, testValue);

		Transaction tx = testSession.beginTransaction();
		testSession.save(container);
		tx.commit();

		List<?> containers = testSession.createQuery("FROM Container").list();
		assertEquals(1, containers.size());
		assertEquals(testValue, ((Container)containers.get(0)).getCapacity(), 0.01d);
		
		tx = testSession.beginTransaction();
		testSession.delete(containers.get(0));
		tx.rollback();
		
		assertEquals(1, containers.size());
		assertEquals(testValue, ((Container)containers.get(0)).getCapacity(), 0.01d);

		tx = testSession.beginTransaction();
		testSession.delete(containers.get(0));
		tx.commit();
		
		assertEquals(0, containers.size());
		
	}
	
	@Test
	public void testMultipleManagers() throws Exception {
		PersistenceManager pm, anotherPM, theLastPM;
		
		// pm obtained from default constructor is system default
		pm = new PersistenceManager();
		assertTrue(pm instanceof com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager);
		
		testPM.resetDefault();
				
		// pm obtained from getDefault() is system default
		pm = PersistenceManager.getDefault();
		assertTrue(pm instanceof com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager);
		
		testPM.resetDefault();
		
		// pm, once set, is the only one you get
		pm = new HsqldbMemoryPersistenceManager();
		PersistenceManager.setDefault(pm);		
		assertSame(pm, PersistenceManager.getDefault());
		assertNotSame(pm, new PersistenceManager());
		
		// and once set, default won't change
		assertSame(pm, PersistenceManager.getDefault());

	}
	
	@Test
	public void testSetDetaultPM() {
		testPM.resetDefault();
		PersistenceManager.setDefault(testPM);
		assertEquals(testPM, PersistenceManager.getDefault());
		
		testPM = new HsqldbMemoryPersistenceManager();
		assertNotSame(testPM, PersistenceManager.getDefault());
		
		try {
			PersistenceManager.setDefault(testPM);
			fail("Expected exception!!");
		}
		catch(Throwable t) {
			;
		}
		
		testPM.resetDefault();
		PersistenceManager.setDefault(testPM);

	}

}
