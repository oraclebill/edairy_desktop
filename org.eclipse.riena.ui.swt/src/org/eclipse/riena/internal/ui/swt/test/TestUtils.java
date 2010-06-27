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
package org.eclipse.riena.internal.ui.swt.test;

import java.text.DecimalFormatSymbols;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

import junit.framework.Assert;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.riena.ui.core.marker.IMessageMarker;
import org.eclipse.riena.ui.core.marker.MandatoryMarker;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;

/**
 * Utility class for tests.
 */
public final class TestUtils {

	private TestUtils() {
		// utility class
	}

	/**
	 * For a given Tree or Table, tests that the layouting results in
	 * correctly-calculated column widths.
	 * 
	 * @param control
	 *            the Tree or Table widget to check
	 * @param numberOfCols
	 *            the number of columns that the widget displays
	 */
	public static void assertColumnWidths(Control control, int numberOfCols) {
		final int expected = control.getSize().x / numberOfCols;
		Assert.assertTrue(String.valueOf(expected), expected > 0);

		for (int column = 0; column < numberOfCols; column++) {
			int actual = getColumnWidth(control, column);
			// take into account rounding errors, e.g. total width 85 => col widths (29, 28, 28)
			String message = String.format(
					"col %d, expected %d <= x <= %d but was %d", column, expected, (expected + 1), actual); //$NON-NLS-1$
			Assert.assertTrue(message, (expected <= actual && actual <= expected + 1));
		}
	}

	/**
	 * Asserts that the given ridget has {@code expectedCount} mandatory markers
	 * with the given {@code disabledState}.
	 * 
	 * @param ridget
	 *            never null
	 * @param expectedCount
	 *            the expected count of markers
	 * @param disabledState
	 *            the expected disabled state value
	 */
	public static void assertMandatoryMarker(IMarkableRidget ridget, int expectedCount, boolean disabledState) {
		Collection<MandatoryMarker> markers = ridget.getMarkersOfType(MandatoryMarker.class);
		Assert.assertEquals(expectedCount, markers.size());
		Iterator<MandatoryMarker> iter = markers.iterator();
		while (iter.hasNext()) {
			boolean isDisabled = iter.next().isDisabled();
			Assert.assertEquals(disabledState, isDisabled);
		}
	}

	/**
	 * Asserts that given ridget has a certain number of markers of the given
	 * type
	 * 
	 * @param ridget
	 *            a IMarkable ridget; never null
	 * @param markerType
	 *            a marker type implementing IMessageMarker
	 * @param count
	 *            the expected count; 0 or greater
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void assertMessageCount(IMarkable ridget, Class markerType, int count) {
		Collection<IMessageMarker> collection = ridget.getMarkersOfType(markerType);
		if (count != collection.size()) {
			System.out.println(String.format("assertion failed on message count -- expected %d, got %d:", count, //$NON-NLS-1$
					collection.size()));
			for (IMessageMarker messageMarker : collection) {
				System.out.println("\t" + messageMarker.getMessage()); //$NON-NLS-1$
			}
		}
		Assert.assertEquals(count, collection.size());
	}

	/**
	 * Asserts that an IMessageMarker with the given message is contained in the
	 * ridget.
	 * 
	 * @param ridget
	 *            a IMarkable ridget; never null
	 * @param markerType
	 *            a marker type implementing IMessageMarker
	 * @param message
	 *            the message to find
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void assertMessage(IMarkable ridget, Class markerType, String message) {
		Collection<IMessageMarker> collection = ridget.getMarkersOfType(markerType);
		boolean wasFound = false;
		Iterator<IMessageMarker> iter = collection.iterator();
		while (!wasFound && iter.hasNext()) {
			IMessageMarker marker = iter.next();
			wasFound = message.equals(marker.getMessage());
		}
		Assert.assertEquals(String.format("Message '%s'", message), true, wasFound); //$NON-NLS-1$
	}

	/**
	 * Asserts that in the given {@code control} the text and cursor position
	 * match the expected {@code before} value. It then applies the given key
	 * sequence and asserts that the resulting text and cursor position matches
	 * the expected {@code after} value.
	 * <p>
	 * One can use one '^' character to denote the expected cursor position, or
	 * two '^' characters to denote the expected selection.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * assertText(&quot;  &circ;.  .2008&quot;, &quot;1208&quot;, &quot;12.08&circ;.2008&quot;);
	 * </pre>
	 * 
	 * @param control
	 *            a non-null Text control
	 * @param before
	 *            the expected before value
	 * @param keySeq
	 *            a String with the characters to type
	 * @param after
	 *            the expected after value
	 */
	public static void assertText(Text control, String before, String keySeq, String after) {
		forceText(control, before);

		checkText(control, before);
		checkSelection(control, before);
		checkCaret(control, before);

		control.setFocus();
		UITestHelper.sendString(control.getDisplay(), keySeq);

		checkText(control, after);
		checkCaret(control, after);
	}

