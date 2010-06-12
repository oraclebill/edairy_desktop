package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AddressGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.DirectionsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.MapGroupWidget;
import com.agritrace.edairy.desktop.operations.ui.controllers.CustomerDialogController;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Link;
import com.swtdesigner.SWTResourceManager;

/**
 * Customer list dialog to add/view/edit customer
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class CustomerDialog extends RecordDialog<Customer, CustomerDialogController> {
	private Composite comonComp;

	// private static int WIDTH_HEIGHT = 400;
	// private static int DESC_HEIGHT_HEIGHT = 50;

	public CustomerDialog() {
		super(null);
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		comonComp.setLayout(new GridLayout(2, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comonComp);

		GridDataFactory factory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true);

		Composite composite = new Composite(comonComp, SWT.NONE);
		composite.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));
		// Customer Id
		Label label = UIControlsFactory.createLabel(composite, "Customer ID");
		Text txtDate = UIControlsFactory.createText(composite);
		txtDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.applyTo(txtDate);

		addUIControl(txtDate, CustomerBindingConstants.BIND_ID_CUSTOMER_ID);

		// Company Name
		Label label_1 = UIControlsFactory.createLabel(composite, "Company Name");
		Text companyNameText = UIControlsFactory.createText(composite);
		companyNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(companyNameText);
		addUIControl(companyNameText, CustomerBindingConstants.BIND_ID_COMPANY_NAME);

		// Status
		Label label_2 = UIControlsFactory.createLabel(composite, "Status");
		Combo statusCombo = UIControlsFactory.createCombo(composite);
		statusCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(statusCombo);
		addUIControl(statusCombo, CustomerBindingConstants.BIND_ID_CUSTOMER_STATUS);

		// Legal Name
		Label label_3 = UIControlsFactory.createLabel(composite, "Legal Name");
		Text legalNameText = UIControlsFactory.createText(composite);
		legalNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(legalNameText);
		addUIControl(legalNameText, CustomerBindingConstants.BIND_ID_LEGAL_NAME);

		// Phone Number
		Label label_4 = UIControlsFactory.createLabel(composite, "Phone Number");
		Text phoneText = UIControlsFactory.createText(composite);
		phoneText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(phoneText);
		addUIControl(phoneText, CustomerBindingConstants.BIND_ID_PHONE_NUMBER);

		// Category
		Label label_5 = UIControlsFactory.createLabel(composite, "Category");
		Combo typeCombo = UIControlsFactory.createCombo(composite);
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(typeCombo);
		addUIControl(typeCombo, CustomerBindingConstants.BIND_ID_CUSTOMERTYPE);

		// Description
		Label label_6 = UIControlsFactory.createLabel(composite, "Description");
		Text descText = UIControlsFactory.createTextMulti(composite, true, true);
		descText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).hint(-1, 50).applyTo(descText);
		addUIControl(descText, CustomerBindingConstants.BIND_ID_DESCRIPTION);

		createContactGroup(comonComp);
		new Label(comonComp, SWT.NONE);
		parent.pack();

	}

	private void createContactGroup(Composite parent) {

		Composite photoPanel = new Composite(comonComp, SWT.NONE);
		photoPanel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		photoPanel.setLayout(new GridLayout(2, false));
		photoPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		Label label = new Label(photoPanel, SWT.BORDER | SWT.WRAP | SWT.CENTER);
		label.setBackground(SWTResourceManager.getColor(255, 255, 255));
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		Composite composite = new Composite(photoPanel, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));

		Link link = new Link(photoPanel, SWT.NONE);
		link.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		link.setText("<a>update photo</a>");
		new Label(photoPanel, SWT.NONE);
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
