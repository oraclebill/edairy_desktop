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
import com.agritrace.edairy.desktop.common.ui.dialogs.MemberLookupDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.services.ui.dialogs.AnimalHealthRequestDialog;
import com.google.inject.Inject;

/**
 * Dialog controller for Animal Health Request
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class AnimalHealthRequestDialogController extends RecordDialogController<AnimalHealthRequest> {


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

	private IActionRidget farmLookupButton;
	private ITextRidget farmLookupText;
	private final List<IActionListener> listeners = new ArrayList<IActionListener>();
	private IActionRidget memberLookupButton;
	private ITextRidget memberLookupText;
	private AnimalHealthRequest request;

	IDateTimeRidget textRidget;

	@Inject
	MemberLookupDialog memberLookupDialog;

	@Inject
	FarmSearchDialog farmLookupDialog;

	public AnimalHealthRequestDialogController() {
		super("AnimalHealthRequest");
	}

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
		veterinaryRadioBtn.setModelToUIControlConverter(new RequestTypeConverter(request));
		veterinaryRadioBtn.addListener(new IActionListener() {
			@Override
			public void callback() {
				request.setType(RequestType.CLINICAL);
				requestTypeChanged();
			}
		});
		veterinaryRadioBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		veterinaryRadioBtn.updateFromModel();

		// Request Type/Insemination
		final IToggleButtonRidget insementationRadionBtn = getRidget(IToggleButtonRidget.class, "insemination"); //$NON-NLS-1$
		insementationRadionBtn.setModelToUIControlConverter(new InseminationTypeConverter(request));
		insementationRadionBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		insementationRadionBtn.addListener(new IActionListener() {
			@Override
			public void callback() {
				request.setType(RequestType.INSEMINATION);
				requestTypeChanged();
			}
		});

		insementationRadionBtn.updateFromModel();

		memberLookupText = getRidget(ITextRidget.class, AnimalHealthRequestDialog.BIND_ID_MEMBER_TEXT);
		memberLookupText.setModelToUIControlConverter(new Member2StringConverter());
		memberLookupText.bindToModel(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER.getName());
		memberLookupText.setOutputOnly(true);
		memberLookupText.setMandatory(true);
		memberLookupText.updateFromModel();

		memberLookupButton = getRidget(IActionRidget.class, AnimalHealthRequestDialog.BIND_ID_MEMBER_BUTTON);
		memberLookupButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				doMemberLookup();
			}

		});

		farmLookupText = getRidget(ITextRidget.class, AnimalHealthRequestDialog.BIND_ID_FARM_TEXT);
		farmLookupText.setModelToUIControlConverter(new Farm2StringConverter());
		farmLookupText.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName());
		farmLookupText.setOutputOnly(true);
		farmLookupText.setMandatory(true);
		farmLookupText.updateFromModel();

		farmLookupButton = getRidget(IActionRidget.class, AnimalHealthRequestDialog.BIND_ID_FARM_BUTTON);
		farmLookupButton.addListener(new IActionListener() {
			@Override
			public void callback() {
				doFarmLookup();
			}
		});

		// Type changed
		requestTypeChanged();
	}

	private void configureGeneralComplaintPanel(final AnimalHealthRequest request) {
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
		});
		complaintTextBtn.bindToModel(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM.getName());
		complaintTextBtn.updateFromModel();
	}

	private void configureInseminationPanel(final AnimalHealthRequest request) {
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
		firstTextBtn.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT.getName());

		firstTextBtn.updateFromModel();

		// Second
		final IDateTextRidget secondTextBtn = getRidget(IDateTextRidget.class,
				AnimalHealthRequestDialog.BIND_ID_INSE_SECOND_TRETMENT);
		secondTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		secondTextBtn.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		// secondTextBtn.setOutputOnly(false);
		secondTextBtn.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT.getName());

		secondTextBtn.updateFromModel();

		// Third
		final IDateTextRidget thirdTextBtn = getRidget(IDateTextRidget.class,
				AnimalHealthRequestDialog.BIND_ID_INSE_THIRD_TRETMENT);
		thirdTextBtn.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		thirdTextBtn.setFormat(DateTimeUtils.DEFAULT_DATE_PATTERN);
		thirdTextBtn.bindToModel(request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT.getName());

		thirdTextBtn.updateFromModel();
	}

	private void requestTypeChanged() {

		final AnimalHealthRequest request = getWorkingCopy();
		// UIChanges
		notifySaveListeners();

		// Updates the bindings
		if (RequestType.INSEMINATION == request.getType()) {
			configureInseminationPanel(request);
		} else {
			configureGeneralComplaintPanel(request);
		}

	}

	private void doMemberLookup() {
		memberLookupDialog.setSelectedFarm(request.getFarm());
		if (memberLookupDialog.open() == Window.OK) {
			request.setRequestingMember(memberLookupDialog.getSelectedMember());
			memberLookupText.updateFromModel();
		}
	}

	private void doFarmLookup() {
		farmLookupDialog.setSelectedMember(request.getRequestingMember());
		if (farmLookupDialog.open() == Window.OK) {
			final Farm farm = farmLookupDialog.getSelectedFarm();
			request.setFarm(farm);
			farmLookupText.updateFromModel();
		}
	}

	protected void notifySaveListeners() {
		for (final IActionListener listener : this.listeners) {
			listener.callback();
		}
	}

}
