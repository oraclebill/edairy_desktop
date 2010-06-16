package com.agritrace.edairy.desktop.operations.services.vehicles;

import java.util.Collection;

import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;

public interface IVehicleRepository {

	Collection<Vehicle> all();

	void saveNew(Vehicle newItem);

}
