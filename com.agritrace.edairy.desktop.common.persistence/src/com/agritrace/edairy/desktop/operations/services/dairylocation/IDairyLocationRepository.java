package com.agritrace.edairy.desktop.operations.services.dairylocation;

import java.util.Collection;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

public interface IDairyLocationRepository extends IRepository<DairyLocation> {
	List<DairyLocation> allCollectionCenters();
	List<Route> getRoutes();
	void saveAll(Collection<? extends DairyLocation> locs);
}
