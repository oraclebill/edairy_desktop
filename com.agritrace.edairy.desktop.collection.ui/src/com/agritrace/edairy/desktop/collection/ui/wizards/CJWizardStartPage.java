package com.agritrace.edairy.desktop.collection.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class CJWizardStartPage extends WizardPage {

	/**
	 * Create the wizard.
	 */
	public CJWizardStartPage() {
		super("wizardPage");
		setTitle("Enter Collection Journals Tool");
		setDescription("This component helps you record all of the collection journals associated with a single session. ");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Composite composite = UIControlsFactory.createComposite(container);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(3, false));
		
		UIControlsFactory.createLabel(composite, "Date");
		
		DateTime dateTime = UIControlsFactory.createDate(composite, 0, "date-picker");
		GridData gd_dateTime = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTime.widthHint = 120;
		dateTime.setLayoutData(gd_dateTime);
		
		Label lblDatePrintedOn = new Label(composite, SWT.NONE);
		GridData gd_lblDatePrintedOn = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblDatePrintedOn.horizontalIndent = 30;
		lblDatePrintedOn.setLayoutData(gd_lblDatePrintedOn);
		lblDatePrintedOn.setText("The date to enter collection data for");
		
		UIControlsFactory.createLabel(composite, "Route");
		
		CCombo combo = UIControlsFactory.createCCombo(composite, "session");
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 120;
		combo.setLayoutData(gd_combo);
		
		Label lblRoute_1 = new Label(composite, SWT.NONE);
		GridData gd_lblRoute_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblRoute_1.horizontalIndent = 30;
		lblRoute_1.setLayoutData(gd_lblRoute_1);
		lblRoute_1.setText("The route");
		
		UIControlsFactory.createLabel(composite, "Session");
		
		CCombo combo_1 = UIControlsFactory.createCCombo(composite, "route");
		GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 120;
		combo_1.setLayoutData(gd_combo_1);
		
		Label lblTheSession = new Label(composite, SWT.NONE);
		GridData gd_lblTheSession = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblTheSession.horizontalIndent = 30;
		lblTheSession.setLayoutData(gd_lblTheSession);
		lblTheSession.setText("The session");
		
		Composite composite_1 = UIControlsFactory.createComposite(container);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_1.setLayout(new GridLayout(3, false));
		
		UIControlsFactory.createLabel(composite_1, "Driver");
		
		CCombo combo_2 = UIControlsFactory.createCCombo(composite_1, "driver");
		GridData gd_combo_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_2.widthHint = 120;
		combo_2.setLayoutData(gd_combo_2);
		
		Label lblSelectTheDriver = new Label(composite_1, SWT.NONE);
		GridData gd_lblSelectTheDriver = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblSelectTheDriver.horizontalIndent = 30;
		lblSelectTheDriver.setLayoutData(gd_lblSelectTheDriver);
		lblSelectTheDriver.setText("Select the driver for this trip");
		
		UIControlsFactory.createLabel(composite_1, "Vehicle");
		
		CCombo combo_3 = UIControlsFactory.createCCombo(composite_1, "vehicle");
		GridData gd_combo_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_3.widthHint = 120;
		combo_3.setLayoutData(gd_combo_3);
		
		Label lblSelectTheProper = new Label(composite_1, SWT.NONE);
		GridData gd_lblSelectTheProper = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblSelectTheProper.horizontalIndent = 30;
		lblSelectTheProper.setLayoutData(gd_lblSelectTheProper);
		lblSelectTheProper.setText("Select the proper vehicle ");
		
		Composite composite_2 = new Composite(container, SWT.NONE);
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		composite_2.setLayout(new GridLayout(1, false));
	}

}
