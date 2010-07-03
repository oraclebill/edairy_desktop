package com.agritrace.edairy.desktop.dairy.locations.ui.controllers;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IMultipleChoiceRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.Location;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.ModelFactory;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFactory;
import com.agritrace.edairy.desktop.common.model.dairy.DairyFunction;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Route;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.operations.services.dairylocation.DairyLocationRepository;

final class DairyLocationDelegate extends AbstractMasterDetailsDelegate {
	private class AddressValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			if ("".equals(textAddress.getText())) {
				return Status.CANCEL_STATUS;
			}

			return Status.OK_STATUS;
		}
	}

	private class DairyLocationNameValidator implements IValidator {
		@Override
		public IStatus validate(Object value) {
			final String name = textName.getText().trim();
			if ("".equals(name)) {
				return Status.CANCEL_STATUS;
			}
			if (locationRepository.getByName(name) != null) {
				return Status.CANCEL_STATUS;
			}
			return Status.OK_STATUS;
		}
	}

	// private ITableRidget table;
	private IRidgetContainer detailsContainer;
	/**
	 * 
	 */
	private final DairyLocationRepository locationRepository;
	private IComboRidget routeCombo;
	private ITextRidget textAddress;
	private ITextRidget textName;

	private DairyLocation workingCopy = createWorkingCopy();

	/**
	 * @param dairyLocationController
	 */
	DairyLocationDelegate(DairyLocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public void configureRidgets(IRidgetContainer container) {
		detailsContainer = container;
		bindRidgets(container);
		configureValidators(container);
		configureActionListeners(container);
	}

	@Override
	public Object copyBean(Object source, Object target) {
		// if (source.equals(target)) {
		// return source;
		// }
		// final DairyLocation from = source != null ? (DairyLocation) source
		// : createWorkingCopy();
		// final DairyLocation to = target != null ? (DairyLocation) target
		// : createWorkingCopy();
		// to.setId(from.getId());
		// to.setName(from.getName());
		// to.setDateOpened(from.getDateOpened());
		// to.setDescription(from.getDescription());
		// to.setPhone(from.getPhone());
		// to.setCode(from.getCode());
		// if (from.getRoute() == null) {
		// to.setRoute(null);
		// } else {
		// if (to.getRoute() == null) {
		// to.setRoute(DairyFactory.eINSTANCE.createRoute());
		// }
		// to.getRoute().setId(from.getRoute().getId());
		// to.getRoute().setName(from.getRoute().getName());
		// to.getRoute().setDescription(from.getRoute().getDescription());
		// to.getRoute().setCode(from.getRoute().getCode());
		// // ECoreUtil.co
		// }
		// // to.setLocation(from.getLocation());
		// to.getFunctions().clear();
		// to.getFunctions().addAll(from.getFunctions());
		// to.getLocation()
		// .getPostalLocation()
		// .setAddress(from.getLocation().getPostalLocation().getAddress());
		// to.getLocation().getPostalLocation()
		// .setEstate(from.getLocation().getPostalLocation().getEstate());
		// to.getLocation()
		// .getPostalLocation()
		// .setVillage(from.getLocation().getPostalLocation().getVillage());
		// to.getLocation()
		// .getPostalLocation()
		// .setPostalCode(
		// from.getLocation().getPostalLocation().getPostalCode());
		// to.getLocation()
		// .getPostalLocation()
		// .setProvince(
		// from.getLocation().getPostalLocation().getProvince());
		// to.getLocation()
		// .getPostalLocation()
		// .setSection(from.getLocation().getPostalLocation().getSection());
		// to.getLocation()
		// .getPostalLocation()
		// .setDivision(
		// from.getLocation().getPostalLocation().getDivision());
		// to.getLocation()
		// .getPostalLocation()
		// .setLocation(
		// from.getLocation().getPostalLocation().getLocation());
		// to.getLocation()
		// .getPostalLocation()
		// .setSubLocation(
		// from.getLocation().getPostalLocation().getSubLocation());
		// to.getLocation()
		// .getPostalLocation()
		// .setDistrict(
		// from.getLocation().getPostalLocation().getDistrict());
		// to.getLocation()
		// .getDescriptiveLocation()
		// .setDirections(
		// from.getLocation().getDescriptiveLocation()
		// .getDirections());
		// to.getLocation()
		// .getDescriptiveLocation()
		// .setLandmarks(
		// from.getLocation().getDescriptiveLocation()
		// .getLandmarks());
		// to.getLocation().getMapLocation()
		// .setLatitude(from.getLocation().getMapLocation().getLatitude());
		// to.getLocation()
		// .getMapLocation()
		// .setLongitude(
		// from.getLocation().getMapLocation().getLongitude());
		EMFUtil.copy((EObject) source, (EObject) target, 4);
		return target;
	}

	@Override
	public DairyLocation createWorkingCopy() {
		final DairyLocation dairyLocation = DairyFactory.eINSTANCE.createDairyLocation();
		workingCopy = dairyLocation;

		final Route route = DairyFactory.eINSTANCE.createRoute();
		dairyLocation.setRoute(route);
		dairyLocation.getRoute().setName("");
		dairyLocation.getFunctions();

		final Location location = ModelFactory.eINSTANCE.createLocation();

		final PostalLocation postalLocation = ModelFactory.eINSTANCE.createPostalLocation();

		final DescriptiveLocation descriptiveLocation = ModelFactory.eINSTANCE.createDescriptiveLocation();

		final MapLocation mapLocation = ModelFactory.eINSTANCE.createMapLocation();

		location.setPostalLocation(postalLocation);
		location.setDescriptiveLocation(descriptiveLocation);
		location.setMapLocation(mapLocation);
		dairyLocation.setLocation(location);
		return workingCopy;
	}

	@Override
	public DairyLocation getWorkingCopy() {

		return workingCopy;
	}

	@Override
	public boolean isChanged(Object source, Object target) {
		if ((source != null) && (target != null)) {

			final DairyLocation src = (DairyLocation) source;
			final DairyLocation dst = (DairyLocation) target;
			if (src.getId() == 0) {
				// always return true for id=0 since it's a new created
				// object;
				return true;
			}
			if (!(EMFUtil.compare(src, dst)
					&& EMFUtil.compare(src.getRoute(), dst.getRoute())
					&& EMFUtil.compare(src.getLocation().getPostalLocation(), dst.getLocation().getPostalLocation())
					&& EMFUtil.compare(src.getLocation().getDescriptiveLocation(), dst.getLocation()
							.getDescriptiveLocation()) && EMFUtil.compare(src.getLocation().getMapLocation(), dst
					.getLocation().getMapLocation()))) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String isValid(IRidgetContainer container) {
		if (!textName.revalidate()) {
			if ("".equals(textName.getText())) {
				return "The name can't be empty!";
			}
			textName.requestFocus();
			return "The name '" + textName.getText()
					+ "' is already in use.\r\n\rPlease select a unique name for this new location.";
		} else if (!textAddress.revalidate()) {
			textAddress.requestFocus();
			return "You must specify an address for this location.";
		}
		return super.isValid(container);
	}

	@Override
	public void itemApplied(Object changedItem) {
		if (changedItem instanceof DairyLocation) {
			final DairyLocation changedDairyLocation = (DairyLocation) changedItem;
			if (changedDairyLocation.getId() == 0) {
				// perform create action to SQL
				locationRepository.saveNew(changedDairyLocation);
			} else {
				// perform update action to SQL
				locationRepository.update(changedDairyLocation);
			}
		}
		super.itemApplied(changedItem);
	}

	@Override
	public void itemCreated(Object newItem) {
		bindRidgets(detailsContainer);
		super.itemCreated(newItem);
	}

	@Override
	public void itemRemoved(Object oldItem) {
		locationRepository.delete((DairyLocation) oldItem);
	}

	private void bindRidgets(IRidgetContainer container) {
		// table = container.getRidget(ITableRidget.class,
		// AbstractMasterDetailsComposite.BIND_ID_TABLE);

		final ITextRidget textId = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_COLLECTION_CENTRE_ID);
		textId.bindToModel(workingCopy, "id");
		textId.setOutputOnly(true);
		textId.updateFromModel();

		textName = container.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_NAME);
		textName.bindToModel(workingCopy, "name");
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

		configureAddressTab(container, workingCopy);
		configureDirectionsTab(container, workingCopy);
		configureMapTab(container, workingCopy);
	}

	private void bindRouteCombo() {
		// routeCombo.bindToModel(locationRepository, "routes", Route.class,
		// "name", workingCopy, "route");
		routeCombo.bindToModel(new WritableList(locationRepository.getRoutes(), Route.class), Route.class, "getName",
				EMFObservables.observeValue(workingCopy, DairyPackage.Literals.DAIRY_LOCATION__ROUTE));
		// EMFObservables.listFactory(Realm.getDefault(),
		// DairyPackage.Literals.DAIRY__ROUTES).createObservable(target)
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

	private void configureAddressTab(IRidgetContainer container, DairyLocation dairyLocation) {
		textAddress = container.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_PL_ADDRESS);
		textAddress.setMandatory(true);
		textAddress.bindToModel(dairyLocation.getLocation().getPostalLocation(), "address");
		textAddress.updateFromModel();

		final ITextRidget section = container
				.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_PL_SECTION);
		section.bindToModel(dairyLocation.getLocation().getPostalLocation(), "section");
		section.updateFromModel();

		final ITextRidget town = container.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_PL_TOWN);
		town.bindToModel(dairyLocation.getLocation().getPostalLocation(), "village");
		town.updateFromModel();

		final ITextRidget estate = container.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_PL_ESTATE);
		estate.bindToModel(dairyLocation.getLocation().getPostalLocation(), "estate");
		estate.updateFromModel();

		final ITextRidget location = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_PL_LOCATION);
		location.bindToModel(dairyLocation.getLocation().getPostalLocation(), "location");
		location.updateFromModel();

		final ITextRidget sub = container.getRidget(ITextRidget.class, DairyLocationController.RIDGET_ID_PL_SUB);
		sub.bindToModel(dairyLocation.getLocation().getPostalLocation(), "subLocation");
		sub.updateFromModel();

		final ITextRidget district = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_PL_DISTRICT);
		district.bindToModel(dairyLocation.getLocation().getPostalLocation(), "district");
		district.updateFromModel();

		final ITextRidget division = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_PL_DIVISION);
		division.bindToModel(dairyLocation.getLocation().getPostalLocation(), "division");
		division.updateFromModel();

		final ITextRidget postalCode = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_PL_POSTALCODE);
		postalCode.bindToModel(dairyLocation.getLocation().getPostalLocation(), "postalCode");
		postalCode.updateFromModel();

		final ITextRidget province = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_PL_PROVINCE);
		province.bindToModel(dairyLocation.getLocation().getPostalLocation(), "province");
		province.updateFromModel();

	}

	private void configureDirectionsTab(IRidgetContainer container, DairyLocation dairyLocation) {
		final ITextRidget landmark = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_DL_LANDMARK);
		landmark.bindToModel(dairyLocation.getLocation().getDescriptiveLocation(), "landmarks");
		landmark.updateFromModel();

		final ITextRidget directions = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_DL_DIRECTIONS);
		directions.bindToModel(dairyLocation.getLocation().getDescriptiveLocation(), "directions");
		directions.updateFromModel();
	}

	private void configureMapTab(IRidgetContainer container, DairyLocation dairyLocation) {
		final ITextRidget latitude = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_ML_LATITUDE);
		latitude.bindToModel(dairyLocation.getLocation().getMapLocation(), "latitude");
		latitude.updateFromModel();

		final ITextRidget longitude = container.getRidget(ITextRidget.class,
				DairyLocationController.RIDGET_ID_ML_LONGITUDE);
		longitude.bindToModel(dairyLocation.getLocation().getMapLocation(), "longitude");
		longitude.updateFromModel();
	}

	private void configureValidators(IRidgetContainer container) {
		final DairyLocationNameValidator nameValidator = new DairyLocationNameValidator();
		if (textName.getValidationRules().size() <= 0) {
			textName.addValidationRule(nameValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		}
		final AddressValidator addressValidator = new AddressValidator();
		if (textAddress.getValidationRules().size() <= 0) {
			textAddress.addValidationRule(addressValidator, ValidationTime.ON_UPDATE_TO_MODEL);
			textAddress.addValidationMessage("required", addressValidator);
		}
	}
}