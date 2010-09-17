package com.agritrace.edairy.desktop.common.persistence;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class PersistenceModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Session.class).toProvider(PersistenceManager.class);
		bind(PersistenceManager.class).in(Scopes.SINGLETON);
		
		// Ideally we shouldn't need this...
		requestStaticInjection(PersistenceManager.class);
	}
}
