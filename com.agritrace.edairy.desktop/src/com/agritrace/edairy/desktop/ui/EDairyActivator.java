package com.agritrace.edairy.desktop.ui;

import java.text.ParseException;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class EDairyActivator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "com.agritrace.edairy.desktop.demo.riena"; //$NON-NLS-1$

    // The shared instance
    private static EDairyActivator plugin;

    /**
     * The constructor
     */
    public EDairyActivator() {
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
	// SwtControlRidgetMapper.getInstance().addMapping(CommonMasterDetailsComposite.class,
	// StatuslineUIProcessRidget.class);
	setupDairyResource();

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

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static EDairyActivator getDefault() {
	return plugin;
    }

    /**
     * Return a "shared" image instance using the given colorKey. Shared images
     * are managed automatically and must not be disposed by client code.
     * 
     * @param imageKey
     *            a non-null String; see {@link SharedImages} for valid keys
     * @return a non-null Image instance
     */
    public static synchronized Image getImage(final String path) {
	final ImageDescriptor imageDescriptor = getImageDescriptor(path);
	if (imageDescriptor != null) {
	    return imageDescriptor.createImage();
	}
	return ImageStore.getInstance().getImage(path);

    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
	return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

    private void setupDairyResource() {
	try {
	    // String baseDir =
	    // RienaLocations.getDataArea(plugin.getBundle()).getAbsolutePath();
	    final String baseDir = System.getProperty("edairy.db.root", "/tmp");
	    DairyDemoResourceManager.INSTANCE.createDairyResource(baseDir);
	} catch (final ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}