/**
 * 
 */
package com.agritrace.edairy.desktop.ui;

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

import com.agritrace.edairy.desktop.EDairyActivator;
import com.agritrace.edairy.desktop.collection.ui.NavigationConstants;
import com.agritrace.edairy.desktop.common.ui.navigation.NodeFactory;
import com.agritrace.edairy.desktop.common.ui.views.BlankView;
import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationDirectoryController;
import com.agritrace.edairy.desktop.dairy.locations.ui.views.DairyLocationDirectoryView;
import com.agritrace.edairy.desktop.dairy.profile.ui.controllers.DairyProfileViewController;
import com.agritrace.edairy.desktop.dairy.profile.ui.views.DairyProfileView;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers.VehicleLogDirectoryViewController;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.views.VehicleLogDirectoryView;
import com.agritrace.edairy.desktop.home.views.DairyHomeView;
import com.agritrace.edairy.desktop.member.ui.controllers.ContainerListViewController;
import com.agritrace.edairy.desktop.member.ui.controllers.FarmListViewController;
import com.agritrace.edairy.desktop.member.ui.controllers.LiveStockListController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberDirectoryController2;
import com.agritrace.edairy.desktop.member.ui.views.ContainerListView;
import com.agritrace.edairy.desktop.member.ui.views.FarmListView;
import com.agritrace.edairy.desktop.member.ui.views.LivestockListView;
import com.agritrace.edairy.desktop.member.ui.views.MemberDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.controllers.ContainersDirectoryViewController;
import com.agritrace.edairy.desktop.operations.ui.controllers.CustomerDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.controllers.EmployeeDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.controllers.RouteListController;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.views.ContainerDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.CustomerDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.EmployeeDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.RouteDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierDirectoryView;
import com.agritrace.edairy.desktop.services.ui.controllers.AnimalHealthRequestViewController;
import com.agritrace.edairy.desktop.services.ui.views.AnimalHealthRequestView;
import com.agritrace.edairy.desktop.system.ui.controllers.RoleDirectoryController;
import com.agritrace.edairy.desktop.system.ui.views.RoleDirectoryView;
import com.agritrace.edairy.desktop.ui.views.MemberPayablesReportView;
import com.agritrace.edairy.desktop.ui.views.MemberStatementReportView;
import com.agritrace.edairy.desktop.ui.views.MilkProductionReportView;
import com.agritrace.edairy.desktop.ui.views.MonthlyCreditReportView;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author oraclebill
 * 
 */
public class EDairyManagerApplication extends SwtApplication {

	private static final String LABEL_APPLICATION = "eDairy Manager Desktop";
	private static final String LABEL_FARMS = "Farms";
	private static final String LABEL_HOME = "Home";
	// private static final String LABEL_MILK = "Milk";
	private static final String LABEL_MEMBERS = "Membership";
	// private static final String LABEL_FINANCE = "Finance";
	private static final String LABEL_OPERATIONS = "Operations";
	private static final String LABEL_REPORTS = "Reports";
	// labels (translatable)
	private static final String LABEL_SYSTEM = "System";
	private static final String LABEL_VETERINARY = "Veterinary";

	private static final String MODULE_FARMS = "edm.farms";//$NON-NLS-1$
	private static final String MODULE_GROUP_HOME = "home.navgroup";//$NON-NLS-1$
	private static final String MODULE_GROUP_MEMBERS = "members.navgroup";//$NON-NLS-1$
	private static final String MODULE_GROUP_OPERATIONS = "modulegroup.desktop.operations"; //$NON-NLS-1$

	private static final String MODULE_GROUP_REPORTS = "modulegroup.desktop.reports"; //$NON-NLS-1$
	private static final String MODULE_GROUP_SYSTEM = "system.navgroup"; //$NON-NLS-1$
	private static final String MODULE_GROUP_VETERINARY = "animalhealth.navgroup"; //$NON-NLS-1$
	private static final String MODULE_HOME = "desktop.home.module";//$NON-NLS-1$
	private static final String MODULE_MEMBERS = "edm.members";//$NON-NLS-1$
	private static final String MODULE_OPERATIONS = "edm.dairy";
	private static final String MODULE_OPERATIONS_BRANCH_LOCATIONS = "edm.dairy-locations";

	private static final String MODULE_OPERATIONS_DAIRY_CONTAINERS = "MODULE_OPERATIONS_DAIRY_CONTAINERS";

