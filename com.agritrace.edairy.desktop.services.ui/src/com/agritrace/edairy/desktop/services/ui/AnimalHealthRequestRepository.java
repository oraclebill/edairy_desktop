package com.agritrace.edairy.desktop.services.ui;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class AnimalHealthRequestRepository extends HibernateRepository<AnimalHealthRequest> {

	@Override
	protected Class getClassType() {
		// due to type erasure, cannot get this from the generic type argument...
		return AnimalHealthRequest.class;
	}

	@Override
	public List<AnimalHealthRequest> find(String query, Object[] args) {
		// TODO Auto-generated method stub
		return super.find(query, args);
	}

	@Override
	public List<AnimalHealthRequest> find(String rawQuery) {
		// TODO Auto-generated method stub
		return super.find(rawQuery);
	}

	@Override
	public List<AnimalHealthRequest> all() {
		// TODO Auto-generated method stub
		return super.all();
	}

	@Override
	public AnimalHealthRequest findByKey(long key) {
		// TODO Auto-generated method stub
		return super.findByKey(key);
	}

	@Override
	public void saveNew(AnimalHealthRequest newEntity) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		super.saveNew(newEntity);
	}

	@Override
	public void update(AnimalHealthRequest updateableEntity) throws NonExistingEntityException {
		// TODO Auto-generated method stub
		super.update(updateableEntity);
	}

	@Override
	public void delete(AnimalHealthRequest deletableEntity) throws NonExistingEntityException {
		// TODO Auto-generated method stub
		super.delete(deletableEntity);
	}
	
	
}
