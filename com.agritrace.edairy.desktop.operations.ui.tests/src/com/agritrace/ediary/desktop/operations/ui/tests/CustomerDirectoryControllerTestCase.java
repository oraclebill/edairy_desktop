package com.agritrace.ediary.desktop.operations.ui.tests;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.riena.core.RienaStatus;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.collection.services.ICollectionJournalLineRepository;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.ManagedMemoryDataStoreProvider;
import com.agritrace.edairy.desktop.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.common.ui.reference.CompanyStatus;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;
import com.agritrace.edairy.desktop.internal.collection.services.MilkCollectionJournalLineRepository;
import com.agritrace.edairy.desktop.operations.ui.controllers.CustomerDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.views.CustomerDirectoryView;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Test case for supplier list controller
 * 
 * @author bjones
 * 
 */
public class CustomerDirectoryControllerTestCase extends AbstractSubModuleControllerTest<CustomerDirectoryController> {

	Injector injector = Guice.createInjector(new PersistenceModule() {
		@Override protected void bindDataStore() {
			ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
			bind(HbDataStore.class).toProvider(provider);
		}
	});


	// List<Supplier> supplier = new ArrayList<Supplier>();
	private CustomerDirectoryController controller;
	
	@Inject
	private IRepository<Customer> customerRepo;

	@Override
	protected CustomerDirectoryController createController(ISubModuleNode node) {
		controller = injector.getInstance(CustomerDirectoryController.class);
		node.setNodeId(new NavigationNodeId("edm.customer.directory"));
		controller.setNavigationNode(node);
		return controller;
	}

	@Override
	public void setUp() throws Exception {
		// start with a new db
		System.setProperty(RienaStatus.RIENA_TEST_SYSTEM_PROPERTY, "true");
		injector.injectMembers(this);
		
		for (int i = 0; i < 10; i++) {
			customerRepo.saveNew(createTestCustomer());
		}
		
		super.setUp();
	}

	/**
	 * Test the filter section and buttons
	 */
	public void testFilterSectionSetup() {

		assertEquals(controller, getController());

		// Categories in filter
		final ITableRidget table = getController().getRidget(ITableRidget.class, CustomerDirectoryView.BIND_ID_TABLE);
		assertEquals(0, table.getObservableList().size());

		// Contact Name
		final ITextRidget contactText = getController().getRidget(ITextRidget.class,
				CustomerDirectoryView.BIND_ID_FILTER_COMPANYNAME);
		assertEquals("", contactText.getText());

		// Type combo
		final IComboRidget typeCombo = getController().getRidget(IComboRidget.class,
				CustomerDirectoryView.BIND_ID_FILTER_CUSTOMERTYPE);
		assertEquals(CustomerType.getCustomerTypeList().size(), typeCombo.getObservableList().size());
		assertEquals(typeCombo.getSelection(), null);

		// Status combo
		final IComboRidget statusCombo = getController().getRidget(IComboRidget.class,
				CustomerDirectoryView.BIND_ID_FILTER_STATUS);
		assertEquals(CompanyStatus.getCustomerStatusList().size(), statusCombo.getObservableList().size());
		assertEquals(statusCombo.getSelection(), null);

	}

	public void testTablePopulatesFromModel() {
		controller.refreshTableContents();
		controller.getRidget(ITableRidget.class, CustomerDirectoryView.BIND_ID_TABLE).updateFromModel();
		assertEquals(10, controller.getRidget(ITableRidget.class, 
				CustomerDirectoryView.BIND_ID_TABLE).getObservableList().size());

	}
	
	public void testFilterReset() {
		// Test Reset Button
		final IActionRidget reset = (IActionRidget) getController().getRidget(IActionRidget.class,
				CustomerDirectoryView.BIND_ID_FILTER_RESET);
		reset.fireAction();

		// TODO More items

	}

	public void testFilterSearch() {
		// Test Apply Button, Change some condition
		final IActionRidget apply = getController().getRidget(IActionRidget.class,
				CustomerDirectoryView.BIND_ID_FILTER_SEARCH);
		apply.fireAction();

	}

	private static Customer createTestCustomer() {
		return createTestCustomer(null, null, null); 	
	}
	
	private static int sequence = 0;
	private static Customer createTestCustomer(String name, String type, String status) {
		Customer cust = DairyFactory.eINSTANCE.createCustomer();
		cust.setCompanyName(name != null ? name : "Test Company #" + sequence);
		cust.setCustomerType(type != null ? type : CustomerType.getCustomerTypeList().get(0).getName());
		cust.setStatus(status != null ? status : CompanyStatus.getCustomerStatusList().get(0).getName());
		cust.setPhoneNumber("" + sequence);
		cust.setDescription("Test Company");
		cust.setLocation(DairyUtil.createLocation(null, null, null));
		sequence++;
		return cust;
	}
	

}
