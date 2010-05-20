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
import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationController;
import com.agritrace.edairy.desktop.dairy.locations.ui.views.DairyLocationView;
import com.agritrace.edairy.desktop.dairy.profile.ui.views.DairyProfileView;
import com.agritrace.edairy.desktop.deliveries.ui.views.DeliveryView;
import com.agritrace.edairy.desktop.finance.ui.views.CreditJournalView;
import com.agritrace.edairy.desktop.home.views.DairyHomeView;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberSearchViewController;
import com.agritrace.edairy.desktop.member.ui.controllers.NewMemberViewController;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchView;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierListViewController;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierListView;
import com.agritrace.edairy.desktop.services.ui.controllers.ServiceRequestViewController;
import com.agritrace.edairy.desktop.services.ui.views.ServiceRequestView;
import com.agritrace.edairy.desktop.setup.ui.controllers.StaffInfoViewController;
import com.agritrace.edairy.desktop.setup.ui.controllers.VehicleLogViewController;
import com.agritrace.edairy.desktop.setup.ui.views.StaffInfoView;
import com.agritrace.edairy.desktop.setup.ui.views.VehicleLogView;
import com.agritrace.edairy.desktop.ui.views.BlankView;
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

    private static final String MILK_MODULEGRP = "milk.navgroup";
    private static final String MILK_COLLECTION_ENTRY_SUBMODULE = "edm.milk.collection.entry";
    private static final String MILK_COLLECTION_LOG_SUBMODULE = "edm.milk.collection.log";
    private static final String MILK_COLLECTION_MODULE = "edm.milk.collection";
    public static final String BG_DARK = "edm_dark_background";
    public static final String BG_LIGHT = "edm_light_background";

        public static final String TAB_HOME 		= "com.agritrace.edairy.desktop.home"; //$NON-NLS-1$
        public static final String TAB_MILK	 	= "com.agritrace.edairy.desktop.milk"; //$NON-NLS-1$
        public static final String TAB_MEMBERS 		= "com.agritrace.edairy.desktop.members"; //$NON-NLS-1$
        public static final String TAB_FINANCE 		= "com.agritrace.edairy.desktop.finance"; //$NON-NLS-1$
        public static final String TAB_ANIMALHEALTH 	= "com.agritrace.edairy.desktop.animalhealth"; //$NON-NLS-1$
        public static final String TAB_OPERATIONS 		= "com.agritrace.edairy.desktop.operations"; //$NON-NLS-1$
        public static final String TAB_REPORTS 		= "com.agritrace.edairy.desktop.reports"; //$NON-NLS-1$
        public static final String TAB_SYSTEM 		= "com.agritrace.edairy.desktop.system"; //$NON-NLS-1$
    
        public static final String MODULEGROUP_HOME 	= "modulegroup.desktop.home"; //$NON-NLS-1$
        public static final String MODULEGROUP_MILK 	= "modulegroup.desktop.milk"; //$NON-NLS-1$
        public static final String MODULEGROUP_MEMBERS 	= "modulegroup.desktop.members"; //$NON-NLS-1$
        public static final String MODULEGROUP_FINANCE 	= "modulegroup.desktop.finance"; //$NON-NLS-1$
        public static final String MODULEGROUP_OPERATONS 	= "modulegroup.desktop.operations"; //$NON-NLS-1$
        public static final String MODULEGROUP_ANIMALHEALTH = "modulegroup.desktop.animalhealth"; //$NON-NLS-1$
        public static final String MODULEGROUP_REPORTS 	= "modulegroup.desktop.reports"; //$NON-NLS-1$
        public static final String MODULEGROUP_SYSTEM 	= "modulegroup.desktop.system"; //$NON-NLS-1$
    //
    //
    // public static final String LABEL_APPLICATION = "eDairy Manager Desktop";
    // public static final String LABEL_HOME = "Home";
    // public static final String LABEL_MILK = "Milk";
    // public static final String LABEL_MEMBERS = "Members";
    // public static final String LABEL_FINANCE = "Finance";
    // public static final String LABEL_OPERATONS = "Operations";
    // public static final String LABEL_ANIMALHEALTH = "Veterinary";
    // public static final String LABEL_REPORTS = "Reports";
    // public static final String LABEL_SYSTEM = "System";
    //

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

	ISubApplicationNode subAppNode;
	IModuleGroupNode moduleGroupNode;
	IModuleNode moduleNode;

	//
	// HOME TAB
	//

	subAppNode = new SubApplicationNode("Home"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_HOME); //$NON-NLS-1$

	//
	// HOME MODULE GROUP
	//
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("home.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	moduleNode = NodeFactory.createModule("desktop.home.module", "Home", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("desktop.home.view", "Home", moduleNode, DairyHomeView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// MILK TAB
	//

	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.milk"), "Milk"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_MILK); //$NON-NLS-1$

	//
	// COLLECTION MODULE GROUP
	//
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MILK_MODULEGRP));
	subAppNode.addChild(moduleGroupNode);

	moduleNode = NodeFactory.createModule(MILK_COLLECTION_MODULE, "Milk Collection", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule(MILK_COLLECTION_LOG_SUBMODULE, "Collection Log", moduleNode, BlankView.ID);
	NodeFactory.createSubModule(MILK_COLLECTION_ENTRY_SUBMODULE,
		"Log New Collections", moduleNode, MilkCollectionJournalView.ID, MilkCollectionJournalController.class); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// DELIVERY MODULE GROUP
	//
	moduleNode = NodeFactory.createModule("edm.milk.delivery", "Milk Deliveries", moduleGroupNode);
	NodeFactory.createSubModule("edm.milk.delivery.log", "Delivery Log", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.milk.delivery.entry", "Log New Delivery", moduleNode, DeliveryView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// MEMBER TAB
	//

	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.members"), "Membership"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_MEMBERS); //$NON-NLS-1$

	//
	// MEMBER MODULE GROUP
	//

	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("members.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	moduleNode = NodeFactory.createModule("edm.members", "Members", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.member.directory", "Member Directory", moduleNode, MemberSearchView.ID, MemberSearchViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.member.edit", "Register Member", moduleNode, MemberSearchView.ID, NewMemberViewController.class); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// FARM MODULE GROUP
	//
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("farms.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	moduleNode = NodeFactory.createModule("edm.farms", "Farms", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.farms.directory", "Farm Directory", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.farms.edit", "Register Farm", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// LIVESTOCK MODULE GROUP
	//

	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("livestock.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	moduleNode = NodeFactory.createModule("edm.livestock", "Livestock", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.livestock.directory", "Livestock Directory", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.livestock.edit", "Register Animal", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// FINANCE TAB
	//

	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.finance"), "Finance"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_FINANCE); //$NON-NLS-1$
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("animalhealth.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	//
	// FINANCE GROUP
	//

	final IModuleNode financeMembers = NodeFactory.createModule("edm.finances", "Finance", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.finances.log", "Journal Log", financeMembers, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.finances.credits", "Credit Journal Entry", financeMembers, CreditJournalView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.finances.payments", "Payment Journal Entry", financeMembers, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// VETERINARY TAB
	//

	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.animalhealth"), "Veterinary"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_ANIMALHEALTH); //$NON-NLS-1$
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("animalhealth.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	//
	// SERVICE REQUESTS GROUP
	//

	final IModuleNode moduleServices = NodeFactory.createModule("edm.services", "Requests", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.services.log", "Request Log", moduleServices, ServiceRequestView.ID, ServiceRequestViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.services.animalhealth", "Request Entry", moduleServices, VeterinaryRequestView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// OPERATIONS TAB
	//

	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.operations"), "Operations"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_OPERATIONS); //$NON-NLS-1$
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("operations.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	//
	// DAIRY GRP
	//

	final IModuleNode moduleSystem = NodeFactory.createModule("edm.sysadmin", "Dairy", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.dairy.info", "Profile", moduleSystem, DairyProfileView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.dairy.branches", "Branch Locations", moduleSystem, DairyLocationView.ID, DairyLocationController.class); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.dairy.staff", "Employees", moduleSystem, StaffInfoView.ID, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.dairy.vehicles", "Vehicles", moduleSystem, VehicleLogView.ID, VehicleLogViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.dairy.bins", "Containers (Bins)", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.dairy.routes", "Routes", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	//		NodeFactory.createSubMobule("edm.dairy.roles", "Roles", moduleSystem, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// EVENTS GRP
	//

	final IModuleNode moduleEvents = NodeFactory.createModule("edm.events", "Events", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.services.event.directory", "Event List", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	NodeFactory.createSubModule("edm.services.event.editor", "Create Event", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// SUPPLIERS GRP
	//

	final IModuleNode moduleDirectory = NodeFactory.createModule("edm.directory", "Suppliers", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.services.supplier.directory", "Supplier Directory", moduleDirectory, SupplierListView.ID, SupplierListViewController.class); //, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.services.supplier.editor", "Register Supplier", moduleDirectory, BlankView.ID); //, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// REPORTS TAB
	//

	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.reports"), "Reports"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_REPORTS); //$NON-NLS-1$
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("reports.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	//
	// REPORTS GRP
	//

	final IModuleNode moduleReports = NodeFactory.createModule("edm.reports", "Reports", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.reports.intake", "Milk Collection", moduleReports, MilkProductionReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.reports.members.payables", "Members Payables", moduleReports, MemberPayablesReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.reports.members.statement", "Member Statement", moduleReports, MemberStatementReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.reports.finance.credit", "Monthly Credit Sales", moduleReports, MonthlyCreditReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//		NodeFactory.createSubMobule("edm.reports.members", "Members", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	//		NodeFactory.createSubMobule("edm.reports.finance", "Finance", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	//		NodeFactory.createSubMobule("edm.reports.services", "Services", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	//		NodeFactory.createSubMobule("edm.reports.events", "Events", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	//		NodeFactory.createSubMobule("edm.reports.marketplace", "Marketplace", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	//		NodeFactory.createSubMobule("edm.reports.dairy", "Dairy", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.reports.custom", "Custom", moduleReports, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

	//
	// SYSTEM TAB
	//

	subAppNode = new SubApplicationNode(new NavigationNodeId("com.agritrace.edairy.desktop.system"), "System"); //$NON-NLS-1$
	app.addChild(subAppNode);
	workarea.registerDefinition(subAppNode, TAB_SYSTEM); //$NON-NLS-1$
	moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("system.navgroup"));
	subAppNode.addChild(moduleGroupNode);

	moduleNode = NodeFactory.createModule("edm.system", "Security", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.system.roles", "Roles", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	NodeFactory.createSubModule("edm.system.permissions", "Permissions", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
	
	return app;

    }

}
