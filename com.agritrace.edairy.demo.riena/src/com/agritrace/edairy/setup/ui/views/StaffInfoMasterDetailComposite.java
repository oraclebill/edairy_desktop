package com.agritrace.edairy.setup.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.ui.EDairyActivator;
import com.agritrace.edairy.ui.ImageRegistry;

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
	protected Table createTable(Composite tableComposite,
			TableColumnLayout layout) {

		Table table = super.createTable(tableComposite, layout);
		GridData data = new GridData(GridData.FILL_BOTH);
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

		Group detailGroup = UIControlsFactory.createGroup(details, "Details");
		detailGroup.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout2 = new GridLayout(3, false);
		layout2.makeColumnsEqualWidth = false;
		detailGroup.setLayout(layout2);
		//

		UIControlsFactory.createLabel(detailGroup, "First Name:"); //$NON-NLS-1$
		Text txtFirst = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				BIND_ID_FIRST_NAME);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtFirst);

		Label imageLable = new Label(detailGroup, SWT.BORDER);
		GridData imagData = new GridData();
		imagData.verticalAlignment = GridData.FILL;

		imagData.verticalSpan = 4;
		Image photoImage = EDairyActivator.getImage(ImageRegistry.smileFace);
		imageLable.setImage(photoImage);
		imageLable.setLayoutData(imagData);

		UIControlsFactory.createLabel(detailGroup, "Last Name:"); //$NON-NLS-1$
		Text txtLast = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				BIND_ID_LAST_NAME);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtLast);

		UIControlsFactory.createLabel(detailGroup, "Phone Number"); //$NON-NLS-1$
		Text txtPhone = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				BIND_ID_PHONE_NUM); 
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtPhone);

		UIControlsFactory.createLabel(detailGroup, "Department"); //$NON-NLS-1$
		Text txtDep = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				BIND_ID_DEPARTMENT); 
		GridDataFactory.fillDefaults().grab(true, false).applyTo(txtDep);

		UIControlsFactory.createLabel(detailGroup, "Address"); //$NON-NLS-1$
		Text txtAdd = UIControlsFactory.createText(detailGroup, SWT.BORDER,
				BIND_ID_ADDRESS); //$NON-NLS-1$
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).applyTo(txtAdd);

		//		UIControlsFactory.createLabel(detailGroup, "Gender:"); //$NON-NLS-1$
		// ChoiceComposite ccGender = new ChoiceComposite(detailGroup, SWT.NONE,
		// false);
		// ccGender.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
		// 1, 1));
		// ccGender.setOrientation(SWT.HORIZONTAL);

		Composite buttonPanel = UIControlsFactory.createComposite(detailGroup);
		GridDataFactory.fillDefaults().span(3, 1).grab(true, false).align(SWT.CENTER, SWT.FILL).applyTo(buttonPanel);
		buttonPanel.setLayout(new GridLayout(2, false));
		Button saveButton = UIControlsFactory.createButton(buttonPanel, "Save");
		saveButton
				.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false, false));

		Button cancelButton = UIControlsFactory.createButton(buttonPanel,
				"Cancel");
		cancelButton.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, false,
				false));

		// DefaultButtonManager dbm = new
		// DefaultButtonManager(parent.getShell());
		// dbm.addButton(mdComposite.getButtonApply(), mdComposite);
	}

}
