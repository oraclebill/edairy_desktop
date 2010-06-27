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
package org.eclipse.riena.ui.swt;

import java.beans.Beans;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.riena.core.util.ReflectionUtils;
import org.eclipse.riena.internal.ui.swt.Activator;
import org.eclipse.riena.ui.swt.facades.SWTFacade;
import org.eclipse.riena.ui.swt.lnf.ILnfRenderer;
import org.eclipse.riena.ui.swt.lnf.ILnfRendererExtension;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.lnf.renderer.AbstractTitleBarRenderer;
import org.eclipse.riena.ui.swt.lnf.renderer.DialogBorderRenderer;
import org.eclipse.riena.ui.swt.lnf.renderer.DialogTitleBarRenderer;
import org.eclipse.riena.ui.swt.lnf.rienadefault.RienaDefaultLnf;

/**
 * Provides theming & styling for jface {@link Window}s.
 * 
 * @since 1.2
 */
public class RienaWindowRenderer {

	private final Window dialog;
	private Composite centerComposite;
	private DialogTitleBarMouseListener mouseListener;
	private Composite topComposite;

	public RienaWindowRenderer(Window dialog) {
		this.dialog = dialog;

		// if we are in design time, supply default renderer
		if (Beans.isDesignTime() || Activator.getDefault() == null) {
			ILnfRendererExtension[] extensions = new ILnfRendererExtension[] {
					new LnfRendererExtension(new DialogBorderRenderer(), LnfKeyConstants.DIALOG_BORDER_RENDERER),
					new LnfRendererExtension(new DialogTitleBarRenderer(), LnfKeyConstants.DIALOG_RENDERER) };
			LnfManager.getLnf().update(extensions);
		}
	}

	/**
	 * Updates the style of the dialog shell.
	 * 
	 * @returns new style of the dialog
	 */
	public int computeShellStyle() {
		int result = getShellStyle();
		if (isHideOsBorder()) {
			if ((result & SWT.DIALOG_TRIM) == SWT.DIALOG_TRIM) {
				result &= ~SWT.DIALOG_TRIM;
			}
			result |= SWT.NO_TRIM;
		} else {
			if ((result & SWT.NO_TRIM) == SWT.NO_TRIM) {
				result &= ~SWT.NO_TRIM;
			}
			result &= ~SWT.DIALOG_TRIM;
		}
		if (isApplicationModal()) {
			result |= SWT.APPLICATION_MODAL;
		} else {
			if ((result & SWT.APPLICATION_MODAL) == SWT.APPLICATION_MODAL) {
				result &= ~SWT.APPLICATION_MODAL;
			}
		}
		if (isCloseable()) {
			result |= SWT.CLOSE;
		}
		if (isMaximizeable()) {
			result |= SWT.MAX;
		}
		if (isMinimizeable()) {
			result |= SWT.MIN;
		}
		return result;
	}

