package com.agritrace.edairy.desktop.internal.operations.services.dairylocation;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.operations.services.dairylocation.IDairyLocationRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DairyLocationRepository extends HibernateRepository<DairyLocation> implements IDairyLocationRepository {
	
	@Inject
	protected DairyLocationRepository(Provider<Session> sessionProvider) {
		super(sessionProvider);
	}

//	private class RoutesQuery extends SessionRunnable<Object> {
//		List<Route> routes;
//
//		public List<Route> getResults() {
//			return routes;
//		}
//
//		@Override
//		public void run(Session session) {
//			@SuppressWarnings("unchecked")
//			final
//			List<Route> result = session.createQuery("FROM Route").list();
//			routes = result;
//		}
//	}

//	@Override
//	public final List<DairyLocation> allCollectionCenters() {
//		final SessionRunnable<List<DairyLocation>> runnable = new SessionRunnable<List<DairyLocation>>() {
//			@Override
//			public void run(final Session session) {
//				final Query query = session.createQuery(
//						"SELECT DISTINCT dl FROM DairyLocation dl LEFT JOIN dl.functions func WHERE func = :func");
//				query.setParameter("func", DairyFunction.MILK_COLLECTION);
//
//				@SuppressWarnings("unchecked")
//				final List<DairyLocation> result = query.list();
//				setResult(result);
//			}
//		};
//
//		runWithTransaction(runnable);
//		return runnable.getResult();
//	}


	@Override
	public void save(Object changedItem) throws AlreadyExistsException {
		super.save(changedItem);
	}

	@Override
	public void delete(DairyLocation deletableEntity) {
		final Route route = deletableEntity.getRoute();
		if (route != null) {
			route.getStops().remove(deletableEntity);
			updateRoute(route);
		}
	}

//	public void deleteRoute(final Route object) {
//		runWithTransaction(new SessionRunnable<Object>() {
//			@Override
//			public void run(Session session) {
//				session.delete("Route", object);
//			}
//		});
//	}

	@Override
	public DairyLocation findByKey(long key) {
		return super.findByKey(key);
	}

//	@Override
//	public List<Route> getRoutes() {
//		final RoutesQuery routesQuery = new RoutesQuery();
//		runWithTransaction(routesQuery);
//		return routesQuery.getResults();
//	}

//	private void prepareNew(DairyLocation newEntity) {
//		final Route route = newEntity.getRoute();
//		if (route != null) { // TODO: what the hell is this?
//			newEntity.setRoute((Route) get("Route", new Long(route.getId())));
//		}
//		final Dairy dairy = (Dairy) get("Dairy", 1l);
//		dairy.getBranchLocations().add(newEntity);
//	}

//	@Override
//	public void saveNew(DairyLocation newEntity) {
////		prepareNew(newEntity);
//		super.saveNew(newEntity);
//	}

//	@Override
//	public void saveAll(final Collection<? extends DairyLocation> locs) {
//		runWithTransaction(new SessionRunnable<Object>() {
//			@Override
//			public void run(Session session) {
//				for (final DairyLocation loc: locs) {
//					saveNew(loc);
//				}
//			}
//		});
//	}

//	public void saveNewRoute(final Route newRoute) {
//		runWithTransaction(new SessionRunnable<Object>() {
//			@Override
//			public void run(Session session) {
//				session.persist("Route", newRoute);
//			}
//		});
//	}

//	@Override
//	public void update(DairyLocation updateableEntity) {
//		super.update(updateableEntity);
//	}

	private void updateRoute(final Route changedRoute) {
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
