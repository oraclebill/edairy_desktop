package com.agritrace.edairy.desktop.dairy.containers.ui.controllers;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDecimalTextRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.UnitOfMeasure;
import com.agritrace.edairy.desktop.common.model.dairy.DairyContainer;
import com.agritrace.edairy.desktop.common.model.tracking.TrackingPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.assetinfo.IAssetInfoRidget;
import com.agritrace.edairy.desktop.dairy.containers.ui.controls.ContainerLogDetailBindConstants;

public class ContainerEditDialogController  extends RecordDialogController<DairyContainer> {

	private DairyContainer editContainer = null;
	

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editContainer = getWorkingCopy();
		assert (null != editContainer);
		bindContainerInfo();
		bindAssetInfo();
	
	}
	
	private void bindContainerInfo() {
		final ITextRidget id = getRidget(ITextRidget.class,
				ContainerLogDetailBindConstants.BIND_ID_CONTAINER_ID);
		id.setFocusable(false);
		// id.setEnabled(false);
		id.setOutputOnly(true);
		id.bindToModel(PojoObservables.observeValue(editContainer,
				TrackingPackage.Literals.CONTAINER__CONTAINER_ID.getName()));
		id.updateFromModel();

		final ITextRidget trackingNumber = getRidget(ITextRidget.class,
				ContainerLogDetailBindConstants.BIND_ID_CONTAINER_TRACKING_NUM);
		trackingNumber.setDirectWriting(true);
		trackingNumber.bindToModel(EMFObservables.observeValue(editContainer,
				TrackingPackage.Literals.CONTAINER__TRACKING_NUMBER));
		trackingNumber.updateFromModel();

		final IDecimalTextRidget capacity = getRidget(IDecimalTextRidget.class,
				ContainerLogDetailBindConstants.BIND_ID_CONTAINER_CAPACITY);
		capacity.setDirectWriting(true);
		capacity.setMandatory(true);
		capacity.bindToModel(editContainer, TrackingPackage.Literals.CONTAINER__CAPACITY.getName());
		capacity.updateFromModel();

		final IComboRidget unitOfMeasure = getRidget(IComboRidget.class,
				ContainerLogDetailBindConstants.BIND_ID_CONTAINER_UOM);
		unitOfMeasure.bindToModel(Observables.staticObservableList(UnitOfMeasure.VALUES), UnitOfMeasure.class,
				null, EMFObservables.observeValue(editContainer, TrackingPackage.Literals.CONTAINER__MEASURE_TYPE));
		unitOfMeasure.updateFromModel();
		
	}
	
	private void bindAssetInfo() {
		IAssetInfoRidget assetInfo = getRidget(IAssetInfoRidget.class, IAssetInfoRidget.WIDGET_ID);
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
