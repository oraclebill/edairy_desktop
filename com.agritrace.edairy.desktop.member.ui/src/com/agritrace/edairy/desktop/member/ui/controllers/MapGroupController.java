package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MapGroupController implements WidgetController {

	private IController controller;

	private MapLocation map;

	private ITextRidget latituteTxt;
	private ITextRidget longtituteTxt;

	public MapGroupController(SubModuleController controller){
		this.controller = controller;
		configue();
	}
	@Override
	public void configue() {
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
			latituteTxt.bindToModel(EMFObservables.observeValue(map, ModelPackage.Literals.MAP_LOCATION__LATITUDE));
			latituteTxt.updateFromModel();
			longtituteTxt.bindToModel(EMFObservables.observeValue(map, ModelPackage.Literals.MAP_LOCATION__LONGITUDE));
			longtituteTxt.updateFromModel();
		}else{
			latituteTxt.setText("");
			longtituteTxt.setText("");
		}
	}
}