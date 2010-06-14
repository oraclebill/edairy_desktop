package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class MilkCollectionJournalRepository extends HibernateRepository<CollectionJournalPage> implements
		IRepository<CollectionJournalPage> {
	@Override
	protected Class<CollectionJournalPage> getClassType() {
		return CollectionJournalPage.class;
	}
}
