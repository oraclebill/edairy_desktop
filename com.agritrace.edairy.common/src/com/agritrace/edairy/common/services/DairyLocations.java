package com.agritrace.edairy.common.services;

import com.agritrace.edairy.common.datamodel.dairy.DairyLocation;

public interface DairyLocations {
	void save(DairyLocation dl);
	void delete(long dairyLocationId);
	DairyLocation create();
	DairyLocation query(long dairyLocationId);
	DairyLocation query(String name);
}
