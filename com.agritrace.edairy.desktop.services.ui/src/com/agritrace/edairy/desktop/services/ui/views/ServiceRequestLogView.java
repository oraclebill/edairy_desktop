package com.agritrace.edairy.desktop.services.ui.views;

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

    public static final String ID = "animalhealth.services.log.view"; //$NON-NLS-1$
    
    
    public static final String BIND_ID_MASTER = "master"; //$NON-NLS-1$

    @Override
    protected void basicCreatePartControl(Composite parent) {

	parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

	parent.setLayout(new GridLayout(1, false));

	final Composite panel = new Composite(parent, SWT.NULL);
	panel.setLayout(new GridLayout(2, false));
	panel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	panel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

	// Creates filter section
	final ServiceRequestFilterSection filterSection = new ServiceRequestFilterSection();
	filterSection.createSection(panel);
	// Since Master/Detail are in different composite, we need to pass the
	// panel as detail composite
	final ServiceRequestMasterDetailComposite mdComposite = new ServiceRequestMasterDetailComposite(panel, SWT.NONE);
	addUIControl(mdComposite, BIND_ID_MASTER);
	addUIControl(mdComposite.getTypeSpecialComposite(),
		ServiceRequestMasterDetailComposite.BIND_ID_SPECIFIC_CONTAINER);

    }

}
