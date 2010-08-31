package com.agritrace.edairy.desktop.reporting.util;

import java.util.Properties;

import org.eclipse.datatools.connectivity.ConnectionProfileException;
import org.eclipse.datatools.connectivity.ProfileManager;
import org.eclipse.datatools.connectivity.db.generic.IDBConnectionProfileConstants;

public class ConnectionProfileInitializer {

	private static class InstanceHolder {
		private static ConnectionProfileInitializer INSTANCE = new ConnectionProfileInitializer();		
	}
	public static ConnectionProfileInitializer getInstance() {
		return InstanceHolder.INSTANCE;
	}

	private ConnectionProfileInitializer() {

	}

	public void doInit() throws ConnectionProfileException {
		ProfileManager profileManager;

		profileManager = ProfileManager.getInstance();
		profileManager.createProfile("eDairy MySQL Data Source", "", "",
				createDefaultProperties());
	}

	private Properties createDefaultProperties() {
		Properties props = new Properties();

		props.put(IDBConnectionProfileConstants.URL_PROP_ID,
				"jdbc:mysql://127.0.0.1:3306/dairytest");
		props.put(IDBConnectionProfileConstants.USERNAME_PROP_ID, "root");
		props.put(IDBConnectionProfileConstants.PASSWORD_PROP_ID, "");
		props.put(IDBConnectionProfileConstants.DATABASE_NAME_PROP_ID,
				"dairytest");
		props.put(IDBConnectionProfileConstants.DEFAULT_SCHEMA_PROP_ID,
				"dairytest");

		return props;
	}

}
