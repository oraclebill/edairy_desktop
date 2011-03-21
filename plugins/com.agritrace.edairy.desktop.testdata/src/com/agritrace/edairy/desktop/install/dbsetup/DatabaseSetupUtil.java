package com.agritrace.edairy.desktop.install.dbsetup;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
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
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseSetupUtil
{

	public static final EPackage[]	EPACKAGES	= { TrackingPackage.eINSTANCE, DairyPackage.eINSTANCE,
			ModelPackage.eINSTANCE, AccountPackage.eINSTANCE, RequestsPackage.eINSTANCE };

	private HbDataStore				hbds;
	private Session					session		= null;

	private DatabaseSetupData		data;															// = new
// DatabaseSetupData("generated", "localhost", 3306, "root", "",
																									// "edairy-schema.sql");
	private DairySeedData			seedData	= new DairySeedData("generated", "REG12345", -1l);

	/**
	 * 
	 */
	public DatabaseSetupUtil(DatabaseSetupData setupData)
	{
		this.data = setupData;
	}

	/**
	 * Create a new session and initialize the 'current' session..
	 * 
	 * @return
	 */
	public Session openSession()
	{
		return hbds.getSessionFactory().openSession();
	}

	/**
	 * Get the current Session, or null..
	 * 
	 * @return
	 */
	public Session getSession()
	{
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(Session session)
	{
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
	public Session getOrCreateSession()
	{
		if (getSession() == null)
			setSession(openSession());
		return getSession();
	}

	private DataSource createDataSource()
	{
		return createDataSource(data);
	}

	/**
	 * @throws IOException
	 * 
	 */
	public static void generateSchemaFile(DatabaseSetupData data) throws IOException
	{
		// for teneo, we need to intialize the datastore in order ot properly
		// init the configuration. So we set an invalid db so init will fail,
		// but then we can use the config to generate schema...

		File f = new File(data.getSchemaFileName());
		System.out.println("Generating schema to file: " + f.getCanonicalPath());

		Configuration configuration = generateTeneoHibernateConfig(data);

		SchemaExport exporter = new SchemaExport(configuration);
		exporter.setHaltOnError(true);
		exporter.setOutputFile(f.getCanonicalPath());
		exporter.setDelimiter(";");
		exporter.setFormat(true);
		exporter.execute(true, false, false, true);

	}

	/**
	 * 
	 */
	public static void generateHibernateMapping(DatabaseSetupData data) throws IOException
	{

	}
	
	public void intializeDairyDatabase(String regNo, String licName) {
		initializeDataStore();
		populateReferenceData();
		Dairy dairy = createDairy(regNo, licName);
		populateBaseCollectionSessions(dairy);
	}
	
	/**
	 * 
	 */
	private void initializeDataStore()
	{
		hbds = HbHelper.INSTANCE.createRegisterDataStore(data.getDatabaseName());
		hbds.setProperties(data.getOptions());
		hbds.setEPackages(EPACKAGES);
		hbds.initialize();
	}

	/**
	 * 
	 */
	private void populateReferenceData()
	{
		populateBaseSystemUsersAndRoles();
		populateBaseMilkGrades();
	}

	/**
	 * @param dairy
	 */
	private void populateBaseCollectionSessions(Dairy dairy)
	{
		CollectionSession cSession;

		Session session;
		Transaction transaction;

		session = getOrCreateSession();
		transaction = session.beginTransaction();
		
		dairy = (Dairy) session.load("Dairy", dairy.getCompanyId());
		
		cSession = DairyFactory.eINSTANCE.createCollectionSession();
		cSession.setCode("AM");
		cSession.setTimeOfDay(new Date(0, 0, 0, 6, 0));
		cSession.setDescription("The first collection session of the day");
		dairy.getCollectionSessions().add(cSession);

		cSession = DairyFactory.eINSTANCE.createCollectionSession();
		cSession.setCode("PM");
		cSession.setDescription("An additional collection session.");
		cSession.setTimeOfDay(new Date(0, 0, 0, 13, 0));
		dairy.getCollectionSessions().add(cSession);
		
		transaction.commit();
	}

	/**
	 * 
	 */
	private void populateBaseSystemUsersAndRoles()
	{
		SystemUser user;
		Role role;
// Permission permission;

		Session session;
		Transaction transaction;

		session = getOrCreateSession();
		transaction = session.beginTransaction();
		
		role = ModelFactory.eINSTANCE.createRole();
		role.setName("ADMIN");
		role.setDescription("The 'admin' role has all permissions, implicitly");
		session.persist(role);

		user = ModelFactory.eINSTANCE.createSystemUser();
		user.setUsername("admin");
		user.setPassword(PrincipalManager.hashPassword("admin"));
		user.setPasswordHashed(true);
		user.setLocalEnabled(false);
		user.setRole(role);
		session.persist(user);

		role = ModelFactory.eINSTANCE.createRole();
		role.setName("GUEST");
		role.setDescription("The 'GUEST' role has no permissions.");
		session.persist(role);

		user = ModelFactory.eINSTANCE.createSystemUser();
		user.setUsername("guest");
		// user.setPassword(); // no password on purpose.
		user.setPasswordHashed(true);
		user.setLocalEnabled(false);
		user.setRole(role);
		session.persist(user);
		
		transaction.commit();

		// TODO: read permissions from java annotations and populate in db
		// TODO: come to think of it, perhaps roles and permissions shoudld be
		// specified using and extension point.. (maybe riena already does...)

	}

	/**
	 * 
	 */
	private void populateBaseMilkGrades()
	{
		Session session;
		Transaction transaction;
		
		MilkGrade grade;

		session = getOrCreateSession();
		transaction = session.beginTransaction();
		
		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("RAW");
		grade.setDescription("Standard raw milk grade.");
		grade.setName("Raw");
		session.persist(grade);
		seedData.setBaseGrade(grade);

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("PIGGERY");
		grade.setDescription("Raw milk grade that is not fit for human consumption.");
		grade.setName("Piggery");
		session.persist(grade);

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("COOLED");
		grade.setDescription("Raw milk that has been cooled and stored in transit.");
		grade.setName("Refrigerated");
		session.persist(grade);

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("HIGHFAT");
		grade.setDescription("High fat content raw milk.");
		grade.setName("High Fat Content");
		session.persist(grade);

		grade = DairyFactory.eINSTANCE.createMilkGrade();
		grade.setCode("ORGANIC");
		grade.setDescription("Raw milk from certified organic producers.");
		grade.setName("Organic");
		session.persist(grade);

		for (int i = 1; i < 4; i++) {
			grade = DairyFactory.eINSTANCE.createMilkGrade();
			grade.setCode("SPECIAL" + i);
			grade.setDescription("Special use category " + i + ".");
			grade.setName("Special " + i);
			session.persist(grade);
		}
		
		transaction.commit();
	}

	protected Dairy createDairy(String dairyNumber,
								String licenseeName)
	{
		Session session;
		Transaction transaction;

		Dairy dairy;
		Location location;

		session = getOrCreateSession();
		transaction = session.beginTransaction();
		
		location = ModelFactory.eINSTANCE.createLocation();
		location.setDescriptiveLocation(null);
		location.setMapLocation(null);
		location.setPostalLocation(null);
		location.setStatutoryLocation(null);
		session.persist(location);

		dairy = DairyFactory.eINSTANCE.createDairy();
		dairy.setRegistrationNumber(dairyNumber);
		dairy.setLegalName(licenseeName);
// dairy.setCompanyId(getDairyId());

		dairy.setDescription("<description>");
		dairy.setCompanyName("<company common name>");
		dairy.setPhoneNumber("+254 0072 0000 0000");
		dairy.setEstablishedDate(new Date(1, 1, 1975));

		dairy.setLocation(location);
		session.persist(dairy);

		transaction.commit();
		
		return dairy;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		BasicConfigurator.configure();
		Logger.getLogger("org.eclipse.emf.teneo").setLevel(Level.INFO);
		Logger.getLogger("org.hibernate").setLevel(Level.WARN);

		DatabaseSetupData setupData = new DatabaseSetupData();

		if (args != null && args.length > 0) {
			setupData.setSchemaFileName(args[0]);
			if (args.length > 1) {
				setupData.setDatabaseName(args[1]);
			}
		}

		if (!DatabaseSetupUtil.testServerConnection(setupData)) {
			throw new RuntimeException("Unable to connect to running server");
		}

		if (DatabaseSetupUtil.checkDatabaseExists(setupData)) {
			throw new RuntimeException("Database: '" + setupData.getDatabaseName() + "' exists!");
		}

		// documentation
		DatabaseSetupUtil.generateSchemaFile(setupData);
		DatabaseSetupUtil.generateHibernateMapping(setupData);

		// create live database
		DatabaseSetupUtil.createDatabase(setupData);

		// create seed data and initial dairy record
		DatabaseSetupUtil setupUtil = new DatabaseSetupUtil(setupData);
		setupUtil.intializeDairyDatabase("registration #", "licensee name");

	}

	private static Configuration generateTeneoHibernateConfig(DatabaseSetupData data)
	{
		// for teneo, we need to intialize the datastore in order ot properly
		// init the configuration. So we set an invalid db so init will fail,
		// but then we can use the config to generate schema...
		HbDataStore tempDataStore = HbHelper.INSTANCE.createRegisterDataStore("fakedatastore");

		String savedDbName = data.getDatabaseName();
		data.setDatabaseName("generateschema" + data.hashCode());
		String savedUserName = data.getUserName();
		data.setUserName(data.hashCode() + "generateschema");
		try {
			tempDataStore.setProperties(data.getOptions());
			tempDataStore.setEPackages(EPACKAGES);
			tempDataStore.initialize();
		} catch (Throwable t) {
			System.out.println("Caught expected error: " + t.getMessage());
		}
		data.setUserName(savedUserName);
		data.setDatabaseName(savedDbName);

		Configuration configuration = tempDataStore.getHibernateConfiguration();
		return configuration;
	}

	/**
	 * @param data
	 * @return
	 */
	private static DataSource createDataSource(DatabaseSetupData data)
	{
		MysqlDataSource dataSource = new MysqlDataSource();
		// dataSource.setUrl(getDatabaseURL());
		dataSource.setUser(data.getUserName());
		dataSource.setPassword(data.getPassword());
		dataSource.setPort(data.getPort());
		dataSource.setServerName(data.getHost());
		// dataSource.setDatabaseName(getDatabaseName());
		return dataSource;
	}

	/**
	 * @param data
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	private static ResultSet runSQL(DatabaseSetupData data,
									String sql) throws SQLException
	{
		System.out.format("Executing sql [%s]\n", sql);
		DataSource dataSource = createDataSource(data);
		Connection conn = dataSource.getConnection();
		Statement stmt = conn.createStatement();
		stmt.execute(sql);
		return stmt.getResultSet();
	}

	/**
	 * @param setupData
	 * @return
	 */
	public static boolean checkDatabaseExists(DatabaseSetupData setupData) throws SQLException
	{
		System.out.format("Creating database [%s]\n", setupData.getDatabaseName());
		ResultSet rs = runSQL(setupData, "select count(*) from INFORMATION_SCHEMA.schemata where schema_name = '"
				+ setupData.getDatabaseName() + "'");
		rs.first();
		int count = rs.getInt(1);
		return count > 0;
	}

	/**
	 * @param setupData
	 * @return
	 * @throws SQLException
	 */
	public static boolean testServerConnection(DatabaseSetupData setupData) throws SQLException
	{
		ResultSet resultSet = runSQL(setupData, "select count(*) from INFORMATION_SCHEMA.TABLES;");
		resultSet.first();
		return (resultSet.getInt(1) > 0);
	}

	/**
	 * @param data
	 * @throws SQLException
	 */
	public static void createDatabase(DatabaseSetupData data) throws SQLException
	{
		System.out.format("Creating database [%s]\n", data.getDatabaseName());
		runSQL(data, String.format("create database  %s;", data.getDatabaseName()));

	}

}