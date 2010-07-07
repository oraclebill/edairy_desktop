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
import org.eclipse.swt.widgets.Spinner;

import org.eclipse.riena.ui.ridgets.ISpinnerRidget;
import org.eclipse.riena.ui.ridgets.ITraverseRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;

/**
 * Ridget for a SWT {@link Spinner} widget.
 * 
 * @since 1.2
 */
public class SpinnerRidget extends AbstractTraverseRidget implements ISpinnerRidget {

	/**
	 * The maximum number of characters the spinnerRidget can hold.
	 */
	public static final int LIMIT;

	static {
		LIMIT = Spinner.LIMIT - 1;
	}

	private int textLimit;
	private int digits;

	public SpinnerRidget() {
		super();
		textLimit = Integer.MIN_VALUE;
		digits = Integer.MIN_VALUE;
	}

	@Override
	public void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Spinner.class);
	}

	public int getDigits() {
		return digits;
	}

	public int getTextLimit() {
		return textLimit;
	}

	@Override
	public Spinner getUIControl() {
		return (Spinner) super.getUIControl();
	}

	public void setDigits(int digits) {
		checkDigits(digits);

		digits = preSetDigits(digits);
		Object oldValue = this.digits;
		this.digits = digits;
		updateUIDigits();
		updateToolTip();
		firePropertyChange(ISpinnerRidget.PROPERTY_DIGITS, oldValue, this.digits);
	}

	public void setTextLimit(int textLimit) {
		checkTextLimit(textLimit);

		textLimit = preSetTextLimit(textLimit);
		Object oldValue = this.textLimit;
		this.textLimit = textLimit;
		updateUITextLimit();
		firePropertyChange(ISpinnerRidget.PROPERTY_TEXT_LIMIT, oldValue, this.textLimit);
	}

	@Override
	protected void addSelectionListener(Control control, SelectionListener listener) {
		((Spinner) control).addSelectionListener(listener);
	}

	@Override
	protected int getValue(Control control) {
		return getUIControl().getSelection();
	}

	@Override
	protected void initAdditionalsFromUIControl() {
		Spinner spinner = getUIControl();
		if (spinner != null) {
			if (getTextLimit() == Integer.MIN_VALUE) {
				setTextLimit(spinner.getTextLimit());
			}
			if (getDigits() == Integer.MIN_VALUE) {
				setDigits(spinner.getDigits());
			}
		}
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * digits requires this by java doc. <br>
	 * As a special case, it can also change the given digits.
	 * <p>
	 * See <i>'Property value adjustments'</i> in java doc of
	 * {@link #setDigits(int)}.
	 * 
	 * @param digits
	 *            the digits to set
	 * @return an adjusted digits
	 */
	protected int preSetDigits(int digits) {
		if (digits < 0) {
			digits = 0;
		}
		return digits;
	}

	/**
	 * This method changes the values of properties of this ridget, if the given
	 * textLimit requires this by java doc. <br>
	 * As a special case, it can also change the given textLimit.
	 * <p>
	 * See <i>'Property value adjustments'</i> in java doc of
	 * {@link #setTextLimit(int)}.
	 * 
	 * @param textLimit
	 *            the textLimit to set
	 * @return an adjusted textLimit
	 */
	protected int preSetTextLimit(int textLimit) {
		if (textLimit > LIMIT) {
			textLimit = LIMIT;
		}
		if (digits > textLimit) {
			setDigits(textLimit);
		}
		return textLimit;
	}

	@Override
	protected void removeSelectionListener(Control control, SelectionListener listener) {
		((Spinner) control).removeSelectionListener(listener);
	}

	@Override
	protected String replaceToolTipPattern(String toolTipTemplate) {
		if (getDigits() > 0) {
			int intSelection = getValue();
			double value = intSelection / Math.pow(10, getDigits());
			return toolTipTemplate.replace(ITraverseRidget.VALUE_PATTERN, Double.toString(value));
		} else {
			return super.replaceToolTipPattern(toolTipTemplate);
		}
	}

	/**
	 * Updates the uiControl with the values of the ridget.
	 */
	@Override
	protected void updateUIControl() {
		super.updateUIControl();
		updateUITextLimit();
		updateUIDigits();
	}

	/**
	 * Updates the digits of the uiControl with the digits of this ridget.
	 */
	protected void updateUIDigits() {
		Spinner control = getUIControl();
		if (control != null && control.getDigits() != getDigits()) {
			control.setDigits(getDigits());
		}
	}

	@Override
	protected void updateUIIncrement() {
		Spinner control = getUIControl();
		if (control != null) {
			control.setIncrement(getIncrement());
		}
	}

	@Override
	protected void updateUIMaximum() {
		Spinner control = getUIControl();
		if (control != null) {
			control.setMaximum(getMaximum());
		}
	}

	@Override
	protected void updateUIMinimum() {
		Spinner control = getUIControl();
		if (control != null) {
			control.setMinimum(getMinimum());
		}
	}

	@Override
	protected void updateUIPageIncrement() {
		Spinner control = getUIControl();
		if (control != null) {
			control.setPageIncrement(getPageIncrement());
		}
	}

	/**
	 * Updates the textLimit of the uiControl with the textLimit of this ridget.
	 */
	protected void updateUITextLimit() {
		Spinner control = getUIControl();
		if (control != null) {
			control.setTextLimit(getTextLimit());
		}
	}

	@Override
	protected void updateUIValue() {
		Spinner control = getUIControl();
		if (control != null) {
			control.setSelection(getValue());
		}
	}

	// helping methods
	// ////////////////

	/**
	 * Validates whether the digits is in the valid range.
	 * <p>
	 * See <i>'Invalid values'</i> in java doc of {@link #setDigits(int)}.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given digits is not a valid value.
	 */
	private void checkDigits(int digits) {
		if (digits > getTextLimit()) {
			new Message(Message.DIGITS_GT_TEXTLIMIT, digits, getTextLimit()).push();
		}
	}

	/**
	 * Validates whether the textLimit is in the valid range.
	 * <p>
	 * See <i>'Invalid values'</i> in java doc of {@link #setTextLimit(int)}.
	 * 
	 * @throws IllegalArgumentException
	 *             if the given textLimit is not a valid value.
	 */
	private void checkTextLimit(int textLimit) {
		if (textLimit <= 0) {
			new Message(Message.TEXTLIMIT_LE_ZERO, textLimit).push();
		}
	}

	protected static class Message extends AbstractTraverseRidget.Message {

		public static final String TEXTLIMIT_LE_ZERO = "The textLimit value of %d must be greater than zero"; //$NON-NLS-1$
		public static final String DIGITS_GT_TEXTLIMIT = "The digit value of %d must be lower or equal than the textlimit value of %d"; //$NON-NLS-1$

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