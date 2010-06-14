package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.validation.RequiredField;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controllers.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeBindingConstants;

public class EmployeeEditDialogController2 extends RecordDialogController<Employee> {

	private Employee editEmployee = null;

	ITextRidget employeeId;
	IComboRidget department;
	ITextRidget familyName;
	ITextRidget givenName;
	IComboRidget position;


	@Override
	public void configureUserRidgets() {
		
		// ensure model available
		editEmployee = getWorkingCopy();
		assert(null != editEmployee);

		// customer id
		employeeId = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_EMPLOYEE_ID);
		employeeId.bindToModel(EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__ID));
		employeeId.setOutputOnly(true);
		
		// company name
		familyName = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_FAMILY_NAME);
		familyName.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__FAMILY_NAME));
		familyName.setMandatory(true);
		familyName.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		familyName.updateFromModel();
		
		// company legal name
		givenName = getRidget(ITextRidget.class, EmployeeBindingConstants.BIND_ID_GIVEN_NAME);
		givenName.bindToModel(EMFObservables.observeValue(editEmployee, ModelPackage.Literals.PERSON__GIVEN_NAME));
		givenName.setMandatory(true);
		givenName.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		givenName.updateFromModel();
		
		// department
		department = getRidget(IComboRidget.class, EmployeeBindingConstants.BIND_ID_DEPARTMENT);
//		department.bindToModel(
//				Observables.staticObservableList(CompanyStatus.getEmployeeStatusList()), 
//				CompanyStatus.class, 
//				null, 
//				EMFObservables.observeValue(editEmployee, DairyPackage.Literals.CUSTOMER__STATUS));
//		department.updateFromModel();
//		department.setSelection(0);
		
		// customer type
		position = getRidget(IComboRidget.class, EmployeeBindingConstants.BIND_ID_POSITION);
//		position.bindToModel(
//				Observables.staticObservableList(EmployeeType.getEmployeeTypeList()), 
//				EmployeeType.class, 
//				null, 
//				EMFObservables.observeValue(editEmployee, DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE));
//		position.updateFromModel();
//		position.setSelection(0);

		
		// Configure address group
		AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		addressGroupController.setInputModel(editEmployee.getLocation().getPostalLocation());
		addressGroupController.updateBinding();

		
		// Configure Direction Group
		DirectionGroupController directionController = new DirectionGroupController(this);
		directionController.setInputModel(editEmployee.getLocation().getDescriptiveLocation());
		directionController.updateBinding();

		
		// Configure Map Group
		MapGroupController mapController = new MapGroupController(this);
		mapController.setInputModel(editEmployee.getLocation().getMapLocation());
		mapController.updateBinding();

		
		// Configure Communication Group
		CommunicationGroupController commController = new CommunicationGroupController(this);
		commController.setInputModel(editEmployee);
		commController.updateBinding();		
	}

	
	@Override
	protected EClass getEClass() {
		return DairyPackage.Literals.EMPLOYEE;
	}

	@Override
	public Employee getWorkingCopy() {
		return (Employee) getContext("editObject");
	}

//	@Override
//	protected void saveNew() throws AlreadyExistsException {
//		// prevent saving in dialog
//	}
//
//	@Override
//	protected void saveUpdated() throws NonExistingEntityException {
//		// prevent saving in dialog
//	}

}
