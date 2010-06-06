package com.agritrace.edairy.desktop.dairy.profile.service;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class DairyRepository  implements IDairyRepository {

	private static final HibernateRepository<Dairy> dairyRepository = new HibernateRepository<Dairy>() {
		protected Class<Dairy> getClassType() { return Dairy.class; }
	};	
	private static final HibernateRepository<Route> routeRepository = new HibernateRepository<Route>() {
		protected Class<Route> getClassType() { return Route.class; }
	};

	public Dairy getByName(String name) {
		List<Dairy> list = find("FROM Dairy where name='" + name + "'");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	public List<Dairy> find(String query, Object[] args) {
		// TODO Auto-generated method stub
		return dairyRepository.find(query, args);
	}

	
	public List<Dairy> find(String rawQuery) {
		// TODO Auto-generated method stub
		return dairyRepository.find(rawQuery);
	}

	
	public List<Dairy> all() {
		// TODO Auto-generated method stub
		return dairyRepository.all();
	}

	
	public Dairy findByKey(Long key) {
		// TODO Auto-generated method stub
		return dairyRepository.findByKey(key);
	}

	
	public void saveNew(Dairy newEntity) {
		newEntity.setCompanyId(null);
		dairyRepository.saveNew(newEntity);
	}

	
	public void update(Dairy updateableEntity) {
		// TODO Auto-generated method stub
		dairyRepository.update(updateableEntity);
	}

	
	public void delete(Dairy deletableEntity) {
		// TODO Auto-generated method stub
		dairyRepository.delete(deletableEntity);
	}

	public List<Route> getRoutes() {
		return routeRepository.all();
	}

	public void saveNewRoute(final Route newRoute) {
		routeRepository.saveNew(newRoute);
	}

	public void updateRoute(final Route changedRoute) {
		routeRepository.update(changedRoute);
	}

	public void deleteRoute(final Route object) {
		routeRepository.delete(object);
	}


}
