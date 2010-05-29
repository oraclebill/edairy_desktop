package com.agritrace.ediary.desktop.operations.ui.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.NavigationNodeId;
import org.eclipse.riena.navigation.ui.swt.controllers.AbstractSubModuleControllerTest;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierListViewController;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierListView;

/**
 * Test case for supplier list controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class SupplierListControllerTestCase extends
		AbstractSubModuleControllerTest<SupplierListViewController> {

	List<Supplier> supplier = new ArrayList<Supplier>();
	private SupplierListViewController newInst;

	@Override
	protected SupplierListViewController createController(ISubModuleNode node) {
		newInst = new SupplierListViewController();
		node.setNodeId(new NavigationNodeId("edm.services.supplier.directory"));
		newInst.setNavigationNode(node);
		return newInst;

	}

	/**
	 * Test the filter section and buttons
	 */
	public void testFilterSection() {

		// Categories in filter
		final IListRidget catgories = getController().getRidget(
				IListRidget.class, SupplierListView.BIND_ID_FILTER_CATEGORIES);
		assertEquals(9, catgories.getObservableList().size());

		// Contact Name
		final ITextRidget contactText = getController().getRidget(
				ITextRidget.class, SupplierListView.BIND_ID_FILTER_CONTACT);
		assertEquals("", contactText.getText());

		// Status combo
		final IComboRidget statusCombo = getController().getRidget(
				IComboRidget.class, SupplierListView.BIND_ID_FILTER_CONTACT);
		assertEquals(VendorStatus.VALUES.size(), statusCombo
				.getObservableList().size());
		assertEquals(1, statusCombo.getSelectionIndex());

		// Test Apply Button, Change some condition
		final IActionRidget apply = getController().getRidget(
				IActionRidget.class, SupplierListView.BIND_ID_FILTER_SEARCH);
		catgories.setSelection(1);
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
