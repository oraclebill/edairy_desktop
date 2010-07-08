package com.agritrace.edairy.desktop.common.ui.views;

import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class AddressGroupWidget {

	public static final String ADDRESS_LABEL = "Address:";
	public static final String DISTRICT_LABEL = "District:";

	public static final String DIVISION_LABEL = "Division";
	public static final String ESTATE_LABEL = "Estate/Nearest Center:";
	public static final String LOCATION_LABEL = "Location:";
	public static final String POSTAL_CODE_LABEL = "Postal Code:";
	public static final String PROVINCE_LABEL = "Province:";
	public static final String SECTION_LABEL = "Section/Homestead:";
	public static final String SUBLOCATION_LABEL = "Sublocation";
	public static final String VILLAGE_LABEL = "Village:";
	private Group addressGroup;
	private Composite addressPanel;

	public AddressGroupWidget(Composite parent) {
		if (parent != null) {
			addressGroup = UIControlsFactory.createGroup(parent, "Address Information");
			addressGroup.setLayout(new GridLayout(1, false));
			createAddresscontrol();
		}
	}

	public Group getGroup() {
		return addressGroup;
	}

	private void createAddresscontrol() {
		// address composite
		addressPanel = UIControlsFactory.createComposite(addressGroup);
		final GridLayout layout2 = new GridLayout(6, false);
		addressPanel.setLayout(layout2);
		addressPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// address
		final Label label = UIControlsFactory.createLabel(addressPanel, ADDRESS_LABEL);
		final GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.minimumWidth = 100;
		label.setLayoutData(gd_label);
		final Text txtAddress = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.ADDRESS_TXT);
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1));
		// section
		UIControlsFactory.createLabel(addressPanel, SECTION_LABEL);
		final Text txtAddress2 = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.SECTION_TXT);
		txtAddress2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1));

		// estate
		UIControlsFactory.createLabel(addressPanel, ESTATE_LABEL);
		final Text estateAddress = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.ESTATE_TXT);
		estateAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// town
		UIControlsFactory.createLabel(addressPanel, VILLAGE_LABEL);
		final Text txtVillage = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.VILLAGE_TXT);
		txtVillage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// sublocation
		UIControlsFactory.createLabel(addressPanel, SUBLOCATION_LABEL);
		final Text txtSubLocation = UIControlsFactory
				.createText(addressPanel, SWT.BORDER, ViewWidgetId.SUBLOCATION_TXT);
		txtSubLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// location
		UIControlsFactory.createLabel(addressPanel, LOCATION_LABEL);
		final Text txtLocation = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.LOCATION_TXT);
		txtLocation.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// division
		UIControlsFactory.createLabel(addressPanel, DIVISION_LABEL);
		final Text txtDivision = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.DIVISION_TXT);
		txtDivision.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// District
		UIControlsFactory.createLabel(addressPanel, DISTRICT_LABEL);
		final Text txtDistrict = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.DISTRICT_TXT);
		txtDistrict.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// province
		UIControlsFactory.createLabel(addressPanel, PROVINCE_LABEL);
		final Combo comboProvince = UIControlsFactory.createCombo(addressPanel, ViewWidgetId.PROVINCE_TXT);
		comboProvince.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// PostalCode
		UIControlsFactory.createLabel(addressPanel, POSTAL_CODE_LABEL);
		final Text txtPostal = UIControlsFactory.createText(addressPanel, SWT.BORDER, ViewWidgetId.POSTAL_CODE_TXT);
		txtPostal.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
	}

}
