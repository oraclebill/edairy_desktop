package com.agritrace.edairy.desktop.dairy.vehicles.ui.controllers;

import java.util.Collection;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.dairy.vehicles.ui.controls.VehicleLogDetailBindConstants;
import com.agritrace.edairy.desktop.operations.services.vehicles.DairyVehicleRepository;
import com.agritrace.edairy.desktop.operations.services.vehicles.IVehicleRepository;

/**
 * Vehicle log view controller
 * 
 * @author Hui(Spark) Wan
 * @author Bill Jones
 * 
 */
public class VehicleLogViewController extends SubModuleController {

	/**
	 * Setup the ridgets for editing a person (text ridgets for name, single
	 * choice ridget for gender, multiple choice ridgets for pets).
	 */
	private final class VehicleLogMasterDetailDelegate extends AbstractMasterDetailsDelegate {

		private final Vehicle workingCopy = createWorkingCopy();

		@Override
		public void configureRidgets(IRidgetContainer container) {
			bindVehicleInfo(container);
			bindAssetInfo(container, workingCopy.getAssetInfo());
		}

		@Override
		public Vehicle copyBean(final Object source, final Object target) {

			final Vehicle from = source != null ? (Vehicle) source : createWorkingCopy();
			final Vehicle to = target != null ? (Vehicle) target : createWorkingCopy();
			EMFUtil.copy(from, to, 2);
			return to;
		}

		@Override
		public Vehicle createWorkingCopy() {
			final Vehicle vehicle = DairyFactory.eINSTANCE.createVehicle();
			EMFUtil.populate(vehicle);
			return vehicle;
		}

		@Override
		public Object getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			return true;
		}

		protected void bindAssetInfo(IRidgetContainer container, Asset assetInfo) {
			// Asset Info
			// Date Acquired
			final ITextRidget dateAcquiredText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_ASSET_DATE_ACQUIRED);
			dateAcquiredText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			dateAcquiredText.setDirectWriting(true);
			dateAcquiredText.bindToModel(assetInfo, DairyPackage.Literals.ASSET__DATE_ACQUIRED.getName());
			dateAcquiredText.updateFromModel();

