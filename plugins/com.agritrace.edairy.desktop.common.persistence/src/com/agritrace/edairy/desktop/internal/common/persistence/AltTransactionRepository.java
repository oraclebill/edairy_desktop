package com.agritrace.edairy.desktop.internal.common.persistence;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountFactory;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.BalancePoint;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionSource;
import com.agritrace.edairy.desktop.common.model.dairy.account.TransactionType;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository.SessionRunnable;
import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("unchecked")
public class AltTransactionRepository extends RepositoryUtil<AccountTransaction> implements ITransactionRepository {

	/**
	 *
	 * @param store
	 */
	@Inject
	public AltTransactionRepository(Provider<Session> provider) {
		super(provider);
	}

	@Override
	public List<AccountTransaction> all() {
		return runQuery("from AccountTransaction");
	}

	@Override
	@Transactional
	public List<AccountTransaction> findAccountTransactions(Account account, Date start, Date end, String refNum, List<TransactionSource> sources) {
		final Session session = getCurrentSession();
		final Criteria criteria = session.createCriteria("Transaction");

		if (account != null) {
			criteria.add(Restrictions.eq("account", account));
		}
		if (start != null) {
			criteria.add(Restrictions.ge("transactionDate", start));
		}
		if (end != null) {
			criteria.add(Restrictions.le("transactionDate", end));
		}

		if (refNum != null) {
			criteria.add(Restrictions.like("referenceNumber", end));
		}

		if (sources != null && sources.size() > 0) {
			criteria.add(Restrictions.in("source", sources));
		}

		return criteria.list();
	}

	@Override
	public List<AccountTransaction> findAccountTransactions(Account account, Date start, Date end)
	{
		return findAccountTransactions(account, start, end, null, null);
	}

	@Transactional
	List<AccountTransaction> runQuery(String q) {
		final Session session = getCurrentSession();
		return session.createQuery(q).list();
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

}
