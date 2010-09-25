package com.agritrace.edairy.desktop.finance.payments;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class MemberAccountManager {

	private Date effectiveDate;
	private ITransactionRepository txRepo;

	@Inject
	public MemberAccountManager(ITransactionRepository txRepo, Date effective) {
		this.txRepo = txRepo;
		this.effectiveDate = effective;
	}

	@Inject
	public MemberAccountManager(ITransactionRepository txRepo) {
		this(txRepo, new Date());
	}

	/**
	 * Create a new balance by adding the sum of all unaccounted transactions to
	 * the last balance point.
	 * 
	 * @param account
	 * @param message
	 * @return a newly created balance point
	 */
	public BalancePoint createBalancePoint(Account account, String message) {
		BigDecimal newBalance = getCurrentBalance(account);
		BalancePoint newBalancePoint = AccountFactory.eINSTANCE
				.createBalancePoint();
		newBalancePoint.setAccount(account);
		newBalancePoint.setAmount(newBalance);
		newBalancePoint.setAsOf(effectiveDate);
		// newBalancePoint.setPreviousBalance(latestBalance);

		// RepositoryFactory.getRepository(Transaction.class).save(newBalancePoint);

		return newBalancePoint;
	}

	/**
	 * Add a set of transactions where credits decrease and debits increase the
	 * result.
	 * 
	 * @param transactionList
	 * @return
	 */
	BigDecimal sum(List<Transaction> transactionList) {
		BigDecimal sum = Constants.BIGZERO;
		for (Transaction tx : transactionList) {
			BigDecimal amount = tx.getAmount();
			if (TransactionType.CREDIT.equals(tx.getTransactionType())) {
				sum = sum.subtract(amount);
			} else {
				sum = sum.add(amount);
			}
		}
		return sum;
	}

	BalancePoint getLatestBalancePoint(Account account) {
		List<BalancePoint> balances = account.getBalances();
		BalancePoint lastBalance = null;
		Date newest = new Date(0l);

		for (BalancePoint point : balances) {
			final Date balanceDate = point.getAsOf();
			if (balanceDate.compareTo(newest) > 0) {
				newest = balanceDate;
				lastBalance = point;
			}
		}
		return lastBalance;
	}

	/**
	 * If the account has a debit balance, return it. Otherwise return 0.
	 * 
	 */
	public BigDecimal getCurrentBalance(Account account) {
		Date startDate = new Date(0);
		BigDecimal balance = Constants.BIGZERO;
		BalancePoint point = getLatestBalancePoint(account);

		if (point != null) {
			balance = point.getAmount();
			startDate = point.getAsOf();
		}

		List<Transaction> transactionList = txRepo.accountTransactionsInRange(
				account, startDate, effectiveDate);

		return sum(transactionList).add(balance);
	}

	public void createDebit(Account account, TransactionSource source,
			BigDecimal amount, String desc) {
		createTransaction(account, TransactionType.DEBIT, source, amount, desc);
	}

	public void createCredit(Account account, TransactionSource source,
			BigDecimal amount, String desc) {
		createTransaction(account, TransactionType.CREDIT, source, amount, desc);
	}

	public void createTransaction(Account account, TransactionType type,
			TransactionSource source, BigDecimal amount, String desc) {
		createTransaction(account, getEffectiveDate(), type, source, amount,
				desc);
	}

	public AccountTransaction createTransaction(Account account, Date date,
			TransactionType type, TransactionSource source, BigDecimal amount,
			String desc) {

		if (account == null)
			throw new IllegalArgumentException("Account must not be null.");

		AccountTransaction tx = AccountFactory.eINSTANCE
				.createAccountTransaction();
		tx.setAccount(account);
		tx.setTransactionType(type);
		tx.setSource(source);
		tx.setAmount(amount);
		tx.setTransactionDate(date);
		tx.setDescription(desc);
		account.getTransactions().add(tx);

		txRepo.saveNew(tx);
		return tx;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}
}