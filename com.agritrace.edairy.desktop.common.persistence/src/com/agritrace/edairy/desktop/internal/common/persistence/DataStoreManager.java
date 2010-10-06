package com.agritrace.edairy.desktop.internal.common.persistence;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.ManagedSessionContext;

public class DataStoreManager {
	private final HbDataStore store;
	private final SessionFactory sessionFactory;
	
	public DataStoreManager(HbDataStore store) {
		this.store = store;		
		this.sessionFactory = store.getSessionFactory();
		ManagedSessionContext.bind(sessionFactory.openSession());			
	}
		
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();	
	}

}
