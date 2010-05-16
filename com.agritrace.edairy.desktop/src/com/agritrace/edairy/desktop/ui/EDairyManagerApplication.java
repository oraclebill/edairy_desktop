/**
 * 
 */
package com.agritrace.edairy.desktop.ui;

import org.eclipse.riena.internal.core.test.ExtensionRegistryAnalyzer;
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

import com.agritrace.edairy.desktop.collection.ui.controllers.MilkCollectionJournalController;
import com.agritrace.edairy.desktop.collection.ui.views.MilkCollectionJournalView;
import com.agritrace.edairy.desktop.dairy.locations.ui.views.DairyLocationView;
import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationController;
import com.agritrace.edairy.desktop.dairy.profile.ui.views.DairyProfileView;
import com.agritrace.edairy.desktop.finance.ui.views.CreditJournalView;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberSearchViewController;
import com.agritrace.edairy.desktop.member.ui.controllers.NewMembeViewController;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchView;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierListView;
import com.agritrace.edairy.desktop.services.ui.controllers.ServiceLogViewController;
import com.agritrace.edairy.desktop.services.ui.views.ServiceRequestLogView;
import com.agritrace.edairy.desktop.setup.ui.controllers.StaffInfoViewController;
import com.agritrace.edairy.desktop.setup.ui.controllers.VehicleLogViewController;
import com.agritrace.edairy.desktop.setup.ui.views.StaffInfoView;
import com.agritrace.edairy.desktop.setup.ui.views.VehicleLogView;
import com.agritrace.edairy.desktop.ui.views.BlankView;
import com.agritrace.edairy.desktop.ui.views.DairyHomeView;
import com.agritrace.edairy.desktop.ui.views.DeliveryView;
import com.agritrace.edairy.desktop.ui.views.InseminationRequestView;
import com.agritrace.edairy.desktop.ui.views.MemberPayablesReportView;
import com.agritrace.edairy.desktop.ui.views.MemberStatementReportView;
import com.agritrace.edairy.desktop.ui.views.MilkProductionReportView;
import com.agritrace.edairy.desktop.ui.views.MonthlyCreditReportView;
import com.agritrace.edairy.desktop.ui.views.VeterinaryRequestView;

/**
 * @author oraclebill
 * 
 */
public class EDairyManagerApplication extends SwtApplication {

    public static final String BG_DARK = "edm_dark_background";
    public static final String BG_LIGHT = "edm_light_background";

    public EDairyManagerApplication() {
	super();
	LnfManager.setLnf(new EDairyManagerLookAndFeel());
    }

    // @Override
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

	ExtensionRegistryAnalyzer.dumpRegistry("org.eclipse.ui");
	
	final ApplicationNode app = new ApplicationNode("eDairy Manager"); //$NON-NLS-1$
	final WorkareaManager workarea = WorkareaManager.getInstance();

	ISubApplicationNode 	subAppNode;
	IModuleGroupNode 	moduleGroupNode;
	IModuleNode 		moduleNode;

	//
	// HOME TAB
	//

	subAppNode = new SubApplicationNode("eDairy Manager"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, "com.agritrace.edairy.desktop.home"); //$NON-NLS-1$

