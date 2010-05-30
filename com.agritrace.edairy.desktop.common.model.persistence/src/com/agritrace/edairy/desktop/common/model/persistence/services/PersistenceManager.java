package com.agritrace.edairy.desktop.common.model.persistence.services;

import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

public class PersistenceManager {
	
	public static final String DB_NAME = "dairytest";
	public static final PersistenceManager INSTANCE = new PersistenceManager();
	
	private final HbDataStore hbds;
	private final SessionFactory sessionFactory;
	
	
	public HbDataStore getDataStore() {
		return hbds;		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;		
	}
	
	private PersistenceManager() {
		hbds = HbHelper.INSTANCE.createRegisterDataStore(DB_NAME);
		hbds.setProperties( getDatastoreProperties() );
		hbds.setEPackages( getEPackages() );		
		hbds.initialize();		
		postInit();
		sessionFactory = hbds.getSessionFactory();
	}

	protected Properties getDatastoreProperties() {
		// TODO: hibernate properties can be set by having a hibernate.properties file in the root of
		// the classpath.
		final Properties props = new Properties();
		
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + DB_NAME);
		//props.setProperty(Environment.PASS, "root");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");
		
		// show all sql 
//		props.setProperty(Environment.SHOW_SQL, "true");
		
		// drop and recreate db on startup
		props.setProperty(Environment.HBM2DDL_AUTO, "update");	
		return props;
		
	}
	
	protected EPackage[] getEPackages() {
		return new EPackage[] { TrackingPackage.eINSTANCE, DairyPackage.eINSTANCE, 
				ModelPackage.eINSTANCE, AccountPackage.eINSTANCE, RequestsPackage.eINSTANCE };
	}
	
	
	protected void postInit() {
		;; 
	}
}