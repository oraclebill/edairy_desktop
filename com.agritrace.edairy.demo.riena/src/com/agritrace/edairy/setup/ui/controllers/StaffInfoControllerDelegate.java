package com.agritrace.edairy.setup.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.service.ui.controllers.CommonSubModuleViewController;
import com.agritrace.edairy.service.ui.controllers.SubModuleControllerDelegate;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;
import com.agritrace.edairy.setup.ui.views.StaffInfoMasterDetailComposite;

/**
 * Controller delegate for Staff info view
 * 
 * @author Hui(Spark) Wan
 *
 */
public class StaffInfoControllerDelegate extends SubModuleControllerDelegate {

	public StaffInfoControllerDelegate(SubModuleController controller) {
		super(controller);

	}

	@Override
	public void configureRidgets() {

		String[] headers = new String[] { "ID", "First Name", "Last Name",
				"Department" };
		String[] properties = new String[] {
				DairyPackage.Literals.EMPLOYEE__ID.getName(),
				ModelPackage.Literals.PERSON__GIVEN_NAME.getName(),
				ModelPackage.Literals.PERSON__FAMILY_NAME.getName(),
				DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION.getName() };

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget(
				IMasterDetailsRidget.class, "master"); //$NON-NLS-1$
		List<EObject> employees = ((CommonSubModuleViewController) this
				.getSubModuleController()).getModleOjects();
		if (master != null) {
			master.setDelegate(new StaffDelegation());
			master.bindToModel(new WritableList(employees, Employee.class),
					Employee.class, properties, headers);
			master.updateFromModel();

			IActionRidget actionApply = master.getRidget(IActionRidget.class,
					AbstractMasterDetailsComposite.BIND_ID_APPLY);
			this.getSubModuleController().addDefaultAction(master, actionApply);
		}

	}

	@Override
	public void fireListener(int eventType) {

	}

	/**
	 * Setup the ridgets for editing a person (text ridgets for name, single
	 * choice ridget for gender, multiple choice ridgets for pets).
	 */
	private final class StaffDelegation extends AbstractMasterDetailsDelegate {

		private final Employee workingCopy = createWorkingCopy();

		@Override
		public void configureRidgets(IRidgetContainer container) {

		}

		@Override
		public Employee createWorkingCopy() {
			return DairyFactory.eINSTANCE.createEmployee(); 
		}

		@Override
		public Employee copyBean(final Object source, final Object target) {
			Employee from = source != null ? (Employee) source
					: createWorkingCopy();
			Employee to = target != null ? (Employee) target
					: createWorkingCopy();
			ServiceUtils.copy(from, to);
			EcoreUtil.Copier copier = new EcoreUtil.Copier();
			Employee cloned = (Employee) copier.copy(from);
			copier.copyReferences();
			to.setLocation(cloned.getLocation());
			return to;
		}

		@Override
		public Object getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			Employee p1 = (Employee) source;
			Employee p2 = (Employee) target;
			boolean equals = p1.getGivenName().equals(p2.getGivenName())
					&& p1.getFamilyName().equals(p2.getFamilyName())
					&& p1.getId().equals(p2.getId())
					&& p1.getJobFunction().equals(p2.getJobFunction());
			return !equals;
		}

		@Override
		public String isValid(IRidgetContainer container) {
			ITextRidget txtLast = (ITextRidget) container.getRidget("last"); //$NON-NLS-1$
			if (txtLast.isErrorMarked()) {
				return "'Last Name' is not valid."; //$NON-NLS-1$
			}
			return null;
		}

		@Override
		public void itemSelected(Object newSelection) {

			super.itemSelected(newSelection);
			if (newSelection instanceof Employee) {
				Employee employee = (Employee) newSelection;
				// Updates the bindings
				updateDetailBindings(employee);
			}

		}

	}

	private void updateDetailBindings(Employee employee) {

		// First name
		ITextRidget firstName = getRidget(ITextRidget.class,
				StaffInfoMasterDetailComposite.BIND_ID_FIRST_NAME);

		// Last Name
		ITextRidget lastNameText = getRidget(ITextRidget.class,
				StaffInfoMasterDetailComposite.BIND_ID_LAST_NAME);

		// Phone Number
		ITextRidget phoneNoText = getRidget(ITextRidget.class,
				StaffInfoMasterDetailComposite.BIND_ID_PHONE_NUM);

		// Department
		ITextRidget departText = getRidget(ITextRidget.class,
				StaffInfoMasterDetailComposite.BIND_ID_DEPARTMENT);

		// Address
		ITextRidget addressText = getRidget(ITextRidget.class,
				StaffInfoMasterDetailComposite.BIND_ID_DEPARTMENT);

		if (employee == null) {
			firstName.setText("");
			lastNameText.setText("");
			phoneNoText.setText("");
			departText.setText("");
			addressText.setText("");
			return;
		} else {
			firstName.setDirectWriting(true);
			firstName.bindToModel(EMFObservables.observeValue(employee,
					ModelPackage.Literals.PERSON__GIVEN_NAME));
			firstName.updateFromModel();
			
			lastNameText.setDirectWriting(true);
			lastNameText.bindToModel(EMFObservables.observeValue(employee,
					ModelPackage.Literals.PERSON__FAMILY_NAME));
			lastNameText.updateFromModel();
			
			phoneNoText.setDirectWriting(true);
			phoneNoText.bindToModel(EMFObservables.observeValue(employee,
					ModelPackage.Literals.PARTY__PHONE_NUMBER));
			phoneNoText.updateFromModel();
			
			departText.setDirectWriting(true);
			departText.bindToModel(EMFObservables.observeValue(employee,
					DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION));
			departText.updateFromModel();
			
			addressText.setDirectWriting(true);
			if (employee.getLocation() != null
					&& employee.getLocation().getPostalLocation() != null) {
				addressText.bindToModel(EMFObservables.observeValue(employee
						.getLocation().getPostalLocation(),
						ModelPackage.Literals.POSTAL_LOCATION__ADDRESS));
				addressText.updateFromModel();
			}
		}

	}
}
