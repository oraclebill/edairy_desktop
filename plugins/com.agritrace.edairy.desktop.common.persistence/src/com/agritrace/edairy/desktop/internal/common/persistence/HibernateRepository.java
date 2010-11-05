package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.common.persistence.services.Transactional;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class HibernateRepository<T extends EObject> implements IRepository<T> {
	protected abstract class SessionRunnable<X> implements Runnable {
		@Override
		public void run() {
			run(sessionProvider.get());
		}

		abstract public void run(Session session);

		X result;

		protected void setResult(X o) {
			result = o;
		}

		public X getResult() {
			return result;
		}

	}

	private final Provider<Session> sessionProvider;

	private Class<?> classType;
	private String entityName;

	@Inject
	protected HibernateRepository(Provider<Session> sessionProvider) {
		// set the persistence manager
		this.sessionProvider = sessionProvider;

		if (getClassType() != null) {
			initEntityName();
		}
	}

	private void initEntityName() {
		// get metadata about the class we will be persisting..
		String className = getClassType().getName();
		// entity name
		entityName = className.substring(className.lastIndexOf('.') + 1);
		Assert.isLegal(!entityName.startsWith("."));
	}

	@Override
	public List<T> all() {
		final Criteria crit = sessionProvider.get().createCriteria(
				getClassType());
		final List<T> result = crit.list();
		return result;
	}

	@Transactional
	protected List<T> allWithEagerFetch(final String... paths) {
		final Criteria crit = sessionProvider.get().createCriteria(
				getClassType());

		if (paths != null) {
			for (final String path : paths) {
				crit.setFetchMode(path, FetchMode.JOIN);
			}
		}

		@SuppressWarnings("unchecked")
		final List<T> result = crit.list();
		return result;
	}

	@Override
	public void delete(final T deletableEntity)
			throws NonExistingEntityException {
		runWithTransaction(new SessionRunnable<Object>() {
			@Override
			public void run(Session session) {
				session.delete(deletableEntity);
			}
		});
	}

	@Override
	public void load(EObject obj) {
		final Serializable key = (Serializable) obj.eGet(obj.eClass()
				.getEIDAttribute());
		load(obj, key);
	}

	@Override
	@Transactional
	public void load(final EObject obj, final Serializable key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}

		final Session session = sessionProvider.get();

		if (!session.contains(obj)) {
			session.load(obj, key);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByKey(long key) {
		return (T) findByKey(getClassType(), key);
	}

	/**
	 * 
	 * @param <X>
	 * @param entityClass
	 * @param entityKey
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public <X> X findByKey(Class<X> entityClass, long entityKey) {
		return (X) sessionProvider.get().get(getEntityName(entityClass),
				new Long(entityKey));
	}

	/**
	 * 
	 * @param eClass
	 * @return
	 */
	private String getEntityName(Class<?> eClass) {
		final String className = eClass.getName();
		return className.substring(className.lastIndexOf('.') + 1);
	}

	/**
	 * Merge
	 * 
	 * 
	 */
	public void merge(T obj) {
		update(obj);
	}

	@Override
	public void save(final Object changedItem) throws AlreadyExistsException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				final Session session = sessionProvider.get();
				if (changedItem instanceof Collection) {
					for (final Object item : (Collection) changedItem) {
						session.saveOrUpdate(item);
					}
				} else {
					session.saveOrUpdate(changedItem);
				}
			}
		});
	}

	@Override
	public void saveNew(final T newEntity) throws AlreadyExistsException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				sessionProvider.get().save(newEntity);
			}
		});
	}

	@Override
	public void update(final T updateableEntity)
			throws NonExistingEntityException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				sessionProvider.get().update(getEntityName(), updateableEntity);
			}
		});
	}

	private void closeSession() {
		// Currently does nothing!
	}

	protected Object get(String eName, Serializable key) {
		return sessionProvider.get().get(eName, key);
	}

	/**
	 * Subclasses must implement this as follows:
	 * 
	 * <code>
	 *     return T.class;
	 * </code>
	 * 
	 * Where 'T' is the type parameter used in the subclass declaration.
	 * 
	 * @return
	 */
	protected Class<?> getClassType() {
		return classType;
	}

	/**
	 * Non-API method for classes created by PersistenceModule internal
	 * provider.
	 * 
	 */
	public void setClassType(Class<?> klass) {
		classType = klass;
		initEntityName();
	}

	/**
	 * The hibernate entity name of the parameterized class.
	 * 
	 * @return
	 */
	protected String getEntityName() {
		return entityName;
	}

	// /**
	// * The name of the identifier property (primary key) of the parameterized
	// * class.
	// *
	// * @return
	// */
	// protected String getIdentifierName() {
	// return identifierName;
	// }

	protected void run(Runnable r) {
		sessionProvider.get();

		try {
			r.run();
		} finally {
			closeSession();
		}
	}

	@Transactional
	protected void runWithTransaction(Runnable r) {
		r.run();
	}

}
