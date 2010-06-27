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

import org.eclipse.swt.graphics.Image;

import org.eclipse.riena.ui.swt.utils.ImageStore;

/**
 * Wrapper for resource image.
 */
public class ImageLnfResource extends AbstractLnfResource<Image> {

	private String imagePath;

	/**
	 * @param image
	 *            image to wrap
	 */
	public ImageLnfResource(String imagePath) {
		super();
		this.imagePath = imagePath;
	}

	/**
	 * @see org.eclipse.riena.ui.swt.lnf.ILnfResource#createResource()
	 */
	public Image createResource() {
		return ImageStore.getInstance().getImage(imagePath);
	}

	/**
	 * @return ImagePath that was used to create the ImageLnfResource
	 */
	public String getImagePath() {
		return imagePath;
	}

}
