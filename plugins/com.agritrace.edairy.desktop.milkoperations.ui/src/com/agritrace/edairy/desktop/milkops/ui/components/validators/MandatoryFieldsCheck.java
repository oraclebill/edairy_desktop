package com.agritrace.edairy.desktop.milkops.ui.components.validators;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.core.marker.MandatoryMarker;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

/**
 *
 * @author oraclebill
 *
 */
public class MandatoryFieldsCheck implements IValidator {
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
			catch(final Exception e) {
			}
		}
	}

	final IRidgetContainer container;

	/**
	 *
	 * @param container
	 */
	public MandatoryFieldsCheck(IRidgetContainer container) {
		this.container = container;
	}

	void setErrorMarker(final IMarkableRidget ridget, String message) {
		final ErrorMarker errorMarker = new MandatoryErrorMarker(message);
		final MandatoryErrorMarkerCleaner markerCleaner = new MandatoryErrorMarkerCleaner(ridget, errorMarker);
		ridget.addMarker(errorMarker);
		ridget.addPropertyChangeListener("text", markerCleaner);
	}

	@Override
	public IStatus validate(Object value) {
System.err.printf("validate: %s: %s\n", this, value);
		IStatus status = Status.OK_STATUS;
		for (final IRidget ridget : container.getRidgets()) {
			if (ridget instanceof IMarkable) {
				boolean result = false;
				final Iterator<MandatoryMarker> iter = ((IMarkable) ridget).getMarkersOfType(MandatoryMarker.class)
						.iterator();
				while (iter.hasNext()) {
					result = /*result ||*/ !iter.next().isDisabled();
				}
				if (result) {
					setErrorMarker((IMarkableRidget)ridget, "Required field.");
					status = ValidationStatus.error("The highlighted fields are required.");
				}
			}
		}
		return status;
	}

}
