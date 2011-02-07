package com.agritrace.edairy.desktop.birt.data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.JournalStatus;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.finance.payments.MemberPaymentsProcessor;
import com.agritrace.edairy.desktop.finance.payments.PaymentRecord;
import com.google.inject.Inject;

public class YearReportDao {
	@Inject
	private static YearReportDao INSTANCE;

	private final IDairyRepository dairyRepo;
	private final MemberPaymentsProcessor processor;

	@Inject
	public YearReportDao(IDairyRepository dairyRepo, MemberPaymentsProcessor processor) {
		this.dairyRepo = dairyRepo;
		this.processor = processor;
	}

	public static YearReportDao instance() {
		return INSTANCE;
	}

	public List<FarmerPayablesYearData> getReportValuesX(String year, String month) {
		// List<FarmerPayablesYearData> data = farmerPayablesYearDao.getReportValuesX(year, month);
		final List<FarmerPayablesYearData> result = new ArrayList<FarmerPayablesYearData>();
		final int priceMonth = Integer.parseInt(month), priceYear = Integer.parseInt(year);
		final List<PaymentRecord> paymentRecords = processor.generatePaymentsList(new BigDecimal(1),
				priceMonth - 1, priceYear);
		
		for (PaymentRecord rec: paymentRecords) {
			final Membership member = rec.getMember();
			
			FarmerPayablesYearData data = new FarmerPayablesYearData(member.getFarmer().getGivenName(),
					member.getMemberNumber(), member.getAccount().getAccountNumber(), rec.getMilkIncome().toString(),
					rec.getAccountCredits().toString(), rec.getAccountAdjustments().toString(),
					rec.getTotalPayment().toString());
			
			result.add(data);
		}
		
		return result;
	}

	public List<YearReportData> getReportValues(String year, String month) {
		final int priceMonth = Integer.parseInt(month), priceYear = Integer.parseInt(year);
		Calendar startDate = new GregorianCalendar(priceYear, priceMonth - 1, 1);
		Calendar endDate = Calendar.getInstance();

		endDate.setTime(startDate.getTime());
		endDate.add(Calendar.MONTH, 1);
		
		final List<CollectionGroup> allJournals = dairyRepo.getCollectionGroups(startDate.getTime(), endDate.getTime());
		final List<YearReportData> ret = new ArrayList<YearReportData>();

		for (final CollectionGroup page : allJournals) {
			if (!checkStatusForListing(page)) {
				continue;
			}
			final YearReportData data = new YearReportData(page.getJournalDate(), "" + page.getRecordTotal(), "%"/*
																												 * TODO!
																												 */);
			ret.add(data);
		}

		// YearReportData data = new YearReportData(new Date(), "12",
		// "%"/*TODO!*/);
		// ret.add(data);
		return ret;
	}

	private boolean checkStatusForListing(CollectionGroup page) {
		if (page == null) {
			return false;
		}
		if (page.getStatus() == JournalStatus.SUSPENDED || page.getStatus() == JournalStatus.PENDING) {
			return true;
		}
		return true;
	}
}
