package com.agritrace.edairy.desktop.home;

import com.agritrace.edairy.desktop.home.views.DairyHomeView;
import com.google.inject.AbstractModule;

public class HomeModule extends AbstractModule {
	@Override
	protected void configure() {
		requestStaticInjection(DairyHomeView.class);
	}
}
