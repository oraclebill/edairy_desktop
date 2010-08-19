package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Arrays;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.NumberToStringConverter;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.CompanyStatus;
import com.agritrace.edairy.desktop.operations.ui.dialogs.CustomerBindingConstants;

public class CustomerDialogController extends RecordDialogController<Customer> {
	public static String[] CUSTOMER_TYPES = { "Milk Processor", "Milk Bar", "Other" };

	@Override
	public void configureUserRidgets() {
		Customer editCustomer = null;
		ITextRidget customerId;
		IProfilePhotoRidget profilePhoto;

		// ensure model available
		editCustomer = getWorkingCopy();
		assert (null != editCustomer);

		addTextMap(CustomerBindingConstants.BIND_ID_COMPANY_NAME, ModelPackage.Literals.COMPANY__COMPANY_NAME);
		addTextMap(CustomerBindingConstants.BIND_ID_PHONE_NUMBER, ModelPackage.Literals.COMPANY__PHONE_NUMBER);
		addTextMap(CustomerBindingConstants.BIND_ID_LEGAL_NAME, ModelPackage.Literals.COMPANY__LEGAL_NAME);
		addTextMap(CustomerBindingConstants.BIND_ID_DESCRIPTION, ModelPackage.Literals.COMPANY__DESCRIPTION);

		// combos
		addComboMap(CustomerBindingConstants.BIND_ID_CUSTOMER_STATUS,
				Observables.staticObservableList(CompanyStatus.getCustomerStatusStringList()), null,
				DairyPackage.Literals.CUSTOMER__STATUS);

		addComboMap(CustomerBindingConstants.BIND_ID_CUSTOMERTYPE,
				Observables.staticObservableList(Arrays.asList(CUSTOMER_TYPES)), null,
				DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE);

		/*
		customerId = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_ID);
		final IObservableValue oberservModel = PojoObservables.observeValue(editCustomer,
				ModelPackage.Literals.COMPANY__COMPANY_ID.getName());
		customerId.setModelToUIControlConverter(NumberToStringConverter.fromLong(false));
		customerId.bindToModel(oberservModel);
		*/
		addTextMap(CustomerBindingConstants.BIND_ID_CUSTOMER_NUM, DairyPackage.Literals.CUSTOMER__ID);

		// profile photo also needs manual binding..
		profilePhoto = getRidget(IProfilePhotoRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_PHOTO);
		profilePhoto.bindToModel(EMFObservables
				.observeValue(editCustomer, ModelPackage.Literals.COMPANY__PROFILE_PHOTO));
		// profilePhoto.updateFromModel();

		// Configure address group
		final LocationProfileWidgetController addressGroupController = new LocationProfileWidgetController(this);
		addressGroupController.setInputModel(editCustomer.getLocation());
		addressGroupController.updateBinding();

		// Configure Communication Group
		IContactMethodsGroupRidget contacts = getRidget(IContactMethodsGroupRidget.class,
				IContactMethodsGroupRidget.WIDGET_ID);
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
