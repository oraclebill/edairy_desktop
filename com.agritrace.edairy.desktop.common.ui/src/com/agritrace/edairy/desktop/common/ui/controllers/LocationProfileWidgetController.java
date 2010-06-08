package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;

public class LocationProfileWidgetController implements WidgetController {

	private final IController controller;
	private Location location;

	private final AddressGroupWidgetController addressGroup;
	private final DirectionGroupController directionGroup;
	private final MapGroupController mapGroup;

	public LocationProfileWidgetController(IController controller) {
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
//		addressGroup.configure();
//		directionGroup.configure();
//		mapGroup.configure();

	}

	@Override
	public Object getInputModel() {
		return location;
	}

	@Override
	public void setInputModel(Object model) {
		this.location = (Location) model;
		if (controller != null) {
			updateBinding();
		}

	}

	@Override
	public SubModuleController getController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setController(IController controller) {
		// TODO Auto-generated method stub

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

}
