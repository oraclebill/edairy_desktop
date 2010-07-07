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

import org.eclipse.core.runtime.Assert;

import org.eclipse.riena.ui.ridgets.IDateTextRidget;

/**
 * Deals with insertion, deletion and replacing in segmented strings. A
 * segmented string has one or more segments of numbers separated by a single
 * separator.
 * <p>
 * Implementation note regarding valid format patterns: this class has been
 * tested with the format patterns in {@link IDateTextRidget}. For details
 * regarding the pattern format see {@link IDateTextRidget#setFormat(String).
 */
public class SegmentedString {

	/**
	 * An array holding the value of this segmented string
	 */
	private final char[] fields;
	/**
	 * An encoding of the pattern of this segmented string. 'd's stand for
	 * digits. '|'s stand for separators.
	 */
	private String pattern;

	/**
	 * Returns true if fChar is a digit (0-9).
	 */
	public static boolean isDigit(char fChar) {
		return Character.isDigit(fChar);
	}

	/**
	 * Returns true if fChar is a valid separator character.
	 * 
	 * Implementation note: be careful how you use this method. Because ' ' can
	 * be used both as a separator and as a placeholder, the results of this
	 * method must be carefully considered against the context in which this
	 * method is invoked. Example: if you know the user typed ' ' it is a
	 * separator. If you look at a ' ' value in {@code fields}, it is only a
	 * separator if the corresponding character in {@pattern} is '|'.
	 */
	public static boolean isSeparator(char fChar) {
		return ".:/- ".indexOf(fChar) != -1; //$NON-NLS-1$
	}

	/**
	 * Create a new segmented string with the given format.
	 * 
	 * @param format
	 *            a valid format String. See class javadoc for details.
	 * @throws RuntimeException
	 *             if format is not valid
	 */
	public SegmentedString(String format) {
		pattern = createPattern(format);
		fields = new char[pattern.length()];
		for (int i = 0; i < pattern.length(); i++) {
			char pChar = pattern.charAt(i);
			fields[i] = pChar != 'd' ? format.charAt(i) : ' ';
		}
	}

	/**
	 * Create a new segmented string with the given format and initial value.
	 * The initial value is not checked against the format.
	 * 
	 * @param format
	 *            a valid format String. See class javadoc for details.
	 * @param value
	 *            an initial value; non-null
	 * @throws RuntimeException
	 *             if format is not valid, or value is too long
	 */
	public SegmentedString(String format, String value) {
		pattern = createPattern(format);
		fields = new char[pattern.length()];
		String msg = String.format("Value '%s' is longer than '%s'", value, format); //$NON-NLS-1$
		Assert.isTrue(value.length() <= pattern.length(), msg);
		for (int i = 0; i < value.length(); i++) {
			fields[i] = value.charAt(i);
		}
	}

	/**
	 * Delete between {@code from} and {@code to} (inclusive) preserving
	 * separators.
	 * 
	 * @param from
	 *            0-based starting position
	 * @param to
	 *            0-based ending position (inclusive; {@code from <= to <
	 *            pattern.length})
	 * @return the new cursor position
	 * @throws RuntimeException
	 *             if {@code from} or {@code to} are not valid
	 */
	public int delete(int from, int to) {
		return delete(from, to, true);
	}

	/**
	 * Find a new cursor position, starting at caretPosition and moving in the
	 * direction of delta. While moving in either direction, it will ignore
	 * placeholder spaces (i.e. ' ' on digit positions).
	 * 
	 * @param caretPosition
	 *            the current cursor position (0 <= caretPosition <=
	 *            pattern.length)
	 * @param delta
	 *            moving direction (1 or -1)
	 * @return a new cursor position
	 * @throws RuntimeException
	 *             if delta has an illegal value.
	 */
	public int findNewCursorPosition(int caretPosition, int delta) {
		Assert.isLegal(delta == 1 || delta == -1);
		int pos = caretPosition;
		if (caretPosition + delta <= pattern.length() && caretPosition + delta >= 0) {
			pos = caretPosition + delta;
		}
		while (pos < pattern.length() && pos > -1) {
			if (pattern.charAt(pos) == '|') {
				break;
			} else if (pattern.charAt(pos) == 'd' && fields[pos] == ' ') {
				pos = pos + delta;
			} else {
				break;
			}
		}
		return pos;
	}

