package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;

public class MemberCollectionsManager {
	public MemberCollectionsManager() {

	}

	public BigDecimal calculatePayableDeliveries(Membership member,
			int paymentMonth, int paymentYear) {
		throw new UnsupportedOperationException("unimplemented");
	}

	public BigDecimal getMilkPriceForPeriod(int priceMonth, int priceYear) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Membership> getActiveMembers() {
		// identify the members who have delivered milk in this period
		/*
		 * [[ select distinct memberid from collectionjournalline l join
		 * collectiongroup g on g.jounalid = l.xxxxx where year(g.journaldate) =
		 * priceYear and month(g.journaldate) = priceMonth]]
		 */
		return null;
	}
}