package com.agritrace.edairy.desktop.common.model.persistence.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.ReferenceAnimalType;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;

public class ModelPersistenceTestCase {
	
	private SessionFactory sFactory;

	@Before public void setupSessionFactory() {
		// create the HbDataStore
		String hbName = "dairytest";
		String dbName = "dairytest";
		HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);

		// The hibernate properties can be set by having a hibernate.properties file in the root of
		// the classpath.
		// Another approach is setting the properties in the HbDataStore. To do this comment out the
		// following lines
		// For more information see section 3.1 of the Hibernate manual
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + dbName);
		//props.setProperty(Environment.PASS, "root");
		props.setProperty(Environment.DIALECT, org.hibernate.dialect.MySQLInnoDBDialect.class.getName());

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");
		
		// show all sql 
//		props.setProperty(Environment.SHOW_SQL, "true");
		
		// drop and recreate db on startup
		props.setProperty(Environment.HBM2DDL_AUTO, "update");
		
		hbds.setProperties(props);

		hbds.initialize();
		sFactory = hbds.getSessionFactory();
	}
	
	@Test
	public void testCreateDairyData() throws Exception {

		
		Session session = sFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		// save some reference data
		ReferenceAnimalType animalType = TrackingFactory.eINSTANCE.createReferenceAnimalType();
		animalType.setBreed("Guersney");
		animalType.setSpecies("Cow");
		
		session.save(animalType);		
		
		tx.commit();
		session.close();
		
		// create new session for bulk of work
		session = sFactory.openSession();
		tx = session.beginTransaction();

//		DairyDemoResourceManager.INSTANCE.createDairyResource();
//		dairyResource = DairyDemoResourceManager.INSTANCE.getLocalDairy().eResource();
//		TreeIterator<EObject> dairyIter = dairyResource.getAllContents() ;
//		for (EObject obj = dairyIter.next(); dairyIter.hasNext(); obj = dairyIter.next() ) {
//			System.err.println( "Saving: " + obj );
//			session.save(obj);
//		}

		Dairy dairy;
		
		dairy = DairyDemoResourceManager.INSTANCE.createDairyData();
		
		
		session.save(dairy);
		tx.commit();
		session.close();
		
	}
}
