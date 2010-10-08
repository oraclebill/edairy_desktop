package com.agritrace.edairy.desktop.birt.data;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;

public class YearReportDao {
	@Inject
	private static YearReportDao instance;

	private final FarmerPayablesYearDao farmerPayablesYearDao;
	private final IDairyRepository dairyRepo;

	@Inject
	public YearReportDao(FarmerPayablesYearDao farmerPayablesYearDao, IDairyRepository dairyRepo) {
		this.farmerPayablesYearDao = farmerPayablesYearDao;
		this.dairyRepo = dairyRepo;
	}

	public static YearReportDao instance(){
		return instance;
	}

	public List<FarmerPayablesYearData> getReportValuesX(String year, String month) {
		return farmerPayablesYearDao.getReportValuesX(year, month);
	}

	public List<YearReportData> getReportValues(String year){
		//TODO apply year!
		final List<CollectionGroup> allJournals = dairyRepo.allCollectionGroups();
		final List<YearReportData> ret = new ArrayList<YearReportData>();

		for(final CollectionGroup page:allJournals){
			if(!checkStatusForListing(page)){
				continue;
			}
			final YearReportData data = new YearReportData(page.getJournalDate(), ""+page.getRecordTotal(), "%"/*TODO!*/);
			ret.add(data);
		}

		// YearReportData data = new YearReportData(new Date(), "12",
		// "%"/*TODO!*/);
//		ret.add(data);
		return ret;
	}

	private boolean checkStatusForListing(CollectionGroup page) {
		if(page == null){
			return false;
		}
		if (page.getStatus() == JournalStatus.SUSPENDED || page.getStatus() == JournalStatus.PENDING) {
			return true;
		}
		return true;
	}
}
