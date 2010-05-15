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
package com.agritrace.edairy.desktop.ui.views;

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

public class DairyHomeView extends ViewPart {

    public static final String ID = DairyHomeView.class.getName();

    @Override
    public void createPartControl(Composite parent) {
	final Composite top = new Composite(parent, SWT.NONE);
	GridLayout layout = new GridLayout();
	layout.marginHeight = 0;
	layout.marginWidth = 0;
	top.setLayout(layout);
	// top banner
	final Composite banner = new Composite(top, SWT.NONE);
	banner.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL, GridData.VERTICAL_ALIGN_BEGINNING, true,
		false));
	layout = new GridLayout();
	layout.marginHeight = 5;
	layout.marginWidth = 10;
	layout.numColumns = 2;
	banner.setLayout(layout);

	final Font boldFont = JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT);

	Label l = new Label(banner, SWT.WRAP);
	l.setText("Welcome to eDairy Manager"); //$NON-NLS-1$
	l.setFont(boldFont);

	l = new Label(top, SWT.NONE);
	final Image backImage = ImageStore.getInstance().getImage("dairy_staff_photo.jpg");
	l.setImage(backImage);
	l.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    @Override
    public void setFocus() {
    }

}
