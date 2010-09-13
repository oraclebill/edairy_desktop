package com.agritrace.edairy.desktop.finance.ui.beans;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.functors.NullIsTruePredicate;
import org.apache.commons.collections.functors.TruePredicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.util.FilterUtil;

public class TestAccountTransactionRepository{

	private IRepository<AccountTransaction> myRepo;
	
	
	static class TransactionMemberEqualPredicate implements Predicate {
		final private Membership testMember;

		TransactionMemberEqualPredicate(Membership testMember) {
			this.testMember = testMember;
		}

		@Override
		public boolean evaluate(Object obj) {
			boolean ret = false;
			if (obj instanceof Transaction) {
				final Transaction tx = (Transaction) obj;
				final Account acct = tx.getAccount();
				if (acct != null) {
					final Membership membership = acct.getMember();
					ret = membership.equals(testMember);
//					LOGGER.log(LogService.LOG_DEBUG, String.format(
//							"comparing: arg('%s') to member('%s') returns: '%s'", membership, testMember, ret));
				}
			} else {
				if (null != obj) {
					throw new IllegalArgumentException("Objects of type: '" + obj.getClass()
							+ "' are not valid for this operation.");
				} else {
					throw new IllegalArgumentException("Invalid predicate parameter - (null).");
				}
			}
			return ret;
		}
	}
	
	public IRepository<AccountTransaction> getRepository(){
		if(myRepo == null){
			myRepo = RepositoryFactory.getRepository(AccountTransaction.class);
		}
		return myRepo;
	}
	
	@Before
	public void setUp() throws Exception {
		getRepository();
	}

	@After
	public void tearDown() throws Exception {
		myRepo = null;
	}
	
	@Test
	public void testHandleBatchEntryAction(){
		final ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
		createBatchAccountTransactions(transactionList);
		
		for (final AccountTransaction tx : transactionList) {
			try{
				getRepository().saveNew(tx);
			}
			catch(Throwable t){
				t.printStackTrace();
				fail("Exception is: "+t);				
			}			
		}
		
	}
	
	private void createBatchAccountTransactions(
			ArrayList<AccountTransaction> transactionList) {
		TestAccountTransactionGenerator tg = new TestAccountTransactionGenerator();
		
		List<AccountTransaction> transactions = tg.createTransactions(300);
		
		transactionList.addAll(transactions);
		
	}

	@Test
	public void testHandleFilterPredicate(){
		final List<AccountTransaction> filtered = new ArrayList<AccountTransaction>();
		final Predicate filterPredicate = buildFilterPredicate();
		try {
			for (final AccountTransaction tx : getRepository().all()) {
				if (filterPredicate.evaluate(tx)) {
					filtered.add(tx);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Predicate buildFilterPredicate() {
		final List<Predicate> predicateList = new ArrayList<Predicate>();
		Predicate returnPredicate;

		Date date;

		date = new Date(System.currentTimeMillis() - 30*24*60*60*1000);
		if (date != null) {
			predicateList.add(NullIsTruePredicate.getInstance(new FilterUtil.DateAfterPredicate(date, AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE.getName())));
		}

		date = new Date(System.currentTimeMillis() - 30*24*60*60*1000);
		if (date != null) {
			predicateList.add(NullIsTruePredicate.getInstance(new FilterUtil.DateBeforePredicate(date, AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE.getName())));
		}

		Membership member = null;
		if (member != null) {
			predicateList.add(NullIsTruePredicate.getInstance(new TransactionMemberEqualPredicate(member)));
		}

		// predicateList.add(NullIsTruePredicate.getInstance(new
		// EqualPredicate(filterBean.getMember())));

		if (predicateList.size() > 0) {
			final Predicate[] predicates = new Predicate[predicateList.size()];
			for (int i = 0; i < predicates.length; i++) {
				predicates[i] = predicateList.get(i);
			}
			returnPredicate = new AllPredicate(predicates);
		} else {
			returnPredicate = TruePredicate.getInstance();
		}

		return returnPredicate;
	}

	

}
