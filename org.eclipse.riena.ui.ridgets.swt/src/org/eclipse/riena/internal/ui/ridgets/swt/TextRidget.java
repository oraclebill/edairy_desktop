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
package org.eclipse.riena.internal.ui.ridgets.swt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractEditableRidget;
import org.eclipse.riena.ui.ridgets.swt.AbstractSWTRidget;
import org.eclipse.riena.ui.ridgets.swt.MarkerSupport;
import org.eclipse.riena.ui.ridgets.validation.ValidationRuleStatus;

/**
 * Ridget for an SWT <code>Text</code> widget.
 */
public class TextRidget extends AbstractEditableRidget implements ITextRidget {

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	protected final FocusListener focusListener;
	protected final KeyListener crKeyListener;
	protected final ModifyListener modifyListener;
	protected final ValidationListener verifyListener;

	private String textValue = EMPTY_STRING;
	private boolean isDirectWriting;
	private IConverter inputConverter;

	public TextRidget() {
		crKeyListener = new CRKeyListener();
		focusListener = new FocusManager();
		modifyListener = new SyncModifyListener();
		verifyListener = new ValidationListener();
		isDirectWriting = false;
		addPropertyChangeListener(IRidget.PROPERTY_ENABLED, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				forceTextToControl(getTextInternal());
			}
		});
		addPropertyChangeListener(IMarkableRidget.PROPERTY_OUTPUT_ONLY, new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				updateEditable();
				forceTextToControl(getTextInternal());
			}
		});
	}

	protected TextRidget(String initialValue) {
		this();
		Assert.isNotNull(initialValue);
		textValue = initialValue;
	}

	@Override
	protected IObservableValue getRidgetObservable() {
		return BeansObservables.observeValue(this, ITextRidget.PROPERTY_TEXT);
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		AbstractSWTRidget.assertType(uiControl, Text.class);
	}

	/**
	 * Returns true, if the input to this method is considered 'non empty',
	 * false otherwise.
	 * <p>
	 * Subclasses may override, to provide their own notion what is considered
	 * to be an 'non empty' String value.
	 * 
	 * @param input
	 *            a String; never null
	 * @return false if the input is considered 'empty', true otherwise
	 */
	protected boolean isNotEmpty(String input) {
		return input.length() > 0;
	}

	@Override
	protected final synchronized void bindUIControl() {
		Text control = getTextWidget();
		if (control != null) {
			setUIText(getTextBasedOnMarkerState(textValue));
			updateEditable();
			addListeners(control);
		}
	}

	@Override
	protected final synchronized void unbindUIControl() {
		super.unbindUIControl();
		Text control = getTextWidget();
		if (control != null) {
			removeListeners(control);
		}
	}

	/**
	 * Template method for adding listeners to the control. Will be called
	 * automatically. Children can override but must call super.
	 * 
	 * @param control
	 *            a Text instance (never null)
	 */
	protected synchronized void addListeners(Text control) {
		control.addKeyListener(crKeyListener);
		control.addFocusListener(focusListener);
		control.addModifyListener(modifyListener);
		control.addVerifyListener(verifyListener);
	}

	/**
	 * Template method for removing listeners from the control. Will be called
	 * automatically. Children can override but must call super.
	 * 
	 * @param control
	 *            a Text instance (never null)
	 */
	protected synchronized void removeListeners(Text control) {
		control.removeKeyListener(crKeyListener);
		control.removeFocusListener(focusListener);
		control.removeModifyListener(modifyListener);
		control.removeVerifyListener(verifyListener);
	}

	/**
	 * Returns the underlying Text control.
	 * <p>
	 * Ridgets that wrap a Text widget into other UI elements, may override this
	 * method to provide access to the text widget.
	 * 
	 * @return the Text control to be used by this ridget; may be null
	 * @since 2.0
	 */
	protected Text getTextWidget() {
		return (Text) getUIControl();
	}

	protected String getUIText() {
		Text control = getTextWidget();
		Assert.isNotNull(control);
		return control.getText();
	}

	protected void updateEditable() {
		Text control = getTextWidget();
		if (control != null && !control.isDisposed()) {
			boolean isEditable = isOutputOnly() ? false : true;
			if (isEditable != control.getEditable()) {
				Color bgColor = control.getBackground();
				control.setEditable(isEditable);
				// workaround for Bug 315689 / 315691
				control.setBackground(bgColor);
			}
		}
	}

	protected void setUIText(String text) {
		Text control = getTextWidget();
		if (control != null) {
			control.setText(text);
			control.setSelection(0, 0);
		}
	}

	protected void selectAll() {
		Text text = getTextWidget();
		// if not multi line text field
		if (text != null && (text.getStyle() & SWT.MULTI) == 0) {
			text.selectAll();
		}
	}

	public synchronized String getText() {
		return textValue;
	}

	public void setInputToUIControlConverter(IConverter converter) {
		if (converter != null) {
			Assert.isLegal(converter.getFromType() == String.class,
					"Invalid from-type. Need a String-to-String converter"); //$NON-NLS-1$
			Assert.isLegal(converter.getToType() == String.class, "Invalid to-type. Need a String-to-String converter"); //$NON-NLS-1$
		}
		this.inputConverter = converter;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Invoking this method will copy the given text into the ridget and the
	 * widget regardless of the validation outcome. If the text does not pass
	 * validation the error marker will be set and the text will <b>not</b> be
	 * copied into the model. If validation passes the text will be copied into
	 * the model as well.
	 * <p>
	 * Passing a null value is equivalent to {@code setText("")}.
	 */
	public synchronized void setText(String text) {
		String oldValue = textValue;
		textValue = text != null ? text : ""; //$NON-NLS-1$
		forceTextToControl(textValue);
		disableMandatoryMarkers(isNotEmpty(textValue));
		IStatus onEdit = checkOnEditRules(textValue, new ValidationCallback(false));
		if (onEdit.isOK()) {
			firePropertyChange(ITextRidget.PROPERTY_TEXT, oldValue, textValue);
			firePropertyChange("textAfter", oldValue, textValue); //$NON-NLS-1$
		}
	}

	public synchronized boolean revalidate() {
		if (getUIControl() != null) {
			textValue = getUIText();
		}
		forceTextToControl(textValue);
		disableMandatoryMarkers(isNotEmpty(textValue));
		IStatus status = checkAllRules(textValue, new ValidationCallback(false));
		if (status.isOK()) {
			getValueBindingSupport().updateFromTarget();
		}
		return !isErrorMarked();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Invoking this method will copy the model value into the ridget and the
	 * widget regardless of the validation outcome. If the model value does not
	 * pass validation, the error marker will be set.
	 */
	@Override
	public synchronized void updateFromModel() {
		super.updateFromModel();
		checkAllRules(textValue, new ValidationCallback(false));
	}

	public synchronized boolean isDirectWriting() {
		return isDirectWriting;
	}

	public synchronized void setDirectWriting(boolean directWriting) {
		if (this.isDirectWriting != directWriting) {
			this.isDirectWriting = directWriting;
		}
	}

	@Override
	public final boolean isDisableMandatoryMarker() {
		return isNotEmpty(textValue);
	}

	// helping methods
	// ////////////////

	/**
	 * Given an input {@value} , compute an output value for the UI control,
	 * based on the current marker state. The method is called when any of the
	 * following markers changes state: output, read-only.
	 * <p>
	 * Subclasses may override, but should call super.
	 * 
	 * @since 2.0
	 */
	protected String getTextBasedOnMarkerState(String value) {
		boolean hideValue = !isEnabled() && MarkerSupport.isHideDisabledRidgetContent();
		return hideValue ? EMPTY_STRING : value;
	}

	private synchronized void forceTextToControl(String newValue) {
		Text control = getTextWidget();
		if (control != null) {
			Listener[] listeners = control.getListeners(SWT.Verify);
			for (Listener listener : listeners) {
				control.removeListener(SWT.Verify, listener);
			}
			TextRidget.this.setUIText(getTextBasedOnMarkerState(newValue));
			for (Listener listener : listeners) {
				control.addListener(SWT.Verify, listener);
			}
		}
	}

	private synchronized String getTextInternal() {
		return textValue;
	}

	private synchronized void updateTextValue() {
		String oldValue = textValue;
		String newValue = getUIText();
		if (!oldValue.equals(newValue)) {
			textValue = newValue;
			if (checkOnEditRules(newValue, null).isOK()) {
				firePropertyChange(ITextRidget.PROPERTY_TEXT, oldValue, newValue);
				firePropertyChange("textAfter", oldValue, newValue); //$NON-NLS-1$
			}
		}
	}

	private synchronized void updateTextValueWhenDirectWriting() {
		if (isDirectWriting) {
			updateTextValue();
		}
	}

	// helping classes
	// ////////////////

	/**
	 * Update text value in ridget when ENTER is pressed
	 */
	private final class CRKeyListener extends KeyAdapter implements KeyListener {
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.character == '\r') {
				updateTextValue();
			}
		}
	}

	/**
	 * Manages activities trigger by focus changed:
	 * <ol>
	 * <li>select single line text fields, when focus is gained by keyboard</li>
	 * <li>update text value in ridget, when focus is lost</li>
	 * <ol>
	 */
	private final class FocusManager implements FocusListener {
		public void focusGained(FocusEvent e) {
			if (isFocusable() && !isOutputOnly()) {
				selectAll();
			}
		}

		public void focusLost(FocusEvent e) {
			updateTextValue();
		}
	}

	/**
	 * Updates the text value in the ridget, if direct writing is enabled.
	 */
	private final class SyncModifyListener implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			updateTextValueWhenDirectWriting();
			String text = getUIText();
			disableMandatoryMarkers(isNotEmpty(text));
		}
	}

	/**
	 * Validation listener that checks 'on edit' validation rules when the text
	 * widget's contents are modified by the user. If the new text value does
	 * not pass the test and outcome is ERROR_BLOCK_WITH_FLASH, the change will
	 * be rejected. If the new text passed the test, or fails the test without
	 * blocking, the value is copied into the ridget. This will fire a proprty
	 * change event (see {@link TextRidget#setText(String)}) causing the 'on
	 * update' validation rules to be checked and will copy the value into the
	 * model if it passes those checks.
	 */
	private final class ValidationListener implements VerifyListener {

		public synchronized void verifyText(VerifyEvent e) {
			if (!e.doit) {
				return;
			}
			if (inputConverter != null) {
				e.text = (String) inputConverter.convert(e.text);
			}
			String newText = getText(e);
			IStatus status = checkOnEditRules(newText, new ValidationCallback(true));
			boolean doit = !(status.getCode() == ValidationRuleStatus.ERROR_BLOCK_WITH_FLASH);
			e.doit = doit;
		}

		private String getText(VerifyEvent e) {
			String oldText = getUIText();
			String newText;
			// deletion
			if (e.keyCode == 127 || e.keyCode == 8) {
				newText = oldText.substring(0, e.start) + oldText.substring(e.end);
			} else { // addition / replace
				newText = oldText.substring(0, e.start) + e.text + oldText.substring(e.end);
			}
			return newText;
		}
	}

}
