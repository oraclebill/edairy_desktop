package com.agritrace.edairy.desktop.internal.common.persistence;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.IPaymentRecord;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class TransactionRepository extends HibernateRepository<AccountTransaction> implements ITransactionRepository {

	@Inject
	protected TransactionRepository(Provider<Session> sessionProvider) {
		super(sessionProvider);
	}

	@Override
	protected Class<AccountTransaction> getClassType() {
		return AccountTransaction.class;
	}
	
	@Override
	public List<AccountTransaction> findAccountTransactions(final Account account,
			final Date start, final Date end, final String refNum, final List<TransactionSource> sources) {
		final SessionRunnable<List<AccountTransaction>> runnable = new SessionRunnable<List<AccountTransaction>>() {
			@SuppressWarnings("unchecked")
			@Override
			public void run(Session session) {
				final Criteria criteria = session.createCriteria("AccountTransaction");
				// filter out erroneous data..
				criteria.add(Restrictions.isNotNull("account"));

				if (account != null) {
					criteria.add(Restrictions.eq("account", account));
				}
				if (start != null) {
					criteria.add(Restrictions.ge("transactionDate", start));
				}
				if (end != null) {
					criteria.add(Restrictions.le("transactionDate", end));
				}
				if (refNum != null && !refNum.trim().isEmpty()) {
					criteria.add(Restrictions.like("referenceNumber", refNum));
				}
				if (sources != null && sources.size() > 0 ) {
					criteria.add(Restrictions.in("source", sources));
				}
				setResult(criteria.list());
			}
		};
		run(runnable);
		return runnable.getResult();
	}


	@Override
	public List<AccountTransaction> findAccountTransactions(final Account account, final Date start, final Date end) {
		return findAccountTransactions(account, start, end, null, null);
	}

//	/**
//	 * Create a balance point as of specified date.
//	 *
//	 *
//	 * @param account
//	 * @param type
//	 *            the balance type determines if we use start-of-day or
//	 *            end-of-day 'date' semantic
//	 * @param date
//	 *            the date at which the balance should be calculated.
//	 * @return a new BalancePoint
//	 * @throws IllegalStateException
//	 *             if there is an existing balance point after the requested
//	 *             time.
//	 */
//	BalancePoint createBalancePoint(final Account account, Calendar balanceDate, String message)
//			throws IllegalStateException {
//		BalancePoint previous = findLatestBalancePoint(account);
//
//		BigDecimal previousValue;
//		Calendar previousTime = Calendar.getInstance();
//
//		// there may not be an initial point, so handle null
//		if (previous != null) {
//			previousTime.setTime(previous.getAsOf());
//			previousValue = previous.getAmount();
//		} else {
//			previousTime.clear();
//			previousValue = Constants.BIGZERO;
//		}
//
//		// make sure we aren't creating a balance in a previously balanced range
//		if (balanceDate.before(previousTime)) {
//			throw new IllegalStateException("Attempt to create a balance (" + balanceDate + ") prior to latest: "
//					+ previousTime);
//		}
//
//		// create the new balance point
//		BalancePoint latest = AccountFactory.eINSTANCE.createBalancePoint();
//
//		latest.setAccount(account);
//		latest.setAsOf(balanceDate.getTime());
//		List<AccountTransaction> intermediate = findAccountTransactionsInRange(account, previousTime.getTime(),
//				latest.getAsOf());
//
//		// amount is sum of previous
//		latest.setAmount(previousValue.add(sumTransactions(intermediate)));
//
//		return createBalancePoint(account, balanceDate, previousValue.add(sumTransactions(intermediate)));
//	}

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
		final BalancePoint latest = AccountFactory.eINSTANCE.createBalancePoint();

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
		final Calendar balanceDate = Calendar.getInstance();
		balanceDate.clear();
		balanceDate.set(Calendar.YEAR, year);
		balanceDate.set(Calendar.MONTH, month);

		// floor or ceil the date, as appropriate for the type of balancepoint
		final List<Integer> timeFields = Arrays.asList(Calendar.DAY_OF_MONTH, Calendar.HOUR, Calendar.MINUTE,
				Calendar.SECOND, Calendar.MILLISECOND);
		for (final int field : timeFields) {
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

		final BalancePoint point = findLatestBalancePoint(primaryAcct);
		if (point != null) {
			startDate = point.getAsOf();
			sum = point.getAmount();
		}

		final List<AccountTransaction> transactions = findAccountTransactions(primaryAcct, startDate, cutoffDate);
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
		final List<BalancePoint> balances = account.getBalances();
		BalancePoint lastBalance = null;
		Date newest = new Date(0l);

		for (final BalancePoint point : balances) {
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

	private AccountTransaction createTransaction(Account account, TransactionType type, TransactionSource source, BigDecimal amount,
			String desc) {
		return createTransaction(account, new Date(), type, source, amount, desc);
	}

	private AccountTransaction createTransaction(Account account, Date date, TransactionType type,
			TransactionSource source, BigDecimal amount, String desc) {

		if (account == null) {
			throw new IllegalArgumentException("Account must not be null.");
		}

		final AccountTransaction tx = AccountFactory.eINSTANCE.createAccountTransaction();
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

	@Override
	public List<IPaymentRecord> findPayments(Membership member, int year) {
		// TODO Auto-generated method stub
		return null;
	}

}
