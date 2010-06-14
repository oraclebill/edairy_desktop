package com.agritrace.edairy.desktop.operations.services.collections;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.employee.EmployeeRepository;


public class CollectionRepository extends DairyRepository implements ICollectionRepository {

	HibernateRepository<CollectionJournalPage> collectionRepository = new HibernateRepository<CollectionJournalPage>() {
		@Override protected Class<CollectionJournalPage> getClassType() { return CollectionJournalPage.class; } 
		};
	EmployeeRepository empRepo = new EmployeeRepository();

	@Override
	public void addCollectionJournal(CollectionJournalPage newJournal) {
		collectionRepository.saveNew(newJournal);
	}

}
