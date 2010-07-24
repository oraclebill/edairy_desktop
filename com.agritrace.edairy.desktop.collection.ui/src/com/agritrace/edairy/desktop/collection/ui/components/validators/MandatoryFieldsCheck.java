package com.agritrace.edairy.desktop.collection.ui.components.validators;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.core.marker.MandatoryMarker;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

public class MandatoryFieldsCheck implements IValidator {
	private static class MandatoryErrorMarker extends ErrorMarker {}

	private static class MandatoryErrorMarkerCleaner implements PropertyChangeListener {
		private ErrorMarker marker;
		private IMarkableRidget ridget;
		public MandatoryErrorMarkerCleaner(IMarkableRidget ridget, ErrorMarker markerToClean) {
			this.ridget = ridget;
			this.marker = markerToClean;
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent evt) {
			try {
				ridget.removeMarker(marker);
				marker = null;
				ridget.removePropertyChangeListener(this);
				ridget = null;
			}
			catch(Exception e) {
			}
		}		
	}

	final IRidgetContainer container;
	
	public MandatoryFieldsCheck(IRidgetContainer container) {
		this.container = container;
	}
	void setErrorMarker(final IMarkableRidget ridget) {
		final ErrorMarker errorMarker = new MandatoryErrorMarker();
		final MandatoryErrorMarkerCleaner markerCleaner = new MandatoryErrorMarkerCleaner(ridget, errorMarker);
		ridget.addMarker(errorMarker);
		ridget.addPropertyChangeListener("text", markerCleaner);
	}
	
	@Override
	public IStatus validate(Object value) {
		IStatus status = ValidationStatus.OK_STATUS;
		for (IRidget ridget : container.getRidgets()) {
			if (ridget instanceof IMarkable) {
				boolean result = false;
				Iterator<MandatoryMarker> iter = ((IMarkable) ridget).getMarkersOfType(MandatoryMarker.class)
						.iterator();
				while (!result && iter.hasNext()) {
					result = !iter.next().isDisabled();
				}
				if (result) {
					setErrorMarker((IMarkableRidget)ridget);
					status = ValidationStatus.error("Missing mandatory field(s)");
				}
			}
		}
		return status;
	}

}