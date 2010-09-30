package com.agritrace.edairy.desktop.install.navigation;

import com.agritrace.edairy.desktop.install.handlers.ImportCollectionCentersHandler;
import com.agritrace.edairy.desktop.install.handlers.ImportEmployeesHandler;
import com.agritrace.edairy.desktop.install.handlers.ImportMemberTransactionHandler;
import com.agritrace.edairy.desktop.install.handlers.ImportMembersHandler;
import com.agritrace.edairy.desktop.install.handlers.ImportVehiclesHandler;
import com.google.inject.AbstractModule;

public class InstallModule extends AbstractModule {
	@Override
	protected void configure() {
		requestStaticInjection(ImportCollectionCentersHandler.class);
		requestStaticInjection(ImportMemberTransactionHandler.class);
		requestStaticInjection(ImportEmployeesHandler.class);
		requestStaticInjection(ImportMembersHandler.class);
		requestStaticInjection(ImportVehiclesHandler.class);
	}
}
