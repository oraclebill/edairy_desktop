package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.agritrace.edairy.desktop.common.model.dairy.GlobalSettings;
import com.agritrace.edairy.desktop.operations.services.GlobalSettingsRepository;

public final class SystemSettingsController {
	private Button encryptUserPasswords;
	private GlobalSettingsRepository repository;
	
	public SystemSettingsController() {
		repository = new GlobalSettingsRepository();
	}
	
	public void addControls(Composite area) {
		encryptUserPasswords = new Button(area, SWT.CHECK);
		encryptUserPasswords.setText("Encrypt user passwords");
		GridDataFactory.swtDefaults().span(2, 1).applyTo(encryptUserPasswords);
	}
	
	public void loadData() {
		GlobalSettings settings = repository.get();
		encryptUserPasswords.setSelection(settings.isPasswordsEncrypted());
	}
	
	public void saveData() {
		GlobalSettings settings = repository.get();
		settings.setPasswordsEncrypted(encryptUserPasswords.getSelection());
		repository.save(settings);
	}
}
