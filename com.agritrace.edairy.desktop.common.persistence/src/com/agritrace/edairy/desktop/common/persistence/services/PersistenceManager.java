package com.agritrace.edairy.desktop.common.persistence.services;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.internal.common.persistence.Activator;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PersistenceManager implements Provider<Session> {
	private static final Logger LOG = Log4r.getLogger(Activator.getDefault(), PersistenceManager.class);
	
	@Inject
	private static Provider<PersistenceManager> PROVIDER;

	@Deprecated
	public static PersistenceManager getDefault() {
		return PROVIDER.get();
	}

	private Session session;
	private final SessionFactory sessionFactory;

	@Inject
	protected PersistenceManager(HbDataStore hbds) {
		LOG.log(LogService.LOG_INFO, " ** Creating PersistenceManager [" + getClass().getName() + ":" + hashCode()
				+ "]");

		sessionFactory = hbds.getSessionFactory();
	}

	/**
	 * Deprecated. Inject a <code>Provider&lt;Session&gt;</code> instead.
	 * 
	 * @return New Hibernate session
	 */
	@Deprecated
	public Session getSession() {
		return get();
	}
	
	@Override
	public Session get() {
		if (null == session) {
			session = sessionFactory.openSession();
			LOG.log(LogService.LOG_DEBUG, "--> created session: " + session);
		} else if (!session.isConnected()) {
			session = sessionFactory.openSession();
			LOG.log(LogService.LOG_DEBUG, "--> creatied session: " + session);
		}
		return session;
	}
}
