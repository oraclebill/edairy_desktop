package com.agritrace.edairy.desktop.operations.services;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalPage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;

public interface IDairyRepository {

	List<Customer> allCustomers();

	//List<Dairy> allDairies();

	List<DairyContainer> allDairyContainers();

	List<DeliveryJournal> allDeliveries();

	List<Vehicle> allVehicles();

	List<Employee> employeesByPosition(String string);

	Dairy getDairyById(Long companyId);

	Container getFarmContainerById(String canId);

	CollectionJournalPage getJournalPageById(Long pageId);

	CollectionJournalPage getJournalPageById(String pageId);

	Dairy getLocalDairy();

	List<DairyLocation> getLocalDairyLocations();

	Membership getMembershipById(Object memberId);

	Dairy reloadLocalDairy();

	void save(Object changedItem);

	void saveNewJournalPage(CollectionJournalPage newJournal);

	void updateDairy();

	List<Route> allRoutes();

	void addRoute(Route newRoute);

}
