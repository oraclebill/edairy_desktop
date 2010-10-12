package com.agritrace.edairy.desktop.internal.common.persistence;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.osgi.service.log.LogService;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class SessionProvider implements Provider<Session> {
	private static final Logger LOG = Log4r.getLogger(Activator.getDefault(), "com.agritrace.edairy.desktop.internal.common.persistence.SessionProvider");

	private SessionFactory sessionFactory;
	private Session session;

	@Inject
	protected SessionProvider(HbDataStore hbds) {
		LOG.log(LogService.LOG_INFO, " ** Creating SessionProvider [" + getClass().getName() + ":" + hashCode()
				+ "]");

		sessionFactory = hbds.getSessionFactory();
	}

	@Override
	public Session get() {
		// Managed contexts, disabled for now, until future comments from Bill.
		/*
		if (sessionFactory == null) {
			this.sessionFactory = store.getSessionFactory();
			final Session session = sessionFactory.openSession();
			System.err.println(" --> Binding session@" + session.hashCode() + " to managed context." );
			ManagedSessionContext.bind(sessionFactory.openSession());
		}
		return sessionFactory.getCurrentSession();
		*/
		
		if (session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		
		return session;
	}
}
