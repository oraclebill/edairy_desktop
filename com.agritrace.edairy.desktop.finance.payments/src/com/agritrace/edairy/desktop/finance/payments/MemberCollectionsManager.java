package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.List;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;

public class MemberCollectionsManager {
	ICollectionJournalLineRepository repository;
	int priceMonth;
	int priceYear;

	public MemberCollectionsManager(ICollectionJournalLineRepository repo) {
		this.repository = repo;
	}

	public MemberCollectionsManager() {
		this(
				RepositoryFactory
						.getRegisteredRepository(ICollectionJournalLineRepository.class));
	}

	public void setContext(int pMon, int pYear) {
		priceMonth = pMon;
		priceYear = pYear;
	}

	public BigDecimal calculatePayableDeliveries(Membership member) {
		return calculatePayableDeliveries(member, priceMonth, priceYear);
	}

	public BigDecimal getMilkPriceForPeriod() {
		return getMilkPriceForPeriod(priceMonth, priceYear);
	}

	public List<Membership> getActiveMembers() {
		return getActiveMembers(priceMonth, priceYear);
	}

	BigDecimal calculatePayableDeliveries(Membership member, int paymentMonth,
			int paymentYear) {
		BigDecimal totalQuantity = repository.getSumOfPayableDeliveries(member,
				paymentMonth, paymentYear);
		BigDecimal periodRate = getMilkPriceForPeriod(paymentMonth, paymentYear);
		return periodRate.multiply(totalQuantity,
				MemberPaymentsProcessor.MONEYCONTEXT);
	}

	BigDecimal getMilkPriceForPeriod(int priceMonth, int priceYear) {
		return repository.getMilkPrice(priceMonth, priceYear);
	}

	List<Membership> getActiveMembers(int priceMonth, int priceYear) {
		return repository.getMembersWithDeliveriesFor(priceMonth, priceYear);
	}
}