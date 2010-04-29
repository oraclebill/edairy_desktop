package com.agritrace.edairy.common.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.agritrace.edairy.common.datamodel.dairy.Dairy;

public class DairyManager {
	public static final String PERSISTENCE_UNIT_NAME = "com.agritrace.edairy.persistence";
	public static final String EDAIRY_LOCAL_ID_PROPERTY = "com.agritrace.edairy.site.dairy_id";	// todo - somewhere else...

	private DairyManager() {
		initPersistenceManager();
	}

	private static class PersistenceManagerHolder {
		private static final DairyManager INSTANCE = new DairyManager();
	}

	public static DairyManager INSTANCE() {
		return PersistenceManagerHolder.INSTANCE;
	}

	private EntityManagerFactory factory;
	private EntityManager entityMgr;

	private void initPersistenceManager() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		entityMgr = factory.createEntityManager();
		
		loadDairyManager();		
	}

	private void loadDairyManager() {
		
	}
	
	public Dairy getLocalDairy() {
		Long dairyId = Long.getLong(System.getProperty(EDAIRY_LOCAL_ID_PROPERTY));
		return getDairyById(dairyId);
	}
	
	public Dairy getDairyById(Long dairyId) {
		return entityMgr.find(Dairy.class, dairyId);
	}
	

}
