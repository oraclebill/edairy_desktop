package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;

import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeBindingConstants;

public class EmployeeEditDialogController extends RecordDialogController<Employee> {

	private Employee editEmployee = null;

	private ITextRidget employeeId;
	/*
	private IComboRidget department;
	private ITextRidget familyName;
	private ITextRidget givenName;
	private IComboRidget position;
	private IDateTimeRidget startDate;
	private ITextRidget operatorCode;
	private ITextRidget securityRole;
	*/

	private IProfilePhotoRidget photoRidget;

	private IContactMethodsGroupRidget contacts;

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editEmployee = getWorkingCopy();
		assert (null != editEmployee);

		photoRidget = getRidget(IProfilePhotoRidget.class, "profile-photo-widget");
		photoRidget.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__PHOTO) );

//		addTextMap(EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM, DairyPackage.Literals.EMPLOYEE__ID);
		
		// customer id
		employeeId = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_EMPLOYEE_NUM);
		employeeId.bindToModel(EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__ID));
		employeeId.setOutputOnly(false);
		employeeId.setFocusable(false);
		if (this.getActionType() == AbstractDirectoryController.ACTION_VIEW) {
			employeeId.updateFromModel();
		}

		addTextMap(EmployeeBindingConstants.BIND_ID_FAMILY_NAME, ModelPackage.Literals.PERSON__FAMILY_NAME);
		addTextMap(EmployeeBindingConstants.BIND_ID_GIVEN_NAME, ModelPackage.Literals.PERSON__GIVEN_NAME);
		addComboMap(EmployeeBindingConstants.BIND_ID_DEPARTMENT, EmployeeReference.getDepartments(), "toString", DairyPackage.Literals.EMPLOYEE__DEPARTMENT);
		addComboMap(EmployeeBindingConstants.BIND_ID_POSITION, EmployeeReference.getPositions(), "toString", DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION);
		addTextMap(EmployeeBindingConstants.BIND_ID_SINCE, DairyPackage.Literals.EMPLOYEE__START_DATE);
		addTextMap(EmployeeBindingConstants.BIND_ID_OPR_CODE, DairyPackage.Literals.EMPLOYEE__OPERATOR_CODE);
		addTextMap(EmployeeBindingConstants.BIND_ID_SEC_ROLE, DairyPackage.Literals.EMPLOYEE__SECURITY_ROLE);
		addTextMap(EmployeeBindingConstants.BIND_ID_USERNAME, DairyPackage.Literals.EMPLOYEE__USERNAME);
		addTextMap(EmployeeBindingConstants.BIND_ID_PASSWORD, DairyPackage.Literals.EMPLOYEE__PASSWORD);
		
		IToggleButtonRidget localEnabled = (IToggleButtonRidget) getRidget(EmployeeBindingConstants.BIND_ID_LOCAL_ENABLED);
		localEnabled.bindToModel(EMFObservables.observeValue(getWorkingCopy(), DairyPackage.Literals.EMPLOYEE__LOCAL_ENABLED));

		getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_SEC_ROLE).setOutputOnly(true);
		
		// Configure address group
		final AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		if(editEmployee.getLocation() == null){
			Location employeeLocation = DairyUtil.createLocation(null, null, null);
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
		//		final CommunicationGroupController commController = new CommunicationGroupController(this);
		//		commController.setInputModel(editEmployee);
		//		commController.updateBinding();

		contacts = getRidget(IContactMethodsGroupRidget.class, IContactMethodsGroupRidget.WIDGET_ID);
		contacts.bindToModel(editEmployee);
		contacts.updateFromModel();
	}
	
	@Override
	public void afterBind() {
		super.afterBind();
		
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
