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
package com.agritrace.edairy.desktop.modules.dairy;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.utils.ImageStore;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FillLayout;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.part.ViewPart;

import com.agritrace.edairy.desktop.modules.common.LocationInfoGroup;

public class DairyProfileView extends SubModuleView {

	public static final String ID = DairyProfileView.class.getName();

	private Text txtDairyName;
	private Text txtId;
	private Text txtLicense;
	private Text txtDairyDescription;
	private Text txtManager;
	private Text txtMemberCount;
	private Text txtAddress;
	private Text txtSection;
	private Text txtEstate;
	private Text txtTown;
	private Text txtSubLocation;
	private Combo txtLocation;
	private Text txtPostalCode;
	private Combo divisionCombo;
	private Combo districtCombo;
	private Combo provinceCombo;
	private Button btnSave;
	private Button btnCancel;
	
	@Override
	public void basicCreatePartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		
		Composite top = UIControlsFactory.createComposite(parent, SWT.NONE);
		top.setLayout(new FormLayout());

		// Construct Dairy Name/ID Area
		Group grpGeneralInfo = UIControlsFactory.createGroup(top, "General Information"); //, SWT.NONE);
		setupGeneralInfo(grpGeneralInfo);

		// Construct Dairy Image
		Label lblDairyImage = UIControlsFactory.createLabel(top, "", "dairy.profile.dairyimage");
		lblDairyImage.setImage(ImageStore.getInstance().getImage("map.jpg"));

		Group grpLocationInfo = UIControlsFactory.createGroup(top, "Location Information"); //, SWT.NONE);
		setupLocationInfo(grpLocationInfo);
		
//		Group grpAdminInfo = UIControlsFactory.createGroup(top, "Administrative Information"); //, SWT.NONE);
//		setupAdminInfo(grpAdminInfo);
		
		Composite ctButtonArea = UIControlsFactory.createComposite(top);
		setupButtonArea(ctButtonArea);
		
		// Layout name area
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.bottom = new FormAttachment(grpLocationInfo, -5);
		fd_composite.left = new FormAttachment(0, 10);
		fd_composite.right = new FormAttachment(lblDairyImage, 5);
		grpGeneralInfo.setLayoutData(fd_composite);
				
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
//		fd_locationInfoGroup.bottom = new FormAttachment(100);
		fd_locationInfoGroup.left = new FormAttachment(0, 10);
		fd_locationInfoGroup.right = new FormAttachment(100, -10);
		grpLocationInfo.setLayoutData(fd_locationInfoGroup);

		// Layout button area
		FormData fs_buttonAreaGroup = new FormData();
//		fs_buttonAreaGroup.height = 320;
		fs_buttonAreaGroup.top = new FormAttachment(grpLocationInfo, 5);
		//fs_buttonAreaGroup.bottom = new FormAttachment();
		fs_buttonAreaGroup.left = new FormAttachment(0, 10);
		fs_buttonAreaGroup.right = new FormAttachment(100, -10);
		ctButtonArea.setLayoutData(fs_buttonAreaGroup);
	}

	/**
	 * Populate dairy name/id area.
	 * 
	 * TODO: Pin #, license effective date. license expiration date
	 * 
	 * @param parent
	 */
	private void setupGeneralInfo(Composite parent ) {
		GridLayout gl_nameArea = new GridLayout(2, false);
		gl_nameArea.marginTop = 5;
		gl_nameArea.marginRight = 5;
		gl_nameArea.marginLeft = 5;
		parent.setLayout(gl_nameArea);
		
		Label lblName = UIControlsFactory.createLabel(parent, "Name");
		lblName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtDairyName = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.dairyname");
		txtDairyName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblId = UIControlsFactory.createLabel(parent, "ID");
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtId = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.dairyid");
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label lblLicense = UIControlsFactory.createLabel(parent, "License Number");
		lblLicense.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		txtLicense = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.licence");
		txtLicense.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		addUIControl(txtLicense, "txtLicense");

		Label lblManager = UIControlsFactory.createLabel(parent, "Manager");
		lblManager.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtManager = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.manager.name");
		txtManager.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblMembership = UIControlsFactory.createLabel(parent, "Membership");
		lblMembership.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtMemberCount = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.memberCount");
		txtMemberCount.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblDetails = UIControlsFactory.createLabel(parent, "Notes");
		lblDetails.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));		
		
		txtDairyDescription = UIControlsFactory.createText(parent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI, "dairy.profile.description");
		txtDairyDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		// demo data 
		txtDairyName.setText("Limuru Dairy Milk Processing Plant");
		txtId.setText("# 33422314");
		txtLicense.setText("AD-123445-112");
		txtManager.setText("John Jones");
		txtMemberCount.setText("134");
		txtDairyDescription.setText("Established 1976 as Limuru Community Processing Play");
	}
	
	private void setupLocationInfo(Composite parent ) {
			GridLayout gl_parent = new GridLayout(2, false);
			gl_parent.marginTop = 5;
			gl_parent.marginRight = 5;
			gl_parent.marginBottom = 5;
			gl_parent.marginLeft = 5;
			parent.setLayout(gl_parent);
			
			Label label = UIControlsFactory.createLabel(parent, "Address");
			txtAddress = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.address.address");		
			txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_1 = UIControlsFactory.createLabel(parent, "Section/Homestead");
			txtSection = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.address.section");		
			txtSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_2 = UIControlsFactory.createLabel(parent, "Estate/Nearest Centre");
			txtEstate = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.address.estate");
			txtEstate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_3 = UIControlsFactory.createLabel(parent, "Town/Village");
			txtTown = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.address.town");
			txtTown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_4 = UIControlsFactory.createLabel(parent, "Sub Location");
			txtSubLocation = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.address.sublocation");
			txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_5 = UIControlsFactory.createLabel(parent, "Location");
			txtLocation = UIControlsFactory.createCombo(parent, "dairy.profile.address.location");
			txtLocation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
			
			Label label_6 = UIControlsFactory.createLabel(parent, "Division");
			divisionCombo = UIControlsFactory.createCombo(parent, "dairy.profile.address.division");
//			divisionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_7 = UIControlsFactory.createLabel(parent, "District");
			districtCombo = UIControlsFactory.createCombo(parent, "dairy.profile.address.district");
//			districtCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_8 = UIControlsFactory.createLabel(parent, "Province");
			provinceCombo = UIControlsFactory.createCombo(parent,  "dairy.profile.address.province");
//			provinceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_9 = UIControlsFactory.createLabel(parent, "Postal Code");
			txtPostalCode = UIControlsFactory.createText(parent, SWT.BORDER, "dairy.profile.address.postalCode");
			
			GridData gd_txtPostalCode = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_txtPostalCode.minimumWidth = 50;
			txtPostalCode.setLayoutData(gd_txtPostalCode);

			
	}
	
	private void setupAdminInfo(Composite parent ) {
		
	}
	
	private void setupButtonArea(Composite parent) {
		FillLayout filler = new FillLayout();
		parent.setLayout(filler);
		
		btnCancel = UIControlsFactory.createButton(parent, "Cancel", "dairy.profile.button.cancel");		
		btnSave = UIControlsFactory.createButton(parent, "Save", "dairy.profile.button.save");
	}
	
	@Override
	public void setFocus() {
//		super.setFocus();
	}

}
