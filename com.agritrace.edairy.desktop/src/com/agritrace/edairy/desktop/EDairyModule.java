package com.agritrace.edairy.desktop;

import org.ops4j.peaberry.Peaberry;
import org.ops4j.peaberry.eclipse.EclipseRegistry;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.google.inject.AbstractModule;

public class EDairyModule extends AbstractModule {
	private BundleContext context;
	
	public EDairyModule(BundleContext context) {
		this.context = context;
	}

	@Override
	protected void configure() {
		install(Peaberry.osgiModule(context, EclipseRegistry.eclipseRegistry()));
		install(new PersistenceModule());
	}
}
