package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public abstract class RepositoryUtil<T extends EObject> extends DataStoreManager implements IRepository<T> {

	public RepositoryUtil(HbDataStore store) {
		super(store);
	}

	@Override
	public void delete(T deletableEntity) throws NonExistingEntityException {
		Session session = getCurrentSession();
		session.delete(deletableEntity);
	}

	@Override
	public void saveNew(T newEntity) throws AlreadyExistsException {
		Session session = getCurrentSession();
		session.save(newEntity);
	}

	@Override
	public void update(T updateableEntity) throws NonExistingEntityException {
		Session session = getCurrentSession();
		session.persist(updateableEntity);
	}

	@Override
	public void load(EObject object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void load(EObject obj, Serializable key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public T findByKey(long key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save(Object obj) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(obj);
			tx.commit();
		}
		catch(HibernateException hbe) {
			tx.rollback();
		}
		catch(RuntimeException re) {
			tx.rollback();
		}
	}
}
