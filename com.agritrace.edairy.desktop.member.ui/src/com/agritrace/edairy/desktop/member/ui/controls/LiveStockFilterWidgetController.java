package com.agritrace.edairy.desktop.member.ui.controls;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeFilter;
import com.agritrace.edairy.desktop.common.ui.controllers.DateRangeSearchController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.reference.LivestockValues;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class LiveStockFilterWidgetController  implements WidgetController, DateRangeFilter{
	
	private IController controller;
	
	private DateRangeSearchController dateSearchController;
	private IComboRidget farmCombo;
	public DateRangeSearchController getDateSearchController() {
		return dateSearchController;
	}

	public IComboRidget getFarmCombo() {
		return farmCombo;
	}

	public IComboRidget getSpeciesCombo() {
		return speciesCombo;
	}

	public IComboRidget getStatusCombo() {
		return statusCombo;
	}

	public List<String> getSpeciesList() {
		return speciesList;
	}

	public List<String> getFarmsList() {
		return farmsList;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	private IComboRidget speciesCombo;
	private IComboRidget statusCombo;
	
	private List<String> speciesList =  new ArrayList<String>();
	private List<String> farmsList =  new ArrayList<String>();
	private List<String> statusList =  new ArrayList<String>();
	private IActionRidget search;
	

	private IActionRidget clear;
	
	private Object inputModel;
	
	public LiveStockFilterWidgetController(IController controller) {
		this.controller = controller;
		dateSearchController = new DateRangeSearchController(controller, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE,
				ViewWidgetId.LIVESTOCK_FILTER_ENDDATE, ViewWidgetId.LIVESTOCK_FILTER_STARTDATE_BUTTON,
				ViewWidgetId.LIVESTOCK_FILTER_ENDDATE_BUTTON, this);
		configure();
	}

	@Override
	public void configure() {
	
		farmCombo = controller.getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_FarmFilterCombo);
		speciesCombo = controller.getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_ContainerSpeciesFilter);
		statusCombo =controller.getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_ContainerStatusFilter);
		search = controller.getRidget(IActionRidget.class, ViewWidgetId.memberInfo_searchButton);
		clear = controller.getRidget(IActionRidget.class,ViewWidgetId.cancelButton);
	}

	@Override
	public Object getInputModel() {
		// TODO Auto-generated method stub
		return inputModel;
	}

	@Override
	public void setInputModel(Object model) {
		inputModel = model;
		updateBinding();
		
	}

	@Override
	public IController getController() {
		// TODO Auto-generated method stub
		return controller;
	}

	@Override
	public void setController(IController controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBinding() {
		speciesList.clear();
		speciesList.add("All Species");
		speciesList.addAll(LivestockValues.getSpecies());
		speciesCombo.bindToModel(Observables.staticObservableList(speciesList), String.class, null,new WritableValue());
		speciesCombo.updateFromModel();
		speciesCombo.setSelection(0);
		
		statusList.clear();
		statusList.add("All Status");
		statusCombo.bindToModel(Observables.staticObservableList(statusList), String.class, null,new WritableValue());
		statusCombo.updateFromModel();
		statusCombo.setSelection(0);
		
		farmsList.clear();
		farmsList.add("All Farms");
		if(inputModel instanceof Membership){
			List<Farm> farms = ((Membership)inputModel).getMember().getFarms();
			for(Farm farm : farms){
				farmsList.add(farm.getName());
			}
		}else if(inputModel instanceof Farm){
			farmsList.add(((Farm)inputModel).getName());

		}
		farmCombo.bindToModel(Observables.staticObservableList(farmsList), String.class, null,new WritableValue());
		farmCombo.updateFromModel();
		farmCombo.setSelection(0);
	}

	@Override
	public List<?> filter(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public IActionRidget getSearch() {
		return search;
	}

	public IActionRidget getClear() {
		return clear;
	}
	
}
