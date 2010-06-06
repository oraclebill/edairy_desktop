package com.agritrace.edairy.desktop.operations.services.employee;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class EmployeeRepository implements IEmployeeRepository {

	private HibernateRepository<Employee> employeeRepo = new HibernateRepository<Employee>() {
		@Override
		protected Class<Employee> getClassType() {
			return Employee.class;
		}
		
	};
	
	@Override
	public List<Employee> all() {
		return employeeRepo.all();
		
	}

}
