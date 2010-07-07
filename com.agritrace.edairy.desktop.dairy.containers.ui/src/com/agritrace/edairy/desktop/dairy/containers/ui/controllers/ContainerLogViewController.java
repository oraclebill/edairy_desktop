package com.agritrace.edairy.desktop.dairy.containers.ui.controllers;

import java.util.Collection;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.common.model.base.ContainerType;
import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.dairy.containers.ui.controls.ContainerLogDetailBindConstants;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

/**
 * Container log view controller
 * 
 * @author Hui(Spark) Wan
 * @author Bill Jones
 * 
 */
public class ContainerLogViewController extends SubModuleController {

	/**
	 * Setup the ridgets for editing a person (text ridgets for name, single
	 * choice ridget for gender, multiple choice ridgets for pets).
	 */
	private final class ContainerLogMasterDetailDelegate extends AbstractMasterDetailsDelegate {

		private final DairyContainer workingCopy = createWorkingCopy();

		@Override
		public void configureRidgets(IRidgetContainer container) {
			bindContainerInfo(container);
			bindAssetInfo(container, workingCopy.getAssetInfo());
		}

		@Override
		public Container copyBean(final Object source, final Object target) {

			final Container from = source != null ? (Container) source : createWorkingCopy();
			final Container to = target != null ? (Container) target : createWorkingCopy();
			EMFUtil.copy(from, to, 2);
			return to;
		}

		@Override
		public DairyContainer createWorkingCopy() {
			final DairyContainer container = DairyFactory.eINSTANCE.createDairyContainer();
			EMFUtil.populate(container);
			return container;
		}

		@Override
		public DairyContainer getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			return true;
		}

		@Override
		public void itemApplied(Object changedItem) {
			super.itemApplied(changedItem);
			dairyRepository.save(changedItem);
		}

		private void bindAssetInfo(IRidgetContainer container, Asset assetInfo) {
			// Asset Info
			// Date Acquired
			final ITextRidget dateAcquiredText = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_ASSET_DATE_ACQUIRED);
			dateAcquiredText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			dateAcquiredText.setDirectWriting(true);
			dateAcquiredText.bindToModel(EMFObservables.observeValue(assetInfo,
					DairyPackage.Literals.ASSET__DATE_ACQUIRED));
			dateAcquiredText.updateFromModel();

			// Date Damaged
			final ITextRidget damangeDateText = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_ASSET_DATE_DAMAGE);
			damangeDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			damangeDateText.setDirectWriting(true);
			damangeDateText.bindToModel(EMFObservables
					.observeValue(assetInfo, DairyPackage.Literals.ASSET__DAMAGE_DATE));
			damangeDateText.updateFromModel();

			// Damage Description
			final ITextRidget damageDesText = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_ASSET_DESC_DAMAGE);
			damageDesText.setDirectWriting(true);
			damageDesText.bindToModel(EMFObservables.observeValue(assetInfo,
					DairyPackage.Literals.ASSET__DAMAGE_DESCRIPTION));
			damageDesText.updateFromModel();

			// Disposal Date
			final ITextRidget disposalDate = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_ASSET_DATE_DISPOSAL);
			disposalDate.setDirectWriting(true);
			disposalDate.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			disposalDate
					.bindToModel(EMFObservables.observeValue(assetInfo, DairyPackage.Literals.ASSET__DATE_DISPOSED));
			disposalDate.updateFromModel();

			// Disposal Reason
			final ITextRidget disposalReason = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_ASSET_REASON_DISPOSAL);
			disposalReason.setDirectWriting(true);
			disposalReason.bindToModel(EMFObservables.observeValue(assetInfo,
					DairyPackage.Literals.ASSET__DISPOSAL_REASON));
			disposalReason.updateFromModel();

			// Disposal Witness
			final ITextRidget disposalWitness = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_ASSET_WITNESS_DISPOSAL);
			disposalWitness.setDirectWriting(true);
			disposalWitness.bindToModel(EMFObservables.observeValue(assetInfo,
					DairyPackage.Literals.ASSET__DISPOSAL_WITNESS));
			disposalWitness.updateFromModel();

		}

		private void bindContainerInfo(IRidgetContainer container) {

			// Log Book Number
			final ITextRidget id = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_ID);
			id.setDirectWriting(true);
			id.bindToModel(EMFObservables.observeValue(workingCopy, TrackingPackage.Literals.CONTAINER__CONTAINER_ID));
			id.updateFromModel();

			// Driver Name Name
			final IComboRidget type = container.getRidget(IComboRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_TYPE);
			type.bindToModel(Observables.staticObservableList(ContainerType.VALUES), ContainerType.class, null,
					EMFObservables.observeValue(workingCopy, TrackingPackage.Literals.CONTAINER__TYPE));
			type.updateFromModel();

			// Insurance Info
			// Insurance Number
			final IDecimalTextRidget capacity = container.getRidget(IDecimalTextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_CAPACITY);
			capacity.setDirectWriting(true);
			// capacity.bindToModel(EMFObservables.observeValue(workingCopy,
			// TrackingPackage.Literals.CONTAINER__CAPACITY));
			capacity.bindToModel(workingCopy, TrackingPackage.Literals.CONTAINER__CAPACITY.getName());
			capacity.updateFromModel();

			// Expiration Date
			final IComboRidget unitOfMeasure = container.getRidget(IComboRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_UOM);
			unitOfMeasure.bindToModel(Observables.staticObservableList(UnitOfMeasure.VALUES), UnitOfMeasure.class,
					null, EMFObservables.observeValue(workingCopy, TrackingPackage.Literals.CONTAINER__MEASURE_TYPE));
			unitOfMeasure.updateFromModel();
		}
	}

	public static final String ID = ContainerLogViewController.class.getName();

	private final String[] containerColumnHeaders = { "ID", "Container Type", "Units Of Measure", "Capacity" };
	private final String[] containerPropertyNames = { "containerId", "type", "measureType", "capacity" };
	protected final IDairyRepository dairyRepository = DairyRepository.getInstance();

	@Override
	public void configureRidgets() {

		final Collection<DairyContainer> containers = dairyRepository.allDairyContainers();

		final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, "master"); //$NON-NLS-1$
		if (master != null) {
			master.setDelegate(new ContainerLogMasterDetailDelegate());
			master.bindToModel(new WritableList(containers, DairyContainer.class), DairyContainer.class,
					containerPropertyNames, containerColumnHeaders);
			master.updateFromModel();

			final IActionRidget actionApply = master.getRidget(IActionRidget.class,
					AbstractMasterDetailsComposite.BIND_ID_APPLY);
			this.addDefaultAction(master, actionApply);
		}

	}
}
