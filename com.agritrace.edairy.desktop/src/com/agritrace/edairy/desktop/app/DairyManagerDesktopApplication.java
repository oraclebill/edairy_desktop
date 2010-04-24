/**
 * 
 */
package com.agritrace.edairy.desktop.app;

import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ApplicationNode;
import org.eclipse.riena.navigation.model.ModuleGroupNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.navigation.ui.controllers.ApplicationController;
import org.eclipse.riena.navigation.ui.swt.application.SwtApplication;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.workarea.WorkareaManager;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.DesktopActivator;

import com.agritrace.edairy.desktop.modules.dairy.DairyProfileView;

/**
 * @author oraclebill
 *
 */
public class DairyManagerDesktopApplication extends SwtApplication {

	public static final String BG_DARK =  "edm_dark_background";
	public static final String BG_LIGHT =  "edm_light_background";


	public DairyManagerDesktopApplication() {
		super();
		LnfManager.setLnf(new EDairyManagerLookAndFeel());
	}

	//    @Override
	protected Bundle getBundle() {
		return DesktopActivator.getDefault().getBundle();
	}

	@Override
	protected void initializeNodeDefaultIcon(INavigationNode<?> node) {
		// TODO Auto-generated method stub
		super.initializeNodeDefaultIcon(node);
	}

    /**
     * @see org.eclipse.riena.navigation.ui.swt.application.SwtApplication#createApplicationController(org.eclipse.riena.navigation.IApplicationModel)
     */
    @Override
    protected ApplicationController createApplicationController(
                    IApplicationNode node) {
            ApplicationController controller = super
                            .createApplicationController(node);
            controller.setMenubarVisible(true);
            return controller;
    }

	@Override
	protected IApplicationNode createModel() {

		IApplicationNode applicationNode = super.createModel();
		applicationNode.setLabel("eDairy Manager Desktop");
//		applicationNode.setIcon("path to icon");
		
		
		ISubApplicationNode subApplication = new SubApplicationNode(
				new NavigationNodeId("com.agritrace.edairy.desktop.navigation.subapplication"), 
				"Main");
		WorkareaManager.getInstance().registerDefinition(subApplication, "subapplication.main");
		applicationNode.addChild(subApplication);
		
		IModuleGroupNode groupTopLevel = new ModuleGroupNode(new NavigationNodeId("primary.navgroup"));
		subApplication.addChild(groupTopLevel);

		IModuleNode moduleSystem = NodeFactory.createModule(
				new NavigationNodeId("edm.sysadmin"), "Setup", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleSystem.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.info"), "Dairy Profile", moduleSystem, DairyProfileView.ID, 
				com.agritrace.edairy.desktop.modules.dairy.DairyProfileController.class); //$NON-NLS-1$ //$NON-NLS-2$

//		ISubApplicationNode dataEntry = new SubApplicationNode("Data Entry"); //$NON-NLS-1$
//		applicationNode.addChild(dataEntry);
//		ISubApplicationNode reports = new SubApplicationNode("Reports"); //$NON-NLS-1$
//		applicationNode.addChild(reports);

//		ApplicationController ac = (ApplicationController) app.getNavigationNodeController(); 
//		ac.getStatusline().setMessage("Hello World!");

		return applicationNode;

	}
	
	

}
