package com.agritrace.edairy.desktop.common.persistence;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.util.Types;

/**
 * A factory for IRepositories.
 * 
 * 
 * @author oraclebill
 *
 */
// TODO: Get rid of this class. Nothing should inject the injector. Ever.
@Deprecated
public final class RepositoryFactory {
	@Inject
	private static Injector INJECTOR;
	
	public static <T extends IRepository<?>> T getRegisteredRepository(final Class<T> klass) {
		return INJECTOR.getInstance(klass);
	}

	public static <X extends EObject> IRepository<X> getRepository(final Class<X> repoClass) {
		@SuppressWarnings("unchecked")
		Key<IRepository<X>> key = (Key<IRepository<X>>)
			Key.get(Types.newParameterizedType(IRepository.class, repoClass));
		
		return INJECTOR.getInstance(key);
	}
	
	public static IDairyRepository getDairyRepository() {
		return INJECTOR.getInstance(IDairyRepository.class);
	}
	
	public static IMemberRepository getMemberRepository() {
		return INJECTOR.getInstance(IMemberRepository.class);
	}
		
	private RepositoryFactory() {
		// don't really wan't to instantiate this - it's here for the statics..
	}
}
