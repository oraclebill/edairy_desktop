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

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Slider;

import org.eclipse.riena.ui.ridgets.ISliderRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;

/**
 * Ridget for a SWT {@link Slider} widget.
 * <p>
 * <b>Note:</b> The behavior of this ridget differs from the
 * {@link TraverseRidget}, because the thumb changes the maximum <-> value
 * relation.
 * <p>
 * <b>Value ranges and automatic value adjustments:</b>
 * <p>
 * THUMB
 * <p>
 * Invalid values:
 * <ul>
 * <li><b>thumb &lt; 1:</b> The set operation will be ignored.</li>
 * <li><b>thumb &gt;= maximum - minimum:</b> The set operation will be ignored.</li>
 * </ul>
 * <p>
 * INCREMENT
 * <p>
 * It has to be greater than zero.
 * <p>
 * Automatic adjustments:
 * <ul>
 * <li><b>increment &lt;= 0:</b> The increment will be set to 1.</li>
 * <li><b>increment &gt; maximum - thumb - minimum</b> The increment will be
 * decreased to maximum - thumb - minimum.</li>
 * </ul>
 * <p>
 * MAXIMUM
 * <p>
 * It has to be equal or greater than zero.
 * <p>
 * Invalid values:
 * <ul>
 * <li><b>maximum &lt;= 0:</b> The set operation will be ignored.</li>
 * <li><b>maximum &lt;= minimum + thumb:</b> The set operation will be ignored.</li>
 * </ul>
 * Automatic adjustments:
 * <p>
 * <ul>
 * <li><b>maximum &lt; value - thumb:</b> The value will be decreased to maximum
 * thumb.</li>
 * <li><b>maximum - thumb - minimum &lt; increment:</b> See INCREMENT</li>
 * <li><b>maximum - thumb - minimum &lt; pageIncrement:</b> See PAGE INCREMENT</li>
 * </ul>
 * <p>
 * MINIMUM
 * <p>
 * Invalid values:
 * <ul>
 * <li><b>minimum &lt; 0:</b> The set operation will be ignored.</li>
 * <li><b>minimum &gt;= maximum - thumb:</b> The set operation will be ignored.</li>
 * </ul>
 * Automatic adjustments:
 * <p>
 * <ul>
 * <li><b>minimum &gt; value:</b> The value will be increased to minimum.</li>
 * <li><b>maximum - thumb - minimum &lt; increment:</b> See INCREMENT</li>
 * <li><b>maximum - thumb - minimum &lt; pageIncrement:</b> See PAGE INCREMENT</li>
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
public class SliderRidget extends AbstractTraverseRidget implements ISliderRidget {

	private int thumb;

	public SliderRidget() {
		super();
		thumb = Integer.MIN_VALUE;
	}

	@Override
	public void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Slider.class);
	}

	public int getThumb() {
		return thumb;
	}

	@Override
	public Slider getUIControl() {
		return (Slider) super.getUIControl();
	}

	public void setThumb(int thumb) {
		checkThumb(thumb);

		Object oldValue = this.thumb;
		this.thumb = thumb;
		updateUIThumb();
		firePropertyChange(ISliderRidget.PROPERTY_THUMB, oldValue, this.thumb);
	}

	@Override
	protected void addSelectionListener(Control control, SelectionListener listener) {
		((Slider) control).addSelectionListener(listener);
	}

	/**
	 * Validates whether the maximum is in the valid range.
	 * <p>
	 * 
	 * @see {@link ISliderRidget}.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given maximum is not a valid value.
	 */
	@Override
	protected void checkMaximum(int maximum) {
		if (!initialized) {
			return;
		}
		if (calcInternalMaximum(maximum) <= getMinimum()) {
			new Message(Message.MAX_LE_MIN, maximum, getThumb(), getMinimum()).push();
		}
		if (maximum <= 0) {
			new Message(Message.MAX_LE_ZERO, maximum, getThumb(), getMinimum()).push();
		}
	}

	/**
	 * Validates whether the minimum is in the valid range.
	 * <p>
	 * 
	 * @see {@link ISliderRidget}.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given minimum is not a valid value.
	 */
	@Override
	protected void checkMinimum(int minimum) {
		if (!initialized) {
			return;
		}
		if (minimum >= calcInternalMaximum()) {
			new Message(Message.MIN_GE_MAX, minimum, getMaximum(), getThumb()).push();
		}
		if (minimum < 0) {
			new Message(Message.MIN_LT_ZERO, minimum).push();
		}
	}

	/**
	 * Validates whether the thumb is in the valid range.
	 * <p>
	 * 
	 * See <i>'Invalid values'</i> in java doc of
	 * {@link ISliderRidget#setThumb(int)}.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given thumb is not a valid value.
	 */
	protected void checkThumb(int thumb) {
		if (thumb <= 0) {
			new Message(Message.THUMB_LE_ZERO, thumb).push();
		}
		if (thumb >= getMaximum() - getMinimum()) {
			new Message(Message.THUMB_GE_RANGE, thumb, getMaximum(), getMinimum()).push();
		}
	}

	@Override
	protected int getValue(Control control) {
		return getUIControl() != null ? getUIControl().getSelection() : 0;
	}

	@Override
	protected void initAdditionalsFromUIControl() {
		Slider slider = getUIControl();
		if (slider != null) {
			if (getThumb() == Integer.MIN_VALUE) {
				setThumb(slider.getThumb());
			}
		}
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * increment requires this by java doc. As a special case, it can also
	 * change the given increment.
	 * <p>
	 * See <i>'Property value adjustments'</i> in java doc of
	 * {@link ISliderRidget#setIncrement(int)}.
	 * 
	 * @param increment
	 *            the increment to set
	 * @return an adjusted increment
	 */
	@Override
	protected int preSetIncrement(int increment) {
		if (!initialized) {
			return increment;
		}
		if (increment <= 0) {
			increment = 1;
		} else if (increment > calcInternalMaximum() - getMinimum()) {
			increment = calcInternalMaximum() - getMinimum();
		}
		return increment;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * maximum requires this by java doc. As a special case, it can also change
	 * the given maximum.
	 * <p>
	 * See <i>'Property value adjustments'</i> in java doc of
	 * {@link ISliderRidget#setMaximum(int)}.
	 * 
	 * @param maximum
	 *            the maximum to set
	 * @return an adjusted maximum
	 */
	@Override
	protected int preSetMaximum(int maximum) {
		if (!initialized) {
			return maximum;
		}
		if (calcInternalMaximum(maximum) < getValue()) {
			setValue(calcInternalMaximum(maximum));
		}
		int deltaMaxMin = calcInternalMaximum(maximum) - getMinimum();
		if (deltaMaxMin < getIncrement()) {
			setIncrement(deltaMaxMin);
		}
		if (deltaMaxMin < getPageIncrement()) {
			setPageIncrement(deltaMaxMin);
		}
		return maximum;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * minimum requires this by java doc. As a special case, it can also change
	 * the given minimum.
	 * <p>
	 * See <i>'Property value adjustments'</i> in java doc of
	 * {@link ISliderRidget#setMinimum(int)}.
	 * 
	 * @param minimum
	 *            the minimum to set
	 * @return an adjusted minimum
	 */
	@Override
	protected int preSetMinimum(int minimum) {
		if (!initialized) {
			return minimum;
		}
		if (getValue() < minimum) {
			setValue(minimum);
		}
		int deltaMaxMin = calcInternalMaximum() - minimum;
		if (deltaMaxMin < getIncrement()) {
			setIncrement(deltaMaxMin);
		}
		if (deltaMaxMin < getPageIncrement()) {
			setPageIncrement(deltaMaxMin);
		}
		return minimum;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * pageIncrement requires this by java doc. As a special case, it can also
	 * change the given pageIncrement.
	 * <p>
	 * See <i>'Property value adjustments'</i> in java doc of
	 * {@link ISliderRidget#setPageIncrement(int)}.
	 * 
	 * @param pageIncrement
	 *            the pageIncrement to set
	 * @return an adjusted pageIncrement
	 */
	@Override
	protected int preSetPageIncrement(int pageIncrement) {
		if (!initialized) {
			return pageIncrement;
		}
		if (pageIncrement <= 0) {
			pageIncrement = 1;
		} else if (pageIncrement > calcInternalMaximum() - getMinimum()) {
			pageIncrement = calcInternalMaximum() - getMinimum();
		}
		return pageIncrement;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * value requires this by java doc. As a special case, it can also change
	 * the given value.
	 * <p>
	 * See <i>'Property value adjustments'</i> in java doc of
	 * {@link ISliderRidget#setValue(int)}.
	 * 
	 * @param value
	 *            the value to set
	 * @return an adjusted value
	 */
	@Override
	protected int preSetValue(int value) {
		if (!initialized) {
			return value;
		}
		if (value < 0 || value < getMinimum()) {
			value = getMinimum();
		}
		if (value > calcInternalMaximum()) {
			value = calcInternalMaximum();
		}
		return value;
	}

	@Override
	protected void removeSelectionListener(Control control, SelectionListener listener) {
		((Slider) control).removeSelectionListener(listener);
	}

	/**
	 * Updates the uiControl with the values of the ridget.
	 */
	@Override
	protected void updateUIControl() {
		updateUIMaximum();
		updateUIThumb();
		updateUIMinimum();
		updateUIIncrement();
		updateUIPageIncrement();
		updateUIValue();
	}

	@Override
	protected void updateUIIncrement() {
		Slider control = getUIControl();
		if (control != null) {
			control.setIncrement(getIncrement());
		}
	}

	@Override
	protected void updateUIMaximum() {
		Slider control = getUIControl();
		if (control != null) {
			control.setMaximum(getMaximum());
		}
	}

	@Override
	protected void updateUIMinimum() {
		Slider control = getUIControl();
		if (control != null) {
			control.setMinimum(getMinimum());
		}
	}

	@Override
	protected void updateUIPageIncrement() {
		Slider control = getUIControl();
		if (control != null) {
			control.setPageIncrement(getPageIncrement());
		}
	}

	protected void updateUIThumb() {
		Slider control = getUIControl();
		if (control != null) {
			control.setThumb(getThumb());
		}
	}

	@Override
	protected void updateUIValue() {
		Slider control = getUIControl();
		if (control != null) {
			control.setSelection(getValue());
		}
	}

	// helping methods
	// ////////////////

	/**
	 * Calculates the maximum - thumb as the internal maximum.
	 * 
	 * @return maximum - thumb
	 */
	private int calcInternalMaximum() {
		return calcInternalMaximum(getMaximum());
	}

	/**
	 * Calculates the maximum - thumb as the internal maximum.
	 * 
	 * @param maximum
	 * @return maximum - thumb
	 */
	private int calcInternalMaximum(int maximum) {
		return maximum - getThumb();
	}

	protected static class Message extends AbstractTraverseRidget.Message {

		public static final String MAX_LE_MIN = "The maximum value subtract thumb (%d - %d) must be greater than the minimum value of %d"; //$NON-NLS-1$
		public static final String MIN_GE_MAX = "The minimum value of %d must be lower than the maximum value subtract thumb (%d - %d)"; //$NON-NLS-1$
		public static final String THUMB_LE_ZERO = "The thumb value of %d must be greater than zero"; //$NON-NLS-1$
		public static final String THUMB_GE_RANGE = "The thumb value of %d must be lower than maximum subtract minimum (%d - %d)"; //$NON-NLS-1$

		/**
		 * @param msgConstant
		 * @param attributes
		 */
		public Message(String msgConstant, Object... attributes) {
			super(msgConstant, attributes);
		}

	}

	@Override
	protected int getUIControlIncrement() {
		return getUIControl().getIncrement();
	}

	@Override
	protected int getUIControlMaximum() {
		return getUIControl().getMaximum();
	}

	@Override
	protected int getUIControlMinimum() {
		return getUIControl().getMinimum();
	}

	@Override
	protected int getUIControlPageIncrement() {
		return getUIControl().getPageIncrement();
	}

	@Override
	protected int getUIControlSelection() {
		return getUIControl().getSelection();
	}

}