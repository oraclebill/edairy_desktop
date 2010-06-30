package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.core.resource.IIconManager;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ILinkRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.validation.RequiredField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Employee;
import com.agritrace.edairy.desktop.common.ui.controllers.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.reference.EmployeeReference;
import com.agritrace.edairy.desktop.operations.ui.dialogs.EmployeeBindingConstants;

public class EmployeeEditDialogController extends RecordDialogController<Employee> {

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
		assert (null != editEmployee);

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
		department.bindToModel(Observables.staticObservableList(EmployeeReference.getDepartments()), String.class,
				null, new WritableValue());
		department.updateFromModel();
		department.setSelection(0);

		// job function
		position = getRidget(IComboRidget.class, EmployeeBindingConstants.BIND_ID_POSITION);
		position.bindToModel(Observables.staticObservableList(EmployeeReference.getPositions()), String.class, null,
				EMFObservables.observeValue(editEmployee, DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION));
		position.setMandatory(true);
		position.updateFromModel();
		position.setSelection(0);

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

		// action ridget
		ILinkRidget photoDialog = getRidget(ILinkRidget.class, "update-photo-action");
		photoDialog.addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				handleUpdatePhotoAction();
			}
		});
	}

	private void handleUpdatePhotoAction() {
		FileDialog fDialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.DIALOG_TRIM);
		String fName = fDialog.open();
		
		Image photo = new Image(PlatformUI.getWorkbench().getDisplay(), fName);
		ILabelRidget photoLabel = getRidget(ILabelRidget.class, "contact-photo-label");
//		try {
//			photoLabel.setText("");
//			photoLabel.setIcon(photo);
//			photoLabel.getParent().pack();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
//
//	@Override
//	protected EClass getEClass() {
//		return DairyPackage.Literals.EMPLOYEE;
//	}

	@Override
	public Employee getWorkingCopy() {
		return (Employee) getContext("editObject");
	}

	// @Override
	// protected void saveNew() throws AlreadyExistsException {
	// // prevent saving in dialog
	// }
	//
	// @Override
	// protected void saveUpdated() throws NonExistingEntityException {
	// // prevent saving in dialog
	// }

}
