package com.agritrace.edairy.desktop.collection.services;

import java.util.Properties;

import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.internal.common.persistence.HbDataStoreProvider;

public class TestingDataStoreProvider extends HbDataStoreProvider {

	/* (non-Javadoc)
	 * @see com.agritrace.edairy.desktop.internal.common.persistence.HsqlDbDataStoreProvider#getDatastoreProperties()
	 */
	@Override
	protected Properties getDatastoreProperties() {
		final Properties props = super.getDatastoreProperties();

		// memory based hsqldb
		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "SA");
		props.setProperty(Environment.URL, "jdbc:hsqldb:file:test");
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");

		return props;
	}

}
