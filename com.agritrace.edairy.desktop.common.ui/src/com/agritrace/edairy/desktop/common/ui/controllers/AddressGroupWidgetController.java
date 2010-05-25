package com.agritrace.edairy.desktop.common.ui.controllers;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;

public class AddressGroupWidgetController implements WidgetController, ISelectionListener{

	private IController controller;
	private PostalLocation location;

	private ITextRidget addressTxt;
	private ITextRidget sectionTxt;
	private ITextRidget estateTxt;
	private ITextRidget locationTxt;
	private ITextRidget subLocationTxt;
	private ITextRidget villageTxt;
	private ITextRidget divisionTxt;
	private ITextRidget districtTxt;
	private IComboRidget provinceComo;
	private ITextRidget postalCodeTxt;


	public AddressGroupWidgetController(IController controller){
		this.controller = controller;
		configue();
	}


	@Override
	public void configue() {
		if(controller == null){
			return;
		}
		addressTxt =controller.getRidget(ITextRidget.class, ViewWidgetId.ADDRESS_TXT);
		sectionTxt = controller.getRidget(ITextRidget.class, ViewWidgetId.SECTION_TXT);
		estateTxt = controller.getRidget(ITextRidget.class, ViewWidgetId.ESTATE_TXT);
		locationTxt =controller.getRidget(ITextRidget.class, ViewWidgetId.LOCATION_TXT);
		subLocationTxt = controller.getRidget(ITextRidget.class, ViewWidgetId.SUBLOCATION_TXT);
		villageTxt = controller.getRidget(ITextRidget.class, ViewWidgetId.VILLAGE_TXT);
		divisionTxt =controller. getRidget(ITextRidget.class, ViewWidgetId.DIVISION_TXT);
		districtTxt = controller.getRidget(ITextRidget.class, ViewWidgetId.DISTRICT_TXT);
		// provinceTxt=getRidget(ITextRidget.class,ViewWidgetId.PROVINCE_TXT);
		postalCodeTxt = controller.getRidget(ITextRidget.class, ViewWidgetId.POSTAL_CODE_TXT);
		provinceComo = controller.getRidget(IComboRidget.class, ViewWidgetId.PROVINCE_TXT);
		provinceComo.bindToModel(Observables.staticObservableList(Arrays.asList(ViewWidgetId.PROVINCES_LIST)),
				String.class, null, new WritableValue());
		provinceComo.updateFromModel();
		provinceComo.addSelectionListener(this);

	}

	@Override
	public Object getInputModel() {
		return location;
	}

	@Override
	public void setInputModel(Object model) {
		location = (PostalLocation) model;
		if(controller != null){
			updateBinding();
		}

	}

	@Override
	public IController getController() {
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;

	}

	@Override
	public void updateBinding() {
		if(location == null){
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
		addressTxt.bindToModel(EMFObservables
				.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__ADDRESS));
		addressTxt.updateFromModel();
		sectionTxt.bindToModel(EMFObservables
				.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__SECTION));
		sectionTxt.updateFromModel();
		estateTxt.bindToModel(EMFObservables.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__ESTATE));
		estateTxt.updateFromModel();
		locationTxt.bindToModel(EMFObservables.observeValue(location,
				ModelPackage.Literals.POSTAL_LOCATION__LOCATION));
		locationTxt.updateFromModel();
		subLocationTxt.bindToModel(EMFObservables.observeValue(location,
				ModelPackage.Literals.POSTAL_LOCATION__SUB_LOCATION));
		subLocationTxt.updateFromModel();
		villageTxt.bindToModel(EMFObservables
				.observeValue(location, ModelPackage.Literals.POSTAL_LOCATION__VILLAGE));
		villageTxt.updateFromModel();
		divisionTxt.bindToModel(EMFObservables.observeValue(location,
				ModelPackage.Literals.POSTAL_LOCATION__DIVISION));
		divisionTxt.updateFromModel();
		districtTxt.bindToModel(EMFObservables.observeValue(location,
				ModelPackage.Literals.POSTAL_LOCATION__DISTRICT));
		districtTxt.updateFromModel();
		provinceComo.setSelection(location.getProvince());
		postalCodeTxt.bindToModel(EMFObservables.observeValue(location,
				ModelPackage.Literals.POSTAL_LOCATION__POSTAL_CODE));
		postalCodeTxt.updateFromModel();


	}


	@Override
	public void ridgetSelected(SelectionEvent event) {
		if (event.getSource() == provinceComo) {
			if (location != null) {
				location.setProvince((String) event.getNewSelection().get(0));
			}
		}
	}
}
