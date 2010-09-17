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
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PersistenceManager implements Provider<Session> {

	private static final org.eclipse.equinox.log.Logger LOG = Log4r.getLogger(Activator.getDefault(),
			PersistenceManager.class);
	public final File DATA_AREA = getConfigFileArea();
	public static final String PROPERTIES_FILE_NAME = "edairydb.properties";
	public static final String DB_TYPE_PROPERTY = "edairy.database.type";
	public static final String DB_NAME_PROPERTY = "edairy.database.name";
	public static final String DB_TYPE_MYSQL = "mysql";
	public static final String DB_TYPE_HSQLDB = "hsqldb";
	public static final String DB_TYPE_SYBASE_ASA = "sybase-asa";
	
	public static final String DEFAULT_DB_NAME = "dairytest";
	public static final String DEFAULT_DB_TYPE = DB_TYPE_MYSQL;
	
	@Inject
	private static Provider<PersistenceManager> PROVIDER;

	@Deprecated
	public static PersistenceManager getDefault() {
		return PROVIDER.get();
	}

	public static File getConfigFileArea() {
		File ret = null;
		try {
			ret = RienaLocations.getDataArea();
		} catch (Exception e) {
			ret = new File(".");
			ret = ret.getAbsoluteFile();
		}
		return ret;
	}

	public static String getDatabaseName() {
		return System.getProperty(PersistenceManager.DB_NAME_PROPERTY, PersistenceManager.DEFAULT_DB_NAME);
	}

	private final HbDataStore hbds;
	private Session session;
	private final SessionFactory sessionFactory;

	protected PersistenceManager() {
		LOG.log(LogService.LOG_INFO, " ** Creating PersistenceManager [" + getClass().getName() + ":" + hashCode()
				+ "]");

		hbds = HbHelper.INSTANCE.createRegisterDataStore(DEFAULT_DB_NAME);
		hbds.setProperties(getDatastoreProperties());
		hbds.setEPackages(getEPackages());

		hbds.initialize();
		try {
			File file = new File(DATA_AREA, "hibernate-mapping.xml");
			FileWriter writer = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(writer);
			buffered.write(hbds.getMappingXML());
			buffered.close();
			writer.close();
			LOG.log(LogService.LOG_INFO, "Saved mapping file to " + file);
		} catch (Exception e) {
			LOG.log(LogService.LOG_ERROR, e.getMessage(), e);
		}

		postInit();

		sessionFactory = hbds.getSessionFactory();
	}

	/**
	 * Deprecated. Inject a <code>Provider&lt;Session&gt;</code> instead.
	 * 
	 * @return New Hibernate session
	 */
	@Deprecated
	public Session getSession() {
		return get();
	}

	protected Properties getDatastoreProperties() {
		final Properties props = new Properties();
		File propFile = new File(DATA_AREA, PROPERTIES_FILE_NAME);

		LOG.log(LogService.LOG_INFO, "Hibernate properties file found at: '" + propFile + "'");
		if (propFile.canRead()) {
			LOG.log(LogService.LOG_INFO, "Reading hibernate properties from properties file");
			try {
				props.load(new FileInputStream(propFile));
			} catch (Exception e) {
				e.printStackTrace();
				LOG.log(LogService.LOG_ERROR, e.getMessage(), e);
			}
		} else {
			LOG.log(LogService.LOG_INFO, "Using default hibernate properties.");

			props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
			props.setProperty(Environment.USER, "root");
			props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + DEFAULT_DB_NAME);
			// props.setProperty(Environment.PASS, "root");
			props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");

			// TODO: test this - perhaps JTA or 'managed' is better...
			props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			props.setProperty("teneo.mapping.disable_econtainer", "true");
			props.setProperty("teneo.mapping.default_varchar_length", "60");

			// show all sql for debugging
//			props.setProperty(Environment.SHOW_SQL, "true");
//			props.setProperty(Environment.FORMAT_SQL, "true");
//			props.setProperty(Environment.USE_SQL_COMMENTS, "true");
//			props.setProperty(Environment.GENERATE_STATISTICS, "true");

			// drop and recreate db on startup
			props.setProperty(Environment.HBM2DDL_AUTO, "update");
		}
		
		return props;
	}
	
	protected static File getDatabaseFileArea() {
		File ret = null;
		try {
			ret = RienaLocations.getDataArea(Activator.getDefault().getContext().getBundle());

		} catch (Exception e) {
			ret = new File("./db/");
		}
		return ret;
	}

	public final Properties getProperties() {
		return hbds.getProperties();
	}
	
	public final void saveProperties(Properties properties) throws IOException {
		File propFile = new File(DATA_AREA, PROPERTIES_FILE_NAME);
		LOG.log(LogService.LOG_INFO, "Saving properties to " + propFile);

		properties.store(new FileOutputStream(propFile), "default properties, written on " + new Date());
	}

	private EPackage[] getEPackages() {
		return new EPackage[] { TrackingPackage.eINSTANCE, DairyPackage.eINSTANCE, ModelPackage.eINSTANCE,
				AccountPackage.eINSTANCE, RequestsPackage.eINSTANCE };
	}

	private void postInit() {
		LOG.log(LogService.LOG_DEBUG, ">>>>>> PersistenceManager[" + getClass().getName() + ":" + hashCode()
				+ "] started on thread " + Thread.currentThread());
		
		File propFile = new File(DATA_AREA, PROPERTIES_FILE_NAME);
		
		if (!propFile.exists()) {
			try {
				saveProperties(getProperties());
			} catch (FileNotFoundException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			} catch (IOException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			}
		}
	}

	@Override
	public Session get() {
		if (null == session) {
			session = sessionFactory.openSession();
			LOG.log(LogService.LOG_DEBUG, "--> created session: " + session);
		} else if (!session.isConnected()) {
			session = sessionFactory.openSession();
			LOG.log(LogService.LOG_DEBUG, "--> creatied session: " + session);
		}
		return session;
	}
}
