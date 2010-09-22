package com.agritrace.edairy.desktop.operations.ui.dialogs;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.ContactMethodsGroup;
import com.agritrace.edairy.desktop.common.ui.controls.location.LocationTabFolder;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.ProfilePhotoComposite;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.operations.ui.controllers.EmployeeEditDialogController;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Employee list dialog to add/view/edit customer
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class EmployeeEditDialog extends RecordDialog<Employee> {
	@Inject
	public EmployeeEditDialog(@Named("current") final Shell shell, final EmployeeEditDialogController controller) {
		super(shell, controller);
	}

	@Override
	protected void buildWorkArea(Composite parent) {

		Composite comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));		
		comonComp.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).create());
		comonComp.setLayout(new GridLayout(2, false));
		
		createEmployeeInfoPanel(comonComp).setLayoutData(GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).grab(true, false).create());

		createPhotoPanel(comonComp).setLayoutData(GridDataFactory.fillDefaults().create());

		createContactGroup(comonComp).setLayoutData(GridDataFactory.fillDefaults().grab(true,true).span(2,1).create());
	}

	protected Composite createPhotoPanel(Composite parent) {
		final ProfilePhotoComposite photoWidget = new ProfilePhotoComposite(parent, SWT.NONE);
//		photoWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		addUIControl(photoWidget, "profile-photo-widget");
		return photoWidget;		
	}

	protected Composite createEmployeeInfoPanel(final Composite comonComp) {
		final Composite employeeInfo = UIControlsFactory.createComposite(comonComp);
//		employeeInfo.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.TOP).grab(true, false).create());
		employeeInfo.setLayout(GridLayoutFactory.swtDefaults().margins(5, 5).numColumns(2).create());

		final GridDataFactory factory = GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true);
		
		UIControlsFactory.createLabel(employeeInfo, "Employee No.");
		final Text txtId = UIControlsFactory.createText(employeeInfo);
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.applyTo(txtId);
		addUIControl(txtId, EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM);

		UIControlsFactory.createLabel(employeeInfo, "Family Name");
		final Text familyName = UIControlsFactory.createText(employeeInfo);
		familyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(familyName);
		addUIControl(familyName, EmployeeBindingConstants.BIND_ID_FAMILY_NAME);

		UIControlsFactory.createLabel(employeeInfo, "Given Name");
		final Text givenName = UIControlsFactory.createText(employeeInfo);
		givenName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(givenName);
		addUIControl(givenName, EmployeeBindingConstants.BIND_ID_GIVEN_NAME);

		UIControlsFactory.createLabel(employeeInfo, "Department");
		final CCombo deptCCombo = UIControlsFactory.createCCombo(employeeInfo);
		deptCCombo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
		GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(deptCCombo);
		addUIControl(deptCCombo, EmployeeBindingConstants.BIND_ID_DEPARTMENT);

		UIControlsFactory.createLabel(employeeInfo, "Position");
		final CCombo positionCCombo = UIControlsFactory.createCCombo(employeeInfo);
		positionCCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(positionCCombo);
		addUIControl(positionCCombo, EmployeeBindingConstants.BIND_ID_POSITION);

		UIControlsFactory.createLabel(employeeInfo, "Operator Code");
		final Text operatorCode = UIControlsFactory.createText(employeeInfo);
		operatorCode.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(operatorCode);
		addUIControl(operatorCode, EmployeeBindingConstants.BIND_ID_OPR_CODE);
		
		UIControlsFactory.createLabel(employeeInfo, "Start Date");
		final DateTime startDate = UIControlsFactory.createDate(employeeInfo, SWT.MEDIUM|SWT.BORDER);
		startDate.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(startDate);
		addUIControl(startDate, EmployeeBindingConstants.BIND_ID_SINCE);
		
		UIControlsFactory.createLabel(employeeInfo, "Security Role");
		final CCombo securityRole = UIControlsFactory.createCCombo(employeeInfo);
		securityRole.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(securityRole);
		addUIControl(securityRole, EmployeeBindingConstants.BIND_ID_SEC_ROLE);

		UIControlsFactory.createLabel(employeeInfo, "User Name");
		final Text username = UIControlsFactory.createText(employeeInfo);
		familyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(username);
		addUIControl(username, EmployeeBindingConstants.BIND_ID_USERNAME);

		UIControlsFactory.createLabel(employeeInfo, "Password");
		final Text password = UIControlsFactory.createText(employeeInfo, SWT.SINGLE | SWT.PASSWORD);
		familyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		factory.copy().applyTo(password);
		addUIControl(password, EmployeeBindingConstants.BIND_ID_PASSWORD);

		final Button localEnabled = UIControlsFactory.createButtonCheck(employeeInfo);
		localEnabled.setText("Allow local machine authentication");
		familyName.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
		factory.copy().applyTo(localEnabled);
		addUIControl(localEnabled, EmployeeBindingConstants.BIND_ID_LOCAL_ENABLED);
		
		return employeeInfo;
	}

	private Composite createContactGroup(Composite parent) {
		
		final Group contactGroup = UIControlsFactory.createGroup(parent, "Company Contact");
//		contactGroup.setLayoutData(GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).create());
		contactGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

		final LocationTabFolder locationGroup = new LocationTabFolder(contactGroup, SWT.None);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(locationGroup);

		final CTabItem commsTab = new CTabItem(locationGroup.getTabFolder(), SWT.NONE);
		commsTab.setText("Contact Info");
		final ContactMethodsGroup commGroup = new ContactMethodsGroup(locationGroup.getTabFolder());
		SWTBindingPropertyLocator.getInstance().setBindingProperty(commGroup, "contact-methods");		
		commsTab.setControl(commGroup);
		return contactGroup;

	}
}
