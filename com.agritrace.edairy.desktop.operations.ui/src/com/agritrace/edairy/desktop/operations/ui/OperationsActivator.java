package com.agritrace.edairy.desktop.operations.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class OperationsActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.agritrace.edairy.desktop.operations.ui"; //$NON-NLS-1$

	private static BundleContext context;

	// The shared instance
	private static OperationsActivator plugin;

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static OperationsActivator getDefault() {
		return plugin;
	}

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		OperationsActivator.context = bundleContext;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		OperationsActivator.context = null;
	}

}
