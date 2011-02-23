package com.agritrace.edairy.desktop.internal.common.persistence;

import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Session;
import org.osgi.service.log.LogService;

import com.google.inject.Provider;

public class DataStoreManager {
	private final static Logger LOGGER = Log4r.getLogger(DataStoreManager.class);
	
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
		if (LOGGER.isLoggable(LogService.LOG_DEBUG)) {
			StringBuffer buf  = new StringBuffer();
			buf.append(" >> DataStoreManager@")
				.append(hashCode())
				.append(" using session provider: ")
				.append(sessionProvider.getClass().getName())
				.append("@")
				.append(sessionProvider.hashCode())
				.append(", session=")
				.append(session.getClass().getName())
				.append("@")
				.append(session.hashCode());		
			LOGGER.log(LogService.LOG_DEBUG, buf.toString());
		}
	}
	
}
