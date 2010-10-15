package com.agritrace.edairy.desktop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.ops4j.peaberry.Peaberry;
import org.ops4j.peaberry.eclipse.EclipseRegistry;
import org.osgi.framework.BundleContext;

import com.agritrace.edairy.desktop.birt.BirtModule;
import com.agritrace.edairy.desktop.collection.ui.controllers.MilkCollectionLogController;
import com.agritrace.edairy.desktop.collection.ui.controllers.MilkDeliveryJournalController;
import com.agritrace.edairy.desktop.collection.ui.controllers.ScaleImportViewController;
import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.common.ui.UIModule;
import com.agritrace.edairy.desktop.common.ui.navigation.NodeFactory;
import com.agritrace.edairy.desktop.dairy.locations.ui.controllers.DairyLocationDirectoryController;
import com.agritrace.edairy.desktop.dairy.profile.ui.controllers.DairyProfileViewController;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers.VehicleLogDirectoryViewController;
import com.agritrace.edairy.desktop.finance.ui.navigation.FinanceModule;
import com.agritrace.edairy.desktop.home.HomeModule;
import com.agritrace.edairy.desktop.install.navigation.InstallModule;
import com.agritrace.edairy.desktop.member.ui.controllers.ContainerListViewController;
import com.agritrace.edairy.desktop.member.ui.controllers.FarmListViewController;
import com.agritrace.edairy.desktop.member.ui.controllers.LiveStockListController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberDirectoryController2;
import com.agritrace.edairy.desktop.operations.ui.controllers.ContainersDirectoryViewController;
import com.agritrace.edairy.desktop.operations.ui.controllers.CustomerDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.controllers.EmployeeDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.controllers.RouteListController;
import com.agritrace.edairy.desktop.operations.ui.controllers.SessionDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDirectoryController;
import com.agritrace.edairy.desktop.services.ui.controllers.AnimalHealthRequestViewController;
import com.agritrace.edairy.desktop.splashHandlers.EdairySplashHandler;
import com.agritrace.edairy.desktop.system.ui.controllers.RoleDirectoryController;
import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;

public class EDairyModule extends AbstractModule {
	private final BundleContext context;

	private static final List<Class<? extends IController>> CONTROLLERS = new ArrayList<Class<? extends IController>>();

	// Add any directory controllers that require injection here.
	static {
		CONTROLLERS.add(AnimalHealthRequestViewController.class);
		CONTROLLERS.add(LiveStockListController.class);
		CONTROLLERS.add(FarmListViewController.class);
		CONTROLLERS.add(RoleDirectoryController.class);
		CONTROLLERS.add(DairyLocationDirectoryController.class);
		CONTROLLERS.add(ContainerListViewController.class);
		CONTROLLERS.add(MilkCollectionLogController.class);
		CONTROLLERS.add(MilkDeliveryJournalController.class);
		CONTROLLERS.add(SupplierDirectoryController.class);
		CONTROLLERS.add(SessionDirectoryController.class);
		CONTROLLERS.add(MemberDirectoryController2.class);
		CONTROLLERS.add(DairyProfileViewController.class);
		CONTROLLERS.add(ScaleImportViewController.class);
		CONTROLLERS.add(VehicleLogDirectoryViewController.class);
		CONTROLLERS.add(ContainersDirectoryViewController.class);
		CONTROLLERS.add(EmployeeDirectoryController.class);
		CONTROLLERS.add(CustomerDirectoryController.class);
		CONTROLLERS.add(RouteListController.class);
		CONTROLLERS.add(VehicleLogDirectoryViewController.class);
		FinanceModule.contributeControllers(CONTROLLERS);
	}

	public EDairyModule(BundleContext context) {
		this.context = context;
	}

	@Override
	protected void configure() {
		install(Peaberry.osgiModule(context, EclipseRegistry.eclipseRegistry()));
		install(new PersistenceModule());
		install(new UIModule());
		install(new InstallModule());
		install(new FinanceModule());
		install(new HomeModule());
		install(new BirtModule());

		final Map<Class<? extends IController>, Provider<? extends IController>> map =
			new HashMap<Class<? extends IController>, Provider<? extends IController>>();

		for (final Class<? extends IController> klass: CONTROLLERS) {
			map.put(klass, getProvider(klass));
		}

		bind(new TypeLiteral<Map<Class<? extends IController>, Provider<? extends IController>>>() {}).toInstance(map);
		requestStaticInjection(EdairySplashHandler.class);
		requestStaticInjection(NodeFactory.class);
	}

	@Provides @Named("current")
	protected Shell getCurrentShell()
	{
		return Display.getCurrent().getActiveShell();
	}
}
