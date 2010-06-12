package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerStatus;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.operations.services.customer.CustomerRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.CustomerDialog;
import com.agritrace.edairy.desktop.operations.ui.views.CustomerDirectoryView;

public class CustomerDirectoryController extends AbstractRecordListController<Customer> {

	private static final String EMPTY_SELECTION_TEXT = "ANY";
	private static String[] PROPERTIES = { ModelPackage.Literals.COMPANY__COMPANY_ID.getName(),
			DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE.getName(),
			ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(), ModelPackage.Literals.COMPANY__CONTACTS.getName(),
			ModelPackage.Literals.COMPANY__PHONE_NUMBER.getName(), DairyPackage.Literals.CUSTOMER__STATUS.getName(), };
	private static String[] MASTER_HEADERS = { "ID", "Type", "Company Name", "Contact", "Contact #", "Status" };

	private static final IObservableList CUSTOMER_TYPES = Observables.staticObservableList(CustomerType
			.getCustomerTypeList());
	private static final IObservableList CUSTOMER_STATUSES = Observables.staticObservableList(CustomerStatus
			.getCustomerStatusList());

	private ITextRidget companyNameSearchText;
	private IComboRidget customerTypeSearchCombo;
	private IComboRidget customerStatusCombo;

	private ITableRidget tableRidget;

	private SearchBean searchBean = new SearchBean();

	public CustomerDirectoryController() {
		super();
		setRepository(new CustomerRepository());
	}

	@Override
	protected Class<?> getEntityClass() {
		return Customer.class;
	}

	@Override
	protected EClass getEClass() {
		return DairyPackage.Literals.CUSTOMER;
	}

	@Override
	protected String[] getTableColumnHeaders() {
		return MASTER_HEADERS;
	}

	@Override
	protected String[] getTableColumnPropertyNames() {
		return PROPERTIES;
	}

	@Override
	protected void configureFilterRidgets() {
		super.configureFilterRidgets();
		companyNameSearchText = getRidget(ITextRidget.class, CustomerDirectoryView.BIND_ID_FILTER_COMPANYNAME);
		companyNameSearchText.setDirectWriting(true);
		companyNameSearchText.bindToModel(searchBean, "nameSearchValue");

		//
		customerTypeSearchCombo = getRidget(IComboRidget.class, CustomerDirectoryView.BIND_ID_FILTER_CUSTOMERTYPE);
		customerTypeSearchCombo.bindToModel(CUSTOMER_TYPES, CustomerType.class, "getName",
				BeansObservables.observeValue(searchBean, "typeSearchValue"));
		customerTypeSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		customerTypeSearchCombo.updateFromModel();
		customerTypeSearchCombo.setSelection(EMPTY_SELECTION_TEXT);

		//
		customerStatusCombo = getRidget(IComboRidget.class, CustomerDirectoryView.BIND_ID_FILTER_STATUS);
		customerStatusCombo.bindToModel(CUSTOMER_STATUSES, CustomerStatus.class, "getName",
				BeansObservables.observeValue(searchBean, "statusSearchValue"));
		customerTypeSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		customerStatusCombo.updateFromModel();
		customerStatusCombo.setSelection(EMPTY_SELECTION_TEXT);

	}
	
	@Override
	protected void resetFilterConditions() {
		companyNameSearchText.setText("");
		customerTypeSearchCombo.setSelection(customerStatusCombo.getEmptySelectionItem());
		customerStatusCombo.setSelection(customerStatusCombo.getEmptySelectionItem());
	}

	@Override
	protected List<Customer> getFilteredResult() {
		List<Customer> filtered = new ArrayList<Customer>();
		List<Customer> allCustomers = getRepository().all();
		System.err.println("allCustomers: " + allCustomers);
		for (final Customer c : allCustomers) {
			if (matchContains(searchBean.getNameSearchValue(), c.getCompanyName())
					&& matchEquals(searchBean.getTypeSearchValue(), c.getCustomerType())
					&& matchEquals(searchBean.getStatusSearchValue(), c.getStatus())) {
				filtered.add(c);
			}
		}
		System.err.println("Filtered: " + filtered);
		return filtered;
	}

	@Override
	protected void configureTableRidget() {
		super.configureTableRidget();
		tableRidget = this.getRidget(ITableRidget.class, AbstractRecordListView.BIND_ID_TABLE);
		// For contact Name, we will get the first contact
		tableRidget.setColumnWidths(null);
		tableRidget.setColumnFormatter(3, new ColumnFormatter() {
			@Override
			public String getText(Object element) {
				if (element instanceof Customer) {
					Customer customer = (Customer) element;
					if (customer.getContacts().size() > 0) {
						return customer.getContacts().get(0).getGivenName() + " "
								+ customer.getContacts().get(0).getFamilyName();
					}
				}
				return null;
			}

		});

		// Contact Phone Number, we will get the first contact
		if (tableRidget != null) {
			tableRidget.setColumnFormatter(4, new ColumnFormatter() {

				@Override
				public String getText(Object element) {
					if (element instanceof Customer) {

						Customer customer = (Customer) element;

						if (customer.getContacts().size() > 0) {
							return customer.getContacts().get(0).getPhoneNumber();
						}
					}
					return null;
				}

			});
		}

	}

	@Override
	protected RecordDialog<Customer, ?> getRecordDialog(Shell shell) {
		return new CustomerDialog(shell);
	}

	/**
	 * Create new model while createing a new record
	 * 
	 * @return
	 */
	protected Customer createNewModel() {
		Customer customer = (Customer) EMFUtil.createWorkingCopy(this.getEClass(), 3);
		customer.setPhoneNumber("");
		return customer;
	}

	private static boolean matchContains(String userValue, String entityValue) {
		System.err.println("mc: " + userValue + ", " + entityValue);
		if (userValue == null || userValue.trim().length() == 0)
			return true;
		if (entityValue.contains(userValue))
			return true;
		System.err.println("false: " + userValue + ", " + entityValue);
		return false;
	}

	private static boolean matchEquals(Object userValue, String entityValue) {
		System.err.println("me: " + userValue + ", " + entityValue);
		if (userValue == null || userValue.toString().trim().length() == 0)
			return true;
		if (entityValue.equals(userValue))
			return true;
		System.err.println("false: " + userValue + ", " + entityValue);
		return false;
	}
}
