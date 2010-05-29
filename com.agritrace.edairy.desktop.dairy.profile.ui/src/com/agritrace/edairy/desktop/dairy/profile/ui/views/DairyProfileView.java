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
package com.agritrace.edairy.desktop.dairy.profile.ui.views;

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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.dairy.profile.ui.DairyProfileViewWidgetID;

public class DairyProfileView extends SubModuleView {

	public static final String ID = "dairy.profile.editor";

	private Text txtName;
	private Text txtId;
	private Text txtLicense;
	private Text txtDairyDescription;
	private Text txtManagerName;
	private Text txtMemberCount;
	private Label lblDairyImage;

	public static final String ADDRESS_LABEL = "Address:";
	public static final String SECTION_LABEL = "Section/Homestead:";
	public static final String ESTATE_LABEL = "Estate/Nearest Center:";
	public static final String LOCATION_LABEL = "Location:";
	public static final String SUBLOCATION_LABEL = "Sublocation";
	public static final String VILLAGE_LABEL = "Village:";
	public static final String DIVISION_LABEL = "Division";
	public static final String DISTRICT_LABEL = "District:";
	public static final String PROVINCE_LABEL = "Province:";
	public static final String POSTAL_CODE_LABEL = "Postal Code:";

	@Override
	protected void basicCreatePartControl(Composite parent) {
		// Composite top = new Composite(parent, SWT.NONE);
		final Composite top = parent;
		top.setLayout(new FormLayout());

		// Construct Dairy Name/ID Area
		final Group nameArea = UIControlsFactory.createGroup(top, "General Information");

		// Construct Dairy Image
		lblDairyImage = UIControlsFactory.createLabel(top, "", DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);

		// // Construct Dairy Location Component
		// final LocationInfoGroup locationInfoGroup = new
		// LocationInfoGroup(top, SWT.NONE);

		final Group locationInfoGroup = createAddress(top);
		// Populate Dairy Name/ID Area
		final GridLayout gl_nameArea = new GridLayout(2, false);
		gl_nameArea.marginTop = 5;
		gl_nameArea.marginRight = 5;
		gl_nameArea.marginLeft = 5;
		nameArea.setLayout(gl_nameArea);

		// Label lblName = UIControlsFactory.createLabel(nameArea, "Name");
		// lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
		// false, 1, 1));

		final GridDataFactory labelGridDataFactory = GridDataFactory.createFrom(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		final GridDataFactory fieldGridDataFactory = GridDataFactory.createFrom(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		// name field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Name"));
		fieldGridDataFactory.applyTo(txtName = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_NAME));
		// id field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "ID"));
		fieldGridDataFactory.applyTo(txtId = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_ID));
		// license field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "License #"));
		fieldGridDataFactory.applyTo(txtLicense = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_LICENSE));

		// Populate Image Area
		// Populate Location Area

		// Layout name area
		final FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.bottom = new FormAttachment(locationInfoGroup, -5);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(lblDairyImage, 5);
		nameArea.setLayoutData(fd_composite);

		// manager field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Dairy Manager"));
		fieldGridDataFactory.applyTo(txtManagerName = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_MANAGER_NAME));

		// member count field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Membership"));
		fieldGridDataFactory.applyTo(txtMemberCount = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_MEMBER_COUNT));

		// description field
		labelGridDataFactory.align(SWT.RIGHT, SWT.TOP).applyTo(UIControlsFactory.createLabel(nameArea, "Description"));
		fieldGridDataFactory
				.align(SWT.FILL, SWT.FILL)
				.grab(true, true)
				.applyTo(
						txtDairyDescription = UIControlsFactory.createText(nameArea, SWT.BORDER | SWT.WRAP
								| SWT.V_SCROLL | SWT.MULTI, DairyProfileViewWidgetID.DAIRY_PUBLIC_DESCRIPTION));

		// Layout image area
		final FormData fd_lblDairyImage = new FormData();
		fd_lblDairyImage.width = 200;
		fd_lblDairyImage.height = 200;
		fd_lblDairyImage.top = new FormAttachment(0, 10);
		// fd_lblDairyImage.bottom = new FormAttachment(0, 210);
		// fd_lblDairyImage.left = new FormAttachment(100, -179);
		fd_lblDairyImage.right = new FormAttachment(100, -10);
		lblDairyImage.setLayoutData(fd_lblDairyImage);

		// Layout address area
		final FormData fd_locationInfoGroup = new FormData();
		fd_locationInfoGroup.height = 320;
		fd_locationInfoGroup.top = new FormAttachment(lblDairyImage, 5);
		fd_locationInfoGroup.bottom = new FormAttachment(100);
		fd_locationInfoGroup.left = new FormAttachment(0, 10);
		fd_locationInfoGroup.right = new FormAttachment(100, -10);
		locationInfoGroup.setLayoutData(fd_locationInfoGroup);

		// test data
		//		
		lblDairyImage.setImage(ImageStore.getInstance().getImage("map.jpg"));
		txtDairyDescription.setText("Established 1976 as Limuru Community Processing Play");
		txtMemberCount.setText("134");
		txtName.setText("Limuru Dairy");
		txtManagerName.setText("John Jones");
		txtId.setText("# 33422314");
		txtLicense.setText("AD-123445-112");
	}

	private Group createAddress(Composite parent) {
		// address composite
		final Group addressPanel = UIControlsFactory.createGroup(parent, "Location");
		final GridLayout layout2 = new GridLayout(6, false);
		addressPanel.setLayout(layout2);
		addressPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// address
		final Label label = UIControlsFactory.createLabel(addressPanel, ADDRESS_LABEL);
		final GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.minimumWidth = 100;
		label.setLayoutData(gd_label);
		final Text txtAddress = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_ADDRESS);
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1));
		// section
		UIControlsFactory.createLabel(addressPanel, SECTION_LABEL);
		final Text txtAddress2 = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_SECTION);
		txtAddress2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1));

		// estate
		UIControlsFactory.createLabel(addressPanel, ESTATE_LABEL);
		final Text estateAddress = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_ESTATE);
		estateAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// town
		UIControlsFactory.createLabel(addressPanel, VILLAGE_LABEL);
		final Text txtVillage = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_VILLAGE);
		txtVillage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// sublocation
		UIControlsFactory.createLabel(addressPanel, SUBLOCATION_LABEL);
		final Text txtSubLocation = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_SUBLOCATION);
		txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// location
		UIControlsFactory.createLabel(addressPanel, LOCATION_LABEL);
		final Text txtLocation = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_LOCATION);
		txtLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// division
		UIControlsFactory.createLabel(addressPanel, DIVISION_LABEL);
		final Text txtDivision = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_DIVISION);
		txtDivision.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// District
		UIControlsFactory.createLabel(addressPanel, DISTRICT_LABEL);
		final Text txtDistrict = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_DISTRICT);
		txtDistrict.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// province
		UIControlsFactory.createLabel(addressPanel, PROVINCE_LABEL);
		final Combo comboProvince = UIControlsFactory.createCombo(addressPanel,
				DairyProfileViewWidgetID.DAIRY_LOCATION_PROVINCE);
		comboProvince.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// PostalCode
		UIControlsFactory.createLabel(addressPanel, POSTAL_CODE_LABEL);
		final Text txtPostal = UIControlsFactory.createText(addressPanel, SWT.BORDER,
				DairyProfileViewWidgetID.DAIRY_LOCATION_POSTALCODE);
		txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		return addressPanel;
	}

}
