package com.agritrace.edairy.desktop.operations.services.dairylocation;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class DairyLocationRepository extends HibernateRepository<DairyLocation> {

	class RoutesQuery extends SessionRunnable<Object> {
		List<Route> routes;

		public List<Route> getResults() {
			return routes;
		}

		@Override
		public void run(Session session) {
			routes = session.createQuery("FROM Route").list();
		}
	}

	@Override
	public List<DairyLocation> all() {
		// TODO Auto-generated method stub
		return super.all();
	}

	@Override
	public void delete(DairyLocation deletableEntity) {
		// TODO Auto-generated method stub
		super.delete(deletableEntity);
	}

	public void deleteRoute(final Route object) {
		runWithTransaction(new SessionRunnable<Object>() {
			@Override
			public void run(Session session) {
				session.delete("Route", object);
			}
		});
	}

	@Override
	public List<DairyLocation> find(String rawQuery) {
		// TODO Auto-generated method stub
		return super.find(rawQuery);
	}

	@Override
	public List<DairyLocation> find(String query, Object[] args) {
		// TODO Auto-generated method stub
		return super.find(query, args);
	}

	@Override
	public DairyLocation findByKey(long key) {
		// TODO Auto-generated method stub
		return super.findByKey(key);
	}

	public DairyLocation getByName(String name) {
		final List<DairyLocation> list = find("FROM DairyLocation where name='" + name + "'");
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public List<Route> getRoutes() {
		final RoutesQuery routesQuery = new RoutesQuery();
		runWithTransaction(routesQuery);
		return routesQuery.getResults();
	}

	@Override
	public void saveNew(DairyLocation newEntity) {
		final Route route = newEntity.getRoute();
		if (route != null) {
			newEntity.setRoute((Route) get("Route", new Long(route.getId())));
		}
		super.saveNew(newEntity);
	}

	public void saveNewRoute(final Route newRoute) {
		runWithTransaction(new SessionRunnable<Object>() {
			@Override
			public void run(Session session) {
				session.persist("Route", newRoute);
			}
		});
	}

	@Override
	public void update(DairyLocation updateableEntity) {
		// TODO Auto-generated method stub
		super.update(updateableEntity);
	}

	public void updateRoute(final Route changedRoute) {
		runWithTransaction(new SessionRunnable<Object>() {
			@Override
			public void run(Session session) {
				session.update("Route", changedRoute);
			}
		});
	}

	@Override
	protected Class<?> getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return DairyLocation.class;
	}

}
