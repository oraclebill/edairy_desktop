package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.controllers.location.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.util.ContainerValidator;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

final class DairyLocationDelegate extends AbstractMasterDetailsDelegate {

	private IComboRidget routeCombo;
	private ITextRidget textAddress;
	private ITextRidget textName;

	private DairyLocation workingCopy = createWorkingCopy();
	private IDairyRepository locationRepository;

	/**
	 * @param dairyLocationController
	 */
	DairyLocationDelegate(IDairyRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public void configureRidgets(IRidgetContainer container) {
		bindRidgets(container);
		configureValidators(container);
		configureActionListeners(container);
	}

	@Override
	public Object copyBean(Object source, Object target) {
		EMFUtil.copy((EObject) source, (EObject) target, 4);
		return target;
	}

	@Override
	public DairyLocation createWorkingCopy() {
		final DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
		EMFUtil.populate(dairyLocation);
		return dairyLocation;
	}

	@Override
	public DairyLocation getWorkingCopy() {
		return workingCopy;
	}

	static EStructuralFeature[] features = new EStructuralFeature[] { DairyPackage.Literals.DAIRY_LOCATION__CODE,
			DairyPackage.Literals.DAIRY_LOCATION__CONTAINERS, DairyPackage.Literals.DAIRY_LOCATION__DATE_OPENED,
			DairyPackage.Literals.DAIRY_LOCATION__DESCRIPTION, DairyPackage.Literals.DAIRY_LOCATION__FUNCTIONS,
			DairyPackage.Literals.DAIRY_LOCATION__NAME, DairyPackage.Literals.DAIRY_LOCATION__PHONE,
			DairyPackage.Literals.DAIRY_LOCATION__ROUTE, };

	@Override
	public boolean isChanged(Object source, Object target) {
		boolean same = true;
		EObject src = (EObject) source, tgt = (EObject) target;
		same = EMFUtil.compareFeatures(src, tgt, features);
		same = same
				&& EcoreUtil.equals((EObject) src.eGet(DairyPackage.Literals.DAIRY_LOCATION__LOCATION),
						(EObject) tgt.eGet(DairyPackage.Literals.DAIRY_LOCATION__LOCATION));
		// System.err.println("isChanged returning: " + !same );
		// System.err.println(" .. source:" + source );
		// System.err.println(" .. target:" + target );
		return !same;
	}

	@Override
	public String isValid(IRidgetContainer container) {
		// if (!textName.revalidate()) {
		// if ("".equals(textName.getText())) {
		// return "The name can't be empty!";
		// }
		// textName.requestFocus();
		// return "Error.";
		// } else if (!textAddress.revalidate()) {
		// textAddress.requestFocus();
		// return "You must specify an address for this location.";
		// }
		Collection<IMarkableRidget> results = ContainerValidator.validateContainer(container);
		return results.isEmpty() ? super.isValid(container) : results.toString();
	}

	@Override
	public void itemApplied(Object changedItem) {
		if (changedItem instanceof DairyLocation) {
			final DairyLocation changedDairyLocation = (DairyLocation) changedItem;
			if (!locationRepository.getLocalDairyLocations().contains(changedDairyLocation)) {
				locationRepository.getLocalDairyLocations().add(changedDairyLocation);
			}
			locationRepository.updateDairy();
			// if (changedDairyLocation.getId() == 0) {
			// locationRepository.addBranchLocation(changedDairyLocation);
			// } else {
			// // perform update action to SQL
			// locationRepository.updateBranchLocation(changedDairyLocation);
			// }
		} else {
			System.err.println("==================>> What Wha Wah?");
		}
		super.itemApplied(changedItem);
	}

	// @Override
	// public void itemCreated(Object newItem) {
	// bindRidgets(detailsContainer);
	// super.itemCreated(newItem);
	// }

	@Override
	public void itemRemoved(Object oldItem) {
		locationRepository.deleteBranchLocation((DairyLocation) oldItem);
	}

	private void bindRidgets(IRidgetContainer container) {

		final ITextRidget textId = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_COLLECTION_CENTRE_ID);
		textId.bindToModel(workingCopy, "id");
		textId.setOutputOnly(true);
		textId.updateFromModel();

		textName = container.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_NAME);
		textName.bindToModel(workingCopy, "name");
		textName.setMandatory(true);
		textName.updateFromModel();

		final ITextRidget description = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_DESCRIPTION);
		description.bindToModel(workingCopy, "description");
		description.updateFromModel();
		description.setMandatory(true);

		final ITextRidget phone = container.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_PHONE);
		phone.bindToModel(workingCopy, "phone");
		phone.updateFromModel();

		final IDateTextRidget dateOpened = container.getRidget(IDateTextRidget.class,
				DairyLocationController.RIDGET_ID_DATEOPENED);
		dateOpened.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		dateOpened.bindToModel(workingCopy, "dateOpened");
		dateOpened.updateFromModel();

		final IMultipleChoiceRidget functions = container.getRidget(IMultipleChoiceRidget.class,
				DairyLocationController.RIDGET_ID_FUNCTIONS);
		final IObservableList optionValues = new WritableList(Arrays.asList(DairyFunction.values()),
				DairyFunction.class);
		final IObservableList selectionValues = new WritableList(workingCopy.getFunctions(), DairyFunction.class);
		functions.bindToModel(optionValues, selectionValues);
		functions.updateFromModel();

		routeCombo = container.getRidget(IComboRidget.class, DairyLocationController.RIDGET_ID_ROUTE);
		bindRouteCombo();

		// configureAddressTab(container, workingCopy);
		// configureDirectionsTab(container, workingCopy);
		// configureMapTab(container, workingCopy);

		LocationProfileWidgetController locationController = new LocationProfileWidgetController(container);
		locationController.setInputModel(workingCopy.getLocation());

	}

	private void bindRouteCombo() {
		routeCombo.bindToModel(new WritableList(locationRepository.allRoutes(), Route.class), Route.class, "getName",
				EMFObservables.observeValue(workingCopy, DairyPackage.Literals.DAIRY_LOCATION__ROUTE));
		routeCombo.updateFromModel();
	}

	private void configureActionListeners(IRidgetContainer container) {
		// routeCombo.addSelectionListener(new RouteSelectCallback());
		//
		// final IActionRidget configureRouteAction = container.getRidget(
		// IActionRidget.class,
		// DairyLocationController.RIDGET_ID_CONFIGURE_ROUTE_ACTION);
		// configureRouteAction.addListener(new ConfigureRouteCallback());
	}

	private void configureValidators(IRidgetContainer container) {
		// if (textName.getValidationRules().size() <= 0) {
		// final IValidator validator = new MinLength(5);
		// textName.addValidationRule(validator,
		// ValidationTime.ON_UPDATE_TO_MODEL);
		// textName.addValidationMessage("Location name must be 5 characters or more.",
		// validator);
		// }
		//
		// if (textAddress.getValidationRules().size() <= 0) {
		// final IValidator addressValidator = new MinLength(5);
		// textAddress.addValidationRule(addressValidator,
		// ValidationTime.ON_UPDATE_TO_MODEL);
		// textAddress.addValidationMessage("Address must be 5 characters or more.",
		// addressValidator);
		// }
	}
}