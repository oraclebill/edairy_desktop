package com.agritrace.edairy.desktop.internal.common.persistence;

import java.util.Properties;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.cfg.Environment;

import com.agritrace.edairy.desktop.common.model.audit.AuditPackage;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AuditDataStoreProvider implements Provider<HbDataStore> {
	private static final String AUDIT_DB_HOST = "127.0.0.1:3306";
	private static final String AUDIT_DB_NAME = "dairytest_audit";
	
	private HbDataStore hbds;
	
	@Inject
	public AuditDataStoreProvider() {
		hbds = HbHelper.INSTANCE.createRegisterDataStore(AUDIT_DB_NAME);
		hbds.setProperties(getDatastoreProperties());
		hbds.setEPackages(new EPackage[] { AuditPackage.eINSTANCE });

		hbds.initialize();
	}
	
	@Override
	public HbDataStore get() {
		return hbds;
	}

	private Properties getDatastoreProperties() {
		final Properties props = new Properties();

		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.URL, "jdbc:mysql://" + AUDIT_DB_HOST + "/" + AUDIT_DB_NAME);
		props.setProperty(Environment.USER, "root");
		// props.setProperty(Environment.PASS, "root");
		props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLInnoDBDialect");
		props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

		props.setProperty("teneo.mapping.disable_econtainer", "true");
		props.setProperty("teneo.mapping.default_varchar_length", "255");
		return props;
	}
	
}
