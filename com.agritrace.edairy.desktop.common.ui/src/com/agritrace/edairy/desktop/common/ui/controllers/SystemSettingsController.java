package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;

public final class SystemSettingsController {
	public static final String ENCRYPT_PASSWORDS = "edairy.security.encrypt_passwords";
	
	public IPreferenceStore loadData() {
		// TODO: Stub
		return new PreferenceStore();
	}
	
	public void saveData() {
		// TODO: Stub
	}
}
