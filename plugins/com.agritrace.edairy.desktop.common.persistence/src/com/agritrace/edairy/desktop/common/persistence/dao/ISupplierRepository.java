package com.agritrace.edairy.desktop.common.persistence.dao;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.internal.common.persistence.dao.SupplierRepository;
import com.google.inject.ImplementedBy;

@ImplementedBy(SupplierRepository.class)
public interface ISupplierRepository extends IRepository<Supplier> {
	List<Supplier> allWithCollections();
}
