package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class EmployeeDirectoryView extends AbstractDirectoryView {
	public EmployeeDirectoryView() {
	}

	public static final String ID = "edairy.operations.employee.directory";

	public static final String BIND_ID_FILTER_NAME = "bind.id.filter.name";
	public static final String BIND_ID_FILTER_DEPT = "bind.id.filter.dept";
	public static final String BIND_ID_FILTER_JOBFUNC = "bind.id.filter.position";

	@Override
	protected void createFilterConditions(Composite parent) {
		GridLayout gridLayout = (GridLayout) parent.getLayout();
		gridLayout.marginLeft = 2;
		gridLayout.marginLeft = 3;
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = false;
		GridLayout gl_parent = GridLayoutFactory.swtDefaults().margins(0, 0).numColumns(2).create();
		gl_parent.marginTop = 5;
		gl_parent.marginRight = 3;
		gl_parent.marginLeft = 3;
		parent.setLayout(gl_parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(parent);

		Group filterGroup = new Group(parent, SWT.NONE);
		filterGroup.setText("Search Criteria");
		filterGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		filterGroup.setLayout(new GridLayout(2, false));
		filterGroup.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		{
			// Employee name
			Label label_1 = UIControlsFactory.createLabel(filterGroup, "Name");
			Text companyName = UIControlsFactory.createText(filterGroup, SWT.None);
			companyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(companyName);
			addUIControl(companyName, BIND_ID_FILTER_NAME);
		}
		{
			// Department
			Label label_2 = UIControlsFactory.createLabel(filterGroup, "Department");
			Combo dept = UIControlsFactory.createCombo(filterGroup);
			dept.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dept);
			addUIControl(dept, BIND_ID_FILTER_DEPT);
		}
		{
			// job
			Label label_2 = UIControlsFactory.createLabel(filterGroup, "Position");
			Combo job = UIControlsFactory.createCombo(filterGroup);
			job.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(job);
			addUIControl(job, BIND_ID_FILTER_JOBFUNC);
		}
		Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite_1.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

	}

}
