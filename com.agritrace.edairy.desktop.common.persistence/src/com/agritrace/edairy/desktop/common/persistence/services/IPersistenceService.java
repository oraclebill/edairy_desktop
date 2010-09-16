package com.agritrace.edairy.desktop.common.persistence.services;

import com.google.inject.ImplementedBy;

@ImplementedBy(PersistenceService.class)
public interface IPersistenceService {
	void start();
}
