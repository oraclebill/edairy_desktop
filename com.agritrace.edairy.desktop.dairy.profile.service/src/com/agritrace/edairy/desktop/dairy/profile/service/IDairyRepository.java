package com.agritrace.edairy.desktop.dairy.profile.service;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;

public interface IDairyRepository {

	void saveNew(Dairy localDairy);

	void update(Dairy localDairy);

	Dairy findByKey(Long companyId);

}
