package com.agritrace.edairy.desktop.common.persistence.services;

public class PersistenceService implements IPersistenceService {
	@Override
	public void start() {
		initDatabase();
	}

	private void initDatabase() {
		// FIXME: get config from filesystem
		String dbName = PersistenceManager.DEFAULT_DB_TYPE; // "mysql"
		try {
			dbName = System.getProperty(PersistenceManager.DB_TYPE_PROPERTY, PersistenceManager.DEFAULT_DB_TYPE);
		} catch (Exception e) {
			;
		}

		if (dbName.equals(PersistenceManager.DB_TYPE_HSQLDB)) {
			PersistenceManager.setDefault(new HsqlDbPersistenceManager());
		} else if (dbName.equals(PersistenceManager.DB_TYPE_SYBASE_ASA)) {
			// PersistenceManager.setDefault(new SybaseASAPersistenceManager()
			// );
		} else {
			PersistenceManager.getDefault().getSession();
		}
	}
}
