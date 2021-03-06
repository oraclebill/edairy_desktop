package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;

public class EmployeeDirectoryView extends AbstractDirectoryView {
	public static final String BIND_ID_FILTER_DEPT = "bind.id.filter.dept";

	public static final String BIND_ID_FILTER_JOBFUNC = "bind.id.filter.position";

	public static final String BIND_ID_FILTER_NAME = "bind.id.filter.name";
	public static final String ID = "edairy.operations.employee.directory";

	public EmployeeDirectoryView() {
	}

	@Override
	protected void createFilterConditions(Composite top) {
		final Composite parent = UIControlsFactory.createComposite(top);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(parent);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(parent);

		final Group filterGroup = new Group(parent, SWT.NONE);
		filterGroup.setText("Search Criteria");
		filterGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		filterGroup.setLayout(new GridLayout(2, false));
		filterGroup.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		{
			UIControlsFactory.createLabel(filterGroup, "Name");
			final Text companyName = UIControlsFactory.createText(filterGroup, SWT.None);
			companyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(companyName);
			addUIControl(companyName, BIND_ID_FILTER_NAME);
		}
		{
			UIControlsFactory.createLabel(filterGroup, "Department");
			final CCombo dept = UIControlsFactory.createCCombo(filterGroup);
			dept.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(dept);
			addUIControl(dept, BIND_ID_FILTER_DEPT);
		}
		{
			UIControlsFactory.createLabel(filterGroup, "Position");
			final CCombo job = UIControlsFactory.createCCombo(filterGroup);
			job.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
			GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(job);
			addUIControl(job, BIND_ID_FILTER_JOBFUNC);
		}
		final Composite composite_1 = new Composite(parent, SWT.NONE);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite_1.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

	}

}