	private static final String MODULE_OPERATIONS_DAIRY_EMPLOYEES = "MODULE_OPERATIONS_DAIRY_EMPLOYEES";
	private static final String MODULE_OPERATIONS_DAIRY_VEHICLES = "MODULE_OPERATIONS_DAIRY_VEHICLES";
	private static final String MODULE_OPERATIONS_ROUTES = "edm.routes";
	private static final String MODULE_REPORTS = "edm.reports";

	private static final String MODULE_SYSTEM = "edm.system";
	private static final String MODULE_VETERINARY = "edm.services";
	// FINANCE
	private static final String SUBAPP_FINANCE = "com.agritrace.edairy.desktop.finance";//$NON-NLS-1$
//	private static final String SUBAPP_INSTALL = "com.agritrace.edairy.desktop.install";//$NON-NLS-1$
	//	private static final String MODULE_GROUP_FINANCE = "modulegroup.desktop.finance"; //$NON-NLS-1$
	//	private static final String MODULE_FINANCE = "edm.finances";//$NON-NLS-1$
	//	private static final String SUBMODULE_FINANCE_TRANSACTION_BATCH_ENTRY = "edm.finances.blog";//$NON-NLS-1$
	//	private static final String SUBMODULE_FINANCE_MILK_PRICE_REGISTER = "edm.finances.milklog";//$NON-NLS-1$
	//	private static final String SUBMODULE_FINANCE_ADJUSTMENTS_REGISTER = "edm.finances.credits";//$NON-NLS-1$
	//	private static final String SUBMODULE_FINANCE_TRANSACTION_REGISTER = "edm.finances.log";//$NON-NLS-1$

	// HOME
	private static final String SUBAPP_HOME = "com.agritrace.edairy.desktop.home"; //$NON-NLS-1$
	// MEMBERSHIP
	private static final String SUBAPP_MEMBERS = "com.agritrace.edairy.desktop.members";//$NON-NLS-1$
	private static final String SUBAPP_MEMBERS_VIEWID = SUBAPP_MEMBERS;
	// OPERATIONS
	private static final String SUBAPP_OPERATIONS = "com.agritrace.edairy.desktop.operations";//$NON-NLS-1$
	// REPORTS
	private static final String SUBAPP_REPORTS = "com.agritrace.edairy.desktop.reports";//$NON-NLS-1$
	// SYSTEM ADMIN
	private static final String SUBAPP_SYSTEM = "com.agritrace.edairy.desktop.system";//$NON-NLS-1$
	// VETERINARY
	private static final String SUBAPP_VETERINARY = "com.agritrace.edairy.desktop.animalhealth";//$NON-NLS-1$
	// private static final String TAB_FINANCE = SUBAPP_FINANCE;
	private static final String SUBAPP_VETERINARY_VIEWID = SUBAPP_VETERINARY;
	private static final String SUBMODULE_APPLICATION_HOME = "desktop.home.view";//$NON-NLS-1$
	private static final String SUBMODULE_FARM_DIRECTORY = "edm.farms.directory";//$NON-NLS-1$
	//	private static final String SUBMODULE_MEMBER_EDITOR = "edm.member.edit";//$NON-NLS-1$
	private static final String SUBMODULE_LIVESTOCK_DIRECTORY = "edm.livestock.directory";//$NON-NLS-1$
	private static final String SUBMODULE_MEMBER_DIRECTORY = "edm.member.directory";//$NON-NLS-1$

	private static final String SUBMODULE_OPERATIONS_BRANCH_LOCATIONS = "edm.dairy.branches";
	private static final String SUBMODULE_OPERATIONS_DAIRY_CONTAINERS = "SUBMODULE_OPERATIONS_DAIRY_CONTAINERS";
	private static final String SUBMODULE_OPERATIONS_DAIRY_PROFILE = "edm.dairy.info";

	private static final String SUBMODULE_OPERATIONS_EMPLOYEE_REGISTER = "edm.dairy.staff";
	private static final String SUBMODULE_OPERATIONS_ROUTES = "edm.dairy.routes";
	private static final String SUBMODULE_OPERATIONS_VEHICLE_REGISTER = "edm.dairy.vehicles";
	private static final String SUBMODULE_VETERINARY_REQUESTS = "edm.services.edit";//$NON-NLS-1$
	private static final String TAB_OPERATIONS = SUBAPP_OPERATIONS;
	private static final String TAB_REPORTS = SUBAPP_REPORTS;
	private static final String TAB_SYSTEM = SUBAPP_SYSTEM;
	
