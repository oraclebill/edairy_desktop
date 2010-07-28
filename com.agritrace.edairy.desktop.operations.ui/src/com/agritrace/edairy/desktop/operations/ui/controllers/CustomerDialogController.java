package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Arrays;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.CompanyStatus;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.operations.ui.dialogs.CustomerBindingConstants;

public class CustomerDialogController extends RecordDialogController<Customer> {
	public static String[] CUSTOMER_TYPES = { "Milk Processor", "Milk Bar", "Other" };
	private ITextRidget companyPhone;

	private Customer editCustomer = null;
	ITextRidget companyName;
	ITextRidget customerDescription;
	ITextRidget customerId;
	IComboRidget customerStatus;
	IComboRidget customerType;
	IProfilePhotoRidget profilePhoto;

	ITextRidget legalName;

	@Override
	public void configureUserRidgets() {

		// ensure model available
		editCustomer = getWorkingCopy();
		assert (null != editCustomer);

		// addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_CUSTOMER_ID,
		// ModelPackage.Literals.COMPANY__COMPANY_ID);
		addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_COMPANY_NAME, ModelPackage.Literals.COMPANY__COMPANY_NAME);
		addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_PHONE_NUMBER, ModelPackage.Literals.COMPANY__PHONE_NUMBER);
		addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_LEGAL_NAME, ModelPackage.Literals.COMPANY__LEGAL_NAME);
		addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_DESCRIPTION, ModelPackage.Literals.COMPANY__DESCRIPTION);
		// addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_CUSTOMER_PHOTO,
		// ModelPackage.Literals.COMPANY__PROFILE_PHOTO);

		// combos
		addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_CUSTOMER_STATUS, Observables.staticObservableList(CompanyStatus.getCustomerStatusStringList()), null,
				DairyPackage.Literals.CUSTOMER__STATUS);

		addRidgetFeatureMap(CustomerBindingConstants.BIND_ID_CUSTOMERTYPE, Observables.staticObservableList(Arrays.asList(CUSTOMER_TYPES)), null, DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE);

		// customer id is read-only, so needs manual attention.
		customerId = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_ID);
		//note, notice if set converter NumberToStringConberter, it won't be called, there is ClassCastException at console
		//set converter this way, fixed the error.
		// customerId.setModelToUIControlConverter(NumberToStringConverter.fromLong(false));
		final IObservableValue oberservModel = EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__COMPANY_ID);
		customerId.setModelToUIControlConverter(new Converter(oberservModel.getValueType(), String.class) {
			@Override
			public Object convert(Object from) {
				if (from instanceof Long) {
					return ((Long) from).toString();
				}
				return "";
			}
		});
		customerId.bindToModel(oberservModel);
		customerId.setOutputOnly(true);

		profilePhoto = getRidget(IProfilePhotoRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_PHOTO);
		profilePhoto.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__PROFILE_PHOTO));
		// profilePhoto.updateFromModel();

		// Configure address group
		final AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		addressGroupController.setInputModel(editCustomer.getLocation().getPostalLocation());
		addressGroupController.updateBinding();

		// Configure Direction Group
		final DirectionGroupController directionController = new DirectionGroupController(this);
		directionController.setInputModel(editCustomer.getLocation().getDescriptiveLocation());
		directionController.updateBinding();

		// Configure Map Group
		final MapGroupController mapController = new MapGroupController(this);
		mapController.setInputModel(editCustomer.getLocation().getMapLocation());
		mapController.updateBinding();

		// Configure Communication Group
		// final CommunicationGroupController commController = new
		// CommunicationGroupController(this);
		// commController.setInputModel(editCustomer);
		// commController.updateBinding();
		IContactMethodsGroupRidget contacts = getRidget(IContactMethodsGroupRidget.class, IContactMethodsGroupRidget.WIDGET_ID);
		contacts.bindToModel(editCustomer);
		contacts.updateFromModel();
	}

	@Override
	public Customer getWorkingCopy() {
		return (Customer) getContext("editObject");
	}

	@Override
	public void afterBind() {
		super.afterBind();
		// customerType.updateFromModel();
		// profilePhoto.updateFromModel();
	}
}
