package com.agritrace.edairy.desktop.internal.common.persistence;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;

public class ModelPersistenceTestCase extends ModelPersistenceBase {

	@Test
	public void testSessionFailureBehaviour() throws Exception {
		Session session = getSessionFactory().openSession();
		// do something that will fail, then try to do something else..
		final long initialSize = session.createQuery("FROM Dairy").list().size();
		final Dairy invalidDairy = DairyFactory.eINSTANCE.createDairy();

		Transaction tx = session.beginTransaction();
		boolean rolledBack = false;
		try {
			invalidDairy.setLegalName("only valid property");
			session.save(invalidDairy);
			tx.commit();
			fail("no exception");
		} catch (final org.hibernate.PropertyValueException e) {
			tx.rollback();
			// session.clear();
			rolledBack = true;
		} finally {
		}

		assertEquals(true, rolledBack);
		// assertEquals(false, session.isDirty());

		session = getSessionFactory().openSession();
		tx = session.beginTransaction();
		// test starts here...
		final List<Dairy> dairyList = session.createQuery("FROM Dairy").list();
		assertEquals(initialSize, dairyList.size());
		tx.commit();

	}



}
