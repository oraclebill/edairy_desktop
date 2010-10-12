package com.agritrace.edairy.desktop.internal.common.persistence;

import org.hibernate.Session;

import com.google.inject.Provider;

public class DataStoreManager {
	private final Provider<Session> sessionProvider;

	public DataStoreManager(Provider<Session> provider) {
		sessionProvider = provider;
	}

	protected Session getCurrentSession() {
		return sessionProvider.get();
	}
}
