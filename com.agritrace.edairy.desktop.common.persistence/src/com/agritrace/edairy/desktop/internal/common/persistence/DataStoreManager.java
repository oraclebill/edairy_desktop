package com.agritrace.edairy.desktop.internal.common.persistence;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.ManagedSessionContext;

public class DataStoreManager {
	private final HbDataStore store;
	private  SessionFactory sessionFactory;
	
	public DataStoreManager(HbDataStore store) {
		this.store = store;		
		sessionFactory = null;
	}
		
	protected Session getCurrentSession() {
		if (sessionFactory == null) {
			this.sessionFactory = store.getSessionFactory();
			Session session = sessionFactory.openSession();
			System.err.println(" --> Binding session@" + session.hashCode() + " to managed context." );
			ManagedSessionContext.bind(sessionFactory.openSession());			
		}
		return sessionFactory.getCurrentSession();	
	}

}
