package com.agritrace.edairy.services.framework;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ServicesActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.agritrace.edairy.services"; //$NON-NLS-1$

	// The shared instance
	private static ServicesActivator plugin;
	
	/**
	 * The constructor
	 */
	public ServicesActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ServicesActivator getDefault() {
		return plugin;
	}

}
