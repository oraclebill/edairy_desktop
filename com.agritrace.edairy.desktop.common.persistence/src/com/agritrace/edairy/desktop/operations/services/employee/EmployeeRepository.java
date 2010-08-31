package com.agritrace.edairy.desktop.operations.services.employee;

import java.io.Serializable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class EmployeeRepository implements IEmployeeRepository, IRepository<Employee> {

	private final class EmployeeRepositoryInternal extends HibernateRepository<Employee> {
		@Override
		protected Class<Employee> getClassType() {
			return Employee.class;
		}

		Employee find(final String username, final String password) {
			SessionRunnable<List<Employee>> runner = new SessionRunnable<List<Employee>>() {
				@Override
				public void run(Session s) {
					final Criteria crit = s.createCriteria(getClassType());
					crit.add(Restrictions.eq("username", username));
					crit.add(Restrictions.eq("password", password));
					
					@SuppressWarnings("unchecked")
					List<Employee> result = crit.list();
					setResult(result);
				}
			};
			
			// TODO Auto-generated method stub
			runWithTransaction(runner);
			return runner.getResult().size() == 1 ? runner.getResult().get(0) : null;
		}
	};

	EmployeeRepositoryInternal employeeRepo = new EmployeeRepositoryInternal();
	
	@Override
	public List<Employee> all() {
		return employeeRepo.all();

	}

	@Override
	public void load(EObject toLoad) {
		employeeRepo.load(toLoad);
	}
	@Override
	public void load(EObject toLoad, Serializable key) {
		employeeRepo.load(toLoad, key);
	}

	@Override
	public void delete(Employee deletableEntity) throws NonExistingEntityException {
		employeeRepo.delete(deletableEntity);
	}

//	@Override
//	public List<Employee> find(String rawQuery) {
//		return employeeRepo.find(rawQuery);
//	}
//
//	@Override
//	public List<Employee> find(String query, Object[] args) {
//		return employeeRepo.find(query, args);
//	}

	@Override
	public Employee findByKey(long key) {
		return employeeRepo.findByKey(key);
	}

	public void merge(Employee obj) {
		employeeRepo.merge(obj);
	}

	@Override
	public void save(Object obj) {
		employeeRepo.save(obj);
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
	public Employee find(String username, String password) {
		return employeeRepo.find(username, password);
	}


}
