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

import java.text.DecimalFormatSymbols;

import org.eclipse.core.runtime.Assert;

/**
 * Deals with manipulation of numeric strings.
 * <p>
 * A numeric string consists of several digits, thay may or may not be separated
 * by grouping separators (groups of 3 digits). The string may contain a decimal
 * separator, followed by a fractional part of 0 to <i>n</i> digits. Grouping
 * and decimal separator must conform to the current locale. Negative values may
 * be prefixed by a '-' character.
 * <p>
 * Examples:
 * <ul>
 * <li>DE - valid strings: "1.234,56" / "1234,56" / "1234" / "1.234" / "1234," /
 * "1.234,"</li>
 * <li>US - valid strings: "1,234.56" / "1234.56" / "1234" / "1,234" / "1234." /
 * "1,234."</li>
 * </ul>
 * 
 * @see DecimalFormatSymbols#getDecimalSeparator()
 */
public class NumericString {

	private Digit start;
	private final boolean isGrouping;

	/**
	 * Create a new instnace
	 * 
	 * @param value
	 *            the non-null value of this string. See class javadoc for
	 *            accepted formats
	 * @param isGrouping
	 *            true, if a grouping separator should be used, false otherwise.
	 *            Grouping separators will automatically be added to the value
	 *            argument, if necessary.
	 */
	public NumericString(String value, boolean isGrouping) {
		Assert.isNotNull(value);
		if (value.length() > 0) {
			Digit prev = null;
			for (int i = 0; i < value.length(); i++) {
				char ch = value.charAt(i);
				prev = new Digit(ch, prev);
				if (i == 0) {
					start = prev;
				}
			}
		}
		this.isGrouping = isGrouping;
		if (isGrouping) {
			applyGrouping();
		}
	}

	/**
	 * Deletes between {@code from} and {@code to} (exclusive) preserving
	 * separators.
	 * 
	 * @param from
	 *            0-based starting position
	 * @param to
	 *            0-based ending position (exclusive; {@code from < to <=
	 *            pattern.length})
	 * @return the new cursor position
	 * @throws RuntimeException
	 *             if {@code from} or {@code to} are not valid
	 */
	public int delete(int from, int to, char ch) {
		Assert.isLegal(-1 < from);
		Assert.isLegal(from < to);
		final int delta = '\b' == ch ? -1 : 1;
		if (to - from == 1) {
			Digit fromDigit = findDigit(from);
			fromDigit.delete(delta);
		} else {
			Digit fromDigit = findDigit(from);
			Digit toDigitExcl = findDigit(to);
			boolean endsWithSep = toDigitExcl != null && toDigitExcl.prev != null
					&& toDigitExcl.prev.isDecimalSeparator();
			fromDigit.delete(toDigitExcl);
			if (endsWithSep && toDigitExcl.prev != null) {
				toDigitExcl.prev.setCursorBefore();
			} else if (toDigitExcl != null) {
				toDigitExcl.setCursorBefore();
			} else {
				Digit lastDigit = getLastDigit();
				if (lastDigit != null && lastDigit == start && lastDigit.isDecimalSeparator()) {
					lastDigit.setCursorBefore();
				} else if (lastDigit != null) {
					lastDigit.setCursorAfter();
				}
			}
		}
		applyGrouping();
		return getCursorLocation();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if (start != null) {
			Digit current = start;
			while (current != null) {
				result.append(current.toString());
				current = current.next;
			}
		}
		return result.toString();
	}

	// helping methods
	//////////////////

	private void applyGrouping() {
		if (!isGrouping) {
			return;
		}
		Digit here = start;
		while (here != null) {
			if (here.isGroupingSeparator()) {
				here.deleteThis();
			}
			here = here.next;
		}
		Digit decSep = null;
		Digit lastDigit = null;
		here = start;
		while (decSep == null && here != null) {
			if (here.isDecimalSeparator()) {
				decSep = here;
			}
			if (here.next == null) {
				lastDigit = here;
			}
			here = here.next;
		}
		Digit firstDigit = decSep != null ? decSep.prev : lastDigit;
		int i = 2;
		while (firstDigit != null) {
			if (i == 0 && firstDigit.prev != null && Character.isDigit(firstDigit.prev.ch)) {
				Digit sep = new Digit(NumericTextRidget.GROUPING_SEPARATOR, null);
				sep.next = firstDigit;
				sep.prev = firstDigit.prev;
				firstDigit.prev.next = sep;
				firstDigit.prev = sep;
				i = 4;

			}
			i--;
			firstDigit = firstDigit.prev;
		}
	}

