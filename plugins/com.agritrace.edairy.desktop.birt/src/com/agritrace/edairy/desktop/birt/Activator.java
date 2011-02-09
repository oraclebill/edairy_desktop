package com.agritrace.edairy.desktop.birt;

import java.io.File;
import java.util.Arrays;

import org.eclipse.riena.core.RienaLocations;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	static String PLUGIN_ID = "com.agritrace.edairy.desktop.birt";

	public static BundleContext context;

	private static Activator plugin;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		plugin = this;
		
		// create the reporting library directory if it doens't exist
		File reportArea = new File(RienaLocations.getDataArea(), "reports");
		if (! reportArea.exists()) {
			reportArea.mkdirs();
		}
		
		// create subdirectories for each report class
		String[] reportAreaNames = { "Milk Operations", "Membership", "Stores" };
		for (String name : reportAreaNames) {
			File areaDirectory = new File(reportArea, name);			
			if (!areaDirectory.exists()) {
				areaDirectory.mkdir();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	public static Activator getDefault() {
		return plugin;
	}

}
