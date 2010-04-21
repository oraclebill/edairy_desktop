package com.agritrace.edairy.common.services;

import java.util.List;

import com.agritrace.edairy.common.datamodel.common.*;
import com.agritrace.edairy.common.datamodel.dairy.*;


public interface DairyService  {
	
	public List<Route> getRoutes();
	public void setRoutes(List<Route> value);

	public List<String> getSessions();
	public void setSessions(List<String> value);

	public List<Vehicle> getVehicles();
	public void setVehicles(List<Vehicle> value);

	public List<Employee> getEmployees();
	public void setEmployees(List<Employee> value);

	public List<Container> getContainers();
	public void setContainers(List<Container> value);

} // DairyService
