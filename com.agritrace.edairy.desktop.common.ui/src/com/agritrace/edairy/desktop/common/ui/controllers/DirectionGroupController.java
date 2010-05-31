package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class DirectionGroupController implements WidgetController {
	
	private IController controller;
	private DescriptiveLocation location;
	
	private ITextRidget landmarkTxt;
	private ITextRidget directionsTxt;
	
	public DirectionGroupController(IController controller){
		this.controller = controller;
		configure();
	}

	@Override
	public void configure() {
		if(controller == null){
			return;
		}
		landmarkTxt = controller.getRidget(ITextRidget.class,ViewWidgetId.LANDMARK_TEXT);
		directionsTxt = controller.getRidget(ITextRidget.class,ViewWidgetId.DIRECTIONS_TEXT);

	}

	@Override
	public Object getInputModel() {
		return location;
	}

	@Override
	public void setInputModel(Object model) {
		this.location = (DescriptiveLocation)model;

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
		if(location == null){
			landmarkTxt.setText("");
			directionsTxt.setText("");
		}else{
			landmarkTxt.bindToModel(EMFObservables.observeValue(location, ModelPackage.Literals.DESCRIPTIVE_LOCATION__LANDMARKS));
			directionsTxt.bindToModel(EMFObservables.observeValue(location, ModelPackage.Literals.DESCRIPTIVE_LOCATION__DIRECTIONS));
			landmarkTxt.updateFromModel();
			directionsTxt.updateFromModel();
		}
	
	}

}
