package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.persistence.IRepository;
import com.agritrace.edairy.desktop.common.persistence.dao.IDairyRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.ui.dialogs.ContainerBindingConstants;
import com.agritrace.edairy.desktop.operations.ui.dialogs.ContainerEditDialog;
import com.google.inject.Inject;

@PermissionRequired(UIPermission.VIEW_DAIRY_BINS)
public class ContainersDirectoryViewController extends BasicDirectoryController<Bin> {

	private final ContainerSearchBean searchBean = new ContainerSearchBean();
	private final IRepository<Bin> containerRepository;
	private final IDairyRepository dairyRepository;

	private ITextRidget trackingText;

	@Inject
	public ContainersDirectoryViewController(final IDairyRepository dairyRepo, final IRepository<Bin> repo) {
		setEClass(DairyPackage.Literals.BIN);
		dairyRepository = dairyRepo;
		containerRepository = repo;
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
	protected Bin createNewModel() {
		final Bin container = DairyFactory.eINSTANCE.createBin();
		EMFUtil.populate(container);
		return container;
	}

	@Override
	protected void createEntity(Bin newEntity) {
		dairyRepository.getLocalDairy().getDairyBins().add(newEntity);
		super.createEntity(newEntity);
	}

	@Override
	protected List<Bin> getFilteredResult() {
		final List<Bin> filtered = new ArrayList<Bin>();
		final List<Bin> allContainers = containerRepository.all();
		System.err.println("allContainers: " + allContainers);
		for (final Bin c : allContainers) {
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
	protected RecordDialog<Bin> getRecordDialog(Shell shell) {
		final ContainerEditDialog dialog = new ContainerEditDialog(shell);
		dialog.setTitle("Edit Dairy Bin Information");
		return dialog;
	}

	@Override
	protected void resetFilterConditions() {
		trackingText.setText("");
	}

	@Override
	protected void deleteEntity(Bin deletableEntity) {
		dairyRepository.getLocalDairy().getDairyBins().remove(deletableEntity);
		super.deleteEntity(deletableEntity);
		dairyRepository.save(dairyRepository.getLocalDairy());

	}

}
