/**
 * 
 */
package com.agritrace.edairy.demo.riena;

import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ApplicationNode;
import org.eclipse.riena.navigation.model.ModuleGroupNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.navigation.ui.swt.application.SwtApplication;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.workarea.WorkareaManager;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.demo.riena.views.CreditJournalView;
import com.agritrace.edairy.demo.riena.views.DairyHomeView;
import com.agritrace.edairy.demo.riena.views.DeliveryView;
import com.agritrace.edairy.demo.riena.views.FacilityInfoView;
import com.agritrace.edairy.demo.riena.views.InseminationRequestView;
import com.agritrace.edairy.demo.riena.views.LocalDairyView;
import com.agritrace.edairy.demo.riena.views.LocalDairyViewController;
import com.agritrace.edairy.demo.riena.views.MemberInfoViewController;
import com.agritrace.edairy.demo.riena.views.MembersInfoView;
import com.agritrace.edairy.demo.riena.views.MilkCollectionView;
import com.agritrace.edairy.demo.riena.views.NetworklDairyView;
import com.agritrace.edairy.demo.riena.views.NetworklDairyViewController;
import com.agritrace.edairy.demo.riena.views.ServiceRequestLogView;
import com.agritrace.edairy.demo.riena.views.StaffInfoView;
import com.agritrace.edairy.demo.riena.views.StaffInfoViewController;
import com.agritrace.edairy.demo.riena.views.VeterinaryRequestView;

/**
 * @author oraclebill
 *
 */
public class EDairyManagerApplication extends SwtApplication {

	public static final String BG_DARK =  "edm_dark_background";
	public static final String BG_LIGHT =  "edm_light_background";


	public EDairyManagerApplication() {
		super();
		LnfManager.setLnf(new EDairyManagerLookAndFeel());
	}

	//    @Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected IApplicationNode createModel() {

		ApplicationNode app = new ApplicationNode("eDairy Manager"); //$NON-NLS-1$

		ISubApplicationNode subApp = new SubApplicationNode("Demo"); //$NON-NLS-1$
		app.addChild(subApp);

		final WorkareaManager workarea = WorkareaManager.getInstance();

		workarea.registerDefinition(subApp, "com.agritrace.edairy.manager.perspective"); //$NON-NLS-1$

		IModuleGroupNode groupTopLevel = new ModuleGroupNode(new NavigationNodeId("primary.navgroup"));
		subApp.addChild(groupTopLevel);

		IModuleNode moduleDairy = NodeFactory.createModule(
				new NavigationNodeId("edm.dairy"), "Home", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleDairy.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.home"), "Home", moduleDairy, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$

//		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.admin"), "Administrative", moduleDairy, FacilityInfoView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		IModuleNode moduleSupplyChain = NodeFactory.createModule(
				new NavigationNodeId("edm.supplychain"), "Milk Collection", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleSupplyChain.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.supplychain.collections"), "Collections", moduleSupplyChain, MilkCollectionView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.supplychain.deliveries"), "Deliveries", moduleSupplyChain, DeliveryView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//			NodeFactory.createSubMobule(new NavigationNodeId("edm.supplychain.accounts"), "Member Accounts", moduleSupplyChain, MembersInfoView.ID,MemberInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$

		IModuleNode moduleMembers = NodeFactory.createModule(
				new NavigationNodeId("edm.members"), "Members", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleMembers.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.members.accounts"), "Directory", moduleMembers, MembersInfoView.ID,MemberInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.members.farms"), "Member Farms", moduleMembers, MembersInfoView.ID); 

		IModuleNode moduleServices = NodeFactory.createModule(
				new NavigationNodeId("edm.services"), "Services", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleServices.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.veterinary"), "Veterinary", moduleServices, VeterinaryRequestView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.insemination"), "Insemination", moduleServices, InseminationRequestView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.insurance"), "Insurance", moduleServices, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.loans"), "Loans", moduleServices, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.log"), "Request Log", moduleServices, ServiceRequestLogView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		IModuleNode financeMembers = NodeFactory.createModule(
				new NavigationNodeId("edm.finances"), "Finance", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		financeMembers.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.finances.credits"), "Credit Journal", financeMembers, CreditJournalView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.finances.payments"), "Payment Journal", financeMembers, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.finances.credits2"), "", financeMembers, MembersInfoView.ID,MemberInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$


		IModuleNode moduleEvents = NodeFactory.createModule(
				new NavigationNodeId("edm.events"), "Events", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleEvents.setClosable(false);
		
		IModuleNode moduleDirectory = NodeFactory.createModule(
				new NavigationNodeId("edm.directory"), "Marketplace", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleDirectory.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.suppliers"), "Suppliers", moduleDirectory, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.tenders"), "Tenders", moduleDirectory, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.forsale"), "For Sale", moduleDirectory, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.wantedtobuy"), "Wanted", moduleDirectory, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$


		IModuleNode moduleReports = NodeFactory.createModule(
				new NavigationNodeId("edm.reports"), "Reports", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleReports.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.intake"), "Milk Collection", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.members"), "Members", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.finance"), "Finance", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.services"), "Services", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.events"), "Events", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.marketplace"), "Marketplace", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.dairy"), "Dairy", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.custom"), "Custom", moduleReports, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		IModuleNode moduleSystem = NodeFactory.createModule(
				new NavigationNodeId("edm.sysadmin"), "Setup", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleSystem.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.info"), "Dairy Profile", moduleSystem, FacilityInfoView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.staff"), "Staff Directory", moduleSystem, StaffInfoView.ID, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.roles"), "Roles", moduleSystem, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.routes"), "Routes", moduleSystem, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.vehicles"), "Vehicles", moduleSystem, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.bins"), "Bins", moduleSystem, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		return app;

	}

}
