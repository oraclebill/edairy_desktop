package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerStatus;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.operations.services.customer.CustomerRepository;
import com.agritrace.edairy.desktop.operations.services.customer.ICustomerRepository;
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

	private final ICustomerRepository customerRepo = new CustomerRepository();

	private ITextRidget companyNameSearchText;
	private IComboRidget customerTypeSearchCombo;
	private IComboRidget customerStatusCombo;

	private ITableRidget tableRidget;

	private SearchBean searchBean = new SearchBean();

	private List<Customer> customers;

	public CustomerDirectoryController() {
		super();
		customers = customerRepo.all();
		System.err.println(" ++++++++ customer list size == " + customers.size());
	}

	public ICustomerRepository getRepository() {
		return customerRepo;
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
		companyNameSearchText.bindToModel(searchBean, "nameSearchValue");

		// 
		customerTypeSearchCombo = getRidget(IComboRidget.class, CustomerDirectoryView.BIND_ID_FILTER_CUSTOMERTYPE);
		customerTypeSearchCombo.bindToModel(CUSTOMER_TYPES, CustomerType.class, null,
				BeansObservables.observeValue(searchBean, "typeSearchValue"));
		customerTypeSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		customerTypeSearchCombo.updateFromModel();
		customerTypeSearchCombo.setSelection(EMPTY_SELECTION_TEXT);

		// 
		customerStatusCombo = getRidget(IComboRidget.class, CustomerDirectoryView.BIND_ID_FILTER_STATUS);
		customerStatusCombo.bindToModel(CUSTOMER_STATUSES, CustomerStatus.class, null,
				BeansObservables.observeValue(searchBean, "typeSearchValue"));
		customerTypeSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		customerStatusCombo.updateFromModel();
		customerStatusCombo.setSelection(EMPTY_SELECTION_TEXT);

	}

	@Override
	protected List<Customer> getFilteredResult() {
		List<Customer> filtered = new ArrayList<Customer>();
		for (Customer c : customers) {
			boolean include = true;
			if (!c.getCompanyName().contains(check(searchBean.getNameSearchValue()))) {
				include = false;
			}
			if (!c.getCustomerType().equals(check(searchBean.getTypeSearchValue()))) {
				include = false;
			}
			if (!c.getStatus().equals(check(searchBean.getStatusSearchValue()))) {
				include = false;
			}
			if (include) {
				filtered.add(c);
			}
		}
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
	protected RecordDialog getRecordDialog(Shell shell) {
		return new CustomerDialog();
	}

	@Override
	protected void configureButtonsRidget() {
		final IActionRidget newBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_NEW);
		if (newBtnRidget != null) {
			newBtnRidget.addListener(new IActionListener() {
				@Override
				public void callback() {
					CustomerDialog customerDialog = new CustomerDialog();
					customerDialog.setTitle("New Customer");
					Customer newCustomer = DairyFactory.eINSTANCE.createCustomer();
					EMFUtil.populate(newCustomer);
					customerDialog.getController().setContext("editObject", newCustomer);
					int retVal = customerDialog.open();
					if (retVal == Dialog.OK) {
						customerRepo.saveNew(newCustomer);
					}
				}
			});
		}
		final IActionRidget viewBtnRidget = getRidget(IActionRidget.class, AbstractRecordListView.BIND_ID_VIEW);
		viewBtnRidget.setEnabled(false);
		if (viewBtnRidget != null) {
			viewBtnRidget.addListener(new IActionListener() {
				private Customer getCheckedSelection() {
					List<Object> selection = tableRidget.getSelection();
					if (selection == null || selection.size() == 0)
						return null;
					if (selection.size() > 1) {
						// TODO: log warning
						System.err.println("Warning: multiple selections present during 'View' action.");
					}
					Customer customer = null;
					if (selection.get(0) instanceof Customer) {
						customer = (Customer) selection.get(0);
					}
					if (customer == null) {
						// TODO: log warning
						System.err.println("Warning: null or empty selection during 'View' action.");
						return null;
					}
					return customer;
				}

				@Override
				public void callback() {
					Customer customer = getCheckedSelection();
					CustomerDialog customerDialog = new CustomerDialog();
					customerDialog.setTitle("View/Edit Customer");
					customerDialog.getController().setContext("editObject", customer);
					int retVal = customerDialog.open();
					if (retVal == Dialog.OK) {
						customerRepo.merge(customer);
					} else {
						customerRepo.restore(customer);
					}
					refreshTableContents();
				}
			});
		}
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

	private static String check(String actual) {
		return actual != null && actual.trim().length() > 0 ? actual : "";
	}

	static {
		for (int i = 0; i < 10; i++ ) {
			createTestCustomer();
		}
	}
	
	private static Customer createTestCustomer() {
		return createTestCustomer(null, null, null); 	
	}
	
	private static int sequence = 0;
	private static Customer createTestCustomer(String name, String type, String status) {
		Customer cust = DairyFactory.eINSTANCE.createCustomer();
		cust.setCompanyName(name != null ? name : "Test Company #" + sequence);
		cust.setCustomerType(type != null ? type : CustomerType.getCustomerTypeList().get(0).getName());
		cust.setStatus(status != null ? status : CustomerStatus.getCustomerStatusList().get(0).getName());
		cust.setPhoneNumber("" + sequence);
		cust.setDescription("Test Company");
		cust.setLocation(DairyUtil.createLocation(null, null, null));
		sequence++;
		return cust;
	}
	

}
