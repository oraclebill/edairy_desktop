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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.LocationProfileWidget;
import com.agritrace.edairy.desktop.dairy.profile.ui.DairyProfileViewWidgetID;

public class DairyProfileView extends SubModuleView {
	public DairyProfileView() {
	}

	public static final String ID = "dairy.profile.editor";

	private Text txtName;
	private Text txtId;
	private Text txtLicense;
	private Text txtDairyDescription;
	private Text txtManagerName;
	private Text txtMemberCount;
	private Label lblDairyImage;
	private Link linkDairyImage;

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

	private static final String DAIRY_IMAGE_GROUP_HEADER = "Dairy Image";

	private static final String DAIRY_IMAGE_LINK_ID = "dairy.profile.image.link";

	private static final String DAIRY_IMAGE_LINK_TEXT = "<click here to update>";

	@Override
	protected void basicCreatePartControl(Composite parent) {
		// Composite top = new Composite(parent, SWT.NONE);
		Composite row1 = UIControlsFactory.createComposite(parent);
		Composite top = createDairyInfoPanel(row1);
		Composite image = createDairyImagePanel(row1);
		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(row1);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).minSize(-1, 400).applyTo(row1);

		Composite row2 = UIControlsFactory.createComposite(parent);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.FILL).minSize(-1, 400).applyTo(row2);

		Composite tabs = createDairyTabPanel(row2);

		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(row2);

		GridLayoutFactory.fillDefaults().generateLayout(parent);
	}

	private Composite createDairyImagePanel(Composite parent) {
		Group imageGroup = UIControlsFactory.createGroup(parent, DAIRY_IMAGE_GROUP_HEADER);
		lblDairyImage = UIControlsFactory.createLabel(imageGroup, "", DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);
		linkDairyImage = UIControlsFactory.createLink(imageGroup, SWT.NONE, DAIRY_IMAGE_LINK_ID);
		linkDairyImage.setText(DAIRY_IMAGE_LINK_TEXT);
		GridLayoutFactory.swtDefaults().numColumns(2).generateLayout(imageGroup);
		return imageGroup;
	}

	private Composite createDairyInfoPanel(Composite parent) {

		// Construct Dairy Name/ID Area
		final Group nameArea = UIControlsFactory.createGroup(parent, "General Information");

		// Layout Dairy Name/ID Area
		final GridLayout gl_nameArea = new GridLayout(2, false);
		gl_nameArea.marginTop = 5;
		gl_nameArea.marginRight = 5;
		gl_nameArea.marginLeft = 5;
		nameArea.setLayout(gl_nameArea);

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
				.hint(-1, 40)
				.applyTo(
						txtDairyDescription = UIControlsFactory.createText(nameArea, SWT.BORDER | SWT.WRAP | SWT.SCROLL_LINE
								| SWT.V_SCROLL | SWT.MULTI, DairyProfileViewWidgetID.DAIRY_PUBLIC_DESCRIPTION));

		// test data
		//
		Image dairyImage = ImageStore.getInstance().getImage("map.jpg");
		if (dairyImage != null)
			if (lblDairyImage != null) 
				lblDairyImage.setImage(dairyImage);
		txtDairyDescription.setText("Established 1976 as Limuru Community Processing Play");
		txtMemberCount.setText("134");
		txtName.setText("Limuru Dairy");
		txtManagerName.setText("John Jones");
		txtId.setText("# 33422314");
		txtLicense.setText("AD-123445-112");

		return nameArea;
	}

	private Composite createDairyTabPanel(Composite parent) {

		Composite tabComposite = UIControlsFactory.createComposite(parent);
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
		Composite profileWidget = createAddressArea(profileComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(profileWidget);
		profileTab.setControl(profileComposite);

		// license info
		final CTabItem accountTab = new CTabItem(tabfolder, SWT.NULL);
		accountTab.setText("License Info");
		final Composite accountComposite = UIControlsFactory.createComposite(tabfolder, SWT.NONE);
		accountComposite.setLayout(new GridLayout(1, true));
		Composite managementArea = createManagementArea(accountComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(managementArea);
		accountTab.setControl(accountComposite);

		tabfolder.setSelection(0);
		
		return tabComposite;
	}

	private Composite createManagementArea(Composite accountComposite) {
		// TODO Auto-generated method stub
		return UIControlsFactory.createComposite(accountComposite);
	}

	private Composite createAddressArea(Composite parent) {

		Composite addressGroup = UIControlsFactory.createComposite(parent);
		GridLayoutFactory.fillDefaults().applyTo(addressGroup);
		
		LocationProfileWidget addressWidget = new LocationProfileWidget(addressGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(addressWidget.getComposite());

		CommunicationsGroupWidget communication = new CommunicationsGroupWidget(addressGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(communication.getGroup());

		return addressGroup;
	}

}
