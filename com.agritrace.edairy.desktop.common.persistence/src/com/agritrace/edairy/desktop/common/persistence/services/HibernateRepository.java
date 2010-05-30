package com.agritrace.edairy.desktop.common.persistence.services;

import java.util.List;

import org.eclipse.core.internal.runtime.Activator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metadata.ClassMetadata;

public abstract class HibernateRepository<T extends EObject> implements IRepository<T> {

	
	private final HbDataStore hbds;
	private final SessionFactory sessionFactory;
	private final String entityName;
	private final String identifierName;
	
	public HibernateRepository() {
		hbds = HbHelper.INSTANCE.getDataStore(PersistenceManager.DB_NAME);
		sessionFactory = hbds.getSessionFactory();
		ClassMetadata metaData = sessionFactory.getClassMetadata(getClassType());
		entityName = metaData.getEntityName();
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
	protected abstract Class getClassType() ;
	
	/**
	 * The hibernate entity name of the parameterized class.
	 * 
	 * @return
	 */
	protected String getEntityName() {
		return entityName;
	}
	
	/**
	 * The name of the identifier property (primary key) of the parameterized class.
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
		Session session;
		List<T> retval;
		String query = rawQuery;
		
		session = sessionFactory.openSession();
		try {
			retval = session.createQuery(query).list();
		}
		finally {
			session.close();
		}
		
		return retval;
	}

	@Override
	public List<T> all() {
		return find("FROM " + getEntityName());
	}

	@Override
	public T findByKey(long key) {
		Session session;
		T retval;
		
		session = sessionFactory.openSession();
		try {
			retval = (T)session
				.createQuery("FROM " + getEntityName() + " where " + getIdentifierName() + " = ? ")
				.setLong(0, key)
				.uniqueResult();
		}
		finally {
			session.close();
		}
		
		return retval;
	}

	@Override
	public void saveNew(T newEntity) throws AlreadyExistsException {
		Session session;
		
		session = sessionFactory.openSession();
		try {
			session.persist(getEntityName(), newEntity);
		}
		finally {
			session.close();
		}		
	}

	@Override
	public void update(T updateableEntity) throws NonExistingEntityException {
		Session session;
		
		session = sessionFactory.openSession();
		try {
			session.update(getEntityName(), updateableEntity);
		}
		finally {
			session.close();
		}				
	}

	@Override
	public void delete(T deletableEntity) throws NonExistingEntityException {
		Session session;
		
		session = sessionFactory.openSession();
		try {
			session.delete(getEntityName(), deletableEntity);
		}
		finally {
			session.close();
		}				
		
	}

//	private void openSession() {
//		if (null != sessionFactory) {
//			session = sessionFactory.openSession();
//		}
//		else {
//			// TODO: use proper logging and exception code.
//			throw new RuntimeException("Unable to create session: null session factory.");
//		}
//	}
//	
//	private void closeSession() {
//		if (null != session) {
//			session.close();
//		}
//		else {
//			// TODO: use proper logging and exception code.
//			throw new IllegalStateException("null session");
//		}
//	}
}
