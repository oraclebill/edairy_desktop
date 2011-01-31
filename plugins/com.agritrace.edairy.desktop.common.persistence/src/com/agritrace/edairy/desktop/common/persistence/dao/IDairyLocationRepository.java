package com.agritrace.edairy.desktop.common.persistence.dao;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.DairyLocationRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(DairyLocationRepository.class)
public interface IDairyLocationRepository extends IRepository<DairyLocation> {
//	List<DairyLocation> allCollectionCenters();
//	List<Route> getRoutes();
//	void saveAll(Collection<? extends DairyLocation> locs);
}
