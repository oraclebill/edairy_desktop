package com.agritrace.edairy.desktop.collection.ui.controllers;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournal;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class MilkCollectionJournalRepository extends HibernateRepository<CollectionJournal> implements
		IRepository<CollectionJournal> {
	@Override
	protected Class<CollectionJournal> getClassType() {
		return CollectionJournal.class;
	}
}
