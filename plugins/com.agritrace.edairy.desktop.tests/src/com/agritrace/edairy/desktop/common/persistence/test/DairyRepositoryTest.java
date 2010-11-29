package com.agritrace.edairy.desktop.common.persistence.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.junit.Before;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.services.IDbPropertiesManager;
import com.agritrace.edairy.desktop.internal.common.persistence.HsqlDbDataStoreProvider;
import com.agritrace.edairy.desktop.internal.persistence.DairyRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Scopes;

public class DairyRepositoryTest {
	private IMemberRepository repo;

	static class TestModule extends AbstractModule {
		@Override
		protected void configure() {
			bind(IMemberRepository.class).to(DairyRepository.class);
			bind(HbDataStore.class).toProvider(HsqlDbDataStoreProvider.class);
			bind(IDbPropertiesManager.class).to(HsqlDbDataStoreProvider.class);
			bind(HsqlDbDataStoreProvider.class).in(Scopes.SINGLETON);
		}
	}

	@Before
	public void setUp() {
		repo = Guice.createInjector(new TestModule()).getInstance(IMemberRepository.class);
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