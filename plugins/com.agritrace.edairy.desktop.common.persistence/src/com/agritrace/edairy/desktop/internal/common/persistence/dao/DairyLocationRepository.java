package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyLocationRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class DairyLocationRepository extends HibernateRepository<DairyLocation> implements IDairyLocationRepository {
	
	private IDairyRepository dairyRepo;
	
	@Inject
	public DairyLocationRepository(Provider<Session> sessionProvider, IDairyRepository dairyRepo) {
		super(sessionProvider);
		this.dairyRepo = dairyRepo;
	}

//	@Override
//	public void delete(DairyLocation deletableEntity) {
//		final Route route = deletableEntity.getRoute();
//		if (route != null) {
//			route.getStops().remove(deletableEntity);
//			updateRoute(route);
//		}
//	}

	@Override
	public void saveNew(DairyLocation newEntity) {
		dairyRepo.getLocalDairy().getBranchLocations().add(newEntity);
		super.saveNew(newEntity);
	}

//	private void updateRoute(final Route changedRoute) {
//		runWithTransaction(new SessionRunnable<Object>() {
//			@Override
//			public void run(Session session) {
//				session.update("Route", changedRoute);
//			}
//		});
//	}

	@Override
	protected Class<?> getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return DairyLocation.class;
	}

}
