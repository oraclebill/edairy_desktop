package com.agritrace.edairy.desktop.internal.collection.ui;

import org.eclipse.swt.graphics.Image;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends DesktopBaseActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.agritrace.edairy.desktop.collection.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static Image getImage(String calendar) {
		return null;
	}

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
//		SwtControlRidgetMapper.getInstance().addMapping(JournalHeaderComposite.class, JournalHeaderRidget.class);
//		SwtControlRidgetMapper.getInstance().addMapping(CollectionLineComposite.class, CollectionLineRidget.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

}
