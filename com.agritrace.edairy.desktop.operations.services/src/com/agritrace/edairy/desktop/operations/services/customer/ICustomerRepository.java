package com.agritrace.edairy.desktop.operations.services.customer;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.persistence.services.IRepository;

public interface ICustomerRepository extends IRepository<Customer> {

	List<Customer> all();

	void saveNew(Customer newCustomer);

	void merge(Customer customer);

	void restore(Customer customer);

}
