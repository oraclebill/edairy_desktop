package com.agritrace.edairy.desktop.collection.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;


import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.AltRoleRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.AltTransactionRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;


public class TestTestDataStoreProvider {

	@Test
	public void testDatastoreCreation() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override protected void configure() {
				ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toInstance(provider.get());
			}
		});
		HbDataStore repo = injector.getInstance(HbDataStore.class);
		assertNotNull(repo);
	}

	static class RoleRepoLiteral extends TypeLiteral<IRepository<Role>> {
		public RoleRepoLiteral() {
			super();
		}		
	}
	
	@Test
	public void testRepositoryCreation() throws Exception {		
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override protected void configure() {
				ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider);
				bind(ITransactionRepository.class).to(AltTransactionRepository.class);
				
				bind(new RoleRepoLiteral()).to(AltRoleRepository.class);
			}
		});

		ITransactionRepository repo = injector.getInstance(ITransactionRepository.class);
		assertNotNull(repo);
		
		IRepository<Role> roleRepo = injector.getInstance(Key.get(new RoleRepoLiteral()));
		assertNotNull(roleRepo);
		
		Role role1 = DairyFactory.eINSTANCE.createRole();
		role1.setDescription("Test Role #1");
		role1.setName("testRole1");
		
		roleRepo.save(role1);
		
		assertEquals(1, roleRepo.all().size());

		Long roleId = role1.getId();

		IRepository<Role> roleRepo2 = injector.getInstance(Key.get(new RoleRepoLiteral()));
		assertNotSame(
				roleRepo, roleRepo2);
		
		assertEquals(0, roleRepo2.all().size());

	}
	
}
