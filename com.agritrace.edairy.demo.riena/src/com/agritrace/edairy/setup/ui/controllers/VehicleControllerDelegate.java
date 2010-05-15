package com.agritrace.edairy.setup.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Employee;
import com.agritrace.edairy.model.dairy.Vehicle;
import com.agritrace.edairy.service.ui.controllers.CommonSubModuleViewController;
import com.agritrace.edairy.service.ui.controllers.SubModuleControllerDelegate;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;
import com.agritrace.edairy.setup.ui.views.VehicleMasterDetailComposite;

/**
 * Controller delegate for Vehicle log view
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class VehicleControllerDelegate extends SubModuleControllerDelegate {

	public VehicleControllerDelegate(SubModuleController controller) {
		super(controller);

	}

	@Override
	public void configureRidgets() {

		String[] headers = new String[] { "Log Book #", "VIN #", "Type",
				"Make", "Model", "Color", "Capacity" };
		String[] properties = new String[] {
				DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER.getName(),
				DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER.getName(),
				DairyPackage.Literals.VEHICLE__TYPE.getName(),
				DairyPackage.Literals.VEHICLE__MAKE.getName(),
				DairyPackage.Literals.VEHICLE__MODEL.getName(),
				DairyPackage.Literals.VEHICLE__DOMINANT_COLOUR.getName(),
				DairyPackage.Literals.VEHICLE__CAPACITY_IN_TONNES.getName() };

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget(
				IMasterDetailsRidget.class, "master"); //$NON-NLS-1$
		List<EObject> vehicles = ((CommonSubModuleViewController) this
				.getSubModuleController()).getModleOjects();
		if (master != null) {
			master.setDelegate(new VehicleLogMasterDetailDelegate());
			master.bindToModel(new WritableList(vehicles, Vehicle.class),
					Vehicle.class, properties, headers);
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
	private final class VehicleLogMasterDetailDelegate extends
			AbstractMasterDetailsDelegate {

		private final Vehicle workingCopy = createWorkingCopy();

		@Override
		public void configureRidgets(IRidgetContainer container) {
			
			// Log Book Number
			ITextRidget firstName = container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_LOG_NUM);
			for (IRidget ridget: container.getRidgets())
			{
				if (ridget.getID() !=null)
				{
					System.out.println(ridget.getID());
				}
			}
			firstName.setDirectWriting(true);
			firstName.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER.getName());
			firstName.updateFromModel();

			// Driver Name Name
			ITextRidget lastNameText = container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_DRIVER_NAME);
			lastNameText.setDirectWriting(true);
//			lastNameText.bindToModel(workingCopy.getDriver(),
//					ModelPackage.Literals.PARTY__NAME.getName());
			lastNameText.updateFromModel();

			 // Registration Number
			ITextRidget regText = container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_REG_NUM);
			regText.setDirectWriting(true);
			regText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER
							.getName());
			regText.updateFromModel();
			//
			 // Chassis Number
			ITextRidget chasisText = container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_CHASSIS_NUM);
			chasisText.setDirectWriting(true);
			chasisText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__CHASSIS_NUMBER.getName());
			chasisText.updateFromModel();
			
			// Engine Number
			ITextRidget engineNumber = container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_ENGINE_NUM);
			engineNumber.setDirectWriting(true);
			engineNumber.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__ENGINE_NUMBER.getName());
			engineNumber.updateFromModel();
			
			// Description Group
			// Make
			ITextRidget makeText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_DESC_MAKE);
			makeText.setDirectWriting(true);
			makeText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__MAKE.getName());
			makeText.updateFromModel();
			
			// Model
			ITextRidget modelText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_DESC_MODEL);
			modelText.setDirectWriting(true);
			modelText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__MODEL.getName());
			modelText.updateFromModel();
			
			// Color
			ITextRidget colorText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_DESC_COLOR);
			colorText.setDirectWriting(true);
			colorText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__DOMINANT_COLOUR.getName());
			colorText.updateFromModel();
			
			// Year
			ITextRidget yearText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_DESC_YEAR);
			yearText.setDirectWriting(true);
			yearText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__YEAR.getName());
			yearText.updateFromModel();
			
			// Capacity
			ITextRidget capacityText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_DESC_CAPACITY);
			capacityText.setDirectWriting(true);
			capacityText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__CAPACITY_IN_TONNES.getName());
			capacityText.updateFromModel();
			
			
			// Asset Info
			// Date Acquired			
			ITextRidget dateAcquiredText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_ASSET_DATE_ACQUIRED);
			dateAcquiredText.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
			dateAcquiredText.setDirectWriting(true);
			dateAcquiredText.bindToModel(workingCopy,
					DairyPackage.Literals.ASSET__DATE_ACQUIRED.getName());
			dateAcquiredText.updateFromModel();
			
			// Date Damaged			
			ITextRidget damangeDateText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_ASSET_DATE_DAMAGE);
			damangeDateText.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
			damangeDateText.setDirectWriting(true);
			damangeDateText.bindToModel(workingCopy,
					DairyPackage.Literals.ASSET__DAMAGE_DATE.getName());
			damangeDateText.updateFromModel();
			
			// Damage Description			
			ITextRidget damageDesText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_ASSET_DESC_DAMAGE);
			damageDesText.setDirectWriting(true);
			damageDesText.bindToModel(workingCopy,
					DairyPackage.Literals.ASSET__DAMAGE_DESCRIPTION.getName());
			damageDesText.updateFromModel();
			
			
			// Disposal Date			
			ITextRidget disposalDate= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_ASSET_DATE_DISPOSAL);
			disposalDate.setDirectWriting(true);
			disposalDate.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
			disposalDate.bindToModel(workingCopy,
					DairyPackage.Literals.ASSET__DATE_DISPOSED.getName());
			disposalDate.updateFromModel();
			
			// Disposal Reason			
			ITextRidget disposalReason= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_ASSET_REASON_DISPOSAL);
			disposalReason.setDirectWriting(true);
			disposalReason.bindToModel(workingCopy,
					DairyPackage.Literals.ASSET__DISPOSAL_REASON.getName());
			disposalReason.updateFromModel();
			
			// Disposal Witness			
			ITextRidget disposalWitness= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_ASSET_WITNESS_DISPOSAL);
			disposalWitness.setDirectWriting(true);
			disposalWitness.bindToModel(workingCopy,
					DairyPackage.Literals.ASSET__DISPOSAL_WITNESS.getName());
			disposalWitness.updateFromModel();
			
			
			// Insurance Info
			// Insurance Number
			ITextRidget insuranceNumberText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_INSURANCE_NUMBER);
			insuranceNumberText.setDirectWriting(true);
			insuranceNumberText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__INSURANCE_POLICY_NUMBER.getName());
			insuranceNumberText.updateFromModel();
			
			// Expiration Date
			ITextRidget expDateText= container.getRidget(ITextRidget.class,
					VehicleMasterDetailComposite.BIND_ID_INSURANCE_EXP_DATE);
			expDateText.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
			expDateText.setDirectWriting(true);
			expDateText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__INSURANCE_EXPIRATION_DATE.getName());
			expDateText.updateFromModel();
	
			
		}

		@Override
		public Vehicle createWorkingCopy() {
			Vehicle vehicle = DairyFactory.eINSTANCE.createVehicle();
			Employee driver1 = DairyFactory.eINSTANCE.createEmployee();
			vehicle.setDriver(driver1);
			return vehicle;
		}

		@Override
		public Vehicle copyBean(final Object source, final Object target) {
			Vehicle from = source != null ? (Vehicle) source
					: createWorkingCopy();
			Vehicle to = target != null ? (Vehicle) target
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
			Vehicle p1 = (Vehicle) source;
			Vehicle p2 = (Vehicle) target;
			boolean equals = p1.getLogBookNumber().equals(p2.getLogBookNumber())
					&& p1.getRegistrationNumber().equals(p2.getRegistrationNumber())
					&& p1.getType().equals(p2.getType());
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
