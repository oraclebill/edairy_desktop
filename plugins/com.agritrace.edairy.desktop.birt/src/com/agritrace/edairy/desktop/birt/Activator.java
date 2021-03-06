package com.agritrace.edairy.desktop.birt;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.RienaLocations;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

public class Activator implements BundleActivator {
//	public static final String PLUGIN_ID = "com.agritrace.edairy.desktop.birt";

	private static final Logger LOGGER = Log4r.getLogger(Activator.class);


	public static BundleContext context;
	private static Activator plugin;

	private IReportEngine engine = null;

	static BundleContext getContext() {
		return context;
	}

	public static Activator getDefault() {
		return plugin;
	}

	public IReportEngine getReportEngine() {
		return engine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		plugin = this;
		
		EngineConfig config = null;
		IReportEngineFactory factory;

		// configure engine and platform; create factory object
		config = new EngineConfig();
//		config.setLogger(java.util.logging.Logger.getLogger(Activator.class.getName()));
		config.setLogConfig(RienaLocations.getDataArea().getAbsolutePath(), Level.FINE);
		config.setTempDir(RienaLocations.getDataArea().getAbsolutePath());

		HashMap<String, Object> context = new HashMap<String, Object>();
		context.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, Activator.class.getClassLoader());
		config.setAppContext(context);
		
		try {
			LOGGER.log(LogService.LOG_DEBUG, "Starting BIRT Platform...");
			Platform.startup(config);
		} catch (BirtException ex) {
			ex.printStackTrace();
			throw ex;
		}
		
		LOGGER.log(LogService.LOG_DEBUG, "Creating BIRT engine factory...");
		factory = (IReportEngineFactory) Platform
				.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		if (factory == null) {
			throw new RuntimeException("Failed to create BIRT engine factory");
		}
		
		LOGGER.log(LogService.LOG_DEBUG, "Creating BIRT engine ...");
		engine = factory.createReportEngine(config);
		
        String[] supportedFormats = engine.getSupportedFormats();
        String formatList = null;
        for (String supportedFormat : supportedFormats) {
            if (formatList != null) {
                formatList += ", " + supportedFormat;
            } else {
                formatList = supportedFormat;
            }
        }
        LOGGER.log(LogService.LOG_DEBUG, "BIRT supported formats: " + formatList);

		// create the user reports  directory if it doens't exist
		File reportArea = new File(RienaLocations.getDataArea(), "reports");
		if (!reportArea.exists()) {
			reportArea.mkdirs();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		engine.destroy();
		Platform.shutdown();
		Activator.context = null;
	}

}
