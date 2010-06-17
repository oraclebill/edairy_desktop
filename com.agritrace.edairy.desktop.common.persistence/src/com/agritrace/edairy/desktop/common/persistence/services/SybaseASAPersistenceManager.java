package com.agritrace.edairy.desktop.common.persistence.services;

import java.util.Properties;
import java.util.UUID;

import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;

public class SybaseASAPersistenceManager extends PersistenceManager {

	public SybaseASAPersistenceManager() {
		super();
	}

	@Override
	protected Properties getDatastoreProperties() {
		final Properties props = new Properties();

		// mysql
		// props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		// props.setProperty(Environment.USER, "root");
		// props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/" +
		// DB_NAME);
		// //props.setProperty(Environment.PASS, "root");
		// props.setProperty(Environment.DIALECT,
		// "org.hibernate.dialect.MySQLInnoDBDialect");

		// sybase asa
		props.setProperty(Environment.DRIVER, "com.sybase.jdbc3.jdbc.SybDriver");
		props.setProperty(Environment.USER, "dairy");
		props.setProperty(Environment.URL, "jdbc:sybase:Tds:localhost:5000/dairy");
		props.setProperty(Environment.PASS, "dairy");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.SybaseAnywhereDialect");

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