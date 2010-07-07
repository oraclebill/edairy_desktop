/*******************************************************************************
 * Copyright © 2009 Florian Pirchner and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Florian Pirchner – initial API and implementation (based on other ridgets of 
 *                    compeople AG)
 * compeople AG     - adjustments for Riena v1.2
 *******************************************************************************/
package org.eclipse.riena.internal.ui.ridgets.swt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.ui.ridgets.AbstractMarkerSupport;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITraverseRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractEditableRidget;
import org.eclipse.riena.ui.ridgets.swt.BasicMarkerSupport;

/**
 * This ridget is an abstraction for all TraverseRidgets and offers general
 * functionality.
 * <p>
 * Additionally it adds a pattern feature to the toolTipText. See
 * {@link ITraverseRidget#VALUE_PATTERN}
 * <p>
 * <b>Value ranges and automatic value adjustments:</b>
 * <p>
 * INCREMENT
 * <p>
 * It has to be greater than zero.
 * <p>
 * Automatic adjustments:
 * <ul>
 * <li><b>increment &lt;= 0:</b> The increment will be set to 1.</li>
 * <li><b>increment &gt; maximum - minimum</b> The increment will be decreased
 * to maximum - minimum</li>
 * </ul>
 * <p>
 * MAXIMUM
 * <p>
 * It has to be equal or greater than zero.
 * <p>
 * Invalid values:
 * <ul>
 * <li><b>maximum &lt;= 0:</b> The set operation will be ignored.</li>
 * <li><b>maximum &lt;= minimum:</b> The set operation will be ignored.</li>
 * </ul>
 * Automatic adjustments:
 * <p>
 * <ul>
 * <li><b>maximum &lt; value:</b> The value will be decreased to maximum.</li>
 * <li><b>maximum - minimum &lt; increment:</b> See INCEMENT.</li>
 * <li><b>maximum - minimum &lt; pageIncrement:</b> See PAGE INCREMENT.</li>
 * </ul>
 * <p>
 * MINIMUM
 * <p>
 * Invalid values:
 * <ul>
 * <li><b>minimum &lt; 0:</b> The set operation will be ignored.</li>
 * <li><b>minimum >= maximum:</b> The set operation will be ignored.</li>
 * </ul>
 * Automatic adjustments:
 * <p>
 * <ul>
 * <li><b>minimum &gt; value:</b> The value will be increased to minimum.</li>
 * <li><b>maximum - minimum &lt; increment:</b> See INCEMENT.</li>
 * <li><b>maximum - minimum &lt; pageIncrement:</b> See PAGE INCREMENT.</li>
 * </ul>
 * PAGE INCREMENT
 * <p>
 * It has to be greater than zero.
 * </p>
 * Automatic adjustments:
 * <p>
 * <ul>
 * <li><b>increment &lt;= 0:</b> The increment will be set to 1.</li>
 * <li><b>increment &gt; maximum - thumb - minimum</b> The increment will be
 * decreased to maximum - thumb - minimum.</li>
 * </ul>
 * VALUE
 * <p>
 * It has to be zero or greater and in the range of minimum and maximum.
 * <p>
 * Automatic adjustments:
 * <ul>
 * <li><b>value &lt; 0:</b> The value will be set to minimum.</li>
 * <li><b>value &lt; minimum:</b> The value will be set to minimum.</li>
 * <li><b>value &gt; maximum - thumb:</b> The value will be set to maximum -
 * thumb.</li>
 * </ul>
 * 
 * @since 1.2
 */
public abstract class AbstractTraverseRidget extends AbstractEditableRidget implements ITraverseRidget {

	private final ActionObserver actionObserver;
	private final TooltipChangeHandler tooltipChangedHandler;

	protected boolean initialized;
	protected int maximum;
	protected int minimum;
	protected int increment;
	protected int pageIncrement;
	protected int value;

	public AbstractTraverseRidget() {
		initialized = false;
		maximum = Integer.MIN_VALUE;
		minimum = Integer.MIN_VALUE;
		increment = Integer.MIN_VALUE;
		pageIncrement = Integer.MIN_VALUE;
		value = Integer.MIN_VALUE;
		actionObserver = new ActionObserver(this);
		tooltipChangedHandler = new TooltipChangeHandler();
		addListener(new ActionListener());
		addPropertyChangeListener(IRidget.PROPERTY_TOOLTIP, tooltipChangedHandler);
	}

	public final void addListener(IActionListener listener) {
		actionObserver.addListener(listener);
	}

	public void triggerListener() {
		actionObserver.fireAction(null);
	}

