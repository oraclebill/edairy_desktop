package com.agritrace.edairy.desktop.internal.common.persistence;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AuditSessionProvider implements Provider<Session> {
	private final SessionFactory sessionFactory;
	private Session session;

	@Inject
	protected AuditSessionProvider(@Audit HbDataStore hbds) {
		sessionFactory = hbds.getSessionFactory();
	}

	@Override
	public Session get() {
		if (session == null || !session.isConnected()) {
			session = sessionFactory.openSession();
		}
		
		return session;
	}
}
