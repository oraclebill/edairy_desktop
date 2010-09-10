package com.agritrace.edairy.desktop.operations.services.supplier;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;

public class SupplierRepository extends HibernateRepository<Supplier> implements ISupplierRepository {
	@Override
	public List<Supplier> all() {
		// TODO Auto-generated method stub
		return super.all();
	}

	@Override
	public List<Supplier> allWithCollections() {
		return super.allWithEagerFetch("categories", "contacts", "contactMethods");
	}

	@Override
	public void delete(Supplier deletableEntity) throws NonExistingEntityException {
		// TODO Auto-generated method stub
		super.delete(deletableEntity);
	}

//	@Override
//	public List<Supplier> find(String rawQuery) {
//		// TODO Auto-generated method stub
//		return super.find(rawQuery);
//	}
//
//	@Override
//	public List<Supplier> find(String query, Object[] args) {
//		// TODO Auto-generated method stub
//		return super.find(query, args);
//	}

	@Override
	public Supplier findByKey(long key) {
		// TODO Auto-generated method stub
		return super.findByKey(key);
	}

	@Override
	public void saveNew(Supplier newEntity) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		super.saveNew(newEntity);
	}

	@Override
	public void update(Supplier updateableEntity) throws NonExistingEntityException {
		// TODO Auto-generated method stub
		super.update(updateableEntity);
	}

	@Override
	protected Class<Supplier> getClassType() {
		// due to type erasure, cannot get this from the generic type
		// argument...
		return Supplier.class;
	}

}
