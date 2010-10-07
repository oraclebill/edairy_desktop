package com.agritrace.edairy.desktop.common.ui.controllers;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
//import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.persistence.services.IDbPropertiesManager;
import com.google.inject.Inject;

public class SiteSettingsController {
	public static final String DB_HOST = "SiteSettingsController.Custom.DB_HOST";
	public static final String DB_NAME = "SiteSettingsController.Custom.DB_NAME";
	public static final String URL = "hibernate.connection.url";
	
	private IDbPropertiesManager manager;
	
	@Inject
	public SiteSettingsController(IDbPropertiesManager manager) {
		this.manager = manager;
	}
	
	private static PreferenceStore loadPreferenceStore(Properties props) {
		final PreferenceStore prefs = new PreferenceStore();
		
		for (final Enumeration<?> e = props.propertyNames(); e.hasMoreElements(); ) {
			String key = e.nextElement().toString();
			
			if (!key.equals(URL))
				prefs.putValue(key, props.getProperty(key));
		}

		// JDBC URL requires special treatment
		final Matcher matcher = Pattern.compile("jdbc:mysql://(.*)/(.*)").matcher(props.getProperty(URL));
		matcher.matches();
		prefs.putValue(DB_HOST, matcher.group(1));
		prefs.putValue(DB_NAME, matcher.group(2));
		
		return prefs;
	}
		
	private static void dumpPreferenceStore(PreferenceStore prefs, Properties props) {
		for (final String key: prefs.preferenceNames()) {
			if (!key.equals(DB_HOST) && !key.equals(DB_NAME))
				props.setProperty(key, prefs.getString(key));
		}
		
		// JDBC URL requires special treatment
		final String url = String.format("jdbc:mysql://%s/%s", prefs.getString(DB_HOST), prefs.getString(DB_NAME));
		props.setProperty(URL, url);
	}
	
	private Properties props;
	private PreferenceStore prefs;

	/**
	 * Load the properties.
	 * 
	 * @return Preference store to use in a preference page
	 */
	public IPreferenceStore loadData() {
		props = manager.getProperties();
		prefs = loadPreferenceStore(props);
		return prefs;
	}
	
	/**
	 * Save the properties.
	 * 
	 * @return Whether the database properties have been modified since last change.
	 * @throws IOException
	 */
	public boolean saveData() throws IOException {
		Properties propsCopy = (Properties) props.clone();
		dumpPreferenceStore(prefs, props);
		
		if (propsCopy.equals(props))
			return false;
		
		manager.setProperties(props);
		return true;
	}
}
