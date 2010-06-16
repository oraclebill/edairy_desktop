package com.agritrace.edairy.desktop.operations.services.employee;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class EmployeeRepository implements IEmployeeRepository, IRepository<Employee>{

	private final HibernateRepository<Employee> employeeRepo = new HibernateRepository<Employee>() {
		@Override
		protected Class<Employee> getClassType() {
			return Employee.class;
		}

	};

	@Override
	public List<Employee> all() {
		return employeeRepo.all();

	}

	@Override
	public void save(Object obj) {
		employeeRepo.save(obj);
	}

	@Override
	public List<Employee> find(String query, Object[] args) {
		return employeeRepo.find(query, args);
	}

	@Override
	public List<Employee> find(String rawQuery) {
		return employeeRepo.find(rawQuery);
	}

	@Override
	public Employee findByKey(long key) {
		return employeeRepo.findByKey(key);
	}

	@Override
	public void saveNew(Employee newEntity) throws AlreadyExistsException {
		employeeRepo.saveNew(newEntity);
	}

	@Override
	public void update(Employee updateableEntity) throws NonExistingEntityException {
		employeeRepo.update(updateableEntity);
	}

	@Override
	public void delete(Employee deletableEntity) throws NonExistingEntityException {
		employeeRepo.delete(deletableEntity);
	}

	public void merge(Employee obj) {
		employeeRepo.merge(obj);
	}

}
