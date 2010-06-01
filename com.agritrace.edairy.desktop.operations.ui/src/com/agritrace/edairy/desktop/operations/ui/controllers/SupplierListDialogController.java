package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
<<<<<<< HEAD
import org.eclipse.emf.databinding.EMFObservables;
=======
>>>>>>> Category Multi Selection binding in Supplier List dialog can work
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.beans.common.ListBean;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.controllers.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.reference.SupplierCategory;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;

public class SupplierListDialogController extends RecordDialogController<Supplier> {
	IController parentController;

	// public SupplierListDialogController(Supplier toBeEditedOrViewed) {
	// super(toBeEditedOrViewed);
	// }

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		// configure supplier ID
		final Supplier supplier = getWorkingCopy();
		ITextRidget supplierId = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_ID); //$NON-NLS-1$
		if (this.getActionType() != AbstractRecordListController.ACTION_NEW) {
			supplierId.setOutputOnly(false);
		}
		supplierId.setDirectWriting(true);
		supplierId.bindToModel(supplier, ModelPackage.Literals.COMPANY__COMPANY_ID.getName());
		supplierId.updateFromModel();
		if (this.getActionType() != AbstractRecordListController.ACTION_NEW) {
			supplierId.setOutputOnly(true);
		}

		// Status
		IComboRidget statusCombo = getRidget(IComboRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_STATUS);
		// statusCombo.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
		statusCombo.bindToModel(Observables.staticObservableList(VendorStatus.VALUES), VendorStatus.class, "toString",
				PojoObservables.observeValue(supplier, DairyPackage.Literals.SUPPLIER__STATUS.getName()));

		statusCombo.updateFromModel();

		// Company Name
		ITextRidget companyName = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_COMPANY_NAME); //$NON-NLS-1$
		companyName.bindToModel(supplier, ModelPackage.Literals.COMPANY__COMPANY_NAME.getName());
		companyName.updateFromModel();

		// Legal Name
		ITextRidget legalName = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_LEGAL_NAME); //$NON-NLS-1$
		legalName.bindToModel(supplier, ModelPackage.Literals.COMPANY__LEGAL_NAME.getName());
		legalName.updateFromModel();

		// Category
		IListRidget category = getRidget(IListRidget.class, SupplierListDialog.BIND_ID_CATEGORY); //$NON-NLS-1$		
		if (category != null) {
			category.setSelectionType(SelectionType.MULTI);

			// Create a supplier to hold all categories
			IObservableValue selectedValue = new WritableValue();

			category.bindToModel(
					Observables.staticObservableList(SupplierCategory
							.getCategoriesList()), SupplierCategory.class,
					"name");
			category.updateFromModel();
			// categoriesList.bindToModel(EMFObservables.observeList(supplier,
			// DairyPackage.Literals.SUPPLIER__CATEGORIES), "value");
			List<SupplierCategory> selectedCategoriesList = new ArrayList<SupplierCategory>();
			for (String categor: supplier.getCategories())
			{
				selectedCategoriesList.add(SupplierCategory.getByName(categor));
			}
			final ListBean selection = new ListBean();
			selection.setValues(selectedCategoriesList);
			selection.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					// Get current selections
<<<<<<< HEAD
					List<?> values = selection.getValues();
=======
					List values = selection.getValues();
>>>>>>> Category Multi Selection binding in Supplier List dialog can work
					supplier.getCategories().clear();
					// Update the working copy
					for (Object category : values) {
						supplier.getCategories().add(
								((SupplierCategory) category).getName());
					}
					
				}
			});
			category.bindMultiSelectionToModel(selection, "values");
			category.updateMultiSelectionFromModel();
		}
<<<<<<< HEAD
//=======
//		IListRidget category = getRidget(IListRidget.class, SupplierListDialog.BIND_ID_CATEGORY); //$NON-NLS-1$
//		Supplier supplierBean = (Supplier) EMFUtil.createObject(this.getEClass());
//		supplierBean.getCategories().addAll(SupplierCategory.getCategories());
//		category.bindToModel(EMFObservables.observeList(supplier,
//				DairyPackage.Literals.SUPPLIER__CATEGORIES), "value");
//		category.bindMultiSelectionToModel(EMFObservables.observeList(supplier,
//				DairyPackage.Literals.SUPPLIER__CATEGORIES));
//		category.updateFromModel();
//>>>>>>> 1) Fixed the issue to create a new model 
		
=======
>>>>>>> Category Multi Selection binding in Supplier List dialog can work
		// Description
		ITextRidget desc = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_DESCRIPTION); //$NON-NLS-1$
		desc.bindToModel(supplier, DairyPackage.Literals.SUPPLIER__PUBLIC_DESCRIPTION.getName());
		desc.updateFromModel();

		// Configure address group
		AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		addressGroupController.setInputModel(supplier.getLocation().getPostalLocation());
		addressGroupController.updateBinding();

		// Configure Direction Group
		DirectionGroupController directionController = new DirectionGroupController(this);
		directionController.setInputModel(supplier.getLocation().getDescriptiveLocation());
		directionController.updateBinding();

		// Configure Map Group
		MapGroupController mapController = new MapGroupController(this);
		mapController.setInputModel(supplier.getLocation().getMapLocation());
		mapController.updateBinding();

		// Configure Communication Group
		CommunicationGroupController commController = new CommunicationGroupController(this);
		commController.setInputModel(supplier.getContactMethods());
		commController.updateBinding();

	}

	@Override
	protected EClass getEClass() {
		return DairyPackage.eINSTANCE.getSupplier();
	}

	// @Override
	// protected Supplier createWorkingCopy() {
	// return (Supplier) EMFUtil.createWorkingCopy(this.getEClass(), 2);
	// }
}