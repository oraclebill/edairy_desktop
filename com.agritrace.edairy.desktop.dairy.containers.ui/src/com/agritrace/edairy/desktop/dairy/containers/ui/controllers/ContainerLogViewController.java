package com.agritrace.edairy.desktop.dairy.containers.ui.controllers;

import java.util.Collection;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Asset;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.tracking.Container;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.controls.AssetInfoRidget;
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
			return !new EcoreUtil.EqualityHelper().equals((EObject) source, (EObject) target);
		}

		@Override
		public void itemApplied(Object changedItem) {
			super.itemApplied(changedItem);
			if (!containers.contains(changedItem)) {
				containers.add((DairyContainer) changedItem);
			}
			// dairyRepository.save(changedItem);
			dairyRepository.save(dairyRepository.getLocalDairy());
		}

		private void bindAssetInfo(IRidgetContainer container, Asset assetInfo) {
			final AssetInfoRidget assetInfoRidget = container.getRidget(AssetInfoRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_ASSET_INFO);
			assetInfoRidget.bindToModel(PojoObservables.observeValue(getWorkingCopy(), "assetInfo"));
		}

		private void bindContainerInfo(IRidgetContainer container) {

			final ITextRidget id = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_ID);
			id.setFocusable(false);
			// id.setEnabled(false);
			id.setOutputOnly(true);
			id.bindToModel(PojoObservables.observeValue(workingCopy,
					TrackingPackage.Literals.CONTAINER__CONTAINER_ID.getName()));
			id.updateFromModel();

			final ITextRidget trackingNumber = container.getRidget(ITextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_TRACKING_NUM);
			trackingNumber.setDirectWriting(true);
			trackingNumber.bindToModel(EMFObservables.observeValue(workingCopy,
					TrackingPackage.Literals.CONTAINER__TRACKING_NUMBER));
			trackingNumber.updateFromModel();

//			final IComboRidget type = container.getRidget(IComboRidget.class,
//					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_TYPE);
//			type.bindToModel(Observables.staticObservableList(ContainerType.VALUES), ContainerType.class, null,
//					EMFObservables.observeValue(workingCopy, TrackingPackage.Literals.CONTAINER__TYPE));
//			type.updateFromModel();

			final IDecimalTextRidget capacity = container.getRidget(IDecimalTextRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_CAPACITY);
			capacity.setDirectWriting(true);
			capacity.setMandatory(true);
			capacity.bindToModel(workingCopy, TrackingPackage.Literals.CONTAINER__CAPACITY.getName());
			capacity.updateFromModel();

			final IComboRidget unitOfMeasure = container.getRidget(IComboRidget.class,
					ContainerLogDetailBindConstants.BIND_ID_CONTAINER_UOM);
			unitOfMeasure.bindToModel(Observables.staticObservableList(UnitOfMeasure.VALUES), UnitOfMeasure.class,
					null, EMFObservables.observeValue(workingCopy, TrackingPackage.Literals.CONTAINER__MEASURE_TYPE));
			unitOfMeasure.updateFromModel();

		}
	}

	public static final String ID = ContainerLogViewController.class.getName();

	private static final String[] containerColumnHeaders = { "ID", "Tracking Number", "Capacity", "Units Of Measure" };
	private static final String[] containerPropertyNames = { "containerId", "trackingNumber", "capacity", "measureType" };
	protected final IDairyRepository dairyRepository = DairyRepository.getInstance();
	private final Collection<DairyContainer> containers = dairyRepository.getLocalDairy().getDairyBins();

	@Override
	public void configureRidgets() {

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
