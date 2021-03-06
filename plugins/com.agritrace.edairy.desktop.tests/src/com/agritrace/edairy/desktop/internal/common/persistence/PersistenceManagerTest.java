package com.agritrace.edairy.desktop.internal.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.collection.services.TestingPersistenceModule;
import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class PersistenceManagerTest {
	@Inject
	private Session testSession;

	@Before
	public void setUp() throws Exception {
		Guice.createInjector(new TestingPersistenceModule()).injectMembers(this);
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
		final Map<?,?> classMetaMap = testSession.getSessionFactory().getAllClassMetadata();

		assertNotNull(classMetaMap.get("Container"));
		assertNotNull(classMetaMap.get("Dairy"));
		assertNotNull(classMetaMap.get("Route"));
		assertNotNull(classMetaMap.get("CollectionJournalLine"));

		// for (Object k : classMetaMap.keySet())
		// System.err.println( k + ": " + classMetaMap.get(k));

	}

	public void testPersistenceManagerPersistence() {
		final double testValue = 3.1415927;

		final Container container = DairyUtil.createContainer(ContainerType.BIN, UnitOfMeasure.KILOGRAM, null, testValue);

		Transaction tx = testSession.beginTransaction();
		testSession.save(container);
		tx.commit();

		final List<?> containers = testSession.createQuery("FROM Container").list();
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
}
