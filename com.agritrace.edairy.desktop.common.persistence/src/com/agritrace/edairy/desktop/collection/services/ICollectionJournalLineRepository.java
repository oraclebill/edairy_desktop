package com.agritrace.edairy.desktop.collection.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

public interface ICollectionJournalLineRepository extends IRepository<CollectionJournalLine> {
	int countByMemberCenterDate(final Membership member, final DairyLocation center, final Date date);
	List<CollectionGroup> allForDate(Date date);
	BigDecimal getMilkPrice(int priceMonth, int priceYear);
	List<Membership> getMembersWithDeliveriesFor(int priceMonth, int priceYear);
	List<CollectionJournalLine> getPayableDeliveriesForMember(Membership member,
			int paymentMonth, int paymentYear);
	BigDecimal getSumOfPayableDeliveries(Membership member, int paymentMonth,
			int paymentYear);
}
