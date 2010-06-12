package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.beans.common.TypedBean;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITableRidget;
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
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.reference.SupplierCategory;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.views.AbstractRecordListView;
import com.agritrace.edairy.desktop.operations.services.supplier.SupplierRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;
import com.agritrace.edairy.desktop.operations.ui.views.SupplierListView;

public class SupplierListViewController extends
		AbstractRecordListController<Supplier> {

	private SupplierRepository supplierRepo;

	public static String[] MASTER_PROPTIES = {
			ModelPackage.Literals.COMPANY__COMPANY_ID.getName(),
			ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(),
			DairyPackage.Literals.SUPPLIER__CATEGORIES.getName(),
			ModelPackage.Literals.COMPANY__CONTACTS.getName(),
			ModelPackage.Literals.COMPANY__PHONE_NUMBER.getName(),
			DairyPackage.Literals.SUPPLIER__STATUS.getName() };

	public static String[] MASTER_HEADERS = { "ID", "Company Name", "Category",
			"Contact", "Contact #", "Status" };

	private IComboRidget statusCombo;

	private IListRidget categoriesList;

	public SupplierRepository getRepository() {
		if (supplierRepo == null) {
			supplierRepo = new SupplierRepository();
		}
		return supplierRepo;
	}

	@Override
	protected Class<?> getEntityClass() {
		return Supplier.class;
	}

	@Override
	protected EClass getEClass() {
		return DairyPackage.Literals.SUPPLIER;
	}

	@Override
	protected List<Supplier> getFilteredResult() {

//<<<<<<< HEAD
		org.hibernate.Session session = PersistenceManager.getDefault()
//=======
//		org.hibernate.Session session = PersistenceManager.getPersistenceManager()
//>>>>>>> 1) Fixed the issue to create a new model 
				.getSession();
		Criteria criteria = session.createCriteria(this.getEntityClass());
		// Company Name
		ITextRidget companyText = getRidget(ITextRidget.class,
				SupplierListView.BIND_ID_FILTER_CONTACT);
		if (companyText != null && !"".equals(companyText.getText().trim())) {
			criteria.add(Restrictions.like(
					ModelPackage.Literals.COMPANY__COMPANY_NAME.getName(),
					companyText.getText()+"%"));
		}
		// Category
		IListRidget categorieList = getRidget(IListRidget.class,
				SupplierListView.BIND_ID_FILTER_CATEGORIES);


		if (categorieList != null && categorieList.getSelection().size() > 0) {
			categorieList.setSelectionType(SelectionType.SINGLE);
//			List<String> categories = new ArrayList<String>();
//			for (Object category : categorieList.getSelection()) {
//				if (category instanceof SupplierCategory) {
//					categories.add(((SupplierCategory) category).getName());
//				}
//			}
//			Critiera critia = session.createCriteria(persistentClass)
//			criteria =criteria.createCriteria("categories");
//			criteria.add(Restrictions.eq("elt", ((SupplierCategory) categorieList.getSelection().get(0)).getName()));
		}

		// Status
		IComboRidget statusCombo = getRidget(IComboRidget.class,
				SupplierListView.BIND_ID_FILTER_STATUS);
		if (statusCombo != null && statusCombo.getSelection() != null) {
			criteria.add(Restrictions.eq("status", statusCombo.getSelection()));
		}

		List ret = criteria.list();
		return ret;
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
	protected RecordDialog<Supplier,SupplierListDialogController> getRecordDialog(Shell shell) {
		return new SupplierListDialog(shell);
	}

	/**
	 * Create new model while creating a new record
	 * 
	 * @return
	 */
	protected Supplier createNewModel() {
		Supplier supplier = (Supplier) EMFUtil.createWorkingCopy(
				this.getEClass(), 3);
		supplier.setPhoneNumber("");
		return supplier;
	}

	@Override
	protected void configureFilterRidgets() {
		super.configureFilterRidgets();
		statusCombo = getRidget(IComboRidget.class,
				SupplierListView.BIND_ID_FILTER_STATUS);
		if (statusCombo != null) {
			statusCombo.bindToModel(
					Observables.staticObservableList(VendorStatus.VALUES),
					VendorStatus.class, "toString", new WritableValue());
			statusCombo.updateFromModel();
			statusCombo.setSelection(0);
		}

		categoriesList = getRidget(IListRidget.class,
				SupplierListView.BIND_ID_FILTER_CATEGORIES);
		if (categoriesList != null) {

			// Create a supplier to hold all categories
			IObservableValue selectedValue = new WritableValue();
//			if (this.getSelectedEObject() != null) {
//				Supplier supplier = (Supplier)this.getSelectedEObject();
//				for (String category:supplier.getCategories())
//				{
//				}
//				selectedValue = Observables.staticObservableList(SupplierCategory.getCategoriesList());
//					
//			}
			categoriesList.bindToModel(
					Observables.staticObservableList(SupplierCategory
							.getCategoriesList()), SupplierCategory.class,
					"name");
			categoriesList.updateFromModel();
			// categoriesList.bindToModel(EMFObservables.observeList(supplier,
			// DairyPackage.Literals.SUPPLIER__CATEGORIES), "value");

			final TypedBean<SupplierCategory> selection = new TypedBean<SupplierCategory>(
					null);
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
			categoriesList.bindSingleSelectionToModel(selection, "value"); //$NON-NLS-1$

//			categoriesList.bindMultiSelectionToModel(EMFObservables
//					.observeList(getSelectedEObject(),
//							DairyPackage.Literals.SUPPLIER__CATEGORIES));

			categoriesList.updateFromModel();

		}
	}
	
	@Override
	protected void resetFilterConditions() {
		categoriesList.setSelection(-1);
		statusCombo.setSelection(statusCombo.getEmptySelectionItem());
	}



}
