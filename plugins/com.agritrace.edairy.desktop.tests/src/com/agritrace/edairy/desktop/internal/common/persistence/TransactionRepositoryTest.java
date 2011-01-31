package com.agritrace.edairy.desktop.internal.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.collection.services.TestingPersistenceModule;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountTransaction;
import com.agritrace.edairy.desktop.common.persistence.dao.ITransactionRepository;
import com.google.inject.Guice;

public class TransactionRepositoryTest  extends TransactionTestCase {

	ITransactionRepository repo;

	@Before
	public void setUp() {
		repo = Guice.createInjector(new TestingPersistenceModule()).getInstance(ITransactionRepository.class);
	}

	@Test
	public void testAccountTransactionsInRange() throws Exception {
		List<AccountTransaction> transactions;

		assertTrue(repo.all().size() > 10);

		final Account testAccount = getAccount("04632");
		Date start, end;
		start = TX_FORMAT.parse("01.06.2010");
		end = TX_FORMAT.parse("15.06.2010");

		transactions = repo.findAccountTransactions(testAccount, start, end);
		assertEquals(2, transactions.size());

		start = TX_FORMAT.parse("15.06.2010");
		end = TX_FORMAT.parse("30.06.2010");

		transactions = repo.findAccountTransactions(testAccount, start, end);
		assertEquals(2, transactions.size());

	}

}
