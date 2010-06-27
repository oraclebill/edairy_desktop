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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * A dialog for showing messages and with an own renderer for the border and the
 * title bar.
 */
public class RienaMessageDialog extends MessageDialog {

	private final RienaWindowRenderer dlgRenderer;

	/**
	 * Creates a Riena message dialog.
	 * 
	 * @param parentShell
	 *            the parent shell
	 * @param dialogTitle
	 *            the dialog title, or <code>null</code> if none
	 * @param dialogTitleImage
	 *            the dialog title image, or <code>null</code> if none
	 * @param dialogMessage
	 *            the dialog message
	 * @param dialogImageType
	 *            one of the following values:
	 *            <ul>
	 *            <li><code>MessageDialog.NONE</code> for a dialog with no image
	 *            </li>
	 *            <li><code>MessageDialog.ERROR</code> for a dialog with an
	 *            error image</li>
	 *            <li><code>MessageDialog.INFORMATION</code> for a dialog with
	 *            an information image</li>
	 *            <li><code>MessageDialog.QUESTION </code> for a dialog with a
	 *            question image</li>
	 *            <li><code>MessageDialog.WARNING</code> for a dialog with a
	 *            warning image</li>
	 *            </ul>
	 * @param dialogButtonLabels
	 *            an array of labels for the buttons in the button bar
	 * @param defaultIndex
	 *            the index in the button label array of the default button
	 * 
	 * @see {@link MessageDialog#MessageDialog(Shell, String, Image, String, int, String[], int)}
	 */
	public RienaMessageDialog(Shell parentShell, String dialogTitle, Image dialogTitleImage, String dialogMessage,
			int dialogImageType, String[] dialogButtonLabels, int defaultIndex) {
		super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, dialogButtonLabels,
				defaultIndex);
		dlgRenderer = new RienaWindowRenderer(this);
	}

	/**
	 * Create the dialog area and the button bar for the receiver.
	 * 
	 * @param parent
	 */
	@Override
	protected void createDialogAndButtonArea(Composite parent) {

		// create the contents area
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.horizontalSpacing = 0;
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		parent.setLayout(gridLayout);
		dlgRenderer.createContents(parent);

		// create the dialog area and button bar
		Composite centerComposite = dlgRenderer.getCenterComposite();
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.horizontalSpacing = LayoutConstants.getSpacing().x * 2;
		gridLayout.verticalSpacing = LayoutConstants.getSpacing().y;
		gridLayout.marginWidth = LayoutConstants.getMargins().x;
		gridLayout.marginHeight = LayoutConstants.getMargins().y;
		centerComposite.setLayout(gridLayout);
		dialogArea = createDialogArea(centerComposite);
		buttonBar = createButtonBar(centerComposite);

		// Apply to the parent so that the message gets it too.
		applyDialogFont(parent);

	}

	@Override
	public void create() {
		// compute the 'styled' shell style, before creating the shell
		setShellStyle(dlgRenderer.computeShellStyle());
		super.create();
	}

}
