package com.agritrace.edairy.desktop.common.persistence.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.teneo.hibernate.LazyCollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

@SuppressWarnings("unchecked")
public class MembershipPerformanceTestCase extends ModelPersistenceBase {
	@Test
	public void testLazyLoadBehaviour() throws Exception {
		final Session session = getSessionFactory().openSession();
		printSessionStats(session);

		final Dairy dairy = (Dairy) session.createQuery("From Dairy").uniqueResult();

		final Collection<Employee> employees = dairy.getEmployees();
		showCollection("Employees", employees);

		final Collection<Membership> members = dairy.getMemberships();
		showCollection("Members", members);
		session.close();

		final Membership member = members.iterator().next();
		System.out.println("Account Number : "
				+ member.getAccount().getAccountNumber());
		final List<Vehicle> vehicles = dairy.getVehicles();
		final Vehicle truck = vehicles.iterator().next();
		if (truck != null) {
			System.out.println(truck.getAssetInfo().getDamageDescription());
		}
		printSessionStats(session);

		session.flush();
		printSessionStats(session);
	}

	@Test
	public void testIterateCriteriaQuery() {
		final long start = System.currentTimeMillis();
		final Session session = getSessionFactory().openSession();
		session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time for Criteria Query... ");

		final List<Membership> members = session.createCriteria("Membership").list();

		long count = 0;
		for (final Membership member : members) {
			if (++count % 100 == 0) {
				System.out.print('.');
			}
			if (++count % 800 == 0) {
				System.out.print('\n');
			}
		}

		System.out.println("\n time elapsed: "
				+ (System.currentTimeMillis() - start));
		printSessionStats(session);

		session.flush();
		System.out.println("\n time elapsed after flush: "
				+ (System.currentTimeMillis() - start));
		printSessionStats(session);

		session.clear();
		System.out.println("\n time elapsed after clear: "
				+ (System.currentTimeMillis() - start));
		printSessionStats(session);

		System.gc();
		printSessionStats(session);

	}

	@Test
	public void testIterateCriteriaQueryInTransaction() {
		final long start = System.currentTimeMillis();
		final Session session = getSessionFactory().openSession();
		final Transaction tx = session.beginTransaction();
		session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time for Criteria Query... ");

		final List<Membership> members = session.createCriteria("Membership").list();

		long count = 0;
		for (final Membership member : members) {
			if (++count % 100 == 0) {
				System.out.print('.');
			}
			if (++count % 800 == 0) {
				System.out.print('\n');
			}
		}
		printSessionStats(session);
		tx.commit();
		printSessionStats(session);

		session.close();
		System.out.println("\n time elapsed: "
				+ (System.currentTimeMillis() - start));
	}

	@Test
	public void testIterateTouchingAttributesCriteriaQuery() {
		final long start = System.currentTimeMillis();
		final Session session = getSessionFactory().openSession();
		session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time for Criteria Query... ");

		final List<Membership> members = session.createCriteria("Membership").list();

		long count = 0;
		for (final Membership member : members) {
			member.getAccount().getBalances();
			String code = member.getDefaultRoute().getName();
			code += code;
			if (++count % 100 == 0) {
				System.out.print('.');
			}
			if (++count % 800 == 0) {
				System.out.print('\n');
			}
			code += count;
		}
		System.out.println("\n time elapsed: "
				+ (System.currentTimeMillis() - start));
	}

	@Test
	public void testIterateHSQLQuery() {
		final long start = System.currentTimeMillis();
		final Session session = getSessionFactory().openSession();
		session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time for HSQL Query... ");

		final List<Membership> members = session.createQuery("FROM Membership")
				.list();

		long count = 0;
		for (final Membership membership : members) {
			printout(membership, ++count);
		}
		System.out.println("\n time elapsed: "
				+ (System.currentTimeMillis() - start));
	}

