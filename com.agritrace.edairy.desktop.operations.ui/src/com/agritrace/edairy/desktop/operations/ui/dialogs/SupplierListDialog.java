package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Supplier;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractRecordListController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AddressGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.DirectionsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.MapGroupWidget;
import com.agritrace.edairy.desktop.operations.services.supplier.SupplierRepository;
import com.agritrace.edairy.desktop.operations.ui.controllers.SupplierListDialogController;

/**
 * Supplier list dialog to add/view/edit supplier
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class SupplierListDialog extends RecordDialog<Supplier, SupplierListDialogController> {

	private static int WIDTH_HEIGHT = 400;
	private static int DESC_HEIGHT_HEIGHT = 50;

	public static final String BIND_ID_SUPPLIER_ID = "bind.id.supplier.id";
	public static final String BIND_ID_SUPPLIER_STATUS = "bind.id.supplier.status";
	public static final String BIND_ID_COMPANY_NAME = "bind.id.supplier.companyname";
	public static final String BIND_ID_LEGAL_NAME = "bind.id.supplier.legalname";
	public static final String BIND_ID_CATEGORY = "bind.id.supplier.category";
	public static final String BIND_ID_DESCRIPTION = "bind.id.supplier.desc";

	public SupplierListDialog(int style, Shell parentShell,
			Supplier selectedObject, SupplierRepository supplierRepository) {
		super(style, parentShell, selectedObject, supplierRepository);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// newShell.setSize(500, 750);
		if (this.getActionType() == AbstractRecordListController.ACTION_NEW) {
			this.setTitle("Add Supplier");
		} else if (this.getActionType() == AbstractRecordListController.ACTION_VIEW) {
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

	protected SupplierListDialogController createController() {
		SupplierListDialogController controller = new SupplierListDialogController();
		controller.setWorkingCopy( null );
		return controller;
	}
}
