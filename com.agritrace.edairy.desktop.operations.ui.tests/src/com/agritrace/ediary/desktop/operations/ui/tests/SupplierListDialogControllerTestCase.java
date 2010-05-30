package com.agritrace.ediary.desktop.operations.ui.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.model.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierListDialogController;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;

/**
 * Test case for supplier list controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class SupplierListDialogControllerTestCase extends
		AbstractDialogViewControllerTestCase<SupplierListDialogController> {

	List<Supplier> supplier = new ArrayList<Supplier>();
	private SupplierListDialogController newInst;
	private Supplier selectedObject;

	protected SupplierListDialogController createController() {
		newInst = new SupplierListDialogController();
		return newInst;

	}
	
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		prepareDBForTest();
	
	}



	protected void prepareDBForTest() {
		// TODO
		
		Session session = PersistenceManager.INSTANCE.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.createSQLQuery("Delete from supplier");
		// delete all records
		tx.commit();
	}



	/**
	 * Test the filter section and buttons
	 */
	public void testNewRecord() {

		// Set action type
		SupplierListDialogController controller = this.getController();
		controller.setActionType(AbstractRecordListController.ACTION_NEW);
		// Update from model
		controller.afterBind();

		// Test the default text value

		// Supplier Id
		final ITextRidget supplierId = getController().getRidget(
				ITextRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_ID);
		assertEquals("", supplierId.getText());

		// Status combo
		final IComboRidget statusCombo = getController().getRidget(
				IComboRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_STATUS);
		assertEquals(VendorStatus.VALUES.size(), statusCombo
				.getObservableList().size());
		assertEquals(0, statusCombo.getSelectionIndex());

		// Company Name
		final ITextRidget companyName = getController().getRidget(
				ITextRidget.class, SupplierListDialog.BIND_ID_COMPANY_NAME);
		assertEquals("", companyName.getText());

		// Legal Name
		final ITextRidget legalName = getController().getRidget(
				ITextRidget.class, SupplierListDialog.BIND_ID_LEGAL_NAME);
		assertEquals("", legalName.getText());

		// Categories
		final IListRidget catgories = getController().getRidget(
				IListRidget.class, SupplierListDialog.BIND_ID_CATEGORY);
		assertEquals(9, catgories.getObservableList().size());

		// Description
		final ITextRidget description = getController().getRidget(
				ITextRidget.class, SupplierListDialog.BIND_ID_DESCRIPTION);
		assertEquals("", description.getText());

		// Test OK button to save a new record
		// Input field
		statusCombo.setSelection(1);
		companyName.setText("My company");
		legalName.setText("Legal Name");

		// Test OK Button
		final IActionRidget apply = getController().getRidget(
				IActionRidget.class, SupplierListDialog.BIND_ID_BUTTON_OK);
		apply.fireAction();

		// TODO Verify DB the last result is 'My company'

	}

	/**
	 * Test the filter section and buttons
	 */
	public void testViewRecord() {

		SupplierListDialogController controller = this.getController();
		controller.setSelectedObject(selectedObject);
		controller.setActionType(AbstractRecordListController.ACTION_VIEW);
		controller.copyModel();

		// TODO
	}

	/**
	 * Test the filter section and buttons
	 */
	public void testEditRecord() {

	}

}