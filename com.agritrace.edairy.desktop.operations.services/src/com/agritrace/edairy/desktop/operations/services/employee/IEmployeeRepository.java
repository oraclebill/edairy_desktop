package com.agritrace.edairy.desktop.operations.services.employee;

import java.util.List;


import com.agritrace.edairy.desktop.common.model.dairy.Employee;

public interface IEmployeeRepository {

	List<Employee> all();

}
