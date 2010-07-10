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
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controls.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.controls.ProfilePhotoComposite;
import com.agritrace.edairy.desktop.common.ui.controls.location.LocationProfileWidget;
import com.agritrace.edairy.desktop.dairy.profile.ui.DairyProfileViewWidgetID;
import com.swtdesigner.SWTResourceManager;

public class DairyProfileView extends SubModuleView {
	public static final String ADDRESS_LABEL = "Address:";

	public static final String DISTRICT_LABEL = "District:";

	public static final String DIVISION_LABEL = "Division";
	public static final String ESTATE_LABEL = "Estate/Nearest Center:";
	public static final String ID = "dairy.profile.editor";
	public static final String LOCATION_LABEL = "Location:";
	public static final String POSTAL_CODE_LABEL = "Postal Code:";
	public static final String PROVINCE_LABEL = "Province:";
	public static final String SECTION_LABEL = "Section/Homestead:";

	public static final String SUBLOCATION_LABEL = "Sublocation";
	public static final String VILLAGE_LABEL = "Village:";
	private static final String DAIRY_IMAGE_GROUP_HEADER = "Dairy Image";
	private static final String DAIRY_IMAGE_LINK_TEXT = "<a>click here to update</a>";
	private Button cancelButton;
	private ProfilePhotoComposite lblDairyImage;
	private Link linkDairyImage;

	private Button saveButton;

	private Text txtDairyDescription;
	private Text txtId;
	private Text txtManagerName;
	private Text txtMemberCount;
	// info panel
	private Text txtName;
	
	public DairyProfileView() {
	}

	private Composite createAddressArea(Composite parent) {

		final Composite addressGroup = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().applyTo(addressGroup);

		final LocationProfileWidget addressWidget = new LocationProfileWidget(addressGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(addressWidget.getComposite());

		final CommunicationsGroupWidget communication = new CommunicationsGroupWidget(addressGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(communication.getGroup());

		return addressGroup;
	}

	private Composite createDairyButtonPanel(Composite parent) {
		final Composite buttonComposite = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(buttonComposite);

		saveButton = UIControlsFactory.createButton(buttonComposite, "Save");
		saveButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(saveButton, DairyProfileViewWidgetID.DAIRY_SAVE);

		cancelButton = UIControlsFactory.createButton(buttonComposite, "Cancel");
		cancelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		addUIControl(cancelButton, DairyProfileViewWidgetID.DAIRY_CANCEL);
		return buttonComposite;
	}

	private Composite createDairyImagePanel(Composite parent) {
		final Group imageGroup = UIControlsFactory.createGroup(parent, DAIRY_IMAGE_GROUP_HEADER);
		lblDairyImage = new ProfilePhotoComposite(imageGroup, SWT.BORDER);
		addUIControl(lblDairyImage, DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);
//		lblDairyImage = UIControlsFactory.createLabel(imageGroup, "", DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);
		GridDataFactory.fillDefaults().hint(200, 200).grab(false, true).align(SWT.FILL, SWT.FILL)
				.applyTo(lblDairyImage);
//		linkDairyImage = UIControlsFactory.createLink(imageGroup, SWT.NONE,
//				DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE_LINK);
//		linkDairyImage.setText(DAIRY_IMAGE_LINK_TEXT);
//		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.BOTTOM).applyTo(linkDairyImage);
		GridLayoutFactory.swtDefaults().numColumns(1).generateLayout(imageGroup);
		return imageGroup;
	}

	private Composite createDairyInfoPanel(Composite dairyInfoPanel) {
		
		// Construct Dairy Name/ID Area
		final Group nameArea = UIControlsFactory.createGroup(dairyInfoPanel, "General Information");

		// Layout Dairy Name/ID Area
		final GridLayout gl_nameArea = new GridLayout(2, false);
		gl_nameArea.marginTop = 5;
		gl_nameArea.marginRight = 5;
		gl_nameArea.marginLeft = 5;
		nameArea.setLayout(gl_nameArea);

		final GridDataFactory labelGridDataFactory = GridDataFactory.createFrom(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1));
		final GridDataFactory fieldGridDataFactory = GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.CENTER).grab(true, false).hint(140,-1);

		// id field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "ID:"));
		fieldGridDataFactory.applyTo(txtId = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_ID));

