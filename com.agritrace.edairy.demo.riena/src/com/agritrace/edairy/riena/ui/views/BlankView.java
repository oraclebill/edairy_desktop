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
package com.agritrace.edairy.riena.ui.views;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
import com.swtdesigner.SWTResourceManager;

public class BlankView extends ViewPart {
	public BlankView() {
	}

	public static final String ID = BlankView.class.getName(); 
	private Label l_1;

	@Override
	public void createPartControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		top.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
	}

	@Override
	public void setFocus() {
	}

}
