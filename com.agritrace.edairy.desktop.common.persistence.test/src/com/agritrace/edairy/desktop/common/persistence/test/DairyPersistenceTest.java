package com.agritrace.edairy.desktop.common.persistence.test;

import java.util.Collection;

import org.eclipse.emf.teneo.hibernate.LazyCollectionUtils;
import org.hibernate.Session;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.test.ModelPersistenceBase;


public class DairyPersistenceTest extends ModelPersistenceBase  {

	@Test
	public void testLazyLoadBehaviour() throws Exception {
		Session session = getSessionFactory().openSession();
		Dairy dairy = (Dairy) session.createQuery("From Dairy").uniqueResult();

		Collection<Employee> employees = dairy.getEmployees();
		showCollection("Employees", employees);

		Collection<Membership> members = dairy.getMemberships();
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
