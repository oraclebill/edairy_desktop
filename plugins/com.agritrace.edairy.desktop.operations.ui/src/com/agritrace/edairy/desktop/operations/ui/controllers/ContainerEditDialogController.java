package com.agritrace.edairy.desktop.operations.ui.controllers;

import org.eclipse.core.databinding.beans.PojoObservables;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.Bin;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.IAssetInfoRidget;
import com.agritrace.edairy.desktop.operations.ui.dialogs.ContainerBindingConstants;

public class ContainerEditDialogController extends RecordDialogController<Bin> {

	private Bin editContainer = null;

	public ContainerEditDialogController() {
		super("Dairy Milk Container");
	}

	@Override
	public void configureUserRidgets() {
		editContainer = getWorkingCopy();
		assert editContainer != null;
		
		addTextMap(ContainerBindingConstants.BIND_ID_CONTAINER_TRACKING_NUM,
				TrackingPackage.Literals.CONTAINER__TRACKING_NUMBER);
		addTextMap(ContainerBindingConstants.BIND_ID_CONTAINER_CAPACITY, TrackingPackage.Literals.CONTAINER__CAPACITY);
		addComboMap(ContainerBindingConstants.BIND_ID_CONTAINER_UOM, UnitOfMeasure.VALUES, "getName",
				TrackingPackage.Literals.CONTAINER__MEASURE_TYPE);
					

		final IAssetInfoRidget assetInfo = getRidget(IAssetInfoRidget.class, IAssetInfoRidget.WIDGET_ID);
		assetInfo.bindToModel(PojoObservables.observeValue(editContainer, "assetInfo"));
		getRidget(IAssetInfoRidget.class, IAssetInfoRidget.WIDGET_ID).updateFromModel();
	}
}
