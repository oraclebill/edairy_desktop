package com.agritrace.edairy.desktop.operations.services.supplier;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.persistence.IRepository;

public interface ISupplierRepository extends IRepository<Supplier> {
	List<Supplier> allWithCollections();
}
