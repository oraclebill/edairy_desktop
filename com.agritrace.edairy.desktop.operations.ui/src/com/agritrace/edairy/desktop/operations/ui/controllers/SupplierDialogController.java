package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.beans.common.ListBean;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.SupplierCategory;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;

public class SupplierDialogController extends RecordDialogController<Supplier> {
	IController parentController;

	// public SupplierListDialogController(Supplier toBeEditedOrViewed) {
	// super(toBeEditedOrViewed);
	// }

	@Override
	public void configureUserRidgets() {
		// configure supplier ID
		final Supplier supplier = getWorkingCopy();
		
		addComboMap(SupplierListDialog.BIND_ID_SUPPLIER_STATUS, VendorStatus.VALUES, "name", DairyPackage.Literals.SUPPLIER__STATUS);
		addTextMap(SupplierListDialog.BIND_ID_COMPANY_NAME, ModelPackage.Literals.COMPANY__COMPANY_NAME);
		addTextMap(SupplierListDialog.BIND_ID_LEGAL_NAME,  ModelPackage.Literals.COMPANY__LEGAL_NAME);
//		addMultiChoiceMap(SupplierListDialog.BIND_ID_CATEGORY, SupplierCategory.getCategoriesList(), "name", DairyPackage.Literals.SUPPLIER__CATEGORIES);
		addTextMap(SupplierListDialog.BIND_ID_DESCRIPTION, DairyPackage.Literals.SUPPLIER__PUBLIC_DESCRIPTION);

		final ITextRidget supplierId = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_NUM);
		supplierId.setOutputOnly(false);
		supplierId.bindToModel(supplier, DairyPackage.Literals.SUPPLIER__ID.getName());
		supplierId.updateFromModel();
		
		final IProfilePhotoRidget profilePhoto = getRidget(IProfilePhotoRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_PHOTO);
		profilePhoto.bindToModel(EMFObservables.observeValue(supplier, ModelPackage.Literals.COMPANY__PROFILE_PHOTO));

		// Category
		final IListRidget category = getRidget(IListRidget.class, SupplierListDialog.BIND_ID_CATEGORY);
		if (category != null) {
			category.setSelectionType(SelectionType.MULTI);

			category.bindToModel(Observables.staticObservableList(SupplierCategory.getCategoriesList()),
					SupplierCategory.class, "name");
			category.updateFromModel();
			// categoriesList.bindToModel(EMFObservables.observeList(supplier,
			// DairyPackage.Literals.SUPPLIER__CATEGORIES), "value");
			final List<SupplierCategory> selectedCategoriesList = new ArrayList<SupplierCategory>();
			for (final String categor : supplier.getCategories()) {
				selectedCategoriesList.add(SupplierCategory.getByName(categor));
			}
			final ListBean selection = new ListBean();
			selection.setValues(selectedCategoriesList);
			selection.addPropertyChangeListener(new PropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent evt) {
					// Get current selections
					final List<?> values = selection.getValues();
					supplier.getCategories().clear();
					// Update the working copy
					for (final Object category : values) {
						supplier.getCategories().add(((SupplierCategory) category).getName());
					}

				}
			});
			category.bindMultiSelectionToModel(selection, "values");
			category.updateMultiSelectionFromModel();
		}

		Location supplierLocation = supplier.getLocation();
		if (supplierLocation == null) {
			supplierLocation = DairyUtil.createLocation(null, null, null);
			supplier.setLocation(supplierLocation);
		}

		// Configure address group
		final AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		addressGroupController.setInputModel(supplier.getLocation().getPostalLocation());
		addressGroupController.updateBinding();

		// Configure Direction Group
		final DirectionGroupController directionController = new DirectionGroupController(this);
		directionController.setInputModel(supplier.getLocation().getDescriptiveLocation());
		directionController.updateBinding();

		// Configure Map Group
		final MapGroupController mapController = new MapGroupController(this);
		mapController.setInputModel(supplier.getLocation().getMapLocation());
		mapController.updateBinding();

		// Configure Communication Group
		final IContactMethodsGroupRidget contacts = getRidget(IContactMethodsGroupRidget.class, IContactMethodsGroupRidget.WIDGET_ID);
		contacts.bindToModel(supplier);
		contacts.updateFromModel();

	}

}