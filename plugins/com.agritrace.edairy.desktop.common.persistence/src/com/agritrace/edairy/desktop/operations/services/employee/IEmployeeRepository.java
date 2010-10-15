package com.agritrace.edairy.desktop.operations.services.employee;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.operations.services.employee.EmployeeRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(EmployeeRepository.class)
public interface IEmployeeRepository extends IRepository<Employee> {
	Employee find(String username, String password);
}
