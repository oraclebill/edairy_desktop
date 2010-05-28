package com.agritrace.edairy.desktop.operations.ui;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingFactory;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.agritrace.edairy.desktop.suppliers.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private static BundleContext context;
	private SessionFactory sFactory;
	private HbDataStore hbds;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		String hbName = "dairytest";
		String dbName = "dairytest";

		// create the HbDataStore
		hbds = HbHelper.INSTANCE.createRegisterDataStore(hbName);

		// The hibernate properties can be set by having a hibernate.properties file in the root of
		// the classpath.
		// Another approach is setting the properties in the HbDataStore. To do this comment out the
		// following lines
		// For more information see section 3.1 of the Hibernate manual
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" + dbName);
		//props.setProperty(Environment.PASS, "root");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");
		
		// show all sql 
//		props.setProperty(Environment.SHOW_SQL, "true");
		
		// drop and recreate db on startup
		props.setProperty(Environment.HBM2DDL_AUTO, "update");
		
		hbds.setProperties(props);
		hbds.setEPackages( new EPackage[] { TrackingPackage.eINSTANCE, DairyPackage.eINSTANCE, 
				ModelPackage.eINSTANCE, AccountPackage.eINSTANCE, RequestsPackage.eINSTANCE } );
		

		final Asset asset = DairyFactory.eINSTANCE.createAsset();
		System.err.println(asset.getClass().getName());
		hbds.initialize();
		sFactory = hbds.getSessionFactory();
		
		context.registerService(SessionFactory.class.getName(), sFactory, new Hashtable());
		
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		sFactory.close();
		hbds.close();
		sFactory = null;
		hbds = null;
	}
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
