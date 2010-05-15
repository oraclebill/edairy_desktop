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
package com.agritrace.edairy.dairy.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.dairy.ui.DairyProfileViewWidgetID;


public class DairyProfileView extends SubModuleView {

	public static final String ID = DairyProfileView.class.getName(); 
	
	
	private Text txtName;
	private Text txtId;
	private Text txtLicense;
	private Text txtDairyDescription;
	private Text txtManagerName;
	private Text txtMemberCount;
	private Label lblMemberCount;
	private Label lblDairyImage;
	
	
	@Override
	protected void basicCreatePartControl(Composite parent) {
//		Composite top = new Composite(parent, SWT.NONE);
		Composite top = parent;
		top.setLayout(new FormLayout());


		// Construct Dairy Name/ID Area
		Group nameArea = new Group(top, SWT.NONE);
		nameArea.setText("General Information");

		// Construct Dairy Image
		lblDairyImage = UIControlsFactory.createLabel(top, "", DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);

		// Construct Dairy Location Component
		LocationInfoGroup locationInfoGroup = new LocationInfoGroup(top, SWT.NONE);
		
		// Populate Dairy Name/ID Area		
		GridLayout gl_nameArea = new GridLayout(2, false);
		gl_nameArea.marginTop = 5;
		gl_nameArea.marginRight = 5;
		gl_nameArea.marginLeft = 5;
		nameArea.setLayout(gl_nameArea);
		
//		Label lblName = UIControlsFactory.createLabel(nameArea, "Name");
//		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		GridDataFactory labelGridDataFactory = GridDataFactory.createFrom(
				new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		GridDataFactory fieldGridDataFactory = GridDataFactory.createFrom(
				new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		// name field
		labelGridDataFactory.applyTo(
				UIControlsFactory.createLabel(nameArea, "Name")
				);
		fieldGridDataFactory.applyTo(
				txtName = UIControlsFactory.createText(nameArea, SWT.NONE, DairyProfileViewWidgetID.DAIRY_NAME)
				);
		// id field
		labelGridDataFactory.applyTo(
				UIControlsFactory.createLabel(nameArea, "ID")
				);
		fieldGridDataFactory.applyTo(
				txtId = UIControlsFactory.createText(nameArea, SWT.NONE, DairyProfileViewWidgetID.DAIRY_ID)
				);
		// license field
		labelGridDataFactory.applyTo(
				UIControlsFactory.createLabel(nameArea, "License #")
				);
		fieldGridDataFactory.applyTo(
				txtLicense = UIControlsFactory.createText(nameArea, SWT.NONE, DairyProfileViewWidgetID.DAIRY_LICENSE)
				);

		
		
		// Populate Image Area		
		// Populate Location Area		
		
		// Layout name area
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.bottom = new FormAttachment(locationInfoGroup, -5);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(lblDairyImage, 5);
		nameArea.setLayoutData(fd_composite);
		
		
		// manager field 
		labelGridDataFactory.applyTo(
				UIControlsFactory.createLabel(nameArea, "Dairy Manager")
				);
		fieldGridDataFactory.applyTo(
				txtManagerName = UIControlsFactory.createText(nameArea, SWT.NONE, DairyProfileViewWidgetID.DAIRY_MANAGER_NAME)
				);
		
		// member count field 
		labelGridDataFactory.applyTo(
				UIControlsFactory.createLabel(nameArea, "Membership")
				);
		fieldGridDataFactory.applyTo(
				txtMemberCount = UIControlsFactory.createText(nameArea, SWT.NONE, DairyProfileViewWidgetID.DAIRY_MEMBER_COUNT)
				);
		
		// description field
		labelGridDataFactory.align(SWT.RIGHT, SWT.TOP).applyTo(
				UIControlsFactory.createLabel(nameArea, "Description")
				);
		fieldGridDataFactory.align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(
				txtDairyDescription = UIControlsFactory.createText(nameArea, 
						SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI, 
						DairyProfileViewWidgetID.DAIRY_PUBLIC_DESCRIPTION)
				);
		
		
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

		lblDairyImage.setImage(ImageStore.getInstance().getImage("map.jpg"));
		txtDairyDescription.setText("Established 1976 as Limuru Community Processing Play");
		txtMemberCount.setText("134");
		txtName.setText("Limuru Dairy");
		txtManagerName.setText("John Jones");
		txtId.setText("# 33422314");
		txtLicense.setText("AD-123445-112");
	}

}
