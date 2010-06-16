package com.agritrace.edairy.desktop.operations.services.vehicles;

import java.util.List;

import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;

public class DairyVehicleRepository implements IVehicleRepository {

	private HibernateRepository<Vehicle> hbRepository = new HibernateRepository<Vehicle>() {
		@Override
		protected Class<Vehicle> getClassType() {
			return Vehicle.class;
		}		
	};
	
	@Override
	public List<Vehicle> all() {
		return hbRepository.all();
	}

	@Override
	public void saveNew(Vehicle newItem) {
		hbRepository.saveNew(newItem);
	}
}
