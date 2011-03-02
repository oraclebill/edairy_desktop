package com.agritrace.edairy.desktop.testdata;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Permission;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.MilkGrade;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseSetup {

	public static final EPackage[] EPACKAGES = { TrackingPackage.eINSTANCE, DairyPackage.eINSTANCE,
			ModelPackage.eINSTANCE, AccountPackage.eINSTANCE, RequestsPackage.eINSTANCE };
	private String databaseName = "generated";
	private String host = "localhost";
	private int port = 3306;
	private String userName = "root";
	private String password = "";
	private String schemaFileName = "edairy-schema.sql";
// private String mappingFileName = "";
// private Map<String, ?> options = new HashMap<String, Object>();
	private HbDataStore hbds;
	private Session session = null;

	/**
	 * @return the baseGrade
	 */
	public MilkGrade getBaseGrade() {
		return baseGrade;
	}

	/**
	 * @param baseGrade
	 *            the baseGrade to set
	 */
	public void setBaseGrade(MilkGrade baseGrade) {
		this.baseGrade = baseGrade;
	}

	private MilkGrade baseGrade;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
// BasicConfigurator.configure();
// Logger.getLogger("org.eclipse.emf.teneo").setLevel(Level.INFO);
// Logger.getLogger("org.hibernate").setLevel(Level.WARN);
		DatabaseSetup setup = new DatabaseSetup();
		if (args != null && args.length > 0) {
			setup.setSchemaFileName(args[0]);
			if (args.length > 1) {
				setup.setDatabaseName(args[1]);
			}
		}
		setup.generateSchema();
	}

	/**
	 * 
	 */
	public DatabaseSetup() {
		super();
	}

	/**
	 * @return the databaseName
	 */
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * @param databaseName
	 *            the databaseName to set
	 */
	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the schemaFileName
	 */
	public String getSchemaFileName() {
		return schemaFileName;
	}

	/**
	 * @param schemaFileName
	 *            the schemaFileName to set
	 */
	public void setSchemaFileName(String schemaFileName) {
		this.schemaFileName = schemaFileName;
	}

	/**
	 * Create a new session and initialize the 'current' session..
	 * 
	 * @return
	 */
	protected Session openSession() {
		return hbds.getSessionFactory().openSession();
	}

	/**
	 * Get the current Session, or null..
	 * 
	 * @return
	 */
	protected Session getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	protected void setSession(Session session) {
		if (this.session != null) {
			this.session.close();
		}
		this.session = session;
	}

	/**
	 * Get the current session, or create one and return it.
	 * 
	 * @return
	 */
	protected Session getOrCreateSession() {
		if (getSession() == null)
			setSession(openSession());
		return getSession();
	}

	/**
	 * 
	 */
	public void createDatabase() {
		System.out.format("Creating database [%s]\n", getDatabaseName());
		String dbURL = getDatabaseURL();
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			// dataSource.setUrl(getDatabaseURL());
			dataSource.setUser(getUserName());
			dataSource.setPassword(getPassword());
			dataSource.setPort(getPort());
			dataSource.setServerName(getHost());
			// dataSource.setDatabaseName(getDatabaseName());

			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String statement = String.format("create database if not exists %s;", getDatabaseName());
			System.out.format("Executing sql [%s]\n", statement);
			stmt.execute(statement);
		} catch (Exception e) {
			throw new RuntimeException("Failed to create database", e);
		}

	}

	/**
	 * @throws IOException
	 * 
	 */
	public void generateSchema() throws IOException {
		// for teneo, we need to intialize the datastore in order ot properly
		// init the configuration. So we set an invalid db so init will fail,
		// but then we can use the config to generate schema...

		File f = new File(getSchemaFileName());
		System.out.println("Generating schema to file: " + f.getCanonicalPath());

		Configuration configuration = generateTeneoHibernateConfig();

		SchemaExport exporter = new SchemaExport(configuration);
		exporter.setHaltOnError(true);
		exporter.setOutputFile(f.getCanonicalPath());
		exporter.setDelimiter(";");
		exporter.setFormat(true);
		exporter.execute(true, false, false, true);

	}

	/**
	 * 
	 * 
	 */
	protected void initializeDataStore() {
		hbds = HbHelper.INSTANCE.createRegisterDataStore(getDatabaseName());
		hbds.setProperties(getOptions());

		hbds.setEPackages(EPACKAGES);
		hbds.initialize();
	}

	/**
	 * 
	 */
	protected void populateBaseReferenceData(Dairy dairy) {
		populateBaseCollectionSessions(dairy);
		populateBaseSystemUsersAndRoles(dairy);
		populateBaseMilkGrades(dairy);
	}

	private void populateBaseCollectionSessions(Dairy dairy) {
		CollectionSession cSession;

		cSession = DairyFactory.eINSTANCE.createCollectionSession();
		cSession.setCode("AM");
		cSession.setDescription("The first collection session of the day");
		dairy.getCollectionSessions().add(cSession);

		cSession = DairyFactory.eINSTANCE.createCollectionSession();
		cSession.setCode("PM");
		cSession.setDescription("An additional collection session.");
		dairy.getCollectionSessions().add(cSession);
	}

	private void populateBaseSystemUsersAndRoles(Dairy dairy) {
		SystemUser user;
		Role role;
		Permission permission;

		role = ModelFactory.eINSTANCE.createRole();
		role.setName("ADMIN");
		role.setDescription("The 'admin' role has all permissions, implicitly");
		getSession().persist(role);

		user = ModelFactory.eINSTANCE.createSystemUser();
		user.setUsername("admin");
		user.setPassword(PrincipalManager.hashPassword("admin"));
		user.setPasswordHashed(true);
		user.setLocalEnabled(false);
		user.setRole(role);
		getSession().persist(user);

		role = ModelFactory.eINSTANCE.createRole();
		role.setName("GUEST");
		role.setDescription("The 'GUEST' role has no permissions.");
		getSession().persist(role);

		user = ModelFactory.eINSTANCE.createSystemUser();
		user.setUsername("guest");
		// user.setPassword(); // no password on purpose.
		user.setPasswordHashed(true);
		user.setLocalEnabled(false);
		user.setRole(role);
		getSession().persist(user);

		// TODO: read permissions from java annotations and populate in db
		// TODO: come to think of it, perhaps roles and permissions shoudld be
		// specified using and extension point.. (maybe riena already does...)

	}

	private void populateBaseMilkGrades(Dairy dairy) {
		MilkGrade grade;

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("RAW");
		grade.setDescription("Standard raw milk grade.");
		grade.setName("Raw");
		getSession().persist(grade);
		baseGrade = grade;

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("PIGGERY");
		grade.setDescription("Raw milk grade that is not fit for human consumption.");
		grade.setName("Piggery");
		getSession().persist(grade);

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("COOLED");
		grade.setDescription("Raw milk that has been cooled and stored in transit.");
		grade.setName("Refrigerated");
		getSession().persist(grade);

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("HIGHFAT");
		grade.setDescription("High fat content raw milk.");
		grade.setName("High Fat Content");
		getSession().persist(grade);

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("ORGANIC");
		grade.setDescription("Raw milk from certified organic producers.");
		grade.setName("Organic");
		getSession().persist(grade);

		for (int i = 1; i < 4; i++) {
			grade = DairyFactory.eINSTANCE.createMilkGrade();
			grade.setCode("SPECIAL" + i);
			grade.setDescription("Special use category " + i + ".");
			grade.setName("Special " + i);
			getSession().persist(grade);
		}
	}

	protected Dairy createDairy(String dairyNumber) {
		Dairy dairy;

		dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setRegistrationNumber(dairyNumber);
		dairy.setDescription("");
		dairy.setCompanyName("");
		dairy.setLegalName("");
		dairy.setEstablishedDate(new Date());
		dairy.setLocation(DairyUtil.createLocation(null, null, null));

		getSession().persist(dairy);

		return dairy;
	}

	private Configuration generateTeneoHibernateConfig() {
		// for teneo, we need to intialize the datastore in order ot properly
		// init the configuration. So we set an invalid db so init will fail,
		// but then we can use the config to generate schema...
		HbDataStore tempDataStore = HbHelper.INSTANCE.createRegisterDataStore("fakedatastore");

		String savedDbName = getDatabaseName();
		setDatabaseName("generateschema" + hashCode());
		String savedUserName = getUserName();
		setUserName(hashCode() + "generateschema");
		try {
			tempDataStore.setProperties(getOptions());
			tempDataStore.setEPackages(EPACKAGES);
			tempDataStore.initialize();
		} catch (Throwable t) {
			System.out.println("Caught expected error: " + t.getMessage());
		}
		setUserName(savedUserName);
		setDatabaseName(savedDbName);

		Configuration configuration = tempDataStore.getHibernateConfiguration();
		return configuration;
	}

	private Properties getOptions() {
		Properties props = new Properties();

		setDatabaseProperties(props);
		setTeneoProperties(props);
		setHibernateProperties(props);

		return props;
	}

	/**
	 * @param props
	 */
	private void setDatabaseProperties(Properties props) {
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, getUserName());
		props.setProperty(Environment.URL, getDatabaseURL());
	}

	private String getUserName() {
		// TODO Auto-generated method stub
		return userName;
	}

	private String getDatabaseURL() {
		return String.format("jdbc:mysql://%s:%d/%s", getHost(), getPort(), getDatabaseName());
	}

	/**
	 * @param props
	 */
	private void setTeneoProperties(Properties props) {
		props.setProperty("teneo.naming.default_id_column", "id");
		props.setProperty("teneo.naming.version_column", "opver");
		props.setProperty("teneo.naming.set_foreign_key_name", "false");
		props.setProperty("teneo.mapping.also_map_as_class", "false");
		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");
		props.setProperty("teneo.mapping.always_map_list_as_bag", "true"); // will
	}

	/**
	 * @param props
	 */
	private void setHibernateProperties(Properties props) {
		props.setProperty(Environment.SHOW_SQL, "true");
// props.setProperty(Environment.FORMAT_SQL, "true");
// props.setProperty(Environment.USE_SQL_COMMENTS, "true");
		props.setProperty(Environment.GENERATE_STATISTICS, "true");
		props.setProperty(Environment.HBM2DDL_AUTO, "create");
	}

}