package com.agritrace.edairy.desktop.operations.services;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.GlobalSettings;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public final class GlobalSettingsRepository {
	private final HibernateRepository<GlobalSettings> internal = new HibernateRepository<GlobalSettings>() {
		@Override
		protected Class<GlobalSettings> getClassType() {
			return GlobalSettings.class;
		}
	};
	
	public GlobalSettings get() {
		GlobalSettings settings = internal.findByKey(1);
		
		if (settings == null) {
			settings = DairyFactory.eINSTANCE.createGlobalSettings();
			settings.setId(1L);
			internal.saveNew(settings);
		}
		
		return settings;
	}
	
	public void save(GlobalSettings settings) {
		internal.save(settings);
	}
}
