package com.agritrace.edairy.desktop.common.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.riena.ui.core.marker.ErrorMarker;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;

import com.agritrace.edairy.desktop.common.persistence.services.IRepository;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;

public abstract class BaseDialogController<T extends EObject> extends AbstractWindowController {

	public static class ContainerValidator {

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
			Collection<? extends IMarker> markers = markable.getMarkersOfType(MandatoryErrorMarker.class);
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

	private IActionRidget okAction;
	protected IRepository<T> repository;

	protected T selected;

	public BaseDialogController() {
		super();
	}

	@Override
	public void afterBind() {
		super.afterBind();
		// we set return code to cancel as default, because if user close
		// the window via ESCAPE (shell close), it returns OK now.
		setReturnCode(CANCEL);
	}

	public T getWorkingCopy() {
		return selected;
	}

	public void setWorkingCopy(T selected) {
		this.selected = selected;
	}

	private boolean validateInternal() {
		boolean retVal = validate(); // user validation first...
		if (!retVal) {
			return false;
		}
		return ContainerValidator.validateContainer(this).isEmpty();
		/**
		for (final IRidget test : getRidgets()) {
			if (test instanceof IMarkableRidget) {
				final IMarkableRidget markable = (IMarkableRidget) test;
				if (markable.isMandatory() && !markable.isDisableMandatoryMarker()) {
					final IMarker errorMarker = new MandatoryErrorMarker();
					markable.addMarker(errorMarker);
					markable.addPropertyChangeListener("text", new PropertyChangeListener() {
						@Override
						public void propertyChange(PropertyChangeEvent evt) {
							markable.removeMarker(errorMarker);
							markable.removePropertyChangeListener(this);
						}
					});
					System.err.println(">>>>>>>> mandatory widget " + markable);
					retVal = false;
				} else {
					Collection<? extends IMarker> markers = markable.getMarkersOfType(MandatoryErrorMarker.class);
					for (IMarker marker : markers) {
						markable.removeMarker(marker);
					}
				}
				if (markable.isErrorMarked()) {
					System.err.println(">>>>>>>> error widget " + markable);

					retVal = false;
					// FIXME: Display error messages in message area.
				}

			}
		}
		return retVal;
		**/
	}

	/**
	 * Configures the 'Save', 'Cancel' and 'Delete' buttons. Subclasses can
	 * override the defaults by manipulating the ridget bindings.
	 * 
	 */
	protected void configureButtonsPanel() {
		if (okAction == null) {
			okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		}
		okAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				if (!validateInternal()) {
					return;
				}
				handleSaveAction();
			}
		});

		final IActionRidget cancelAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_CANCEL);
		cancelAction.addListener(new IActionListener() {

			@Override
			public void callback() {
				handleCancelAction();
			}
		});

		final IActionRidget deleteAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_DELETE);
		deleteAction.setVisible(false);
		deleteAction.addListener(new IActionListener() {
			@Override
			public void callback() {
				handleDeleteAction();
			}
		});
	}

	/**
	 * Enable /disable the save button.
	 * 
	 * @param enable
	 */
	protected void enableSaveButton(boolean enable) {
		if (okAction == null) {
			okAction = (IActionRidget) getRidget(DialogConstants.BIND_ID_BUTTON_SAVE);
		}
		okAction.setEnabled(enable);
	}

	/**
	 * Called when 'Cancel' action is triggered.
	 * 
	 */
	protected void handleCancelAction() {
		setReturnCode(DialogConstants.ACTION_CANCEL);
		getWindowRidget().dispose();
	}

	/**
	 * Called when 'Delete' action is triggered.
	 * 
	 */
	protected void handleDeleteAction() {
		setReturnCode(DialogConstants.ACTION_DELETE);
		getWindowRidget().dispose();
	}

	/**
	 * Called after validation is successful, when 'Save' or 'Update' action is
	 * triggered.
	 * 
	 * 
	 */
	protected void handleSaveAction() {
		setReturnCode(DialogConstants.ACTION_SAVE);
		setContext("selected", getWorkingCopy());
		System.out.println("OK calling dispose");
		getWindowRidget().dispose();
	}

	/**
	 * Validate is called before the standard page validation processs.
	 * 
	 * Subclasses should override to provide additional page level validation.
	 * The default implementation returns 'true'.
	 * 
	 * @return
	 */
	protected boolean validate() {
		final boolean valid = true;
		return valid;
	}
}