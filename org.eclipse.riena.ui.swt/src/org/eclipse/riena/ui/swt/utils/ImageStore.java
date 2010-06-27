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

import java.net.URL;

import org.osgi.service.log.LogService;

import org.eclipse.equinox.log.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.core.wire.InjectExtension;
import org.eclipse.riena.core.wire.Wire;
import org.eclipse.riena.internal.ui.swt.Activator;
import org.eclipse.riena.ui.core.resource.IIconManager;
import org.eclipse.riena.ui.core.resource.IconManagerProvider;
import org.eclipse.riena.ui.core.resource.IconSize;
import org.eclipse.riena.ui.core.resource.IconState;

/**
 * The ImageStore returns the images for given names. The images are loaded form
 * and cached. The ImageStore extends the images name, if a state (@see
 * {@link ImageState}) like pressed of hover is given. If the image name has no
 * file extension, the extension ".png" will be added.
 */
public final class ImageStore {

	private static final Logger LOGGER = Log4r.getLogger(Activator.getDefault(), ImageStore.class);

	private static ImageStore store;
	private static Image missingImage;
	private IImagePathExtension[] iconPathes;

	private ImageStore() {
		// utility class
	}

	/**
	 * Returns an instance (always the same) of this class.
	 * 
	 * @return instance of {@code ImageStore}
	 */
	public static synchronized ImageStore getInstance() {
		if (store == null) {
			store = new ImageStore();
			if (Activator.getDefault() != null) {
				Wire.instance(store).andStart(Activator.getDefault().getContext());
			}
		}
		return store;
	}

	/**
	 * Returns the image for the given image name and with the given file
	 * extension.
	 * 
	 * @param imageName
	 *            name (ID) of the image
	 * @param fileExtension
	 *            extension of the image file (@see ImageFileExtension)
	 * @return image or {@code null} if no image exists for the given name.
	 */
	public Image getImage(String imageName, ImageFileExtension fileExtension) {
		String fullName = getFullName(imageName, fileExtension);
		Image image = loadImage(fullName);
		if (image == null) {
			String defaultIconName = getDefaultIconMangerImageName(imageName);
			fullName = getFullName(defaultIconName, fileExtension);
			image = loadImage(fullName);
		}
		return image;
	}

	/**
	 * Uses the default icon manager to generate the icon name/ID.
	 * 
	 * @param imageName
	 *            name of the image (icon ID)
	 * @return default icon name/ID
	 */
	private String getDefaultIconMangerImageName(String imageName) {

		IIconManager iconManager = IconManagerProvider.getInstance().getIconManager();
		String name = iconManager.getName(imageName);
		IconSize size = iconManager.getSize(imageName);
		if ((size == null) || (size.getClass() != IconSize.class)) {
			size = IconSize.NONE;
		}
		IconState state = iconManager.getState(imageName);
		if ((state == null) || (state.getClass() != IconState.class)) {
			state = IconState.NORMAL;
		}

		IIconManager defaultIconManager = IconManagerProvider.getInstance().getDefaultIconManager();
		String defaultIconName = defaultIconManager.getIconID(name, size, state);

		return defaultIconName;

	}

	/**
	 * Returns the image for the given image name and given state.
	 * 
	 * @param imageName
	 *            name (ID) of the image
	 * @return image or {@code null} if no image exists for the given name.
	 */
	public Image getImage(String imageName) {
		return getImage(imageName, ImageFileExtension.PNG);
	}

	/**
	 * Returns the full name of the image.
	 * 
	 * @param imageName
	 *            name (ID) of the image
	 * @param state
	 *            state of the image (@see ImageState)
	 * @param fileExtension
	 *            extension of the image file (@see ImageFileExtension)
	 * @return full name of the image (file name).
	 */
	private String getFullName(String imageName, ImageFileExtension fileExtension) {

		if (StringUtils.isEmpty(imageName)) {
			return null;
		}

		String fullName = imageName;
		// scaling ?!?

		if (imageName.indexOf('.') < 0) {
			if (fileExtension != null) {
				fullName += "." + fileExtension.getFileNameExtension(); //$NON-NLS-1$
			}
		}

		return fullName;

	}

	/**
	 * Returns the image for the given name. If the image isn't cached, the
	 * image is loaded form the resources and stores in the cache of the {@code
	 * ImageStore}.
	 * 
	 * @param fullName
	 *            full name of the image (file name)
	 * @return image or {@code null} if no image exists for the given name.
	 */
	private synchronized Image loadImage(String fullName) {
		if (StringUtils.isEmpty(fullName)) {
			return null;
		}

		if (Activator.getDefault() == null) {
			return null;
		}

		ImageRegistry imageRegistry = Activator.getDefault().getImageRegistry();
		Image image = imageRegistry.get(fullName);
		if (image == null || image.isDisposed()) {
			ImageDescriptor descriptor = getImageDescriptor(fullName);
			if (descriptor == null) {
				return null;
			}
			imageRegistry.remove(fullName);
			imageRegistry.put(fullName, descriptor);
			image = imageRegistry.get(fullName);
		}
		return image;
	}

	/**
	 * Returns a descriptor of the image for the given name. The file of the
	 * image is searched in every given bundle + icon path. The icon paths are
	 * define via extension points.
	 * 
	 * @param fullName
	 *            full name of the image (file name)
	 * @return image descriptor or {@code null} if file does not exists.
	 */
	private ImageDescriptor getImageDescriptor(String fullName) {

		for (IImagePathExtension iconPath : iconPathes) {
			String fullPath = iconPath.getPath() + '/' + fullName;
			URL url = iconPath.getContributingBundle().getEntry(fullPath);
			if (url != null) {
				return ImageDescriptor.createFromURL(url);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("Image resource \""); //$NON-NLS-1$
		sb.append(fullName);
		sb.append("\" not found in:"); //$NON-NLS-1$

		for (IImagePathExtension iconPath : iconPathes) {
			sb.append("\n  "); //$NON-NLS-1$
			sb.append(iconPath.getContributingBundle().getLocation());
			sb.append(iconPath.getPath());
		}

		LOGGER.log(LogService.LOG_WARNING, sb.toString());
		return null;

	}

	/**
	 * Returns the missing image.
	 * 
	 * @return missing image
	 */
	public synchronized Image getMissingImage() {
		if (missingImage == null) {
			missingImage = ImageDescriptor.getMissingImageDescriptor().createImage();
		}
		return missingImage;
	}

	@InjectExtension
	public void update(IImagePathExtension[] iconPathes) {
		this.iconPathes = iconPathes;
	}

}
