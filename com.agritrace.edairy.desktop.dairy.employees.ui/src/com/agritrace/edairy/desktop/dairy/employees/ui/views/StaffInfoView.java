package com.agritrace.edairy.desktop.dairy.employees.ui.views;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class StaffInfoView extends SubModuleView {

	public static final String ID = "dairy.employee.masterdetail.view";
	public static final String BIND_ID_MASTER = "master"; //$NON-NLS-1$

	public StaffInfoView() {
	}

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		final Composite composite = new Composite(parent, SWT.NONE);
		final GridData data = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(data);

		final GridLayout layout = new GridLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		layout.numColumns = 1;
		composite.setLayout(layout);
		composite.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		final StaffInfoMasterDetailComposite mdComposite = new StaffInfoMasterDetailComposite(composite, SWT.NONE);

		addUIControl(mdComposite, BIND_ID_MASTER);
		// this.addUIControl(mdComposite.getTable(),
		// AbstractMasterDetailsComposite.BIND_ID_TABLE);
		// for (Object control : mdComposite.getUIControls()) {
		// addUIControl(control, SWTBindingPropertyLocator.getInstance()
		// .locateBindingProperty(control));
		// }

	}

}
