package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.google.inject.Inject;

public class MemberCollectionsManager {
	ICollectionJournalLineRepository repository;
	int priceMonth;
	int priceYear;

	@Inject
	public MemberCollectionsManager(ICollectionJournalLineRepository repo) {
		this.repository = repo;
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

	BigDecimal calculatePayableDeliveries(Membership member, int paymentMonth, int paymentYear) {
		final BigDecimal totalQuantity = repository.getSumOfPayableDeliveries(member, paymentMonth, paymentYear);
		final BigDecimal periodRate = getMilkPriceForPeriod(paymentMonth, paymentYear);
		return periodRate.multiply(totalQuantity, Constants.MONEYCONTEXT);
	}

	BigDecimal calculatePayableDeliveries(Membership member, Date date) {
		final BigDecimal totalQuantity = repository.getSumOfPayableDeliveries(member, date.getMonth(), date.getYear());
		final BigDecimal periodRate = getMilkPriceForPeriod(priceMonth, priceYear);
		return periodRate.multiply(totalQuantity, Constants.MONEYCONTEXT);
	}

	BigDecimal getMilkPriceForPeriod(int priceMonth, int priceYear) {
		return repository.getMilkPrice(priceMonth, priceYear);
	}

	List<Membership> getActiveMembers(int priceMonth, int priceYear) {
		return repository.getMembersWithDeliveriesFor(priceMonth, priceYear);
	}
}