package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.dairy.Dairy;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Supplier;

public class SupplierListViewController extends AbstractRecordListController {

	public static String[] MASTER_PROPTIES = {
			DairyPackage.Literals.SUPPLIER__SUPPLIER_ID.getName(),
			ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(),
			DairyPackage.Literals.SUPPLIER__CATEGORIES.getName(),
			ModelPackage.Literals.COMPANY__CONTACTS.getName(),
			ModelPackage.Literals.PARTY__PHONE_NUMBER.getName(),
			DairyPackage.Literals.SUPPLIER__STATUS.getName() };
	public static String[] MASTER_HEADERS = { "ID", "Company Name", "Category",
			"Contacts", "Contact #", "Status" };

	@Override
	protected Class<?> getEntityClass() {
		return Supplier.class;
	}

	@Override
	protected List<?> getFilteredResult() {
		try {
			List<Dairy> dairy = DairyDemoResourceManager.INSTANCE
					.getObjectsFromDairyModel(Dairy.class);
			if (dairy.size() == 1) {
				return dairy.get(0).getSuppliers();
			}

			return new ArrayList<Supplier>();
		} catch (Exception e) {

		}
		return new ArrayList<Supplier>();
	}

	@Override
	protected String[] getTableColumnHeaders() {
		return MASTER_HEADERS;
	}

	@Override
	protected String[] getTableColumnPropertyNames() {
		return MASTER_PROPTIES;
	}

	@Override
	protected void doCreation() {

	}

	@Override
	protected RecordDialog getListDialog(int dialogStyle) {
		return new SupplierListDialog(dialogStyle, null, this
				.getSelectedEObject());
	}

}
