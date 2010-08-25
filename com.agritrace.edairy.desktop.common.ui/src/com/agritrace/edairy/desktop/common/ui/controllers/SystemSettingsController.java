package com.agritrace.edairy.desktop.common.ui.controllers;

import java.io.IOException;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;

import com.agritrace.edairy.desktop.common.ui.DBPreferenceStore;

public final class SystemSettingsController {
	public static final String ENCRYPT_PASSWORDS = "edairy.security.encrypt_passwords";
	private IPersistentPreferenceStore store;
	
	public IPreferenceStore loadData() {
		// TODO: Stub
		store = new DBPreferenceStore();
		return store;
	}
	
	public void saveData() throws IOException {
		store.save();
	}
}
