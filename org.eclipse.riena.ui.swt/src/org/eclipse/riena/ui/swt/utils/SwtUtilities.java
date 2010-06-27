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
package org.eclipse.riena.ui.swt.utils;

import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.widgets.Widget;

import org.eclipse.riena.core.cache.LRUHashMap;
import org.eclipse.riena.ui.swt.facades.GCFacade;

/**
 * A collection of utility methods for SWT.
 */
public final class SwtUtilities {

	private static final String THREE_DOTS = "..."; //$NON-NLS-1$
	private static final GCFacade GC_FACADE = GCFacade.getDefault();
	private static final Map<GCString, Integer> TEXT_WIDTH_CACHE = LRUHashMap.createLRUHashMap(512);

	/**
	 * This class contains only static methods. So it is not necessary to create
	 * an instance.
	 */
	private SwtUtilities() {
		throw new Error("SwtUtilities is just a container for static methods"); //$NON-NLS-1$
	}

	/**
	 * The text will be clipped, if the width of the given text is greater than
	 * the maximum width.<br>
	 * The clipped text always ends with three dots ("...").
	 * 
	 * @param gc
	 *            graphics context
	 * @param text
	 *            text
	 * @param maxWidth
	 *            maximum of the text
	 * @return truncated text
	 */
	public static String clipText(final GC gc, final String text, int maxWidth) {
		int textwidth = calcTextWidth(gc, text);
		if (textwidth <= maxWidth) {
			return text;
		}
		final int threeDotsWidth = calcTextWidth(gc, THREE_DOTS);
		final StringBuilder shortenedText = new StringBuilder(text);
		while (textwidth + threeDotsWidth > maxWidth && shortenedText.length() != 0) {
			shortenedText.setLength(shortenedText.length() - 1);
			textwidth = calcTextWidth(gc, shortenedText);
		}
		shortenedText.append(THREE_DOTS);
		return shortenedText.toString();
	}

	/**
	 * Calculates the width of the given text based on the current settings of
	 * the given graphics context.
	 * 
	 * @param gc
	 *            graphics context
	 * @param text
	 *            text
	 * @return width of text
	 */
	public static int calcTextWidth(final GC gc, final CharSequence text) {
		if (text == null) {
			return 0;
		}
		GCString lookupKey = new GCString(gc, text);
		Integer width = TEXT_WIDTH_CACHE.get(lookupKey);
		if (width == null) {
			int w = 0;
			for (int i = 0; i < text.length(); i++) {
				w += calcCharWidth(gc, text.charAt(i));
			}
			width = w;
			TEXT_WIDTH_CACHE.put(lookupKey, width);
		}
		return width;
	}

	/**
	 * Calculates the width of the given char based on the current settings of
	 * the given graphics context.
	 * 
	 * @param gc
	 *            graphics context
	 * @param ch
	 *            character
	 * @return width of character
	 */
	public static int calcCharWidth(final GC gc, char ch) {
		GCString lookupKey = new GCString(gc, Character.toString(ch));
		Integer width = TEXT_WIDTH_CACHE.get(lookupKey);
		if (width == null) {
			width = GC_FACADE.getAdvanceWidth(gc, ch);
			TEXT_WIDTH_CACHE.put(lookupKey, width);
		}
		return width;
	}

	/**
	 * Creates a new instance of <code>Color</code> that is a brighter version
	 * of the given color.
	 * 
	 * @param color
	 *            the color to make brighter.
	 * @param f
	 *            the factor.
	 * @return a new <code>Color</code> object that is a brighter version of
	 *         this given color.
	 * 
	 * @pre color != null;
	 */
	public static Color makeBrighter(final Color color, float f) {

		Assert.isNotNull(color);
		Assert.isTrue(f >= 0.0);

		float[] hsb = color.getRGB().getHSB();
		float h = hsb[0];
		float s = hsb[1];
		float b = hsb[2];

		b = b * f;
		if (b > 1.0f) {
			b = 1.0f;
		}

		RGB rgb = new RGB(h, s, b);

		return new Color(color.getDevice(), rgb);
	}

	/**
	 * Disposes the given resource, if the the resource is not null and isn't
	 * already disposed.
	 * 
	 * @param resource
	 *            resource to dispose
	 */
	public static void disposeResource(final Resource resource) {
		if (!isDisposed(resource)) {
			resource.dispose();
		}
	}

	/**
	 * Disposes the given widget, if the the widget is not {@code null} and
	 * isn't already disposed.
	 * 
	 * @param widget
	 *            widget to dispose
	 */
	public static void disposeWidget(final Widget widget) {
		if (!isDisposed(widget)) {
			widget.dispose();
		}
	}

	/**
	 * Returns {@code true}, if the given widget is disposed or {@code null}.
	 * 
	 * @param widget
	 *            widget to check
	 * @return {@code true}, if the widget is disposed or {@code null};
	 *         otherwise {@code false}.
	 */
	public static boolean isDisposed(Widget widget) {
		return widget == null || widget.isDisposed();
	}

	/**
	 * Returns {@code true}, if the given resource is disposed or {@code null}.
	 * 
	 * @param resource
	 *            resource to check
	 * @return {@code true}, if the resource is disposed or {@code null};
	 *         otherwise {@code false}.
	 */
	public static boolean isDisposed(Resource resource) {
		return !((resource != null) && (!resource.isDisposed()));
	}

	private final static class GCString {
		private final String text;
		private final FontMetrics fontMetrics;

		private GCString(GC gc, CharSequence seq) {
			this.fontMetrics = gc.getFontMetrics();
			this.text = seq.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((fontMetrics == null) ? 0 : fontMetrics.hashCode());
			result = prime * result + ((text == null) ? 0 : text.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			GCString other = (GCString) obj;
			if (fontMetrics == null) {
				if (other.fontMetrics != null) {
					return false;
				}
			} else if (!fontMetrics.equals(other.fontMetrics)) {
				return false;
			}
			if (text == null) {
				if (other.text != null) {
					return false;
				}
			} else if (!text.equals(other.text)) {
				return false;
			}
			return true;
		}

	}

}
