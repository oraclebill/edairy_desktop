package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.persistence.IPaymentRecord;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository.BalanceType;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
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
 *
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

		final List<Membership> activeMembers = collectionsManager.getActiveMembers(priceMonth, priceYear);
		
		// for each member
		PaymentRecord payment;
		
		for (final Membership member : activeMembers) {
			try {
				payment = generatePaymentRecord(paymentRate, priceMonth, priceYear, member);
				
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
	public PaymentRecord generatePaymentRecord(BigDecimal rate, int priceMonth, int priceYear, Membership member) {

		final PaymentRecord paymentRecord = new PaymentRecord(member, priceMonth, priceYear);
		final Account primaryAcct = member.getAccount();

		final Calendar periodStart = repository.createPeriodDate(BalanceType.STARTING, priceMonth, priceYear);
		repository.createPeriodDate(BalanceType.ENDING, priceMonth, priceYear);

		paymentRecord.setStartingBalance(repository.calculateBalance(primaryAcct, periodStart.getTime()));

		// sum total deliveries
		final BigDecimal memberDeliveries = collectionsManager
				.calculatePayableDeliveries(member, priceMonth, priceYear);

		// multiply by price
		if (memberDeliveries.compareTo(Constants.BIGZERO) > 0) {
			paymentRecord.setPayableMilkQuantity(memberDeliveries);
			paymentRecord.setPaymentRate(rate);
			// paymentRecord.setMilkIncome(memberDeliveries.multiply(rate,
			// Constants.MONEYCONTEXT));
		} else {
			paymentRecord.setPayableMilkQuantity(Constants.BIGZERO);
			paymentRecord.setPaymentRate(Constants.BIGZERO);
			// paymentRecord.setMilkIncome(Constants.BIGZERO);
		}

		paymentRecord.setAccountCredits(repository.calculateBalance(primaryAcct));
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
