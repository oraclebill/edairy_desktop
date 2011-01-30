package com.agritrace.edairy.desktop.milkops.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;

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
	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));

		final Composite composite = UIControlsFactory.createComposite(container);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite.setLayout(new GridLayout(3, false));

		UIControlsFactory.createLabel(composite, "Date");

		final DateTime dateTime = UIControlsFactory.createDate(composite, 0, "date-picker");
		final GridData gd_dateTime = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTime.widthHint = 120;
		dateTime.setLayoutData(gd_dateTime);

		final Label lblDatePrintedOn = new Label(composite, SWT.NONE);
		final GridData gd_lblDatePrintedOn = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblDatePrintedOn.horizontalIndent = 30;
		lblDatePrintedOn.setLayoutData(gd_lblDatePrintedOn);
		lblDatePrintedOn.setText("The date to enter collection data for");

		UIControlsFactory.createLabel(composite, "Transport Route");

		final CCombo combo = UIControlsFactory.createCCombo(composite, "session");
		final GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 120;
		combo.setLayoutData(gd_combo);

		final Label lblRoute_1 = new Label(composite, SWT.NONE);
		final GridData gd_lblRoute_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblRoute_1.horizontalIndent = 30;
		lblRoute_1.setLayoutData(gd_lblRoute_1);
		lblRoute_1.setText("The route");

		UIControlsFactory.createLabel(composite, "Session");

		final CCombo combo_1 = UIControlsFactory.createCCombo(composite, "route");
		final GridData gd_combo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_1.widthHint = 120;
		combo_1.setLayoutData(gd_combo_1);

		final Label lblTheSession = new Label(composite, SWT.NONE);
		final GridData gd_lblTheSession = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblTheSession.horizontalIndent = 30;
		lblTheSession.setLayoutData(gd_lblTheSession);
		lblTheSession.setText("The session");

		final Composite composite_1 = UIControlsFactory.createComposite(container);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		composite_1.setLayout(new GridLayout(3, false));

		UIControlsFactory.createLabel(composite_1, "Driver");

		final CCombo combo_2 = UIControlsFactory.createCCombo(composite_1, "driver");
		final GridData gd_combo_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_2.widthHint = 120;
		combo_2.setLayoutData(gd_combo_2);

		final Label lblSelectTheDriver = new Label(composite_1, SWT.NONE);
		final GridData gd_lblSelectTheDriver = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblSelectTheDriver.horizontalIndent = 30;
		lblSelectTheDriver.setLayoutData(gd_lblSelectTheDriver);
		lblSelectTheDriver.setText("Select the driver for this trip");

		UIControlsFactory.createLabel(composite_1, "Vehicle");

		final CCombo combo_3 = UIControlsFactory.createCCombo(composite_1, "vehicle");
		final GridData gd_combo_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_combo_3.widthHint = 120;
		combo_3.setLayoutData(gd_combo_3);

		final Label lblSelectTheProper = new Label(composite_1, SWT.NONE);
		final GridData gd_lblSelectTheProper = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lblSelectTheProper.horizontalIndent = 30;
		lblSelectTheProper.setLayoutData(gd_lblSelectTheProper);
		lblSelectTheProper.setText("Select the proper vehicle ");

		final Composite composite_2 = new Composite(container, SWT.NONE);
		composite_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		composite_2.setLayout(new GridLayout(1, false));
	}

}
