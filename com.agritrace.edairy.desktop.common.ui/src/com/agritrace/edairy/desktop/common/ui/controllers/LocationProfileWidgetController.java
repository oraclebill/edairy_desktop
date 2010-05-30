package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;

public class LocationProfileWidgetController implements WidgetController {

	private IController controller;
	private Location location;

	
	private AddressGroupWidgetController addressGroup;
	private DirectionGroupController directionGroup;
	private MapGroupController mapGroup;

	public LocationProfileWidgetController(IController controller) {
		this.controller = controller;
		addressGroup = new AddressGroupWidgetController(controller);
		directionGroup = new DirectionGroupController(controller);
		mapGroup = new MapGroupController(controller);
		configue();
	}

	@Override
	public void configue() {
		if (controller == null) {
			return;
		}
		addressGroup.configue();
		directionGroup.configue();
		mapGroup.configue();

	}

	@Override
	public Object getInputModel() {
		return location;
	}

	@Override
	public void setInputModel(Object model) {
		this.location = (Location)model;
		if(controller != null){
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
		if (location!= null) {
			PostalLocation postalLocation = location.getPostalLocation();
			addressGroup.setInputModel(postalLocation);
			
			MapLocation map = location.getMapLocation();
			mapGroup.setInputModel(map);
			
			DescriptiveLocation dLocation =  location.getDescriptiveLocation();
			directionGroup.setInputModel(dLocation);
			
		}
	}

}