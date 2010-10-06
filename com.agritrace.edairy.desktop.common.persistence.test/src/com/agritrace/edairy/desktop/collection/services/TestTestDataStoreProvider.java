package com.agritrace.edairy.desktop.collection.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Properties;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.cfg.Environment;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.ITransactionRepository;
import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.internal.common.persistence.AltRoleRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.AltTransactionRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;


public class TestTestDataStoreProvider {

	private static class  DataStoreProvider implements Provider<HbDataStore> {
		
		@Override
		public HbDataStore get() {
			long COUNTER = System.currentTimeMillis();
			
			Properties props = new Properties();	
			
			props.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
			props.setProperty(Environment.USER, "SA");
			props.setProperty(Environment.URL, "jdbc:hsqldb:mem:test"  + COUNTER);
			props.setProperty(Environment.PASS, "");
			props.setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
			props.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "managed");

			props.setProperty("teneo.mapping.disable_econtainer", "true");
			props.setProperty("teneo.mapping.default_varchar_length", "60");

			HbDataStore hbds = HbHelper.INSTANCE.createRegisterDataStore("data-store-test" + COUNTER);
			hbds.setProperties(props);
			hbds.setEPackages(PersistenceModule.EPACKAGES);

			hbds.initialize();		
			
			System.err.println(" --> returngin data store : " + hbds );
			System.err.println("     " + hbds.getProperties().get(Environment.URL));
			
			return hbds;
		}
	}
	
	@Test
	public void testDatastoreCreation() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override protected void configure() {
				DataStoreProvider provider = new DataStoreProvider();
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
				DataStoreProvider provider = new DataStoreProvider();
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
