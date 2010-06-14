package com.agritrace.edairy.desktop.collection.ui.controllers;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;

public class MilkCollectionJournalLineRepository extends HibernateRepository<CollectionJournalLine> implements
IRepository<CollectionJournalLine> {

	@Override
	protected Class<CollectionJournalLine> getClassType() {
		return CollectionJournalLine.class;
	}



}
