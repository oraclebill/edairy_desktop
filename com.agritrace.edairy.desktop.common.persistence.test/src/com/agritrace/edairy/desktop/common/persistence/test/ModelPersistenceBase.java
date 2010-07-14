package com.agritrace.edairy.desktop.common.persistence.test;

import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.junit.Before;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

public class ModelPersistenceBase {

	private SessionFactory sessionFactory;

	public ModelPersistenceBase() {
		super();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Before
	public void setupSessionFactory() {
		// create the HbDataStore
		String hbName = "dairytest";
		String dbName = "dairytest";
		HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);

		// The hibernate properties can be set by having a hibernate.properties
		// file in the root of
		// the classpath.
		// Another approach is setting the properties in the HbDataStore. To do
		// this comment out the
		// following lines
		// For more information see section 3.1 of the Hibernate manual
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + dbName);
		// props.setProperty(Environment.PASS, "root");
//		props.setProperty(Environment.DIALECT, org.hibernate.dialect.MySQLInnoDBDialect.class.getName());
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
		props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");

		// show all sql
		props.setProperty(Environment.SHOW_SQL, "true");

		// drop and recreate db on startup
		props.setProperty(Environment.HBM2DDL_AUTO, "update");

		hbds.setProperties(props);

		EPackage pkg[] = { DairyPackage.eINSTANCE, TrackingPackage.eINSTANCE, ModelPackage.eINSTANCE,
				RequestsPackage.eINSTANCE, AccountPackage.eINSTANCE };

		hbds.setEPackages((pkg));
		hbds.initialize();
		sessionFactory = hbds.getSessionFactory();
	}

}