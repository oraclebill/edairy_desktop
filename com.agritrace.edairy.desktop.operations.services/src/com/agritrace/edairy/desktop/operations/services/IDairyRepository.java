package com.agritrace.edairy.desktop.operations.services;

import java.util.Collection;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;

public interface IDairyRepository {

	void saveNew(Dairy localDairy);

	void update(Dairy localDairy);

	Dairy findByKey(Long companyId);

	Dairy getLocalDairy();
	
	List<Dairy> getAllDairies();

	Dairy reloadLocalDairy();

	Collection<DairyContainer> allDairyContainers();

}