	@Override
	public void bindUIControl() {
		Control control = getUIControl();
		if (control != null) {
			initFromUIControl();
			addSelectionListener(control, actionObserver);
			updateUIControl();
		}
	}

	public int getIncrement() {
		return increment;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public int getPageIncrement() {
		return pageIncrement;
	}

	public int getValue() {
		return value;
	}

	/**
	 * Always returns true because mandatory markers do not make sense for this
	 * ridget.
	 */
	@Override
	public boolean isDisableMandatoryMarker() {
		return true;
	}

	public final void removeListener(IActionListener listener) {
		actionObserver.removeListener(listener);
	}

	public synchronized boolean revalidate() {
		int val = 0;
		if (getUIControl() != null) {
			val = getValue();
		}
		disableMandatoryMarkers(true);
		IStatus status = checkAllRules(val, new ValidationCallback(false));
		if (status.isOK()) {
			getValueBindingSupport().updateFromTarget();
		}
		return !isErrorMarked();
	}

	public void setIncrement(int increment) {
		increment = preSetIncrement(increment);
		Object oldValue = this.increment;
		this.increment = increment;
		updateUIIncrement();
		firePropertyChange(ITraverseRidget.PROPERTY_INCREMENT, oldValue, this.getIncrement());
	}

	public void setMaximum(int maximum) {
		checkMaximum(maximum);

		preSetMaximum(maximum);
		Object oldValue = this.maximum;
		this.maximum = maximum;
		updateUIMaximum();
		firePropertyChange(ITraverseRidget.PROPERTY_MAXIMUM, oldValue, this.maximum);
	}

	public void setMinimum(int minimum) {
		checkMinimum(minimum);

		preSetMinimum(minimum);

		Object oldValue = this.minimum;
		this.minimum = minimum;
		updateUIMinimum();
		firePropertyChange(ITraverseRidget.PROPERTY_MINIMUM, oldValue, this.minimum);
	}

	public void setPageIncrement(int pageIncrement) {
		pageIncrement = preSetPageIncrement(pageIncrement);
		Object oldValue = this.pageIncrement;
		this.pageIncrement = pageIncrement;
		updateUIPageIncrement();
		firePropertyChange(ITraverseRidget.PROPERTY_PAGE_INCREMENT, oldValue, this.pageIncrement);
	}

	public void setValue(int value) {
		value = preSetValue(value);
		Object oldValue = this.value;
		this.value = value;
		updateUIValue();
		tooltipChangedHandler.updateTooltipPattern();
		firePropertyChange(ITraverseRidget.PROPERTY_VALUE, oldValue, this.value);
	}

	// protected methods
	////////////////////

	/**
	 * Add the given selection listener to the control.
	 * 
	 * @param control
	 *            a control instance; never null
	 * @param listener
	 *            a selection listener; never null
	 */
	protected abstract void addSelectionListener(Control control, SelectionListener listener);

	/**
	 * Validates whether the maximum is in the valid range.
	 * <p>
	 * 
	 * See <i>'Invalid values'</i> in java doc of {@link AbstractTraverseRidget}
	 * section <i>MAXIMUM</i>.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given maximum is not a valid value.
	 */
	protected void checkMaximum(int maximum) {
		if (maximum <= minimum) {
			new Message(Message.MAX_LE_MIN, maximum, minimum).push();
		}
		if (maximum <= 0) {
			new Message(Message.MAX_LE_ZERO, maximum).push();
		}
	}

	/**
	 * Validates whether the minimum is in the valid range.
	 * <p>
	 * 
	 * See <i>'Invalid values'</i> in java doc of {@link AbstractTraverseRidget}
	 * section <i>MINIMUM</i>.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given minimum is not a valid value.
	 */
	protected void checkMinimum(int minimum) {
		if (minimum >= maximum) {
			new Message(Message.MIN_GE_MAX, minimum, maximum).push();
		}
		if (minimum < 0) {
			new Message(Message.MIN_LT_ZERO, minimum).push();
		}
	}

	@Override
	protected AbstractMarkerSupport createMarkerSupport() {
		return new BasicMarkerSupport(this, propertyChangeSupport);
	}

	/**
	 * @return The observable value of the ridget.
	 */
	@Override
	protected IObservableValue getRidgetObservable() {
		return BeansObservables.observeValue(this, ITraverseRidget.PROPERTY_VALUE);
	}

	/**
	 * Returns the value of the given uiControl which is the selection.
	 * 
	 * @param the
	 *            uiControl
	 * @return a integer greater equal zero as the value of the control.
	 */
	protected abstract int getValue(Control control);

	/**
	 * Initializes the ridget on binding with the values of the uiControl. This
	 * is responsible to ensure, that the properties of the ridget and the
	 * uiControl are equal.
	 */
	protected void initFromUIControl() {
		if (getUIControl() != null && !initialized) {
			if (getMaximum() == Integer.MIN_VALUE) {
				setMaximum(getUIControlMaximum());
			}
			if (getMinimum() == Integer.MIN_VALUE) {
				setMinimum(getUIControlMinimum());
			}
			if (getIncrement() == Integer.MIN_VALUE) {
				setIncrement(getUIControlIncrement());
			}
			if (getPageIncrement() == Integer.MIN_VALUE) {
				setPageIncrement(getUIControlPageIncrement());
			}
			if (getValue() == Integer.MIN_VALUE) {
				setValue(getUIControlSelection());
			}
			initAdditionalsFromUIControl();
			initialized = true;
		}
	}

	protected abstract void initAdditionalsFromUIControl();

	protected abstract int getUIControlMaximum();

	protected abstract int getUIControlMinimum();

	protected abstract int getUIControlIncrement();

	protected abstract int getUIControlPageIncrement();

	protected abstract int getUIControlSelection();

	// helping methods
	// ////////////////

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * increment requires this by java doc. As a special case, it can also
	 * change the given increment.
	 * <p>
	 * See <i>'Automatic adjustments'</i> in java doc of
	 * {@link AbstractTraverseRidget} section <i>INCREMENT</i>.
	 * 
	 * @param increment
	 *            the increment to set
	 * @return an adjusted increment
	 */
	protected int preSetIncrement(int increment) {
		if (!initialized) {
			return increment;
		}
		if (increment <= 0) {
			increment = 1;
		} else if (increment > maximum - minimum) {
			increment = maximum - minimum;
		}
		return increment;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * maximum requires this by java doc. As a special case, it can also change
	 * the given maximum.
	 * <p>
	 * See <i>'Automatic adjustments'</i> in java doc of
	 * {@link AbstractTraverseRidget} section <i>MAXIMUM</i>.
	 * 
	 * @param maximum
	 *            the maximum to set
	 * @return an adjusted maximum
	 */
	protected int preSetMaximum(int maximum) {
		if (!initialized) {
			return maximum;
		}
		if (maximum < value) {
			setValue(maximum);
		}
		int deltaMaxMin = maximum - minimum;
		if (deltaMaxMin < increment) {
			setIncrement(deltaMaxMin);
		}
		if (deltaMaxMin < pageIncrement) {
			setPageIncrement(deltaMaxMin);
		}
		return maximum;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * minimum requires this by java doc. As a special case, it can also change
	 * the given minimum.
	 * <p>
	 * See <i>'Automatic adjustments'</i> in java doc of
	 * {@link AbstractTraverseRidget} section <i>MINIMUM</i>.
	 * 
	 * @param minimum
	 *            the minimum to set
	 * @return an adjusted minimum
	 */
	protected int preSetMinimum(int minimum) {
		if (!initialized) {
			return minimum;
		}
		if (value < minimum) {
			setValue(minimum);
		}
		int deltaMaxMin = maximum - minimum;
		if (deltaMaxMin < increment) {
			setIncrement(deltaMaxMin);
		}
		if (deltaMaxMin < pageIncrement) {
			setPageIncrement(deltaMaxMin);
		}
		return minimum;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * pageIncrement requires this by java doc. As a special case, it can also
	 * change the given pageIncrement.
	 * <p>
	 * See <i>'Automatic adjustments'</i> in java doc of
	 * {@link AbstractTraverseRidget} section <i>PAGE INCREMENT</i>.
	 * 
	 * @param pageIncrement
	 *            the pageIncrement to set
	 * @return an adjusted pageIncrement
	 */
	protected int preSetPageIncrement(int pageIncrement) {
		if (!initialized) {
			return pageIncrement;
		}
		if (pageIncrement <= 0) {
			pageIncrement = 1;
		} else if (pageIncrement > maximum - minimum) {
			pageIncrement = maximum - minimum;
		}
		return pageIncrement;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * value requires this by java doc. As a special case, it can also change
	 * the given value.
	 * <p>
	 * See <i>'Automatic adjustments'</i> in java doc of
	 * {@link AbstractTraverseRidget} section <i>VALUE</i>.
	 * 
	 * @param value
	 *            the value to set
	 * @return an adjusted value
	 */
	protected int preSetValue(int value) {
		if (!initialized) {
			return value;
		}
		if (value < 0 || value < minimum) {
			value = getMinimum();
		}
		if (value > maximum) {
			value = maximum;
		}
		return value;
	}

	/**
	 * Remove the given selection listener from the control.
	 * 
	 * @param control
	 *            a control instance; never null
	 * @param listener
	 *            a selection listener; never null
	 */
	protected abstract void removeSelectionListener(Control control, SelectionListener listener);

	/**
	 * Replaces the tooltip pattern ( <code>ITraverseRidget.VALUE_PATTERN</code>
	 * ) with the value of this ridget.
	 */
	protected String replaceToolTipPattern(String toolTipText) {
		String strgValue = Integer.toString(getValue());
		return toolTipText.replace(ITraverseRidget.VALUE_PATTERN, strgValue);
	}

	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		Control control = getUIControl();
		if (control != null) {
			addSelectionListener(control, actionObserver);
		}
	}

	/**
	 * Updates the uiControl with the values of the ridget.
	 */
	protected void updateUIControl() {
		updateUIMaximum();
		updateUIMinimum();
		updateUIIncrement();
		updateUIPageIncrement();
		updateUIValue();
		tooltipChangedHandler.updateTooltipPattern();
	}

	/**
	 * Updates the increment of the uiControl with the increment of the ridget.
	 */
	protected abstract void updateUIIncrement();

	/**
	 * Updates the maximum of the uiControl with the maximum of the ridget.
	 */
	protected abstract void updateUIMaximum();

	/**
	 * Updates the minimum of the uiControl with the minimum of the ridget.
	 */
	protected abstract void updateUIMinimum();

	/**
	 * Updates the pageIncrement of the uiControl with the pageIncrement of the
	 * ridget.
	 */
	protected abstract void updateUIPageIncrement();

	/**
	 * Updates the value of the uiControl with the value of the ridget.
	 */
	protected abstract void updateUIValue();

	// helping classes
	//////////////////

	/**
	 * This class listens for selection events sent by the uiControl.
	 */
	private final class ActionListener implements IActionListener {
		public void callback() {
			if (getUIControl() != null) {
				int selection = getValue(getUIControl());
				setValue(selection);
			}
		}
	}

	/**
	 * A listener that listens for a changed toolTipTexts to replace the
	 * selectionPattern.
	 */
	private final class TooltipChangeHandler implements PropertyChangeListener {
		private String acceptedPatternTooltip;
		private boolean updateMode;

		public void propertyChange(PropertyChangeEvent event) {
			// if updateMode, the method does nothing.
			if (updateMode) {
				return;
			}
			// if the newValue == null, reset the acceptedPatternTooltip and
			// return.
			String newValue = (String) event.getNewValue();
			if (newValue == null || newValue.equals("")) { //$NON-NLS-1$
				acceptedPatternTooltip = null;
				return;
			}

			boolean replace = true;
			// if the newValue contains the selectionPattern, the newValue must
			// be the new acceptedPatternTooltip.
			if (newValue.contains(ITraverseRidget.VALUE_PATTERN)) {
				acceptedPatternTooltip = newValue;
			} else if (acceptedPatternTooltip != null) {
				// test whether the normalized acceptedPatternTooltip matches
				// the newValue. If it does not, i can not be a normalized
				// patternTooltip, because the current selection of the
				// uiControl would already have been inserted in the tooltip.
				String testReplaced = replaceToolTipPattern(acceptedPatternTooltip);
				if (!testReplaced.equals(newValue)) {
					acceptedPatternTooltip = null;
				} else {
					// already replaced
					replace = false;
				}
			} else {
				acceptedPatternTooltip = null;
			}

			if (replace) {
				updateTooltipPattern();
			}
		}

		/**
		 * Updates the tooltipText of the uiControl by replacing the selection
		 * pattern.
		 */
		protected void updateTooltipPattern() {
			Control control = getUIControl();
			if (control == null) {
				return;
			}

			if (acceptedPatternTooltip != null) {
				String toolTipText = replaceToolTipPattern(acceptedPatternTooltip);
				try {
					updateMode = true;
					setToolTipText(toolTipText);
				} finally {
					updateMode = false;
				}
			}
		}
	}

	/**
	 * A helper which throws IllegalArgumentExceptions.
	 */
	protected static class Message {
		public static final String MAX_LE_MIN = "The maximum value of %d must be greater than the minimum value of %d"; //$NON-NLS-1$
		public static final String MAX_LE_ZERO = "The maximum value of %d must be greater than zero"; //$NON-NLS-1$

		public static final String MIN_GE_MAX = "The minimum value of %d must be lower than the maximum value of %d"; //$NON-NLS-1$
		public static final String MIN_LT_ZERO = "The minimum value of %d must be greater than zero"; //$NON-NLS-1$

		private String message;

		protected Message(String msgConstant, Object... attributes) {
			message = String.format(msgConstant, attributes);
		}

		protected void push() {
			throw new IllegalArgumentException(message);
		}
	}
}