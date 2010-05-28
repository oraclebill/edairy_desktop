package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;
import com.agritrace.edairy.desktop.common.ui.controllers.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.reference.SupplierCategory;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.model.persistence.services.PersistenceManager;

class SupplierListDialogController extends RecordDialogController {
	IController parentController;

	SupplierListDialogController(RecordDialog dialog) {
		super(dialog);
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		// configure supplier ID
		final Supplier supplier = (Supplier) getWorkingCopy();
		ITextRidget supplierId = getRidget(ITextRidget.class,
				SupplierListDialog.BIND_ID_SUPPLIER_ID); //$NON-NLS-1$
		supplierId.setDirectWriting(true);
		supplierId.setOutputOnly(false);
		supplierId.bindToModel(supplier,
				DairyPackage.Literals.SUPPLIER__SUPPLIER_ID.getName());
		supplierId.updateFromModel();
		supplierId.setOutputOnly(true);

		// Status
		IComboRidget statusCombo = getRidget(IComboRidget.class,
				SupplierListDialog.BIND_ID_SUPPLIER_STATUS);
		// statusCombo.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
		statusCombo.bindToModel(Observables
				.staticObservableList(VendorStatus.VALUES),
				VendorStatus.class, "toString", PojoObservables
						.observeValue(supplier,
								DairyPackage.Literals.SUPPLIER__STATUS
										.getName()));

		statusCombo.updateFromModel();

		// Company Name
		ITextRidget companyName = getRidget(ITextRidget.class,
				SupplierListDialog.BIND_ID_COMPANY_NAME); //$NON-NLS-1$
		companyName.bindToModel(supplier,
				ModelPackage.Literals.COMPANY__COMPANY_NAME.getName());
		companyName.updateFromModel();

		// Legal Name
		ITextRidget legalName = getRidget(ITextRidget.class,
				SupplierListDialog.BIND_ID_LEGAL_NAME); //$NON-NLS-1$
		legalName.bindToModel(supplier,
				ModelPackage.Literals.COMPANY__LEGAL_NAME.getName());
		legalName.updateFromModel();

		// Category
		IListRidget category = getRidget(IListRidget.class,
				SupplierListDialog.BIND_ID_CATEGORY); //$NON-NLS-1$
		category.bindToModel(supplier,
				DairyPackage.Literals.SUPPLIER__CATEGORIES.getName());
		category.bindToModel(
				Observables.staticObservableList(SupplierCategory
						.getCategoriesList()), SupplierCategory.class,
				"name");
		category.updateFromModel();

		// Description
		ITextRidget desc = getRidget(ITextRidget.class, SupplierListDialog.BIND_ID_DESCRIPTION); //$NON-NLS-1$
		desc.bindToModel(supplier,
				DairyPackage.Literals.SUPPLIER__PUBLIC_DESCRIPTION
						.getName());
		desc.updateFromModel();

		// Configure address group
		AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(
				this);
		addressGroupController.setInputModel(supplier.getLocation()
				.getPostalLocation());
		addressGroupController.updateBinding();

		// Configure Direction Group
		DirectionGroupController directionController = new DirectionGroupController(
				this);
		directionController.setInputModel(supplier.getLocation()
				.getDescriptiveLocation());
		directionController.updateBinding();

		// Configure Map Group
		MapGroupController mapController = new MapGroupController(this);
		mapController
				.setInputModel(supplier.getLocation().getMapLocation());
		mapController.updateBinding();

		// Configure Communication Group
		CommunicationGroupController commController = new CommunicationGroupController(
				this);
		commController.setInputModel(supplier.getContactMethods());
		commController.updateBinding();

	}

	@Override
	protected void saveNew() {
		
		Session session = PersistenceManager.INSTANCE.getSessionFactory().openSession();
		
		Supplier supplier = (Supplier)getWorkingCopy();
		
		session.persist("Supplier", supplier);
		
		session.close();
		
//		Dairy dairy = DairyDemoResourceManager.INSTANCE.getLocalDairy();
//		Supplier newSupplier = (Supplier) this.getWorkingCopy();
//		dairy.getSuppliers().add(newSupplier);
//		// DairyDemoResourceManager.INSTANCE.getDairyResoure().getContents().add(newSupplier);
//		doSave();

	}

	@Override
	protected void saveUpdated() {
		Session session = PersistenceManager.INSTANCE.getSessionFactory().openSession();
		
		Supplier supplier = (Supplier)getWorkingCopy();
		
		session.update("Supplier", supplier);
		
		session.close();
		

		//		doSave();
		
	}

	@Override
	protected EClass getEClass() {
		return DairyPackage.eINSTANCE.getSupplier();
	}

	@Override
	protected EObject createWorkingCopy() {
		return EMFUtil.createWorkingCopy(this.getEClass(), 2);
	}
}