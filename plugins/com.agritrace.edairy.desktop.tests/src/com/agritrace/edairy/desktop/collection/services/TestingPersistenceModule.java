package com.agritrace.edairy.desktop.collection.services;

import org.eclipse.emf.teneo.hibernate.HbDataStore;

import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.common.persistence.services.IDbPropertiesManager;

public class TestingPersistenceModule extends PersistenceModule {
	@Override
	protected void bindDataStore() {
		bind(HbDataStore.class).toProvider(TestingDataStoreProvider.class);
		bind(IDbPropertiesManager.class).to(TestingDataStoreProvider.class);
//		bind(HsqlDbDataStoreProvider.class).in(Scopes.SINGLETON);
	}
}
