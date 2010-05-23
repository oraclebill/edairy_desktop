package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierListView;

public class SupplierListViewController extends AbstractRecordListController {

	public static String[] MASTER_PROPTIES = {
			DairyPackage.Literals.SUPPLIER__SUPPLIER_ID.getName(),
			ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(),
			DairyPackage.Literals.SUPPLIER__CATEGORIES.getName(),
			ModelPackage.Literals.COMPANY__CONTACTS.getName(),
			ModelPackage.Literals.COMPANY__PHONE_NUMBER.getName(),
			DairyPackage.Literals.SUPPLIER__STATUS.getName() };
	public static String[] MASTER_HEADERS = { "ID", "Company Name", "Category",
			"Contact", "Contact #", "Status" };

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
	protected void configureTableRidget() {
		super.configureTableRidget();
		ITableRidget tableRidget = this.getRidget(ITableRidget.class,
				AbstractRecordListView.BIND_ID_TABLE);
		if (tableRidget != null) {
			// Contact Name, we will get the first contact
			tableRidget.setColumnFormatter(3, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof Supplier) {

						Supplier supplier = (Supplier) element;

						if (supplier.getContacts().size() > 0) {
							return supplier.getContacts().get(0).getGivenName()
									+ " "
									+ supplier.getContacts().get(0)
											.getFamilyName();
						}

					}
					return null;
				}

			});
		}
		// Contact Phone Number, we will get the first contact
		if (tableRidget != null) {
			tableRidget.setColumnFormatter(4, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof Supplier) {

						Supplier supplier = (Supplier) element;

						if (supplier.getContacts().size() > 0) {
							return supplier.getContacts().get(0)
									.getPhoneNumber();
						}

					}
					return null;
				}

			});
		}

	}

	@Override
	protected void doCreation() {

	}

	@Override
	protected RecordDialog getListDialog(int dialogStyle) {
		return new SupplierListDialog(dialogStyle, null, this
				.getSelectedEObject());
	}

	@Override
	protected void configureFilterRidgets() {
		super.configureFilterRidgets();
		IComboRidget statusCombo = getRidget(IComboRidget.class,
				SupplierListView.BIND_ID_FILTER_STATUS);
		if (statusCombo != null) {
			statusCombo.bindToModel(Observables
					.staticObservableList(VendorStatus.VALUES),
					VendorStatus.class, "toString", new WritableValue());
			statusCombo.updateFromModel();
			statusCombo.setSelection(0);
		}
	}

}