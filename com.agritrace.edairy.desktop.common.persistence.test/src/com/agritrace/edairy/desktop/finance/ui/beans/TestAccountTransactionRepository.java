package com.agritrace.edairy.desktop.finance.ui.beans;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.collection.services.TestingPersistenceModule;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.model.dairy.account.Transaction;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class TestAccountTransactionRepository{
	@Inject
	private IRepository<AccountTransaction> myRepo;
	private List<AccountTransaction> transactionList;
	public static final int BATCH_SIZE = 300;

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
			Guice.createInjector(new TestingPersistenceModule()).injectMembers(this);
		}
		return myRepo;
	}

	@Before
	public void setUp() throws Exception {
		getRepository();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testHandleBatchEntryAction(){
		this.transactionList = new ArrayList<AccountTransaction>();
		createBatchAccountTransactions(transactionList);
		System.err.println("NOTE: created a list of fake account transactions, size="+this.transactionList.size());
		final long start = System.currentTimeMillis();
		//int count = 0;
		for (final AccountTransaction tx : transactionList) {
			try{
				getRepository().saveNew(tx);
				//count++;
				//System.out.println(""+count);
			}
			catch(final Throwable t){
				t.printStackTrace();
				fail("Exception is: "+t);
			}
		}
		System.err.println("batch entries creation completed in "+(System.currentTimeMillis()-start)+"ms.");

	}

	private void createBatchAccountTransactions(
			List<AccountTransaction> transactionList) {
		final TestAccountTransactionGenerator tg = new TestAccountTransactionGenerator();

		final List<AccountTransaction> transactions = tg.createTransactions(BATCH_SIZE);

		transactionList.addAll(transactions);

	}

//	@Test
//	public void testHandleFilterPredicate(){
//		long start = System.currentTimeMillis();
//		final List<AccountTransaction> filtered = new ArrayList<AccountTransaction>();
//		final Predicate filterPredicate = buildFilterPredicate();
//		try {
//			for (final AccountTransaction tx : getRepository().all()) {
//				if (filterPredicate.evaluate(tx)) {
//					filtered.add(tx);
//				}
//			}
//			System.err.println("NOTE: filtering test completed in "+(System.currentTimeMillis()-start)+"ms.");
//			Assert.assertTrue(filtered.size() > 0);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println("NOTE: filtering test FAILED in "+(System.currentTimeMillis()-start)+"ms.");
//			fail("error evaluating the filters on ALL transactional entries");
//		}
//	}

	@Test
	public void testDropBatchEntry(){
		this.transactionList = getRepository().all();
		if(this.transactionList != null){
			final long start = System.currentTimeMillis();
			try{
				int count = BATCH_SIZE;
				for(final AccountTransaction tr:this.transactionList){
					getRepository().delete(tr);
					count--;
					//System.out.println(""+count);
					if(count <= 0){
						break;
					}
				}
			}
			catch(final Throwable t){
				t.printStackTrace();
				fail("faled to drop test account transactions!");
			}
			this.transactionList = null;
			System.err.println("NOTE account transaction batch drop was completed in "+(System.currentTimeMillis()-start)+"ms.");

		}
		else{
			fail("transaction list must not be empty!");
		}
	}


//	private Predicate buildFilterPredicate() {
//		final List<Predicate> predicateList = new ArrayList<Predicate>();
//		Predicate returnPredicate;
//
//		Date date;
//
//		date = new Date(System.currentTimeMillis() + 30*24*60*60*1000);
//		if (date != null) {
//			predicateList.add(NullIsTruePredicate.getInstance(new FilterUtil.DateAfterPredicate(date, AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE.getName())));
//		}
//
//		date = new Date(System.currentTimeMillis() - 30*24*60*60*1000);
//		if (date != null) {
//			predicateList.add(NullIsTruePredicate.getInstance(new FilterUtil.DateBeforePredicate(date, AccountPackage.Literals.TRANSACTION__TRANSACTION_DATE.getName())));
//		}
//
//		Membership member = null;
//		if (member != null) {
//			predicateList.add(NullIsTruePredicate.getInstance(new TransactionMemberEqualPredicate(member)));
//		}
//
//		// predicateList.add(NullIsTruePredicate.getInstance(new
//		// EqualPredicate(filterBean.getMember())));
//
//		if (predicateList.size() > 0) {
//			final Predicate[] predicates = new Predicate[predicateList.size()];
//			for (int i = 0; i < predicates.length; i++) {
//				predicates[i] = predicateList.get(i);
//			}
//			returnPredicate = new AllPredicate(predicates);
//		} else {
//			returnPredicate = TruePredicate.getInstance();
//		}
//
//		return returnPredicate;
//	}



}
