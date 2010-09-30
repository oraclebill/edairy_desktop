package com.agritrace.edairy.desktop.common.persistence.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.TestPersistenceModule;
import com.google.inject.Guice;

public class DairyRepositoryTest {
	private IMemberRepository repo;
	
	@Before
	public void setUp() {
		repo = Guice.createInjector(new TestPersistenceModule()).getInstance(IMemberRepository.class);
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
