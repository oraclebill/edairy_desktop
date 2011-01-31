package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.agritrace.edairy.desktop.common.model.Constants;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.annotations.Transactional;
import com.agritrace.edairy.desktop.common.persistence.dao.IPaymentRecord;
import com.agritrace.edairy.desktop.common.persistence.dao.ITransactionRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.ITransactionRepository.BalanceType;
import com.google.inject.Inject;

/**
 * The member payments processor performs the typical end-of-month accounting
 * process which applies payments owed from dairy to member to each members
 * account. Once this has been completed it is possible to understand how much
 * each member should be paid to clear their balances - these payments are
 * conducted by the bank and we generate a simple report that can be sent to the
 * bank for this purpose. Finally, once these two steps are complete, we can
 * apply a transaction to each members account to move their balance to zero,
 * and prepare for the next months transactions;
 *
 * FULL DESCRIPTION -
 *
 * For each members account we maintain a list of transactions. Each transaction
 * has a type and a source, where type is debit or credit and the source would
 * be store, vet, etc. In our scheme credits reduce the amount payable to the
 * farmer and debits increase it.
 *
 * We also maintain a list of calculated balances. To determine the current
 * value of a members account we start with the most recent calculated balance
 * then add the values of all debit transactions whose entry-dates are more
 * recent than that balance, and subtract the value of all credit transactions
 * after that date. This gives us a 'current' balance.
 *
 * Balances can be calculated at any time, but they are always calculated during
 * the monthly payments process.
 *
 * The payment process determines the amount a farmer is owed, or the amount the
 * farmer owes the dairy, taking into account all of the farmers credit
 * transactions, any cash deposits made by the farmer and the value of the
 * farmers milk deposits (as determined by volume and monthly price).
 * Consequently the member payout cannot be calculated before the monthly milk
 * price has been determined and entered into the system.
 *
 * When the monthly milk price is entered into the system this should trigger
 * the beginning of the monthly payout process. The system will calculate, for
 * each member, the sum of their milk deliveries multiplied by the price. This
 * value will be used to create a debit transaction in the members account.
 * Since the credit transactions are already present, a balance is calculated at
 * this point that represents the end-of-month balance for that account.
 *
 * Once all of the balances have been calculated, it is possible to run the
 * payment report. The payment report generates a list of all members and their
 * balances for members with positive balances. This report can be transmitted
 * to the bank to indicate how much to transfer from the Dairys account to each
 * members personal accounts as payment for that months milk.
 *
 * When the payment report is run, it can be run with the option of clearing
 * positive balances. If this option is selected an additional credit
 * transaction will be created for each members account which will be equal to
 * their positive balance, this transaction will offset the balance bringing it
 * to zero. This transaction will be logged as a payment transaction.
 *
 * The option of clearing the account or reconciling payments may also be an
 * independent option, so that it would not be necessary to run a report to
 * perform it.
 *
 *
 * @author bjones
 */
public class MemberPaymentsProcessor {

	// private MemberAccountManager accountManager;
	private final MemberCollectionsManager collectionsManager;
	private final ITransactionRepository repository;

	/**
	 *
	 */
	@Inject
	public MemberPaymentsProcessor(ITransactionRepository repository, MemberCollectionsManager collectionsManager) {
		// this.accountManager = accountManager;
		this.collectionsManager = collectionsManager;
		this.repository = repository;
	}

	/**
	 *
	 * @param payments
	 * @return
	 */
	public String generatePaymentReport(List<PaymentRecord> payments) {
		return null;
	}

