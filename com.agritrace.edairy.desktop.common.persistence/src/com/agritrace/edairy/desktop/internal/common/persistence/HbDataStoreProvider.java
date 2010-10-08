package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.RienaLocations;
import org.hibernate.cfg.Environment;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.common.persistence.services.IDbPropertiesManager;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class HbDataStoreProvider implements Provider<HbDataStore>, IDbPropertiesManager {
	private static final org.eclipse.equinox.log.Logger LOG = Log4r.getLogger(Activator.getDefault(),
			HbDataStoreProvider.class);

	public static final String DB_TYPE_PROPERTY = "edairy.database.type";
	public static final String DB_NAME_PROPERTY = "edairy.database.name";
	public static final String DB_TYPE_MYSQL = "mysql";
	public static final String DB_TYPE_HSQLDB = "hsqldb";
	public static final String DB_TYPE_SYBASE_ASA = "sybase-asa";

	public static final String DEFAULT_DB_NAME = "dairytest";
	public static final String DEFAULT_DB_TYPE = DB_TYPE_MYSQL;

	private final HbDataStore hbds;

	private static File getConfigFileArea() {
		File ret = null;
		try {
			ret = RienaLocations.getDataArea();
		} catch (final Exception e) {
			ret = new File(".");
			ret = ret.getAbsoluteFile();
		}
		return ret;
	}

	@Inject
	public HbDataStoreProvider() {
		hbds = HbHelper.INSTANCE.createRegisterDataStore(DEFAULT_DB_NAME);
		hbds.setProperties(getDatastoreProperties());
		hbds.setEPackages(PersistenceModule.EPACKAGES);

		hbds.initialize();
//		ManagedSessionContext.bind(hbds.getSessionFactory().openSession());

		try {
			final File file = new File(getConfigFileArea(), "hibernate-mapping.xml");
			final FileWriter writer = new FileWriter(file);
			final BufferedWriter buffered = new BufferedWriter(writer);
			buffered.write(hbds.getMappingXML());
			buffered.close();
			writer.close();
			LOG.log(LogService.LOG_INFO, "Saved mapping file to " + file);
		} catch (final Exception e) {
			LOG.log(LogService.LOG_ERROR, e.getMessage(), e);
		}

		LOG.log(LogService.LOG_DEBUG, ">>>>>> PersistenceManager[" + getClass().getName() + ":" + hashCode()
				+ "] started on thread " + Thread.currentThread());

		final File propFile = new File(getConfigFileArea(), PersistenceModule.PROPERTIES_FILE_NAME);

		if (!propFile.exists()) {
			try {
				setProperties(hbds.getProperties());
			} catch (final FileNotFoundException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			} catch (final IOException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			}
		}
	}

	@Override
	public HbDataStore get() {
		return hbds;
	}

	protected Properties getDatastoreProperties() {
		final Properties props = new Properties();
		final File propFile = new File(getConfigFileArea(), PersistenceModule.PROPERTIES_FILE_NAME);

		LOG.log(LogService.LOG_INFO, "Hibernate properties file found at: '" + propFile + "'");
		if (propFile.canRead()) {
			LOG.log(LogService.LOG_INFO, "Reading hibernate properties from properties file");
			try {
				props.load(new FileInputStream(propFile));
			} catch (final Exception e) {
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
			props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "managed");

			final URI mappingFileURI = URI.createPlatformPluginURI("/com.agritrace.edairy.desktop.common.persistence/etc/hibernate-mapping.xml", true);
			if (mappingFileURI.isFile()) {
				LOG.log(LogService.LOG_INFO, "Using hibernate mapping from plugin.");
				props.setProperty("teneo.mapping.mapping_file_name", mappingFileURI.toString());
			}
			props.setProperty("teneo.mapping.disable_econtainer", "true");
			props.setProperty("teneo.mapping.default_varchar_length", "60");

			// TODO: improve performance...
//			props.setProperty("teneo.mapping.set_proxy", "true");  // classloading issues
//			props.setProperty("teneo.mapping.fetch_containment_eagerly", "true");  // counterproductive
//			props.setProperty("teneo.mapping.map_all_lists_as_idbag", "true"); // untried
//			props.setProperty("teneo.mapping.always_map_list_as_bag", "true"); // untried
//			props.setProperty("teneo.mapping.map_embeddable_as_embedded", "true");

			// global extra-lazy wont work. contactmethods fouls it up (at least) probably teneo bug..
			//			props.setProperty("teneo.mapping.fetch_one_to_many_extra_lazy", "true");


			// show all sql for debugging
			props.setProperty(Environment.SHOW_SQL, "true");
			props.setProperty(Environment.FORMAT_SQL, "true");
			props.setProperty(Environment.USE_SQL_COMMENTS, "true");
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

		} catch (final Exception e) {
			ret = new File("./db/");
		}
		return ret;
	}

	protected final String getDatabaseName() {
		return System.getProperty(DB_NAME_PROPERTY, DEFAULT_DB_NAME);
	}


	@Override
	public Properties getProperties() {
		return hbds.getProperties();
	}

	@Override
	public void setProperties(Properties props) throws IOException {
		final File propFile = new File(getConfigFileArea(), PersistenceModule.PROPERTIES_FILE_NAME);
		LOG.log(LogService.LOG_INFO, "Saving properties to " + propFile);

		props.store(new FileOutputStream(propFile), "default properties, written on " + new Date());
	}
}
