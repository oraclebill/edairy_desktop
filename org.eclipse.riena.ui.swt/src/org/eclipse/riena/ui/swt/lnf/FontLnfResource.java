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
package org.eclipse.riena.ui.swt.lnf;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

/**
 * Wrapper for resource font.
 */
public class FontLnfResource extends AbstractLnfResource<Font> {

	private FontData fontData;

	/**
	 * @param name
	 *            the name of the font (must not be null)
	 * @param height
	 *            the font height in points
	 * @param style
	 *            style of the font (a bit or combination of NORMAL, BOLD,
	 *            ITALIC)
	 */
	public FontLnfResource(String name, int height, int style) {
		this(new FontData(name, height, style));
	}

	/**
	 * @param font
	 *            font to wrap
	 */
	public FontLnfResource(FontData fontData) {
		super();
		this.fontData = fontData;
	}

	/**
	 * @see org.eclipse.riena.ui.swt.lnf.ILnfResource#createResource()
	 */
	public Font createResource() {
		return new Font(Display.getCurrent(), fontData);
	}

	/**
	 * Returns the font data of this font resource.
	 * 
	 * @return font data
	 * @since 1.2
	 */
	public FontData getFontData() {
		return fontData;
	}

}
