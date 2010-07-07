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

public class LiveStockFilterWidgetController implements WidgetController, DateRangeFilter {

	private IActionRidget clear;

	private final IController controller;
	private final DateRangeSearchController dateSearchController;
	private IComboRidget farmCombo;

	private final List<String> farmsList = new ArrayList<String>();

	private Object inputModel;

	private IActionRidget search;

	private IComboRidget speciesCombo;

	private final List<String> speciesList = new ArrayList<String>();

	private IComboRidget statusCombo;

	private final List<String> statusList = new ArrayList<String>();

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
		statusCombo = controller.getRidget(IComboRidget.class, ViewWidgetId.LIVESTOCK_ContainerStatusFilter);
		search = controller.getRidget(IActionRidget.class, ViewWidgetId.memberInfo_searchButton);
		clear = controller.getRidget(IActionRidget.class, ViewWidgetId.cancelButton);
	}

	@Override
	public List<?> filter(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public IActionRidget getClear() {
		return clear;
	}

	@Override
	public IController getController() {
		// TODO Auto-generated method stub
		return controller;
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
	public void setController(IController controller) {
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
		farmCombo.bindToModel(Observables.staticObservableList(farmsList), String.class, null, new WritableValue());
		farmCombo.updateFromModel();
		farmCombo.setSelection(0);
	}

}
