package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroup;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.location.LocationTabFolder;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierDialogController;

/**
 * Supplier list dialog to add/view/edit supplier
 * 
 * 
 */
public class SupplierListDialog extends RecordDialog<Supplier> {

	// private static int WIDTH_HEIGHT = 400;
	// private static int DESC_HEIGHT_HEIGHT = 50;

	public static final String BIND_ID_CATEGORY = "bind.id.supplier.category";
	public static final String BIND_ID_COMPANY_NAME = "bind.id.supplier.companyname";
	public static final String BIND_ID_DESCRIPTION = "bind.id.supplier.desc";
	public static final String BIND_ID_LEGAL_NAME = "bind.id.supplier.legalname";
	public static final String BIND_ID_SUPPLIER_ID = "bind.id.supplier.id";
	public static final String BIND_ID_SUPPLIER_STATUS = "bind.id.supplier.status";

	public SupplierListDialog(Shell parentShell) {
		super(parentShell);
	}

	private Composite createAddressArea(Composite parent) {

		final Composite addressGroup = UIControlsFactory
				.createComposite(parent);
		GridLayoutFactory.fillDefaults().applyTo(addressGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).span(2, 1).applyTo(addressGroup);

		final LocationTabFolder addressWidget = new LocationTabFolder(
				addressGroup, SWT.NONE);
		addressWidget.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(addressWidget);

		CTabFolder tabs = addressWidget.getTabFolder();

		final CTabItem tab = new CTabItem(tabs, SWT.NONE);
		tab.setText("Contacts");
		final ContactMethodsGroup contacts = new ContactMethodsGroup(tabs,
				SWT.NONE);
		tab.setControl(contacts);

		addUIControl(contacts, IContactMethodsGroupRidget.WIDGET_ID);

		return addressGroup;
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		final Composite comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayout(new GridLayout(2, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(comonComp);

		final GridDataFactory factory = GridDataFactory.swtDefaults()
				.align(SWT.FILL, SWT.FILL).grab(true, true);
		// Supplier Id
		UIControlsFactory.createLabel(comonComp, "Supplier ID");
		final Text txtDate = UIControlsFactory.createText(comonComp);
		factory.applyTo(txtDate);

		addUIControl(txtDate, BIND_ID_SUPPLIER_ID);

		// Status
		UIControlsFactory.createLabel(comonComp, "Status");
		final CCombo statusCombo = UIControlsFactory.createCCombo(comonComp);
		factory.copy().applyTo(statusCombo);
		addUIControl(statusCombo, BIND_ID_SUPPLIER_STATUS);

		// Company Name
		UIControlsFactory.createLabel(comonComp, "Company Name");
		final Text companyNameText = UIControlsFactory.createText(comonComp);
		factory.copy().applyTo(companyNameText);
		addUIControl(companyNameText, BIND_ID_COMPANY_NAME);

		// Legal Name
		UIControlsFactory.createLabel(comonComp, "Legal Name");
		final Text legalNameText = UIControlsFactory.createText(comonComp);
		factory.copy().applyTo(legalNameText);
		addUIControl(legalNameText, BIND_ID_LEGAL_NAME);

		// Category
		UIControlsFactory.createLabel(comonComp, "Category");
		final List categoryList = UIControlsFactory.createList(comonComp, true,
				true);
		GridDataFactory.swtDefaults().grab(true, false)
				.align(SWT.FILL, SWT.BEGINNING).applyTo(categoryList);
		addUIControl(categoryList, BIND_ID_CATEGORY);

		// Description
		UIControlsFactory.createLabel(comonComp, "Description");
		final Text descText = UIControlsFactory.createTextMulti(comonComp,
				true, true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING)
				.grab(true, false).hint(-1, 50).applyTo(descText);
		addUIControl(descText, BIND_ID_DESCRIPTION);

		createAddressArea(comonComp);

	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// newShell.setSize(500, 750);
		if (this.getActionType() == AbstractDirectoryController.ACTION_NEW) {
			this.setTitle("Add Supplier");
		} else if (this.getActionType() == AbstractDirectoryController.ACTION_VIEW) {
			this.setTitle("View Supplier");
		} else {
			this.setTitle("Edit Supplier");
		}
	}

	@Override
	protected SupplierDialogController createController() {
		final SupplierDialogController controller = new SupplierDialogController();
		return controller;
	}
}
