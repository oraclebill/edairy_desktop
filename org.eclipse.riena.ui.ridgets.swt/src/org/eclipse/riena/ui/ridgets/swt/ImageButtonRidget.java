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
package org.eclipse.riena.ui.ridgets.swt;

import org.osgi.service.log.LogService;

import org.eclipse.equinox.log.Logger;
import org.eclipse.swt.graphics.Image;

import org.eclipse.riena.core.Log4r;
import org.eclipse.riena.internal.ui.ridgets.swt.Activator;
import org.eclipse.riena.ui.core.resource.IIconManager;
import org.eclipse.riena.ui.core.resource.IconManagerProvider;
import org.eclipse.riena.ui.core.resource.IconSize;
import org.eclipse.riena.ui.core.resource.IconState;
import org.eclipse.riena.ui.swt.ImageButton;
import org.eclipse.riena.ui.swt.utils.ImageStore;

/**
 * Ridget of an {@link ImageButton} widget.
 * 
 * @since 2.0
 */
public class ImageButtonRidget extends AbstractActionRidget {

	private final static Logger LOGGER = Log4r.getLogger(Activator.getDefault(), ImageButtonRidget.class);

	private ImageButton button;

	/**
	 * {@inheritDoc}
	 * <p>
	 * 
	 * @return image button
	 */
	@Override
	public ImageButton getUIControl() {
		return (ImageButton) super.getUIControl();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Checks if the given UI control is an <code>ImageButton</code>.
	 * 
	 * @param uiControl
	 *            an image button
	 */
	@Override
	protected void checkUIControl(Object uiControl) {
		assertType(uiControl, ImageButton.class);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * An {@link ImageButton} hasn't a property "text".
	 * 
	 * @return always empty string
	 */
	@Override
	protected String getUIControlText() {
		LOGGER.log(LogService.LOG_WARNING, "The " + ImageButton.class.getSimpleName() //$NON-NLS-1$
				+ " does not support the property \"text\""); //$NON-NLS-1$
		return ""; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * An {@link ImageButton} hasn't a property "text". This method has no
	 * effect.
	 * 
	 */
	@Override
	protected void setUIControlText(String text) {
		LOGGER.log(LogService.LOG_WARNING, "The " + ImageButton.class.getSimpleName() //$NON-NLS-1$
				+ " does not support the property \"text\""); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Adds the selection listener to the button and updates the icon/image of
	 * the button.
	 */
	@Override
	protected void bindUIControl() {
		ImageButton control = getUIControl();
		if (control != null) {
			button = control;
			button.addSelectionListener(actionObserver);
			updateUIIcon();
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Removes the selection listener from the button.
	 */
	@Override
	protected void unbindUIControl() {
		super.unbindUIControl();
		if (button != null) {
			button.removeSelectionListener(actionObserver);
			button = null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setUIControlImage(Image image) {
		getUIControl().setImage(image);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * This method also updates other icons (images) e.g. disabled icon, hover
	 * icon.
	 */
	@Override
	protected void updateUIIcon() {

		super.updateUIIcon();

		ImageButton control = getUIControl();
		if (control != null) {

			IIconManager manager = IconManagerProvider.getInstance().getIconManager();
			String iconName = null;
			String iconId = getIcon();
			if (iconId != null) {
				iconName = manager.getName(iconId);
			}

			if (iconName != null) {
				IconSize size = manager.getSize(iconId);
				iconId = manager.getIconID(iconName, size, IconState.DISABLED);
				control.setDisabledImage(ImageStore.getInstance().getImage(iconId));
				iconId = manager.getIconID(iconName, size, IconState.HOVER);
				control.setHoverImage(ImageStore.getInstance().getImage(iconId));
				iconId = manager.getIconID(iconName, size, IconState.PRESSED);
				control.setPressedImage(ImageStore.getInstance().getImage(iconId));
				iconId = manager.getIconID(iconName, size, IconState.HAS_FOCUS);
				control.setFocusedImage(ImageStore.getInstance().getImage(iconId));
				iconId = manager.getIconID(iconName, size, IconState.HOVER_HAS_FOCUS);
				control.setHoverFocusedImage(ImageStore.getInstance().getImage(iconId));
			} else {
				control.setDisabledImage(null);
				control.setHoverImage(null);
				control.setPressedImage(null);
				control.setFocusedImage(null);
				control.setHoverFocusedImage(null);
			}
		}
	}

}
