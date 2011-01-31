package com.agritrace.edairy.desktop.common.persistence.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.MilkCollectionJournalLineRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(MilkCollectionJournalLineRepository.class)
public interface ICollectionJournalLineRepository extends
		IRepository<CollectionJournalLine> {
	long countByMemberCenterDate(final Membership member,
			final DairyLocation center, final Date date);

//	List<CollectionGroup> allForDate(Date date);
  
	BigDecimal getMilkPrice(int priceMonth, int priceYear);

	List<Membership> getMembersWithDeliveriesFor(int priceMonth, int priceYear);
	List<CollectionJournalLine> getPayableDeliveriesForMember(Membership member,
			int paymentMonth, int paymentYear);
	BigDecimal getSumOfPayableDeliveries(Membership member, int paymentMonth, int paymentYear);
	Map<Membership, BigDecimal> getMapOfPayableDeliveries(int paymentMonth, int paymentYear);

	List<Object[]> dailyCollectionsSummary(Date day);
	List<Object[]> collectionsSummary(Date startDate, Date endDate);

	List<Membership> getMembersWithFlaggedDeliveriesFor(int month, int year);

	Map<String, Double> collectionStatistics(Date startDate, Date endDate, DairyLocation route,
			CollectionSession session);
}
