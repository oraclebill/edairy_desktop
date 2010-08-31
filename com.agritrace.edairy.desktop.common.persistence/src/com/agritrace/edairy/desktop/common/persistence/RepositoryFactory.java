package com.agritrace.edairy.desktop.common.persistence;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.operations.services.employee.EmployeeRepository;

/**
 * A factory for IRepositories.
 * 
 * 
 * @author oraclebill
 *
 */
public abstract class RepositoryFactory {
	
	private final static Map<String, Object> repositories;
	static {
		repositories = new HashMap<String, Object>();
		initRepositoryMap();
	}
	
	@SuppressWarnings("unchecked")
	public static <X extends EObject> IRepository<X> getRepository(
			final Class<X> repoClass) {
		synchronized (repositories) {
			String repoName = repoClass.getName();
			IRepository<X> repo = (IRepository<X>) repositories.get(repoName);
			if (repo == null) {
				repo = new HibernateRepository<X>() {
					@Override
					protected Class<?> getClassType() {
						return repoClass;
					}
				};
				configureRepository(repo);
				addRepository(repoClass, repo);
			}
			return repo;
		}
	}

	/**
	 * 
	 * @param <X>
	 * @param repoClass
	 * @param configuredRepository
	 */
	public static <X extends EObject> void addRepository(Class<X> repoClass, IRepository<X> configuredRepository) {
		synchronized (repositories) {
			repositories.put(repoClass.getName(), configuredRepository);
		}
	}
	
	/**
	 * 
	 * @param <X>
	 * @param repoClass
	 */
	public static <X extends EObject> void removeRepository(Class<X> repoClass) {
		synchronized (repositories) {
			@SuppressWarnings("unchecked")
			IRepository<X> repo = (IRepository<X>) repositories.remove(repoClass.getName());
			if (repo != null) {
//			repo.dispose();
			}
		}
	}
	
	/**
	 * 
	 */
	private static void initRepositoryMap() {
//		addRepository(Membership.class, new MembershipRepository());
//		addRepository(Dairy.class, DairyRepository.getInstance());
		addRepository(Employee.class, new EmployeeRepository());
	}
	
	/**
	 * 
	 * @param newRepository
	 */
	private static void configureRepository(IRepository<?> newRepository) {
		// TODO: 
	}

	private RepositoryFactory() {
		// don't really wan't to instantiate this - it's here for the statics..
	}
}
