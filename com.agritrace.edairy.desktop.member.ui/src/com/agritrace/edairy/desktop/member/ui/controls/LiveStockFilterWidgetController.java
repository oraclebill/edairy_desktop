package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeSearchController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.reference.LivestockValues;
import com.agritrace.edairy.desktop.common.ui.views.BaseListView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LiveStockFilterWidgetController implements WidgetController<Object> {

	private final IRidgetContainer container;

	private final DateRangeSearchController dateSearchController;

	private Object inputModel;

	private IActionRidget search;
	private IActionRidget clear;

	private IComboRidget speciesCombo;
	private IComboRidget statusCombo;
	private IComboRidget farmCombo;

	private final List<String> farmsList = new ArrayList<String>();
	private final List<String> speciesList = new ArrayList<String>();
	private final List<String> statusList = new ArrayList<String>();

	public LiveStockFilterWidgetController(IRidgetContainer controller) {
		this.container = controller;
		dateSearchController = new DateRangeSearchController(controller, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE,
				ViewWidgetId.LIVESTOCK_FILTER_ENDDATE, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE_BUTTON,
				ViewWidgetId.LIVESTOCK_FILTER_ENDDATE_BUTTON, null);
		configure();
	}

	@Override
	public void configure() {

		farmCombo = container.getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_FarmFilterCombo);
		speciesCombo = container.getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_ContainerSpeciesFilter);
		statusCombo = container.getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_ContainerStatusFilter);

		search = container.getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_SEARCH);
		clear = container.getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_RESET);
	}

	public IActionRidget getClear() {
		return clear;
	}

	@Override
	public IRidgetContainer getContainer() {
		return container;
	}

	public DateRangeSearchController getDateSearchController() {
		return dateSearchController;
	}

	public IComboRidget getFarmCombo() {
		return farmCombo;
	}

	public List<String> getFarmsList() {
		return farmsList;
	}

	@Override
	public Object getInputModel() {
		// TODO Auto-generated method stub
		return inputModel;
	}

	public IActionRidget getSearch() {
		return search;
	}

	public IComboRidget getSpeciesCombo() {
		return speciesCombo;
	}

	public List<String> getSpeciesList() {
		return speciesList;
	}

	public IComboRidget getStatusCombo() {
		return statusCombo;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	@Override
	public void setController(IRidgetContainer container) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInputModel(Object model) {
		inputModel = model;
		updateBinding();

	}

	@Override
	public void updateBinding() {
		speciesList.clear();
		speciesList.add("All Species");
		speciesList.addAll(LivestockValues.getSpecies());
		speciesCombo
		.bindToModel(Observables.staticObservableList(speciesList), String.class, null, new WritableValue());
		speciesCombo.updateFromModel();
		speciesCombo.setSelection(0);

		statusList.clear();
		statusList.add("All Status");
		statusCombo.bindToModel(Observables.staticObservableList(statusList), String.class, null, new WritableValue());
		statusCombo.updateFromModel();
		statusCombo.setSelection(0);

		farmsList.clear();
		farmsList.add("All Farms");
		if (inputModel instanceof Membership) {
			final List<Farm> farms = ((Membership) inputModel).getMember().getFarms();
			for (final Farm farm : farms) {
				farmsList.add(farm.getName());
			}
		} else if (inputModel instanceof Farm) {
			farmsList.add(((Farm) inputModel).getName());

		}		
		if(farmCombo != null){
			farmCombo.bindToModel(Observables.staticObservableList(farmsList), String.class, null, new WritableValue());
			farmCombo.updateFromModel();
			farmCombo.setSelection(0);		
		}

	}

	public void clearFilters(){
		speciesList.clear();
		speciesList.add("All Species");
		if(speciesCombo != null){
			speciesCombo.bindToModel(Observables.staticObservableList(speciesList), String.class, null, new WritableValue());
			speciesCombo.updateFromModel();
			speciesCombo.setSelection(0);	
		}

		statusList.clear();
		statusList.add("All Status");
		if(statusCombo != null){
			statusCombo.bindToModel(Observables.staticObservableList(statusList), String.class, null, new WritableValue());
			statusCombo.updateFromModel();
			statusCombo.setSelection(0);
		}


		farmsList.clear();
		farmsList.add("All Farms");
		if(farmCombo  != null){
			farmCombo.bindToModel(Observables.staticObservableList(farmsList), String.class, null, new WritableValue());
			farmCombo.updateFromModel();
			farmCombo.setSelection(0);		
		}
		
		if(dateSearchController != null){
			dateSearchController.resetDates();
		}
	
	}

}
