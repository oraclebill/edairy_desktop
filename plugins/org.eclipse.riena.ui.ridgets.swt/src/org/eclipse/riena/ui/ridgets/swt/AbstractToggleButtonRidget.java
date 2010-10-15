/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    compeople AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.ridgets.swt;

import java.beans.EventHandler;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.swt.graphics.Image;

import org.eclipse.riena.internal.ui.ridgets.swt.ActionObserver;
import org.eclipse.riena.ui.core.marker.OutputMarker;
import org.eclipse.riena.ui.core.resource.IIconManager;
import org.eclipse.riena.ui.core.resource.IconManagerProvider;
import org.eclipse.riena.ui.core.resource.IconSize;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

/**
 *
 */
public abstract class AbstractToggleButtonRidget extends AbstractValueRidget implements IToggleButtonRidget {
	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private final ActionObserver actionObserver;
	private Binding controlBinding;
	private String text;
	private String iconID;
	private boolean selected;
	private boolean textAlreadyInitialized;
	private boolean useRidgetIcon;

	public AbstractToggleButtonRidget() {
		super();
		actionObserver = new ActionObserver(this);
		textAlreadyInitialized = false;
		useRidgetIcon = false;
		addPropertyChangeListener(IRidget.PROPERTY_ENABLED, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				boolean isEnabled = ((Boolean) evt.getNewValue()).booleanValue();
				updateSelection(isEnabled);
			}
		});
	}

	@Override
	protected void bindUIControl() {
		DataBindingContext context = getValueBindingSupport().getContext();
		if (getUIControl() != null) {
			controlBinding = context.bindValue(getUIControlSelectionObservable(), getRidgetObservable(),
					new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE), new UpdateValueStrategy(
							UpdateValueStrategy.POLICY_UPDATE)
							.setBeforeSetValidator(new CancelControlUpdateWhenDisabled()));
			initText();
			updateUIText();
			updateSelection(isEnabled());
			updateUIIcon();
		}
	}

	protected abstract ISWTObservableValue getUIControlSelectionObservable();

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		if (controlBinding != null) {
			controlBinding.dispose();
			controlBinding = null;
		}
	}

	@Override
	protected IObservableValue getRidgetObservable() {
		return BeansObservables.observeValue(this, IToggleButtonRidget.PROPERTY_SELECTED);
	}

	/**
	 * Always returns true because mandatory markers do not make sense for this
	 * ridget.
	 */
	@Override
	public boolean isDisableMandatoryMarker() {
		return true;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		if (!getMarkersOfType(OutputMarker.class).isEmpty()) {
			/*
			 * TODO If the Ridget has an OutputMarker all events from UI should
			 * be "reverted". At the moment this only works if the control is
			 * unbound at the moment the selection is reset to the saved value
			 * in the Ridget. Needs some investigation. See bug #271762
			 */
			//
			////// Revert
			unbindUIControl();
			setUIControlSelection(this.selected);
			bindUIControl();
			////// End Revert
			return;
		}
		if (this.selected != selected) {
			boolean oldValue = this.selected;
			this.selected = selected;
			actionObserver.widgetSelected(null);
			firePropertyChange(IToggleButtonRidget.PROPERTY_SELECTED, Boolean.valueOf(oldValue), Boolean
					.valueOf(selected));
		}
	}

	public void addListener(IActionListener listener) {
		actionObserver.addListener(listener);
	}

	/**
	 * @deprecated use {@link #addListener(IActionListener)}
	 */
	public void addListener(Object target, String action) {
		IActionListener listener = EventHandler.create(IActionListener.class, target, action);
		actionObserver.addListener(listener);
	}

	public void removeListener(IActionListener listener) {
		actionObserver.removeListener(listener);
	}

	public final String getText() {
		return text;
	}

	public final void setText(String newText) {
		String oldText = this.text;
		this.text = newText;
		updateUIText();
		firePropertyChange(IActionRidget.PROPERTY_TEXT, oldText, this.text);
	}

	public String getIcon() {
		IIconManager manager = IconManagerProvider.getInstance().getIconManager();
		String icon = manager.getName(this.iconID);
		return icon;
	}

	public void setIcon(String icon) {
		setIcon(icon, IconSize.NONE);
	}

	/**
	 * @since 2.0
	 */
	public void setIcon(String icon, IconSize size) {
		boolean oldUseRidgetIcon = useRidgetIcon;
		useRidgetIcon = true;
		String oldIconID = this.iconID;
		IIconManager manager = IconManagerProvider.getInstance().getIconManager();
		this.iconID = manager.getIconID(icon, size);
		if (hasChanged(oldIconID, iconID) || !oldUseRidgetIcon) {
			updateUIIcon();
		}
	}

	// helping methods
	// ////////////////

	protected abstract void setUIControlSelection(boolean selected);

	/**
	 * If the text of the ridget has no value, initialize it with the text of
	 * the UI control.
	 */
	private void initText() {
		if ((text == null) && (!textAlreadyInitialized)) {
			if ((getUIControl()) != null && !(getUIControl().isDisposed())) {
				text = getUIControlText();
				if (text == null) {
					text = EMPTY_STRING;
				}
				textAlreadyInitialized = true;
			}
		}
	}

	protected abstract String getUIControlText();

	/**
	 * Update the selection state of this ridget's control (button)
	 * 
	 * @param isRidgetEnabled
	 *            true if this ridget is enabled, false otherwise
	 */
	private void updateSelection(boolean isRidgetEnabled) {
		if (getUIControl() != null && MarkerSupport.isHideDisabledRidgetContent()) {
			if (!isRidgetEnabled) {
				setUIControlSelection(false);
			} else {
				setUIControlSelection(isSelected());
			}
		}
	}

	private void updateUIText() {
		if (getUIControl() != null) {
			setUIControlText(text);
		}
	}

	protected abstract void setUIControlText(String text);

	/**
	 * Updates the images of the control.
	 */
	private void updateUIIcon() {
		if (getUIControl() != null) {
			Image image = null;
			if (iconID != null) {
				image = getManagedImage(iconID);
			}
			if ((image != null) || useRidgetIcon) {
				setUIControlImage(image);
			}
		}
	}

	protected abstract void setUIControlImage(Image image);

	// helping classes
	//////////////////

	/**
	 * When the ridget is disabled, this validator will prevent the selected
	 * attribute of a control (Button) from changing -- unless
	 * HIDE_DISABLED_RIDGET_CONTENT is {@code false}.
	 */
	private final class CancelControlUpdateWhenDisabled implements IValidator {
		public IStatus validate(Object value) {
			boolean cancel = MarkerSupport.isHideDisabledRidgetContent() && !isEnabled();
			return cancel ? Status.CANCEL_STATUS : Status.OK_STATUS;
		}
	}

	/**
	 * @since 2.0
	 */
	public void fireAction() {
		if (isVisible() && isEnabled()) {
			setSelected(!isSelected());
			actionObserver.widgetSelected(null);
		}
	}

}
