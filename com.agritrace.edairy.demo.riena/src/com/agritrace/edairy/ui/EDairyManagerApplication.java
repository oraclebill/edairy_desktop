/**
 * 
 */
package com.agritrace.edairy.ui;

import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.model.ApplicationNode;
import org.eclipse.riena.navigation.model.ModuleGroupNode;
import org.eclipse.riena.navigation.model.SubApplicationNode;
import org.eclipse.riena.navigation.ui.swt.application.SwtApplication;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.workarea.WorkareaManager;
import org.osgi.framework.Bundle;

import com.agritrace.edairy.dairy.ui.views.DairyLocationView;
import com.agritrace.edairy.dairy.ui.views.DairyProfileView;
import com.agritrace.edairy.finance.ui.CreditJournalView;
import com.agritrace.edairy.member.ui.controllers.MemberSearchViewController;
import com.agritrace.edairy.member.ui.controllers.NewMembeViewController;
import com.agritrace.edairy.milkCollection.ui.controllers.MilkCollectionJournalController;
import com.agritrace.edairy.milkCollection.ui.views.MilkCollectionJournalView;
import com.agritrace.edairy.service.ui.controllers.ServiceLogViewController;
import com.agritrace.edairy.service.ui.views.ServiceRequestLogView;
import com.agritrace.edairy.tools.ui.views.SupplierListView;
import com.agritrace.edairy.setup.ui.controllers.StaffInfoViewController;
import com.agritrace.edairy.setup.ui.controllers.VehicleLogViewController;
import com.agritrace.edairy.setup.ui.views.StaffInfoView;
import com.agritrace.edairy.setup.ui.views.VehicleLogView;
import com.agritrace.edairy.ui.views.BlankView;
import com.agritrace.edairy.ui.views.DairyHomeView;
import com.agritrace.edairy.ui.views.DeliveryView;
import com.agritrace.edairy.ui.views.InseminationRequestView;
import com.agritrace.edairy.ui.views.MemberPayablesReportView;
import com.agritrace.edairy.ui.views.MemberStatementReportView;
import com.agritrace.edairy.ui.views.MilkProductionReportView;
import com.agritrace.edairy.ui.views.MonthlyCreditReportView;
import com.agritrace.edairy.ui.views.VeterinaryRequestView;
import com.agritrace.edairy.member.ui.views.MemberSearchView;

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
		return EDairyActivator.getDefault().getBundle();
	}

	
	@Override
	protected void initializeNodeDefaultIcon(INavigationNode<?> node) {
		// TODO Auto-generated method stub
		super.initializeNodeDefaultIcon(node);
	}

	
	@Override
	protected IApplicationNode createModel() {

		ApplicationNode app = new ApplicationNode("eDairy Manager"); //$NON-NLS-1$

		ISubApplicationNode subApp = new SubApplicationNode(  "Home"); //$NON-NLS-1$
		app.addChild(subApp);

		final WorkareaManager workarea = WorkareaManager.getInstance();

		workarea.registerDefinition(subApp, "com.agritrace.edairy.manager.home"); //$NON-NLS-1$

		IModuleGroupNode groupTopLevel = new ModuleGroupNode(new NavigationNodeId("primary.navgroup"));

		
		//
		// MEMBER TAB
		// 

		subApp.addChild(groupTopLevel);

		IModuleNode moduleDairy = NodeFactory.createModule(
				new NavigationNodeId("edm.dairy"), "Home", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleDairy.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.home"), "Home", moduleDairy, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$


		//
		// MILK TAB
		// 
		
	    subApp = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.manager.main"), "Milk Operations"); //$NON-NLS-1$
		app.addChild(subApp);
		workarea.registerDefinition(subApp, "com.agritrace.edairy.manager.milk"); //$NON-NLS-1$
		groupTopLevel = new ModuleGroupNode(new NavigationNodeId("milk.navgroup"));
		subApp.addChild(groupTopLevel);

		IModuleNode moduleSupplyChain = NodeFactory.createModule(
				new NavigationNodeId("edm.supplychain"), "Milk Collection", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleSupplyChain.setClosable(false);
		
		NodeFactory.createSubMobule(new NavigationNodeId("edm.supplychain.collectionslog"), "Milk Logs", moduleSupplyChain,BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.supplychain.collections"), "Collections Entry", moduleSupplyChain,MilkCollectionJournalView.ID, MilkCollectionJournalController.class); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.supplychain.deliveries"), "Deliveries Entry", moduleSupplyChain, DeliveryView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		//
		// MEMBER TAB
		// 

		subApp = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.manager.members"), "Membership Management"); //$NON-NLS-1$
		app.addChild(subApp);
		workarea.registerDefinition(subApp, "com.agritrace.edairy.manager.members"); //$NON-NLS-1$
		groupTopLevel = new ModuleGroupNode(new NavigationNodeId("members.navgroup"));
		subApp.addChild(groupTopLevel);

		IModuleNode moduleMembers = NodeFactory.createModule(
				new NavigationNodeId("edm.members"), "Members", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleMembers.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.members.newMember"), "Add Member", moduleMembers, MemberSearchView.ID,NewMembeViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.members.list"), "Search Members", moduleMembers, MemberSearchView.ID,MemberSearchViewController.class); //$NON-NLS-1$ //$NON-NLS-2$

		IModuleNode moduleServices = NodeFactory.createModule(
				new NavigationNodeId("edm.services"), "Services", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleServices.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.log"), "Request Log", moduleServices, ServiceRequestLogView.ID, ServiceLogViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.veterinary"), "Vet Request Entry", moduleServices, VeterinaryRequestView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.insemination"), "A.I. Request Entry", moduleServices, InseminationRequestView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		IModuleNode financeMembers = NodeFactory.createModule(
				new NavigationNodeId("edm.finances"), "Finance", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		financeMembers.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.finances.log"), "Journal Log", financeMembers, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.finances.credits"), "Credit Journal Entry", financeMembers, CreditJournalView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.finances.payments"), "Payment Journal Entry", financeMembers, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		//
		// TOOLS TAB
		// 
	    subApp = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.manager.ftools"), "Office Tools"); //$NON-NLS-1$
		app.addChild(subApp);
		workarea.registerDefinition(subApp, "com.agritrace.edairy.manager.ftools"); //$NON-NLS-1$
		groupTopLevel = new ModuleGroupNode(new NavigationNodeId("tools.navgroup"));
		subApp.addChild(groupTopLevel);

		IModuleNode moduleEvents = NodeFactory.createModule(
				new NavigationNodeId("edm.events"), "Events", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleEvents.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.events"), "Event List", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		
		IModuleNode moduleDirectory = NodeFactory.createModule(
				new NavigationNodeId("edm.directory"), "Suppliers", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleDirectory.setClosable(false);
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.suppliers"), "Supplier Directory", moduleDirectory, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.suppliers"), "Supplier Directory", moduleDirectory, SupplierListView.ID); //, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$

		
		//
		// REPORTS TAB
		// 
		
	    subApp = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.manager.reports"), "Reports"); //$NON-NLS-1$
		app.addChild(subApp);
		workarea.registerDefinition(subApp, "com.agritrace.edairy.manager.reports"); //$NON-NLS-1$
		groupTopLevel = new ModuleGroupNode(new NavigationNodeId("reports.navgroup"));
		subApp.addChild(groupTopLevel);

		IModuleNode moduleReports = NodeFactory.createModule(
				new NavigationNodeId("edm.reports"), "Reports", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleReports.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.intake"), "Milk Collection", moduleReports, MilkProductionReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.members.payables"), "Members Payables", moduleReports, MemberPayablesReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.members.statement"), "Member Statement", moduleReports, MemberStatementReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.finance.credit"), "Monthly Credit Sales", moduleReports, MonthlyCreditReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$