	private int getCursorLocation() {
		int result = start == null ? 0 : -1;
		Digit here = start;
		int index = 0;
		while (result == -1 && here != null) {
			if (here.isCursorBeforeMe()) {
				result = index;
			} else if (here.isCursorAfterMe()) {
				result = index + 1;
			}
			index++;
			here = here.next;
		}
		return result;
	}

	private Digit getLastDigit() {
		Digit result = start;
		while (result != null && result.next != null) {
			result = result.next;
		}
		return result;
	}

	private Digit findDigit(final int index) {
		Digit result = null;
		Digit here = start;
		int count = index;
		while (here != null && count >= 0) {
			if (count == 0) {
				result = here;
			}
			here = here.next;
			count--;
		}
		return result;
	}

	// helping classes
	//////////////////

	private final class Digit {

		private final char ch;
		private boolean cursorAfterMe;
		private boolean cursorBeforeMe;
		private Digit prev;
		private Digit next;

		public Digit(char ch, Digit prev) {
			this.ch = ch;
			this.prev = prev;
			if (prev != null) {
				prev.next = this;
			}
		}

		public void deleteThis() {
			if (prev != null) {
				prev.next = next;
			}
			if (next != null) {
				next.prev = prev;
			}
			if (prev == null) {
				start = next;
			}
			if (cursorAfterMe) {
				if (next != null) {
					next.setCursorBefore();
				} else if (prev != null) {
					prev.setCursorAfter();
				}
			}
			if (cursorBeforeMe) {
				if (prev != null) {
					prev.setCursorAfter();
				} else if (next != null) {
					next.setCursorBefore();
				}
			}
		}

		public void delete(int delta) {
			Assert.isLegal(delta == -1 || delta == 1);
			if (isSeparator()) {
				if (delta == -1) {
					if (prev != null) {
						prev.delete(delta);
					} else {
						this.setCursorBefore();
					}
				} else if (delta == 1) {
					if (next != null) {
						next.delete(delta);
					} else {
						this.setCursorAfter();
					}
				}
			} else {
				deleteThis();
				if (prev != null) {
					prev.setCursorAfter();
				} else if (next != null) {
					next.setCursorBefore();
				}
			}
		}

		public void delete(Digit end) {
			if (this != end) {
				boolean hasPrev = this.prev != null;
				boolean hasNext = this.next != null;
				if (!isDecimalSeparator()) {
					if (hasPrev) {
						this.prev.next = this.next;
					} else {
						start = this.next;
					}
					if (hasNext) {
						this.next.prev = this.prev;
					}
				}
				if (hasNext) {
					this.next.delete(end);
				}
			}
		}

		public boolean isCursorAfterMe() {
			return cursorAfterMe;
		}

		public boolean isCursorBeforeMe() {
			return cursorBeforeMe;
		}

		public boolean isSeparator() {
			return isDecimalSeparator() || isGroupingSeparator();
		}

		public boolean isDecimalSeparator() {
			return NumericTextRidget.DECIMAL_SEPARATOR == ch;
		}

		public boolean isGroupingSeparator() {
			return NumericTextRidget.GROUPING_SEPARATOR == ch;
		}

		public void setCursorAfter() {
			resetCursorLocation();
			cursorAfterMe = true;
			if (next != null) {
				next.cursorBeforeMe = true;
			}
		}

		public void setCursorBefore() {
			resetCursorLocation();
			cursorBeforeMe = true;
			if (prev != null) {
				prev.cursorAfterMe = true;
			}
		}

		@Override
		public String toString() {
			return String.valueOf(ch);
		}

		private void resetCursorLocation() {
			Digit p = this;
			while (p != null) {
				p.cursorAfterMe = false;
				p.cursorBeforeMe = false;
				p = p.prev;
			}
			Digit n = this.next;
			while (n != null) {
				n.cursorAfterMe = false;
				n.cursorBeforeMe = false;
				n = n.next;
			}
		}

	};

}
