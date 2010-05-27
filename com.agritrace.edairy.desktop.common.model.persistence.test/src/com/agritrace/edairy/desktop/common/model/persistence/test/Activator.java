package com.agritrace.edairy.desktop.common.model.persistence.test;

import org.eclipse.core.runtime.Plugin;
import org.hibernate.SessionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;

public class Activator extends Plugin {
	private static BundleContext context;
	private ServiceReference sessionFactoryRef;
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		this.context = context;
		
		sessionFactoryRef = context.getServiceReference(SessionFactory.class.getName());
		SessionFactory sFactory = (SessionFactory)context.getService(sessionFactoryRef);
		
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		context.ungetService(sessionFactoryRef);
		context = null;
	}
	
	
}
