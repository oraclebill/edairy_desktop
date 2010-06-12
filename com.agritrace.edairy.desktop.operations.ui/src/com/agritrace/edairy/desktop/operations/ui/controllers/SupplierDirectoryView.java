package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.beans.common.TypedBean;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.persistence.services.PersistenceManager;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.reference.SupplierCategory;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.supplier.SupplierRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierListView;

public class SupplierDirectoryView extends BasicDirectoryController {

	// public static String[] MASTER_PROPTIES = {
	// ModelPackage.Literals.COMPANY__COMPANY_ID.getName(),
	// ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(),
	// DairyPackage.Literals.SUPPLIER__CATEGORIES.getName(),
	// ModelPackage.Literals.COMPANY__CONTACTS.getName(),
	// ModelPackage.Literals.COMPANY__PHONE_NUMBER.getName(),
	// DairyPackage.Literals.SUPPLIER__STATUS.getName() };
	// public static String[] MASTER_HEADERS = { "ID", "Company Name",
	// "Category", "Contact", "Contact #", "Status" };

	final class ContactPhoneColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof Supplier) {

				Supplier supplier = (Supplier) element;

				if (supplier.getContacts().size() > 0) {
					return supplier.getContacts().get(0).getPhoneNumber();
				}

			}
			return null;
		}
	}

	final class ContactNameColumnFormatter extends ColumnFormatter {
		@Override
		public String getText(Object element) {
			if (element instanceof Supplier) {
				Supplier supplier = (Supplier) element;
				if (supplier.getContacts().size() > 0) {
					return supplier.getContacts().get(0).getGivenName() + " "
							+ supplier.getContacts().get(0).getFamilyName();
				}
			}
			return null;
		}
	}

	// filter ridgets
	private IComboRidget statusCombo;
	private IListRidget categoryList;
	private ITextRidget companyText;

	// filter bean

	public SupplierDirectoryView() {
		super();

		setRepository(new SupplierRepository());
		setEntityClass(Supplier.class);
		setEClass(DairyPackage.Literals.SUPPLIER);

		addTableColumn("ID", ModelPackage.Literals.COMPANY__COMPANY_ID);
		addTableColumn("Company Name", ModelPackage.Literals.COMPANY__COMPANY_NAME);
		addTableColumn("Category", DairyPackage.Literals.SUPPLIER__CATEGORIES);
		addTableColumn("Contact", ModelPackage.Literals.COMPANY__CONTACTS, new ContactNameColumnFormatter());
		addTableColumn("Contact #", ModelPackage.Literals.COMPANY__PHONE_NUMBER, new ContactPhoneColumnFormatter());
		addTableColumn("Status", DairyPackage.Literals.SUPPLIER__STATUS);
	}

	@Override
	protected void configureFilterRidgets() {
		companyText = getRidget(ITextRidget.class, SupplierListView.BIND_ID_FILTER_CONTACT);
		categoryList = getRidget(IListRidget.class, SupplierListView.BIND_ID_FILTER_CATEGORIES);
		statusCombo = getRidget(IComboRidget.class, SupplierListView.BIND_ID_FILTER_STATUS);
		if (statusCombo != null) {
			statusCombo.bindToModel(Observables.staticObservableList(VendorStatus.VALUES), VendorStatus.class,
					"toString", new WritableValue());
			statusCombo.updateFromModel();
			statusCombo.setSelection(0);
		}

		// Create a supplier to hold all categories
		IObservableValue selectedValue = new WritableValue();
		categoryList.bindToModel(Observables.staticObservableList(SupplierCategory.getCategoriesList()),
				SupplierCategory.class, "name");
		categoryList.updateFromModel();

		final TypedBean<SupplierCategory> selection = new TypedBean<SupplierCategory>(null);
		selection.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				SupplierCategory node = selection.getValue();
				if (getSelectedEObject() != null) {
					Supplier supplier = (Supplier) getSelectedEObject();
					supplier.getCategories().clear();
					supplier.getCategories().add(node.getName());
				}
			}
		});
		categoryList.bindSingleSelectionToModel(selection, "value"); //$NON-NLS-1$
		categoryList.updateFromModel();

	}

	@Override
	protected void resetFilterConditions() {
		companyText.setText("");
		categoryList.setSelection((Object) null);
		statusCombo.setSelection(statusCombo.getEmptySelectionItem());
	}


	@Override
	protected List<Supplier> getFilteredResult() {

		org.hibernate.Session session = PersistenceManager.getDefault().getSession();
		Criteria criteria = session.createCriteria(this.getEntityClass());
		if (companyText != null && !"".equals(companyText.getText().trim())) {
			criteria.add(Restrictions.like(ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(), companyText.getText()
					+ "%"));
		}

		if (categoryList != null && categoryList.getSelection().size() > 0) {
			categoryList.setSelectionType(SelectionType.SINGLE);
		}

		if (statusCombo != null && statusCombo.getSelection() != null) {
			criteria.add(Restrictions.eq("status", statusCombo.getSelection()));
		}

		List ret = criteria.list();
		return ret;
	}

	@Override
	protected RecordDialog<Supplier, SupplierListDialogController> getRecordDialog(Shell shell) {
		return new SupplierListDialog(shell);
	}


}
