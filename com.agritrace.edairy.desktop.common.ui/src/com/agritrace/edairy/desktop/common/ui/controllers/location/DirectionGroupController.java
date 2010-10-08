package com.agritrace.edairy.desktop.common.ui.controllers.location;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.core.util.ListenerList;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.IDataChangeListener;
import com.agritrace.edairy.desktop.common.ui.controls.location.ViewWidgetId;

public class DirectionGroupController implements WidgetController<DescriptiveLocation> {
	private final ListenerList<IDataChangeListener> listeners = new ListenerList<IDataChangeListener>(IDataChangeListener.class);

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

		landmarkTxt = container.getRidget(ITextRidget.class, ViewWidgetId.LANDMARK_TEXT);
		landmarkTxt.addFocusListener(listener);
		directionsTxt = container.getRidget(ITextRidget.class, ViewWidgetId.DIRECTIONS_TEXT);
		directionsTxt.addFocusListener(listener);
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
		this.location = model;
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

	public void addDataChangeListener(IDataChangeListener listener) {
		listeners.add(listener);
	}

	public void removeDataChangeListener(IDataChangeListener listener) {
		listeners.remove(listener);
	}

}
