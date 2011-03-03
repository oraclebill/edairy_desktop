package com.agritrace.edairy.desktop.internal.common.persistence;

import java.util.Properties;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.internal.common.persistence.PersistenceModule;
import com.google.inject.Provider;

public class  ManagedMemoryDataStoreProvider implements Provider<HbDataStore> {

	@Override
	public HbDataStore get() {
		final long COUNTER = System.currentTimeMillis();

		final Properties props = new Properties();

		props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		props.setProperty(Environment.USER, "SA");
		props.setProperty(Environment.URL, "jdbc:hsqldb:mem:test"  + COUNTER);
		props.setProperty(Environment.PASS, "");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
		props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "managed");

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "60");

		final HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore("data-store-test" + COUNTER);
		hbds.setProperties(props);
		hbds.setEPackages(PersistenceModule.EPACKAGES);

		hbds.initialize();

		System.err.println(" --> returngin data store : " + hbds );
		System.err.println("     " + hbds.getProperties().get(Environment.URL));
//		Thread.dumpStack();

		return hbds;
	}
}