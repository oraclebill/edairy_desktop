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

/**
 * File extensions of image (file) names.
 */
public enum ImageFileExtension {

	PNG("png"), //$NON-NLS-1$
	GIF("gif"), //$NON-NLS-1$
	JPG("jpg"); //$NON-NLS-1$

	private String fileNameExtension;

	private ImageFileExtension(String fileNameExtension) {
		this.fileNameExtension = fileNameExtension;
	}

	/**
	 * Returns file name extension.
	 * 
	 * @return extension of file name.
	 */
	public String getFileNameExtension() {
		return fileNameExtension;
	}

}
