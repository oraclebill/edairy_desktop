package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.beans.common.TypedBean;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITextRidget;
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
import com.agritrace.edairy.desktop.operations.services.supplier.SupplierRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierListView;

public class SupplierDirectoryView extends BasicDirectoryController {

	// filter ridgets
	private IComboRidget statusCombo;
	private IListRidget categoryList;
	private ITextRidget companyText;

	// filter bean
	private final SupplierSearchBean searchBean = new SupplierSearchBean();

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
		statusCombo = getRidget(IComboRidget.class, SupplierListView.BIND_ID_FILTER_STATUS);
		categoryList = getRidget(IListRidget.class, SupplierListView.BIND_ID_FILTER_CATEGORIES);

		companyText.setDirectWriting(true);
		companyText.bindToModel(searchBean, "name");
		companyText.updateFromModel();

		categoryList.bindSingleSelectionToModel(searchBean, "category");
		categoryList.bindToModel(Observables.staticObservableList(SupplierCategory.getCategoriesList()),
				SupplierCategory.class, "name");
		categoryList.updateFromModel();

		statusCombo.bindToModel(Observables.staticObservableList(VendorStatus.VALUES), 
				VendorStatus.class, "toString",
				BeansObservables.observeValue(searchBean, "status"));
		statusCombo.updateFromModel();
		statusCombo.setSelection(0);
	}

	@Override
	protected void resetFilterConditions() {
		companyText.setText("");
		categoryList.setSelection((Object) null);
		statusCombo.setSelection(statusCombo.getEmptySelectionItem());
	}

	@Override
	protected List<Supplier> getFilteredResult() {
		List<Supplier> allSuppliers = getRepository().all();
		List<Supplier> filteredSuppliers = new ArrayList<Supplier>();
		
		for (final Supplier s : allSuppliers ) {
			if (MatchUtil.matchContains(searchBean.getName(), s.getCompanyName())
					&& MatchUtil.matchContains(searchBean.getCategory(), s.getCategories() )
					&& MatchUtil.matchEquals(searchBean.getStatus(), s.getStatus())) {
				filteredSuppliers.add(s);
			}
		}
		return filteredSuppliers;
	}

	@Override
	protected RecordDialog<Supplier, SupplierListDialogController> getRecordDialog(Shell shell) {
		return new SupplierListDialog(shell);
	}

}
