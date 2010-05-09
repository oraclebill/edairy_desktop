package com.agritrace.edairy.service.ui.controllers;

import java.util.Date;

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

import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.requests.RequestsPackage;
import com.agritrace.edairy.model.tracking.Farm;
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

		if (master != null) {

			WritableList input;
			input = new WritableList(((ServiceLogViewController) this
					.getSubModuleController()).getFilteredResult(),
					AnimalHealthRequest.class);
			master.bindToModel(input, AnimalHealthRequest.class,
					MASTER_PROPTIES, MASTER_HEADERS);
			master.updateFromModel();

		}

		updateDetailBindings(RequestsFactory.eINSTANCE
				.createAnimalHealthRequest());

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
				((ServiceRequestMasterDetailComposite) getRidget(
						IMasterDetailsRidget.class, ServiceRequestLogView.BIND_ID_MASTER).getUIControl())
						.typeChanged(request);
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

		ITextRidget memberIdText = getRidget(ITextRidget.class,
				"id"); //$NON-NLS-1$
		memberIdText.setOutputOnly(false);
		memberIdText.bindToModel(EMFObservables.observeValue(request
				.getRequestingMember(),
				DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
		memberIdText.updateFromModel();
		memberIdText.setOutputOnly(true);
		//
		ITextRidget textDate = getRidget(ITextRidget.class,
				"date"); //$NON-NLS-1$
		textDate.setModelToUIControlConverter(new IConverter() {

			@Override
			public Object getFromType() {
				return EMFObservables.observeValue(request,
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE)
						.getValueType();
			}

			@Override
			public Object getToType() {
				return String.class;
			}

			@Override
			public Object convert(Object fromObject) {
				if (fromObject instanceof Date) {
					Date date = (Date) fromObject;
					return ServiceUtils.DATE_FORMAT.format(date);

				}
				return null;
			}
		});
		textDate.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE));

		textDate.updateFromModel();
		textDate.setOutputOnly(true);

		// Configure Member name
		ITextRidget txtMemberName = getRidget(ITextRidget.class,
				"name"); //$NON-NLS-1$
		//
		txtMemberName.setModelToUIControlConverter(new IConverter() {

			@Override
			public Object getFromType() {
				return EMFObservables
						.observeValue(
								request,
								RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER)
						.getValueType();
			}

			@Override
			public Object getToType() {
				return String.class;
			}

			@Override
			public Object convert(Object fromObject) {
				if (fromObject instanceof Membership) {
					Membership member = (Membership) fromObject;
					return member.getMember().getName();

				}
				return null;
			}
		});
		txtMemberName
				.bindToModel(EMFObservables
						.observeValue(
								request,
								RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER));

		txtMemberName.updateFromModel();
		txtMemberName.setOutputOnly(true);
		// Farm Location
		ITextRidget txtFarm = getRidget(ITextRidget.class, "farm"); //$NON-NLS-1$
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
			// Request Type/Insementation
			ITextRidget heatTimeTextBtn = getRidget(
					ITextRidget.class,
					ServiceRequestMasterDetailComposite.INSE_TIME_HEATED_DETECTED);
			//
			// heatTimeTextBtn
			// .setModelToUIControlConverter(new
			// DateToStringModelConvertor(RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__MEMBER,
			// RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__MEMBER){
			//
			// @Override
			// protected Object filter(Object object) {
			// // TODO Auto-generated method stub
			// return super.filter(object);
			// }});
			// insementationRadionBtn.setOutputOnly(false);
			// insementationRadionBtn.bindToModel(EMFObservables.observeValue(
			// request,
			// RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__MEMBER));
			// // RequestsPackage.Literals.REQUEST_TYPE));
			// insementationRadionBtn.updateFromModel();
			// insementationRadionBtn.setOutputOnly(true);
		}

	}

	@Override
	public void fireListener(int eventType) {
		if (eventType == ServiceLogViewController.EVENT_TYPE_TABLE_INPUT_CHANGED) {
			updateRidgets();
		}

	}

}
