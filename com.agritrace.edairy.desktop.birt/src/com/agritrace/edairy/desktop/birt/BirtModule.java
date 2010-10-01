package com.agritrace.edairy.desktop.birt;

import com.agritrace.edairy.desktop.birt.controllers.ReportController;
import com.agritrace.edairy.desktop.birt.data.FarmerPayablesYearDao;
import com.agritrace.edairy.desktop.birt.data.YearReportDao;
import com.google.inject.AbstractModule;

public class BirtModule extends AbstractModule {

	@Override
	protected void configure() {
		requestStaticInjection(FarmerPayablesYearDao.class);
		requestStaticInjection(ReportController.class);
		requestStaticInjection(YearReportDao.class);
	}

}
