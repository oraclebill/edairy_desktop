package com.agritrace.edairy.desktop.operations.ui.views;

import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.agritrace.edairy.desktop.common.ui.util.FormUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.dialogs.ContainerBindingConstants;

public class ContainerDirectoryView extends AbstractDirectoryView {

	public static final String ID = "edairy.containers.directory";

	public ContainerDirectoryView() {
	}

	@Override
	protected void createFilterConditions(Composite parent) {
		final Group filterGroup = UIControlsFactory.createGroup(parent, "Search Criteria");
		filterGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		filterGroup.setLayout(new GridLayout(2, false));
		filterGroup.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		//Tracking number
		UIControlsFactory.createLabel(filterGroup, "Tracking Number :");
		final Control text = UIControlsFactory.createText(filterGroup, SWT.NONE,
				ContainerBindingConstants.BIND_ID_CONTAINER_TRACKING_NUM);
		GridData gd = new GridData();
		gd.widthHint = FormUtil.WIDTH_UNIT * 3;
		gd.verticalAlignment = SWT.FILL;
		text.setLayoutData(gd);
				
//		//Capacity
//		UIControlsFactory.createLabel(parent, "Capacity");
//		final Text capacityText = UIControlsFactory.createTextDecimal(parent,
//				ContainerBindingConstants.BIND_ID_CONTAINER_CAPACITY);
//		GridData gd2 = new GridData();
//		gd2.widthHint = FormUtil.WIDTH_UNIT * 3;
//		gd2.verticalAlignment = SWT.FILL;
//		capacityText.setLayoutData(gd2);
	}

}
