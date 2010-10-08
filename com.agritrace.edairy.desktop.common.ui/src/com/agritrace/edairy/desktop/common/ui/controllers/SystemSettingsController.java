package com.agritrace.edairy.desktop.common.ui.controllers;

import java.io.IOException;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public final class SystemSettingsController {
	public static final String ENCRYPT_PASSWORDS = "edairy.security.encrypt_passwords";
	@Inject @Named("db")
	private static Provider<IPersistentPreferenceStore> storeProvider;

	private final IPersistentPreferenceStore store;

	public SystemSettingsController() {
		this.store = storeProvider.get();
	}

	public IPreferenceStore loadData() {
		// TODO: Stub
		return store;
	}

	public void saveData() throws IOException {
		store.save();
	}
}
