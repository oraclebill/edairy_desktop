package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.metadata.ClassMetadata;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.google.inject.Inject;
import com.google.inject.Provider;

public abstract class HibernateRepository<T extends EObject> implements
		IRepository<T> {
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

	private static final Logger LOGGER = Log4r.getLogger(
			Activator.getDefault(), HibernateRepository.class);
	private final String entityName;
	private final String identifierName;

	private final Provider<Session> sessionProvider;
	private final Provider<Session> auditProvider;

	@Inject
	protected HibernateRepository(Provider<Session> sessionProvider, @Audit Provider<Session> auditProvider) {
		String className;
		ClassMetadata metaData;

		LOGGER.log(LogService.LOG_INFO, String.format(
				"Creating HibernateRepository [%s:%d]", getClassType()
						.getName(), hashCode()));

		// set the persistence manager
		this.sessionProvider = sessionProvider;
		this.auditProvider = auditProvider;

		// get metadata about the class we will be persisting..
		className = getClassType().getName();
		// entity name
		entityName = className.substring(className.lastIndexOf('.') + 1);
		Assert.isLegal(!entityName.startsWith("."));

		metaData = sessionProvider.get().getSessionFactory().getClassMetadata(entityName);
		Assert.isNotNull(metaData);
		// identifier (pk) name
		identifierName = metaData.getIdentifierPropertyName();
		Assert.isNotNull(identifierName);

	}

	@Override
	public List<T> all() {
		return allWithEagerFetch((String[]) null);
	}

	protected List<T> allWithEagerFetch(final String... paths) {
		SessionRunnable<List<T>> runner = new SessionRunnable<List<T>>() {
			@Override
			public void run(Session s) {
				final Criteria crit = s.createCriteria(getClassType());

				if (paths != null) {
					for (String path : paths) {
						crit.setFetchMode(path, FetchMode.JOIN);
					}
				}

				@SuppressWarnings("unchecked")
				List<T> result = crit.list();
				setResult(result);
			}
		};
		runWithTransaction(runner);
		return runner.getResult();
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
	public void load(final EObject obj, final Serializable key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}
		
		Session session = sessionProvider.get();

		if (!session.contains(obj))
			session.load(obj, key);
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
	public <X> X findByKey(Class<X> entityClass, long entityKey) {
		return (X) sessionProvider.get().get(getEntityName(entityClass), new Long(entityKey));
	}

	/**
	 * 
	 * @param eClass
	 * @return
	 */
	private String getEntityName(Class<?> eClass) {
		String className = eClass.getName();
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
				sessionProvider.get().saveOrUpdate(changedItem);
			}
		});
		
		onSave(changedItem);
	}

	@Override
	public void saveNew(final T newEntity) throws AlreadyExistsException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				sessionProvider.get().save(newEntity);
			}
		});
		
		onSave(newEntity);
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
		
		onSave(updateableEntity);
	}

	@Override
	public void saveAll(final Collection<? extends T> objects) {
		runWithTransaction(new SessionRunnable<Object>() {
			@Override
			public void run(Session session) {
				for (T obj: objects) {
					session.save(obj);
				}
			}
		});
		
		for (T obj: objects) {
			onSave(obj);
		}
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
	protected abstract Class<?> getClassType();

	/**
	 * The hibernate entity name of the parameterized class.
	 * 
	 * @return
	 */
	protected String getEntityName() {
		return entityName;
	}

	/**
	 * The name of the identifier property (primary key) of the parameterized
	 * class.
	 * 
	 * @return
	 */
	protected String getIdentifierName() {
		return identifierName;
	}

	protected void run(Runnable r) {
		sessionProvider.get();
		
		try {
			r.run();
		} finally {
			closeSession();
		}
	}

	protected void runWithTransaction(Runnable r) {
		Session session = sessionProvider.get();
		
		final Transaction t = session.beginTransaction();
		try {
			r.run();
			t.commit();
		} catch (final Exception ex) {
			t.rollback();
			session.clear();
			throw new TransactionException(entityName, ex);
		} finally {
			closeSession();
		}
	}

	protected void onSave(Object entity) {
		// Audit
	}

	protected void onDelete(Object entity) {
		// Audit
	}
}
