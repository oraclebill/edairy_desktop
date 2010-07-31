package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.util.MatchUtil;
import com.agritrace.edairy.desktop.dairy.locations.ui.dialogs.DairyLocationEditDialog;
import com.agritrace.edairy.desktop.operations.services.dairylocation.DairyLocationRepository;

public class DairyLocationDirectoryController extends BasicDirectoryController<DairyLocation> {


	private IMultipleChoiceRidget functions;
	private IComboRidget routeTypeSearchCombo;
	public final static String NODE_ID = "com.agritrace.edairy.dairy.ui.views.DairyLocationView";

	private final DairyLocationSearchBean searchBean = new DairyLocationSearchBean();
	private DairyLocationRepository dairyLocationRepo = new DairyLocationRepository();


	public DairyLocationDirectoryController() {
		super();
		setEClass(DairyPackage.Literals.DAIRY_LOCATION);
		setRepository(dairyLocationRepo);

		addTableColumn("Name", DairyPackage.Literals.DAIRY_LOCATION__NAME);
		addTableColumn("Phone", DairyPackage.Literals.DAIRY_LOCATION__PHONE);
		addTableColumn("Functions", DairyPackage.Literals.DAIRY_LOCATION__FUNCTIONS);
		addTableColumn("Route", DairyPackage.Literals.DAIRY_LOCATION__ROUTE, new DairyLocationRouteFormatter());
		addTableColumn("Description", DairyPackage.Literals.DAIRY_LOCATION__DESCRIPTION);

	}

	@Override
	protected void configureFilterRidgets() {
		functions= getRidget(IMultipleChoiceRidget.class,
				DairyLocationController.RIDGET_ID_FUNCTIONS);
		final IObservableList optionValues = new WritableList(Arrays.asList(DairyFunction.values()),
				DairyFunction.class);
		final IObservableList selectionValues = new WritableList(searchBean.getFunctionSearchValues(), DairyFunction.class);
		functions.bindToModel(optionValues, selectionValues);
		functions.updateFromModel();

		//
		routeTypeSearchCombo = getRidget(IComboRidget.class,DairyLocationController.RIDGET_ID_ROUTE);
		routeTypeSearchCombo.bindToModel(new WritableList(dairyLocationRepo.getRoutes(), Route.class), Route.class, "getName",
				BeansObservables.observeValue(searchBean,"routeSearchValue"));
		routeTypeSearchCombo.updateFromModel();

	}

	/**
	 * Create new model while creating a new record
	 * 
	 * @return
	 */
	@Override
	protected DairyLocation createNewModel() {
		final DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
		EMFUtil.populate(dairyLocation);
		return dairyLocation;
	}

	@Override
	protected List<DairyLocation> getFilteredResult() {
		final List<DairyLocation> filtered = new ArrayList<DairyLocation>();
		final List<DairyLocation> allLocations =  dairyLocationRepo.all();
		System.err.println("allLocations: " + allLocations);
		for (final DairyLocation c : allLocations) {
			if (searchBean.getRouteSearchValue() == null || MatchUtil.matchEquals(searchBean.getRouteSearchValue().getCode(), c.getRoute().getCode())){
				List<DairyFunction> filterFunctions = searchBean.getFunctionSearchValues();
				List<DairyFunction> functions = c.getFunctions();
				boolean found = true;
				for(DairyFunction f : filterFunctions){
					if(!functions.contains(f)){
						found = false;
						break;
					}
				}
				if(found){
					filtered.add(c);
				}
			}
		}
		System.err.println("Filtered: " + filtered);
		return filtered;
	}

	@Override
	protected RecordDialog<DairyLocation> getRecordDialog(Shell shell) {
		DairyLocationEditDialog dialog = new DairyLocationEditDialog(shell);
		dialog.getController().setContext("routes", dairyLocationRepo.getRoutes());
		dialog.setTitle("Edit Dairy Location");
		return dialog;
	}

	@Override
	protected void resetFilterConditions() {
		functions.setSelection(null);
		routeTypeSearchCombo.setSelection(routeTypeSearchCombo.getEmptySelectionItem());
	}

}
