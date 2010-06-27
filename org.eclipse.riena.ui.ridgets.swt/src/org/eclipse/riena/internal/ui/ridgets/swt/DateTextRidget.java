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

import java.util.Date;
import java.util.regex.Pattern;

import com.ibm.icu.text.SimpleDateFormat;

import org.eclipse.core.databinding.BindingException;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.databinding.DateToStringConverter;
import org.eclipse.riena.ui.ridgets.databinding.StringToDateConverter;
import org.eclipse.riena.ui.ridgets.validation.ValidDate;
import org.eclipse.riena.ui.ridgets.validation.ValidIntermediateDate;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.DatePickerComposite.IDateConverterStrategy;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;

/**
 * Ridget for a 'date/time/date time' SWT <code>Text</code> widget. The desired
 * date/time/dat time pattern can be set via {@link #setFormat(String)}. See
 * {@link IDecimalTextRidget} for supported patterns.
 * 
 * @see UIControlsFactory#createTextDate(org.eclipse.swt.widgets.Composite)
 */
public class DateTextRidget extends TextRidget implements IDateTextRidget {

	/**
	 * Controls the expansion that happens when a two-digit year is entered
	 * where a four-digit year is expected. If the entered value is below * * *
	 * * {@value} , it will be prefixed with '20'. Otherwise it will be prefixed
	 * with '19'.
	 */
	private static final int Y2K_CUTOFF = 30;

	private final DateVerifyListener verifyListener;
	private final KeyListener keyListener;
	private final FocusListener focusListener;
	// private final PaintListener paintListener;

	private String pattern;
	private ValidDate validDateRule;
	private ValidIntermediateDate validIntermediateDateRule;
	private StringToDateConverter uiControlToModelconverter;
	private DateToStringConverter modelToUIControlConverter;

	public DateTextRidget() {
		verifyListener = new DateVerifyListener();
		keyListener = new DateKeyListener();
		focusListener = new DateFocusListener();
		// paintListener = new DatePaintListener();
		setFormat(IDateTextRidget.FORMAT_DDMMYYYY);
	}

	@Override
	protected void checkUIControl(Object uiControl) {
		if (null == uiControl) {
			return;
		}

		boolean isValidDatePicker = isValidType(uiControl, DatePickerComposite.class);

		if (isValidDatePicker) {
			DatePickerComposite datePicker = (DatePickerComposite) uiControl;
			datePicker.setDateConverterStrategy(new RidgetAwareDateConverterStrategy());
		}

		if ((!isValidType(uiControl, Text.class) && !isValidDatePicker)) {
			throw new BindingException(String.format("uiControl must be a '%s' or a '%s' but was a %s ", //$NON-NLS-1$
					Text.class.getSimpleName(), DatePickerComposite.class.getSimpleName(), uiControl.getClass()
							.getSimpleName()));
		}
	}

