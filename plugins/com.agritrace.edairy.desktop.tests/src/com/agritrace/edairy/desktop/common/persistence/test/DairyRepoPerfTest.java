package com.agritrace.edairy.desktop.common.persistence.test;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.hibernate.Hibernate;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public class DairyRepoPerfTest extends ModelPersistenceBase {

//	@Test
	public void testDairyRepoSizePerformance() throws Exception {
		final Session session = getSessionFactory().openSession();

		System.out.println("\n  ---- Testing iterate time  ----  \n");

		long count = 0;
		long time0 = System.currentTimeMillis();

		final Dairy localDairy = (Dairy) session.createQuery("From Dairy")
				.uniqueResult();
		Hibernate.initialize(localDairy);
		final List<EReference> persistentCollections = Arrays.asList(
				DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS,
				DairyPackage.Literals.DAIRY__CUSTOMERS,
				DairyPackage.Literals.DAIRY__DAIRY_BINS,
				DairyPackage.Literals.DAIRY__EMPLOYEES,
				DairyPackage.Literals.DAIRY__ROUTES,
				DairyPackage.Literals.DAIRY__VEHICLES,
				DairyPackage.Literals.DAIRY__SUPPLIERS,
				ModelPackage.Literals.CONTACTABLE__CONTACT_METHODS);
		for (final EStructuralFeature feature : persistentCollections) {
			Hibernate.initialize(localDairy.eGet(feature));
		}

		long elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.println("Initialization time : " + elapsed);
		printSessionStats(session);

		System.out.println("Flushing : ");
		session.flush();

		elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.println("\n flush time : " + elapsed);
		printSessionStats(session);

		System.out.println("Iterating : ");

		final Collection<Membership> members = localDairy.getMemberships();
		final Object[] memberArray = members.toArray();
		for (final Object obj : memberArray) {
			if (obj instanceof Membership) {
				final Membership membership = (Membership) obj;
				printout(membership, ++count);
			}
		}

		elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.println(" iterate time : " + elapsed);
		printSessionStats(session);

		System.out.println("Clearing : ");

		session.clear();

		elapsed = System.currentTimeMillis() - time0;
		System.out.println(" clear time : " + elapsed);
		printSessionStats(session);

		session.close();

	}

	@Test
	public void testDairyRepoInterrupted() throws Exception {
		final Session session = getSessionFactory().openSession();

		System.out.println("\n  ---- Testing iterate time  ----  \n");

		long count = 0;
		long time0 = System.currentTimeMillis();

		final Dairy localDairy = (Dairy) session.createQuery("From Dairy")
				.uniqueResult();
		Hibernate.initialize(localDairy);
		final List<EReference> persistentCollections = Arrays.asList(
				DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS,
				DairyPackage.Literals.DAIRY__CUSTOMERS,
				DairyPackage.Literals.DAIRY__DAIRY_BINS,
				DairyPackage.Literals.DAIRY__EMPLOYEES,
				// DairyPackage.Literals.DAIRY__ROUTES,
				DairyPackage.Literals.DAIRY__VEHICLES,
				DairyPackage.Literals.DAIRY__SUPPLIERS,
				ModelPackage.Literals.CONTACTABLE__CONTACT_METHODS);
		for (final EStructuralFeature feature : persistentCollections) {
			Hibernate.initialize(localDairy.eGet(feature));
		}

		long elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.println("Initialized time : " + elapsed);
		printSessionStats(session);

		System.out.println("\nClearing : ");

		session.clear();

		elapsed = System.currentTimeMillis() - time0;
		System.out.println(" clear time : " + elapsed);
		printSessionStats(session);

		System.out.println("\nIterating : ");

		try {
			final Collection<Membership> members = localDairy.getMemberships();
			final Object[] memberArray = members.toArray();
			for (final Object obj : memberArray) {
				if (obj instanceof Membership) {
					final Membership membership = (Membership) obj;
					printout(membership, ++count);
				}
			}
			fail("no lazy init?");
		} catch (final LazyInitializationException lie) {

		}

		{
			final Collection<Employee> members = localDairy.getEmployees();
			final Object[] memberArray = members.toArray();
			for (final Object obj : memberArray) {
				if (obj instanceof Membership) {
					// printout(membership, ++count);
					++count;
				}
			}
		}
		elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.println(" iterate time : " + elapsed);
		printSessionStats(session);

		System.out.println("Flushing : ");
		session.flush();

		elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.printf("\n flush time : " + elapsed);
		printSessionStats(session);

		session.close();

	}

	@Test
	public void testDairyRepoInterruptedNonInit() throws Exception {
		final Session session = getSessionFactory().openSession();

		System.out.println("\n  ---- Testing iterate time  ----  \n");

		long count = 0;
		long time0 = System.currentTimeMillis();

		final Dairy localDairy = (Dairy) session.createQuery("From Dairy")
				.uniqueResult();
		Hibernate.initialize(localDairy);
		final List<EReference> persistentCollections = Arrays.asList(
				DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS,
				DairyPackage.Literals.DAIRY__CUSTOMERS,
				DairyPackage.Literals.DAIRY__DAIRY_BINS,
				// DairyPackage.Literals.DAIRY__EMPLOYEES,
				// DairyPackage.Literals.DAIRY__ROUTES,
				DairyPackage.Literals.DAIRY__VEHICLES,
				DairyPackage.Literals.DAIRY__SUPPLIERS,
				ModelPackage.Literals.CONTACTABLE__CONTACT_METHODS);
		for (final EStructuralFeature feature : persistentCollections) {
			Hibernate.initialize(localDairy.eGet(feature));
		}

		long elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.println("Initialized time : " + elapsed);
		printSessionStats(session);

		System.out.println("\nClearing : ");

		session.clear();

		elapsed = System.currentTimeMillis() - time0;
		System.out.println(" clear time : " + elapsed);
		printSessionStats(session);

		System.out.println("\nIterating : ");

		try {
			final Collection<Membership> members = localDairy.getMemberships();
			final Object[] memberArray = members.toArray();
			for (final Object obj : memberArray) {
				if (obj instanceof Membership) {
					final Membership membership = (Membership) obj;
					printout(membership, ++count);
				}
			}
			fail("no lazy init?");
		} catch (final LazyInitializationException lie) {

		}

		{
			final Collection<Employee> members = localDairy.getEmployees();
			final Object[] memberArray = members.toArray();
			for (final Object obj : memberArray) {
				if (obj instanceof Membership) {
					// printout(membership, ++count);
					++count;
				}
			}
		}
		elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.println(" iterate time : " + elapsed);
		printSessionStats(session);

		System.out.println("Flushing : ");
		session.flush();

		elapsed = System.currentTimeMillis() - time0;
		time0 = System.currentTimeMillis();
		System.out.printf("\n flush time : " + elapsed);
		printSessionStats(session);

		session.close();

	}

	@Test
	public void testSizeDifferences() {


		printMemoryStats("Before anything...", false);

		final Session session = getSessionFactory().openSession();

		printMemoryStats("Session created...", false);

		Dairy localDairy = (Dairy) session.createQuery("From Dairy")
				.uniqueResult();
		Hibernate.initialize(localDairy);
		final List<EReference> persistentCollections = Arrays.asList(
//				DairyPackage.Literals.DAIRY__BRANCH_LOCATIONS,
//				DairyPackage.Literals.DAIRY__CUSTOMERS,
//				DairyPackage.Literals.DAIRY__DAIRY_BINS,
				 DairyPackage.Literals.DAIRY__MEMBERSHIPS,
				 DairyPackage.Literals.DAIRY__ROUTES,
//				DairyPackage.Literals.DAIRY__VEHICLES,
//				DairyPackage.Literals.DAIRY__SUPPLIERS,
				ModelPackage.Literals.CONTACTABLE__CONTACT_METHODS
				);
		for (final EStructuralFeature feature : persistentCollections) {
			Hibernate.initialize(localDairy.eGet(feature));
		}

		printMemoryStats("Dairy Initialized...", false);

		printMemoryStats("...", true);

		localDairy = null;

		printMemoryStats(" null dairy...", true);


	}

}
