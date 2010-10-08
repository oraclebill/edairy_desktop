package com.agritrace.ediary.desktop.reports.data;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class YearReportDao {


	private static YearReportDao instance;

	IDairyRepository dairyRepo;

	public YearReportDao(){
		super();
	}

	public static YearReportDao instance(){
		if(instance == null){
			instance = new YearReportDao();
		}
		return instance;
	}

	public List<YearReportData> getReportValues(String year){
		//TODO apply year!
//		List<CollectionGroup> allJournals = RepositoryFactory.getDairyRepository().allCollectionGroups();
		final List<CollectionGroup> allJournals = dairyRepo.allCollectionGroups();
		final List<YearReportData> ret = new ArrayList<YearReportData>();

		for(final CollectionGroup page:allJournals){
			if(!checkStatusForListing(page)){
				continue;
			}
			final YearReportData data = new YearReportData(page.getJournalDate(), ""+page.getRecordTotal(), "%"/*TODO!*/);
			ret.add(data);
		}

//		YearReportData data = new YearReportData(new Date(), "12", "%"/*TODO!*/);
//		ret.add(data);
		return ret;
	}

	private boolean checkStatusForListing(CollectionGroup page) {
		if(page == null){
			return false;
		}
		if(page.getStatus() == JournalStatus.SUSPENDED
				|| page.getStatus() == JournalStatus.PENDING){
			return true;
		}
		return true;
	}
}
