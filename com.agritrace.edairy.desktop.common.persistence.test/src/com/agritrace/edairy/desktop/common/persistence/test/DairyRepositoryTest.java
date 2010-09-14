package com.agritrace.edairy.desktop.common.persistence.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;

public class DairyRepositoryTest {

	@Test
	public void testAccountForMemberNoQuery() throws Exception {
		IMemberRepository repo = RepositoryFactory.getMemberRepository();
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
