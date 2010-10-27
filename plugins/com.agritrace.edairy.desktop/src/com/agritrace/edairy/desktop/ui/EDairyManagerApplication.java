/**
 *
 */
package com.agritrace.edairy.desktop.ui;

import org.eclipse.riena.internal.ui.swt.utils.RcpUtilities;
import org.eclipse.riena.navigation.IApplicationNode;
import org.eclipse.riena.navigation.IModuleGroupNode;
import org.eclipse.riena.navigation.IModuleNode;
import org.eclipse.riena.navigation.INavigationNode;
import org.eclipse.riena.navigation.ISubApplicationNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.listener.ApplicationNodeListener;
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
import com.agritrace.edairy.desktop.operations.ui.controllers.SessionDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.views.ContainerDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.CustomerDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.EmployeeDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.RouteDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.SessionDirectoryView;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierDirectoryView;
import com.agritrace.edairy.desktop.services.ui.controllers.AnimalHealthRequestViewController;
import com.agritrace.edairy.desktop.services.ui.views.AnimalHealthRequestView;
import com.agritrace.edairy.desktop.system.ui.controllers.RoleDirectoryController;
import com.agritrace.edairy.desktop.system.ui.views.RoleDirectoryView;
import com.agritrace.edairy.desktop.ui.views.MemberPayablesReportView;
import com.agritrace.edairy.desktop.ui.views.MemberStatementReportView;
import com.agritrace.edairy.desktop.ui.views.MilkProductionReportView;
import com.agritrace.edairy.desktop.ui.views.MonthlyCreditReportView;

/**
 * @author oraclebill
 * 
 */
public class EDairyManagerApplication extends SwtApplication implements ApplicationNavigationConstants {

	public EDairyManagerApplication() {
		super();
		LnfManager.setLnf(new EDairyManagerLookAndFeel());
	}

	@Override
	protected ApplicationController createApplicationController(IApplicationNode node) {
		final ApplicationController controller = new ApplicationController(node) {
			@Override
			public void afterBind() {
				super.afterBind();
				RcpUtilities.getWorkbenchShell().setMaximized(true);
			}
		};
		
		controller.setMenubarVisible(true);
		return controller;
	}

	@Override
	protected IApplicationNode createModel() {

		// ExtensionRegistryAnalyzer.dumpRegistry("org.eclipse.ui");
		// ExtensionRegistryAnalyzer.dumpRegistry(null);

		final ApplicationNode app = new ApplicationNode(new NavigationNodeId("application"), LABEL_APPLICATION);
		final WorkareaManager workarea = WorkareaManager.getInstance();

		IApplicationNode model = buildModel(app, workarea);
		model.addListener(new ApplicationNodeListener() {
			@Override
			public void activated(IApplicationNode source) {
				initApplicationContext(source);
			}

		});
		return model;
	}

	private void initApplicationContext(IApplicationNode source) {
		System.err.println("<<<<<<<<<<<<< BILL HERE >>>>>>>>>>>>>>>>>>>");
		// source.setContext("site.local.dairy", DairyRepository.)
	}

	private IApplicationNode buildModel(ApplicationNode app, WorkareaManager workarea) {

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

		subAppNode = new SubApplicationNode(new NavigationNodeId(SUBAPP_REGISTRATION), LABEL_REGISTRATION);
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
			NodeFactory
					.createSubModule(
							SUBMODULE_OPERATIONS_BRANCH_LOCATIONS,
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
//		{
//			// final IModuleNode moduleEvents =
//			NodeFactory.createModule("edm.events", "Events", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
//			//			NodeFactory.createSubModule("edm.services.event.directory", "Event List", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//			//	NodeFactory.createSubModule("edm.services.event.editor", "Create Event", moduleEvents, BlankView.ID); //$NON-NLS-1$ //$NON-NLS-2$
//		}

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
		// SESSIONS GRP
		//
		{
			final IModuleNode moduleDirectory = NodeFactory.createModule(
					"edm.session.directory", "Sessions", moduleGroupNode); //$NON-NLS-1$ //$NON-NLS-2$
			NodeFactory
					.createSubModule(
							"edm.services.session.directory", "Session Directory", moduleDirectory, SessionDirectoryView.ID, SessionDirectoryController.class); //, StaffInfoViewController.class); //$NON-NLS-1$ //$NON-NLS-2$
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
		NodeFactory.createSubModule("edm.system.roles", "Roles", moduleNode, RoleDirectoryView.ID,
				RoleDirectoryController.class);

		/*
		 * app.addSimpleListener(new SimpleNavigationNodeAdapter() {
		 * 
		 * @Override public void afterActivated(INavigationNode<?> source) {
		 * app.getNavigationProcessor().activate(app.getChild(1)); } });
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
