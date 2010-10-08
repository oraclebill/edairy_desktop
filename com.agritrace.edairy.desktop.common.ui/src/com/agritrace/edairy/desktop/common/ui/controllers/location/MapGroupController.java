package com.agritrace.edairy.desktop.common.ui.controllers.location;

import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;

import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.IDataChangeListener;
import com.agritrace.edairy.desktop.common.ui.controls.location.ViewWidgetId;
import com.agritrace.edairy.desktop.common.ui.validators.DoubleNumberValidator;

public class MapGroupController implements WidgetController<MapLocation> {
	private final ListenerList<IDataChangeListener> listeners = new ListenerList<IDataChangeListener>(IDataChangeListener.class);

	private IRidgetContainer container;
	private IDecimalTextRidget latituteTxt;
	private IDecimalTextRidget longtituteTxt;
	private MapLocation map;

	public MapGroupController(IRidgetContainer controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		final IFocusListener listener = new IFocusListener() {
			@Override
			public void focusGained(FocusEvent event) {
				// Do nothing
			}

			@Override
			public void focusLost(FocusEvent event) {
				for (final IDataChangeListener listener: listeners.getListeners()) {
					listener.dataChanged();
				}
			}
		};

		latituteTxt = container.getRidget(IDecimalTextRidget.class, ViewWidgetId.LATITUDE_TEXT);
		latituteTxt.setPrecision(4);
		latituteTxt.setSigned(true);
		latituteTxt.setMarkNegative(false);
		latituteTxt.addFocusListener(listener);

		longtituteTxt = container.getRidget(IDecimalTextRidget.class, ViewWidgetId.LONGTITUDE_TEXT);
		longtituteTxt.setPrecision(4);
		longtituteTxt.setSigned(true);
		longtituteTxt.setMarkNegative(false);
		longtituteTxt.addFocusListener(listener);

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
		map = model;
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

	public void addDataChangeListener(IDataChangeListener listener) {
		listeners.add(listener);
	}

	public void removeDataChangeListener(IDataChangeListener listener) {
		listeners.remove(listener);
	}
}