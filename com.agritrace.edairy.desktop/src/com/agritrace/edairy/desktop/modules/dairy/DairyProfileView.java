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
		Label lblDairyImage = UIControlsFactory.createLabel(top, "", "lblDairyImage");
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
		addUIControl(lblDairyImage, "lblDairyImage");
		
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
		
		txtDairyName = UIControlsFactory.createText(parent);
		txtDairyName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		addUIControl(txtDairyName, "txtDairyName");

		Label lblId = UIControlsFactory.createLabel(parent, "ID");
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setText("ID");
		
		txtId = UIControlsFactory.createText(parent);
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		addUIControl(txtId, "txtId");
		
		Label lblLicense = UIControlsFactory.createLabel(parent, "License Number");
		lblLicense.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		txtLicense = UIControlsFactory.createText(parent);
		txtLicense.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		addUIControl(txtLicense, "txtLicense");

		Label lblManager = UIControlsFactory.createLabel(parent, "Manager");
		lblManager.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtManager = UIControlsFactory.createText(parent);
		txtManager.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		addUIControl(txtManager, "txtManager");
		
		Label lblMembership = UIControlsFactory.createLabel(parent, "Membership");
		lblMembership.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtMemberCount = UIControlsFactory.createText(parent);
		txtMemberCount.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		addUIControl(txtMemberCount, "txtMemberCount");

		
		Label lblDetails = UIControlsFactory.createLabel(parent, "Notes");
		lblDetails.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));		
		
		txtDairyDescription = UIControlsFactory.createText(parent, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtDairyDescription.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		addUIControl(txtDairyDescription, "txtDairyDescription");
		
		// test data 
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
			txtAddress = UIControlsFactory.createText(parent);		
			txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_1 = UIControlsFactory.createLabel(parent, "Section/Homestead");
			txtSection = UIControlsFactory.createText(parent);		
			txtSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_2 = UIControlsFactory.createLabel(parent, "Estate/Nearest Centre");
			txtEstate = UIControlsFactory.createText(parent);
			txtEstate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_3 = UIControlsFactory.createLabel(parent, "Town/Village");
			txtTown = UIControlsFactory.createText(parent);
			txtTown.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_4 = UIControlsFactory.createLabel(parent, "Sub Location");
			txtSubLocation = UIControlsFactory.createText(parent);
			txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_5 = UIControlsFactory.createLabel(parent, "Location");
			txtLocation = new Combo(parent, SWT.READ_ONLY);
			txtLocation.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
			
			Label label_6 = UIControlsFactory.createLabel(parent, "Division");
			divisionCombo = new Combo(parent, SWT.READ_ONLY);
//			divisionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_7 = UIControlsFactory.createLabel(parent, "District");
			districtCombo = new Combo(parent, SWT.READ_ONLY);
//			districtCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_8 = UIControlsFactory.createLabel(parent, "Province");
			provinceCombo = new Combo(parent, SWT.READ_ONLY);
//			provinceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_9 = UIControlsFactory.createLabel(parent, "Postal Code");
			txtPostalCode = UIControlsFactory.createText(parent);
			GridData gd_txtPostalCode = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_txtPostalCode.minimumWidth = 50;
			txtPostalCode.setLayoutData(gd_txtPostalCode);

			// sample data
			txtLocation.setItems(new String[] {"Gatamaiyu\t", "Gitithia\t", "Kamae\t", "Kamburu\t", "Kijabe\t", "Kinale\t", "Kirenga\t", "Lari\t", "Nyanduma\t"});
			txtLocation.select(0);
			divisionCombo.setItems(new String[] {"Githunguri", "Kiambaa", "Kikuyu", "Lari\t", "Limuru"});
			divisionCombo.select(1);
			districtCombo.setItems(new String[] {"Baringo District (Kabarnet)", "Bomet District (Bomet)", "Bondo District (Bondo)", "Bungoma District (Bungoma)", "Buret District (Litein)", "Busia (Busia)", "Butere/Mumias District (Butere)", "Embu District (Embu)", "Garissa District (Garissa)", "Gucha District (Ogembo)", "Homa Bay District (Homa Bay)", "Ijara District (Ijara)", "Isiolo District (Isiolo)", "Kajiado District (Kajiado)", "Kakamega District (Kakamega)", "Keiyo District (Iten/Tambach)", "Kericho District (Kericho)", "Kiambu District (Kiambu)", "Kilifi District (Kilifi)", "Kirinyaga District (Kerugoya/Kutus)", "Kisii Central (Kisii)", "Kisumu District (Kisumu)", "Kitui District (Kitui)", "Koibatek District (Eldama Ravine)", "Kuria District (Kehancha)", "Kwale District (Kwale)", "Laikipia District (Nanyuki)", "Lamu District (Lamu)", "Lugari District (Lugari)", "Machakos District (Machakos)", "Makueni District (Makueni)", "Malindi District (Malindi)", "Mandera District (Mandera)", "Maragua District (Maragua)", "Marakwet District (Kapsowar)", "Marsabit District (Marsabit)", "Mbeere District (Mbeere)", "Meru Central District (Meru)", "Meru North District (Maua)", "Meru South District (Chuka)", "Migori District (Migori)", "Mombasa District (Mombasa)", "Mount Elgon District (Mount Elgon)", "Moyale District (Moyale)", "Murang'a District (Murang'a)", "Mwingi District (Mwingi)", "Nairobi District (Nairobi)", "Nakuru District (Nakuru)", "Nandi (Kapsabet)", "Narok District (Narok)", "Nyamira District (Nyamira)", "Nyandarua District (Ol Kalou)", "Nyando District (Awasi)", "Nyeri District (Nyeri)", "Rachuonyo District (Oyugis)", "Samburu District (Maralal)", "Siaya District (Siaya)", "Suba District (Mbita)", "Taita-Taveta District (Wundanyi)", "Tana River District (Tana River)", "Teso District (Malaba)", "Tharaka District (Tharaka)", "Thika District (Thika)", "Trans Mara District (Kilgoris)", "Trans Nzoia District (Kitale)", "Turkana District (Lodwar)", "Uasin Gishu District (Eldoret)", "Vihiga District (Vihiga)", "Wajir District (Wajir)", "West Pokot District (Kapenguria)"});
			districtCombo.select(1);
			provinceCombo.setItems(new String[] {"Central", "Coast", "Eastern", "Nairobi", "North Eastern", "Nyanza", "Rift Valley", "Western"});
			provinceCombo.select(1);
			txtPostalCode.setText("112345");

			
			addUIControl(txtAddress, "txtAddress");
			addUIControl(txtEstate, "txtEstate");
			addUIControl(txtLocation, "txtLocation");
			addUIControl(txtSubLocation, "txtSubLocation");
			addUIControl(txtPostalCode, "txtPostalCode");
			addUIControl(txtSection, "txtSection");
			addUIControl(districtCombo, "districtCombo");
			addUIControl(divisionCombo, "divisionCombo");
			addUIControl(provinceCombo, "provinceCombo");
			
	}
	
	private void setupAdminInfo(Composite parent ) {
		
	}
	
	private void setupButtonArea(Composite parent) {
		FillLayout filler = new FillLayout();
		parent.setLayout(filler);
		
		btnCancel = UIControlsFactory.createButton(parent, "Cancel", "btnCancel");		
		btnSave = UIControlsFactory.createButton(parent, "Save", "btnSave");
	}
	
	@Override
	public void setFocus() {
//		super.setFocus();
	}

}
