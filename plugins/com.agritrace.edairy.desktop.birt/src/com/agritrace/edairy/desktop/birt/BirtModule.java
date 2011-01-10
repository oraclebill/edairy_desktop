package com.agritrace.edairy.desktop.birt;

import com.agritrace.edairy.desktop.birt.controllers.ReportController;
import com.agritrace.edairy.desktop.birt.data.YearFormatDao;
import com.agritrace.edairy.desktop.birt.data.YearReportDao;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class BirtModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(YearFormatDao.class).in(Scopes.SINGLETON);
		bind(YearReportDao.class).in(Scopes.SINGLETON);
		
		requestStaticInjection(ReportController.class);
		requestStaticInjection(YearReportDao.class);
		requestStaticInjection(YearFormatDao.class);
	}

}
