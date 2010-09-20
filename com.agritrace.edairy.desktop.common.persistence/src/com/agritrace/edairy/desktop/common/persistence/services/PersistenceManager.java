package com.agritrace.edairy.desktop.common.persistence.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.RienaLocations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.internal.common.persistence.Activator;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class PersistenceManager implements Provider<Session> {
	private static final org.eclipse.equinox.log.Logger LOG = Log4r.getLogger(Activator.getDefault(),
			PersistenceManager.class);
	
	@Inject
	private static Provider<PersistenceManager> PROVIDER;

	@Deprecated
	public static PersistenceManager getDefault() {
		return PROVIDER.get();
	}

	private static File getConfigFileArea() {
		File ret = null;
		try {
			ret = RienaLocations.getDataArea();
		} catch (Exception e) {
			ret = new File(".");
			ret = ret.getAbsoluteFile();
		}
		return ret;
	}

	private HbDataStore hbds;
	private Session session;
	private final SessionFactory sessionFactory;

	@Inject
	protected PersistenceManager(HbDataStore hbds) {
		LOG.log(LogService.LOG_INFO, " ** Creating PersistenceManager [" + getClass().getName() + ":" + hashCode()
				+ "]");

		this.hbds = hbds;
		postInit();
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
	
	public final Properties getProperties() {
		return hbds.getProperties();
	}
	
	public final void saveProperties(Properties properties) throws IOException {
		File propFile = new File(getConfigFileArea(), PersistenceModule.PROPERTIES_FILE_NAME);
		LOG.log(LogService.LOG_INFO, "Saving properties to " + propFile);

		properties.store(new FileOutputStream(propFile), "default properties, written on " + new Date());
	}

	private void postInit() {
		LOG.log(LogService.LOG_DEBUG, ">>>>>> PersistenceManager[" + getClass().getName() + ":" + hashCode()
				+ "] started on thread " + Thread.currentThread());
		
		File propFile = new File(getConfigFileArea(), PersistenceModule.PROPERTIES_FILE_NAME);
		
		if (!propFile.exists()) {
			try {
				saveProperties(getProperties());
			} catch (FileNotFoundException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			} catch (IOException e) {
				LOG.log(LogService.LOG_WARNING, e.getMessage(), e);
			}
		}
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
