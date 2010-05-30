package com.agritrace.edairy.desktop.services.ui.controllers;

import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.ui.controllers.LookupControllerDelegate;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.services.ui.dialogs.ServiceRequestListDialog;

public class ServiceRecordDialogController extends RecordDialogController {

	public ServiceRecordDialogController() {
		super();
	}

	public void configureRidgets() {
		super.configureRidgets();
		final AnimalHealthRequest request = (AnimalHealthRequest) getWorkingCopy();
		// ITextRidget memberIdText = getRidget(ITextRidget.class,
		//						ServiceRequestListDialog.BIND_ID_MEMBER_ID); //$NON-NLS-1$
		// memberIdText.setDirectWriting(true);
		// memberIdText.setOutputOnly(false);
		// memberIdText.bindToModel(request.getRequestingMember(),
		// DairyPackage.Literals.MEMBERSHIP__MEMBER_ID.getName());
		// memberIdText.updateFromModel();
		//
		// memberIdText.setOutputOnly(true);

		//
		// ITextRidget textDate = getRidget(ITextRidget.class,
		// ServiceRequestListDialog.BIND_ID_REQUEST_DATE_TEXT);
		// textDate.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
		// // /textDate.setOutputOnly(false);
		// textDate.bindToModel(request,
		// RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE
		// .getName());
		// textDate.updateFromModel();
		// Start date
		LookupControllerDelegate delegate = new LookupControllerDelegate(this,
				PojoObservables.observeValue(request,
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE
								.getName()),
				ServiceRequestListDialog.BIND_ID_REQUEST_DATE_TEXT,
				ServiceRequestListDialog.BIND_ID_REQUEST_DATE_BUTTON);
		delegate.configureRidgets();

		// // Configure Member name
		// ITextRidget txtMemberName = getRidget(ITextRidget.class,
		// ServiceRequestListDialog.BIND_ID_MEMBER_NAME);
		// txtMemberName.setDirectWriting(true);
		// txtMemberName.setOutputOnly(false);
		// txtMemberName.setModelToUIControlConverter(new IConverter() {
		//
		// @Override
		// public Object getFromType() {
		// return EMFObservables.observeValue(
		// request.getRequestingMember(),
		// DairyPackage.Literals.MEMBERSHIP__MEMBER)
		// .getValueType();
		// }
		//
		// @Override
		// public Object getToType() {
		// return String.class;
		// }
		//
		// @Override
		// public Object convert(Object fromObject) {
		// if (fromObject instanceof Person) {
		// return ((Person) fromObject).getGivenName() + " "
		// + ((Person) fromObject).getFamilyName();
		// }
		// return null;
		// }
		// });
		// txtMemberName.bindToModel(EMFObservables.observeValue(request
		// .getRequestingMember(),
		// DairyPackage.Literals.MEMBERSHIP__MEMBER));
		//
		// txtMemberName.updateFromModel();
		// txtMemberName.setOutputOnly(true);
		// // Farm Location
		// IComboRidget farmCombo = getRidget(IComboRidget.class,
		// ServiceRequestListDialog.BIND_ID_FARM);
		// farmCombo.setOutputOnly(false);
		// farmCombo.setModelToUIControlConverter(new IConverter() {
		//
		// @Override
		// public Object getFromType() {
		// return EMFObservables
		// .observeValue(
		// request,
		// RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM)
		// .getValueType();
		// }
		//
		// @Override
		// public Object getToType() {
		// return String.class;
		// }
		//
		// @Override
		// public Object convert(Object fromObject) {
		// if (fromObject instanceof Farm) {
		// Farm farm = (Farm) fromObject;
		// return farm.getName();
		//
		// }
		// return null;
		// }
		// });
		// if (request.getRequestingMember() != null) {
		// farmCombo.bindToModel(new WritableList(request
		// .getRequestingMember().getFarms(), Farm.class),
		// Farm.class, "name", new WritableValue(request
		// .getFarm(), Farm.class));
		// }
		// farmCombo.updateFromModel();
		// //
		// Request Type/Veterinary
		IToggleButtonRidget veterinaryRadioBtn = getRidget(
				IToggleButtonRidget.class, "veterinary"); //$NON-NLS-1$
		//
		veterinaryRadioBtn.setModelToUIControlConverter(new IConverter() {

			@Override
			public Object getFromType() {
				return EMFObservables.observeValue(request,
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE)
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
		});
		// veterinaryRadioBtn.setOutputOnly(false);
		veterinaryRadioBtn.addListener(new IActionListener() {

			@Override
			public void callback() {

				request.setType(RequestType.VETERINARY);
				requestTypeChanged();

			}
		});
		veterinaryRadioBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		// RequestsPackage.Literals.REQUEST_TYPE));
		veterinaryRadioBtn.updateFromModel();
		// veterinaryRadioBtn.setOutputOnly(true);

		// Request Type/Insementation
		IToggleButtonRidget insementationRadionBtn = getRidget(
				IToggleButtonRidget.class, "insemination"); //$NON-NLS-1$
		//
		insementationRadionBtn.setModelToUIControlConverter(new IConverter() {

			@Override
			public Object getFromType() {
				return EMFObservables.observeValue(request,
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE)
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
		});
		// insementationRadionBtn.setOutputOnly(false);
		insementationRadionBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		// RequestsPackage.Literals.REQUEST_TYPE));
		insementationRadionBtn.addListener(new IActionListener() {

			@Override
			public void callback() {
				// Update working copy first
				request.setType(RequestType.INSEMINATION);
				requestTypeChanged();

			}
		});
		insementationRadionBtn.updateFromModel();
		// insementationRadionBtn.setOutputOnly(true);

	}

	private void requestTypeChanged() {

		final AnimalHealthRequest request = (AnimalHealthRequest) getWorkingCopy();
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
			ITextRidget heatTimeTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_TIME_HEATED_DETECTED);
			heatTimeTextBtn.setDirectWriting(true);
			heatTimeTextBtn
					.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			// heatTimeTextBtn.setOutputOnly(false);
			heatTimeTextBtn
					.bindToModel(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED
									.getName());
			heatTimeTextBtn.updateFromModel();
			// heatTimeTextBtn.setOutputOnly(true);

			// First
			ITextRidget firstTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_FIRST_TRETMENT);
			firstTextBtn.setDirectWriting(true);
			firstTextBtn
					.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			// firstTextBtn.setOutputOnly(false);
			firstTextBtn
					.bindToModel(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT
									.getName());

			firstTextBtn.updateFromModel();
			// firstTextBtn.setOutputOnly(true);

			// Second
			ITextRidget secondTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_SECOND_TRETMENT);
			secondTextBtn.setDirectWriting(true);
			secondTextBtn
					.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			// secondTextBtn.setOutputOnly(false);
			secondTextBtn
					.bindToModel(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT
									.getName());