	@Test
	public void testIterateDairyCollection() throws Exception {
		final Session session = getSessionFactory().openSession();
		final Dairy dairy = (Dairy) session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time... ");

		long count = 0;
		final long time0 = System.currentTimeMillis();
		final Collection<Membership> members = dairy.getMemberships();
		final Object[] memberArray = members.toArray();
		for (final Object obj : memberArray) {
			if (obj instanceof Membership) {
				final Membership membership = (Membership) obj;
				printout(membership, ++count);
			}
		}
		final long elapsed = System.currentTimeMillis() - time0;
		System.out.println("\nElapsed: " + elapsed);

		session.close();
	}

	// @Test
	// public void testLoadTime() throws Exception {
	// Session session = getSessionFactory().openSession();
	// Dairy dairy = (Dairy) session.createQuery("From Dairy").uniqueResult();
	//
	// System.out.println("\nTesting load time... ");
	//
	// long time0 = System.currentTimeMillis();
	// Collection<Membership> members = dairy.getMemberships();
	// Object[] memberArray = members.toArray();
	//
	// long elapsed = System.currentTimeMillis() - time0;
	// System.out.println("Elapsed: " + elapsed);
	//
	// session.close();
	// elapsed = System.currentTimeMillis() - time0;
	// System.out.println("Elapsed after close: " + elapsed);
	// }
	//
	// @Test
	// public void testPersistenceManagerSessionPerformance() {
	// PersistenceManager pm = PersistenceManager.getDefault();
	// Session session = pm.getSession();
	//
	// iterateUsing(session);
	// }

	@Override
	public void printSessionStats(final Session session) {
		System.out.printf("Session Collection Count: %s \n", session
				.getStatistics().getCollectionCount());
		System.out.printf("Session Entity Count: %s \n", session
				.getStatistics().getEntityCount());
		System.out.printf(
				"Session Factory Role Names: %s \n",
				Arrays.toString(session.getSessionFactory().getStatistics()
						.getCollectionRoleNames()));

		printFactoryStats(session.getSessionFactory());
		printMemoryStats(false);
		printMemoryStats(true);
	}

	@Override
	public void printFactoryStats(final SessionFactory factory) {
		System.out.printf("Session Factory Close Statement Count: %s \n",
				factory.getStatistics().getCloseStatementCount());
		System.out.printf("Session Factory Collection Fetch Count: %s \n",
				factory.getStatistics().getCollectionFetchCount());
		System.out.printf("Session Factory Collection Load Count: %s \n",
				factory.getStatistics().getCollectionLoadCount());
		System.out.printf("Session Factory Entity Load Count: %s \n", factory
				.getStatistics().getEntityLoadCount());
		System.out.printf("Session Factory Flush Count: %s \n", factory
				.getStatistics().getFlushCount());
		System.out.printf("Session Factory Collection Recreate Count: %s \n",
				factory.getStatistics().getCollectionRecreateCount());
		System.out.printf("Session Factory Remove Count: %s \n", factory
				.getStatistics().getCollectionRemoveCount());
		System.out.printf("Second Level Cache Regions: %s \n", Arrays.toString(factory
				.getStatistics().getSecondLevelCacheRegionNames()));

	}

	@Override
	public void printMemoryStats(boolean gc) {
		if (gc) {
			System.gc();
			System.out.println("Running garbage collector...");
		}

		System.out.printf("Max Memory  : %,10d\n", Runtime.getRuntime()
				.maxMemory());
		System.out.printf("Total Memory : %,10d\n", Runtime.getRuntime()
				.totalMemory());
		System.out.printf("Free Memory  : %,10d\n", Runtime.getRuntime()
				.freeMemory());
	}

	private void showCollection(String name, Collection<?> collection) {
		System.out.printf("\n%s count: %d\n", name,
				LazyCollectionUtils.size(collection));
		System.out.printf("Is Lazy Loadable? : %s\n",
				LazyCollectionUtils.isLazyLoadableCollection(collection));

	}

}
