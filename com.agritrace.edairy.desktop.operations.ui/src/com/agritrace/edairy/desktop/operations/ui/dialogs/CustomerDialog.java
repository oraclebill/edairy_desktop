package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AddressGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.DirectionsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.MapGroupWidget;
import com.agritrace.edairy.desktop.operations.ui.controllers.CustomerDialogController;

/**
 * Customer list dialog to add/view/edit customer
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class CustomerDialog extends RecordDialog<Customer, CustomerDialogController> {

	// private static int WIDTH_HEIGHT = 400;
	// private static int DESC_HEIGHT_HEIGHT = 50;

	public static final String BIND_ID_CUSTOMER_ID = "bind.id.customer.id";
	public static final String BIND_ID_CUSTOMER_STATUS = "bind.id.customer.status";
	public static final String BIND_ID_COMPANY_NAME = "bind.id.customer.companyname";
	public static final String BIND_ID_LEGAL_NAME = "bind.id.customer.legalname";
	public static final String BIND_ID_CUSTOMERTYPE = "bind.id.customer.customertype";
	public static final String BIND_ID_DESCRIPTION = "bind.id.customer.desc";

	public CustomerDialog() {
		super(null);
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		Composite comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayout(new GridLayout(2, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comonComp);

		GridDataFactory factory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true);
		// Customer Id
		UIControlsFactory.createLabel(comonComp, "Customer ID");
		Text txtDate = UIControlsFactory.createText(comonComp);
		factory.applyTo(txtDate);

		addUIControl(txtDate, BIND_ID_CUSTOMER_ID); //$NON-NLS-1$

		// Status
		UIControlsFactory.createLabel(comonComp, "Status");
		Combo statusCombo = UIControlsFactory.createCombo(comonComp);
		factory.copy().applyTo(statusCombo);
		addUIControl(statusCombo, BIND_ID_CUSTOMER_STATUS); //$NON-NLS-1$

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
		CCombo typeCombo = UIControlsFactory.createCCombo(comonComp);
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(typeCombo);
		addUIControl(typeCombo, BIND_ID_CUSTOMERTYPE); //$NON-NLS-1$

		// Description
		UIControlsFactory.createLabel(comonComp, "Description");
		Text descText = UIControlsFactory.createTextMulti(comonComp, true, true);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).hint(-1, 50).applyTo(descText);
		addUIControl(descText, BIND_ID_DESCRIPTION); //$NON-NLS-1$

		createContactGroup(comonComp);

	}

	private void createContactGroup(Composite parent) {
		Group companyContactGroup = UIControlsFactory.createGroup(parent, "Company Contact");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1)
				.applyTo(companyContactGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(companyContactGroup);
		AddressGroupWidget addressWidget = new AddressGroupWidget(companyContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1)
				.applyTo(addressWidget.getGroup());
		addressWidget.getGroup().pack();

		DirectionsGroupWidget directionWidget = new DirectionsGroupWidget(companyContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(directionWidget.getGroup());
		directionWidget.getGroup().pack();

		MapGroupWidget mapWidget = new MapGroupWidget(companyContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(mapWidget.getGroup());
		mapWidget.getGroup().pack();

		CommunicationsGroupWidget commGroup = new CommunicationsGroupWidget(companyContactGroup);
		// GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(
		// commGroup.getGroup());
		// commGroup.getGroup().pack();
		//
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(commGroup.getGroup());
		commGroup.getGroup().pack();
	}

	protected CustomerDialogController createController() {
		CustomerDialogController controller = new CustomerDialogController();
		// controller.setWorkingCopy( null );
		return controller;
	}
}