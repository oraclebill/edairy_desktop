package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.IAssetInfoRidget;
import com.agritrace.edairy.desktop.operations.ui.dialogs.ContainerBindingConstants;

public class ContainerEditDialogController extends RecordDialogController<DairyContainer> {

	private DairyContainer editContainer = null;

	public ContainerEditDialogController() {
		super("Dairy Milk Container");
	}
	

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editContainer = getWorkingCopy();
		assert null != editContainer;
		bindContainerInfo();
		bindAssetInfo();
	}

	private void bindContainerInfo() {
		final ITextRidget id = getRidget(ITextRidget.class,
				ContainerBindingConstants.BIND_ID_CONTAINER_ID);
		id.setFocusable(false);
		// id.setEnabled(false);
		id.setOutputOnly(true);
		id.bindToModel(PojoObservables.observeValue(editContainer,
				TrackingPackage.Literals.CONTAINER__CONTAINER_ID.getName()));
		id.updateFromModel();

		addTextMap(ContainerBindingConstants.BIND_ID_CONTAINER_TRACKING_NUM, TrackingPackage.Literals.CONTAINER__TRACKING_NUMBER);
		addTextMap(ContainerBindingConstants.BIND_ID_CONTAINER_CAPACITY, TrackingPackage.Literals.CONTAINER__CAPACITY);
		addComboMap(ContainerBindingConstants.BIND_ID_CONTAINER_UOM, UnitOfMeasure.VALUES, "getName", TrackingPackage.Literals.CONTAINER__MEASURE_TYPE);
	}

	private void bindAssetInfo() {
		final IAssetInfoRidget assetInfo = getRidget(IAssetInfoRidget.class, IAssetInfoRidget.WIDGET_ID);
		assetInfo.bindToModel(PojoObservables.observeValue(editContainer, "assetInfo"));
		assetInfo.updateFromModel();
	}




	@Override
	public DairyContainer getWorkingCopy() {
		return (DairyContainer) getContext("editObject");
	}

	@Override
	public void afterBind() {
		super.afterBind();
	}
}
