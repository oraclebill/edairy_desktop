package com.agritrace.edairy.desktop.internal.operations.services.supplier;

import java.util.List;

import org.hibernate.Session;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.persistence.services.Audit;
import com.agritrace.edairy.desktop.internal.common.persistence.HibernateRepository;
import com.agritrace.edairy.desktop.operations.services.supplier.ISupplierRepository;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SupplierRepository extends HibernateRepository<Supplier> implements ISupplierRepository {
	@Inject
	protected SupplierRepository(Provider<Session> sessionProvider, @Audit Provider<Session> auditProvider) {
		super(sessionProvider, auditProvider);
	}

	@Override
	public List<Supplier> allWithCollections() {
		return super.allWithEagerFetch("categories", "contacts", "contactMethods");
	}

	@Override
	protected Class<Supplier> getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return Supplier.class;
	}
}
