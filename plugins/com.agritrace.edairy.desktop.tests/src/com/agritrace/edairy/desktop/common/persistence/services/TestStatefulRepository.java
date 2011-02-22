package com.agritrace.edairy.desktop.common.persistence.services;

import java.util.List;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.test.ManagedMemoryDataStoreProvider;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.RepositoryUtil;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.google.inject.Scopes;

public class TestStatefulRepository {

	/**
	 * Trivial extension of IRepository subclass with test methods.
	 * 
	 * @author bjones
	 */
	interface ITestRoleRepository extends IRepository<Role> {
		SessionFactory getSessionFactory();

		public Session getSession();
	}

	/**
	 * Trivial implementation of classic IRepository subclass
	 * 
	 * @author bjones
	 */
	@SuppressWarnings("rawtypes")
	static class ClassicRoleRepository extends HibernateRepository<Role> implements ITestRoleRepository {

		@Inject
		public ClassicRoleRepository(Provider<Session> sessionProvider) {
			super(sessionProvider);
		}

		@Override
		public SessionFactory getSessionFactory() {
			final SessionFactory[] factory = new SessionFactory[1];
			super.run(new SessionRunnable() {
				@Override
				public void run(Session session) {
					factory[0] = session.getSessionFactory();
				}
			});
			return factory[0];
		}

		@Override
		public Session getSession() {
			final Session[] factory = new Session[1];
			super.run(new SessionRunnable() {
				@Override
				public void run(Session session) {
					factory[0] = session;
				}
			});
			return factory[0];
		}
	}

	/**
	 * Trivial implementation of IRepository based on RepositoryUtil
	 * 
	 * @author bjones
	 */
	static class NewStyleRoleRepository extends RepositoryUtil<Role> implements ITestRoleRepository {

		@Inject
		public NewStyleRoleRepository(Provider<Session> provider) {
			super(provider);
		}

		@Override
		public List<Role> all() {
			return null;
		}

		@Override
		public SessionFactory getSessionFactory() {
			return super.getCurrentSession().getSessionFactory();
		}

		@Override
		public Session getSession() {
			return super.getCurrentSession();
		}

		@Override
		public <Q> List<Q> filter(Class<Q> entityClass, FilterParameter... filterParameterList) {
			// TODO Auto-generated method stub
			return null;
		}
	}