			secondTextBtn.updateFromModel();
			// secondTextBtn.setOutputOnly(true);

			// Third
			ITextRidget thirdTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_INSE_THIRD_TRETMENT);
			thirdTextBtn.setDirectWriting(true);
			thirdTextBtn
					.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
			thirdTextBtn.setOutputOnly(false);
			thirdTextBtn
					.bindToModel(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT
									.getName());

			thirdTextBtn.updateFromModel();
			// thirdTextBtn.setOutputOnly(true);

		} else {
			// Complaint
			// Third
			ITextRidget complaintTextBtn = getRidget(ITextRidget.class,
					ServiceRequestListDialog.BIND_ID_VERY_THIRD_COMPLAINT);
			complaintTextBtn.addPropertyChangeListener(
					ITextRidget.PROPERTY_TEXT, new PropertyChangeListener() {

						@Override
						public void propertyChange(
								java.beans.PropertyChangeEvent arg0) {

							request.setReportedProblem(arg0.getNewValue()
									.toString());

						}

					}

			);
			// complaintTextBtn.setOutputOnly(false);
			complaintTextBtn
					.bindToModel(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM
									.getName());
			complaintTextBtn.updateFromModel();
			// complaintTextBtn.setOutputOnly(true);
		}

	}

	@Override
	protected void saveNew() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void saveUpdated() {
		// TODO Auto-generated method stub

	}

	@Override
	protected EClass getEClass() {
		return RequestsPackage.eINSTANCE.getAnimalHealthRequest();
	}

	@Override
	protected EObject createWorkingCopy() {
		return EMFUtil.createWorkingCopy(this.getEClass(), 2);
	}

}
// controller.addListener(new IActionListener() {
//
// @Override
// public void callback() {
// if (getSelectedEObject()!=null)
// {
// EMFUtil.copy(getWorkingCopy(), getSelectedEObject(), 3);
// }
//
// }
// });

