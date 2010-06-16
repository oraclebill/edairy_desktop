package com.agritrace.edairy.desktop.operations.services;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;

public interface IDairyRepository {

	List<Dairy> allDairies();

	List<DairyContainer> allDairyContainers();

	List<Route> allRoutes();

	List<Vehicle> allVehicles();

	List<Employee> employeesByPosition(String string);

	Dairy getDairyById(Long companyId);

	Container getFarmContainerById(String canId);

	CollectionJournalPage getJournalPageById(String pageId);

	Dairy getLocalDairy();

	Membership getMembershipById(Object memberId);

	Dairy reloadLocalDairy();

	void saveNewDairy(Dairy localDairy);

	void saveNewJournalPage(CollectionJournalPage newJournal);

	void updateDairy(Dairy localDairy);

}
