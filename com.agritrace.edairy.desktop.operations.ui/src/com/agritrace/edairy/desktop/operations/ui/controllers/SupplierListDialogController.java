package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.riena.beans.common.ListBean;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ISelectableRidget.SelectionType;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.validation.NotEmpty;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.reference.SupplierCategory;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.ui.dialogs.SupplierListDialog;

public class SupplierListDialogController extends RecordDialogController<Supplier> {
	IController parentController;

	// public SupplierListDialogController(Supplier toBeEditedOrViewed) {
	// super(toBeEditedOrViewed);
	// }

	@Override
	public void configureUserRidgets() {
		// configure supplier ID
		final Supplier supplier = getWorkingCopy();
		final ITextRidget supplierId = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_ID);
		supplierId.setOutputOnly(false);
		supplierId.bindToModel(supplier, ModelPackage.Literals.COMPANY__COMPANY_ID.getName());
		supplierId.updateFromModel();
		if (this.getActionType() == AbstractDirectoryController.ACTION_NEW) {
			supplierId.setText("Auto Generated");
		}
		supplierId.setOutputOnly(true);

		// Status
		final IComboRidget statusCombo = getRidget(IComboRidget.class, SupplierListDialog.BIND_ID_SUPPLIER_STATUS);
		// statusCombo.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
		statusCombo.bindToModel(Observables.staticObservableList(VendorStatus.VALUES), VendorStatus.class, "toString",
				PojoObservables.observeValue(supplier, DairyPackage.Literals.SUPPLIER__STATUS.getName()));

		statusCombo.updateFromModel();

		// Company Name
		final ITextRidget companyName = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_COMPANY_NAME);
		companyName.bindToModel(supplier, ModelPackage.Literals.COMPANY__COMPANY_NAME.getName());
		companyName.updateFromModel();
		companyName.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
		companyName.setMandatory(true);

		// Legal Name
		final ITextRidget legalName = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_LEGAL_NAME);
		legalName.bindToModel(supplier, ModelPackage.Literals.COMPANY__LEGAL_NAME.getName());
		legalName.updateFromModel();
		legalName.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
		legalName.setMandatory(true);

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
		// Description
		final ITextRidget desc = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_DESCRIPTION);
		desc.bindToModel(supplier, DairyPackage.Literals.SUPPLIER__PUBLIC_DESCRIPTION.getName());
		desc.updateFromModel();

		Location supplierLocation = supplier.getLocation();
		if (supplierLocation == null) {
			supplierLocation = DairyUtil.createLocation(null, null, null);
			supplier.setLocation(supplierLocation);
		}
		EMFUtil.populate(supplierLocation);

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
		final CommunicationGroupController commController = new CommunicationGroupController(this);
		// ContactMethod method = ModelFactory.eINSTANCE.createContactMethod();
		// method.setCmType(ContactMethodType.EMAIL);
		// method.setCmValue("sparkwan@gmail.com");
		// supplier.getContactMethods().add(method);
		commController.setInputModel(supplier);
		commController.updateBinding();

	}
	//
	// @Override
	// protected EClass getEClass() {
	// return DairyPackage.eINSTANCE.getSupplier();
	// }

}