package com.agritrace.edairy.desktop.collection.ui.controllers;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class MilkCollectionJournalRepository extends HibernateRepository<CollectionGroup> implements
		ICollectionJournalRepository {
	@Override
	protected Class<CollectionGroup> getClassType() {
		return CollectionGroup.class;
	}
}
