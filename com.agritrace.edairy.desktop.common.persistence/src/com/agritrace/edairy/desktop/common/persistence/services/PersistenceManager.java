package com.agritrace.edairy.desktop.common.persistence.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.RienaLocations;
import org.eclipse.riena.core.RienaStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.internal.common.persistence.Activator;

public class PersistenceManager {

	private static final org.eclipse.equinox.log.Logger LOG = Log4r.getLogger(Activator.getDefault(),
			PersistenceManager.class);

	public static final String DB_NAME = "dairytest";
	public static final String PROPERTIES_FILE_NAME = "edairydb.properties";

	private static PersistenceManager INSTANCE;

	public static PersistenceManager getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new PersistenceManager();
		}
		return INSTANCE;
	}

	public static void reset(PersistenceManager pm) {
		if (!"true".equals(System.getProperty(RienaStatus.RIENA_TEST_SYSTEM_PROPERTY))) {
			throw new IllegalStateException("This method is for testing only!!");
		}
		INSTANCE = pm;
	}

	public static void setDefault(PersistenceManager pm) {
		if (INSTANCE == null) {
			INSTANCE = pm;
		} else {
			throw new IllegalStateException("default instance already set");
		}
	}

	private final HbDataStore hbds;

	private Session session;

	private final SessionFactory sessionFactory;

	protected PersistenceManager() {
		LOG.log(LogService.LOG_INFO, " ** Creating PersistenceManager [" + getClass().getName() + ":" + hashCode()
				+ "]");

		hbds = HbHelper.INSTANCE.createRegisterDataStore(DB_NAME);
		hbds.setProperties(getDatastoreProperties());
		hbds.setEPackages(getEPackages());
		
		hbds.initialize();
		try {
			File file = new File(RienaLocations.getDataArea(), "hibernate-mapping.xml");
			FileWriter writer = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(writer);
			buffered.write(hbds.getMappingXML());
			buffered.close();
			writer.close();
			LOG.log(LogService.LOG_INFO, "Saved mapping file to " + file);
		}
		catch(Exception e) {
			LOG.log(LogService.LOG_ERROR, e.getMessage(), e);

		}
		
		postInit();
		
		sessionFactory = hbds.getSessionFactory();
	}

	public HbDataStore getDataStore() {
		return hbds;
	}

	public Session getSession() {
		if (null == session) {
			session = sessionFactory.openSession();
			LOG.log(LogService.LOG_DEBUG, "--> created session: " + session);
		} else if (!session.isConnected()) {
			session = sessionFactory.openSession();
			LOG.log(LogService.LOG_DEBUG, "--> creatied session: " + session);
		}
		return session;
	}

	protected Properties getDatastoreProperties() {
		final Properties props = new Properties();
		final File hibernateProperties = new File(RienaLocations.getDataArea(), PROPERTIES_FILE_NAME);
		LOG.log(LogService.LOG_INFO, "Hibernate properties file found at: '" + hibernateProperties + "'");
		if (hibernateProperties.canRead()) {
			LOG.log(LogService.LOG_INFO, "Reading hibernate properties from properties file");
			try {
				props.load(new FileInputStream(hibernateProperties));
			} catch (Exception e) {
				e.printStackTrace();
				LOG.log(LogService.LOG_ERROR, e.getMessage(), e);
			}
		} else {
			LOG.log(LogService.LOG_INFO, "Using default hibernate properties.");

			props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
			props.setProperty(Environment.USER, "root");
			props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + DB_NAME);
			// props.setProperty(Environment.PASS, "root");
			props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");

			// TODO: test this - perhaps JTA or 'managed' is better...
			props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			props.setProperty("teneo.mapping.disable_econtainer", "true");
			props.setProperty("teneo.mapping.default_varchar_length", "60");

			// show all sql
			props.setProperty(Environment.SHOW_SQL, "true");

			// drop and recreate db on startup
			props.setProperty(Environment.HBM2DDL_AUTO, "update");
		}
		return props;

	}

	protected EPackage[] getEPackages() {
		return new EPackage[] { TrackingPackage.eINSTANCE, DairyPackage.eINSTANCE, ModelPackage.eINSTANCE,
				AccountPackage.eINSTANCE, RequestsPackage.eINSTANCE };
	}

	protected void postInit() {
		LOG.log(LogService.LOG_DEBUG, ">>>>>> PersistenceManager[" + getClass().getName() + ":" + hashCode()
				+ "] started on thread " + Thread.currentThread());
		File propFile = new File(RienaLocations.getDataArea(), PROPERTIES_FILE_NAME);
		if (!propFile.exists()) {
			LOG.log(LogService.LOG_INFO, "Saving properties to " + propFile);
			try {
				hbds.getProperties().store(new FileOutputStream(propFile),
						"default properties, written on " + new Date());
			} catch (FileNotFoundException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			} catch (IOException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			}
		}
	}

	/**
	 * test only.
	 */
	void resetDefault() {
		INSTANCE = null;
	}
}
