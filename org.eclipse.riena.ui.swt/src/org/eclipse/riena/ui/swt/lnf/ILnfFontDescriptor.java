/*******************************************************************************
 * Copyright (c) 2007, 2009 compeople AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Florian Pirchner - initial API and implementation
 *******************************************************************************/
package org.eclipse.riena.ui.swt.lnf;

import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;

/**
 * Instances of the class create fonts with differing heights and styles for a
 * registered fontKey. A font has to be registered in the
 * {@link RienaDefaultLnf} for the key. Otherwise no font can be created.
 * 
 * @since 1.2
 */
public interface ILnfFontDescriptor {

	/**
	 * Sets the key as a lnfKey. For the passed key a font has to be registered
	 * in the {@link RienaDefaultLnf}. Otherwise, this fontDescriptor can not
	 * create a new font.
	 * 
	 * @param key
	 *            key whose associated font is to be returned.
	 */
	void setKey(String key);

	/**
	 * Sets the height of the font.<br>
	 * If the height is < 0, the
	 * <code>LnfKeyConstants.FONTDESCRIPTOR_DEFAULT_HEIGHT</code> will be used.<br>
	 * This height will be used for the creation of the font.<br>
	 * See also {@link FontData#setHeight(int)}.
	 * 
	 * @param height
	 *            the height to use for the font.
	 */
	void setHeight(int height);

	/**
	 * Sets the style of the font.<br>
	 * This style will be used for the creation of the font. <br>
	 * See also {@link FontData#setStyle(int)}.
	 * 
	 * @param style
	 *            the style to use for the font.
	 */
	void setStyle(int style);

	/**
	 * Returns the font described by this descriptor. If no shared instance
	 * exists, a new instance will be created and added to the
	 * {@link RienaDefaultLnf}. If an equal fontDescriptor is used again, the
	 * font will be returned from the cache.
	 * 
	 * @return the font described by this descriptor or <code>null</code> if no
	 *         registered font can be found by the lnfKeyConstants key.
	 */
	Font getFont();

}