	/**
	 * Asserts that in the given {@code control} the text and cursor position
	 * match the expected {@code before} value. It then applies the given
	 * keyCode and asserts that the resulting text and cursor position matches
	 * the expected {@code after} value.
	 * <p>
	 * One can use one '^' character to denote the expected cursor position, or
	 * two '^' characters to denote the expected selection.
	 * <p>
	 * Example:
	 * 
	 * <pre>
	 * assertText(&quot;  &circ;.  .2008&quot;, &quot;1208&quot;, &quot;12.08&circ;.2008&quot;);
	 * </pre>
	 * 
	 * @param control
	 *            a non-null Text control
	 * @param before
	 *            the expected before value
	 * @param keySeq
	 *            the keyCode to type
	 * @param after
	 *            the expected after value
	 */
	public static void assertText(Text control, String before, int keyCode, String after) {
		forceText(control, before);

		checkText(control, before);
		checkSelection(control, before);
		checkCaret(control, before);

		control.setFocus();
		UITestHelper.sendKeyAction(control.getDisplay(), keyCode);

		checkText(control, after);
		checkCaret(control, after);
	}

	/**
	 * Returns true if the Arab locale ("ar_AE") is available.
	 */
	public static boolean isArabLocaleAvailable() {
		Locale arabLocale = new Locale("ar", "AE"); //$NON-NLS-1$  //$NON-NLS-2$
		for (Locale availableLocale : Locale.getAvailableLocales()) {
			if (availableLocale.equals(arabLocale)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return a localized version of a String representation of a number. The
	 * returned string will use the grouping separator and decimal separator for
	 * the current locale.
	 * <p>
	 * Examples:
	 * <ul>
	 * <li>DE - "1.234,56" -&gt; "1.234,56"</li>
	 * <li>US - "1.234,56" -&gt; "1,234.56"</li>
	 * </ul>
	 * 
	 * @param number
	 *            a String representation of a number, where '.' is used as the
	 *            grouping separator and ',' is used as the decimal separator.
	 * @return a localized String representation of a number
	 */
	public static String getLocalizedNumber(String number) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		char decimalSep = dfs.getDecimalSeparator();
		char groupingSep = dfs.getGroupingSeparator();
		String result = number.replace('.', '_').replace(',', decimalSep).replace('_', groupingSep);
		return result;
	}

	/**
	 * Print all markers in this markable.
	 */
	@SuppressWarnings("unchecked")
	public static void printMarkers(IMarkable markable) {
		Collection<IMarker> markers = (Collection<IMarker>) markable.getMarkers();
		System.out.println(String.format("Have %d markers::", markers.size())); //$NON-NLS-1$
		for (IMarker m : markers) {
			System.out.println(m.toString());
		}
	}

	// helping methods
	//////////////////

	private static void checkText(Text control, String input) {
		String expected = removePositionMarkers(input);
		Assert.assertEquals(expected, control.getText());
	}

	private static void checkSelection(Text control, String input) {
		int start = input.indexOf('^');
		int end = input.lastIndexOf('^');
		String expected = ""; //$NON-NLS-1$
		if (start < end) {
			expected = input.substring(start + 1, end);
		}
		// System.out.println("exp sel: " + expected);
		Assert.assertEquals(expected, control.getSelectionText());
	}

	private static void checkCaret(Text control, String input) {
		int start = input.indexOf('^');
		if (start != -1) {
			int end = input.lastIndexOf('^');
			int expected = start < end ? end - 1 : end;
			// System.out.println("exp car: " + expected);
			Assert.assertEquals(expected, control.getCaretPosition());
		}
	}

	private static int getColumnWidth(Control control, int colIndex) {
		if (control instanceof Tree) {
			return ((Tree) control).getColumn(colIndex).getWidth();
		} else if (control instanceof Table) {
			return ((Table) control).getColumn(colIndex).getWidth();
		}
		throw new IllegalArgumentException("unsupported control: " + control); //$NON-NLS-1$
	}

	private static String removePositionMarkers(String input) {
		StringBuilder result = new StringBuilder(input.length());
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch != '^') {
				result.append(ch);
			}
		}
		return result.toString();
	}

	private static void forceText(Text control, String text) {
		int start = text.indexOf('^');
		int end = text.lastIndexOf('^');

		Listener[] listeners = control.getListeners(SWT.Verify);
		for (Listener listener : listeners) {
			control.removeListener(SWT.Verify, listener);
		}
		control.setText(removePositionMarkers(text));
		for (Listener listener : listeners) {
			control.addListener(SWT.Verify, listener);
		}
		control.setFocus();
		if (start == end) {
			control.setSelection(start, start);
		} else {
			control.setSelection(start, end - 1);
		}
	}

}
