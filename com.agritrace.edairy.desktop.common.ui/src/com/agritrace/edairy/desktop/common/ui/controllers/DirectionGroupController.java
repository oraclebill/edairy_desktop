package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class DirectionGroupController implements WidgetController<DescriptiveLocation> {

	private IRidgetContainer container;
	private ITextRidget directionsTxt;

	private ITextRidget landmarkTxt;
	private DescriptiveLocation location;

	public DirectionGroupController(IRidgetContainer controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}
		landmarkTxt = container.getRidget(ITextRidget.class, ViewWidgetId.LANDMARK_TEXT);
		directionsTxt = container.getRidget(ITextRidget.class, ViewWidgetId.DIRECTIONS_TEXT);

	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public DescriptiveLocation getInputModel() {
		return location;
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;
	}

	@Override
	public void setInputModel(DescriptiveLocation model) {
		this.location = (DescriptiveLocation) model;
		if (container != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		if (location == null) {
			landmarkTxt.setText("");
			directionsTxt.setText("");
		} else {
			landmarkTxt.bindToModel(EMFObservables.observeValue(location,
					ModelPackage.Literals.DESCRIPTIVE_LOCATION__LANDMARKS));
			directionsTxt.bindToModel(EMFObservables.observeValue(location,
					ModelPackage.Literals.DESCRIPTIVE_LOCATION__DIRECTIONS));
			landmarkTxt.updateFromModel();
			directionsTxt.updateFromModel();
		}

	}

}
