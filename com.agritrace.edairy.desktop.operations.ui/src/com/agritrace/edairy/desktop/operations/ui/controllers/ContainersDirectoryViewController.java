package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.persistence.services.HibernateRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.edairy.desktop.operations.ui.dialogs.ContainerBindingConstants;
import com.agritrace.edairy.desktop.operations.ui.dialogs.ContainerEditDialog;

@PermissionRequired(Permission.VIEW_DAIRY_BINS)
public class ContainersDirectoryViewController extends BasicDirectoryController<DairyContainer> {

	private final ContainerSearchBean searchBean = new ContainerSearchBean();

	private final HibernateRepository<DairyContainer> containerRepository = new HibernateRepository<DairyContainer>() {

		@Override
		protected Class<?> getClassType() {
			return DairyContainer.class;
		}

	};
	private final IDairyRepository dairyRepository = RepositoryFactory.getDairyRepository();

	private ITextRidget trackingText;

	public ContainersDirectoryViewController() {
		super();
		setEClass(DairyPackage.Literals.DAIRY_CONTAINER);
		setRepository(containerRepository);

		addTableColumn("ID", TrackingPackage.Literals.CONTAINER__CONTAINER_ID);
		addTableColumn("Tracking Number", TrackingPackage.Literals.CONTAINER__TRACKING_NUMBER);
		addTableColumn("Capacity", TrackingPackage.Literals.CONTAINER__CAPACITY);
		addTableColumn("Units Of Measure", TrackingPackage.Literals.CONTAINER__MEASURE_TYPE);
	}

	@Override
	protected void configureFilterRidgets() {

		trackingText = getRidget(ITextRidget.class, ContainerBindingConstants.BIND_ID_CONTAINER_TRACKING_NUM);
		trackingText.bindToModel(BeansObservables.observeValue(searchBean, ContainerSearchBean.PROP_TRACKINGNUMBER));
		trackingText.updateFromModel();

	}

	/**
	 * Create new model while creating a new record
	 * 
	 * @return
	 */
	@Override
	protected DairyContainer createNewModel() {
		final DairyContainer container = DairyFactory.eINSTANCE.createDairyContainer();
		EMFUtil.populate(container);
		return container;
	}

	@Override
	protected void createEntity(DairyContainer newEntity) {
		dairyRepository.getLocalDairy().getDairyBins().add(newEntity);
		super.createEntity(newEntity);
	}

	@Override
	protected List<DairyContainer> getFilteredResult() {
		final List<DairyContainer> filtered = new ArrayList<DairyContainer>();
		final List<DairyContainer> allContainers = containerRepository.all();
		System.err.println("allContainers: " + allContainers);
		for (final DairyContainer c : allContainers) {
			final String searchedForNumber = searchBean.getTrackingNumber();
			final String currentNumber = c.getTrackingNumber();
			if (currentNumber != null) {
				if (searchedForNumber == null || searchedForNumber.isEmpty()
						|| currentNumber.startsWith(searchedForNumber)) {
					filtered.add(c);
				}
			}
		}
		System.err.println("Filtered: " + filtered);
		return filtered;
	}

	@Override
	protected RecordDialog<DairyContainer> getRecordDialog(Shell shell) {
		ContainerEditDialog dialog = new ContainerEditDialog(shell);
		dialog.setTitle("Edit Dairy Bin Information");
		return dialog;
	}

	@Override
	protected void resetFilterConditions() {
		trackingText.setText("");
	}

	@Override
	protected void deleteEntity(DairyContainer deletableEntity) {
		dairyRepository.getLocalDairy().getDairyBins().remove(deletableEntity);
		super.deleteEntity(deletableEntity);
		dairyRepository.save(dairyRepository.getLocalDairy());

	}

}
