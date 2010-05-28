package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
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
import com.agritrace.edairy.desktop.common.ui.views.AddressGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.DirectionsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.MapGroupWidget;

/**
 * Supplier list dialog to add/view/edit supplier
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class SupplierListDialog extends RecordDialog {

	static class SupplierListDialogController extends RecordDialogController {
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
					BIND_ID_SUPPLIER_ID); //$NON-NLS-1$
			supplierId.setDirectWriting(true);
			supplierId.setOutputOnly(false);
			supplierId.bindToModel(supplier,
					DairyPackage.Literals.SUPPLIER__SUPPLIER_ID.getName());
			supplierId.updateFromModel();
			supplierId.setOutputOnly(true);

			// Status
			IComboRidget statusCombo = getRidget(IComboRidget.class,
					BIND_ID_SUPPLIER_STATUS);
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
					BIND_ID_COMPANY_NAME); //$NON-NLS-1$
			companyName.bindToModel(supplier,
					ModelPackage.Literals.COMPANY__COMPANY_NAME.getName());
			companyName.updateFromModel();

			// Legal Name
			ITextRidget legalName = getRidget(ITextRidget.class,
					BIND_ID_LEGAL_NAME); //$NON-NLS-1$
			legalName.bindToModel(supplier,
					ModelPackage.Literals.COMPANY__LEGAL_NAME.getName());
			legalName.updateFromModel();

			// Category
			IListRidget category = getRidget(IListRidget.class,
					BIND_ID_CATEGORY); //$NON-NLS-1$
			category.bindToModel(supplier,
					DairyPackage.Literals.SUPPLIER__CATEGORIES.getName());
			category.bindToModel(
					Observables.staticObservableList(SupplierCategory
							.getCategoriesList()), SupplierCategory.class,
					"name");
			category.updateFromModel();

			// Description
			ITextRidget desc = getRidget(ITextRidget.class, BIND_ID_DESCRIPTION); //$NON-NLS-1$
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
		protected void doCreation() {
			Dairy dairy = DairyDemoResourceManager.INSTANCE.getLocalDairy();
			Supplier newSupplier = (Supplier) this.getWorkingCopy();
			dairy.getSuppliers().add(newSupplier);
			// DairyDemoResourceManager.INSTANCE.getDairyResoure().getContents().add(newSupplier);
			doSave();

		}

		@Override
		protected void doUpdate() {
			doSave();
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

	private static int WIDTH_HEIGHT = 400;
	private static int DESC_HEIGHT_HEIGHT = 50;

	public static final String BIND_ID_SUPPLIER_ID = "bind.id.supplier.id";
	public static final String BIND_ID_SUPPLIER_STATUS = "bind.id.supplier.status";
	public static final String BIND_ID_COMPANY_NAME = "bind.id.supplier.companyname";
	public static final String BIND_ID_LEGAL_NAME = "bind.id.supplier.legalname";
	public static final String BIND_ID_CATEGORY = "bind.id.supplier.category";
	public static final String BIND_ID_DESCRIPTION = "bind.id.supplier.desc";

	public SupplierListDialog(int style, Shell parentShell,
			EObject selectedObject) {
		super(style, parentShell, selectedObject);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// newShell.setSize(500, 750);
		if (this.getDialogStyle() == DIALOG_STYLE_NEW) {
			this.setTitle("Add Supplier");
		} else if (this.getDialogStyle() == DIALOG_STYLE_VIEW) {
			this.setTitle("View Supplier");
		} else {
			this.setTitle("Edit Supplier");
		}
	}

	@Override
	protected void createUIComponent(Composite parent) {

		Composite comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayout(new GridLayout(2, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(comonComp);

		GridDataFactory factory = GridDataFactory.swtDefaults()
				.align(SWT.FILL, SWT.FILL).grab(true, true);
		// Supplier Id
		UIControlsFactory.createLabel(comonComp, "Supplier ID");
		Text txtDate = UIControlsFactory.createText(comonComp);
		factory.applyTo(txtDate);

		addUIControl(txtDate, BIND_ID_SUPPLIER_ID); //$NON-NLS-1$

		// Status
		UIControlsFactory.createLabel(comonComp, "Status");
		Combo statusCombo = UIControlsFactory.createCombo(comonComp);
		factory.copy().applyTo(statusCombo);
		addUIControl(statusCombo, BIND_ID_SUPPLIER_STATUS); //$NON-NLS-1$

		// Company Name
		UIControlsFactory.createLabel(comonComp, "Company Name");
		Text companyNameText = UIControlsFactory.createText(comonComp);
		factory.copy().applyTo(companyNameText);
		addUIControl(companyNameText, BIND_ID_COMPANY_NAME); //$NON-NLS-1$

		// Legal Name
		UIControlsFactory.createLabel(comonComp, "Legal Name");
		Text legalNameText = UIControlsFactory.createText(comonComp);
		factory.copy().applyTo(legalNameText);
		addUIControl(legalNameText, BIND_ID_LEGAL_NAME); //$NON-NLS-1$

		// Category
		UIControlsFactory.createLabel(comonComp, "Category");
		List categoryList = UIControlsFactory.createList(comonComp, true, true);
		GridDataFactory.swtDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).applyTo(categoryList);
		addUIControl(categoryList, BIND_ID_CATEGORY); //$NON-NLS-1$

		// Description
		UIControlsFactory.createLabel(comonComp, "Description");
		Text descText = UIControlsFactory
				.createTextMulti(comonComp, true, true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.grab(true, false).hint(-1, 50).applyTo(descText);
		addUIControl(descText, BIND_ID_DESCRIPTION); //$NON-NLS-1$

		createContactGroup(comonComp);

	}

	private void createContactGroup(Composite parent) {
		Group companyContactGroup = UIControlsFactory.createGroup(parent,
				"Company Contact");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).span(2, 1).applyTo(companyContactGroup);
		GridLayoutFactory.swtDefaults().numColumns(2)
				.applyTo(companyContactGroup);
		AddressGroupWidget addressWidget = new AddressGroupWidget(
				companyContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).span(2, 1).applyTo(addressWidget.getGroup());
		addressWidget.getGroup().pack();

		DirectionsGroupWidget directionWidget = new DirectionsGroupWidget(
				companyContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(directionWidget.getGroup());
		directionWidget.getGroup().pack();

		MapGroupWidget mapWidget = new MapGroupWidget(companyContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(mapWidget.getGroup());
		mapWidget.getGroup().pack();

		CommunicationsGroupWidget commGroup = new CommunicationsGroupWidget(
				companyContactGroup);
		// GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(
		// commGroup.getGroup());
		// commGroup.getGroup().pack();
		//
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).span(2, 1)
				.applyTo(commGroup.getGroup());
		commGroup.getGroup().pack();
	}

	protected AbstractWindowController createController() {
		RecordDialogController controller = new SupplierListDialogController(
				this);
		return controller;
	}
}
