package com.agritrace.edairy.desktop.common.persistence.services;

import java.util.List;

import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.metadata.ClassMetadata;

public abstract class HibernateRepository<T extends EObject> implements
		IRepository<T> {

	private final HbDataStore hbds;
	private final SessionFactory sessionFactory;
	private final String entityName;
	private final String identifierName;

	private Session session;

	public HibernateRepository() {
		hbds = PersistenceManager.INSTANCE.getDataStore();
		sessionFactory = hbds.getSessionFactory();
		session = sessionFactory.openSession();
		
		// ClassMetadata metaData =
		// sessionFactory.getClassMetadata(getClassType() + "Impl"); // TODO:
		// Hack
		// entityName = metaData.getEntityName();
		String className = getClassType().getName();
		entityName = className.substring(className.lastIndexOf('.') + 1);
		Assert.isLegal(!entityName.startsWith("."));
		ClassMetadata metaData = sessionFactory.getClassMetadata(entityName);
		Assert.isNotNull(metaData);
		identifierName = metaData.getIdentifierPropertyName();
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
	protected abstract Class getClassType();

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
		return entityName;
	}

	@Override
	public List<T> find(String query, Object[] args) {
		throw new UnsupportedOperationException("not implemented");
	}

	@Override
	public List<T> find(String rawQuery) {
		return runQuery(session.createQuery(rawQuery)); 
	}

	@Override
	public List<T> all() {
		return find("FROM " + getEntityName());
	}

	@Override
	public T findByKey(long key) {
		Query q = session.createQuery(
				"FROM " + getEntityName() + " where " + getIdentifierName()
						+ " = ? ").setLong(0, key);

		List<T> ret = runQuery(q);

		if (ret != null && ret.size() > 0)
			return (T) ret.get(0);
		else
			return null;
	}

	@Override
	public void saveNew(final T newEntity) throws AlreadyExistsException {
		runWithTransaction(new Runnable() {
			public void run() {
				session.persist(getEntityName(), newEntity);
			}
		});
	}

	@Override
	public void update(final T updateableEntity)
			throws NonExistingEntityException {
		runWithTransaction(new Runnable() {
			public void run() {
				session.update(getEntityName(), updateableEntity);
			}
		});
	}

	@Override
	public void delete(final T deletableEntity)
			throws NonExistingEntityException {
		runWithTransaction(new Runnable() {
			public void run() {
				session.delete(deletableEntity);
			}
		});
	}

	private void runWithTransaction(Runnable r) {
		openSession();
		Transaction t = session.beginTransaction();
		try {
			r.run();
		} catch (Exception ex) {
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
		if (null != sessionFactory) {
			session = sessionFactory.getCurrentSession();
			if (null == session) {
				session = sessionFactory.openSession();
			}
			Assert.isNotNull(session);
		} else {
			// TODO: use proper logging and exception code.
			throw new RuntimeException(
					"Unable to create session: null session factory.");
		}
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
