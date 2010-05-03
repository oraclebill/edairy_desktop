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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class FacilityInfoView extends ViewPart {

	public static final String ID = "com.agritrace.edairy.demo.riena.views.FacilityInfoView"; //$NON-NLS-1$

	@Override
	public void createPartControl(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		top.setLayout(new FormLayout());

		Text txtName;
		Text txtId;
		Text txtLicense;
		Text txtEstablishedAs;
		Text txtJohnJones;
		Text text_1;

		// Construct Dairy Name/ID Area
		Group nameArea = new Group(top, SWT.NONE);
		nameArea.setText("General Information");

		// Construct Dairy Image
		CLabel lblDairyImage = new CLabel(top, SWT.NONE);
		lblDairyImage.setImage(ImageStore.getInstance().getImage("map.jpg"));

		// Construct Dairy Location Component
		LocationInfoGroup locationInfoGroup = new LocationInfoGroup(top, SWT.NONE);
		
		// Populate Dairy Name/ID Area		
		GridLayout gl_nameArea = new GridLayout(2, false);
		gl_nameArea.marginTop = 5;
		gl_nameArea.marginRight = 5;
		gl_nameArea.marginLeft = 5;
		nameArea.setLayout(gl_nameArea);
		
		Label lblName = new Label(nameArea, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblName.setText("Name");
		txtName = new Text(nameArea, SWT.BORDER);
		txtName.setText("Limuru Dairy Milk Processing Plant");
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblId = new Label(nameArea, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setText("ID");
		txtId = new Text(nameArea, SWT.BORDER);
		txtId.setText("# 33422314");
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblLicense = new Label(nameArea, SWT.NONE);
		lblLicense.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLicense.setText("License #");		
		txtLicense = new Text(nameArea, SWT.BORDER);
		txtLicense.setText("AD-123445-112");
		txtLicense.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		// Populate Image Area		
		// Populate Location Area		
		
		// Layout name area
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.bottom = new FormAttachment(locationInfoGroup, -5);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(lblDairyImage, 5);
		nameArea.setLayoutData(fd_composite);
		
		Label lblManager = new Label(nameArea, SWT.NONE);
		lblManager.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblManager.setText("Manager");
		
		txtJohnJones = new Text(nameArea, SWT.BORDER);
		txtJohnJones.setText("John Jones");
		txtJohnJones.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMembership = new Label(nameArea, SWT.NONE);
		lblMembership.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMembership.setText("Membership");
		
		text_1 = new Text(nameArea, SWT.BORDER);
		text_1.setText("134");
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDetails = new Label(nameArea, SWT.NONE);
		lblDetails.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblDetails.setText("Notes");
		
		txtEstablishedAs = new Text(nameArea, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtEstablishedAs.setText("Established 1976 as Limuru Community Processing Play");
		txtEstablishedAs.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		// Layout image area
		FormData fd_lblDairyImage = new FormData();
		fd_lblDairyImage.width = 200;
		fd_lblDairyImage.height = 200;
		fd_lblDairyImage.top = new FormAttachment(0, 10);
//		fd_lblDairyImage.bottom = new FormAttachment(0, 210);
//		fd_lblDairyImage.left = new FormAttachment(100, -179);
		fd_lblDairyImage.right = new FormAttachment(100, -10);
		lblDairyImage.setLayoutData(fd_lblDairyImage);
		
		// Layout address area
		FormData fd_locationInfoGroup = new FormData();
		fd_locationInfoGroup.height = 320;
		fd_locationInfoGroup.top = new FormAttachment(lblDairyImage, 5);
		fd_locationInfoGroup.bottom = new FormAttachment(100);
		fd_locationInfoGroup.left = new FormAttachment(0, 10);
		fd_locationInfoGroup.right = new FormAttachment(100, -10);
		locationInfoGroup.setLayoutData(fd_locationInfoGroup);

	}

	@Override
	public void setFocus() {
	}

}
