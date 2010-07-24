package com.agritrace.edairy.desktop.collection.ui.controllers;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class MilkCollectionJournalRepository extends HibernateRepository<CollectionJournalPage> implements
		ICollectionJournalRepository {
	@Override
	protected Class<CollectionJournalPage> getClassType() {
		return CollectionJournalPage.class;
	}
}
