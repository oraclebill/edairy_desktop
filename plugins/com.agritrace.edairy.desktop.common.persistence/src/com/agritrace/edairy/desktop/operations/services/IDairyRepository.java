package com.agritrace.edairy.desktop.operations.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionGroup;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournalLine;
import com.agritrace.edairy.desktop.common.model.dairy.CollectionSession;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DeliveryJournal;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.MemberPayment;
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

	CollectionGroup getJournalPageById(Long pageId);

	CollectionGroup getJournalPageById(String pageId);

	Dairy getLocalDairy();

	List<DairyLocation> getLocalDairyLocations();

	Membership getMembershipById(Object memberId);

	Dairy reloadLocalDairy();

	void save(Object changedItem);

	void saveNewJournalPage(CollectionGroup newJournal);

	void updateDairy();

	List<Route> allRoutes();

	void addRoute(Route newRoute);

	void updateBranchLocation(DairyLocation changedDairyLocation);

	void addBranchLocation(DairyLocation changedDairyLocation);

	void deleteBranchLocation(DairyLocation oldItem);

	MemberPayment getCurrentMilkPrice();

	List<MemberPayment> getMilkPrices(Date startDate, Date endDate);

	public List<DeliveryJournal> getDeliveryJournals(Date minDate, Date maxDate, Route route, Customer customer);

	List<DairyContainer> getBinsByRoute(Route journalRoute);

	Membership findMemberByMemberNo(String memberNumber);

	List<CollectionJournalLine> getMemberCollectionsForSession(CollectionSession session, Membership value);

	Collection<Membership> getMembersForRoute(Route currentRoute);

	void deleteRoute(final Route object);

	void save();

	List<CollectionGroup> allCollectionGroups();
}