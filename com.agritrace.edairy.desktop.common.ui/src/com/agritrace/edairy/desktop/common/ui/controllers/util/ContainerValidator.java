package com.agritrace.edairy.desktop.common.ui.controllers.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

public class ContainerValidator {

	private static class MandatoryErrorMarker extends ErrorMarker {

	}

	/**
	 * Validates a ridgetContainer by analyzing error/mandatory markers.
	 * 
	 * @return a list of invalid ridgets, or null if no errors.
	 */
	public static Collection<IMarkableRidget> validateContainer(IRidgetContainer container) {
		Collection<IMarkableRidget> errorRidgets = new LinkedList<IMarkableRidget>();
		for (final IRidget test : container.getRidgets()) {
			if (!(test instanceof IMarkableRidget))
				continue;

			final IMarkableRidget markable = (IMarkableRidget) test;

			// add an error marker if there is an empty mandatory field..
			if (mandatoryIsEmpty(markable)) {
				addSelfRemovingErrorMarker(markable);
				errorRidgets.add(markable);
			} else {
				// just in case..
				clearSelfRemovingErrorMarkers(markable);
			}
			// any markers not added by me?
			if (markable.isErrorMarked()) {
				errorRidgets.add(markable);
			}
		}
		return errorRidgets;
	}

	private static void clearSelfRemovingErrorMarkers(IMarkableRidget markable) {
		Collection<? extends IMarker> markers = markable
				.getMarkersOfType(ContainerValidator.MandatoryErrorMarker.class);
		for (IMarker marker : markers) {
			markable.removeMarker(marker);
		}
	}

	protected static boolean mandatoryIsEmpty(final IMarkableRidget markable) {
		return markable.isMandatory() && !markable.isDisableMandatoryMarker();
	}

	private static void addSelfRemovingErrorMarker(final IMarkableRidget markable) {
		final IMarker errorMarker = new MandatoryErrorMarker();
		markable.addMarker(errorMarker);
		markable.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				markable.removeMarker(errorMarker);
				markable.removePropertyChangeListener(this);
			}
		});
	}
}