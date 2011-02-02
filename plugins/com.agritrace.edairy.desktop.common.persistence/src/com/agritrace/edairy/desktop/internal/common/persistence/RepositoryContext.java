package com.agritrace.edairy.desktop.internal.common.persistence;

import org.eclipse.emf.ecore.EObject;
import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.IRepositoryContext;
import com.google.inject.Provider;

/**
 * A repository context is a factory for repository objects.
 * 
 * It wraps the Guice injection and creation machinery.
 * 
 * @author bjones
 * 
 */
public class RepositoryContext implements IRepositoryContext {

	@Override
	public <T extends EObject> IRepository<T> getRepository(Class<T> domainClass) {
		// get the appropriate database context
		
		// get the appropriate repository class
		Class<IRepository<T>> repoClass = lookupRepository(domainClass);
		if (repoClass == null) {
			repoClass = synthesizeRepository(domainClass);
		}
		// initialize the repository with db context
		// return new repo
		return null;
	}


	private <T extends EObject> Class<IRepository<T>> lookupRepository(Class<T> domainClass) {
		return null;
	}

	class GenericRepository<X extends EObject> extends HibernateRepository<X> {
		protected GenericRepository(Provider<Session> sessionProvider) {
			super(sessionProvider);
		}		
	}
	
	private <T extends EObject> Class<IRepository<T>> synthesizeRepository(final Class<T> domainClass) {
		return null;
	}

}
