package com.agritrace.edairy.desktop.operations.services.supplier;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class SupplierRepository extends HibernateRepository<Supplier> {

	@Override
	protected Class getClassType() {
		// due to type erasure, cannot get this from the generic type argument...
		return Supplier.class;
	}
	
	

	
}