	@Override
	protected final synchronized void addListeners(Text control) {
		control.addVerifyListener(verifyListener);
		control.addKeyListener(keyListener);
		control.addFocusListener(focusListener);
		// control.addPaintListener(paintListener);
		super.addListeners(control);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The 'empty' value will be replaced with the empty string, if the ridget
	 * is in output only mode. Otherwise same behavior as super.
	 */
	@Override
	protected final String getTextBasedOnMarkerState(String value) {
		if (isOutputOnly() && !isNotEmpty(value)) {
			return ""; //$NON-NLS-1$
		}
		return super.getTextBasedOnMarkerState(value);
	}

	/**
	 * This ridget is bound to Text or DatePickerComposite controls. In the
	 * second case this method will return the Text component of the
	 * DatePickerComposite.
	 * 
	 * @return a Text widget or null
	 */
	@Override
	protected Text getTextWidget() {
		Text result;
		Control control = super.getUIControl();
		if (control instanceof DatePickerComposite) {
			result = ((DatePickerComposite) control).getTextfield();
		} else {
			result = (Text) control;
		}
		return result;
	}

	@Override
	protected final synchronized void removeListeners(Text control) {
		// control.removePaintListener(paintListener);
		control.removeFocusListener(focusListener);
		control.removeKeyListener(keyListener);
		control.removeVerifyListener(verifyListener);
		super.removeListeners(control);
	}

	@Override
	protected boolean isNotEmpty(String input) {
		boolean result = false;
		if (pattern != null) {
			String emptyString = new SegmentedString(pattern).toString();
			result = !emptyString.equals(input);
		}
		return result;
	}

	public final void setFormat(String datePattern) {
		removeValidationRule(validDateRule);
		removeValidationRule(validIntermediateDateRule);

		pattern = datePattern;
		validDateRule = new ValidDate(pattern);
		validIntermediateDateRule = new ValidIntermediateDate(pattern);
		uiControlToModelconverter = new StringToDateConverter(pattern);
		modelToUIControlConverter = new DateToStringConverter(pattern);

		addValidationRule(validDateRule, ValidationTime.ON_UPDATE_TO_MODEL);
		addValidationRule(validIntermediateDateRule, ValidationTime.ON_UI_CONTROL_EDIT);
		setUIControlToModelConverter(uiControlToModelconverter);
		setModelToUIControlConverter(modelToUIControlConverter);
		getValueBindingSupport().rebindToModel();

		boolean isBound = getValueBindingSupport().getModelObservable() != null;
		if (isBound && getValueBindingSupport().getModelObservable().getValueType() == Date.class) {
			updateFromModel();
		} else {
			setText(new SegmentedString(pattern).toString()); // clear
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * @throws RuntimeException
	 *             if {code text} does not (partially) match the specified
	 *             format pattern. A partial match is any string that has digits
	 *             and separators in the expected places - as defined by the
	 *             format pattern - regardless of limits for a certain group
	 *             (i.e. month <= 12 etc.). For example, assuming the format
	 *             pattern is 'dd.MM.yyyy', all of the following values are
	 *             valid: "", "12", "12.10", "47.11", "12.10.20", "12.10.2008",
	 *             "  .  .    ", "  .10". Invalid values would be: null, "abc",
	 *             "12.ab", "12122008", "12/12/2008"
	 */
	@Override
	public synchronized void setText(String text) {
		String newText = checkAndFormatValue(text);
		super.setText(newText);
	}

	// helping methods
	//////////////////

	private boolean isValidType(Object uiControl, Class<?> type) {
		return ((uiControl != null) && (type.isAssignableFrom(uiControl.getClass())));
	}

	private String checkAndFormatValue(String text) {
		SegmentedString ss = new SegmentedString(pattern);
		if (text != null) {
			if (!ss.isValidPartialMatch(text)) {
				String msg = String.format("'%s' is no partial match for '%s'", text, pattern); //$NON-NLS-1$
				throw new IllegalArgumentException(msg);
			}
			ss.insert(0, text);
		}
		return ss.toString();
	}

	private String computeAutoFill(String input) {
		String result = null;
		int index = pattern.lastIndexOf("yyyy"); //$NON-NLS-1$
		if (index != -1 && pattern.length() == input.length()) {
			String yyyy = input.substring(index, index + 4);
			if (Pattern.matches("  \\d\\d", yyyy)) { //$NON-NLS-1$
				String yy = yyyy.substring(2);
				if (Integer.parseInt(yy) < Y2K_CUTOFF) {
					yyyy = "20" + yy; //$NON-NLS-1$
				} else {
					yyyy = "19" + yy; //$NON-NLS-1$
				}
				result = input.substring(0, index) + yyyy + input.substring(index + 4);
			}
		}
		return result;
	}

	private synchronized void forceTextToControl(Text control, String text) {
		verifyListener.setEnabled(false);
		control.setText(text);
		verifyListener.setEnabled(true);
	}

	// helping classes
	//////////////////

	/**
	 * A {@link IDateConverterStrategy} that uses the current
	 * modelToUIControlConverter and uiControlToModelconverter for conversion
	 * between {@link String} and {@link Date}
	 * 
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	public final class RidgetAwareDateConverterStrategy implements IDateConverterStrategy {
		/*
		 * The dates given are in the local timezone, so that why we use the
		 * SimpleDateFormat instead of the DateToStringConverter /
		 * StringToDateConverter
		 */
		public void setDateToTextField(Date date) {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			String text = format.format(date);
			setText(text);
		}

		public Date getDateFromTextField(String dateString) {
			Date result;
			try {
				SimpleDateFormat format = new SimpleDateFormat(pattern);
				result = format.parse(dateString);
			} catch (Exception exc) {
				result = null; // dateString not parseable, fallback: null
			}
			return result;
		}
	}

	/**
	 * This listener handles addition, deletion and replacement of text in the
	 * Text control. When the text in the control is modified, it will compute
	 * the new value. Unsupported modifications will be cancelled.
	 */
	private final class DateVerifyListener implements VerifyListener {

		private volatile boolean isEnabled = true;

		public void setEnabled(boolean isEnabled) {
			this.isEnabled = isEnabled;
		}

		public void verifyText(VerifyEvent e) {
			if (!e.doit || !isEnabled) {
				return;
			}
			Text control = (Text) e.widget;
			String oldText = control.getText();

			int oldPos = control.getCaretPosition();
			int newPos = -1;
			SegmentedString ss = new SegmentedString(pattern, oldText);
			if (e.character == '\b' || e.keyCode == 127) {// backspace, del
				newPos = ss.delete(e.start, e.end - 1);
				if (newPos == -1) {
					newPos = e.character == '\b' ? e.start : e.end;
				}
			} else if (SegmentedString.isDigit(e.character)) {
				if (e.end - e.start > 0) {
					newPos = ss.replace(e.start, e.end - 1, e.text);
				} else {
					newPos = ss.insert(e.start, String.valueOf(e.character));
				}
			} else if (SegmentedString.isSeparator(e.character)) {
				if (e.end - e.start > 0) {
					newPos = ss.replace(e.start, e.end - 1, String.valueOf(e.character));
				} else {
					newPos = ss.insert(e.start, String.valueOf(e.character));
				}
			}
			e.doit = false;
			if (newPos != -1) {
				forceTextToControl(control, ss.toString());
				control.setSelection(newPos);
				// System.out.println("newPos: " + newPos);
				if (newPos == oldPos && oldText.equals(ss.toString())) {
					flash();
				}
			} else {
				flash();
			}
		}
	}

	/**
	 * This listener controls which key strokes are allowed by the text control.
	 * Additionally some keystrokes replaced with special behavior. Currently
	 * those key strokes are:
	 * <ol>
	 * <ol>
	 * <li>Left & Right arrow - will jump over separators and spaces</li>
	 * <li>
	 * Delete / Backspace at a single separator - will jump to the next valid
	 * location in the same direction</li>
	 * <li>Shift - disables jumping over grouping separators when pressed down</li>
	 * </ol>
	 */
	private final class DateKeyListener extends KeyAdapter {

		private boolean shiftDown = false;

		@Override
		public void keyReleased(KeyEvent e) {
			if (131072 == e.keyCode) {
				shiftDown = false;
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			Text control = (Text) e.widget;
			if (131072 == e.keyCode) {
				shiftDown = true;
			} else {
				final String text = control.getText();
				final int caret = control.getCaretPosition();
				final int selectionCount = control.getSelectionCount();
				if (16777219 == e.keyCode && selectionCount == 0 && !shiftDown) {// left arrow
					e.doit = false;
					SegmentedString ss = new SegmentedString(pattern, text);
					int index = ss.findNewCursorPosition(caret, -1);
					control.setSelection(index);
				} else if (16777220 == e.keyCode && selectionCount == 0 && !shiftDown) { //right arrow
					e.doit = false;
					SegmentedString ss = new SegmentedString(pattern, text);
					int index = ss.findNewCursorPosition(caret, 1);
					control.setSelection(index);
				} else if (127 == e.keyCode && selectionCount == 0 && !shiftDown) {
					// delete on the left of a separator; no selection
					if (caret < text.length() && SegmentedString.isSeparator(text.charAt(caret))) {
						e.doit = false;
						SegmentedString ss = new SegmentedString(pattern, text);
						int index = ss.findNewCursorPosition(caret, 1);
						// if index (right) is a digit, delete
						if (index < text.length() && SegmentedString.isDigit(text.charAt(index))) {
							ss.delete(caret, index);
							forceTextToControl(control, ss.toString());
							index++;
						}
						control.setSelection(index);
					}
				} else if ('\b' == e.character && selectionCount == 0 && !shiftDown) {
					// backspace on the right of a separator; no selection
					if (caret > 0 && SegmentedString.isSeparator(text.charAt(caret - 1))) {
						e.doit = false;
						SegmentedString ss = new SegmentedString(pattern, text);
						int index = ss.findNewCursorPosition(caret, -1);
						// if index (left) is a digit, delete
						if (index > 0 && SegmentedString.isDigit(text.charAt(index - 1))) {
							ss.delete(index - 1, caret - 1);
							forceTextToControl(control, ss.toString());
						}
						control.setSelection(index);
					}
				}
			}
		}
	}

	/**
	 * For date ridgets with a four-digit-year segment, this focus listener will
	 * try to expand two-digit-years into four-digit years.
	 */
	private final class DateFocusListener extends FocusAdapter {
		@Override
		public void focusLost(FocusEvent e) {
			Text control = (Text) e.widget;
			String autoFill = computeAutoFill(control.getText());
			if (autoFill != null) {
				forceTextToControl(control, autoFill);
			}
		}
	}

	// disabled for 1.0 - fixes bug 261291
	//	/**
	//	 * For proportional fonts (example: Arial, Helvetice, Verdana), this paint
	//	 * listener will try to align separators by adding whitespace as necessary.
	//	 * The goal to make ' . . ' appears to have the same width as '88.88.8888'
	//	 * even with a proportional font.
	//	 */
	//	private static final class DatePaintListener implements PaintListener {
	//
	//		private Font font;
	//		private int widthEight;
	//		private int widthSpace;
	//
	//		public void paintControl(PaintEvent e) {
	//			Text control = (Text) e.widget;
	//			if (control.isFocusControl() || control.isDisposed()) {
	//				return;
	//			}
	//			GC gc = e.gc;
	//			updateWidths(gc);
	//			if (widthEight == widthSpace) { // no padding necessary
	//				return;
	//			}
	//			Point size = control.getSize();
	//			Rectangle clientArea = control.getClientArea();
	//			String text = getPaddedText(control.getText());
	//			Point textExt = gc.stringExtent(text);
	//			int delta = Math.max(0, 2 * (size.x - clientArea.width));
	//			int x = size.x - delta - textExt.x;
	//			gc.fillRectangle(0, 0, size.x, size.y);
	//			gc.drawString(text, x, 1);
	//		}
	//
	//		// helping methods
	//		//////////////////
	//
	//		/**
	//		 * Update the stored widths of the '8' and ' ' characters, if the font
	//		 * has changed.
	//		 */
	//		private void updateWidths(GC gc) {
	//			Font font = gc.getFont();
	//			if (this.font != font) {
	//				this.font = font;
	//				widthEight = gc.getAdvanceWidth('8');
	//				widthSpace = gc.getAdvanceWidth(' ');
	//				// System.out.println("8= " + widthEight + " sp= " + widthSpace);
	//			}
	//		}
	//
	//		/**
	//		 * Replace single space characters with several spaces in order to match
	//		 * the width of a regular character.
	//		 */
	//		private String getPaddedText(String input) {
	//			StringBuilder result = new StringBuilder(input.length());
	//			for (int i = 0; i < input.length(); i++) {
	//				char ch = input.charAt(i);
	//				if (ch == ' ') {
	//					int lookAhead = computeLookAhead(input, i);
	//					int numChars = 1 + lookAhead;
	//					int width = widthEight * numChars;
	//					while (width >= widthSpace) {
	//						width = width - widthSpace;
	//						result.append(' ');
	//					}
	//					i = i + lookAhead;
	//				} else {
	//					result.append(ch);
	//				}
	//			}
	//			return result.toString();
	//		}
	//
	//		/**
	//		 * Returns the number of space ' ' characters after the start position.
	//		 */
	//		private int computeLookAhead(String text, int start) {
	//			int result = 0;
	//			for (int i = start + 1; i < text.length(); i++) {
	//				if (text.charAt(i) == ' ') {
	//					result++;
	//				} else {
	//					return result;
	//				}
	//			}
	//			return result;
	//		}
	//	}
}