//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.members"), "Members", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.finance"), "Finance", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.services"), "Services", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.events"), "Events", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.marketplace"), "Marketplace", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.dairy"), "Dairy", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.custom"), "Custom", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		//
		// ADMIN TAB
		// 
		
	    subApp = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.manager.administration"), "Admin"); //$NON-NLS-1$
		app.addChild(subApp);
		workarea.registerDefinition(subApp, "com.agritrace.edairy.manager.administration"); //$NON-NLS-1$
		groupTopLevel = new ModuleGroupNode(new NavigationNodeId("admin.navgroup"));
		subApp.addChild(groupTopLevel);

		
		IModuleNode moduleSystem = NodeFactory.createModule(
				new NavigationNodeId("edm.sysadmin"), "Administration", groupTopLevel); //$NON-NLS-1$ //$NON-NLS-2$
		moduleSystem.setClosable(false);
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.info"), "Dairy Profile", moduleSystem, DairyProfileView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.routes"), "Branch Locations", moduleSystem, DairyLocationView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.staff"), "Employee Directory", moduleSystem, StaffInfoView.ID, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.vehicles"), "Vehicle Log", moduleSystem, VehicleLogView.ID, VehicleLogViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.bins"), "Container Log", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.routes"), "Routes", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.roles"), "Roles", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		return app;

	}
	
	

}