	@Test
	public void testSimpleConfig() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider);
				bind(Session.class).toProvider(SessionProvider.class);
				bind(ITestRoleRepository.class).to(ClassicRoleRepository.class);
			}
		});
		testRepositoryIdentity(injector, false);
		testSessionFactoryIdentity(injector, false);
		testCrossRepoSessionFactoryIdentity(injector, false);
		testSessionIdentity(injector, false);
		testCrossRepoSessionIdentity(injector, false);
	}
	
	@Test
	public void testSingletonConfig1() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider);
				bind(Session.class).toProvider(SessionProvider.class);
				bind(ITestRoleRepository.class).to(ClassicRoleRepository.class).in(Scopes.SINGLETON);
			}
		});
		testRepositoryIdentity(injector, true);
		testSessionFactoryIdentity(injector, false);
		testCrossRepoSessionFactoryIdentity(injector, false);
		testSessionIdentity(injector, false);
		testCrossRepoSessionIdentity(injector, false);
	}
	
	@Test
	public void testSingletonConfig2() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider).in(Scopes.SINGLETON);
				bind(Session.class).toProvider(SessionProvider.class);
				bind(ITestRoleRepository.class).to(ClassicRoleRepository.class);
			}
		});
		testRepositoryIdentity(injector, false);
		testSessionFactoryIdentity(injector, true);
		testCrossRepoSessionFactoryIdentity(injector, true);
		testSessionIdentity(injector, false);
		testCrossRepoSessionIdentity(injector, false);
	}
	
	@Test
	public void testSingletonConfig3() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider).in(Scopes.SINGLETON);
				bind(Session.class).toProvider(SessionProvider.class).in(Scopes.SINGLETON);
				bind(ITestRoleRepository.class).to(ClassicRoleRepository.class);
			}
		});
		testRepositoryIdentity(injector, false);
		testSessionFactoryIdentity(injector, true);
		testCrossRepoSessionFactoryIdentity(injector, true);
		testSessionIdentity(injector, true);
		testCrossRepoSessionIdentity(injector, true);
	}
	
	@Test
	public void testSingletonConfig4() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider).in(Scopes.SINGLETON);
				bind(Session.class).toProvider(SessionProvider.class);
				bind(ITestRoleRepository.class).to(ClassicRoleRepository.class).in(Scopes.SINGLETON);
			}
		});
		testRepositoryIdentity(injector, true);
		testSessionFactoryIdentity(injector, true);
		testCrossRepoSessionFactoryIdentity(injector, true);
		testSessionIdentity(injector, false);
		testCrossRepoSessionIdentity(injector, false);
	}
	
	@Test
	public void testSingletonConfig5() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider).in(Scopes.SINGLETON);
				bind(Session.class).toProvider(SessionProvider.class).in(Scopes.SINGLETON);
				bind(ITestRoleRepository.class).to(ClassicRoleRepository.class).in(Scopes.SINGLETON);
			}
		});
		testRepositoryIdentity(injector, true);
		testSessionFactoryIdentity(injector, true);
		testCrossRepoSessionFactoryIdentity(injector, true);
		testSessionIdentity(injector, true);
		testCrossRepoSessionIdentity(injector, true);
	}
	
	@Test
	public void testSingletonSessionOnly() throws Exception {
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
				bind(HbDataStore.class).toProvider(provider);
				bind(Session.class).toProvider(SessionProvider.class).in(Scopes.SINGLETON);
				bind(ITestRoleRepository.class).to(ClassicRoleRepository.class);
			}
		});
		testRepositoryIdentity(injector, false);
		testSessionFactoryIdentity(injector, false);
		testCrossRepoSessionFactoryIdentity(injector, false);
		testSessionIdentity(injector, true);
		testCrossRepoSessionIdentity(injector, true);
	}
	
	private void testRepositoryIdentity(Injector injector, boolean expected) {
		ITestRoleRepository repo1, repo2;
		// new repo for each call
		repo1 = injector.getInstance(ITestRoleRepository.class);
		repo2 = injector.getInstance(ITestRoleRepository.class);
		Assert.assertEquals("repository equality check", expected, repo1 == repo2);
		Assert.assertEquals("repository equivalence check", expected, repo1.equals(repo2));
	}
	
	private void testSessionFactoryIdentity(Injector injector, boolean expected) {
		ITestRoleRepository repo1, repo2;
		SessionFactory factory1, factory2;

		repo1 = injector.getInstance(ITestRoleRepository.class);

		factory1 = repo1.getSessionFactory();
		factory2 = repo1.getSessionFactory();
		
		Assert.assertEquals("sessionfactory equality check", expected, factory1 == factory2);
		Assert.assertEquals("sessionfactory equivalence check", expected, factory1.equals(factory2));
	}
	
	private void testCrossRepoSessionFactoryIdentity(Injector injector, boolean expected) {
		ITestRoleRepository repo1, repo2;
		SessionFactory factory1, factory2;

		// new repo for each call
		repo1 = injector.getInstance(ITestRoleRepository.class);
		repo2 = injector.getInstance(ITestRoleRepository.class);
		
		factory1 = repo1.getSessionFactory();
		factory2 = repo2.getSessionFactory();
		
		Assert.assertEquals("cross repo sessionfactory equality check", expected, factory1 == factory2);
		Assert.assertEquals("cross repo sessionfactory equivalence check", expected, factory1.equals(factory2));
	}
	
	private void testSessionIdentity(Injector injector, boolean expected) {
		ITestRoleRepository repo1, repo2;
		Session session1, session2;

		repo1 = injector.getInstance(ITestRoleRepository.class);
		
		session1 = repo1.getSession();
		session2 = repo1.getSession();
		
		Assert.assertEquals(" session equality check", expected, session1 == session2);
		Assert.assertEquals(" session equivalence check", expected, session1.equals(session2));
	}
	
	private void testCrossRepoSessionIdentity(Injector injector, boolean expected) {
		ITestRoleRepository repo1, repo2;
		Session session1, session2;

		// new repo for each call
		repo1 = injector.getInstance(ITestRoleRepository.class);
		repo2 = injector.getInstance(ITestRoleRepository.class);

		session1 = repo1.getSession();
		session2 = repo2.getSession();
		
		Assert.assertEquals("cross repo session equality check", expected, session1 == session2);
		Assert.assertEquals("cross repo session equivalence check", expected, session1.equals(session2));
	}


	/**
	 * A session provider is needed to wrap the session factory (not sure why..)
	 * 
	 * @author bjones
	 */
	static class SessionProvider implements Provider<Session> {
		private SessionFactory sessionFactory;
		private Session session;

		@Inject
		protected SessionProvider(HbDataStore hbds) {
			sessionFactory = hbds.getSessionFactory();
		}

		@Override
		public Session get() {
			if (session == null || !session.isOpen()) {
				session = sessionFactory.openSession();
			}
			return session;
		}
	}


}
