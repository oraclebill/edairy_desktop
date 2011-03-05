package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Role;
import com.agritrace.edairy.desktop.common.model.base.SystemUser;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.model.util.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.SystemSettingsController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapPanelController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeBindingConstants;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class EmployeeEditDialogController extends RecordDialogController<Employee> {
	private Employee editEmployee = null;

	private ITextRidget employeeNumber;
	private ITextRidget passwordRidget;
	private ITextRidget licenseNo;
	private IProfilePhotoRidget photoRidget;
	private IContactMethodsGroupRidget contacts;

	private final IPersistentPreferenceStore preferenceStore;
	private final IRepository<Role> roleRepo;

	@Inject
	public EmployeeEditDialogController(@Named("db") final IPersistentPreferenceStore store,
			final IRepository<Role> roleRepo) {
		super("Employee");
		this.preferenceStore = store;
		this.roleRepo = roleRepo;
	}

	@Override
	public void configureUserRidgets() {
		// ensure model available
		editEmployee = getWorkingCopy();
		assert null != editEmployee;

		photoRidget = getRidget(IProfilePhotoRidget.class, "profile-photo-widget");
		photoRidget.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__PHOTO));

		addTextMap(EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM, DairyPackage.Literals.EMPLOYEE__EMPLOYEE_NUMBER);

		// customer name
		employeeNumber = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM);
		employeeNumber.bindToModel(EMFObservables.observeValue(editEmployee,
				DairyPackage.Literals.EMPLOYEE__EMPLOYEE_NUMBER));
		employeeNumber.setOutputOnly(false);
		employeeNumber.setMandatory(true);

		if (this.getActionType() == AbstractDirectoryController.ACTION_VIEW) {
			employeeNumber.updateFromModel();
		}

		final List<Role> allRoles = roleRepo.all();

		addTextMap(EmployeeBindingConstants.BIND_ID_FAMILY_NAME, ModelPackage.Literals.PERSON__FAMILY_NAME);
		addTextMap(EmployeeBindingConstants.BIND_ID_GIVEN_NAME, ModelPackage.Literals.PERSON__GIVEN_NAME);
		addComboMap(EmployeeBindingConstants.BIND_ID_DEPARTMENT, EmployeeReference.getDepartments(), "toString",
				DairyPackage.Literals.EMPLOYEE__DEPARTMENT);
		addComboMap(EmployeeBindingConstants.BIND_ID_POSITION, EmployeeReference.getPositions(), "toString",
				DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION);
		addTextMap(EmployeeBindingConstants.BIND_ID_SINCE, DairyPackage.Literals.EMPLOYEE__START_DATE);
		addTextMap(EmployeeBindingConstants.BIND_ID_OPR_CODE, DairyPackage.Literals.EMPLOYEE__OPERATOR_CODE);
		addTextMap(EmployeeBindingConstants.BIND_ID_LICENSE_NO, DairyPackage.Literals.EMPLOYEE__LICENSE_NO);

		getRidget(IComboRidget.class, EmployeeBindingConstants.BIND_ID_POSITION).addSelectionListener(
				new ISelectionListener() {
					@Override
					public void ridgetSelected(SelectionEvent event) {
						updateLicenseNoRidget();
					}
				});


		licenseNo = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_LICENSE_NO);

		// Configure address group
		final AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		if (editEmployee.getLocation() == null) {
			final Location employeeLocation = DairyUtil.createLocation(null, null, null);
			editEmployee.setLocation(employeeLocation);
		}
		addressGroupController.setInputModel(editEmployee.getLocation().getPostalLocation());
		addressGroupController.updateBinding();

		// Configure Direction Group
		final DirectionGroupController directionController = new DirectionGroupController(this);
		directionController.setInputModel(editEmployee.getLocation().getDescriptiveLocation());
		directionController.updateBinding();

		// Configure Map Group
		final MapPanelController mapController = new MapPanelController(this);
		mapController.setInputModel(editEmployee.getLocation());
		mapController.updateBinding();

		// Configure Communication Group
		contacts = getRidget(IContactMethodsGroupRidget.class, IContactMethodsGroupRidget.WIDGET_ID);
		contacts.bindToModel(editEmployee);
		contacts.updateFromModel();
	}

	@Override
	protected void handleSaveAction() {
		// Password requires special care. We'll only update it if something was entered.
		final String password = passwordRidget.getText();

		if (!StringUtils.isEmpty(password)) {
			final Employee employee = getWorkingCopy();

			SystemUser systemUser = employee.getSystemIdentity();
			if (systemUser == null) {
				systemUser = ModelFactory.eINSTANCE.createSystemUser();
				employee.setSystemIdentity(systemUser);
			}
			
			if (preferenceStore.getBoolean(SystemSettingsController.ENCRYPT_PASSWORDS)) {
				systemUser.setPassword(PrincipalManager.getInstance().hashPassword(password));
				systemUser.setPasswordHashed(true);
			} else {
				systemUser.setPassword(password);
				systemUser.setPasswordHashed(false);
			}
		}

		super.handleSaveAction();
	}

	@Override
	public void afterBind() {
		super.afterBind();
		updateLicenseNoRidget();
	}

	private void updateLicenseNoRidget() {
		final Employee employee = getWorkingCopy();

		// TODO: Bad! Shouldn't be a string!
		if ("Driver".equals(employee.getJobFunction())) {
			licenseNo.setOutputOnly(false);
			licenseNo.setMandatory(true);
		} else {
			licenseNo.setOutputOnly(true);
			licenseNo.setMandatory(false);
			licenseNo.setText("");
		}
	}
}
