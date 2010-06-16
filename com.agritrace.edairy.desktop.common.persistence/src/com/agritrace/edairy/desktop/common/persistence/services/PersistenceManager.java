package com.agritrace.edairy.desktop.common.persistence.services;

import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.riena.core.RienaStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

public class PersistenceManager {
	
	public static final String DB_NAME = "dairytest";
	
	private static PersistenceManager INSTANCE;
	
	private final HbDataStore hbds;
	private final SessionFactory sessionFactory;
	private Session session;
		
	public static PersistenceManager getDefault() {
		if ( INSTANCE == null )
			INSTANCE = new PersistenceManager();
		return INSTANCE;
	}
	
	public static void setDefault(PersistenceManager pm) {
		if (INSTANCE == null )
			INSTANCE = pm;
		else
			throw new IllegalStateException("default instance already set");
	}
	
	public static void reset(PersistenceManager pm) {
		if (! "true".equals(System.getProperty(RienaStatus.RIENA_TEST_SYSTEM_PROPERTY))) {
			throw new IllegalStateException("This method is for testing only!!");
		}
		INSTANCE = pm;
	}
	
	protected PersistenceManager() {
		System.err.println(" ** Creating PersistenceManager [" + getClass().getName() + ":" + hashCode() + "]" );

		hbds = HbHelper.INSTANCE.createRegisterDataStore(DB_NAME);
		hbds.setProperties( getDatastoreProperties() );
		hbds.setEPackages( getEPackages() );		
		hbds.initialize();		
		postInit();
		sessionFactory = hbds.getSessionFactory();
	}

	public HbDataStore getDataStore() {
		return hbds;		
	}
	
	public Session getSession() {
		if (null == session) {
			session = sessionFactory.openSession();
		} else if ( ! session.isConnected() ) {
			session = sessionFactory.openSession();
		}
		return session;
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

		// TODO: test this - perhaps JTA or 'managed' is better...
		props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		
		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");
		
		// show all sql 
		props.setProperty(Environment.SHOW_SQL, "true");
		
		// drop and recreate db on startup
		props.setProperty(Environment.HBM2DDL_AUTO, "update");
		return props;
		
	}
	
	protected EPackage[] getEPackages() {
		return new EPackage[] { TrackingPackage.eINSTANCE, DairyPackage.eINSTANCE, 
				ModelPackage.eINSTANCE, AccountPackage.eINSTANCE, RequestsPackage.eINSTANCE };
	}
	
	
	protected void postInit() {
		System.err.println( ">>>>>> PersistenceManager[" + getClass().getName() + ":" + hashCode() + "] started on thread " + Thread.currentThread());
		System.err.println(hbds.getMappingXML()); 
	}

	/**
	 * test only.
	 */
	void resetDefault() {
		INSTANCE = null;
	}
}
