package com.agritrace.edairy.desktop.common.ui.controls;

import java.util.Date;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.riena.ui.ridgets.AbstractCompositeRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;

import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;

public class AssetInfoRidget extends AbstractCompositeRidget implements IValueRidget {

	private IObservableValue modelObject;
	private IDateTimeRidget dateAcquiredText;
	private IDateTimeRidget damangeDateText;
	private ITextRidget damageDesText;
	private IDateTimeRidget disposalDate;
	private ITextRidget disposalReason;
	private ITextRidget disposalWitness;

	@Override
	public void configureRidgets() {
		
		dateAcquiredText = getRidget(IDateTimeRidget.class,
				AssetInfoComposite.BIND_ID_ASSET_DATE_ACQUIRED);
		dateAcquiredText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);

		damangeDateText = getRidget(IDateTimeRidget.class,
				AssetInfoComposite.BIND_ID_ASSET_DATE_DAMAGE);
		damangeDateText.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);

		damageDesText = getRidget(ITextRidget.class, AssetInfoComposite.BIND_ID_ASSET_DESC_DAMAGE);
		damageDesText.setDirectWriting(true);

		disposalDate = getRidget(IDateTimeRidget.class,
				AssetInfoComposite.BIND_ID_ASSET_DATE_DISPOSAL);
		disposalDate.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);

		disposalReason = getRidget(ITextRidget.class,
				AssetInfoComposite.BIND_ID_ASSET_REASON_DISPOSAL);
		disposalReason.setDirectWriting(true);

		disposalWitness = getRidget(ITextRidget.class,
				AssetInfoComposite.BIND_ID_ASSET_WITNESS_DISPOSAL);
		disposalWitness.setDirectWriting(true);

		
	}

	@Override
	public void bindToModel(IObservableValue observableValue) {

		if (modelObject == null) {
			// TODO: Log
			return;
		}

		modelObject = observableValue;
		dateAcquiredText.bindToModel(
				BeansObservables.observeDetailValue(modelObject, DairyPackage.Literals.ASSET__DATE_ACQUIRED.getName(), Date.class));
		
		disposalWitness.bindToModel(
				BeansObservables.observeDetailValue(modelObject, DairyPackage.Literals.ASSET__DISPOSAL_WITNESS.getName(), String.class));
		
		disposalReason.bindToModel(
				BeansObservables.observeDetailValue(modelObject, DairyPackage.Literals.ASSET__DISPOSAL_REASON.getName(), String.class));
		
		disposalDate.bindToModel(
				BeansObservables.observeDetailValue(modelObject, DairyPackage.Literals.ASSET__DATE_DISPOSED.getName(), Date.class));
		
		damageDesText.bindToModel(
				BeansObservables.observeDetailValue(modelObject, DairyPackage.Literals.ASSET__DAMAGE_DESCRIPTION.getName(), String.class));
		
		damangeDateText.bindToModel(
				BeansObservables.observeDetailValue(modelObject, DairyPackage.Literals.ASSET__DAMAGE_DATE.getName(), Date.class));
	}

	@Override
	public void updateFromModel() {
		disposalWitness.updateFromModel();
		disposalReason.updateFromModel();
		disposalDate.updateFromModel();
		damageDesText.updateFromModel();
		damangeDateText.updateFromModel();
		dateAcquiredText.updateFromModel();
	}
	
	@Override
	public void bindToModel(Object valueHolder, String valuePropertyName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IConverter getModelToUIControlConverter() {
		return null;
	}

	@Override
	public void setModelToUIControlConverter(IConverter converter) {
		throw new UnsupportedOperationException();
	}
	
}