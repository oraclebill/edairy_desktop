package com.agritrace.edairy.desktop.common.ui.controllers;

import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.common.ui.validators.DoubleNumberValidator;

public class MapGroupController implements WidgetController<MapLocation> {

	private IRidgetContainer container;

	private ITextRidget latituteTxt;

	private ITextRidget longtituteTxt;
	private MapLocation map;

	public MapGroupController(IRidgetContainer controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		latituteTxt = container.getRidget(ITextRidget.class, ViewWidgetId.LATITUDE_TEXT);
		longtituteTxt = container.getRidget(ITextRidget.class, ViewWidgetId.LONGTITUDE_TEXT);
		final DoubleNumberValidator validator = new DoubleNumberValidator();
		latituteTxt.addValidationRule(validator, ValidationTime.ON_UI_CONTROL_EDIT);
		longtituteTxt.addValidationRule(validator, ValidationTime.ON_UI_CONTROL_EDIT);

	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public MapLocation getInputModel() {
		return map;
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;

	}

	@Override
	public void setInputModel(MapLocation model) {
		map = (MapLocation) model;
		if (container != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		if (map != null) {
			latituteTxt.bindToModel(map, ModelPackage.Literals.MAP_LOCATION__LATITUDE.getName());
			latituteTxt.setModelToUIControlConverter(NumberToStringConverter.fromDouble(true));
			latituteTxt.updateFromModel();
			longtituteTxt.bindToModel(map, ModelPackage.Literals.MAP_LOCATION__LONGITUDE.getName());
			latituteTxt.setModelToUIControlConverter(NumberToStringConverter.fromDouble(true));
			longtituteTxt.updateFromModel();
		} else {
			latituteTxt.setText("");
			longtituteTxt.setText("");
		}
	}
}