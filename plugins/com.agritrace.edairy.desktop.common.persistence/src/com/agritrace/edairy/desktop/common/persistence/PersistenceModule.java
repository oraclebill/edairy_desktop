package com.agritrace.edairy.desktop.common.persistence;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.account.Account;
import com.agritrace.edairy.desktop.common.model.dairy.account.AccountPackage;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.services.ImageDataUtil;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.agritrace.edairy.desktop.internal.common.persistence.AccountRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.HbDataStoreProvider;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.SessionProvider;
import com.agritrace.edairy.desktop.internal.common.persistence.TransactionInterceptor;
import com.agritrace.edairy.desktop.internal.operations.services.customer.CustomerRepository;
import com.agritrace.edairy.desktop.internal.persistence.DairyRepository;
import com.agritrace.edairy.desktop.internal.persistence.MemberRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.edairy.desktop.operations.services.employee.IEmployeeRepository;
import com.agritrace.edairy.desktop.operations.services.supplier.ISupplierRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.google.inject.util.Types;

public class PersistenceModule extends AbstractModule {
	public static final String PROPERTIES_FILE_NAME = "edairydb.properties";
	public static final EPackage[] EPACKAGES = {
		TrackingPackage.eINSTANCE,
		DairyPackage.eINSTANCE,
		ModelPackage.eINSTANCE,
		AccountPackage.eINSTANCE,
		RequestsPackage.eINSTANCE
	};

	private class HibernateRepositoryProvider implements Provider<IRepository<?>> {
		private final Class<?> klass;

		@Inject
		private Provider<HibernateRepository<EObject>> baseProvider;

		public HibernateRepositoryProvider(Class<?> klass) {
			this.klass = klass;
		}

		@Override
		public IRepository<?> get() {
			HibernateRepository<EObject> repo = baseProvider.get();
			repo.setClassType(klass);
			return repo;
		}
	}

	private static Map<Class<? extends EObject>, Class<? extends IRepository<? extends EObject>>> customRepositories;

	static {
		customRepositories = new HashMap<Class<? extends EObject>, Class<? extends IRepository<? extends EObject>>>();
		customRepositories.put(Account.class, AccountRepository.class);
		customRepositories.put(CollectionJournalLine.class, ICollectionJournalLineRepository.class);
		customRepositories.put(Customer.class, CustomerRepository.class);
//		customRepositories.put(DairyLocation.class, IDairyLocationRepository.class);
		customRepositories.put(Employee.class, IEmployeeRepository.class);
		customRepositories.put(Farm.class, IFarmRepository.class);
		customRepositories.put(Supplier.class, ISupplierRepository.class);
	}

	@Override
	protected void configure() {
		bind(Session.class).toProvider(SessionProvider.class);
		bind(SessionProvider.class).in(Scopes.SINGLETON);
		bindDataStore();

		for (final EPackage pkg: EPACKAGES) {
			for (final EClassifier klass: pkg.getEClassifiers()) {
				if (klass instanceof EClass) {
					// We have to write all this just so we can @Inject IRepository<Foo> anywhere.

					@SuppressWarnings("unchecked")
					final
					Class<? extends EObject> instanceClass = (Class<? extends EObject>) klass.getInstanceClass();

					@SuppressWarnings("unchecked")
					final
					Key<IRepository<? extends EObject>> key = (Key<IRepository<? extends EObject>>)
						Key.get(Types.newParameterizedType(IRepository.class, instanceClass));

					final Class<? extends IRepository<? extends EObject>> repositoryClass = customRepositories.get(instanceClass);

					if (repositoryClass == null) {
						// We have no registered repository - bind a typical one
						final HibernateRepositoryProvider provider = new HibernateRepositoryProvider(instanceClass);
						requestInjection(provider);

						bind(key).toProvider(provider).in(Scopes.SINGLETON);
					} else {
						// We have a registered repository - bind it
						bind(key).to(repositoryClass);
						bind(repositoryClass).in(Scopes.SINGLETON);
					}
				}
			}
		}

		bind(IDairyRepository.class).to(DairyRepository.class);
		bind(IMemberRepository.class).to(MemberRepository.class);
		bind(DairyRepository.class).in(Scopes.SINGLETON);
		bind(MemberRepository.class).in(Scopes.SINGLETON);
		
		// Install AOP interceptor for transactions
		TransactionInterceptor interceptor = new TransactionInterceptor();
		requestInjection(interceptor);
		bindInterceptor(Matchers.any(), Matchers.annotatedWith(Transactional.class), interceptor);

		// Ideally we shouldn't need this...
		requestStaticInjection(ImageDataUtil.class);
	}

	protected void bindDataStore() {
		bind(HbDataStore.class).toProvider(HbDataStoreProvider.class);
		bind(HbDataStoreProvider.class).in(Scopes.SINGLETON);
	}
}
