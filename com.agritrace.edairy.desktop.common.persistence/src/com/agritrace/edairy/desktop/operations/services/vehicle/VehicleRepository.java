package com.agritrace.edairy.desktop.operations.services.vehicle;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class VehicleRepository extends HibernateRepository<Vehicle> {
	

	@Override
	public List<Vehicle> all() {
		return super.all();
	}

	@Override
	public void delete(Vehicle deletableEntity) {
		super.delete(deletableEntity);
	}

	
	@Override
	public List<Vehicle> find(String rawQuery) {
		return super.find(rawQuery);
	}

	@Override
	public List<Vehicle> find(String query, Object[] args) {
		return super.find(query, args);
	}

	@Override
	public Vehicle findByKey(long key) {
		return super.findByKey(key);
	}

	public List<Vehicle> getByType(String type) {
		return find("FROM Vehicle where type='" + type + "'");
		
	}


	@Override
	public void saveNew(Vehicle newEntity) {
		super.saveNew(newEntity);
	}

	
	@Override
	public void update(Vehicle updateableEntity) {
		super.update(updateableEntity);
	}


	@Override
	protected Class<?> getClassType() {
		return Vehicle.class;
	}

}
