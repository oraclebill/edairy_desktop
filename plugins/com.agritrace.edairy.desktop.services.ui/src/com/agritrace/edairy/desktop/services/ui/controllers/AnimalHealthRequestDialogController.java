package com.agritrace.edairy.desktop.services.ui.controllers;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.window.Window;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDateTextRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.dialogs.FarmSearchDialog;
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberSearchDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.services.ui.dialogs.AnimalHealthRequestDialog;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Dialog controller for Animal Health Request
 *
 * @author Hui(Spark) Wan
 *
 */
public class AnimalHealthRequestDialogController extends RecordDialogController<AnimalHealthRequest> {

	public class FarmLookupAction implements IActionListener {
		@Override
		public void callback() {
			final FarmSearchDialog farmDialog = farmSearchDialogProvider.get();
			farmDialog.setSelectedMember(request.getRequestingMember());

			final int retVal = farmDialog.open();
			if (retVal == Window.OK) {
				final Farm farm = farmDialog.getSelectedFarm();
				request.setFarm(farm);
				// // FIXME: fix.
				// try {
				// Farmer farmer= (Farmer)farm.eContainer();
				// }
				// catch(Exception e) {
				// e.printStackTrace();
				// }
				farmLookupText.updateFromModel();
			}
		}
	}

	public class MemberLookupAction implements IActionListener {
		@Override
		public void callback() {
			final MemberSearchDialog memberDialog = memberSearchDialogProvider.get();
			memberDialog.setSelectedMember(request.getRequestingMember());
			memberDialog.setSelectedFarm(request.getFarm());
			final int retVal = memberDialog.open();
			if (retVal == Window.OK) {
				request.setRequestingMember(memberDialog.getSelectedMember());
				memberLookupText.updateFromModel();
			}
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

	private final class InseminationTypeConverter extends Converter {
		private InseminationTypeConverter(AnimalHealthRequest request) {
			super(EMFObservables.observeValue(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE)
					.getValueType(), boolean.class);
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
			request.setType(RequestType.CLINICAL);
			requestTypeChanged();
		}
	}

	private final class RequestTypeConverter extends Converter {

		private RequestTypeConverter(AnimalHealthRequest request) {
			super(EMFObservables.observeValue(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE)
					.getValueType(), boolean.class);
		}

		@Override
		public Object convert(Object fromObject) {
			if (fromObject instanceof RequestType) {
				return RequestType.CLINICAL.equals(fromObject);
			}
			return null;
		}
	}

	@Inject
	private Provider<FarmSearchDialog> farmSearchDialogProvider;
	@Inject
	private Provider<MemberSearchDialog> memberSearchDialogProvider;

	private IActionRidget farmLookupButton;
	private ITextRidget farmLookupText;
	private final List<IActionListener> listeners = new ArrayList<IActionListener>();
	private IActionRidget memberLookupButton;
	private ITextRidget memberLookupText;
	private AnimalHealthRequest request;

	IDateTimeRidget textRidget;

	public void addListener(IActionListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void configureUserRidgets() {
		request = getWorkingCopy();

		textRidget = getRidget(IDateTimeRidget.class, AnimalHealthRequestDialog.BIND_ID_REQUEST_DATE_TEXT);
		textRidget.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName());
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

		memberLookupText = getRidget(ITextRidget.class, AnimalHealthRequestDialog.BIND_ID_MEMBER_TEXT);
		memberLookupText.setModelToUIControlConverter(new Member2StringConverter());
		memberLookupText.bindToModel(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER.getName());
		memberLookupText.setOutputOnly(true);
		memberLookupText.setMandatory(true);
		memberLookupText.updateFromModel();

		memberLookupButton = getRidget(IActionRidget.class, AnimalHealthRequestDialog.BIND_ID_MEMBER_BUTTON);
		memberLookupButton.addListener(new MemberLookupAction());

		farmLookupText = getRidget(ITextRidget.class, AnimalHealthRequestDialog.BIND_ID_FARM_TEXT);
		farmLookupText.setModelToUIControlConverter(new Farm2StringConverter());
		farmLookupText.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName());
		farmLookupText.setOutputOnly(true);
		farmLookupText.setMandatory(true);
		farmLookupText.updateFromModel();

		farmLookupButton = getRidget(IActionRidget.class, AnimalHealthRequestDialog.BIND_ID_FARM_BUTTON);
		farmLookupButton.addListener(new FarmLookupAction());

		// Type changed
		requestTypeChanged();

	}

	@Override
	public AnimalHealthRequest getWorkingCopy() {
		return (AnimalHealthRequest) getContext("editObject");
	}

	private void configTypeSpecificRidgets(final AnimalHealthRequest request) {

		if (RequestType.INSEMINATION == request.getType()) {

			// Heated date
			final IDateTextRidget heatTimeTextBtn = getRidget(IDateTextRidget.class,
					AnimalHealthRequestDialog.BIND_ID_INSE_TIME_HEATED_DETECTED);
			if (heatTimeTextBtn == null) {
				return;
			}
			heatTimeTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			heatTimeTextBtn.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
			// heatTimeTextBtn.setOutputOnly(false);
			heatTimeTextBtn.bindToModel(request,
					RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED.getName());
			heatTimeTextBtn.updateFromModel();
			// heatTimeTextBtn.setOutputOnly(true);

			// First
			final IDateTextRidget firstTextBtn = getRidget(IDateTextRidget.class,
					AnimalHealthRequestDialog.BIND_ID_INSE_FIRST_TRETMENT);
			firstTextBtn.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
			firstTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			firstTextBtn
					.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT.getName());

			firstTextBtn.updateFromModel();

			// Second
			final IDateTextRidget secondTextBtn = getRidget(IDateTextRidget.class,
					AnimalHealthRequestDialog.BIND_ID_INSE_SECOND_TRETMENT);
			secondTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			secondTextBtn.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
			// secondTextBtn.setOutputOnly(false);
			secondTextBtn.bindToModel(request,
					RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT.getName());

			secondTextBtn.updateFromModel();

			// Third
			final IDateTextRidget thirdTextBtn = getRidget(IDateTextRidget.class,
					AnimalHealthRequestDialog.BIND_ID_INSE_THIRD_TRETMENT);
			thirdTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			thirdTextBtn.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
			thirdTextBtn
					.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT.getName());

			thirdTextBtn.updateFromModel();

		} else {
			// Complaint
			// Third
			final ITextRidget complaintTextBtn = getRidget(ITextRidget.class,
					AnimalHealthRequestDialog.BIND_ID_VERY_THIRD_COMPLAINT);
			if (complaintTextBtn == null) {
				return;
			}
			complaintTextBtn.addPropertyChangeListener(ITextRidget.PROPERTY_TEXT, new PropertyChangeListener() {

				@Override
				public void propertyChange(java.beans.PropertyChangeEvent arg0) {

					request.setReportedProblem(arg0.getNewValue().toString());

				}

			}

			);
			complaintTextBtn.bindToModel(request,
					RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM.getName());
			complaintTextBtn.updateFromModel();
		}

	}

	//
	// @Override
	// protected EClass getEClass() {
	// return RequestsPackage.eINSTANCE.getAnimalHealthRequest();
	// }
	private void requestTypeChanged() {

		final AnimalHealthRequest request = getWorkingCopy();
		// UIChanges
		notifySaveListeners();
		// Updates the bindings
		configTypeSpecificRidgets(request);

	}

	protected void notifySaveListeners() {
		for (final IActionListener listener : this.listeners) {
			listener.callback();
		}
	}

}
