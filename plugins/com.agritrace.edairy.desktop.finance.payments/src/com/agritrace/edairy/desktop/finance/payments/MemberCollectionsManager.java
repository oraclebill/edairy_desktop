package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.google.inject.Inject;

public class MemberCollectionsManager {
	private ICollectionJournalLineRepository repository;
	private ITransactionRepository transactionRepo;
	private int priceMonth;
	private int priceYear;

	@Inject
	public MemberCollectionsManager(ICollectionJournalLineRepository repo, ITransactionRepository transactionRepo) {
		this.repository = repo;
		this.transactionRepo = transactionRepo;
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

	public List<Membership> getActiveMembers(int priceMonth, int priceYear) {
		Date startDate, endDate;
		final Calendar cal = Calendar.getInstance();

		cal.clear();
		cal.set(Calendar.YEAR, priceYear);
		cal.set(Calendar.MONTH, priceMonth);

		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		startDate = cal.getTime();

		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		endDate = cal.getTime();

		// A member is "active" if there are either milk sales or credit sales for that month
		final Set<Membership> members = new HashSet<Membership>(repository.getMembersWithDeliveriesFor(priceMonth, priceYear));
		final List<AccountTransaction> transactions = transactionRepo.findAccountTransactions(null, startDate, endDate);
		
		for (final Transaction transaction: transactions) {
			final Membership member = transaction.getAccount().getMember();
			
			if (transaction.getTransactionType() == TransactionType.CREDIT && member != null) {
				members.add(member);
			}
		}
		
		return new ArrayList<Membership>(members);
	}
}