		// name field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Name:"));
		fieldGridDataFactory.applyTo(txtName = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_NAME));

		// phone field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Phone #:"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_PHONE_NUMBER));

		// established date
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Date Established:"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createDate(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_ESTABLISHED_DATE));

		// manager field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Dairy Manager:"));
		fieldGridDataFactory.applyTo(txtManagerName = UIControlsFactory.createText(nameArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_MANAGER_NAME));

		// description field
		Label label = UIControlsFactory.createLabel(nameArea, "Description:");
		labelGridDataFactory.applyTo(label);
		fieldGridDataFactory
				.copy()
				.align(SWT.LEFT, SWT.FILL)
				.grab(true, true)
				.hint(-1, 40)
				.applyTo(
						txtDairyDescription = UIControlsFactory.createText(nameArea, SWT.BORDER | SWT.WRAP
								| SWT.SCROLL_LINE | SWT.V_SCROLL | SWT.MULTI,
								DairyProfileViewWidgetID.DAIRY_PUBLIC_DESCRIPTION));
		GridData gd_txtDairyDescription = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_txtDairyDescription.heightHint = 50;
		txtDairyDescription.setLayoutData(gd_txtDairyDescription);

		// member count field
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(nameArea, "Member Count:"));
		fieldGridDataFactory.applyTo(txtMemberCount = UIControlsFactory.createTextNumeric(nameArea,
				DairyProfileViewWidgetID.DAIRY_MEMBER_COUNT));
		GridData gd_txtMemberCount = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtMemberCount.widthHint = 50;
		txtMemberCount.setLayoutData(gd_txtMemberCount);
		
		return nameArea;
	}

	private Composite createDairyTabPanel(Composite parent) {

		final Composite tabComposite = UIControlsFactory.createComposite(parent);
		final GridData detailsGD = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		detailsGD.minimumHeight = 200;
		tabComposite.setLayoutData(detailsGD);
		final GridLayout detaLayout = new GridLayout();
		detaLayout.numColumns = 1;
		tabComposite.setLayout(detaLayout);
		tabComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		// create tabfolder
		final CTabFolder tabfolder = new CTabFolder(tabComposite, SWT.NULL);
		tabfolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// set gradient background
		final Color startColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_START_COLOR);
		final Color endColor = LnfManager.getLnf().getColor(
				LnfKeyConstants.EMBEDDED_TITLEBAR_ACTIVE_BACKGROUND_END_COLOR);
		tabfolder.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		tabfolder.setSelectionBackground(new Color[] { startColor, endColor }, new int[] { 50 }, true);

		// profile tab
		final CTabItem profileTab = new CTabItem(tabfolder, SWT.NULL);
		profileTab.setText("Profile");
		final Composite profileComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		profileComposite.setLayout(new GridLayout(1, true));
		final Composite profileWidget = createAddressArea(profileComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(profileWidget);
		profileTab.setControl(profileComposite);

		// license info
		final CTabItem accountTab = new CTabItem(tabfolder, SWT.NULL);
		accountTab.setText("License Info");
		final Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		accountComposite.setLayout(new GridLayout(1, true));
		final Composite managementArea = createLicenseInfoPanel(accountComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(managementArea);
		accountTab.setControl(accountComposite);

		tabfolder.setSelection(0);

		return tabComposite;
	}

	private Composite createLicenseInfoPanel(Composite parent) {

		// Construct Dairy Name/ID Area
		final Group licenseArea = UIControlsFactory.createGroup(parent, "License Information");

		// Layout Dairy Name/ID Area
		final GridLayout gl_nameArea = new GridLayout(2, false);
		gl_nameArea.marginTop = 5;
		gl_nameArea.marginRight = 5;
		gl_nameArea.marginLeft = 5;
		licenseArea.setLayout(gl_nameArea);

		final GridDataFactory labelGridDataFactory = GridDataFactory.createFrom(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		final GridDataFactory fieldGridDataFactory = GridDataFactory.createFrom(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		// Legal Name
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(licenseArea, "Legal Name"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createText(licenseArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_LEGAL_NAME));

		// Registration Number
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(licenseArea, "Registration Number"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createText(licenseArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_REGISTRATION_NUMBER));

		// license effective date
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(licenseArea, "Lic. Effective Date"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createDate(licenseArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_LIC_EFFECTIVE_DATE));

		// license expiration date
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(licenseArea, "Lic. Expiration Date"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createDate(licenseArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_LIC_EXPIRATION_DATE));

		// NSSF Number
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(licenseArea, "NSSF Number"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createText(licenseArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_NSSF_NUMBER));

		// NHIF Number
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(licenseArea, "NHIF Number"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createText(licenseArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_NHIF_NUMBER));

		// Federal PIN
		labelGridDataFactory.applyTo(UIControlsFactory.createLabel(licenseArea, "Federal PIN"));
		fieldGridDataFactory.applyTo(UIControlsFactory.createText(licenseArea, SWT.NONE,
				DairyProfileViewWidgetID.DAIRY_FEDERAL_PIN));

		return licenseArea;
	}

	@Override
	protected void basicCreatePartControl(Composite mainParent) {
		mainParent.setLayout(new FillLayout());
		ScrolledComposite scrollParent = new ScrolledComposite(mainParent, SWT.V_SCROLL);
		scrollParent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		Composite parent = new Composite(scrollParent, 0);

		// create top row containing dairy info and dairy image
		final Composite row1 = UIControlsFactory.createComposite(parent);
		createDairyInfoPanel(row1);
		createDairyImagePanel(row1);
		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(row1);
		// GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL,
		// SWT.FILL).minSize(-1, 400).applyTo(row1);

		// second row containing tabbed panel
		final Composite row2 = UIControlsFactory.createComposite(parent);
		createDairyTabPanel(row2);
		GridLayoutFactory.swtDefaults().numColumns(1).generateLayout(row2);

		// third row contains save and cancel buttons
		final Composite row3 = UIControlsFactory.createComposite(parent);
		createDairyButtonPanel(row3);
		GridLayoutFactory.swtDefaults().numColumns(1).generateLayout(row3);

		// layout the panel
		GridLayoutFactory.fillDefaults().generateLayout(parent);

		//
		// test data
		//
		final Image dairyImage = ImageStore.getInstance().getImage("map.jpg");
		if (dairyImage != null) {
			if (lblDairyImage != null) {
				lblDairyImage.setImage(dairyImage);
			}
		}
		txtDairyDescription.setText("Established 1976 as Limuru Community Processing Play");
		txtMemberCount.setText("134");
		txtName.setText("Limuru Dairy");
		txtManagerName.setText("John Jones");
		txtId.setText("# 33422314");
		// txtLicense.setText("AD-123445-112");

		parent.pack();
		scrollParent.setContent(parent);


	}

}
