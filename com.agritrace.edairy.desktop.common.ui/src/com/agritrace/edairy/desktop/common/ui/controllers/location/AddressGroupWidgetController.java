package com.agritrace.edairy.desktop.common.ui.controllers.location;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.location.ViewWidgetId;

public class AddressGroupWidgetController implements WidgetController<PostalLocation>, ISelectionListener {

	private ITextRidget addressTxt;
	private IRidgetContainer container;

	private ITextRidget districtTxt;
	private ITextRidget divisionTxt;
	private ITextRidget estateTxt;
	private ITextRidget locationTxt;
	private ITextRidget postalCodeTxt;
	private IComboRidget provinceComo;
	private ITextRidget sectionTxt;
	private ITextRidget subLocationTxt;
	private ITextRidget villageTxt;
	
//	private PostalLocation location;
	private IObservableValue location;

	public AddressGroupWidgetController(IRidgetContainer controller) {
		this.container = controller;
		configure();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}
		addressTxt = container.getRidget(ITextRidget.class, ViewWidgetId.ADDRESS_TXT);
		sectionTxt = container.getRidget(ITextRidget.class, ViewWidgetId.SECTION_TXT);
		estateTxt = container.getRidget(ITextRidget.class, ViewWidgetId.ESTATE_TXT);
		locationTxt = container.getRidget(ITextRidget.class, ViewWidgetId.LOCATION_TXT);
		subLocationTxt = container.getRidget(ITextRidget.class, ViewWidgetId.SUBLOCATION_TXT);
		villageTxt = container.getRidget(ITextRidget.class, ViewWidgetId.VILLAGE_TXT);
		divisionTxt = container.getRidget(ITextRidget.class, ViewWidgetId.DIVISION_TXT);
		districtTxt = container.getRidget(ITextRidget.class, ViewWidgetId.DISTRICT_TXT);
//		provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
		postalCodeTxt = container.getRidget(ITextRidget.class, ViewWidgetId.POSTAL_CODE_TXT);
		provinceComo = container.getRidget(IComboRidget.class, ViewWidgetId.PROVINCE_TXT);

		addressTxt.setMandatory(true);
		addressTxt.setDirectWriting(true);
		sectionTxt.setMandatory(true);
		sectionTxt.setDirectWriting(true);
		villageTxt.setMandatory(true);
		villageTxt.setDirectWriting(true);
		postalCodeTxt.setMandatory(true);
		postalCodeTxt.setDirectWriting(true);
		provinceComo.setMandatory(true);

	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	@Override
	public PostalLocation getInputModel() {
//		return location;
		return null;
	}

	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == provinceComo) {
//			if (location != null) {
//				location.setProvince((String) event.getNewSelection().get(0));
//			}
		}
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;

	}

	@Override
	public void setInputModel(PostalLocation model) {
		location = new WritableValue(model, PostalLocation.class);
//		location = (PostalLocation) model;
		if (container != null) {
			updateBinding();
		}

	}
	
	public void setInputModel(IObservableValue model) {
		location = model;
	}

	@Override
	public void updateBinding() {
		if (location.getValue() == null) {
//		if (location == null) {
			addressTxt.setText("");
			sectionTxt.setText("");
			estateTxt.setText("");
			locationTxt.setText("");
			subLocationTxt.setText("");
			villageTxt.setText("");
			divisionTxt.setText("");
			districtTxt.setText("");
			// provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
			postalCodeTxt.setText("");
			return;
		}
		addressTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__ADDRESS));
		addressTxt.updateFromModel();
		sectionTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__SECTION));
		sectionTxt.updateFromModel();
		estateTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__ESTATE));
		estateTxt.updateFromModel();
		locationTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__LOCATION));
		locationTxt.updateFromModel();
		subLocationTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location,
				ModelPackage.Literals.POSTAL_LOCATION__SUB_LOCATION));
		subLocationTxt.updateFromModel();
		villageTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__VILLAGE));
		villageTxt.updateFromModel();
		divisionTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__DIVISION));
		divisionTxt.updateFromModel();
		districtTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__DISTRICT));
		districtTxt.updateFromModel();
		provinceComo.bindToModel(Observables.staticObservableList(Arrays.asList(ViewWidgetId.PROVINCES_LIST)),
				String.class, null, EMFObservables.observeDetailValue(location.getRealm(), location, ModelPackage.Literals.POSTAL_LOCATION__PROVINCE));
		provinceComo.updateFromModel();
//		provinceComo.addSelectionListener(this);
		
		postalCodeTxt.bindToModel(EMFObservables.observeDetailValue(location.getRealm(), location,
				ModelPackage.Literals.POSTAL_LOCATION__POSTAL_CODE));
		postalCodeTxt.updateFromModel();

	}

}