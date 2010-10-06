package com.agritrace.edairy.desktop.internal.common.persistence;


import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.agritrace.edairy.desktop.common.persistence.services.ISessionContextManager;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PersistenceManager implements Provider<Session>, ISessionContextManager {
	private static final Logger LOG = Log4r.getLogger(Activator.getDefault(), PersistenceManager.class);
	
	private final SessionFactory sessionFactory;
	private final Interceptor interceptor;
	private Session session;
	private Object currentContext;
	
	@Inject
	protected PersistenceManager(HbDataStore hbds, @Audit Interceptor interceptor) {
		LOG.log(LogService.LOG_INFO, " ** Creating PersistenceManager [" + getClass().getName() + ":" + hashCode()
				+ "]");

		sessionFactory = hbds.getSessionFactory();
		this.interceptor = interceptor;
	}

	@Override
	public Session get() {
		if (null == session) {
			session = sessionFactory.openSession(interceptor);
			LOG.log(LogService.LOG_DEBUG, "--> created session: " + session + " with interceptor " + interceptor);
		} else if (!session.isConnected()) {
			session = sessionFactory.openSession(interceptor);
			LOG.log(LogService.LOG_DEBUG, "--> creatied session: " + session + " with interceptor " + interceptor);
		}
		return session;
	}

	@Override
	public void switchContext(Object context) {
		if (context == currentContext) {
			return;
		}
		
		currentContext = context;
		LOG.log(LogService.LOG_DEBUG, "--> switched context: " + context);
		
		if (session != null) {
			if (session.isOpen()) {
				session.flush();
				session.close();
			}
			
			session = null;
		}
	}
}
