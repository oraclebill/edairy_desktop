package com.agritrace.edairy.desktop.common.persistence;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Interceptor;

import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.agritrace.edairy.desktop.common.persistence.services.IDbPropertiesManager;
import com.agritrace.edairy.desktop.internal.common.persistence.HsqlDbDataStoreProvider;
import com.google.inject.Scopes;

public class TestPersistenceModule extends PersistenceModule {
	@Override
	protected void bindDataStore() {
		bind(HbDataStore.class).toProvider(HsqlDbDataStoreProvider.class);
		bind(IDbPropertiesManager.class).to(HsqlDbDataStoreProvider.class);
		bind(HsqlDbDataStoreProvider.class).in(Scopes.SINGLETON);
		bind(Interceptor.class).annotatedWith(Audit.class).to(EmptyInterceptor.class);
	}
}
