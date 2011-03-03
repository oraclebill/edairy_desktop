package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.google.inject.Provider;

public class DairyRepositoryTest {
	private MemberRepository repo;

	@Before
	public void setUp() {
		Provider<Session> sessionProvider = new TestDataSessionProvider();
		IDairyRepository dairyRepo = new DairyRepository(sessionProvider);
		repo = new MemberRepository(sessionProvider, dairyRepo);
	}

	@Test
	public void testEmptyRepo() {
		assertEquals(0, repo.all().size());
	}

	@Test
	public void testAccountForMemberNoQuery() throws Exception {
		System.err.println("RUNNING");
		Account account = repo.findAccountByMemberNo("00022");
		assertNotNull(account);
		account = repo.findAccountByMemberNo("00023");
		// assertNotNull(account);
		account = repo.findAccountByMemberNo("00024");
		// assertNotNull(account);
		account = repo.findAccountByMemberNo("00025");
		assertNotNull(account);
	}

}
