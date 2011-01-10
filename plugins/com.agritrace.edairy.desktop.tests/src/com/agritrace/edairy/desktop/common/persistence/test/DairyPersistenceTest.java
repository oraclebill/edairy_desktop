package com.agritrace.edairy.desktop.common.persistence.test;

import java.util.Collection;

import org.eclipse.emf.teneo.hibernate.LazyCollectionUtils;
import org.hibernate.Session;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;


public class DairyPersistenceTest extends ModelPersistenceBase  {

	@Test
	public void testLazyLoadBehaviour() throws Exception {
		final Session session = getSessionFactory().openSession();
		final Dairy dairy = (Dairy) session.createQuery("From Dairy").uniqueResult();

		final Collection<Employee> employees = dairy.getEmployees();
		showCollection("Employees", employees);

		final Collection<Membership> members = dairy.getMemberships();
		showCollection("Members", members);

		showCollection("requests", dairy.getAnimalHealthRequests());
		showCollection("branches", dairy.getBranchLocations());
		showCollection("journals", dairy.getCollectionJournals());
		showCollection("contact methods", dairy.getContactMethods());
		showCollection("contacts", dairy.getContacts());
	}


	private void showCollection(String name, Collection<?> collection) {
		System.out.printf("\n%s count: %d\n", name, LazyCollectionUtils.size(collection));
		System.out.printf("Is Lazy Loadable? : %s\n", LazyCollectionUtils.isLazyLoadableCollection(collection));

	}


}
