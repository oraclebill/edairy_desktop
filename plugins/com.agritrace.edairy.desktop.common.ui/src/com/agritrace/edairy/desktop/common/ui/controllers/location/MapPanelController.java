package com.agritrace.edairy.desktop.common.ui.controllers.location;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IBrowserRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITraverseRidget;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.IDataChangeListener;
import com.agritrace.edairy.desktop.common.ui.controls.location.MapPanel;
import com.agritrace.edairy.desktop.common.ui.validators.DoubleNumberValidator;

public class MapPanelController implements WidgetController<Location> {
	private final ListenerList<IDataChangeListener>	listeners	= new ListenerList<IDataChangeListener>(
																		IDataChangeListener.class);

	private IRidgetContainer						container;
	private IDecimalTextRidget						latitude;
	private IDecimalTextRidget						longitude;
	private Location								location;

	private IBrowserRidget							browser;

	private ITraverseRidget	slider;

	public MapPanelController(IRidgetContainer controller) {
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
				for (final IDataChangeListener listener : listeners.getListeners()) {
					listener.dataChanged();
				}
			}
		};

		latitude = container.getRidget(IDecimalTextRidget.class, MapPanel.MAP_LATITUDE);
		latitude.setPrecision(6);
		latitude.setSigned(true);
		latitude.setMarkNegative(false);
		latitude.addFocusListener(listener);

		longitude = container.getRidget(IDecimalTextRidget.class, MapPanel.MAP_LONGITUDE);
		longitude.setPrecision(6);
		longitude.setSigned(true);
		longitude.setMarkNegative(false);
		longitude.addFocusListener(listener);

		final DoubleNumberValidator validator = new DoubleNumberValidator();
		latitude.addValidationRule(validator, ValidationTime.ON_UI_CONTROL_EDIT);
		longitude.addValidationRule(validator, ValidationTime.ON_UI_CONTROL_EDIT);

		browser = container.getRidget(IBrowserRidget.class, MapPanel.MAP_BROWSER);
		slider = container.getRidget(ITraverseRidget.class, MapPanel.MAP_ZOOM_SCALE);
		slider.setMaximum(14);
		slider.setMinimum(4);
		slider.setValue(11);
		
		latitude.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				browser.setUrl(calculateURL());
			}
		});
		longitude.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				browser.setUrl(calculateURL());
			}
		});
		slider.addPropertyChangeListener("value", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				browser.setUrl(calculateURL());
			}
		});

	}

	private String calculateURL() {
		String lat, lng, url;
		lat = latitude.getText();
		lng = longitude.getText();
		int scale = slider.getValue();
		url = String.format("http://maps.google.com/maps/api/staticmap?center=%s,%s&zoom=%d&size=150x150&sensor=false", lat, lng, scale);
		System.err.println("NEW URL: " + url);
		return url;
//		if (location != null && location.getMapLocation() != null) {
//			return String.format(
//					"http://maps.google.com/maps/api/staticmap?center=%2.6f,%3.6f&zoom=11&size=150x150&sensor=false",
//					location.getMapLocation().getLatitude(), location.getMapLocation().getLongitude());
//		}
//		return "about:blank";
	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public Location getInputModel() {
		return location;
	}

	@Override
	public void setInputModel(Location model) {
		location = model;
		if (container != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		try {
			if (location != null) {
				if (location.getMapLocation() == null) {
					location.setMapLocation(ModelFactory.eINSTANCE.createMapLocation());
				}
				latitude.bindToModel(location, "mapLocation.latitude");
				latitude.setModelToUIControlConverter(NumberToStringConverter.fromDouble(true));
				latitude.updateFromModel();
				longitude.bindToModel(location, "mapLocation.longitude");
				latitude.setModelToUIControlConverter(NumberToStringConverter.fromDouble(true));
				longitude.updateFromModel();
			} else {
				latitude.setText("0");
				longitude.setText("0");
			}
			browser.setUrl(calculateURL());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addDataChangeListener(IDataChangeListener listener) {
		listeners.add(listener);
	}

	public void removeDataChangeListener(IDataChangeListener listener) {
		listeners.remove(listener);
	}
}