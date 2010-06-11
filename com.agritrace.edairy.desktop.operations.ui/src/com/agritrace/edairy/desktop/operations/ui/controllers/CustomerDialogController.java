package com.agritrace.edairy.desktop.operations.ui.controllers;

import java.util.Collection;

import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.util.Assert;
import org.eclipse.riena.core.marker.IMarker;
import org.eclipse.riena.ui.core.marker.IMessageMarker;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.validation.RequiredField;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Customer;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.common.ui.controllers.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerStatus;
import com.agritrace.edairy.desktop.common.ui.reference.CustomerType;
import com.agritrace.edairy.desktop.operations.ui.dialogs.CustomerBindingConstants;

public class CustomerDialogController extends RecordDialogController<Customer> {

	private Customer editCustomer = null;

	ITextRidget customerId;
	IComboRidget customerStatus;
	ITextRidget companyName;
	ITextRidget legalName;
	IComboRidget customerType;
	ITextRidget customerDescription;

	private ITextRidget companyPhone;

	@Override
	public void configureUserRidgets() {
		
		// ensure model available
		editCustomer = getWorkingCopy();
		assert(null != editCustomer);

		// customer id
		customerId = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_ID);
		customerId.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__COMPANY_ID));
		customerId.setOutputOnly(true);
		
		// customer status
		customerStatus = getRidget(IComboRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMER_STATUS);
		customerStatus.bindToModel(
				Observables.staticObservableList(CustomerStatus.getCustomerStatusList()), 
				CustomerStatus.class, 
				null, 
				EMFObservables.observeValue(editCustomer, DairyPackage.Literals.CUSTOMER__STATUS));
		customerStatus.updateFromModel();
		customerStatus.setSelection(0);
		
		// company name
		companyName = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_COMPANY_NAME);
		companyName.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__COMPANY_NAME));
		companyName.setMandatory(true);
		companyName.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		companyName.updateFromModel();
		
		// company phone
		companyPhone = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_PHONE_NUMBER);
		companyPhone.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__PHONE_NUMBER));
		companyPhone.setMandatory(true);
		companyPhone.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		companyPhone.updateFromModel();
		
		// company legal name
		legalName = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_LEGAL_NAME);
		legalName.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__LEGAL_NAME));
//		legalName.setMandatory(true);
//		legalName.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		legalName.updateFromModel();
		
		// customer type
		customerType = getRidget(IComboRidget.class, CustomerBindingConstants.BIND_ID_CUSTOMERTYPE);
		customerType.bindToModel(
				Observables.staticObservableList(CustomerType.getCustomerTypeList()), 
				CustomerType.class, 
				null, 
				EMFObservables.observeValue(editCustomer, DairyPackage.Literals.CUSTOMER__CUSTOMER_TYPE));
		customerType.updateFromModel();
		customerType.setSelection(0);

		// description
		customerDescription = getRidget(ITextRidget.class, CustomerBindingConstants.BIND_ID_DESCRIPTION);
		customerDescription.bindToModel(EMFObservables.observeValue(editCustomer, ModelPackage.Literals.COMPANY__DESCRIPTION));
		customerDescription.setDirectWriting(true);			// otherwise validation doesn't work well..		
		customerDescription.setMandatory(true);
		customerDescription.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		customerDescription.updateFromModel();
		
		
		// Configure address group
		AddressGroupWidgetController addressGroupController = new AddressGroupWidgetController(this);
		addressGroupController.setInputModel(editCustomer.getLocation().getPostalLocation());
		addressGroupController.updateBinding();

		
		// Configure Direction Group
		DirectionGroupController directionController = new DirectionGroupController(this);
		directionController.setInputModel(editCustomer.getLocation().getDescriptiveLocation());
		directionController.updateBinding();

		
		// Configure Map Group
		MapGroupController mapController = new MapGroupController(this);
		mapController.setInputModel(editCustomer.getLocation().getMapLocation());
		mapController.updateBinding();

		
		// Configure Communication Group
		CommunicationGroupController commController = new CommunicationGroupController(this);
		commController.setInputModel(editCustomer);
		commController.updateBinding();		
	}

	
	@Override
	protected EClass getEClass() {
		return DairyPackage.Literals.CUSTOMER;
	}

	@Override
	public Customer getWorkingCopy() {
		return (Customer) getContext("editObject");
	}

//	@Override
//	protected void saveNew() throws AlreadyExistsException {
//		// prevent saving in dialog
//	}
//
//	@Override
//	protected void saveUpdated() throws NonExistingEntityException {
//		// prevent saving in dialog
//	}

}
