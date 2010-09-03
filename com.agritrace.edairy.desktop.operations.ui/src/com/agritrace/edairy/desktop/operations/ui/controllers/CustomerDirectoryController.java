package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.reference.CompanyStatus;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.customer.CustomerRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.CustomerEditDialog;
import com.agritrace.edairy.desktop.operations.ui.views.CustomerDirectoryView;

@PermissionRequired(Permission.VIEW_CUSTOMERS)
public class CustomerDirectoryController extends BasicDirectoryController<Customer> {

	private static final IObservableList CUSTOMER_STATUSES = Observables.staticObservableList(CompanyStatus
			.getCustomerStatusList());
	private static final IObservableList CUSTOMER_TYPES = Observables.staticObservableList(CustomerType
			.getCustomerTypeList());

	private ITextRidget companyNameSearchText;
	private IComboRidget customerStatusCombo;
	private IComboRidget customerTypeSearchCombo;

	private final CustomerSearchBean searchBean = new CustomerSearchBean();

	public CustomerDirectoryController() {
		super();
		setRepository(new CustomerRepository());
		setEClass(DairyPackage.Literals.CUSTOMER);
		// setEntityClass(Customer.class);

		addTableColumn("ID", DairyPackage.Literals.CUSTOMER__ID);
		addTableColumn("Type", DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE);
		addTableColumn("Company Name", ModelPackage.Literals.COMPANY__COMPANY_NAME);
		addTableColumn("Contact", ModelPackage.Literals.COMPANY__CONTACTS, new ContactNameColumnFormatter());
		addTableColumn("Contact #", ModelPackage.Literals.COMPANY__PHONE_NUMBER, new ContactPhoneColumnFormatter());
		addTableColumn("Status", DairyPackage.Literals.CUSTOMER__STATUS);
	}

	@Override
	protected void configureFilterRidgets() {
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
		customerStatusCombo.bindToModel(CUSTOMER_STATUSES, CompanyStatus.class, "getName",
				BeansObservables.observeValue(searchBean, "statusSearchValue"));
		customerTypeSearchCombo.setEmptySelectionItem(EMPTY_SELECTION_TEXT);
		customerStatusCombo.updateFromModel();
		customerStatusCombo.setSelection(EMPTY_SELECTION_TEXT);
	}

	/**
	 * Create new model while createing a new record
	 * 
	 * @return
	 */
	@Override
	protected Customer createNewModel() {
		final Customer customer = (Customer) EMFUtil.createWorkingCopy(this.getEClass(), 3);
		customer.setPhoneNumber("");
		return customer;
	}

	@Override
	protected void createEntity(Customer newEntity) {
		DairyRepository.getInstance().getLocalDairy().getCustomers().add(newEntity);
		DairyRepository.getInstance().save();
		//		getRepository().saveNew(newEntity);
	}

	@Override
	protected List<Customer> getFilteredResult() {
		final List<Customer> filtered = new ArrayList<Customer>();
		final List<Customer> allCustomers = getRepository().all();
		System.err.println("allCustomers: " + allCustomers);
		for (final Customer c : allCustomers) {
			if (MatchUtil.matchContains(searchBean.getNameSearchValue(), c.getCompanyName())
					&& MatchUtil.matchEquals(searchBean.getTypeSearchValue(), c.getCustomerType())
					&& MatchUtil.matchEquals(searchBean.getStatusSearchValue(), c.getStatus())) {
				filtered.add(c);
			}
		}
		System.err.println("Filtered: " + filtered);
		return filtered;
	}

	@Override
	protected RecordDialog<Customer> getRecordDialog(Shell shell) {
		CustomerEditDialog dialog = new CustomerEditDialog(shell);
		dialog.setTitle("Edit Customer");
		return dialog;
	}

	@Override
	protected void resetFilterConditions() {
		companyNameSearchText.setText("");
		customerTypeSearchCombo.setSelection(customerStatusCombo.getEmptySelectionItem());
		customerStatusCombo.setSelection(customerStatusCombo.getEmptySelectionItem());
	}

	@Override
	protected void deleteEntity(Customer deletableEntity) {
		if(deletableEntity != null){
			DairyRepository.getInstance().getLocalDairy().getCustomers().remove(deletableEntity);
			super.deleteEntity(deletableEntity);
			DairyRepository.getInstance().save();
		}
	}
}
