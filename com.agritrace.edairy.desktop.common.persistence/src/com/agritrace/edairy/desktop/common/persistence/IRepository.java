package com.agritrace.edairy.desktop.common.persistence;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

/**
 * Core repository interface which encapsulates a concrete persistence
 * implementation.
 * 
 * @author bjones
 * 
 * @param <T>
 *            type of objects this repo can persist.
 */
public interface IRepository<T extends EObject> {

	/**
	 * Find objects that match the query.
	 * 
	 * @param query
	 * @return List of matches or empty list.
	 */
	List<T> getMemberships();

	/**
	 * 
	 * @param deletableEntity
	 * @throws NonExistingEntityException
	 */
	void delete(T deletableEntity) throws NonExistingEntityException;

	/**
	 * Find objects matching the query.
	 * 
	 * @param rawQuery
	 * @return a possibly empty list.
	 */
	List<?> find(String rawQuery);

	/**
	 * Find objects that match the query after parameter substitution.
	 * 
	 * @param query
	 * @param params
	 * @return List of matches or empty list.
	 */
	List<?> find(String query, Object[] params);

	/**
	 * Find the object that has key of <key> or null if it does not exist.
	 * 
	 * @param key
	 * @return Single <T> object or null.
	 */
	T findByKey(long key);

	/**
	 * Raw save.
	 * 
	 * 
	 */
	void save(Object obj);

	/**
	 * Creates a new persistent entity. If there is a key set in the new entity
	 * it will be used. If there is a key conflict an exception will be thrown.
	 * 
	 * @param newEntity
	 * @return the internal key of the new entity.
	 * @throws AlreadyExistsException
	 *             if entity with identical key already exists.
	 */
	void saveNew(T newEntity) throws AlreadyExistsException;

	/**
	 * Stores the current state of an existing persistent entity. *
	 * 
	 * @param newEntity
	 * @return the internal key of the new entity.
	 * @throws NonExistingEntityException
	 *             if entity does not exist.
	 */
	void update(T updateableEntity) throws NonExistingEntityException;

}
