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

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * A dialog with an own renderer for the border and the title bar.
 * 
 * @deprecated use AbstractDialogView
 */
public class RienaDialog extends Dialog implements IRienaDialog {

	private RienaDialogDelegate dlgDelegate;

	/**
	 * Creates a new instance of {@code RienaDialog}.
	 * 
	 * @param shell
	 *            the parent shell
	 */
	public RienaDialog(Shell shell) {
		super(shell);
		dlgDelegate = new RienaDialogDelegate(this);
		dlgDelegate.evaluateStyle();
	}

	@Override
	public void create() {
		dlgDelegate.initDialog();
		super.create();
	}

	@Override
	protected Control createContents(Composite parent) {

		Control contentsComposite = dlgDelegate.createContents(parent);
		super.createContents(dlgDelegate.getCenterComposite());
		return contentsComposite;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridData data = new GridData();
		data.heightHint = 0;
		composite.setLayoutData(data);
		return composite;
	}

	@Override
	public boolean close() {
		dlgDelegate.removeDialogTitleBarMouseListener();
		return super.close();
	}

	@Override
	public int getShellStyle() {
		return super.getShellStyle();
	}

	@Override
	public void setShellStyle(int newShellStyle) {
		super.setShellStyle(newShellStyle);
	}

	public void setHideOsBorder(boolean hideOsBorder) {
		dlgDelegate.setHideOsBorder(hideOsBorder);
	}

	public boolean isHideOsBorder() {
		return dlgDelegate.isHideOsBorder();
	}

	public boolean isCloseable() {
		return dlgDelegate.isCloseable();
	}

	public boolean isMaximizeable() {
		return dlgDelegate.isMaximizeable();
	}

	public boolean isMinimizeable() {
		return dlgDelegate.isMinimizeable();
	}

	public boolean isResizeable() {
		return dlgDelegate.isResizeable();
	}

	public boolean isApplicationModal() {
		return dlgDelegate.isApplicationModal();
	}

}