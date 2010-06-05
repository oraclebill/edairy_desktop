package com.agritrace.edairy.desktop.operations.services.dairylocation;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class DairyLocationRepository extends HibernateRepository<DairyLocation> {

	@Override
	protected Class<?> getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return DairyLocation.class;
	}

	@Override
	public List<DairyLocation> find(String query, Object[] args) {
		// TODO Auto-generated method stub
		return super.find(query, args);
	}

	@Override
	public List<DairyLocation> find(String rawQuery) {
		// TODO Auto-generated method stub
		return super.find(rawQuery);
	}

	@Override
	public List<DairyLocation> all() {
		// TODO Auto-generated method stub
		return super.all();
	}

	@Override
	public DairyLocation findByKey(long key) {
		// TODO Auto-generated method stub
		return super.findByKey(key);
	}

	@Override
	public void saveNew(DairyLocation newEntity) {
		final Route route = newEntity.getRoute();
		if (route != null) {
			newEntity.setRoute((Route) get("Route", new Long(route.getId())));
		}
		super.saveNew(newEntity);
	}

	@Override
	public void update(DairyLocation updateableEntity) {
		// TODO Auto-generated method stub
		super.update(updateableEntity);
	}

	@Override
	public void delete(DairyLocation deletableEntity) {
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

	public DairyLocation getByName(String name) {
		return find("FROM DairyLocation where name='" + name + "'").get(0);
	}

}
