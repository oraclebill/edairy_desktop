package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controls.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeBindingConstants;

public class EmployeeEditDialogController extends RecordDialogController<Employee> {

	private Employee editEmployee = null;

	private IComboRidget department;
	private ITextRidget employeeId;
	private ITextRidget familyName;
	private ITextRidget givenName;
	private IComboRidget position;

	private ITextRidget operatorCode;
	private ITextRidget securityRole;

	private IProfilePhotoRidget photoRidget;

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editEmployee = getWorkingCopy();
		assert (null != editEmployee);

		photoRidget = getRidget(IProfilePhotoRidget.class, "profile-photo-widget");
		photoRidget.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__PHOTO) );
		
		
		// customer id
		employeeId = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM);
		employeeId.bindToModel(EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__ID));
		employeeId.setOutputOnly(false);
		employeeId.setFocusable(false);

		// company name
		familyName = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_FAMILY_NAME);
		familyName.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__FAMILY_NAME));
		familyName.setMandatory(true);
//		familyName.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
//		familyName.updateFromModel();

		// company legal name
		givenName = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_GIVEN_NAME);
		givenName.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__GIVEN_NAME));
		givenName.setMandatory(true);
//		givenName.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
//		givenName.updateFromModel();

		// department
		department = getRidget(IComboRidget.class, EmployeeBindingConstants.BIND_ID_DEPARTMENT);
		department.bindToModel(Observables.staticObservableList(EmployeeReference.getDepartments()), String.class,
				null, new WritableValue());
//		department.updateFromModel();
//		department.setSelection(0);

		// job function
		position = getRidget(IComboRidget.class, EmployeeBindingConstants.BIND_ID_POSITION);
		position.bindToModel(Observables.staticObservableList(EmployeeReference.getPositions()), String.class, null,
				EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION));
		position.setMandatory(true);
//		position.updateFromModel();
//		position.setSelection(0);

		// operator code
		operatorCode = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_OPR_CODE);
		operatorCode.bindToModel(EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__OPERATOR_CODE));
		operatorCode.setMandatory(true);
//		operatorCode.updateFromModel();

		// security role
		securityRole = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_SEC_ROLE);
		securityRole.bindToModel(EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__SECURITY_ROLE));
		securityRole.setOutputOnly(true);
//		securityRole.updateFromModel();


		
		// Configure address group
		final AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
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
		final CommunicationGroupController commController = new CommunicationGroupController(this);
		commController.setInputModel(editEmployee);
		commController.updateBinding();
		
		// bind all
		for (IRidget ridget : getRidgets()) {
			if (ridget instanceof IValueRidget) {
				ridget.updateFromModel();
			} else if (ridget instanceof IMarkableRidget) {
				IMarkableRidget imr = (IMarkableRidget) ridget;
				imr.updateFromModel();
			}
				
		}
	}

}
