/**
 * 
 */
package com.agritrace.edairy.desktop.app;

import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.model.ApplicationNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.navigation.ui.controllers.ApplicationController;
import org.eclipse.riena.navigation.ui.swt.application.SwtApplication;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.desktop.DesktopActivator;

//import com.agritrace.edairy.demo.riena.controllers.MemberInfoViewController;
//import com.agritrace.edairy.demo.riena.controllers.StaffInfoViewController;
//import com.agritrace.edairy.demo.riena.views.CreditJournalView;
//import com.agritrace.edairy.demo.riena.views.DairyHomeView;
//import com.agritrace.edairy.demo.riena.views.BlankView;
//import com.agritrace.edairy.demo.riena.views.DeliveryView;
//import com.agritrace.edairy.demo.riena.views.DairyProfileView;
//import com.agritrace.edairy.demo.riena.views.InseminationRequestView;
//import com.agritrace.edairy.demo.riena.views.MemberListView;
//import com.agritrace.edairy.demo.riena.views.MemberPayablesReportView;
//import com.agritrace.edairy.demo.riena.views.MemberStatementReportView;
//import com.agritrace.edairy.demo.riena.views.MembersInfoView;
//import com.agritrace.edairy.demo.riena.views.MilkCollectionView;
//import com.agritrace.edairy.demo.riena.views.MilkProductionReportView;
//import com.agritrace.edairy.demo.riena.views.MonthlyCreditReportView;
//import com.agritrace.edairy.demo.riena.views.ServiceRequestLogView;
//import com.agritrace.edairy.demo.riena.views.StaffInfoView;
//import com.agritrace.edairy.demo.riena.views.VeterinaryRequestView;

/**
 * @author oraclebill
 *
 */
public class DesktopApplication extends SwtApplication {

	public static final String BG_DARK =  "edm_dark_background";
	public static final String BG_LIGHT =  "edm_light_background";


	public DesktopApplication() {
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

		ApplicationNode app = new ApplicationNode("eDairy Manager Desktop"); //$NON-NLS-1$

		ISubApplicationNode dataEntry = new SubApplicationNode("Data Entry"); //$NON-NLS-1$
		app.addChild(dataEntry);
		ISubApplicationNode reports = new SubApplicationNode("Reports"); //$NON-NLS-1$
		app.addChild(reports);

//		ApplicationController ac = (ApplicationController) app.getNavigationNodeController(); 
//		ac.getStatusline().setMessage("Hello World!");

		return app;

	}
	
	

}
