package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.converters.NumberToStringConverter;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class MapGroupController implements WidgetController {

	private IController controller;

	private MapLocation map;

	private ITextRidget latituteTxt;
	private ITextRidget longtituteTxt;

	public MapGroupController(IController controller){
		this.controller = controller;
		configure();
	}
	@Override
	public void configure() {
		latituteTxt = controller.getRidget(ITextRidget.class,ViewWidgetId.LATITUDE_TEXT);
		longtituteTxt = controller.getRidget(ITextRidget.class,ViewWidgetId.LONGTITUDE_TEXT);

	}

	@Override
	public Object getInputModel() {
		return map;
	}

	@Override
	public void setInputModel(Object model) {
		map =(MapLocation)model;
		if(controller != null){
			updateBinding();
		}

	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;

	}

	@Override
	public void updateBinding() {
		if(map != null){
			latituteTxt.bindToModel(map, ModelPackage.Literals.MAP_LOCATION__LATITUDE.getName());
			latituteTxt.setModelToUIControlConverter(new NumberToStringConverter(Double.class));
			latituteTxt.updateFromModel();
			longtituteTxt.bindToModel(map, ModelPackage.Literals.MAP_LOCATION__LONGITUDE.getName());
			latituteTxt.setModelToUIControlConverter(new NumberToStringConverter(Double.class));
			longtituteTxt.updateFromModel();
		}else{
			latituteTxt.setText("");
			longtituteTxt.setText("");
		}
	}
}