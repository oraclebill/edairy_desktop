package com.agritrace.edairy.desktop.common.persistence.services;

import java.io.File;
import java.util.Properties;

import org.hibernate.cfg.Environment;

public class HsqlDbDataStoreProvider extends HbDataStoreProvider {
	@Override
	protected Properties getDatastoreProperties() {
		final Properties props = new Properties();

		File dbFile = new File(getDatabaseFileArea(), getDatabaseName());
		
		// in memory hsqldb
		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "SA");
		props.setProperty(Environment.URL, String.format("jdbc:hsqldb:file:%s.db", dbFile));
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");

		// TODO: test this - perhaps JTA or 'managed' is better...
		props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");

		// show all sql
		props.setProperty(Environment.SHOW_SQL, "true");

		// drop and recreate db on startup
		props.setProperty(Environment.HBM2DDL_AUTO, "update");
		return props;
	}
}