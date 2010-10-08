package com.agritrace.edairy.desktop.common.persistence.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;

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

	// @Test
	public void testCreateDairyData() throws Exception {

		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		// save some reference data
		final ReferenceAnimalType animalType = TrackingFactory.eINSTANCE.createReferenceAnimalType();
		animalType.setBreed("Guersney");
		animalType.setSpecies("Cow");

		session.save(animalType);

		tx.commit();
		session.close();

		// create new session for bulk of work
		session = getSessionFactory().openSession();
		tx = session.beginTransaction();

		// DairyDemoResourceManager.INSTANCE.createDairyResource();
		// dairyResource =
		// DairyDemoResourceManager.INSTANCE.getLocalDairy().eResource();
		// TreeIterator<EObject> dairyIter = dairyResource.getAllContents() ;
		// for (EObject obj = dairyIter.next(); dairyIter.hasNext(); obj =
		// dairyIter.next() ) {
		// System.err.println( "Saving: " + obj );
		// session.save(obj);
		// }

		Dairy dairy;

		dairy = DairyDemoResourceManager.INSTANCE.createDairyData();

		dairy.setLegalName("test");
		session.save(dairy);
		tx.commit();
		session.close();

	}

}
