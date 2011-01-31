package com.agritrace.edairy.desktop.collection.services;

import org.eclipse.emf.teneo.hibernate.HbDataStore;

import com.agritrace.edairy.desktop.common.persistence.IDbPropertiesManager;
import com.agritrace.edairy.desktop.internal.common.persistence.PersistenceModule;

public class TestingPersistenceModule extends PersistenceModule {
	@Override
	protected void bindDataStore() {
		bind(HbDataStore.class).toProvider(TestingDataStoreProvider.class);
		bind(IDbPropertiesManager.class).to(TestingDataStoreProvider.class);
//		bind(HsqlDbDataStoreProvider.class).in(Scopes.SINGLETON);
	}
}
