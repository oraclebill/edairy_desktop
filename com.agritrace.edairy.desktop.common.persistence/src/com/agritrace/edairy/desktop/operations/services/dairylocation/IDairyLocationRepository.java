package com.agritrace.edairy.desktop.operations.services.dairylocation;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

public interface IDairyLocationRepository extends IRepository<DairyLocation> {
	List<DairyLocation> allCollectionCenters();
}
