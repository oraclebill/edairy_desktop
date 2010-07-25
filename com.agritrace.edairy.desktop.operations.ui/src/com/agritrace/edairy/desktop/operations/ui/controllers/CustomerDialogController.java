package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Arrays;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.reference.CompanyStatus;
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

		// customer id
		customerId = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_ID);
		customerId.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__COMPANY_ID));
		customerId.setOutputOnly(true);

		// customer status
		customerStatus = getRidget(IComboRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_STATUS);
		customerStatus.bindToModel(Observables.staticObservableList(CompanyStatus.getCustomerStatusList()),
				CompanyStatus.class, null,
				EMFObservables.observeValue(editCustomer, DairyPackage.Literals.CUSTOMER__STATUS));
		customerStatus.updateFromModel();
		customerStatus.setSelection(0);

		// company name
		companyName = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_COMPANY_NAME);
		companyName.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__COMPANY_NAME));
		companyName.setMandatory(true);
//		companyName.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		companyName.updateFromModel();

		// company phone
		companyPhone = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_PHONE_NUMBER);
		companyPhone
				.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__PHONE_NUMBER));
		companyPhone.setMandatory(true);
//		companyPhone.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		companyPhone.updateFromModel();

		// company legal name
		legalName = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_LEGAL_NAME);
		legalName.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__LEGAL_NAME));
		// legalName.setMandatory(true);
		// legalName.addValidationRule(new RequiredField(),
		// ValidationTime.ON_UPDATE_TO_MODEL);
		legalName.updateFromModel();

		// customer type
		customerType = getRidget(IComboRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMERTYPE);
		customerType.bindToModel(Observables.staticObservableList(Arrays.asList(CUSTOMER_TYPES)),
				String.class, null,
				EMFObservables.observeValue(editCustomer, DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE));
//		customerType.setSelection(0);

		// description
		customerDescription = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_DESCRIPTION);
		customerDescription.bindToModel(EMFObservables.observeValue(editCustomer,
				ModelPackage.Literals.COMPANY__DESCRIPTION));
		customerDescription.setDirectWriting(true); // otherwise validation
													// doesn't work well..
		customerDescription.setMandatory(true);
//		customerDescription.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		customerDescription.updateFromModel();

		
		profilePhoto = getRidget(IProfilePhotoRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_PHOTO);
		profilePhoto.bindToModel(EMFObservables.observeValue(editCustomer,
				ModelPackage.Literals.COMPANY__PROFILE_PHOTO));
//		profilePhoto.updateFromModel();
		
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
//		final CommunicationGroupController commController = new CommunicationGroupController(this);
//		commController.setInputModel(editCustomer);
//		commController.updateBinding();
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
		customerType.updateFromModel();
		profilePhoto.updateFromModel();
	}
}
