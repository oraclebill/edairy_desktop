package com.agritrace.edairy.desktop.dairy.employees.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;


public class StaffInfoMasterDetailComposite extends MasterDetailsComposite {

	public static final String BIND_ID_FIRST_NAME = "bind.id.firstname";//$NON-NLS-1$
	public static final String BIND_ID_LAST_NAME = "bind.id.lastName";//$NON-NLS-1$
	public static final String BIND_ID_PHONE_NUM = "bind.id.phonenum";//$NON-NLS-1$
	public static final String BIND_ID_DEPARTMENT = "bind.id.department";//$NON-NLS-1$
	public static final String BIND_ID_ADDRESS = "bind.id.address";//$NON-NLS-1$

	public StaffInfoMasterDetailComposite(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected Table createTable(Composite tableComposite, TableColumnLayout layout) {

		final Table table = super.createTable(tableComposite, layout);
		final GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		// Same height with the filter section
		data.heightHint = 200;
		data.widthHint = 830;
		tableComposite.setLayoutData(data);
		tableComposite.setLayout(layout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		return table;
	}

	@Override
	protected void createDetails(Composite details) {

		details.setLayout(new GridLayout());

		final Group detailGroup = UIControlsFactory.createGroup(details, "Details");
		detailGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		final GridLayout layout2 = new GridLayout(3, false);
		layout2.makeColumnsEqualWidth = false;
		detailGroup.setLayout(layout2);
		//

		UIControlsFactory.createLabel(detailGroup, "First Name:"); //$NON-NLS-1$
		final Text txtFirst = UIControlsFactory.createText(detailGroup, SWT.BORDER, BIND_ID_FIRST_NAME);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtFirst);

		final Label imageLable = new Label(detailGroup, SWT.BORDER);
		final GridData imagData = new GridData();
		imagData.verticalAlignment = GridData.FILL;

		imagData.verticalSpan = 4;
		imageLable.setLayoutData(imagData);

		UIControlsFactory.createLabel(detailGroup, "Last Name:"); //$NON-NLS-1$
		final Text txtLast = UIControlsFactory.createText(detailGroup, SWT.BORDER, BIND_ID_LAST_NAME);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtLast);

		UIControlsFactory.createLabel(detailGroup, "Phone Number"); //$NON-NLS-1$
		final Text txtPhone = UIControlsFactory.createText(detailGroup, SWT.BORDER, BIND_ID_PHONE_NUM);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtPhone);

		UIControlsFactory.createLabel(detailGroup, "Department"); //$NON-NLS-1$
		final Text txtDep = UIControlsFactory.createText(detailGroup, SWT.BORDER, BIND_ID_DEPARTMENT);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtDep);

		UIControlsFactory.createLabel(detailGroup, "Address"); //$NON-NLS-1$
		final Text txtAdd = UIControlsFactory.createText(detailGroup, SWT.BORDER, BIND_ID_ADDRESS);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(txtAdd);

		//		UIControlsFactory.createLabel(detailGroup, "Gender:"); //$NON-NLS-1$
		// ChoiceComposite ccGender = new ChoiceComposite(detailGroup, SWT.NONE,
		// false);
		// ccGender.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
		// 1, 1));
		// ccGender.setOrientation(SWT.HORIZONTAL);

		final Composite buttonPanel = UIControlsFactory.createComposite(detailGroup);
		GridDataFactory.fillDefaults().span(3, 1).grab(true, false).align(SWT.CENTER, SWT.FILL).applyTo(buttonPanel);
		buttonPanel.setLayout(new GridLayout(2, false));
		final Button saveButton = UIControlsFactory.createButton(buttonPanel, "Save");
		saveButton.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false));

		final Button cancelButton = UIControlsFactory.createButton(buttonPanel, "Cancel");
		cancelButton.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false));

		// DefaultButtonManager dbm = new
		// DefaultButtonManager(parent.getShell());
		// dbm.addButton(mdComposite.getButtonApply(), mdComposite);
	}

}
