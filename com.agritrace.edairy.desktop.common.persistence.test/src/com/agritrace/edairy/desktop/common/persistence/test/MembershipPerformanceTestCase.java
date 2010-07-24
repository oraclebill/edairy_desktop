package com.agritrace.edairy.desktop.common.persistence.test;

import java.util.Collection;
import java.util.Formatter;
import java.util.List;

import org.eclipse.emf.teneo.hibernate.LazyCollectionUtils;
import org.hibernate.Session;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;

public class MembershipPerformanceTestCase extends ModelPersistenceBase {
	@Test
	public void testLazyLoadBehaviour() throws Exception {
		Session session = getSessionFactory().openSession();
		Dairy dairy = (Dairy) session.createQuery("From Dairy").uniqueResult();

		Collection<Employee> employees = dairy.getEmployees();
		showCollection("Employees", employees);

		Collection<Membership> members = dairy.getMemberships();
		showCollection("Members", members);
		session.close();
	}

	@Test
	public void testIterateCriteriaQuery() {
		long start = System.currentTimeMillis();
		Session session = getSessionFactory().openSession();
		session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time for Criteria Query... ");

		List<Membership> members = session.createCriteria("Membership").list();

		long count = 0;
		for (Membership member : members) {
			if (++count % 100 == 0)
				System.out.print('.');
			if (++count % 800 == 0)
				System.out.print('\n');
		}
		System.out.println("\n time elapsed: " + (System.currentTimeMillis() - start));
	}

	@Test
	public void testIterateHSQLQuery() {
		long start = System.currentTimeMillis();
		Session session = getSessionFactory().openSession();
		session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time for HSQL Query... ");

		List<Membership> members = session.createQuery("FROM Membership").list();

		long count = 0;
		for (Membership membership : members) {
			printout(membership, ++count);
		}
		System.out.println("\n time elapsed: " + (System.currentTimeMillis() - start));
	}

	@Test
	public void testIterateDairyCollection() throws Exception {
		Session session = getSessionFactory().openSession();
		Dairy dairy = (Dairy) session.createQuery("From Dairy").uniqueResult();

		System.out.println("\nTesting iterate time... ");

		long count = 0;
		long time0 = System.currentTimeMillis();
		Collection<Membership> members = dairy.getMemberships();
		Object[] memberArray = members.toArray();
		for (Object obj : memberArray) {
			if (obj instanceof Membership) {
				Membership membership = (Membership) obj;
				printout(membership, ++count);
			}
		}
		long elapsed = System.currentTimeMillis() - time0;
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

	private void showCollection(String name, Collection<?> collection) {
		System.out.printf("\n%s count: %d\n", name, LazyCollectionUtils.size(collection));
		System.out.printf("Is Lazy Loadable? : %s\n", LazyCollectionUtils.isLazyLoadableCollection(collection));

	}
	
	private void printout(Membership membership, long count) {
		Account a = membership.getAccount();
		Farmer f = membership.getMember();
		Route r = membership.getDefaultRoute();
		Formatter formatter = new Formatter();
		formatter.format("Member: %s, Account: %s, Farmer: %s, Route: %s\n", membership.getApplicationDate(),
				a.getEstablished(), f.getFamilyName(), r.getCode());
		if (count % 100 == 0)
			System.out.print('.');
		if (count % 800 == 0)
			System.out.print('\n');
	}
	


}
