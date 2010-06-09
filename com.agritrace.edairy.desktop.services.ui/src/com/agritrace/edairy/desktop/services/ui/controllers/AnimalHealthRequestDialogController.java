package com.agritrace.edairy.desktop.services.ui.controllers;

import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.persistence.services.AlreadyExistsException;
import com.agritrace.edairy.desktop.common.persistence.services.NonExistingEntityException;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.FarmSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.services.ui.dialogs.ServiceRequestListDialog;

public class AnimalHealthRequestDialogController extends RecordDialogController<AnimalHealthRequest> {

	public class FarmLookupAction implements IActionListener {

		public FarmLookupAction(ITextRidget farmLookupText) {
			memberLookupText.bindToModel(AnimalHealthRequestDialogController.this, "selectedMember");
			farmLookupText.bindToModel(AnimalHealthRequestDialogController.this, "selectedFarm");
		}

		@Override
		public void callback() {
			FarmSearchDialog farmDialog = new FarmSearchDialog(null);
			int retVal = farmDialog.open();
			

		}

	}

	public class MemberLookupAction implements IActionListener {

		public MemberLookupAction(ITextRidget memberLookupText) {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void callback() {
			MemberSearchDialog memberDialog = new MemberSearchDialog(null);
			int retVal = memberDialog.open();
		}

	}

	private final class InseminationTypeChangeAction implements IActionListener {
		private final AnimalHealthRequest request;

		private InseminationTypeChangeAction(AnimalHealthRequest request) {
			this.request = request;
		}

		@Override
		public void callback() {
			// Update working copy first
			request.setType(RequestType.INSEMINATION);
			requestTypeChanged();
		}
	}

	private final class InseminationTypeConverter implements IConverter {
		private final AnimalHealthRequest request;

		private InseminationTypeConverter(AnimalHealthRequest request) {
			this.request = request;
		}

		@Override
		public Object getFromType() {
			return EMFObservables.observeValue(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE)
					.getValueType();
		}

		@Override
		public Object getToType() {
			return boolean.class;
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject instanceof RequestType) {
				return RequestType.INSEMINATION.equals(fromObject);

			}
			return null;
		}
	}

	private final class RequestTypeChangeAction implements IActionListener {
		private final AnimalHealthRequest request;
		private RequestTypeChangeAction(AnimalHealthRequest request) {
			this.request = request;
		}
		@Override
		public void callback() {
			request.setType(RequestType.VETERINARY);
			requestTypeChanged();
		}
	}

	private final class RequestTypeConverter implements IConverter {
		private final AnimalHealthRequest request;

		private RequestTypeConverter(AnimalHealthRequest request) {
			this.request = request;
		}

		@Override
		public Object getFromType() {
			return EMFObservables.observeValue(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE)
					.getValueType();
		}