	/**
	 * Using the recorded milk price for a pricing period (year/month) calculate
	 * the amount owed by the dairy to each member and apply a credit for that
	 * amount to their primary account.
	 *
	 * @param priceMonth
	 *            month of the price period
	 * @param priceYear
	 *            year of the price period
	 * @param apply
	 *            if true, apply payments to account.
	 * @return a list of payment records for reporting.
	 */
	@Transactional
	public List<PaymentRecord> generatePaymentsList(BigDecimal paymentRate, int priceMonth, int priceYear) {
		final List<PaymentRecord> paymentList = new LinkedList<PaymentRecord>();
		final List<AccountTransaction> transactions = repository.all();

		final List<Membership> activeMembers = collectionsManager.getActiveMembers(priceMonth, priceYear);
		final Map<Membership, BigDecimal> deliveries = collectionsManager.getMapOfPayableDeliveries(priceMonth, priceYear);
		
		// for each member
		PaymentRecord payment;
		BigDecimal periodRate = collectionsManager.getMilkPriceForPeriod(priceMonth, priceYear);
				
		for (final Membership member : activeMembers) {
			try {
				final BigDecimal totalQuantity = deliveries.get(member);
				final BigDecimal memberDeliveries = totalQuantity == null ?
						Constants.BIGZERO : periodRate.multiply(totalQuantity, Constants.MONEY_CONTEXT);
				
				payment = generatePaymentRecord(paymentRate, priceMonth, priceYear, member, transactions, memberDeliveries);
				
				if (payment.getTotalPayment().compareTo(Constants.BIGZERO) > 0) {
					paymentList.add(payment);
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		return paymentList;
	}

	/**
	 * Add a set of transactions where credits decrease and debits increase the
	 * result.
	 *
	 * @param transactionList
	 * @return
	 */
	private BigDecimal sumTransactions(List<AccountTransaction> transactionList) {
		BigDecimal sum = Constants.BIGZERO;
		
		for (final Transaction tx : transactionList) {
			final BigDecimal amount = tx.getAmount();
			
			if (TransactionType.CREDIT.equals(tx.getTransactionType())) {
				sum = sum.subtract(amount);
			} else {
				sum = sum.add(amount);
			}
		}
		
		return sum;
	}
	
	private List<AccountTransaction> filterTransactions(List<AccountTransaction> transactions, Account primaryAcct,
			Date startDate, Date cutoffDate) {
		List<AccountTransaction> result = new ArrayList<AccountTransaction>();
		
		for (AccountTransaction trans: transactions) {
			if (trans.getAccount() != null && trans.getAccount().getAccountId() == primaryAcct.getAccountId()
					&& trans.getTransactionDate().compareTo(startDate) >= 0
					&& (cutoffDate == null || trans.getTransactionDate().compareTo(cutoffDate) <= 0))
				result.add(trans);
		}
		
		return result;
	}
	
	private BigDecimal calculateBalance(Account primaryAcct, List<AccountTransaction> transactions, Date cutoffDate) {
		Date startDate = new Date(0);
		BigDecimal sum = Constants.BIGZERO;

		final BalancePoint point = repository.findLatestBalancePoint(primaryAcct);
		if (point != null) {
			startDate = point.getAsOf();
			sum = point.getAmount();
		}

		return sum.add(sumTransactions(filterTransactions(transactions, primaryAcct, startDate, cutoffDate)));
	}
	/**
	 * Generate a payment record that can be applied later.
	 *
	 * The payment record contains the results of the 'end of period' member
	 * account reconciliation, where members milk sales are calculated and
	 * applied to their account and a payout determination is made.
	 *
	 * @param priceMonth
	 * @param priceYear
	 * @param paymentList
	 * @param rate
	 * @param member
	 * @return
	 */
	private PaymentRecord generatePaymentRecord(BigDecimal rate, int priceMonth, int priceYear, Membership member,
			List<AccountTransaction> transactions, BigDecimal memberDeliveries) {
		final PaymentRecord paymentRecord = new PaymentRecord(member, priceMonth, priceYear);
		final Account primaryAcct = member.getAccount();

		final Calendar periodStart = repository.createPeriodDate(BalanceType.STARTING, priceMonth, priceYear);
		repository.createPeriodDate(BalanceType.ENDING, priceMonth, priceYear);

		paymentRecord.setStartingBalance(calculateBalance(primaryAcct, transactions, periodStart.getTime()));

		// multiply by price
		if (memberDeliveries.compareTo(Constants.BIGZERO) > 0) {
			paymentRecord.setPayableMilkQuantity(memberDeliveries);
			paymentRecord.setPaymentRate(rate);
			// paymentRecord.setMilkIncome(memberDeliveries.multiply(rate,
			// Constants.MONEY_CONTEXT));
		} else {
			paymentRecord.setPayableMilkQuantity(Constants.BIGZERO);
			paymentRecord.setPaymentRate(Constants.BIGZERO);
			// paymentRecord.setMilkIncome(Constants.BIGZERO);
		}

		paymentRecord.setAccountCredits(calculateBalance(primaryAcct, transactions, null));
		paymentRecord.setAccountAdjustments(Constants.BIGZERO); // TODO: Fix

		return paymentRecord;
	}

	public void processPayment(IPaymentRecord payment) {
		final Account primaryAcct = payment.getMember().getAccount();

		Calendar balanceDate = repository.createPeriodDate(BalanceType.STARTING, payment.getMonth(), payment.getYear());
		repository.createBalancePoint(primaryAcct, balanceDate, payment.getStartingBalance());

		final String debitMessage = String.format("dairy payment for milk received during %s %d: %f kg @  %f ksh/kg",
				Constants.MONTHS[payment.getMonth()], payment.getYear(), payment.getPayableMilkQuantity(),
				payment.getPaymentRate());

		// debit account for value of milk sales
		repository.createDebit(primaryAcct, TransactionSource.CASH_PAYMENT, payment.getMilkIncome(), debitMessage);

		// if member balance is positive, create a transaction to register
		// balance payout.
		if (payment.getTotalPayment().compareTo(Constants.BIGZERO) > 0) {
			repository.createCredit(primaryAcct, TransactionSource.CASH_PAYMENT, payment.getTotalPayment(),
					"transfer to member bank account # XXXX");
		}

		balanceDate = repository.createPeriodDate(BalanceType.ENDING, payment.getMonth(), payment.getYear());
		repository.createBalancePoint(primaryAcct, balanceDate, payment.getTotalPayment());
	}

}
