package com.agritrace.edairy.desktop.common.persistence.services;

import java.io.Serializable;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.metadata.ClassMetadata;

public abstract class HibernateRepository<T extends EObject> implements IRepository<T> {

	private final PersistenceManager persistenceManager;
	private final String entityName;
	private final String identifierName;

	private Session session;
	
	protected abstract class SessionRunnable implements Runnable {
		
		abstract public void run(Session session);
		
		@Override
		public void run() {
			run(session);			
		}
		
	}

	protected HibernateRepository() {
		this(PersistenceManager.getDefault());
	}

	protected HibernateRepository(PersistenceManager pm) {
		String className;
		ClassMetadata metaData;

		System.err.println( "Creating HibernateRepository [" + getClass().getName() + ":" + hashCode() + "]" );

		// set the persistence manager
		persistenceManager = pm;

		// get metadata about the class we will be persisting..
		className = getClassType().getName();
		// entity name
		entityName = className.substring(className.lastIndexOf('.') + 1);
		Assert.isLegal(!entityName.startsWith("."));

		metaData = persistenceManager.getSession().getSessionFactory().getClassMetadata(entityName);
		Assert.isNotNull(metaData);
		// identifier (pk) name
		identifierName = metaData.getIdentifierPropertyName();
		Assert.isNotNull(identifierName);

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

	protected Object get(String eName, Serializable key) {
		return session.get(eName, key);
	}
	
	@Override
	public List<T> find(String query, Object[] args) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public List<T> find(String rawQuery) {
		openSession();
		return runQuery(session.createQuery(rawQuery));
	}

	@Override
	public List<T> all() {
		return find("FROM " + getEntityName());
	}

	@Override
	public T findByKey(long key) {
		openSession();
		final Query q = session.createQuery("FROM " + getEntityName() + " where " + getIdentifierName() + " = ? ")
				.setLong(0, key);

		final List<T> ret = runQuery(q);

		if ((ret != null) && (ret.size() > 0))
			return ret.get(0);
		else
			return null;
	}

	@Override
	public void saveNew(final T newEntity) throws AlreadyExistsException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				session.persist(getEntityName(), newEntity);
			}
		});
	}

	@Override
	public void save(final EObject newEntity) throws AlreadyExistsException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				session.persist(getEntityName(), newEntity);
			}
		});
	}

	@Override
	public void update(final T updateableEntity) throws NonExistingEntityException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				session.update(getEntityName(), updateableEntity);
			}
		});
	}

	@Override
	public void delete(final T deletableEntity) throws NonExistingEntityException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				session.delete(deletableEntity);
			}
		});
	}

	protected void runWithTransaction(Runnable r) {
		openSession();
		final Transaction t = session.beginTransaction();
		try {
			r.run();
			t.commit();
		} catch (final Exception ex) {
			t.rollback();
			throw new TransactionException(entityName, ex);
		} finally {
			closeSession();
		}
	}

	private List<T> runQuery(Query q) {
		List<T> results = null;
		openSession();
		try {
			results = q.list();
			return results;
		} finally {
			closeSession();
		}
	}

	private void openSession() {
		session = persistenceManager.getSession();
		Assert.isNotNull(session);
	}

	private void closeSession() {
		if (null != session) {
			// session.close();
		} else {
			// TODO: use proper logging and exception code.
			throw new IllegalStateException("null session");
		}
	}
}
