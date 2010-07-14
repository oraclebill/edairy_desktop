package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class RouteRepository implements IRepository<Route> {

	IRepository<Route> routeRepo = new HibernateRepository<Route>() {

		@Override
		protected Class<Route> getClassType() {
			return Route.class;
		}
	};

	@Override
	public List<Route> getMemberships() {
		return routeRepo.getMemberships();
	}

	@Override
	public void delete(Route deletableEntity) throws NonExistingEntityException {
		routeRepo.delete(deletableEntity);
	}

	@Override
	public List<?> find(String rawQuery) {
		return routeRepo.find(rawQuery);
	}

	@Override
	public List<?> find(String query, Object[] params) {
		return routeRepo.find(query, params);
	}

	@Override
	public Route findByKey(long key) {
		return routeRepo.findByKey(key);
	}

	@Override
	public void save(Object obj) {
		routeRepo.save(obj);
	}

	@Override
	public void saveNew(Route newEntity) throws AlreadyExistsException {
		routeRepo.save(newEntity);
	}

	@Override
	public void update(Route updateableEntity) throws NonExistingEntityException {
		routeRepo.update(updateableEntity);
	}

}
