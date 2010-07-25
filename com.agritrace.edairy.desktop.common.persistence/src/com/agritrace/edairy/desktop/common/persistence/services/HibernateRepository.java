package com.agritrace.edairy.desktop.common.persistence.services;

import java.io.Serializable;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.metadata.ClassMetadata;

import com.agritrace.edairy.desktop.common.persistence.IRepository;

public abstract class HibernateRepository<T extends EObject> implements IRepository<T> {

	protected abstract class SessionRunnable implements Runnable {

		@Override
		public void run() {
			run(session);
		}

		abstract public void run(Session session);
		
		Object result;
		protected void setResult(Object o) {
			result = o;
		}
		public Object getResult() {
			return result;
		}

	}

	private final String entityName;
	private final String identifierName;

	private final PersistenceManager persistenceManager;

	private Session session;

	protected HibernateRepository() {
		this(PersistenceManager.getDefault());
	}

	protected HibernateRepository(PersistenceManager pm) {
		String className;
		ClassMetadata metaData;

		System.err.println("Creating HibernateRepository [" + getClass().getName() + ":" + hashCode() + "]");

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

	@Override
	public List<T> all() {
		return find("FROM " + getEntityName());
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

	@Override
	public List<T> find(String rawQuery) {
		openSession();
		return runQuery(session.createQuery(rawQuery));
	}

	@Override
	public List<T> find(String query, Object[] args) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public T findByKey(long key) {
		return (T) findByKey(getClassType(), key);
		/*
		openSession();
		final Query q = session.createQuery("FROM " + getEntityName() + " where " + getIdentifierName() + " = ? ")
				.setLong(0, key);

		final List<T> ret = runQuery(q);

		if ((ret != null) && (ret.size() > 0)) {
			return ret.get(0);
		} else {
			return null;
		}
		*/
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
		openSession();
		String entityName = getEntityName(entityClass);
		String identifierName = getIdentifierName(entityClass, entityName);
		final Query q = session.createQuery("FROM " + 
				entityName + " where " + 
				identifierName + " = ? ").setLong(0, entityKey);
		Object obj = null;
		final List<?> results = runQuery(q);
		if ((results != null) && (results.size() > 0)) {
			obj = results.get(0);
		} 
		return (X) obj;
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
	 * 
	 * @param eClass
	 * @param eName
	 * @return
	 */
	private String getIdentifierName(Class<?> eClass, String eName) {
		ClassMetadata metaData = persistenceManager.getSession().getSessionFactory().getClassMetadata(eName);
		return metaData.getIdentifierPropertyName();
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
				session.saveOrUpdate(changedItem);
			}
		});
	}

	@Override
	public void saveNew(final T newEntity) throws AlreadyExistsException {
		runWithTransaction(new Runnable() {
			@Override
			public void run() {
				session.save(newEntity);
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

	private void closeSession() {
		if (null != session) {
			// session.close();
		} else {
			// TODO: use proper logging and exception code.
			throw new IllegalStateException("null session");
		}
	}

	private void openSession() {
		session = persistenceManager.getSession();
		Assert.isNotNull(session);
	}

	@SuppressWarnings("unchecked")
	private List<T> runQuery(Query q) {
		List<T> results = null;
		openSession();
		try {
			results = q.list();
		} catch (final HibernateException hbe) {
			session.clear();
			throw hbe;
		} finally {
			closeSession();
		}
		return results;
	}

	protected Object get(String eName, Serializable key) {
		return session.get(eName, key);
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

	protected void runWithTransaction(Runnable r) {
		openSession();
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

}
