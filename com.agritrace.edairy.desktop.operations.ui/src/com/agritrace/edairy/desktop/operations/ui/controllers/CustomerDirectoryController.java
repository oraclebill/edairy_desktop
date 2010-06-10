package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.operations.services.customer.CustomerRepository;
import com.agritrace.edairy.desktop.operations.services.customer.ICustomerRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.CustomerDialog;
import com.agritrace.edairy.desktop.operations.ui.views.CustomerDirectoryView;

public class CustomerDirectoryController extends AbstractRecordListController<Customer> {

	private final ICustomerRepository customerRepo;

	private static String[] PROPERTIES = { 
		ModelPackage.Literals.COMPANY__COMPANY_ID.getName(),
		ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(), 
		ModelPackage.Literals.COMPANY__CONTACTS.getName(),
		ModelPackage.Literals.COMPANY__PHONE_NUMBER.getName(),
		DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE.getName() };

	private static String[] MASTER_HEADERS = { "ID", "Company Name", "Contact", "Contact #", "Type" };

	private ITextRidget companyNameSearchText;
	private IComboRidget customerTypeSearchCombo;
	private ITableRidget tableRidget;

	private String nameSearchValue;
	private String typeSearchValue;

	private List<Customer> customers;

	public CustomerDirectoryController() {
		super();
		customerRepo = new CustomerRepository();
		customers = customerRepo.all();
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
		return DairyPackage.Literals.SUPPLIER;
	}

	@Override
	protected List<Customer> getFilteredResult() {
		List<Customer> filtered = new ArrayList<Customer>();
		if (nameSearchValue != null && nameSearchValue.length() > 0) {

		}
		for (Customer c : customers) {
			boolean include = true;
			if (nameSearchValue != null && !c.getCompanyName().contains(nameSearchValue)) {
				include = false;
			}
			if (include && typeSearchValue != null && !c.getCustomerType().contains(typeSearchValue)) {
				include = false;
			}
			if (include) {
				filtered.add(c);
			}
		}
		return filtered;
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
	protected void configureTableRidget() {
		super.configureTableRidget();
		tableRidget = this.getRidget(ITableRidget.class, AbstractRecordListView.BIND_ID_TABLE);
		// For contact Name, we will get the first contact
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
	protected RecordDialog getEditDialog(int dialogStyle, Customer selectedObj) {
		// return new CustomerDialog(dialogStyle, null, (Customer) selectedObj,
		// getRepository());
		return null;
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
					}
					else {
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

	@Override
	protected void configureFilterRidgets() {
		super.configureFilterRidgets();
		companyNameSearchText = getRidget(ITextRidget.class, CustomerDirectoryView.BIND_ID_FILTER_COMPANYNAME);
		companyNameSearchText.bindToModel(this, "nameSearchValue");

		customerTypeSearchCombo = getRidget(IComboRidget.class, CustomerDirectoryView.BIND_ID_FILTER_CUSTOMERTYPE);
		customerTypeSearchCombo.bindToModel(Observables.staticObservableList(CustomerType.getCustomerTypeList()),
				CustomerType.class, null, BeansObservables.observeValue(this, "typeSearchValue"));
		customerTypeSearchCombo.updateFromModel();
//		customerTypeSearchCombo.setSelection(0);

		// final TypedBean<CustomerType> selection = new
		// TypedBean<CustomerType>(null);
		// selection.addPropertyChangeListener(new PropertyChangeListener() {
		// public void propertyChange(PropertyChangeEvent evt) {
		// CustomerType node = selection.getValue();
		// if (getSelectedEObject() != null) {
		// Customer customer = (Customer) getSelectedEObject();
		// customer.getCategories().add(node.getName());
		// }
		// }
		// });
		//		customerType.bindSingleSelectionToModel(selection, "value"); //$NON-NLS-1$
		// customerType.updateFromModel();

	}

	public String getNameSearchValue() {
		return nameSearchValue;
	}

	public void setNameSearchValue(String nameSearchValue) {
		this.nameSearchValue = nameSearchValue;
	}

	public String getTypeSearchValue() {
		return typeSearchValue;
	}

	public void setTypeSearchValue(String typeSearchValue) {
		this.typeSearchValue = typeSearchValue;
	}

}
