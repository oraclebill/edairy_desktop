package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.controllers.ResultListDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.model.dairy.VendorStatus;

public class SupplierListDialog extends RecordDialog {

	private Composite comp;
	private static int WIDTH_HEIGHT = 400;

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
		GridDataFactory.swtDefaults().grab(true, true).applyTo(comonComp);

		// Supplier Id
		UIControlsFactory.createLabel(comonComp, "Supplier ID");
		Text txtDate = UIControlsFactory.createText(comonComp);
		GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		dateData.horizontalSpan = 1;
		dateData.grabExcessHorizontalSpace = true;
		dateData.widthHint = WIDTH_HEIGHT;
		txtDate.setLayoutData(dateData);
		addUIControl(txtDate, BIND_ID_SUPPLIER_ID); //$NON-NLS-1$

		// Status
		UIControlsFactory.createLabel(comonComp, "Status");
		Combo statusCombo = UIControlsFactory.createCombo(comonComp);
		GridDataFactory.swtDefaults().grab(true, false).hint(WIDTH_HEIGHT, -1)
				.applyTo(statusCombo);
		addUIControl(statusCombo, BIND_ID_SUPPLIER_STATUS); //$NON-NLS-1$

		// Company Name
		UIControlsFactory.createLabel(comonComp, "Company Name");
		Text companyNameText = UIControlsFactory.createText(comonComp);
		GridDataFactory.swtDefaults().grab(true, false).hint(WIDTH_HEIGHT, -1)
				.applyTo(companyNameText);
		addUIControl(companyNameText, BIND_ID_COMPANY_NAME); //$NON-NLS-1$

		// Legal Name
		UIControlsFactory.createLabel(comonComp, "Legal Name");
		Text legalNameText = UIControlsFactory.createText(comonComp);
		GridDataFactory.swtDefaults().grab(true, false).hint(WIDTH_HEIGHT, -1)
				.applyTo(legalNameText);
		addUIControl(legalNameText, BIND_ID_LEGAL_NAME); //$NON-NLS-1$

		// Category
		UIControlsFactory.createLabel(comonComp, "Category");
		List categoryList = UIControlsFactory.createList(comonComp, true, true);
		GridDataFactory.swtDefaults().grab(true, false).hint(WIDTH_HEIGHT, -1)
				.applyTo(categoryList);
		addUIControl(categoryList, BIND_ID_CATEGORY); //$NON-NLS-1$

		// Description
		UIControlsFactory.createLabel(comonComp, "Description");
		Text descText = UIControlsFactory
				.createTextMulti(comonComp, true, true);
		GridDataFactory.swtDefaults().grab(true, false).hint(WIDTH_HEIGHT, -1)
				.applyTo(descText);
		addUIControl(descText, BIND_ID_DESCRIPTION); //$NON-NLS-1$

		Group companyContactGroup = UIControlsFactory.createGroup(comonComp,
				"Company Contact");
		GridDataFactory.swtDefaults().grab(true, false).span(2, 1).applyTo(
				companyContactGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(
				companyContactGroup);

		// Address

	}

	protected AbstractWindowController createController() {
		ResultListDialogController controller = new ResultListDialogController() {

			@Override
			public EObject createWorkingCopy() {
				Supplier supllier = DairyFactory.eINSTANCE.createSupplier();
				return supllier;
			}

			@Override
			public void configureRidgets() {
				super.configureRidgets();
				// Copy selected object to
				// Copy selected into working copy
				if (getSelectedEObject() != null
						&& getDialogStyle() != DIALOG_STYLE_NEW) {
					EMFUtil.copy(getSelectedEObject(), getWorkingCopy());
				}
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
						VendorStatus.class, "toString", new WritableValue(
								supplier,
								DairyPackage.Literals.SUPPLIER__STATUS));

				statusCombo.updateFromModel();

				// Company Name
				ITextRidget companyName = getRidget(ITextRidget.class,
						BIND_ID_COMPANY_NAME); //$NON-NLS-1$
				companyName.bindToModel(supplier,
						DairyPackage.Literals.SUPPLIER__SUPPLIER_ID.getName());
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
				category.updateFromModel();

				// Description
				ITextRidget desc = getRidget(ITextRidget.class,
						BIND_ID_DESCRIPTION); //$NON-NLS-1$
				desc.bindToModel(supplier,
						DairyPackage.Literals.SUPPLIER__PUBLIC_DESCRIPTION
								.getName());
				desc.updateFromModel();

			}

		};
		return controller;
	}
}