	public EDairyManagerApplication() {
		super();
		LnfManager.setLnf(new EDairyManagerLookAndFeel());
	}

	@Override
	protected ApplicationController createApplicationController(IApplicationNode node) {
		final ApplicationController controller = super.createApplicationController(node);
		controller.setMenubarVisible(true);
		return controller;
	}

	@Override
	protected IApplicationNode createModel() {

		// ExtensionRegistryAnalyzer.dumpRegistry("org.eclipse.ui");

		final ApplicationNode app = new ApplicationNode(new NavigationNodeId("application"), LABEL_APPLICATION);
		final WorkareaManager workarea = WorkareaManager.getInstance();

		ISubApplicationNode subAppNode;
		IModuleGroupNode moduleGroupNode;
		IModuleNode moduleNode;

		//
		// HOME TAB
		//

		subAppNode = new SubApplicationNode(new NavigationNodeId("home"), LABEL_HOME);
		app.addChild(subAppNode);
		workarea.registerDefinition(subAppNode, SUBAPP_HOME);

		//
		// HOME MODULE GROUP
		//
		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_HOME));
		subAppNode.addChild(moduleGroupNode);

		moduleNode = NodeFactory.createModule(MODULE_HOME, LABEL_HOME, moduleGroupNode);
		NodeFactory.createSubModule(SUBMODULE_APPLICATION_HOME, LABEL_HOME, moduleNode, DairyHomeView.ID);

		//
		// MILK TAB
		//

		app.create(new NavigationNodeId(NavigationConstants.SUBAPP_MILK));

		//
		// MEMBER TAB
		//

		subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_MEMBERS), LABEL_MEMBERS);
		app.addChild(subAppNode);
		workarea.registerDefinition(subAppNode, SUBAPP_MEMBERS_VIEWID);

		//
		// MEMBER MODULE GROUP
		//

		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_MEMBERS));
		subAppNode.addChild(moduleGroupNode);

		moduleNode = NodeFactory.createModule(MODULE_MEMBERS, LABEL_MEMBERS, moduleGroupNode);
		NodeFactory.createSubModule(SUBMODULE_MEMBER_DIRECTORY,
				"Member Directory", moduleNode, MemberDirectoryView.ID, MemberDirectoryController2.class); //$NON-NLS-1$ 
		// NodeFactory.createSubModule(SUBMODULE_MEMBER_EDITOR,
		//				"Register Member", moduleNode, CreateMemberView.ID, MemberRegisterViewController.class); //$NON-NLS-1$ 

		//
		// FARM MODULE GROUP
		//
		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("farms.navgroup"));
		subAppNode.addChild(moduleGroupNode);

		moduleNode = NodeFactory.createModule(MODULE_FARMS, LABEL_FARMS, moduleGroupNode);
		NodeFactory.createSubModule(SUBMODULE_FARM_DIRECTORY,
				"Farm Directory", moduleNode, FarmListView.ID, FarmListViewController.class); //$NON-NLS-1$ 
		//	NodeFactory.createSubModule("edm.farms.edit", "Register Farm", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		//
		// LIVESTOCK MODULE GROUP
		//

		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("livestock.navgroup"));
		subAppNode.addChild(moduleGroupNode);

		moduleNode = NodeFactory.createModule("edm.livestock", "Livestock", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubModule(SUBMODULE_LIVESTOCK_DIRECTORY,
				"Livestock Directory", moduleNode, LivestockListView.ID, LiveStockListController.class); //$NON-NLS-1$ 
		//	NodeFactory.createSubModule("edm.livestock.edit", "Register Animal", moduleNode, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$

		// Container
		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId("container.navgroup"));
		subAppNode.addChild(moduleGroupNode);

		moduleNode = NodeFactory.createModule("edm.container", "Container", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubModule("edm.container.directory", "Container Directory", moduleNode, ContainerListView.ID,
				ContainerListViewController.class);

		//
		// FINANCE TAB
		//

		app.create(new NavigationNodeId(SUBAPP_FINANCE));
//		app.create(new NavigationNodeId(SUBAPP_INSTALL));

		/************
		 * subAppNode = new SubApplicationNode(new
		 * NavigationNodeId(SUBAPP_FINANCE), LABEL_FINANCE);
		 * app.addChild(subAppNode); workarea.registerDefinition(subAppNode,
		 * TAB_FINANCE); moduleGroupNode = new ModuleGroupNode(new
		 * NavigationNodeId(MODULE_GROUP_FINANCE));
		 * subAppNode.addChild(moduleGroupNode);
		 * 
		 * // // FINANCE GROUP //
		 * 
		 * final IModuleNode financeMembers =
		 * NodeFactory.createModule(MODULE_FINANCE, "Finance", moduleGroupNode);
		 * //$NON-NLS-1$
		 * NodeFactory.createSubModule(SUBMODULE_FINANCE_TRANSACTION_REGISTER,
		 * "Transaction Journal", financeMembers,
		 * MemberTransactionRegisterView.ID); //$NON-NLS-1$ //
		 * NodeFactory.createSubModule
		 * (SUBMODULE_FINANCE_TRANSACTION_BATCH_ENTRY, //
		 * "Transaction Journal 8", financeMembers,
		 * TransactionBatchEntrySubModuleView.ID); //$NON-NLS-1$ //
		 * NodeFactory.createSubModule( // "edm.finances.mdlog",
		 * "Transaction Journal 9", financeMembers,
		 * TransactionBatchEntryMDSubModuleView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		 * // NodeFactory //
		 * .createSubModule(SUBMODULE_FINANCE_ADJUSTMENTS_REGISTER,
		 * "Adjustments", financeMembers, BlankView.ID); //$NON-NLS-1$ //
		 * NodeFactory.createSubModule(SUBMODULE_FINANCE_MILK_PRICE_REGISTER, //
		 * "Milk Price Register", financeMembers, BlankView.ID); //$NON-NLS-1$
		 ************/

		//
		// VETERINARY TAB
		//

		subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_VETERINARY), LABEL_VETERINARY);
		app.addChild(subAppNode);
		workarea.registerDefinition(subAppNode, SUBAPP_VETERINARY_VIEWID);
		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_VETERINARY));
		subAppNode.addChild(moduleGroupNode);

		//
		// SERVICE REQUESTS GROUP
		//

		final IModuleNode moduleServices = NodeFactory.createModule(MODULE_VETERINARY, "Requests", moduleGroupNode); //$NON-NLS-1$ 
		NodeFactory.createSubModule(SUBMODULE_VETERINARY_REQUESTS,
				"Request Log", moduleServices, AnimalHealthRequestView.ID, AnimalHealthRequestViewController.class); //$NON-NLS-1$ 

		//
		// OPERATIONS TAB
		//

		subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_OPERATIONS), LABEL_OPERATIONS);
		app.addChild(subAppNode);
		workarea.registerDefinition(subAppNode, TAB_OPERATIONS);
		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_OPERATIONS));
		subAppNode.addChild(moduleGroupNode);

		//
		// DAIRY GRP
		//

		{
			final IModuleNode moduleSystem = NodeFactory.createModule(MODULE_OPERATIONS,
					"Dairy Profile", moduleGroupNode); //$NON-NLS-1$ 
			NodeFactory.createSubModule(SUBMODULE_OPERATIONS_DAIRY_PROFILE,
					"Dairy Profile", moduleSystem, DairyProfileView.ID, DairyProfileViewController.class); //$NON-NLS-1$ 
		}

		{
			final IModuleNode moduleSystem = NodeFactory.createModule(MODULE_OPERATIONS_DAIRY_EMPLOYEES,
					"Employees", moduleGroupNode); //$NON-NLS-1$ 
			NodeFactory.createSubModule(SUBMODULE_OPERATIONS_EMPLOYEE_REGISTER,
					"Employees", moduleSystem, EmployeeDirectoryView.ID, EmployeeDirectoryController.class); //$NON-NLS-1$ 

		}
		{
			final IModuleNode moduleSystem = NodeFactory.createModule(MODULE_OPERATIONS_DAIRY_VEHICLES,
					"Vehicles", moduleGroupNode); //$NON-NLS-1$ 
			NodeFactory.createSubModule(SUBMODULE_OPERATIONS_VEHICLE_REGISTER,
					"Vehicles", moduleSystem, VehicleLogDirectoryView.ID, VehicleLogDirectoryViewController.class); //$NON-NLS-1$ 

		}
		{
			final IModuleNode moduleSystem = NodeFactory.createModule(MODULE_OPERATIONS_DAIRY_CONTAINERS,
					"Dairy Bins", moduleGroupNode); //$NON-NLS-1$ 
			NodeFactory.createSubModule(SUBMODULE_OPERATIONS_DAIRY_CONTAINERS,
					"Dairy Bins", moduleSystem, ContainerDirectoryView.ID, ContainersDirectoryViewController.class); //$NON-NLS-1$ 

		}
		{
			final IModuleNode moduleSystem = NodeFactory.createModule(MODULE_OPERATIONS_BRANCH_LOCATIONS,
					"Dairy Locations", moduleGroupNode); //$NON-NLS-1$ 
			NodeFactory.createSubModule(SUBMODULE_OPERATIONS_BRANCH_LOCATIONS,
					"Branch Locations", moduleSystem, DairyLocationDirectoryView.ID, DairyLocationDirectoryController.class); //$NON-NLS-1$ 

		}
		{
			final IModuleNode moduleRoutes = NodeFactory.createModule(MODULE_OPERATIONS_ROUTES,
					"Transport Routes", moduleGroupNode); //$NON-NLS-1$ 
			NodeFactory.createSubModule(SUBMODULE_OPERATIONS_ROUTES,
					"Transport Routes", moduleRoutes, RouteDirectoryView.ID, RouteListController.class); //$NON-NLS-1$ 
		}

		//
		// EVENTS GRP
		//
		{
			// final IModuleNode moduleEvents =
			NodeFactory.createModule("edm.events", "Events", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
			//			NodeFactory.createSubModule("edm.services.event.directory", "Event List", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
			//	NodeFactory.createSubModule("edm.services.event.editor", "Create Event", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		}

		//
		// CUSTOMERS GRP
		//
		{
			final IModuleNode moduleDirectory = NodeFactory.createModule(
					"edm.customer.directory", "Customers", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
			NodeFactory.createSubModule("edm.services.customer.directory", "Customer Directory", moduleDirectory,
					CustomerDirectoryView.ID, CustomerDirectoryController.class);
		}

		//
		// SUPPLIERS GRP
		//
		{
			final IModuleNode moduleDirectory = NodeFactory.createModule(
					"edm.supplier.directory", "Suppliers", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
			NodeFactory
					.createSubModule(
							"edm.services.supplier.directory", "Supplier Directory", moduleDirectory, SupplierDirectoryView.ID, SupplierDirectoryController.class); //, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
			//	NodeFactory.createSubModule("edm.services.supplier.editor", "Register Supplier", moduleDirectory, BlankView.ID); //, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
		}
		//
		// REPORTS TAB
		//

		subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_REPORTS), LABEL_REPORTS);
		app.addChild(subAppNode);
		workarea.registerDefinition(subAppNode, TAB_REPORTS);
		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_REPORTS));
		subAppNode.addChild(moduleGroupNode);

		//
		// REPORTS GRP
		//

		final IModuleNode moduleReports = NodeFactory.createModule(MODULE_REPORTS, "Reports", moduleGroupNode); //$NON-NLS-1$ 
		NodeFactory
				.createSubModule("edm.reports.intake", "Milk Collection", moduleReports, MilkProductionReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubModule(
				"edm.reports.members.payables", "Members Payables", moduleReports, MemberPayablesReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubModule(
				"edm.reports.members.statement", "Member Statement", moduleReports, MemberStatementReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$
		NodeFactory.createSubModule(
				"edm.reports.finance.credit", "Monthly Credit Sales", moduleReports, MonthlyCreditReportView.ID); //$NON-NLS-1$ //$NON-NLS-2$

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

		subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_SYSTEM), LABEL_SYSTEM);
		app.addChild(subAppNode);
		workarea.registerDefinition(subAppNode, TAB_SYSTEM);
		moduleGroupNode = new ModuleGroupNode(new NavigationNodeId(MODULE_GROUP_SYSTEM));
		subAppNode.addChild(moduleGroupNode);

		moduleNode = NodeFactory.createModule(MODULE_SYSTEM, "Security", moduleGroupNode); //$NON-NLS-1$ 
		NodeFactory.createSubModule("edm.system.roles", "Roles", moduleNode,
				RoleDirectoryView.ID, RoleDirectoryController.class); //$NON-NLS-1$ //$NON-NLS-2$
		
		/*
		app.addSimpleListener(new SimpleNavigationNodeAdapter() {
			@Override
			public void afterActivated(INavigationNode<?> source) {
				app.getNavigationProcessor().activate(app.getChild(1));
			}
		});
		*/
		
		return app;

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

}
