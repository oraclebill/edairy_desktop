package com.agritrace.edairy.desktop.operations.services.collections;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.CollectionJournal;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.model.tracking.Container;

public interface ICollectionRepository {

	List<Route> getRoutes();

	List<DairyContainer> getDairyBins();

	List<Vehicle> getVehicles();

	List<Employee> getEmployees(String string);

	void addCollectionJournal(CollectionJournal newJournal);

	Membership getMembershipById(String memberId);

	Container getContainerById(String canId);

}
