/*******************************************************************************
 * Copyright (c) 2007, 2010 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Florian Pirchner - initial API and implementation
 *    
 *******************************************************************************/
package org.eclipse.riena.ui.swt.lnf;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;

/**
 * This class creates fonts with differing heights and styles for a registered
 * key. A font has to be registered in the {@link RienaDefaultLnf} for the
 * passed key. Otherwise no font can be created.
 * 
 * @since 1.2
 */
public class FontDescriptor implements ILnfFontDescriptor {

	private String key;
	private int height;
	private int style;
	private final RienaDefaultLnf lnf;

	/**
	 * @param lnf
	 *            the {@link RienaDefaultLnf} which is used to access the
	 *            fontStore.
	 */
	public FontDescriptor(RienaDefaultLnf lnf) {
		this.lnf = lnf;

		// force the height to initialize its default
		setHeight(-1);
	}

	/**
	 * @param key
	 *            the lnfKeyConstants key, whose font should be returned. See
	 *            also {@link #setKey(String)}.
	 * @param height
	 *            the height to create the font. See also
	 *            {@link #setHeight(int)}.
	 * @param style
	 *            the style to create the font. See also {@link #setStyle(int)}.
	 * @param lnf
	 *            the {@link RienaDefaultLnf} which is used to access the
	 *            fontStore.
	 */
	public FontDescriptor(String key, int height, int style, RienaDefaultLnf lnf) {
		this(lnf);
		setKey(key);
		setHeight(height);
		setStyle(style);
	}

	/**
	 * @return the key as a lnfKeyConstant.
	 */
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height < 0) {
			height = getDefaultHeight();
		}
		this.height = height;

		Assert.isLegal(this.height >= 0);
	}

	/**
	 * @return the default height of the font from the lnf by
	 *         <code>LnfKeyConstants.FONTDESCRIPTOR_DEFAULT_HEIGHT</code>.
	 */
	protected Integer getDefaultHeight() {
		return lnf.getIntegerSetting(LnfKeyConstants.FONTDESCRIPTOR_DEFAULT_HEIGHT);
	}

	/**
	 * @return the style
	 */
	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public Font getFont() {
		Font font = lnf.getFont(this.toString());
		if (font != null) {
			return font;
		} else {
			return updateFont();
		}
	}

	/**
	 * Creates a new {@link FontLnfResource} and adds it to the
	 * {@link RienaDefaultLnf}. So next time, a fontDescriptor with this key
	 * will be used to fetch the font, the cached instance will be returned.
	 * 
	 * @return the font defined by this descriptor or <code>null</code> if no
	 *         registered font can be found by the lnfKeyConstants key.
	 */
	private Font updateFont() {
		if (key == null) {
			return null;
		}

		Font font = lnf.getFont(key);
		if (font == null || font.getFontData().length == 0) {
			return null;
		}

		String fontName = font.getFontData()[0].getName();
		FontData fontData = new FontData(fontName, height, style);
		FontLnfResource fontResource = new FontLnfResource(fontData);
		lnf.putLnfResource(this.toString(), fontResource);
		return getFont();
	}

	@Override
	public String toString() {
		return "FontDescriptor [key=" + key + ", height=" + height + ", style=" + style + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}
}
