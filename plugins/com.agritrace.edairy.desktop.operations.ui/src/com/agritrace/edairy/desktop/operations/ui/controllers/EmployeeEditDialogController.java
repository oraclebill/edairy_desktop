package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.model.dairy.Role;
import com.agritrace.edairy.desktop.common.model.dairy.security.PrincipalManager;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.SystemSettingsController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeBindingConstants;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class EmployeeEditDialogController extends RecordDialogController<Employee> {
	private Employee editEmployee = null;

	private ITextRidget employeeId;
	private ITextRidget passwordRidget;
	private IProfilePhotoRidget photoRidget;
	private IContactMethodsGroupRidget contacts;

	private final IPersistentPreferenceStore preferenceStore;
	private final IRepository<Role> roleRepo;

	@Inject
	public EmployeeEditDialogController(@Named("db") final IPersistentPreferenceStore store,
			final IRepository<Role> roleRepo) {
		this.preferenceStore = store;
		this.roleRepo = roleRepo;
	}

	@Override
	public void configureUserRidgets() {
		// ensure model available
		editEmployee = getWorkingCopy();
		assert null != editEmployee;

		photoRidget = getRidget(IProfilePhotoRidget.class, "profile-photo-widget");
		photoRidget.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__PHOTO) );

//		addTextMap(EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM, DairyPackage.Literals.EMPLOYEE__ID);

		// customer id
		employeeId = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM);
		employeeId.bindToModel(EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__ID));
		employeeId.setOutputOnly(false);
		employeeId.setMandatory(true);

		if (this.getActionType() == AbstractDirectoryController.ACTION_VIEW) {
			employeeId.updateFromModel();
		}

		final List<Role> allRoles = roleRepo.all();

		addTextMap(EmployeeBindingConstants.BIND_ID_FAMILY_NAME, ModelPackage.Literals.PERSON__FAMILY_NAME);
		addTextMap(EmployeeBindingConstants.BIND_ID_GIVEN_NAME, ModelPackage.Literals.PERSON__GIVEN_NAME);
		addComboMap(EmployeeBindingConstants.BIND_ID_DEPARTMENT, EmployeeReference.getDepartments(), "toString", DairyPackage.Literals.EMPLOYEE__DEPARTMENT);
		addComboMap(EmployeeBindingConstants.BIND_ID_POSITION, EmployeeReference.getPositions(), "toString", DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION);
		addTextMap(EmployeeBindingConstants.BIND_ID_SINCE, DairyPackage.Literals.EMPLOYEE__START_DATE);
		addTextMap(EmployeeBindingConstants.BIND_ID_OPR_CODE, DairyPackage.Literals.EMPLOYEE__OPERATOR_CODE);
		addTextMap(EmployeeBindingConstants.BIND_ID_USERNAME, DairyPackage.Literals.EMPLOYEE__USERNAME);

		// Role needs special care
		final IComboRidget roleRidget = getRidget(IComboRidget.class, EmployeeBindingConstants.BIND_ID_SEC_ROLE);
		roleRidget.bindToModel(new WritableList(allRoles, Role.class), Role.class, "getName",
				EMFObservables.observeValue(getWorkingCopy(), DairyPackage.Literals.EMPLOYEE__ROLE));

		// We pointedly do not display the current password.
		passwordRidget = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_PASSWORD);

		final IToggleButtonRidget localEnabled = (IToggleButtonRidget) getRidget(EmployeeBindingConstants.BIND_ID_LOCAL_ENABLED);
		localEnabled.bindToModel(EMFObservables.observeValue(getWorkingCopy(), DairyPackage.Literals.EMPLOYEE__LOCAL_ENABLED));

		// Configure address group
		final AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		if(editEmployee.getLocation() == null){
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
		final MapGroupController mapController = new MapGroupController(this);
		mapController.setInputModel(editEmployee.getLocation().getMapLocation());
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

			if (preferenceStore.getBoolean(SystemSettingsController.ENCRYPT_PASSWORDS)) {
				employee.setPassword(PrincipalManager.getInstance().hashPassword(password));
				employee.setPasswordHashed(true);
			} else {
				employee.setPassword(password);
				employee.setPasswordHashed(false);
			}
		}

		super.handleSaveAction();
	}

	@Override
	public void afterBind() {
		super.afterBind();

		// bind all
		for (final IRidget ridget : getRidgets()) {
			if (ridget instanceof IValueRidget) {
				ridget.updateFromModel();
			} else if (ridget instanceof IMarkableRidget) {
				final IMarkableRidget imr = (IMarkableRidget) ridget;
				imr.updateFromModel();
			}

		}
	}

}
