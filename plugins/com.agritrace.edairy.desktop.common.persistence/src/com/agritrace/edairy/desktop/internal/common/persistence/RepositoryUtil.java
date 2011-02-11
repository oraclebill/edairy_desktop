package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.annotations.Transactional;
import com.agritrace.edairy.desktop.common.persistence.exceptions.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.exceptions.NonExistingEntityException;
import com.google.inject.Provider;

/**
 * Abstract implementation of the IRepository interface.
 * 
 * RepositoryUtil relies on the 'getCurrentSession' method of it's superclass to get
 * access to a session. The superclass simply hides the underlying hibernate code.
 * 
 * @author bjones
 *
 * @param <T>
 */
public abstract class RepositoryUtil<T extends EObject> extends DataStoreManager implements IRepository<T> {

	public RepositoryUtil(Provider<Session> provider) {
		super(provider);
	}

	@Override
	public void delete(T deletableEntity) throws NonExistingEntityException {
		final Session session = getCurrentSession();
		session.delete(deletableEntity);
	}

	@Override
	public void saveNew(T newEntity) throws AlreadyExistsException {
		final Session session = getCurrentSession();
		session.save(newEntity);
	}

	@Override
	public void update(T updateableEntity) throws NonExistingEntityException {
		final Session session = getCurrentSession();
		session.persist(updateableEntity);
	}

	@Override
	public void load(EObject object) {
//		throw new UnsupportedOperationException();
	}

	@Override
	public void load(EObject obj, Serializable key) {
//		throw new UnsupportedOperationException();
	}

	@Override
	public T findByKey(long key) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public void save(Object obj) {
		final Session session = getCurrentSession();
//		final Transaction tx = session.beginTransaction();
//		try {
			session.persist(obj);
//			tx.commit();
//		}
//		catch(final HibernateException hbe) {
//			tx.rollback();
//		}
//		catch(final RuntimeException re) {
//			tx.rollback();
//		}
	}
}
