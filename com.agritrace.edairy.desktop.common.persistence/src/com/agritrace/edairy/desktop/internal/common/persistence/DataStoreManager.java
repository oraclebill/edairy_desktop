package com.agritrace.edairy.desktop.internal.common.persistence;

import org.hibernate.Session;

import com.google.inject.Provider;

public class DataStoreManager {
	private final Provider<Session> sessionProvider;

	public DataStoreManager(Provider<Session> provider) {
		sessionProvider = provider;
	}

	protected Session getCurrentSession() {
		Session session = sessionProvider.get();
		
		debugPrint(session);
		
		return session;
	}

	private void debugPrint(Session session) {
		System.err.println(" >> DataStoreManager@" + hashCode() + " using session provider: "
				+ sessionProvider.getClass().getName() + "@" + sessionProvider.hashCode());
		System.err.println(" >> DataStoreManager@" + hashCode() + " returning session: " + session.getClass().getName()
				+ "@" + session.hashCode());		
	}
	
}
