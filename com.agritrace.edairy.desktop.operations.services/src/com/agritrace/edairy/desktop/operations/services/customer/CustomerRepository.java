package com.agritrace.edairy.desktop.operations.services.customer;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class CustomerRepository extends HibernateRepository<Customer> implements ICustomerRepository {

	class RunLoad extends SessionRunnable {
		Customer myObj;

		RunLoad(Customer eObject) {
			myObj = eObject;
		}

		@Override
		public void run(Session session) {
			session.load(myObj, myObj.getCompanyId());
		}
	}

	class RunMerge extends SessionRunnable {
		Object myObj;

		RunMerge(Object eObject) {
			myObj = eObject;
		}

		@Override
		public void run(Session session) {
			session.merge(myObj);
		}
	}

	@Override
	public List<Customer> all() {
		// TODO Auto-generated method stub
		return super.all();
	}

	@Override
	public void delete(Customer deletableEntity) throws NonExistingEntityException {
		// TODO Auto-generated method stub
		super.delete(deletableEntity);
	}

	@Override
	public List<Customer> find(String rawQuery) {
		// TODO Auto-generated method stub
		return super.find(rawQuery);
	}

	@Override
	public List<Customer> find(String query, Object[] args) {
		// TODO Auto-generated method stub
		return super.find(query, args);
	}

	@Override
	public Customer findByKey(long key) {
		// TODO Auto-generated method stub
		return super.findByKey(key);
	}

	@Override
	public void merge(Customer updateableEntity) {
		runWithTransaction(new RunMerge(updateableEntity));
	}

	@Override
	public void restore(Customer updateableEntity) {
		runWithTransaction(new RunMerge(updateableEntity));
	}

	@Override
	public void saveNew(Customer newEntity) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		super.saveNew(newEntity);
	}

	@Override
	public void update(Customer updateableEntity) throws NonExistingEntityException {
		// TODO Auto-generated method stub
		super.update(updateableEntity);
	}

	@Override
	protected Class getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return Customer.class;
	}

}
