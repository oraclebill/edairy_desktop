package com.agritrace.edairy.desktop.internal.common.persistence;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.google.inject.Inject;

@SuppressWarnings("unchecked")
public class AltTransactionRepository extends RepositoryUtil<Transaction> implements ITransactionRepository {

	/**
	 * 
	 * @param store
	 */
	@Inject
	public AltTransactionRepository(HbDataStore store) {
		super(store);
	}

	@Override
	public List<Transaction> all() {
		return runQuery("from Transaction");
	}

	@Override
	public List<Transaction> findAccountTransactions(Account account, Date start, Date end) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria("Transaction");

		if (account != null) {
			criteria.add(Restrictions.eq("account", account));
		}
		if (start != null) {
			criteria.add(Restrictions.ge("transactionDate", start));
		}
		if (end != null) {
			criteria.add(Restrictions.le("transactionDate", end));
		}

		return (List<Transaction>) criteria.list();
	}

	private List<Transaction> runQuery(String q) {
		Session session = getCurrentSession();
		return (List<Transaction>) session.createQuery(q).list();
	}

	/**
	 * 
	 * 
	 * @param account
	 * @param balanceDate
	 * @param amount
	 * @return
	 * @throws IllegalStateException
	 */
	@Override
	public BalancePoint createBalancePoint(final Account account, Calendar balanceDate, BigDecimal amount)
			throws IllegalStateException {
		BalancePoint latest = AccountFactory.eINSTANCE.createBalancePoint();

		latest.setAsOf(balanceDate.getTime());
		latest.setAccount(account);
		latest.setAmount(amount);

		save(latest);

		return latest;
	}

	/**
	 * Create a Calendar-type date based on the payment period.
	 * 
	 * @param type
	 * @param year
	 * @param month
	 * @return
	 */
	@Override
	public Calendar createPeriodDate(BalanceType type, int year, int month) {
		// initialize balance date
		Calendar balanceDate = Calendar.getInstance();
		balanceDate.clear();
		balanceDate.set(Calendar.YEAR, year);
		balanceDate.set(Calendar.MONTH, month);

		// floor or ceil the date, as appropriate for the type of balancepoint
		List<Integer> timeFields = Arrays.asList(Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.MINUTE,
				Calendar.SECOND, Calendar.MILLISECOND);
		for (int field : timeFields) {
			if (type.equals(BalanceType.STARTING)) {
				balanceDate.set(field, balanceDate.getMinimum(field));
			} else {
				balanceDate.set(field, balanceDate.getMaximum(field));
			}
		}
		return balanceDate;
	}

	/**
	 * Find the latest balance point, by date, for the specified account
	 * 
	 * @param account
	 * @return
	 */
	@Override
	public BalancePoint findLatestBalancePoint(final Account account) {
		return findLatestBalancePoint(account, new Date());
	}

	@Override
	public BigDecimal calculateBalance(Account primaryAcct) {
		return calculateBalance(primaryAcct, new Date());
	}

	@Override
	public BigDecimal calculateBalance(Account primaryAcct, Date cutoffDate) {
		Date startDate = new Date(0);
		BigDecimal sum = Constants.BIGZERO;

		BalancePoint point = findLatestBalancePoint(primaryAcct);
		if (point != null) {
			startDate = point.getAsOf();
			sum = point.getAmount();
		}

		List<Transaction> transactions = findAccountTransactions(primaryAcct, startDate, cutoffDate);
		return sum.add(sumTransactions(transactions));
	}

	@Override
	public AccountTransaction createDebit(Account account, TransactionSource source, BigDecimal amount, String desc) {
		return createTransaction(account, TransactionType.DEBIT, source, amount, desc);
	}

	@Override
	public AccountTransaction createCredit(Account account, TransactionSource source, BigDecimal amount, String desc) {
		return createTransaction(account, TransactionType.CREDIT, source, amount, desc);
	}

	/**
	 * Find the latest balance point, before date, for the specified account
	 * 
	 * @param account
	 * @return
	 */
	private BalancePoint findLatestBalancePoint(final Account account, Date cutoff) {
		List<BalancePoint> balances = account.getBalances();
		BalancePoint lastBalance = null;
		Date newest = new Date(0l);

		for (BalancePoint point : balances) {
			final Date balanceDate = point.getAsOf();
			if (balanceDate.after(newest) && balanceDate.before(cutoff)) {
				newest = balanceDate;
				lastBalance = point;
			}
		}
		return lastBalance;
	}

	/**
	 * Add a set of transactions where credits decrease and debits increase the
	 * result.
	 * 
	 * @param transactionList
	 * @return
	 */
	private BigDecimal sumTransactions(List<Transaction> transactionList) {
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

	/**
	 * 
	 * @param account
	 * @param type
	 * @param source
	 * @param amount
	 * @param desc
	 * @return
	 */
	private AccountTransaction createTransaction(Account account, TransactionType type, TransactionSource source,
			BigDecimal amount, String desc) {
		return createTransaction(account, new Date(), type, source, amount, desc);
	}

	/**
	 * 
	 * @param account
	 * @param date
	 * @param type
	 * @param source
	 * @param amount
	 * @param desc
	 * @return
	 */
	private AccountTransaction createTransaction(Account account, Date date, TransactionType type,
			TransactionSource source, BigDecimal amount, String desc) {

		if (account == null)
			throw new IllegalArgumentException("Account must not be null.");

		AccountTransaction tx = AccountFactory.eINSTANCE.createAccountTransaction();
		tx.setAccount(account);
		tx.setTransactionType(type);
		tx.setSource(source);
		tx.setAmount(amount);
		tx.setTransactionDate(date);
		tx.setDescription(desc);
		account.getTransactions().add(tx);

		save(tx);

		return tx;
	}
}
