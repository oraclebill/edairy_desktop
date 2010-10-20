package com.agritrace.edairy.desktop.common.persistence.test;

import org.eclipse.core.runtime.Plugin;
import org.hibernate.SessionFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator extends Plugin {
	private ServiceReference sessionFactoryRef;

	@Override
	public void start(BundleContext context) throws Exception {
		sessionFactoryRef = context.getServiceReference(SessionFactory.class.getName());
		context.getService(sessionFactoryRef);


	}

	@Override
	public void stop(BundleContext context) throws Exception {
		context.ungetService(sessionFactoryRef);
		context = null;
	}


}