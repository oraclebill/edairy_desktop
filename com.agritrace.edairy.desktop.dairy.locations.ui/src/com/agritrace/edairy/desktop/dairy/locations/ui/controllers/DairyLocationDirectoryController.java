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

import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.util.MatchUtil;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

public class DairyLocationDirectoryController extends BasicDirectoryController<DairyLocation> {

	
	private IMultipleChoiceRidget functions;
	private IComboRidget routeTypeSearchCombo;
	public final static String NODE_ID = "com.agritrace.edairy.dairy.ui.views.DairyLocationView";

	private final DairyLocationSearchBean searchBean = new DairyLocationSearchBean();
	final IDairyRepository locationRepository = DairyRepository.getInstance();


	public DairyLocationDirectoryController() {
		super();
		setEClass(DairyPackage.Literals.DAIRY_LOCATION);

		addTableColumn("Name", DairyPackage.Literals.DAIRY_LOCATION__NAME);
		addTableColumn("Phone", DairyPackage.Literals.DAIRY_LOCATION__PHONE);
		addTableColumn("Functions", DairyPackage.Literals.DAIRY_LOCATION__FUNCTIONS);
		addTableColumn("Route", DairyPackage.Literals.DAIRY_LOCATION__ROUTE);
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
		routeTypeSearchCombo.bindToModel(new WritableList(locationRepository.allRoutes(), Route.class), Route.class, "getName",
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
		final DairyLocation customer = (DairyLocation) EMFUtil.createWorkingCopy(this.getEClass(), 3);
		return customer;
	}

	@Override
	protected List<DairyLocation> getFilteredResult() {
		final List<DairyLocation> filtered = new ArrayList<DairyLocation>();
		final List<DairyLocation> allLocations =  locationRepository.getLocalDairyLocations();
		System.err.println("allCustomers: " + allLocations);
		for (final DairyLocation c : allLocations) {
			if (MatchUtil.matchEquals(searchBean.getFunctionSearchValues(),c.getFunctions())
					&& MatchUtil.matchEquals(searchBean.getRouteSearchValue(), c.getRoute())){
				filtered.add(c);
			}
		}
		System.err.println("Filtered: " + filtered);
		return filtered;
	}

	@Override
	protected RecordDialog<DairyLocation> getRecordDialog(Shell shell) {
//		CustomerEditDialog dialog = new CustomerEditDialog(shell);
//		dialog.setTitle("Edit Customer");
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		functions.setSelection(null);
		routeTypeSearchCombo.setSelection(routeTypeSearchCombo.getEmptySelectionItem());
	}
}
