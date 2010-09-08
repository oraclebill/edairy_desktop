package com.agritrace.edairy.desktop.services.ui;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.services.ui.controllers.IAnimalHealthRequestRepository;

public class AnimalHealthRequestRepository extends HibernateRepository<AnimalHealthRequest> implements
		IAnimalHealthRequestRepository {

	@Override
	public List<AnimalHealthRequest> all() {
		return super.all();
	}

	@Override
	public List<AnimalHealthRequest> allRequests() {
		return all();
	}

	@Override
	public void delete(AnimalHealthRequest deletableEntity) throws NonExistingEntityException {
		super.delete(deletableEntity);
	}

//	@Override
//	public List<AnimalHealthRequest> find(String rawQuery) {
//		return super.find(rawQuery);
//	}
//
//	@Override
//	public List<AnimalHealthRequest> find(String query, Object[] args) {
//		return super.find(query, args);
//	}

//	@Override
//	public AnimalHealthRequest findByKey(long key) {
//		return super.findByKey(key);
//	}

	@Override
	public void merge(AnimalHealthRequest context) {
		super.save(context);
	}

	@Override
	public void saveNew(AnimalHealthRequest newEntity) throws AlreadyExistsException {
		super.saveNew(newEntity);
	}

	@Override
	public void update(AnimalHealthRequest updateableEntity) throws NonExistingEntityException {
		super.update(updateableEntity);
	}

	@Override
	protected Class<AnimalHealthRequest> getClassType() {
		return AnimalHealthRequest.class;
	}

}
