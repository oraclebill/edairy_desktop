package com.agritrace.edairy.desktop.birt.data;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.google.inject.Inject;

/**
 * class to collect the data needed for the report and to place it into special
 * beans for report presentation.
 *
 * @author rsw
 *
 */
public class FarmerPayablesYearDao {
	private static final MathContext MONEY_CONTEXT = new MathContext(2, RoundingMode.HALF_DOWN);
	private static final BigDecimal ZERO = new BigDecimal(0, MONEY_CONTEXT);

	private final DecimalFormat floatFormater = new DecimalFormat("#,#00.0#;(#,#00.0#)");
	private final ICollectionJournalLineRepository collectionsRepo;
	private final ITransactionRepository transactionRepo;

	@Inject
	public FarmerPayablesYearDao(final ICollectionJournalLineRepository collectionsRepo,
			final ITransactionRepository transactionRepo) {
		this.collectionsRepo = collectionsRepo;
		this.transactionRepo = transactionRepo;
	}

	public List<FarmerPayablesYearData> getReportValues(String year, String month) {

//		ICollectionJournalLineRepository collectionsRepo = RepositoryFactory
//				.getRegisteredRepository(ICollectionJournalLineRepository.class);
		final List<FarmerPayablesYearData> ret = new ArrayList<FarmerPayablesYearData>();

		for (final Membership membership : collectionsRepo.getMembersWithDeliveriesFor(Integer.parseInt(month), Integer
				.parseInt(year))) {
			final Farmer farmer = membership.getMember();

			// Income = (Total quantity of milk collected - quantity of rejected
			// milk) * Posted Milk Price for that month
			final float income = 34588;// TODO implement!

			// Credits = 0 - (Sum of all credits attributed to member for
			// current month)
			final float credits = -34;

			// Adjustments = Sum of all adjustments (debit adds and credit
			// subtracts)
			final float adjustments = 0;

			// Payables = Sum of Income, credits and adjustments
			final float payables = 1;

			final String name = farmer.getGivenName();
			final String memberNumber = membership.getMemberNumber();
			final String accountNumber = membership.getAccount().getAccountNumber();

			FarmerPayablesYearData data = new FarmerPayablesYearData(name, memberNumber, accountNumber,
					this.floatFormater.format(income), this.floatFormater.format(credits), this.floatFormater
							.format(adjustments), this.floatFormater.format(payables));
			ret.add(data);
		}

		return ret;
	}

	public List<FarmerPayablesYearData> getReportValuesX(String year, String month) {
		try {
	//		ICollectionJournalLineRepository collectionsRepo = RepositoryFactory
	//				.getRegisteredRepository(ICollectionJournalLineRepository.class);
			final List<FarmerPayablesYearData> ret = new ArrayList<FarmerPayablesYearData>();
	
			for (Membership membership : collectionsRepo.getMembersWithDeliveriesFor(Integer.parseInt(month), Integer
					.parseInt(year))) {
				Farmer farmer = membership.getMember();
	
				// Income = (Total quantity of milk collected - quantity of rejected
				// milk) * Posted Milk Price for that month
				final BigDecimal income = calculateMemberMonthlyIncome(membership, month,
						year);
	
				// Credits = 0 - (Sum of all credits attributed to member for
				// current month)
				final BigDecimal[] creditsAndAdjustments = calculateMemberMonthlyCreditsAndAdjustments(
						membership, month, year);
	
				if (income.equals(ZERO) && creditsAndAdjustments[0].equals(ZERO)
						&& creditsAndAdjustments[1].equals(ZERO)) {
					continue;
				}
	
				// Payables = Sum of Income, credits and adjustments
				final BigDecimal payables = income.add(creditsAndAdjustments[0]).add(
						creditsAndAdjustments[1]);
	
				final String name = farmer.getGivenName();
				final String memberNumber = membership.getMemberNumber();
				final String accountNumber = membership.getAccount().getAccountNumber();
	
				final FarmerPayablesYearData data = new FarmerPayablesYearData(name,
						memberNumber, accountNumber,
						this.floatFormater.format(income),
						this.floatFormater.format(creditsAndAdjustments[0]),
						this.floatFormater.format(creditsAndAdjustments[1]),
						this.floatFormater.format(payables));
				ret.add(data);
			}
	
			return ret;
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private BigDecimal calculateMemberMonthlyIncome(
			final Membership membership, final String month, final String year) {
//		final ICollectionJournalLineRepository collectionsRepo = RepositoryFactory
//				.getRegisteredRepository(ICollectionJournalLineRepository.class);
		final int priceMonth = Integer.parseInt(month), priceYear = Integer
				.parseInt(year);
		final BigDecimal memberCollections = collectionsRepo
				.getSumOfPayableDeliveries(membership, priceMonth, priceYear);
		BigDecimal paymentRate = collectionsRepo.getMilkPrice(priceMonth, priceYear);

		if(paymentRate == null){
			paymentRate = new BigDecimal("0");
		}

		return paymentRate.multiply(memberCollections, MONEY_CONTEXT);
	}

	private BigDecimal[] calculateMemberMonthlyCreditsAndAdjustments(Membership membership, String month, String year) {
//		ITransactionRepository transactionRepo = RepositoryFactory
//				.getRegisteredRepository(ITransactionRepository.class);
		final int priceMonth = Integer.parseInt(month), priceYear = Integer.parseInt(year);
		Calendar startDate = Calendar.getInstance(), endDate = Calendar.getInstance();

		startDate.set(Calendar.MONTH, priceMonth);
		startDate.set(Calendar.YEAR, priceYear);
		startDate.set(Calendar.DAY_OF_MONTH, startDate.getActualMinimum(Calendar.DAY_OF_MONTH));

		endDate.set(Calendar.MONTH, priceMonth);
		endDate.set(Calendar.YEAR, priceYear);
		startDate.set(Calendar.DAY_OF_MONTH, startDate.getActualMaximum(Calendar.DAY_OF_MONTH));

		final List<Transaction> transactions = transactionRepo
				.findAccountTransactions(membership.getAccount(),
						startDate.getTime(), endDate.getTime());
		BigDecimal credits = ZERO, adjustments = ZERO;
		for (final Transaction tx : transactions) {
			BigDecimal amt = tx.getAmount();
			if (tx.getTransactionType().equals(TransactionType.CREDIT)) {
				amt = ZERO.subtract(amt);
			}
			if (tx instanceof AccountTransaction) {
				credits = credits.add(amt);
			} else {
				adjustments = adjustments.add(amt);
			}
		}
		return new BigDecimal[] { credits, adjustments };
	}

}
