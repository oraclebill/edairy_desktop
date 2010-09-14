package com.agritrace.edairy.desktop.operations.services.customer;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

@Deprecated
// Apparently unused?
public interface ICustomerRepository extends IRepository<Customer> {

	@Override
	List<Customer> all();

	void merge(Customer customer);

	void restore(Customer customer);

	@Override
	void saveNew(Customer newCustomer);

}
