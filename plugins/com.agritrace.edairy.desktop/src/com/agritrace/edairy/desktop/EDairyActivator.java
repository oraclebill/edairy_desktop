package com.agritrace.edairy.desktop;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;

/**
 * The activator class controls the plug-in life cycle
 */
public class EDairyActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.agritrace.edairy.desktop.demo.riena"; //$NON-NLS-1$

	// The shared instance
	@Inject
	private static EDairyActivator plugin;

	private Injector injector;

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
		injector = Guice.createInjector(new EDairyModule(context), new AbstractModule() {
			@Override
			protected void configure() {
				bind(EDairyActivator.class).toInstance(EDairyActivator.this);
				requestStaticInjection(EDairyActivator.class);
			}
			
			@Provides
			public Dairy providesLocalDairy(IDairyRepository dairyRepo) {
			    return dairyRepo.getLocalDairy();
			}
			
		});
		injector.injectMembers(this);
		super.start(context);
		context.registerService(Injector.class.getName(), injector, null);
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

	public void injectMembers(Object obj) {
		injector.injectMembers(obj);		
	}
}
