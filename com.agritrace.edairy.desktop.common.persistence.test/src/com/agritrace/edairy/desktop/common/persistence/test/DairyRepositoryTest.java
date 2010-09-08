package com.agritrace.edairy.desktop.common.persistence.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class DairyRepositoryTest {

	@Test
	public void testAccountForMemberNoQuery() throws Exception {
		DairyRepository repo = DairyRepository.getInstance();
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
