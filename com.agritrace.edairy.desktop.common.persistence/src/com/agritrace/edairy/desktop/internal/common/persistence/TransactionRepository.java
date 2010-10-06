package com.agritrace.edairy.desktop.internal.common.persistence;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class TransactionRepository extends HibernateRepository<Transaction>
		implements ITransactionRepository {
	
	@Inject
	protected TransactionRepository(Provider<Session> sessionProvider, @Audit Provider<Session> auditProvider) {
		super(sessionProvider, auditProvider);
	}
	
	@Override
	protected Class<Transaction> getClassType() {
		return Transaction.class;
	}

	@Override
	public List<Transaction> accountTransactionsInRange(final Account account,
			final Date start, final Date end) {
		SessionRunnable<List<Transaction>> runnable = new SessionRunnable<List<Transaction>>() {
			@SuppressWarnings("unchecked")
			@Override
			public void run(Session session) {
				Criteria criteria = session.createCriteria("Transaction");

				criteria.add(Restrictions.eq("account", account));
				criteria.add(Restrictions.between("transactionDate", start, end));
				
				setResult(criteria.list());
			}
		};
		run(runnable);
		return runnable.getResult();
	}

}
