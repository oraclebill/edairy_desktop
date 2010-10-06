package com.agritrace.edairy.desktop.collection.services;

import org.eclipse.emf.teneo.hibernate.HbDataStore;

import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.common.persistence.services.IDbPropertiesManager;
import com.agritrace.edairy.desktop.internal.common.persistence.HsqlDbDataStoreProvider;
import com.google.inject.Scopes;

public class TestPersistenceModule extends PersistenceModule {
	@Override
	protected void bindDataStore() {
		bind(HbDataStore.class).toProvider(TestDataStoreProvider.class);
		bind(IDbPropertiesManager.class).to(TestDataStoreProvider.class);
//		bind(HsqlDbDataStoreProvider.class).in(Scopes.SINGLETON);
	}
}