		@Override
		public Object getToType() {
			return boolean.class;
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject instanceof RequestType) {
				return RequestType.VETERINARY.equals(fromObject);

			}
			return null;
		}
	}

	IDateTextRidget textRidget;
	private IActionRidget memberLookupButton;
	private IActionRidget farmLookupButton;
	private Membership selectedMember;
	private Farm selectedFarm;
	private ITextRidget memberLookupText;
	private ITextRidget farmLookupText;
	
	public AnimalHealthRequestDialogController() {
		super();
	}

	@Override
	public AnimalHealthRequest getWorkingCopy() {
		return (AnimalHealthRequest) getContext("editObject");
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();
		final AnimalHealthRequest request = getWorkingCopy();

		textRidget = getRidget(IDateTextRidget.class, ServiceRequestListDialog.BIND_ID_REQUEST_DATE_TEXT);
		textRidget.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		textRidget.bindToModel(PojoObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName()));
		textRidget.updateFromModel();

		// Request Type/Veterinary
		final IToggleButtonRidget veterinaryRadioBtn = getRidget(IToggleButtonRidget.class, "veterinary"); //$NON-NLS-1$
		//
		veterinaryRadioBtn.setModelToUIControlConverter(new RequestTypeConverter(request));

		// veterinaryRadioBtn.setOutputOnly(false);
		veterinaryRadioBtn.addListener(new RequestTypeChangeAction(request));
		veterinaryRadioBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		// RequestsPackage.Literals.REQUEST_TYPE));
		veterinaryRadioBtn.updateFromModel();
		// veterinaryRadioBtn.setOutputOnly(true);

		// Request Type/Insemination
		final IToggleButtonRidget insementationRadionBtn = getRidget(IToggleButtonRidget.class, "insemination"); //$NON-NLS-1$
		//
		insementationRadionBtn.setModelToUIControlConverter(new InseminationTypeConverter(request));
		// insementationRadionBtn.setOutputOnly(false);
		insementationRadionBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		// RequestsPackage.Literals.REQUEST_TYPE));
		insementationRadionBtn.addListener(new InseminationTypeChangeAction(request));
		insementationRadionBtn.updateFromModel();
		// insementationRadionBtn.setOutputOnly(true);
		
		memberLookupText = getRidget(ITextRidget.class, ServiceRequestListDialog.BIND_ID_MEMBER_TEXT );
		memberLookupButton = getRidget(IActionRidget.class, ServiceRequestListDialog.BIND_ID_MEMBER_BUTTON );
		memberLookupButton.addListener( new MemberLookupAction(memberLookupText) );

		farmLookupText = getRidget(ITextRidget.class, ServiceRequestListDialog.BIND_ID_FARM_TEXT );
		farmLookupButton = getRidget(IActionRidget.class, ServiceRequestListDialog.BIND_ID_FARM_BUTTON );
		farmLookupButton.addListener( new FarmLookupAction(farmLookupText) );

	}

	private void requestTypeChanged() {

		final AnimalHealthRequest request = getWorkingCopy();
		// UIChanges

		// Updates the bindings
		configTypeSpecificRidgets(request);

	}

	private void configTypeSpecificRidgets(final AnimalHealthRequest request) {

		// ICompositeRidget container =
		// getRidget(ICompositeRidget.class,
		// ServiceRequestListDialog.BIND_ID_SPECIFIC_CONTAINER);
		if (RequestType.INSEMINATION == request.getType()) {

			// Heated date
			final ITextRidget heatTimeTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_TIME_HEATED_DETECTED);
			heatTimeTextBtn.setDirectWriting(true);
			heatTimeTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			// heatTimeTextBtn.setOutputOnly(false);
			heatTimeTextBtn.bindToModel(request,
					RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED.getName());
			heatTimeTextBtn.updateFromModel();
			// heatTimeTextBtn.setOutputOnly(true);

			// First
			final ITextRidget firstTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_FIRST_TRETMENT);
			firstTextBtn.setDirectWriting(true);
			firstTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			// firstTextBtn.setOutputOnly(false);
			firstTextBtn
					.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT.getName());

			firstTextBtn.updateFromModel();
			// firstTextBtn.setOutputOnly(true);

			// Second
			final ITextRidget secondTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_SECOND_TRETMENT);
			secondTextBtn.setDirectWriting(true);
			secondTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			// secondTextBtn.setOutputOnly(false);
			secondTextBtn.bindToModel(request,
					RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT.getName());

			secondTextBtn.updateFromModel();
			// secondTextBtn.setOutputOnly(true);

			// Third
			final ITextRidget thirdTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_THIRD_TRETMENT);
			thirdTextBtn.setDirectWriting(true);
			thirdTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			thirdTextBtn.setOutputOnly(false);
			thirdTextBtn
					.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT.getName());

			thirdTextBtn.updateFromModel();
			// thirdTextBtn.setOutputOnly(true);

		} else {
			// Complaint
			// Third
			final ITextRidget complaintTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_VERY_THIRD_COMPLAINT);
			complaintTextBtn.addPropertyChangeListener(ITextRidget.PROPERTY_TEXT, new PropertyChangeListener() {

				@Override
				public void propertyChange(java.beans.PropertyChangeEvent arg0) {

					request.setReportedProblem(arg0.getNewValue().toString());

				}

			}

			);
			// complaintTextBtn.setOutputOnly(false);
			complaintTextBtn.bindToModel(request,
					RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM.getName());
			complaintTextBtn.updateFromModel();
			// complaintTextBtn.setOutputOnly(true);
		}

	}

	@Override
	protected EClass getEClass() {
		return RequestsPackage.eINSTANCE.getAnimalHealthRequest();
	}

	@Override
	protected void saveNew() throws AlreadyExistsException {

	}

	@Override
	protected void saveUpdated() throws NonExistingEntityException {
	}

}
