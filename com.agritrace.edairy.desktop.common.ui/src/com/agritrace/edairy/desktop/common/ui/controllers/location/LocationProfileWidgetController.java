package com.agritrace.edairy.desktop.common.ui.controllers.location;

import org.eclipse.riena.ui.ridgets.IRidgetContainer;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.IDataChangeListener;

public class LocationProfileWidgetController implements WidgetController<Location> {
	private final AddressGroupWidgetController addressGroup;
	private final IRidgetContainer controller;

	private final DirectionGroupController directionGroup;
	private Location location;
	private final MapGroupController mapGroup;

	public LocationProfileWidgetController(IRidgetContainer controller) {
		this.controller = controller;
		addressGroup = new AddressGroupWidgetController(controller);
		directionGroup = new DirectionGroupController(controller);
		mapGroup = new MapGroupController(controller);
		configure();
	}

	@Override
	public void configure() {
		if (controller == null) {
			return;
		}
		// addressGroup.configure();
		// directionGroup.configure();
		// mapGroup.configure();

	}

	@Override
	public IRidgetContainer getContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location getInputModel() {
		return location;
	}

	@Override
	public void setController(IRidgetContainer container) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInputModel(Location model) {
		this.location = (Location) model;
		if (controller != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		if (location != null) {
			final PostalLocation postalLocation = location.getPostalLocation();
			addressGroup.setInputModel(postalLocation);

			final MapLocation map = location.getMapLocation();
			mapGroup.setInputModel(map);

			final DescriptiveLocation dLocation = location.getDescriptiveLocation();
			directionGroup.setInputModel(dLocation);

		}
	}

	public void addDataChangeListener(IDataChangeListener listener) {
		addressGroup.addDataChangeListener(listener);
		directionGroup.addDataChangeListener(listener);
		mapGroup.addDataChangeListener(listener);
	}

	public void removeDataChangeListener(IDataChangeListener listener) {
		addressGroup.removeDataChangeListener(listener);
		directionGroup.removeDataChangeListener(listener);
		mapGroup.removeDataChangeListener(listener);
	}

}
