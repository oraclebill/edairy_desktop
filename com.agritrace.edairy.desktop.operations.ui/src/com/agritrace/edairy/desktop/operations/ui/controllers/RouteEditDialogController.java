package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.core.util.StringUtils;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IListRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.model.dairy.Vehicle;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.agritrace.edairy.desktop.operations.ui.ViewConstants;
import com.google.inject.Inject;

public class RouteEditDialogController extends RecordDialogController<Route> {
	private final IDairyRepository dairyRepo;
	
	@Inject
	public RouteEditDialogController(final IDairyRepository dairyRepo) {
		this.dairyRepo = dairyRepo;
	}

	@Override
	protected void configureUserRidgets() {
		addTextMap(ViewConstants.ID_TXT_ROUTE_NAME, DairyPackage.Literals.ROUTE__NAME);
		addTextMap(ViewConstants.ID_TXT_ROUTE_DESCRIPTION, DairyPackage.Literals.ROUTE__DESCRIPTION);

		final Dairy localDairy = dairyRepo.getLocalDairy();
		final List<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(null);
		vehicles.addAll(localDairy.getVehicles());
		addComboMap(ViewConstants.ID_TXT_ROUTE_VEHICLE, vehicles, "getRegistrationNumber", DairyPackage.Literals.ROUTE__VEHICLE);
		
		final ITextRidget routeName = getRidget(ITextRidget.class, ViewConstants.ID_TXT_ROUTE_NAME);
		getRidget(IComboRidget.class, ViewConstants.ID_TXT_ROUTE_VEHICLE).addSelectionListener(new ISelectionListener() {
			@Override
			public void ridgetSelected(SelectionEvent event) {
				final Route route = getWorkingCopy();
				final Vehicle vehicle = route.getVehicle();
				
				if (vehicle != null && StringUtils.isEmpty(route.getName())) {
					route.setName(vehicle.getLogBookNumber());
					routeName.updateFromModel();
				}
			}
		});
		
		final IListRidget stopsList = getRidget(IListRidget.class, ViewConstants.ID_LST_ROUTE_STOPS);
		stopsList.bindToModel(EMFObservables.observeList(this.getWorkingCopy(), DairyPackage.Literals.ROUTE__STOPS),
				DairyLocation.class, "name");
		stopsList.updateFromModel();
		stopsList.setOutputOnly(true);
		stopsList.setFocusable(false);
		stopsList.setEnabled(false);
	}	
}
