package com.agritrace.edairy.setup.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.impl.ModelFactoryImpl;
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
			// First name
			ITextRidget firstName = container.getRidget(ITextRidget.class,
					StaffInfoMasterDetailComposite.BIND_ID_FIRST_NAME);
			firstName.setDirectWriting(true);
			firstName.bindToModel(workingCopy,
					ModelPackage.Literals.PERSON__GIVEN_NAME.getName());
			firstName.updateFromModel();

			// Last Name
			ITextRidget lastNameText = container.getRidget(ITextRidget.class,
					StaffInfoMasterDetailComposite.BIND_ID_LAST_NAME);
			lastNameText.setDirectWriting(true);
			lastNameText.bindToModel(workingCopy,
					ModelPackage.Literals.PERSON__FAMILY_NAME.getName());
			lastNameText.updateFromModel();

			// Phone Number
			ITextRidget phoneNoText = container.getRidget(ITextRidget.class,
					StaffInfoMasterDetailComposite.BIND_ID_PHONE_NUM);
			phoneNoText.setDirectWriting(true);
			phoneNoText.bindToModel(workingCopy,
					ModelPackage.Literals.PARTY__PHONE_NUMBER.getName());
			phoneNoText.updateFromModel();

			// Department
			ITextRidget departText = container.getRidget(ITextRidget.class,
					StaffInfoMasterDetailComposite.BIND_ID_DEPARTMENT);
			departText.setDirectWriting(true);
			departText.bindToModel(workingCopy,
					DairyPackage.Literals.EMPLOYEE__JOB_FUNCTION.getName());
			departText.updateFromModel();

			// Address
			ITextRidget addressText = container.getRidget(ITextRidget.class,
					StaffInfoMasterDetailComposite.BIND_ID_DEPARTMENT);
			addressText.setDirectWriting(true);
			if (workingCopy.getLocation() != null
					&& workingCopy.getLocation().getPostalLocation() != null) {
				addressText.bindToModel(workingCopy.getLocation()
						.getPostalLocation(),
						ModelPackage.Literals.POSTAL_LOCATION__ADDRESS
								.getName());

				addressText.updateFromModel();
			}
		}

		@Override
		public Employee createWorkingCopy() {
			Employee employee = DairyFactory.eINSTANCE.createEmployee();
			Location location = ModelFactoryImpl.eINSTANCE.createLocation();
			employee.setLocation(location);
			PostalLocation postalLocation = ModelFactory.eINSTANCE
					.createPostalLocation();
			location.setPostalLocation(postalLocation);
			return DairyFactory.eINSTANCE.createEmployee();
		}

		@Override
		public Employee copyBean(final Object source, final Object target) {
			Employee from = source != null ? (Employee) source
					: createWorkingCopy();
			Employee to = target != null ? (Employee) target
					: createWorkingCopy();
			ServiceUtils.copy(from, to);
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

	}

}
