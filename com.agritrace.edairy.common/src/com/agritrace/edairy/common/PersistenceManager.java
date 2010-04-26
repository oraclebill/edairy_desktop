package com.agritrace.edairy.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.agritrace.edairy.common.datamodel.dairy.Dairy;

public class PersistenceManager {
	public static final String PERSISTENCE_UNIT_NAME = "com.agritrace.edairy.persistence";

	private PersistenceManager() {
		initPersistenceManager();
	}

	private static class PersistenceManagerHolder {
		private static final PersistenceManager INSTANCE = new PersistenceManager();
	}

	public static PersistenceManager getInstance() {
		return PersistenceManagerHolder.INSTANCE;
	}

	private EntityManagerFactory factory;
	private EntityManager em;

	private void initPersistenceManager() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
		
		loadDairyManager();		
	}

	private void loadDairyManager() {
		
	}
	
	public Dairy getDairy(String dairyId) {
		Query q = em.createQuery("select d from Dairy where d.id = ''");
		return null;
	}
	
	private void testPersistenceManager() {

		// Begin a new local transaction so that we can persist a new entity
		em.getTransaction().begin();

		// Read the existing entries
		Query q = em.createQuery("select m from Person m");
		// Persons should be empty

		// Do we have entries?
		boolean createNewEntries = (q.getResultList().size() == 0);

		// No, so lets create new entries
		if (createNewEntries) {
			assert(q.getResultList().size() == 0);
			
//			Family family = new Family();
//			family.setDescription("Family for the Knopfs");
//			em.persist(family);
//			for (int i = 0; i < 40; i++) {
//				Person person = new Person();
//				person.setFirstName("Jim_" + i);
//				person.setLastName("Knopf_" + i);
//				em.persist(person);
//				// First we have to persists the job
//				// Now persists the new person
//				family.getMembers().add(person);
//				em.persist(person);
//				em.persist(family);
//			}
		}

		// Commit the transaction, which will cause the entity to
		// be stored in the database
		em.getTransaction().commit();

		// It is always good practice to close the EntityManager so that
		// resources are conserved.
		em.close();
	}
}
