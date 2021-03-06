package com.agritrace.edairy.desktop.operations.ui.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.ui.views.BaseListView;
import com.agritrace.edairy.desktop.internal.common.persistence.ManagedMemoryDataStoreProvider;
import com.agritrace.edairy.desktop.internal.common.persistence.PersistenceModule;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDirectoryController;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierDirectoryView;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Test case for supplier list controller
 *
 * @author Hui(Spark) Wan
 *
 */
public class SupplierListControllerTestCase extends
		AbstractSubModuleControllerTest<SupplierDirectoryController> {

	Injector injector = Guice.createInjector(new PersistenceModule() {
		@Override protected void bindDataStore() {
			final ManagedMemoryDataStoreProvider provider = new ManagedMemoryDataStoreProvider();
			bind(HbDataStore.class).toProvider(provider);
		}
	});

	List<Supplier> supplier = new ArrayList<Supplier>();
	private SupplierDirectoryController newInst;

	@Override
	protected SupplierDirectoryController createController(ISubModuleNode node) {
		newInst = injector.getInstance(SupplierDirectoryController.class);
		node.setNodeId(new NavigationNodeId("edm.services.supplier.directory"));
		newInst.setNavigationNode(node);
		return newInst;

	}

	/**
	 * Test the filter section and buttons
	 */
	public void testFilterSection() {

		// Categories in filter
		final IListRidget categories = getController().getRidget(
				IListRidget.class, SupplierDirectoryView.BIND_ID_FILTER_CATEGORIES);
		assertEquals(9, categories.getObservableList().size());

		// Contact Name
		final ITextRidget contactText = getController().getRidget(
				ITextRidget.class, SupplierDirectoryView.BIND_ID_FILTER_CONTACT);
		assertEquals("", contactText.getText());

		// Status combo
		final IComboRidget statusCombo = getController().getRidget(
				IComboRidget.class, SupplierDirectoryView.BIND_ID_FILTER_STATUS);
		assertEquals(VendorStatus.VALUES.size(), statusCombo
				.getObservableList().size());
		assertEquals(1, statusCombo.getSelectionIndex());

		// Test Apply Button, Change some condition
		final IActionRidget apply = getController().getRidget(
				IActionRidget.class, BaseListView.BIND_ID_FILTER_SEARCH);
		categories.setSelection(1);
		apply.fireAction();

		// Test Reset Button
		// final IActionRidget reset = (IActionRidget)
		// getController().getRidget(
		// IActionRidget.class, ServiceRequestFilterSection.BIND_ID_RESET);
		// reset.fireAction();

		// TODO More items

	}

	public void testTableList() {

	}

}