	public Control createButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridData data = new GridData();
		data.heightHint = 0;
		composite.setLayoutData(data);
		return composite;
	}

	public Control createContents(Composite parent) {
		int padding = 0;
		Composite contentsComposite = new Composite(parent, SWT.NONE);
		contentsComposite.setLayout(new FormLayout());
		if (isHideOsBorder()) {
			SWTFacade.getDefault().addPaintListener(contentsComposite, new DialogBorderPaintListener());
			padding = getBorderWidth();
		}
		contentsComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

		int titleBarHeight = 0;
		topComposite = new Composite(contentsComposite, SWT.NONE);
		if (isHideOsBorder()) {
			titleBarHeight = getTitleBarHeight();

			SWTFacade swtFacade = SWTFacade.getDefault();
			DialogTitlePaintListener titlePaintListener = new DialogTitlePaintListener(isCloseable(), isMaximizeable(),
					isMinimizeable());
			swtFacade.addPaintListener(topComposite, titlePaintListener);

			mouseListener = new DialogTitleBarMouseListener();
			topComposite.addMouseListener(mouseListener);
			swtFacade.addMouseMoveListener(topComposite, mouseListener);
			swtFacade.addMouseTrackListener(topComposite, mouseListener);
		}
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, padding);
		formData.top = new FormAttachment(0, padding);
		formData.right = new FormAttachment(100, -padding);
		formData.bottom = new FormAttachment(0, titleBarHeight);
		topComposite.setLayoutData(formData);

		centerComposite = new Composite(contentsComposite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		centerComposite.setLayout(layout);
		formData = new FormData();
		formData.left = new FormAttachment(0, padding);
		formData.top = new FormAttachment(topComposite);
		formData.right = new FormAttachment(100, -padding);
		formData.bottom = new FormAttachment(100, -padding);
		centerComposite.setLayoutData(formData);

		return contentsComposite;
	}

	public Composite getCenterComposite() {
		return centerComposite;
	}

	public void removeDialogTitleBarMouseListener() {
		if ((topComposite != null) && (mouseListener != null)) {
			topComposite.removeMouseListener(mouseListener);
			SWTFacade swtFacade = SWTFacade.getDefault();
			swtFacade.removeMouseMoveListener(topComposite, mouseListener);
			swtFacade.removeMouseTrackListener(topComposite, mouseListener);
			mouseListener.dispose();
			mouseListener = null;
		}
	}

	// helping methods
	//////////////////

	private int getBorderWidth() {
		DialogBorderRenderer borderRenderer = (DialogBorderRenderer) LnfManager.getLnf().getRenderer(
				LnfKeyConstants.DIALOG_BORDER_RENDERER);
		return borderRenderer != null ? borderRenderer.getBorderWidth() : 0;
	}

	private int getTitleBarHeight() {
		DialogTitleBarRenderer titleBarRenderer = (DialogTitleBarRenderer) LnfManager.getLnf().getRenderer(
				LnfKeyConstants.DIALOG_RENDERER);
		return titleBarRenderer != null ? titleBarRenderer.getHeight() : 0;
	}

	private boolean isApplicationModal() {
		return (getShellStyle() & SWT.APPLICATION_MODAL) == SWT.APPLICATION_MODAL;
	}

	private boolean isCloseable() {
		return (getShellStyle() & SWT.CLOSE) == SWT.CLOSE;
	}

	private boolean isHideOsBorder() {
		RienaDefaultLnf lnf = LnfManager.getLnf();
		return lnf.getBooleanSetting(LnfKeyConstants.DIALOG_HIDE_OS_BORDER);
	}

	private boolean isMinimizeable() {
		return (getShellStyle() & SWT.MIN) == SWT.MIN;
	}

	private boolean isMaximizeable() {
		return (getShellStyle() & SWT.MAX) == SWT.MAX;
	}

	private int getShellStyle() {
		return ReflectionUtils.invokeHidden(dialog, "getShellStyle", (Object[]) null); //$NON-NLS-1$
	}

	/**
	 * This listener paints the dialog (the border of the shell).
	 */
	private static final class DialogBorderPaintListener implements PaintListener {

		public void paintControl(final PaintEvent e) {
			if (e.getSource() instanceof Control) {
				final Control dialog = (Control) e.getSource();
				final Rectangle dialogBounds = dialog.getBounds();
				final Rectangle bounds = new Rectangle(0, 0, dialogBounds.width, dialogBounds.height);
				final ILnfRenderer borderRenderer = LnfManager.getLnf().getRenderer(
						LnfKeyConstants.DIALOG_BORDER_RENDERER);
				borderRenderer.setBounds(bounds);
				borderRenderer.paint(e.gc, null);
			}
		}
	}

	/**
	 * This listener paints the dialog title.
	 */
	private static final class DialogTitlePaintListener implements PaintListener {

		private final boolean canClose;
		private final boolean canMax;
		private final boolean canMin;

		DialogTitlePaintListener(boolean canClose, boolean canMax, boolean canMin) {
			this.canClose = canClose;
			this.canMax = canMax;
			this.canMin = canMin;
		}

		public void paintControl(final PaintEvent e) {
			if (e.getSource() instanceof Control) {
				final Control control = (Control) e.getSource();
				final Rectangle dialogBounds = control.getBounds();
				final DialogTitleBarRenderer renderer = (DialogTitleBarRenderer) LnfManager.getLnf().getRenderer(
						LnfKeyConstants.DIALOG_RENDERER);
				renderer.setShell(control.getShell());
				final Rectangle bounds = new Rectangle(0, 0, dialogBounds.width, renderer.getHeight());
				renderer.setBounds(bounds);
				renderer.setCloseable(canClose);
				renderer.setMaximizable(canMax);
				renderer.setMinimizable(canMin);
				renderer.paint(e.gc, control);
			}
		}
	}

	private static final class DialogTitleBarMouseListener extends AbstractTitleBarMouseListener {
		@Override
		protected AbstractTitleBarRenderer getTitleBarRenderer() {
			return (DialogTitleBarRenderer) LnfManager.getLnf().getRenderer(LnfKeyConstants.DIALOG_RENDERER);
		}

	}

}
