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
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.util.MatchUtil;
import com.agritrace.edairy.desktop.dairy.locations.ui.DairyLocationUIConstants;
import com.agritrace.edairy.desktop.dairy.locations.ui.dialogs.DairyLocationEditDialog;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.edairy.desktop.operations.services.dairylocation.IDairyLocationRepository;
import com.google.inject.Inject;

@PermissionRequired(Permission.VIEW_DAIRY_LOCATIONS)
public class DairyLocationDirectoryController extends
		BasicDirectoryController<DairyLocation> {
	private IMultipleChoiceRidget functions;
	private IComboRidget routeTypeSearchCombo;
	public final static String NODE_ID = "com.agritrace.edairy.dairy.ui.views.DairyLocationView";

	private final DairyLocationSearchBean searchBean = new DairyLocationSearchBean();
	private final IDairyLocationRepository dairyLocationRepo;

	private final IDairyRepository dairyRepo;
	// private final Dairy localDairy = dairyRepo.getLocalDairy();

	@Override
	protected void deleteEntity(DairyLocation deletableEntity) {
		if (deletableEntity != null) {
			dairyRepo.deleteBranchLocation(deletableEntity);
		}
	}

	@Inject
	public DairyLocationDirectoryController(IDairyLocationRepository dairyLocationRepo, IDairyRepository dairyRepo) {
		super();
		setEClass(DairyPackage.Literals.DAIRY_LOCATION);
		this.dairyLocationRepo = dairyLocationRepo;
		this.dairyRepo = dairyRepo;
		setRepository(dairyLocationRepo);

		addTableColumn("Name", DairyPackage.Literals.DAIRY_LOCATION__NAME);
		addTableColumn("Phone", DairyPackage.Literals.DAIRY_LOCATION__PHONE);
		addTableColumn("Functions", DairyPackage.Literals.DAIRY_LOCATION__FUNCTIONS);
		addTableColumn("Code", DairyPackage.Literals.DAIRY_LOCATION__CODE);
		addTableColumn("Transport Route", DairyPackage.Literals.DAIRY_LOCATION__ROUTE,
				new DairyLocationRouteFormatter());
		addTableColumn("Description", DairyPackage.Literals.DAIRY_LOCATION__DESCRIPTION);

	}

	@Override
	protected void configureFilterRidgets() {
		functions = getRidget(IMultipleChoiceRidget.class,
				DairyLocationUIConstants.RIDGET_ID_FUNCTIONS);
		final IObservableList optionValues = new WritableList(Arrays
				.asList(DairyFunction.values()), DairyFunction.class);
		final IObservableList selectionValues = new WritableList(searchBean
				.getFunctionSearchValues(), DairyFunction.class);
		functions.bindToModel(optionValues, selectionValues);
		functions.updateFromModel();

		//
		routeTypeSearchCombo = getRidget(IComboRidget.class,
				DairyLocationUIConstants.RIDGET_ID_ROUTE);
		routeTypeSearchCombo.bindToModel(new WritableList(dairyLocationRepo.getRoutes(), Route.class), Route.class,
				"getName", BeansObservables.observeValue(searchBean, "routeSearchValue"));
		routeTypeSearchCombo.updateFromModel();

	}

	/**
	 * Create new model while creating a new record
	 *
	 * @return
	 */
	@Override
	protected DairyLocation createNewModel() {
		final DairyLocation dairyLocation = DairyFactory.eINSTANCE
				.createDairyLocation();
		EMFUtil.populate(dairyLocation);
		return dairyLocation;
	}

	@Override
	protected List<DairyLocation> getFilteredResult() {
		final List<DairyLocation> filtered = new ArrayList<DairyLocation>();
		final List<DairyLocation> allLocations = dairyLocationRepo.all();
		System.err.println("allLocations: " + allLocations);
		for (final DairyLocation c : allLocations) {
			final String cName = c.getRoute() == null ? "" : c.getRoute().getName();
			if (searchBean.getRouteSearchValue() == null
					|| MatchUtil.matchEquals(searchBean.getRouteSearchValue().getName(), cName)) {

				final List<DairyFunction> filterFunctions = searchBean
						.getFunctionSearchValues();
				final List<DairyFunction> functions = c.getFunctions();

				boolean found = true;
				for (final DairyFunction f : filterFunctions) {
					if (!functions.contains(f)) {
						found = false;
						break;
					}
				}

				if (found) {
					filtered.add(c);
				}
			}
		}
		System.err.println("Filtered: " + filtered);
		return filtered;
	}

	@Override
	protected RecordDialog<DairyLocation> getRecordDialog(Shell shell) {
		final DairyLocationEditDialog dialog = new DairyLocationEditDialog(shell);
		dialog.getController().setContext("routes",
				dairyLocationRepo.getRoutes());
		dialog.setTitle("Edit Dairy Location");
		return dialog;
	}

	@Override
	protected void resetFilterConditions() {
		functions.setSelection(null);
		routeTypeSearchCombo.setSelection(routeTypeSearchCombo
				.getEmptySelectionItem());
	}

}
