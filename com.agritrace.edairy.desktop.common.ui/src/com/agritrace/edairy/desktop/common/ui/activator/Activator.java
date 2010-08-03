package com.agritrace.edairy.desktop.common.ui.activator;

import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroup;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.DateRange;
import com.agritrace.edairy.desktop.common.ui.controls.daterange.DateRangeRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.ProfilePhotoComposite;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.ProfilePhotoRidget;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends DesktopBaseActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.agritrace.edairy.desktop.common.ui"; //$NON-NLS-1$

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
		SwtControlRidgetMapper.getInstance().addMapping(ProfilePhotoComposite.class, ProfilePhotoRidget.class);
		SwtControlRidgetMapper.getInstance().addMapping(DateRange.class, DateRangeRidget.class);
		SwtControlRidgetMapper.getInstance().addMapping(ContactMethodsGroup.class, ContactMethodsGroupRidget.class);
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
