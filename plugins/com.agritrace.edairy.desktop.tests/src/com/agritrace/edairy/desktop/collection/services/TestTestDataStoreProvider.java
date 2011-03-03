package com.agritrace.edairy.desktop.collection.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.ITransactionRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.ManagedMemoryDataStoreProvider;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.AltRoleRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.AltTransactionRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;


public class TestTestDataStoreProvider {

	@Test
	public void testDatastoreCreation() throws Exception {
		final Injector injector = Guice.createInjector(new AbstractModule() {
			@Override protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toInstance(provider.get());
			}
		});
		final HbDataStore repo = injector.getInstance(HbDataStore.class);
		assertNotNull(repo);
	}

	static class RoleRepoLiteral extends TypeLiteral<IRepository<Role>> {
		public RoleRepoLiteral() {
			super();
		}
	}

	@Test
	public void testRepositoryCreation() throws Exception {
		final Injector injector = Guice.createInjector(new AbstractModule() {
			@Override protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider);
				bind(ITransactionRepository.class).to(AltTransactionRepository.class);

				bind(new RoleRepoLiteral()).to(AltRoleRepository.class);
			}
		});

		final ITransactionRepository repo = injector.getInstance(ITransactionRepository.class);
		assertNotNull(repo);

		final IRepository<Role> roleRepo = injector.getInstance(Key.get(new RoleRepoLiteral()));
		assertNotNull(roleRepo);

		final Role role1 = ModelFactory.eINSTANCE.createRole();
		role1.setDescription("Test Role #1");
		role1.setName("testRole1");

		roleRepo.save(role1);

		assertEquals(1, roleRepo.all().size());

		role1.getId();

		final IRepository<Role> roleRepo2 = injector.getInstance(Key.get(new RoleRepoLiteral()));
		assertNotSame(
				roleRepo, roleRepo2);

		assertEquals(0, roleRepo2.all().size());

	}

}
