package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.Serializable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.annotations.Transactional;
import com.agritrace.edairy.desktop.common.persistence.exceptions.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.exceptions.NonExistingEntityException;
import com.google.inject.Provider;

/**
 * Abstract implementation of the IRepository interface.
 * 
 * RepositoryUtil relies on the 'getCurrentSession' method of it's superclass to
 * get access to a session. The superclass simply hides the underlying hibernate
 * code.
 * 
 * @author bjones
 * 
 * @param <T>
 */
public abstract class RepositoryUtil<T extends EObject> extends
		DataStoreManager implements IRepository<T> {

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
		// throw new UnsupportedOperationException();
	}

	@Override
	public void load(EObject obj, Serializable key) {
		// throw new UnsupportedOperationException();
	}

	@Override
	public T findByKey(long key) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public void save(Object obj) {
		final Session session = getCurrentSession();
		// final Transaction tx = session.beginTransaction();
		// try {
		session.persist(obj);
		// tx.commit();
		// }
		// catch(final HibernateException hbe) {
		// tx.rollback();
		// }
		// catch(final RuntimeException re) {
		// tx.rollback();
		// }
	}

	@Override
	public List<?> filter(String entityName,
			FilterParameter... filterParameterList) {
		Criteria crit = getCurrentSession().createCriteria(entityName);

		for (FilterParameter p : filterParameterList) {
			if (p.getParamValue() != null) {
				switch (p.getType()) {
				case EQUALS:
					crit.add(Restrictions.eq(p.getParamName(),
							p.getParamValue()));
					break;
				case LIKE:
					crit.add(Restrictions.like(p.getParamName(),
							p.getParamValue()));
					break;
				case LESS_THAN:
					crit.add(Restrictions.le(p.getParamName(),
							p.getParamValue()));
					break;
				case GREATER_THAN:
					crit.add(Restrictions.ge(p.getParamName(),
							p.getParamValue()));
					break;
				default:
					throw new IllegalArgumentException("Unrecognized type: "
							+ p.getType());
				}
			}
		}

		return crit.list();
	}

}
