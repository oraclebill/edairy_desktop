package com.agritrace.edairy.desktop.dairy.profile.service;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class DairyRepository extends HibernateRepository<Dairy> {

	@Override
	protected Class<?> getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return Dairy.class;
	}

	@Override
	public List<Dairy> find(String query, Object[] args) {
		// TODO Auto-generated method stub
		return super.find(query, args);
	}

	@Override
	public List<Dairy> find(String rawQuery) {
		// TODO Auto-generated method stub
		return super.find(rawQuery);
	}

	@Override
	public List<Dairy> all() {
		// TODO Auto-generated method stub
		return super.all();
	}

	@Override
	public Dairy findByKey(long key) {
		// TODO Auto-generated method stub
		return super.findByKey(key);
	}

	@Override
	public void saveNew(Dairy newEntity) {
		newEntity.setCompanyId(null);
		super.saveNew(newEntity);
	}

	@Override
	public void update(Dairy updateableEntity) {
		// TODO Auto-generated method stub
		super.update(updateableEntity);
	}

	@Override
	public void delete(Dairy deletableEntity) {
		// TODO Auto-generated method stub
		super.delete(deletableEntity);
	}

	class RoutesQuery extends SessionRunnable {
		List<Route> routes;

		public List<Route> getResults() {
			return routes;
		}

		@Override
		public void run(Session session) {
			routes = session.createQuery("FROM Route").list();
		}
	}

	public List<Route> getRoutes() {
		final RoutesQuery routesQuery = new RoutesQuery();
		runWithTransaction(routesQuery);
		return routesQuery.getResults();
	}

	public void saveNewRoute(final Route newRoute) {
		runWithTransaction(new SessionRunnable() {
			@Override
			public void run(Session session) {
				session.persist("Route", newRoute);
			}
		});
	}

	public void updateRoute(final Route changedRoute) {
		runWithTransaction(new SessionRunnable() {
			@Override
			public void run(Session session) {
				session.update("Route", changedRoute);
			}
		});
	}

	public void deleteRoute(final Route object) {
		runWithTransaction(new SessionRunnable() {
			@Override
			public void run(Session session) {
				session.delete("Route", object);
			}
		});
	}

	public Dairy getByName(String name) {
		List<Dairy> list = find("FROM Dairy where name='" + name + "'");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
