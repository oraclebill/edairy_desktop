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

	protected abstract class SessionRunnable<X> implements Runnable {

		@Override
		public void run() {
			run(session);
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
		SessionRunnable<List<T>> runner = new SessionRunnable<List<T>>() {
			@Override public void run(Session s) {
				setResult(
					s.createCriteria(getClassType()).list());
			}
		};
		runWithTransaction(runner);
		return runner.getResult();
	}

	@Override
	public void delete(final T deletableEntity) throws NonExistingEntityException {
		runWithTransaction(new SessionRunnable<Object>() {
			@Override
			public void run(Session session) {
				session.delete(deletableEntity);
			}
		});
	}

	@Override
	public void load(EObject obj) {
		Object id;
		if (obj == null) {
			throw new IllegalArgumentException("obj cannot be null");
		}
//		session.lock(obj, LockMode.NONE);
		try {
			load(obj, (Serializable)obj.eGet(obj.eClass().getEIDAttribute()));
		}
		// we may fail if object is already associated with this session...
		catch(Exception e) {
			load(obj, (Serializable)obj.eGet(obj.eClass().getEIDAttribute()));
		}		
	}
	
	@Override
	public void load(final EObject obj, final Serializable key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}
		runWithTransaction(new Runnable() {
			@Override
			public void run() {				
				session.load(obj, key);
			}
		});
	}
	
	@Override
	public List<T> find(final String rawQuery) {
		SessionRunnable<List<T>> query = new SessionRunnable<List<T>>() {
			@Override
			public void run(Session s) {				
				setResult(s.createQuery(rawQuery).list());
			}
		};
		return query.getResult();
	}


	@Override
	public List<T> find(String query, Object[] args) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public T findByKey(long key) {
		return (T) findByKey(getClassType(), key);
		/*
		 * openSession(); final Query q = session.createQuery("FROM " +
		 * getEntityName() + " where " + getIdentifierName() + " = ? ")
		 * .setLong(0, key);
		 * 
		 * final List<T> ret = runQuery(q);
		 * 
		 * if ((ret != null) && (ret.size() > 0)) { return ret.get(0); } else {
		 * return null; }
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
		final Query q = session.createQuery("FROM " + entityName + " where " + identifierName + " = ? ").setLong(0,
				entityKey);
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
//			 session.close();
//			 session = null;
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
