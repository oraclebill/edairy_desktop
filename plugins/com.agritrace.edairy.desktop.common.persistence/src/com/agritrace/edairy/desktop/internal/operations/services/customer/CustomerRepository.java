package com.agritrace.edairy.desktop.internal.operations.services.customer;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class CustomerRepository extends HibernateRepository<Customer> {
	@Inject
	protected CustomerRepository(Provider<Session> sessionProvider) {
		super(sessionProvider);
	}

	class RunLoad extends SessionRunnable<Object> {
		Customer myObj;

		RunLoad(Customer eObject) {
			myObj = eObject;
		}

		@Override
		public void run(Session session) {
			session.load(myObj, myObj.getCompanyId());
		}
	}

	class RunMerge extends SessionRunnable<Object> {
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
	public void merge(Customer updateableEntity) {
		runWithTransaction(new RunMerge(updateableEntity));
	}

	@Override
	protected Class<Customer> getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return Customer.class;
	}

}
