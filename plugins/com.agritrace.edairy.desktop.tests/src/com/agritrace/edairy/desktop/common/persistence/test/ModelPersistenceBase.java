package com.agritrace.edairy.desktop.common.persistence.test;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.junit.Before;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
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
		final String hbName = "dairytest";
		final String dbName = "dairytest";
		final HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);

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
		props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/"
				+ dbName);
		// props.setProperty(Environment.PASS, "root");
		// props.setProperty(Environment.DIALECT,
		// org.hibernate.dialect.MySQLInnoDBDialect.class.getName());
		props.setProperty(Environment.DIALECT,
				"org.hibernate.dialect.MySQLInnoDBDialect");
		props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");

		// show all sql
		props.setProperty(Environment.SHOW_SQL, "false");

		// drop and recreate db on startup
		props.setProperty(Environment.HBM2DDL_AUTO, "update");

		hbds.setProperties(props);

		final EPackage pkg[] = { DairyPackage.eINSTANCE, TrackingPackage.eINSTANCE,
				ModelPackage.eINSTANCE, RequestsPackage.eINSTANCE,
				AccountPackage.eINSTANCE };

		hbds.setEPackages(pkg);
		hbds.initialize();
		sessionFactory = hbds.getSessionFactory();
	}

	public void printSessionStats(final Session session) {
		System.out.println("\nSession Statistics\n");
		System.out.printf("\tSession Collection Count: %s \n", session
				.getStatistics().getCollectionCount());
		System.out.printf("\tSession Entity Count: %s \n", session
				.getStatistics().getEntityCount());
		System.out.printf(
				"\tSession Factory Role Names: %s \n",
				Arrays.toString(session.getSessionFactory().getStatistics()
						.getCollectionRoleNames()));

		printFactoryStats(session.getSessionFactory());
		printMemoryStats(false);
		printMemoryStats(true);
	}

	public void printFactoryStats(final SessionFactory factory) {
		System.out.println("\nSession Factory Statistics\n");
		System.out.printf("\tSession Factory Close Statement Count: %s \n",
				factory.getStatistics().getCloseStatementCount());
		System.out.printf("\tSession Factory Collection Fetch Count: %s \n",
				factory.getStatistics().getCollectionFetchCount());
		System.out.printf("\tSession Factory Collection Load Count: %s \n",
				factory.getStatistics().getCollectionLoadCount());
		System.out.printf("\tSession Factory Entity Load Count: %s \n", factory
				.getStatistics().getEntityLoadCount());
		System.out.printf("\tSession Factory Flush Count: %s \n", factory
				.getStatistics().getFlushCount());
		System.out.printf("\tSession Factory Collection Recreate Count: %s \n",
				factory.getStatistics().getCollectionRecreateCount());
		System.out.printf("\tSession Factory Remove Count: %s \n", factory
				.getStatistics().getCollectionRemoveCount());
		System.out.printf("\tSecond Level Cache Regions: %s \n", Arrays
				.toString(factory.getStatistics()
						.getSecondLevelCacheRegionNames()));

	}

	public void printMemoryStats(String string, boolean gc) {
		if (gc) {
			System.gc();
			System.out.println("\nMemory Statistics (after GC) : "+string+"\n");
		}
		else {
			System.out.println("\nMemory Statistics :  "+string+"\n");

		}

		System.out.printf("\tMax Memory  : %,14d\n", Runtime.getRuntime()
				.maxMemory());
		System.out.printf("\tMemory Used : %,14d\n", Runtime.getRuntime()
				.totalMemory() - Runtime.getRuntime()
				.freeMemory());
	}

	public void printMemoryStats(boolean gc) {
		printMemoryStats("", gc);
	}

	protected void printout(Membership membership, long count) {
		final Account a = membership.getAccount();
		final Farmer f = membership.getFarmer();
		final DairyLocation r = membership.getDefaultRoute();
		final Formatter formatter = new Formatter();
		formatter.format("Member: %s, Account: %s, Farmer: %s, Route: %s\n",
				membership.getApplicationDate(), a.getEstablished(),
				f.getFamilyName(), r.getName());
		if (count % 100 == 0) {
			System.out.print('.');
		}
		if (count % 800 == 0) {
			System.out.print('\n');
		}
	}

}