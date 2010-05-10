package com.agritrace.edairy.service.ui.controllers;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.requests.RequestsPackage;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.service.ui.converters.DateToStringModelConvertor;
import com.agritrace.edairy.service.ui.converters.StringToStringModelConverter;
import com.agritrace.edairy.service.ui.views.ServiceRequestLogView;
import com.agritrace.edairy.service.ui.views.ServiceRequestMasterDetailComposite;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;

/**
 * Master-detail controller delegate
 * 
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestLogMasterDetailControllerDelegate extends
		SubModuleControllerDelegate {

	public static String[] MASTER_PROPTIES = {
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUEST_ID
					.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER
					.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE.getName() };
	public static String[] MASTER_HEADERS = { "ID", "Date", "Member", "Farm",
			"Type" };

	public ServiceRequestLogMasterDetailControllerDelegate(
			SubModuleController controller) {
		super(controller);
	}

	@Override
	public void configureRidgets() {
		final IMasterDetailsRidget master = getRidget(
				IMasterDetailsRidget.class,
				ServiceRequestLogView.BIND_ID_MASTER);

		if (master != null) {
			master.setDelegate(new ServiceRequestDelegate());
			WritableList input;
			input = new WritableList(((ServiceLogViewController) this
					.getSubModuleController()).getFilteredResult(),
					AnimalHealthRequest.class);
			master.bindToModel(input, AnimalHealthRequest.class,
					MASTER_PROPTIES, MASTER_HEADERS);
			master.updateFromModel();

		}
	}

	private void updateRidgets() {
		final IMasterDetailsRidget master = getRidget(
				IMasterDetailsRidget.class,
				ServiceRequestLogView.BIND_ID_MASTER); 

		if (master != null && master.getDelegate() != null) {

			WritableList input;
			input = new WritableList(((ServiceLogViewController) this
					.getSubModuleController()).getFilteredResult(),
					AnimalHealthRequest.class);
			master.bindToModel(input, AnimalHealthRequest.class,
					MASTER_PROPTIES, MASTER_HEADERS);
			master.updateFromModel();

			updateDetailBindings(null);
		}

	}

	/**
	 * A IMasterDetailsDelegate for service request.
	 */
	private final class ServiceRequestDelegate extends
			AbstractMasterDetailsDelegate {

		private final AnimalHealthRequest workingCopy = createWorkingCopy();

		@Override
		public void configureRidgets(IRidgetContainer container) {

			// Configure column formatter for table ridget
			ITableRidget masterTable = container != null ? (ITableRidget) container
					.getRidget(ITableRidget.class,
							AbstractMasterDetailsComposite.BIND_ID_TABLE)
					: getRidget(ITableRidget.class,
							AbstractMasterDetailsComposite.BIND_ID_TABLE);

			// Configure column formatter
			if (masterTable != null) {

				// Date column
				masterTable.setColumnFormatter(1, new ColumnFormatter() {

					@Override
					public String getText(Object element) {
						if (element instanceof AnimalHealthRequest) {
							return ServiceUtils.DATE_FORMAT
									.format(((AnimalHealthRequest) element)
											.getDate());
						}
						return null;
					}

				});
				// Member column
				masterTable.setColumnFormatter(2, new ColumnFormatter() {

					@Override
					public String getText(Object element) {
						if (element instanceof AnimalHealthRequest) {
							String name = ((AnimalHealthRequest) element)
									.getRequestingMember().getMember()
									.getName();
							return name == null ? "" : name;
						}
						return null;
					}

				});
				// Farm column
				masterTable.setColumnFormatter(3, new ColumnFormatter() {

					@Override
					public String getText(Object element) {
						if (element instanceof AnimalHealthRequest) {
							String name = ((AnimalHealthRequest) element)
									.getFarm().getName();
							return name == null ? "" : name;
						}
						return null;
					}

				});

				// Type column
				masterTable.setColumnFormatter(4, new ColumnFormatter() {

					@Override
					public String getText(Object element) {
						if (element instanceof AnimalHealthRequest) {
							String name = ((AnimalHealthRequest) element)
									.getType().toString();
							return name == null ? "" : name;
						}
						return null;
					}

				});

			}
		}

		@Override
		public void itemSelected(Object newSelection) {

			super.itemSelected(newSelection);
			if (newSelection instanceof AnimalHealthRequest) {
				AnimalHealthRequest request = (AnimalHealthRequest) newSelection;
				// Notify the UI control
				ServiceRequestMasterDetailComposite mdComposite =
				(ServiceRequestMasterDetailComposite) getRidget(
						IMasterDetailsRidget.class, ServiceRequestLogView.BIND_ID_MASTER).getUIControl();
				if (mdComposite != null) {
					mdComposite.updateUI(request);
				}
				// Updates the bindings
				updateDetailBindings(request);	
			}

		}

		@Override
		public AnimalHealthRequest copyBean(Object source, Object target) {
			AnimalHealthRequest from = source != null ? (AnimalHealthRequest) source
					: createWorkingCopy();
			AnimalHealthRequest to = target != null ? (AnimalHealthRequest) target
					: createWorkingCopy();
			// EcoreUtil.Copier copier = new Copier();
			// AnimalHealthRequest to = (AnimalHealthRequest) copier.copy(from);
			// copier.copyReferences();
			copy(from, to);
			to.setRequestingMember(from.getRequestingMember());

			return to;
		}

		private void copy(EObject source, EObject target) {
			EClass eClass = source.eClass();
			EClass toClass = source.eClass();
			for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i) {
				EStructuralFeature eStructuralFeature = eClass
						.getEStructuralFeature(i);

				target.eSet(eStructuralFeature, source.eGet(eStructuralFeature));

			}
		}

		@Override
		public AnimalHealthRequest createWorkingCopy() {
			return RequestsFactory.eINSTANCE.createAnimalHealthRequest(); 
		}

		@Override
		public AnimalHealthRequest getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			return false;
		}

		@Override
		public String isValid(IRidgetContainer container) {
			return null;
		}
	}

	private void updateDetailBindings(final AnimalHealthRequest request) {

		if (request == null) {
			
			// Date
			ITextRidget textDate = getRidget(ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_REQUEST_DATE); 
			
			textDate.setOutputOnly(false);
			textDate.setText("");
			textDate.setOutputOnly(true);
			
			// Member ID
			ITextRidget memberIdText = getRidget(ITextRidget.class, ServiceRequestMasterDetailComposite.BIND_ID_MEMBER_ID); //$NON-NLS-1$
			memberIdText.setOutputOnly(false);
			memberIdText.setText("");
			memberIdText.setOutputOnly(true);
			
			// Member Name
			ITextRidget memberNameText = getRidget(ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_MEMBER_NAME); //$NON-NLS-1$
			memberNameText.setOutputOnly(false);
			memberNameText.setText("");
			memberNameText.setOutputOnly(true);
			
			// Farm Name
			ITextRidget farmText = getRidget(ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_FARM_NAME); //$NON-NLS-1$
			farmText.setOutputOnly(false);
			farmText.setText("");
			farmText.setOutputOnly(true);
			
			return;
		}
		ITextRidget memberIdText = getRidget(ITextRidget.class,
				ServiceRequestMasterDetailComposite.BIND_ID_MEMBER_ID); //$NON-NLS-1$
		memberIdText.setDirectWriting(true);
		memberIdText
				.setModelToUIControlConverter(new StringToStringModelConverter(
						request.getRequestingMember(),
						DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
		memberIdText.setOutputOnly(false);
		memberIdText.bindToModel(EMFObservables.observeValue(request
				.getRequestingMember(),
				DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
		memberIdText.updateFromModel();

		memberIdText.setOutputOnly(true);
		//
		ITextRidget textDate = getRidget(ITextRidget.class,
				ServiceRequestMasterDetailComposite.BIND_ID_REQUEST_DATE);
		textDate.setModelToUIControlConverter(new DateToStringModelConvertor(
				request, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE));		
		textDate.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE));

		textDate.updateFromModel();
		textDate.setOutputOnly(true);

		// Configure Member name
		ITextRidget txtMemberName = getRidget(ITextRidget.class,
				ServiceRequestMasterDetailComposite.BIND_ID_MEMBER_NAME);
		txtMemberName.setDirectWriting(true);
		//
		txtMemberName
				.setModelToUIControlConverter(new StringToStringModelConverter(
						request.getRequestingMember().getMember(),
						ModelPackage.Literals.PARTY__NAME));
		txtMemberName.setOutputOnly(false);
		txtMemberName
				.bindToModel(EMFObservables
						.observeValue(
								request.getRequestingMember().getMember(),
								ModelPackage.Literals.PARTY__NAME));

		txtMemberName.updateFromModel();
		txtMemberName.setOutputOnly(true);
		// Farm Location
		ITextRidget txtFarm = getRidget(ITextRidget.class,
				ServiceRequestMasterDetailComposite.BIND_ID_FARM_NAME); 
		txtFarm.setModelToUIControlConverter(new IConverter() {

			@Override
			public Object getFromType() {
				return EMFObservables.observeValue(request,
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM)
						.getValueType();
			}

			@Override
			public Object getToType() {
				return String.class;
			}

			@Override
			public Object convert(Object fromObject) {
				if (fromObject instanceof Farm) {
					Farm farm = (Farm) fromObject;
					return farm.getName();

				}
				return null;
			}
		});
		txtFarm.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM));
		txtFarm.updateFromModel();
		txtFarm.setOutputOnly(true);
		//
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
		veterinaryRadioBtn.setOutputOnly(false);
		veterinaryRadioBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		// RequestsPackage.Literals.REQUEST_TYPE));
		veterinaryRadioBtn.updateFromModel();
		veterinaryRadioBtn.setOutputOnly(true);

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
		insementationRadionBtn.setOutputOnly(false);
		insementationRadionBtn.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
		// RequestsPackage.Literals.REQUEST_TYPE));
		insementationRadionBtn.updateFromModel();
		insementationRadionBtn.setOutputOnly(true);

		if (RequestType.INSEMINATION == request.getType()) {
			
			// Heate date
			ITextRidget heatTimeTextBtn = getRidget(
					ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_INSE_TIME_HEATED_DETECTED);
			heatTimeTextBtn.setDirectWriting(true);
			heatTimeTextBtn
					.setModelToUIControlConverter(new DateToStringModelConvertor(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED));
			heatTimeTextBtn.setOutputOnly(false);
			heatTimeTextBtn
					.bindToModel(EMFObservables
							.observeValue(
									request,
									RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED));

			heatTimeTextBtn.updateFromModel();
			heatTimeTextBtn.setOutputOnly(true);
			
			
			// First
			ITextRidget firstTextBtn = getRidget(
					ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_INSE_FIRST_TRETMENT);
			firstTextBtn.setDirectWriting(true);
			firstTextBtn
					.setModelToUIControlConverter(new DateToStringModelConvertor(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT));
			firstTextBtn.setOutputOnly(false);
			firstTextBtn
					.bindToModel(EMFObservables
							.observeValue(
									request,
									RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT));

			firstTextBtn.updateFromModel();
			firstTextBtn.setOutputOnly(true);
			
			
			// Second
			ITextRidget secondTextBtn = getRidget(
					ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_INSE_SECOND_TRETMENT);
			secondTextBtn.setDirectWriting(true);
			secondTextBtn
					.setModelToUIControlConverter(new DateToStringModelConvertor(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT));
			secondTextBtn.setOutputOnly(false);
			secondTextBtn
					.bindToModel(EMFObservables
							.observeValue(
									request,
									RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT));

			secondTextBtn.updateFromModel();
			secondTextBtn.setOutputOnly(true);
			
			// Third
			ITextRidget thirdTextBtn = getRidget(
					ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_INSE_THIRD_TRETMENT);
			thirdTextBtn.setDirectWriting(true);
			thirdTextBtn
					.setModelToUIControlConverter(new DateToStringModelConvertor(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT));
			thirdTextBtn.setOutputOnly(false);
			thirdTextBtn
					.bindToModel(EMFObservables
							.observeValue(
									request,
									RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT));

			thirdTextBtn.updateFromModel();
			thirdTextBtn.setOutputOnly(true);
	
		}
		else
		{
			// Complaint
			// Third
			ITextRidget complaintTextBtn = getRidget(
					ITextRidget.class,
					ServiceRequestMasterDetailComposite.BIND_ID_VERY_THIRD_COMPLAINT);
			complaintTextBtn.setDirectWriting(true);
			complaintTextBtn
					.setModelToUIControlConverter(new StringToStringModelConverter(
							request,
							RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM));
			complaintTextBtn.setOutputOnly(false);
			complaintTextBtn
					.bindToModel(EMFObservables
							.observeValue(
									request,
									RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM));

			complaintTextBtn.updateFromModel();
			complaintTextBtn.setOutputOnly(true);
		}

	}

	@Override
	public void fireListener(int eventType) {
		if (eventType == ServiceLogViewController.EVENT_TYPE_TABLE_INPUT_CHANGED) {
			updateRidgets();
		}

	}

}
