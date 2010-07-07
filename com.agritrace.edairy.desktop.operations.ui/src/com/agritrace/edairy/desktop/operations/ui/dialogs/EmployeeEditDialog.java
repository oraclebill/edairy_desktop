package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AddressGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.CommunicationsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.DirectionsGroupWidget;
import com.agritrace.edairy.desktop.common.ui.views.MapGroupWidget;
import com.agritrace.edairy.desktop.operations.ui.controllers.EmployeeEditDialogController;
import com.swtdesigner.SWTResourceManager;

/**
 * Employee list dialog to add/view/edit customer
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class EmployeeEditDialog extends RecordDialog<Employee, EmployeeEditDialogController> {
	private Composite comonComp;

	// private static int WIDTH_HEIGHT = 400;
	// private static int DESC_HEIGHT_HEIGHT = 50;

	public EmployeeEditDialog(Shell shell) {
		super(shell);
	}

	private void createContactGroup(Composite parent) {

		final Composite photoPanel = new Composite(comonComp, SWT.NONE);
		photoPanel.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		photoPanel.setLayout(new GridLayout(1, false));
		photoPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));

		final Label label = new Label(photoPanel, SWT.BORDER | SWT.WRAP | SWT.CENTER);
		label.setBackground(SWTResourceManager.getColor(255, 255, 255));
		label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final Label composite = UIControlsFactory.createLabel(photoPanel, "", "contact-photo-label");
		composite.setBackground(SWTResourceManager.getColor(255, 255, 255));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 2));

		final Link link = UIControlsFactory.createLink(photoPanel, SWT.NONE, "update-photo-action");
		link.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		link.setText("<a>update photo</a>");

		// UIControlsFactory.createLabel(photoPanel, );
		final Group ContactGroup = UIControlsFactory.createGroup(parent, "Company Contact");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(ContactGroup);
		GridLayoutFactory.swtDefaults().numColumns(2).applyTo(ContactGroup);
		final AddressGroupWidget addressWidget = new AddressGroupWidget(ContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1)
				.applyTo(addressWidget.getGroup());
		addressWidget.getGroup().pack();

		final DirectionsGroupWidget directionWidget = new DirectionsGroupWidget(ContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(directionWidget.getGroup());
		directionWidget.getGroup().pack();

		final MapGroupWidget mapWidget = new MapGroupWidget(ContactGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(mapWidget.getGroup());
		mapWidget.getGroup().pack();

		final CommunicationsGroupWidget commGroup = new CommunicationsGroupWidget(ContactGroup);
		// GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).applyTo(
		// commGroup.getGroup());
		// commGroup.getGroup().pack();
		//
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).span(2, 1).applyTo(commGroup.getGroup());
		commGroup.getGroup().pack();
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		comonComp.setLayout(new GridLayout(2, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(comonComp);

		final GridDataFactory factory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true);

		final Composite composite = new Composite(comonComp, SWT.NONE);
		composite.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));

		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		composite.setLayout(new GridLayout(2, false));

		UIControlsFactory.createLabel(composite, "Employee ID");

		final Text txtId = UIControlsFactory.createText(composite);
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.applyTo(txtId);
		addUIControl(txtId, EmployeeBindingConstants.BIND_ID_EMPLOYEE_ID);

		UIControlsFactory.createLabel(composite, "Family Name");
		final Text familyName = UIControlsFactory.createText(composite);
		familyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(familyName);
		addUIControl(familyName, EmployeeBindingConstants.BIND_ID_FAMILY_NAME);

		UIControlsFactory.createLabel(composite, "Given Name");
		final Text givenName = UIControlsFactory.createText(composite);
		givenName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(givenName);
		addUIControl(givenName, EmployeeBindingConstants.BIND_ID_GIVEN_NAME);

		UIControlsFactory.createLabel(composite, "Department");
		final CCombo deptCCombo = UIControlsFactory.createCCombo(composite);
		deptCCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(deptCCombo);
		addUIControl(deptCCombo, EmployeeBindingConstants.BIND_ID_DEPARTMENT);

		UIControlsFactory.createLabel(composite, "Position");
		final CCombo positionCCombo = UIControlsFactory.createCCombo(composite);
		positionCCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(positionCCombo);
		addUIControl(positionCCombo, EmployeeBindingConstants.BIND_ID_POSITION);

		createContactGroup(comonComp);
		new Label(comonComp, SWT.NONE);
		parent.pack();

	}

	@Override
	protected EmployeeEditDialogController createController() {
		final EmployeeEditDialogController controller = new EmployeeEditDialogController();
		// controller.setWorkingCopy( null );
		return controller;
	}
}