			// Date Damaged
			final ITextRidget damangeDateText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_ASSET_DATE_DAMAGE);
			damangeDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			damangeDateText.setDirectWriting(true);
			damangeDateText.bindToModel(assetInfo, DairyPackage.Literals.ASSET__DAMAGE_DATE.getName());
			damangeDateText.updateFromModel();

			// Damage Description
			final ITextRidget damageDesText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_ASSET_DESC_DAMAGE);
			damageDesText.setDirectWriting(true);
			damageDesText.bindToModel(assetInfo, DairyPackage.Literals.ASSET__DAMAGE_DESCRIPTION.getName());
			damageDesText.updateFromModel();

			// Disposal Date
			final ITextRidget disposalDate = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_ASSET_DATE_DISPOSAL);
			disposalDate.setDirectWriting(true);
			disposalDate.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			disposalDate.bindToModel(assetInfo, DairyPackage.Literals.ASSET__DATE_DISPOSED.getName());
			disposalDate.updateFromModel();

			// Disposal Reason
			final ITextRidget disposalReason = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_ASSET_REASON_DISPOSAL);
			disposalReason.setDirectWriting(true);
			disposalReason.bindToModel(assetInfo, DairyPackage.Literals.ASSET__DISPOSAL_REASON.getName());
			disposalReason.updateFromModel();

			// Disposal Witness
			final ITextRidget disposalWitness = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_ASSET_WITNESS_DISPOSAL);
			disposalWitness.setDirectWriting(true);
			disposalWitness.bindToModel(assetInfo, DairyPackage.Literals.ASSET__DISPOSAL_WITNESS.getName());
			disposalWitness.updateFromModel();

		}

		protected void bindVehicleInfo(IRidgetContainer container) {

			// Log Book Number
			final ITextRidget logNumber = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_LOG_NUM);
			logNumber.setDirectWriting(true);
			logNumber.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER.getName());
			logNumber.updateFromModel();

			// Driver Name Name
			final ITextRidget lastNameText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_DRIVER_NAME);
			lastNameText.setDirectWriting(true);
			// lastNameText.bindToModel(workingCopy.getDriver(),
			// ModelPackage.Literals.PARTY__NAME.getName());
			lastNameText.updateFromModel();

			// Registration Number
			final ITextRidget regText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_REG_NUM);
			regText.setDirectWriting(true);
			regText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER.getName());
			regText.updateFromModel();
			//
			// Chassis Number
			final ITextRidget chasisText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_CHASSIS_NUM);
			chasisText.setDirectWriting(true);
			chasisText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__CHASSIS_NUMBER.getName());
			chasisText.updateFromModel();

			// Engine Number
			final ITextRidget engineNumber = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_ENGINE_NUM);
			engineNumber.setDirectWriting(true);
			engineNumber.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__ENGINE_NUMBER.getName());
			engineNumber.updateFromModel();

			// Description Group
			// Make
			final ITextRidget makeText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_DESC_MAKE);
			makeText.setDirectWriting(true);
			makeText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__MAKE.getName());
			makeText.updateFromModel();

			// Model
			final ITextRidget modelText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_DESC_MODEL);
			modelText.setDirectWriting(true);
			modelText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__MODEL.getName());
			modelText.updateFromModel();

			// Color
			final ITextRidget colorText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_DESC_COLOR);
			colorText.setDirectWriting(true);
			colorText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__DOMINANT_COLOUR.getName());
			colorText.updateFromModel();

			// Year
			final ITextRidget yearText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_DESC_YEAR);
			yearText.setDirectWriting(true);
			yearText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__YEAR.getName());
			yearText.updateFromModel();

			// Capacity
			final ITextRidget capacityText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_DESC_CAPACITY);
			capacityText.setDirectWriting(true);
			capacityText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__CAPACITY_IN_TONNES.getName());
			capacityText.updateFromModel();

			// Insurance Info
			// Insurance Number
			final ITextRidget insuranceNumberText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_INSURANCE_NUMBER);
			insuranceNumberText.setDirectWriting(true);
			insuranceNumberText.bindToModel(workingCopy,
					DairyPackage.Literals.VEHICLE__INSURANCE_POLICY_NUMBER.getName());
			insuranceNumberText.updateFromModel();

			// Expiration Date
			final ITextRidget expDateText = container.getRidget(ITextRidget.class,
					VehicleLogDetailBindConstants.BIND_ID_INSURANCE_EXP_DATE);
			expDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			expDateText.setDirectWriting(true);
			expDateText.bindToModel(workingCopy, DairyPackage.Literals.VEHICLE__INSURANCE_EXPIRATION_DATE.getName());
			expDateText.updateFromModel();
		}
	}

	public static final String ID = VehicleLogViewController.class.getName();

	protected final IVehicleRepository vehicleRepository;

	public VehicleLogViewController() {
		super();
		vehicleRepository = new DairyVehicleRepository();
	}

	@Override
	public void configureRidgets() {

		final String[] headers = new String[] { "Log Book #", "VIN #", "Type", "Make", "Model", "Color", "Capacity" };
		final String[] properties = new String[] { DairyPackage.Literals.VEHICLE__LOG_BOOK_NUMBER.getName(),
				DairyPackage.Literals.VEHICLE__REGISTRATION_NUMBER.getName(),
				DairyPackage.Literals.VEHICLE__TYPE.getName(), DairyPackage.Literals.VEHICLE__MAKE.getName(),
				DairyPackage.Literals.VEHICLE__MODEL.getName(),
				DairyPackage.Literals.VEHICLE__DOMINANT_COLOUR.getName(),
				DairyPackage.Literals.VEHICLE__CAPACITY_IN_TONNES.getName() };

		final Collection<Vehicle> vehicles = vehicleRepository.all();

		final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, "master"); //$NON-NLS-1$
		if (master != null) {
			master.setDelegate(new VehicleLogMasterDetailDelegate());
			master.bindToModel(new WritableList(vehicles, Vehicle.class), Vehicle.class, properties, headers);
			master.updateFromModel();

			final IActionRidget actionApply = master.getRidget(IActionRidget.class,
					AbstractMasterDetailsComposite.BIND_ID_APPLY);
			this.addDefaultAction(master, actionApply);
		}

	}
}
