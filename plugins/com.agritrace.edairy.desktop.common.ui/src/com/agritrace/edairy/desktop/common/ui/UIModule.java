package com.agritrace.edairy.desktop.common.ui;

import org.eclipse.jface.preference.IPersistentPreferenceStore;

import com.agritrace.edairy.desktop.common.ui.controllers.SystemSettingsController;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class UIModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(IPersistentPreferenceStore.class).annotatedWith(Names.named("db")).to(DBPreferenceStore.class);
		requestStaticInjection(SystemSettingsController.class);
	}
}