	/**
	 * Returns the internal representation of pattern.
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * Insert the given value at the specified index position.
	 * 
	 * @param index
	 *            a valid index (zero-based; 0 <= index < pattern.length)
	 * @param value
	 *            the String to insert. The string is expected to consist of
	 *            valid digits and separators. Insertion will silently abort
	 *            when the first invalid character is encountered.
	 * @return the cursor position after insertion
	 */
	public int insert(int index, String value) {
		int idx = index;
		boolean proceed = true;
		for (int i = 0; proceed && i < value.length(); i++) {
			char sChar = value.charAt(i);
			proceed = isDigit(sChar) || isSeparator(sChar);
			if (proceed) {
				idx = insert(idx, sChar);
			}
		}
		idx = idx + shiftSpacesLeft(idx);
		return idx;
	}

	/**
	 * Returns true if the given candidate partially matches this strings
	 * pattern.
	 * <p>
	 * A partial match is defined as: the candidate must not be longer than the
	 * pattern. Each character in the candidate must match the expected type of
	 * character in the pattern. If a digit is expected valid values are 0-9 or
	 * ' ' (placeholder). If a separator is expected the only valid value is the
	 * exact same separator.
	 * 
	 * @param candidate
	 *            a non-null String
	 */
	public boolean isValidPartialMatch(String candidate) {
		boolean result = candidate.length() <= pattern.length();
		for (int i = 0; result && i < candidate.length(); i++) {
			char cChar = candidate.charAt(i);
			char pChar = pattern.charAt(i);
			if (pChar == 'd') {
				result = isDigit(cChar) || cChar == ' ';
			} else if (pChar == '|') {
				result = isSeparator(cChar) && cChar == fields[i];
			} else {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Replace the characters between {@code from} and {@code to} by the given
	 * {@code value}.
	 * <p>
	 * Implementation note: replace will first delete between {@code from} and
	 * {@code to}. Afterwards in will insert {@code value} starting at {@code
	 * from}.
	 * 
	 * @param from
	 *            a valid starting position (zero-based; 0 <= from <
	 *            pattern.length)
	 * @param to
	 *            a valid ending position (zero-based; 0 < to < pattern.lengthl
	 *            from <= to)
	 * @param value
	 *            the String to insert. The string is expected to consist of
	 *            valid digits and separators. Insertion will silently abort
	 *            when the first invalid character is encountered.
	 * @return the cursor position after replacing
	 */
	public int replace(int from, int to, String value) {
		delete(from, to, false);
		int idx = insert(from, value);
		return idx;
	}

	/**
	 * Beautify the complete segmented string, by shifting placeholder ' ' to
	 * the leftmost position within their segment.
	 * 
	 * @param index
	 *            an index for the delta calculation (this is usually the cursor
	 *            position; 0-based; 0 < index <= pattern.length). Each shift
	 *            occuring at the right of the index will be counted. The count
	 *            will be returned as a delta.
	 * 
	 * @return a delta, indicating how many positions the index position has
	 *         shifted to the right
	 */
	public int shiftSpacesLeft(final int index) {
		int delta = 0;
		for (int i = 0; i < fields.length - 1; i++) {
			if (isDigit(fields[i]) && fields[i + 1] == ' ' && pattern.charAt(i + 1) == 'd') {
				fields[i + 1] = fields[i];
				fields[i] = ' ';
				if (index <= i + 1) {
					delta++;
				}
				if (i > 0) {
					i = i - 2;
				}
			}
		}
		return delta;
	}

	@Override
	public String toString() {
		return String.valueOf(fields);
	}

	// helping methods
	//////////////////

	private int computeCursorPositionAfterDelete(int from, int to) {
		int sepIndex = -1;
		for (int i = to; i >= from; i--) {
			if (pattern.charAt(i) == '|') {
				sepIndex = i;
			}
		}
		return sepIndex != -1 ? sepIndex : to + 1;
	}

	private String createPattern(String format) {
		StringBuilder result = new StringBuilder(format.length());
		for (int i = 0; i < format.length(); i++) {
			char fChar = format.charAt(i);
			if (isDigitPattern(fChar)) {
				result.append('d');
			} else if (isSeparator(fChar)) {
				result.append('|');
			} else {
				throw new IllegalStateException("unsupported format character: " + fChar); //$NON-NLS-1$
			}
		}
		return result.toString();
	}

	private int delete(int from, int to, boolean shift) {
		Assert.isLegal(from > -1, "'from' out of bounds: " + from); //$NON-NLS-1$
		Assert.isLegal(from <= to, String.format("'from' must be less-or-equal than 'to': %d, %d", from, to)); //$NON-NLS-1$
		Assert.isLegal(to < fields.length, "'to' out of bounds: " + to); //$NON-NLS-1$
		for (int i = from; i <= to; i++) {
			if (pattern.charAt(i) != '|') {
				fields[i] = ' ';
			}
		}
		int pos = computeCursorPositionAfterDelete(from, to);
		if (shift) {
			// for the delete operation we can ignore the value returned by
			// shiftSpacesLeft(...). The method computeCursorPositionAfterDelete
			// already returns the correct location
			shiftSpacesLeft(to);
		}
		return pos;
	}

	private int findFreePosition(int index) {
		int result = -1;
		final int pos = index < pattern.length() ? index : pattern.length() - 1;
		if (fields[pos] == ' ' && pattern.charAt(pos) == 'd') {
			result = pos;
		} else if (groupHasSpaceOnLeft(pos)) {
			shiftRight(index - 1);
			Assert.isLegal(fields[index - 1] == ' ');
			result = index - 1;
		} else if (groupHasSpaceOnRight(pos)) {
			result = pos + 1;
		}
		return result;
	}

	private void shiftRight(final int index) {
		int spacePos = -1;
		int pos = index;
		while (pos > -1 && spacePos == -1) {
			if (fields[pos] == ' ') {
				spacePos = pos;
			} else {
				pos--;
			}
		}
		String msg = String.format("did not find space in '%s' starting at %d", String.valueOf(fields), index); //$NON-NLS-1$
		Assert.isLegal(spacePos != -1, msg);
		Assert.isLegal(fields[spacePos] == ' ');
		for (int i = spacePos; i < index; i++) {
			fields[i] = fields[i + 1];
			fields[i + 1] = ' ';
		}
	}

	private boolean groupHasSpaceOnLeft(final int index) {
		boolean result = false;
		int pos = index;
		while (pos > 0 && !result) {
			result = pattern.charAt(pos - 1) == 'd' && fields[pos - 1] == ' ';
			if (pattern.charAt(pos - 1) == '|') {
				pos = -1;
			} else {
				pos--;
			}
		}
		return result;
	}

	private boolean groupHasSpaceOnRight(int index) {
		return index < pattern.length() - 1 && pattern.charAt(index) == '|' && pattern.charAt(index + 1) == 'd'
				&& fields[index + 1] == ' ';
	}

	private int insert(int index, char ch) {
		Assert.isLegal(index > -1, "index out of bounds: " + index); //$NON-NLS-1$
		Assert.isLegal(index <= fields.length, "index out of bounds: " + index); //$NON-NLS-1$
		int result = index;
		if (index < fields.length) {
			if (isSeparator(ch) && isSeparator(fields[index])) {
				result = index + 1;
			} else if (isDigit(ch)) {
				int freePosition = findFreePosition(index);
				if (freePosition != -1) {
					fields[freePosition] = ch;
					result = freePosition + 1;
				}
			}
		} else if (index == fields.length) {
			if (isDigit(ch)) {
				int freePosition = findFreePosition(index);
				if (freePosition != -1) {
					fields[freePosition] = ch;
					result = freePosition + 1;
				}
			}
		}
		return result;
	}

	private boolean isDigitPattern(char fChar) {
		return "dMyHms".indexOf(fChar) != -1; //$NON-NLS-1$
	}

}
