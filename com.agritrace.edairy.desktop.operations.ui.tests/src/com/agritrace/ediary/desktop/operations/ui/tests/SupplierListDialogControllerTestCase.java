package com.agritrace.ediary.desktop.operations.ui.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.DialogConstants;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDialogController;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;

/**
 * Test case for supplier list controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class SupplierListDialogControllerTestCase extends
		AbstractDialogViewControllerTestCase<SupplierDialogController> {

	List<Supplier> supplier = new ArrayList<Supplier>();
	private SupplierDialogController newInst;
	protected SupplierDialogController createController() {
		newInst = new SupplierDialogController();
		return newInst;

	}
	
	

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		prepareDBForTest();
	
	}



	protected void prepareDBForTest() {
		// TODO
		
		Session session = PersistenceManager.getDefault().getSession();
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
		SupplierDialogController controller = this.getController();
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
				IActionRidget.class, DialogConstants.BIND_ID_BUTTON_SAVE);
		apply.fireAction();

		// TODO Verify DB the last result is 'My company'

	}

	/**
	 * Test the filter section and buttons
	 */
	public void testViewRecord() {

		this.getController();

		// TODO
	}

	/**
	 * Test the filter section and buttons
	 */
	public void testEditRecord() {

	}

}
