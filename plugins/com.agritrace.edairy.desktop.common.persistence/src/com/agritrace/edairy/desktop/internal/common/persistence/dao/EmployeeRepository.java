package com.agritrace.edairy.desktop.internal.common.persistence.dao;

import java.io.Serializable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.persistence.FilterParameter;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IEmployeeRepository;
import com.agritrace.edairy.desktop.common.persistence.exceptions.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.exceptions.NonExistingEntityException;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class EmployeeRepository implements IEmployeeRepository, IRepository<Employee> {
	protected static class EmployeeRepositoryInternal extends HibernateRepository<Employee> {
		@Inject
		protected EmployeeRepositoryInternal(Provider<Session> sessionProvider) {
			super(sessionProvider);
			// Force DB initialization
			sessionProvider.get();
		}

		@Override
		protected Class<Employee> getClassType() {
			return Employee.class;
		}
		
		Employee find(final String username, final String password) {
			if (username == null || password == null) {
				throw new NullPointerException("Username and password must be non-null");
			}

			final SessionRunnable<List<Employee>> runner = new SessionRunnable<List<Employee>>() {
				@Override
				public void run(Session s) {
					final Criteria crit = s.createCriteria(getClassType());
					final String hash = PrincipalManager.getInstance().hashPassword(password);

					crit.add(Restrictions.eq("username", username));
					crit.add(Restrictions.or(
							Restrictions.and(Restrictions.eq("password", password),
									Restrictions.or(Restrictions.eq("passwordHashed", false), Restrictions.isNull("passwordHashed"))),
							Restrictions.and(Restrictions.eq("password", hash), Restrictions.eq("passwordHashed", true))
					));

					@SuppressWarnings("unchecked")
					final
					List<Employee> result = crit.list();
					setResult(result);
				}
			};

			// TODO Auto-generated method stub
			runWithTransaction(runner);
			return runner.getResult().size() == 1 ? runner.getResult().get(0) : null;
		}
	};

	private final EmployeeRepositoryInternal employeeRepo;

	@Inject
	public EmployeeRepository(EmployeeRepositoryInternal employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

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

	@Override
	public List<?> filter(String entityName,
			FilterParameter... filterParameterList) {
		return employeeRepo.filter(entityName, filterParameterList);
	}

	
}
