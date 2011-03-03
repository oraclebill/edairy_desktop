package com.agritrace.edairy.desktop.internal.common.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.log.Logger;
import org.eclipse.riena.core.Log4r;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.osgi.service.log.LogService;

import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.annotations.Transactional;
import com.agritrace.edairy.desktop.common.persistence.exceptions.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.exceptions.NonExistingEntityException;
import com.google.inject.Provider;

/**
 * Abstract implementation of the IRepository interface.
 * 
 * RepositoryUtil relies on the 'getCurrentSession' method of it's superclass to get access to a session. The superclass
 * simply hides the underlying hibernate code.
 * 
 * @author bjones
 * 
 * @param <T>
 */
public abstract class RepositoryUtil<T extends EObject> extends DataStoreManager implements IRepository<T> {

	private static final Logger LOGGER = Log4r.getLogger(RepositoryUtil.class);

	public RepositoryUtil(Provider<Session> provider) {
		super(provider);
	}

	@Override
	@Transactional
	public void delete(T deletableEntity) throws NonExistingEntityException {
		// FIXME: test transactions
		boolean created = false, exception = false;

		Session session = getCurrentSession();
		Transaction tx = session.getTransaction();

		if (tx == null || !tx.isActive()) {
			tx = session.beginTransaction();
			created = true;
		}
		try {
			session.delete(deletableEntity);
		} catch (Exception e) {
			exception = true;
			// FIXME: handle exceptions
			e.printStackTrace();
		} finally {
			if (created) {
				if (!exception) {
					tx.commit();
				} else {
					tx.rollback();
				}
			}
		}
	}

	@Override
	@Transactional
	public void saveNew(T newEntity) throws AlreadyExistsException {
		// FIXME: test transactions
		saveInternal(newEntity);
	}

	@Override
	@Transactional
	public void update(T updateableEntity) throws NonExistingEntityException {
		// FIXME: test transactions
		saveInternal(updateableEntity);
	}

	/**
	 */
	@Override
	@Transactional
	public void load(EObject obj) {
		EStructuralFeature id = obj.eClass().getEIDAttribute();
		Assert.isLegal(id != null);
		final Serializable key = (Serializable) obj.eGet(id);
		load(obj, key);
	}

	/**
	 */
	@Override
	@Transactional
	public void load(EObject obj,
			Serializable key) {
		if (key == null) {
			throw new IllegalArgumentException("key cannot be null");
		}

		final Session session = getCurrentSession();

		if (!session.contains(obj)) {
			session.load(obj, key);
		}
	}

	@Override
	@Transactional
	public void save(Object changedItem) {
		getCurrentSession();
		if (changedItem instanceof Collection) {
			for (final Object item : (Collection<?>) changedItem) {
				saveInternal(item);
			}
		} else {
			saveInternal(changedItem);
		}
	}

	void saveInternal(Object obj) {
		// FIXME: test transactions
		// TODO: need to verify this logic.. the assumption is transaction will
		// flush the session and any changes to live object will be persisted..
		boolean created = false, exception = false;

		Session session = getCurrentSession();
		Transaction tx = session.getTransaction();

		if (tx == null || !tx.isActive()) {
			tx = session.beginTransaction();
			created = true;
		}
		try {
			if (session.contains(obj)) {
				LOGGER.log(LogService.LOG_DEBUG, "object already in session - skipping explicit save : " + obj);
				// nothing to do
			} else {
				LOGGER.log(LogService.LOG_DEBUG, "saving : " + obj);
				if (obj instanceof EObject) {
					EObject eObj = (EObject) obj;
					String key = EcoreUtil.getID(eObj);
					if (key != null) {
						LOGGER.log(LogService.LOG_DEBUG, "merging : " + obj);
						session.merge(obj);
					} else {
						session.persist(obj);
					}
				} else {
					session.persist(obj);
				}
			}
		} catch (Exception e) {
			exception = true;
			// FIXME: handle exceptions
			e.printStackTrace();
		} finally {
			if (created) {
				if (!exception) {
					tx.commit();
				} else {
					tx.rollback();
				}
			}
		}
	}

	@Override
	@Transactional
	public T findByKey(long key) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <Q> List<Q> filter(Class<Q> entityClass,
			FilterParameter... filterParameterList) {
		return filter(getCurrentSession().createCriteria(entityClass), filterParameterList);
	}

	@Override
	public List<?> filter(String entityName,
			FilterParameter... filterParameterList) {
		return filter(getCurrentSession().createCriteria(entityName), filterParameterList);
	}

	@Transactional
	<Q> List<Q> filter(Criteria crit,
			FilterParameter... filterParameterList) {
		if (filterParameterList != null) {
			for (FilterParameter p : filterParameterList) {
				if (p.getParamValue() != null) {
					switch (p.getType()) {
					case EQUALS:
						crit.add(Restrictions.eq(p.getParamName(), p.getParamValue()));
						break;
					case LIKE:
						crit.add(Restrictions.like(p.getParamName(), p.getParamValue()));
						break;
					case LESS_THAN:
						crit.add(Restrictions.le(p.getParamName(), p.getParamValue()));
						break;
					case GREATER_THAN:
						crit.add(Restrictions.ge(p.getParamName(), p.getParamValue()));
						break;
					default:
						throw new IllegalArgumentException("Unrecognized type: " + p.getType());
					}
				}
			}
		}
		List<Q> ret = null;
		try {
			ret = crit.list();
		}
		catch(Exception e) {
			LOGGER.log(LogService.LOG_ERROR, "Error executing filter query", e);
		}
		return ret;
	}
}
