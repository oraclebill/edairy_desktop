package com.agritrace.edairy.desktop.install.navigation;

import com.agritrace.edairy.desktop.install.handlers.ImportCollectionCentersHandler;
import com.agritrace.edairy.desktop.install.handlers.ImportMemberTransactionHandler;
import com.google.inject.AbstractModule;

public class InstallModule extends AbstractModule {
	@Override
	protected void configure() {
		requestStaticInjection(ImportCollectionCentersHandler.class);
		requestStaticInjection(ImportMemberTransactionHandler.class);
	}
}
