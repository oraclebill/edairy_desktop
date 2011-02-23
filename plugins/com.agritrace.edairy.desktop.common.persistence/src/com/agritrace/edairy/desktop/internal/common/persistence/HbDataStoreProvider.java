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
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.IDbPropertiesManager;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class HbDataStoreProvider implements Provider<HbDataStore>, IDbPropertiesManager {
	private static final org.eclipse.equinox.log.Logger LOG = Log4r.getLogger(PersistenceActivator.getDefault(),
			HbDataStoreProvider.class);

	public static final String PROPERTIES_FILE_NAME = "edairydb.properties";	
	private static final String DB_NAME_PROPERTY = "edairy.database.name";
	private static final String DEFAULT_DB_NAME = "dairymgr";

	private final HbDataStore hbds;

	private static File getConfigFileArea() {
		File ret = null;
		try {
			ret = RienaLocations.getDataArea();
		} catch (final Exception e) {
			e.printStackTrace();
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
		// ManagedSessionContext.bind(hbds.getSessionFactory().openSession());

		try {
			File file = new File(getConfigFileArea(), "hibernate-mapping.xml");
			FileWriter writer = new FileWriter(file);
			BufferedWriter buffered = new BufferedWriter(writer);
			buffered.write(hbds.getMappingXML());
			buffered.close();
			writer.close();
			LOG.log(LogService.LOG_INFO, "Saved mapping file to " + file);

			file = new File(getConfigFileArea(), "edairy-schema.sql");
			SchemaExport se = new SchemaExport(hbds.getHibernateConfiguration()).setHaltOnError(true)
					.setOutputFile(file.getAbsolutePath()).setDelimiter(";").setFormat(true);
			se.execute(true, false, false, true);

			LOG.log(LogService.LOG_INFO, "Saved sql schema to " + file);

		} catch (final Exception e) {
			LOG.log(LogService.LOG_ERROR, e.getMessage(), e);
		}

		LOG.log(LogService.LOG_DEBUG, ">>>>>> PersistenceManager[" + getClass().getName() + ":" + hashCode()
				+ "] started on thread " + Thread.currentThread());

		final File propFile = new File(getConfigFileArea(), PROPERTIES_FILE_NAME);

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

	public static Properties getDatastoreProperties() {
		final Properties props = new Properties();
		final File propFile = new File(getConfigFileArea(), PROPERTIES_FILE_NAME);

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
			String testval;

			LOG.log(LogService.LOG_INFO, "Using default hibernate properties.");

			testval = System.getenv("EDAIRY_DB_POSTGRES");
			if (null != testval && testval.equalsIgnoreCase("true")) {
				props.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				props.setProperty(Environment.DRIVER, "org.postgresql.Driver");
				props.setProperty(Environment.USER, "bjones");
				props.setProperty(Environment.URL, "jdbc:postgresql://localhost/" + DEFAULT_DB_NAME + "/");
			} else {
				props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
				props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
				props.setProperty(Environment.USER, "root");
				props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + DEFAULT_DB_NAME);
			}
			// props.setProperty(Environment.PASS, "root");

			// TODO: test this - perhaps JTA or 'managed' is better...
			props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "managed");

			final URI mappingFileURI = URI.createPlatformPluginURI(
					"/com.agritrace.edairy.desktop.common.persistence/etc/hibernate-mapping.xml", true);
			if (mappingFileURI.isFile()) {
				LOG.log(LogService.LOG_INFO, "Using hibernate mapping from plugin.");
				props.setProperty("teneo.mapping.mapping_file_name", mappingFileURI.toString());
			}

			props.setProperty("teneo.naming.default_id_column", "id");
			props.setProperty("teneo.naming.version_column", "opver");
			// teneo fk names are duplicated sometimes, so we disable this.. 
			// the downside is the fk names change every time they are generated, and have
			// no semantic content
			props.setProperty("teneo.naming.set_foreign_key_name", "false");
			
			props.setProperty("teneo.mapping.disable_econtainer", "true");
			props.setProperty("teneo.mapping.default_varchar_length", "60");
			props.setProperty("teneo.mapping.always_map_list_as_bag", "true"); // will
																				// cause
																				// hb
																				// to
																				// ignore
																				// index
																				// columns
			// if they exist,

			// TODO: improve performance...
			// props.setProperty("teneo.mapping.set_proxy", "true"); //
			// classloading issues
			// props.setProperty("teneo.mapping.fetch_containment_eagerly",
			// "true"); // counterproductive
			// props.setProperty("teneo.mapping.map_all_lists_as_idbag",
			// "true"); // untried
			// props.setProperty("teneo.mapping.always_map_list_as_bag",
			// "true"); // untried
			// props.setProperty("teneo.mapping.map_embeddable_as_embedded",
			// "true");

			// TODO: extra-lazy
			// global extra-lazy wont work. contactmethods fouls it up (at
			// least) probably teneo bug..
			// props.setProperty("teneo.mapping.fetch_one_to_many_extra_lazy",
			// "true");

			// show all sql for debugging
			testval = System.getenv("EDAIRY_SHOW_SQL");
			if (testval != null && !testval.isEmpty()) {
				props.setProperty(Environment.SHOW_SQL, "true");
			}

			testval = System.getenv("EDAIRY_FORMAT_SQL");
			if (testval != null && !testval.isEmpty()) {
				props.setProperty(Environment.FORMAT_SQL, "true");
			}
			testval = System.getenv("EDAIRY_USE_SQL_COMMENTS");
			if (testval != null && !testval.isEmpty()) {
				props.setProperty(Environment.USE_SQL_COMMENTS, "true");
			}

			testval = System.getenv("EDAIRY_GENERATE_STATISTICS");
			if (testval != null && !testval.isEmpty()) {
				props.setProperty(Environment.GENERATE_STATISTICS, "true");
			}

			// drop and recreate db on startup
			testval = System.getenv("EDAIRY_HBM2DDL_AUTO");
			if (testval != null && !testval.isEmpty()) {
				props.setProperty(Environment.HBM2DDL_AUTO, testval);
			} else {
				// don't update db, but check for changes
				props.setProperty(Environment.HBM2DDL_AUTO, "validate");
			}
		}

		return props;
	}

	protected static File getDatabaseFileArea() {
		File ret = null;
		try {
			ret = RienaLocations.getDataArea(PersistenceActivator.getDefault().getContext().getBundle());

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
		final File propFile = new File(getConfigFileArea(), PROPERTIES_FILE_NAME);
		LOG.log(LogService.LOG_INFO, "Saving properties to " + propFile);

		props.store(new FileOutputStream(propFile), "default properties, written on " + new Date());
	}
	
	
	public static void main(String[] args) {
//		System.getenv().put("EDAIRY_HBM2DDL_AUTO", "true");
		HbDataStoreProvider provider = new HbDataStoreProvider();
		provider.get();
	}
}
