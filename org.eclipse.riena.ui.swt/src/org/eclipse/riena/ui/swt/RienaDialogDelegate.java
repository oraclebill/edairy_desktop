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

import org.eclipse.riena.internal.ui.swt.Activator;
import org.eclipse.riena.ui.swt.facades.SWTFacade;
import org.eclipse.riena.ui.swt.lnf.ILnfRenderer;
import org.eclipse.riena.ui.swt.lnf.ILnfRendererExtension;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.lnf.renderer.AbstractTitleBarRenderer;
import org.eclipse.riena.ui.swt.lnf.renderer.DialogBorderRenderer;
import org.eclipse.riena.ui.swt.lnf.renderer.DialogTitleBarRenderer;

/**
 * @deprecated use {@link RienaWindowRenderer}
 */
public class RienaDialogDelegate {

	private boolean hideOsBorder;
	private AbstractTitleBarMouseListener mouseListener;

	private boolean closeable;
	private boolean maximizeable;
	private boolean minimizeable;
	private boolean resizeable;
	private boolean applicationModal;
	private IRienaDialog dialog;
	private Composite topComposite;
	private Composite centerComposite;

	public RienaDialogDelegate(IRienaDialog dialog) {
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
	 * Evaluates the style of the shell and sets corresponding properties of the
	 * dialog.
	 */
	public void evaluateStyle() {

		int style = dialog.getShellStyle();
		setCloseable((style & SWT.CLOSE) == SWT.CLOSE);
		setMinimizeable((style & SWT.MIN) == SWT.MIN);
		setMaximizeable((style & SWT.MAX) == SWT.MAX);
		setResizeable((style & SWT.RESIZE) == SWT.RESIZE);
		setApplicationModal((style & SWT.APPLICATION_MODAL) == SWT.APPLICATION_MODAL);

	}

	public void initDialog() {
		updateDialogStyle();
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
			SWTFacade.getDefault().addPaintListener(topComposite, new DialogPaintListener());

			mouseListener = new DialogTitleBarMouseListener();
			topComposite.addMouseListener(mouseListener);
			SWTFacade.getDefault().addMouseMoveListener(topComposite, mouseListener);
			SWTFacade.getDefault().addMouseTrackListener(topComposite, mouseListener);
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

	public void setHideOsBorder(boolean hideOsBorder) {
		this.hideOsBorder = hideOsBorder;
	}

	public boolean isHideOsBorder() {
		return hideOsBorder;
	}

	public void removeDialogTitleBarMouseListener() {
		if ((topComposite != null) && (mouseListener != null)) {
			topComposite.removeMouseListener(mouseListener);
			SWTFacade.getDefault().removeMouseMoveListener(topComposite, mouseListener);
			SWTFacade.getDefault().removeMouseTrackListener(topComposite, mouseListener);
			mouseListener.dispose();
			mouseListener = null;
		}
	}

	public boolean isCloseable() {
		return closeable;
	}

	public boolean isMaximizeable() {
		return maximizeable;
	}

	public boolean isMinimizeable() {
		return minimizeable;
	}

	public boolean isResizeable() {
		return resizeable;
	}

	public boolean isApplicationModal() {
		return applicationModal;
	}

	public Composite getCenterComposite() {
		return centerComposite;
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

	private void setApplicationModal(boolean applicationModal) {
		this.applicationModal = applicationModal;
	}

	private void setCloseable(boolean closeable) {
		this.closeable = closeable;
	}

	private void setMaximizeable(boolean maximizeable) {
		this.maximizeable = maximizeable;
	}

	private void setMinimizeable(boolean minimizeable) {
		this.minimizeable = minimizeable;
	}

	private void setResizeable(boolean resizeable) {
		this.resizeable = resizeable;
	}

	/**
	 * Updates the style of the dialog shell.
	 */
	private void updateDialogStyle() {

		boolean hide = LnfManager.getLnf().getBooleanSetting(LnfKeyConstants.DIALOG_HIDE_OS_BORDER);
		setHideOsBorder(hide);

		int style = dialog.getShellStyle();
		if (isHideOsBorder()) {
			if ((style & SWT.DIALOG_TRIM) == SWT.DIALOG_TRIM) {
				style ^= SWT.DIALOG_TRIM;
			}
			style |= SWT.NO_TRIM;
		} else {
			if ((style & SWT.NO_TRIM) == SWT.NO_TRIM) {
				style ^= SWT.NO_TRIM;
			}
			style |= SWT.DIALOG_TRIM;
		}
		if (isApplicationModal()) {
			style |= SWT.APPLICATION_MODAL;
		} else {
			if ((style & SWT.APPLICATION_MODAL) == SWT.APPLICATION_MODAL) {
				style ^= SWT.APPLICATION_MODAL;
			}
		}
		dialog.setShellStyle(style);

	}

	// helping classes
	//////////////////

	/**
	 * This listener paints the dialog (the border of the shell).
	 */
	private static final class DialogBorderPaintListener implements PaintListener {

		public void paintControl(final PaintEvent e) {
			onPaint(e);
		}

		/**
		 * Paints the border of the (titleless) shell.
		 * 
		 * @param e
		 *            event
		 */
		private void onPaint(final PaintEvent e) {

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
	 * This listener paints the dialog (the border of the shell).
	 */
	private final class DialogPaintListener implements PaintListener {

		public void paintControl(final PaintEvent e) {
			onPaint(e);
		}

		/**
		 * Paints the border of the (titleless) shell.
		 * 
		 * @param e
		 *            event
		 */
		private void onPaint(final PaintEvent e) {
			if (e.getSource() instanceof Control) {

				final Control control = (Control) e.getSource();

				final Rectangle dialogBounds = control.getBounds();
				final DialogTitleBarRenderer renderer = (DialogTitleBarRenderer) LnfManager.getLnf().getRenderer(
						LnfKeyConstants.DIALOG_RENDERER);
				renderer.setShell(control.getShell());
				final Rectangle bounds = new Rectangle(0, 0, dialogBounds.width, renderer.getHeight());
				renderer.setBounds(bounds);
				renderer.setCloseable(dialog.isCloseable());
				renderer.setMaximizable(dialog.isMaximizeable());
				renderer.setMinimizable(dialog.isMinimizeable());
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
