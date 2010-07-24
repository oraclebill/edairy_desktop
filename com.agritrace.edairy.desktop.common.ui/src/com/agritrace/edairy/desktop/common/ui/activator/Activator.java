package com.agritrace.edairy.desktop.common.ui.activator;

import org.eclipse.riena.ui.ridgets.swt.uibinding.SwtControlRidgetMapper;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.controls.CommunicationsGroup;
import com.agritrace.edairy.desktop.common.ui.controls.CommunicationsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.DateRange;
import com.agritrace.edairy.desktop.common.ui.controls.DateRangeRidget;
import com.agritrace.edairy.desktop.common.ui.controls.ProfilePhotoComposite;
import com.agritrace.edairy.desktop.common.ui.controls.ProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.ridgets.EditableTable;
import com.agritrace.edairy.desktop.common.ui.ridgets.EditableTableRidget;

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
		SwtControlRidgetMapper.getInstance().addMapping(EditableTable.class, EditableTableRidget.class);
		SwtControlRidgetMapper.getInstance().addMapping(ProfilePhotoComposite.class, ProfilePhotoRidget.class);
		SwtControlRidgetMapper.getInstance().addMapping(DateRange.class, DateRangeRidget.class);
		SwtControlRidgetMapper.getInstance().addMapping(CommunicationsGroup.class, CommunicationsGroupRidget.class);
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