	//
	// HOME MODULE GROUP
	//
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("home.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	final IModuleNode moduleDairy = NodeFactory.createModule(
		new NavigationNodeId("desktop.home.module"), "Home", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	moduleDairy.setClosable(false);
	NodeFactory.createSubMobule(new NavigationNodeId("desktop.home.view"), "Home", moduleDairy, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// MILK TAB
	//
//
//	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.manager.main"), "Milk Operations"); //$NON-NLS-1$
//	app.addChild(subAppNode);
//	workarea.registerDefinition(subAppNode, "com.agritrace.edairy.desktop.manager.milk"); //$NON-NLS-1$
//	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("milk.navgroup"));
//	subAppNode.addChild(moduleGroupNode);
//
//	final IModuleNode moduleSupplyChain = NodeFactory.createModule(
//		new NavigationNodeId("edm.supplychain"), "Milk Collection", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	moduleSupplyChain.setClosable(false);
//
//	NodeFactory.createSubMobule(
//		new NavigationNodeId("edm.supplychain.collectionslog"), "Milk Logs", moduleSupplyChain, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.supplychain.collections"), "Collections Entry", moduleSupplyChain, MilkCollectionJournalView.ID, MilkCollectionJournalController.class); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.supplychain.deliveries"), "Deliveries Entry", moduleSupplyChain, DeliveryView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//
//	//
//	// MEMBER TAB
//	//
//
//	subAppNode = new SubApplicationNode(
//		new NavigationNodeId("com.agritrace.edairy.desktop.manager.members"), "Membership Management"); //$NON-NLS-1$
//	app.addChild(subAppNode);
//	workarea.registerDefinition(subAppNode, "com.agritrace.edairy.desktop.manager.members"); //$NON-NLS-1$
//	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("members.navgroup"));
//	subAppNode.addChild(moduleGroupNode);
//
//	final IModuleNode moduleMembers = NodeFactory.createModule(
//		new NavigationNodeId("edm.members"), "Members", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	moduleMembers.setClosable(false);
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.members.newMember"), "Add Member", moduleMembers, MemberSearchView.ID, NewMembeViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.members.list"), "Search Members", moduleMembers, MemberSearchView.ID, MemberSearchViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
//
//	final IModuleNode moduleServices = NodeFactory.createModule(
//		new NavigationNodeId("edm.services"), "Services", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	moduleServices.setClosable(false);
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.services.log"), "Request Log", moduleServices, ServiceRequestLogView.ID, ServiceLogViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.services.veterinary"), "Vet Request Entry", moduleServices, VeterinaryRequestView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.services.insemination"), "A.I. Request Entry", moduleServices, InseminationRequestView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//
//	final IModuleNode financeMembers = NodeFactory.createModule(
//		new NavigationNodeId("edm.finances"), "Finance", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	financeMembers.setClosable(false);
//	NodeFactory.createSubMobule(
//		new NavigationNodeId("edm.finances.log"), "Journal Log", financeMembers, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.finances.credits"), "Credit Journal Entry", financeMembers, CreditJournalView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory.createSubMobule(
//		new NavigationNodeId("edm.finances.payments"), "Payment Journal Entry", financeMembers, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//
//	//
//	// TOOLS TAB
//	//
//	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.manager.ftools"), "Office Tools"); //$NON-NLS-1$
//	app.addChild(subAppNode);
//	workarea.registerDefinition(subAppNode, "com.agritrace.edairy.desktop.manager.ftools"); //$NON-NLS-1$
//	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("tools.navgroup"));
//	subAppNode.addChild(moduleGroupNode);
//
//	final IModuleNode moduleEvents = NodeFactory.createModule(
//		new NavigationNodeId("edm.events"), "Events", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	moduleEvents.setClosable(false);
//	NodeFactory.createSubMobule(
//		new NavigationNodeId("edm.services.events"), "Event List", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//
//	final IModuleNode moduleDirectory = NodeFactory.createModule(
//		new NavigationNodeId("edm.directory"), "Suppliers", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	moduleDirectory.setClosable(false);
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.services.suppliers"), "Supplier Directory", moduleDirectory, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.services.suppliers"), "Supplier Directory", moduleDirectory, SupplierListView.ID); //, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
//
//	//
//	// REPORTS TAB
//	//
//
//	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.manager.reports"), "Reports"); //$NON-NLS-1$
//	app.addChild(subAppNode);
//	workarea.registerDefinition(subAppNode, "com.agritrace.edairy.desktop.manager.reports"); //$NON-NLS-1$
//	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("reports.navgroup"));
//	subAppNode.addChild(moduleGroupNode);
//
//	final IModuleNode moduleReports = NodeFactory.createModule(
//		new NavigationNodeId("edm.reports"), "Reports", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	moduleReports.setClosable(false);
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.reports.intake"), "Milk Collection", moduleReports, MilkProductionReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.reports.members.payables"), "Members Payables", moduleReports, MemberPayablesReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.reports.members.statement"), "Member Statement", moduleReports, MemberStatementReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.reports.finance.credit"), "Monthly Credit Sales", moduleReports, MonthlyCreditReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.members"), "Members", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.finance"), "Finance", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.services"), "Services", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.events"), "Events", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.marketplace"), "Marketplace", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.dairy"), "Dairy", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory.createSubMobule(new NavigationNodeId("edm.reports.custom"), "Custom", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//
//	//
//	// ADMIN TAB
//	//
//
//	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.manager.administration"), "Admin"); //$NON-NLS-1$
//	app.addChild(subAppNode);
//	workarea.registerDefinition(subAppNode, "com.agritrace.edairy.desktop.manager.administration"); //$NON-NLS-1$
//	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("admin.navgroup"));
//	subAppNode.addChild(moduleGroupNode);
//
//	final IModuleNode moduleSystem = NodeFactory.createModule(
//		new NavigationNodeId("edm.sysadmin"), "Administration", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//	moduleSystem.setClosable(false);
//	NodeFactory.createSubMobule(
//		new NavigationNodeId("edm.dairy.info"), "Dairy Profile", moduleSystem, DairyProfileView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory.createSubMobule(
//		new NavigationNodeId("edm.dairy.routes"), "Branch Locations", moduleSystem, DairyLocationView.ID, DairyLocationController.class); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.dairy.staff"), "Employee Directory", moduleSystem, StaffInfoView.ID, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(
//			new NavigationNodeId("edm.dairy.vehicles"), "Vehicle Log", moduleSystem, VehicleLogView.ID, VehicleLogViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
//	NodeFactory
//		.createSubMobule(new NavigationNodeId("edm.dairy.bins"), "Container Log", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.routes"), "Routes", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//	//		NodeFactory.createSubMobule(new NavigationNodeId("edm.dairy.roles"), "Roles", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	return app;

    }

}
