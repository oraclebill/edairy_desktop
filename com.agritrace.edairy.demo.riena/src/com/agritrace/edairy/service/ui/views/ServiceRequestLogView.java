package com.agritrace.edairy.service.ui.views;

import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Services log view
 * 
 * @author Spark Wan
 * 
 */
public class ServiceRequestLogView extends SubModuleView {

	public static final String ID = ServiceRequestLogView.class.getName();

	@Override
	protected void basicCreatePartControl(Composite parent) {

		parent.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		parent.setLayout(new GridLayout(1, false));

		Composite panel = new Composite(parent, SWT.NULL);
		panel.setLayout(new GridLayout(2, false));
		panel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		panel.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));

		// Creates filter section
		ServiceRequestFilterSection filterSection = new ServiceRequestFilterSection();
		filterSection.createSection(panel);	
		// Since Master/Detail are in different composite, we need to pass the panel as detail composite
		ServiceRequestMasterDetailComposite mdComposite = new ServiceRequestMasterDetailComposite(
				panel, SWT.NONE);
		this.addUIControl(mdComposite, "master"); //$NON-NLS-1$

	}


}
