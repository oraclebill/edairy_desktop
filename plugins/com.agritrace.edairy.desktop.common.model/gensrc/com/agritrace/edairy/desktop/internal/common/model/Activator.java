package com.agritrace.edairy.desktop.internal.common.model;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator  implements BundleActivator
{
	private static Activator instance;
	private BundleContext context;
	
	public static Activator getDefault() {
		return instance;
	}
	
	public BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext context) throws Exception
	{
		instance = this;
		this.context = context;
	}

	@Override
	public void stop(BundleContext context) throws Exception
	{
		instance = null;
		this.context = null;
	}

}
