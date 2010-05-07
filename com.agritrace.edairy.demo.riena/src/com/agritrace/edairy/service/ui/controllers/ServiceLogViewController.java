package com.agritrace.edairy.service.ui.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.booleans.BooleanAdapter;
import org.eclipse.emf.query.conditions.booleans.BooleanCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.numbers.NumberAdapter;
import org.eclipse.emf.query.conditions.numbers.NumberCondition;
import org.eclipse.emf.query.conditions.numbers.NumberCondition.RelationalOperator;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.ridgets.validation.NotEmpty;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.ModelPackage;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.requests.RequestsPackage;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.TrackingFactory;
import com.agritrace.edairy.model.tracking.TrackingPackage;
import com.agritrace.edairy.service.ui.views.ServiceRequestFilterSection;
import com.agritrace.edairy.service.ui.views.ServiceRequestMasterDetailComposite;
import com.agritrace.edairy.service.ui.views.utils.ServiceUtils;

/**
 * Service log view controller
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceLogViewController extends SubModuleController {

	public static final String ID = ServiceLogViewController.class.getName();
	public static String[] MASTER_PROPTIES = {
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUEST_ID
					.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER
					.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName(),
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE.getName() };
	public static String[] MASTER_HEADERS = {
			"ID", "Date", "Member", "Farm", "Type" }; //$NON-NLS-1$ //$NON-NLS-2$

	public ServiceLogViewController() {
		super();
	}

	/**
	 * A IMasterDetailsDelegate for service request.
	 */
	private final class ServiceRequestDelegate extends
			AbstractMasterDetailsDelegate {

		private final AnimalHealthRequest workingCopy = createWorkingCopy();

		public void configureRidgets(IRidgetContainer container) {

			// Configure column formatter for table rgiet

			ITableRidget masterTable = (ITableRidget) container
					.getRidget(AbstractMasterDetailsComposite.BIND_ID_TABLE);

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
				((ServiceRequestMasterDetailComposite) getRidget("master")
						.getUIControl()).typeChanged(request);
				// Updates the bindings
				updateDetailBindings(request);
			}

		}

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

		public AnimalHealthRequest createWorkingCopy() {
			return RequestsFactory.eINSTANCE.createAnimalHealthRequest(); //$NON-NLS-1$ //$NON-NLS-2$
		}

		public AnimalHealthRequest getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			return false;
		}

		@Override
		public String isValid(IRidgetContainer container) {
			ITextRidget txtLast = (ITextRidget) container.getRidget("name"); //$NON-NLS-1$
			if (txtLast.isErrorMarked()) {
				return "'Member name' is not valid."; //$NON-NLS-1$
			}
			return null;
		}
	}

	@Override
	public void configureRidgets() {

		configFilterRidgets();

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master"); //$NON-NLS-1$

		if (master != null) {

			master.setDelegate(new ServiceRequestDelegate());
			WritableList input;
			try {
				input = new WritableList(getFilteredResult(),
						AnimalHealthRequest.class);
				master.bindToModel(input, AnimalHealthRequest.class,
						MASTER_PROPTIES, MASTER_HEADERS);
				master.updateFromModel();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void configFilterRidgets() {
		final IActionRidget apply = (IActionRidget) getRidget(ServiceRequestFilterSection.BIND_ID_APPLY);

		if (apply != null) {
			apply.addListener(new IActionListener() {

				@Override
				public void callback() {
					final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master"); //$NON-NLS-1$
					// Update
					WritableList input;
					try {
						input = new WritableList(getFilteredResult(),
								AnimalHealthRequest.class);
						master.bindToModel(input, AnimalHealthRequest.class,
								MASTER_PROPTIES, MASTER_HEADERS);
						master.updateFromModel();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
		}
		final IActionRidget reset = (IActionRidget) getRidget(ServiceRequestFilterSection.BIND_ID_RESET);

		if (reset != null) {
			reset.addListener(new IActionListener() {

				@Override
				public void callback() {
					resetCondtions();

				}
			});
		}
		resetCondtions();

	}

	private void resetCondtions() {
		// for date range
		// Start Date Default value
		ITextRidget startText = (ITextRidget) getRidget(ServiceRequestFilterSection.STARTE_DATE);
		startText.setDirectWriting(true);
		if (startText != null) {
			startText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils
					.getFirstDayOfMonth(Calendar.getInstance().getTime())));
		}
		// End date default value
		ITextRidget endDateText = (ITextRidget) getRidget(ServiceRequestFilterSection.END_DATE);
		if (endDateText != null) {
			endDateText.setDirectWriting(true);
			endDateText.setText(ServiceUtils.DATE_FORMAT.format(ServiceUtils
					.getLastDayOfMonth(Calendar.getInstance().getTime())));

		}
		// Request Type
		IToggleButtonRidget inseminationRidget = (IToggleButtonRidget) getRidget(ServiceRequestFilterSection.REQUEST_TYPE_INSEMINATION); 
		inseminationRidget.setSelected(false);
		IToggleButtonRidget vertRidget = (IToggleButtonRidget) getRidget(ServiceRequestFilterSection.REQUEST_TYPE_VERTERNARY); 
		vertRidget.setSelected(false);
		
		// Member Look
		ITextRidget memberText = (ITextRidget) getRidget(ServiceRequestFilterSection.MEMBER_LOOKUP_TEXT);
		memberText.setDirectWriting(true);
		memberText.setText("");
		// Farm Look
		ITextRidget farmText = (ITextRidget) getRidget(ServiceRequestFilterSection.FARM_LOOKUP_TEXT);
		farmText.setDirectWriting(true);
		farmText.setText("");
		
	}

	private List<EObject> getFilteredResult() throws ParseException {
		List<EObject> objs = new ArrayList<EObject>();
		NumberAdapter.LongAdapter dateAdapter = new NumberAdapter.LongAdapter() {
			public long longValue(Object object) {
				return ((Date) object).getTime();
			}

			@Override
			public Long adapt(Object value) {
				return longValue(value);
			}
		};

		// Start Date
		ITextRidget memberIdText = (ITextRidget) getRidget(ServiceRequestFilterSection.STARTE_DATE); //$NON-NLS-1$
		List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

		SELECT select = null;
		if (memberIdText != null) {
			// StartDate
			// memberIdText.updateFromModel();
			String startDate = memberIdText.getText();

			if (!"".equals(startDate)) {
				Condition startDateCondtion = new NumberCondition<Long>(
						ServiceUtils.DATE_FORMAT.parse(startDate).getTime(),
						RelationalOperator.GREATER_THAN_OR_EQUAL_TO,
						dateAdapter);

				EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE,
						startDateCondtion);
				condtions.add(startDateCondition);
			}

		}
		// End Date
		ITextRidget endDateText = (ITextRidget) getRidget(ServiceRequestFilterSection.END_DATE);
		if (endDateText != null) {
			String endDateStr = endDateText.getText();

			if (!"".equals(endDateStr)) {
				Condition startDateCondtion = new NumberCondition<Long>(
						ServiceUtils.DATE_FORMAT.parse(endDateStr).getTime() + 86400000l,
						RelationalOperator.LESS_THAN_OR_EQUAL_TO, dateAdapter);

				EObjectAttributeValueCondition endDateCondtion = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE,
						startDateCondtion);
				condtions.add(endDateCondtion);
			}
		}

		// Request Type
		// Verterinary
		IToggleButtonRidget veterinaryRidget = (IToggleButtonRidget) getRidget(ServiceRequestFilterSection.REQUEST_TYPE_VERTERNARY); //$NON-NLS-1$
		if (veterinaryRidget != null) {
			boolean isVerterinaryType = veterinaryRidget.isSelected();
			if (isVerterinaryType) {
				BooleanAdapter booleanAdapter = new BooleanAdapter() {

					@Override
					public Boolean getBoolean(Object object) {
						return object.equals(RequestType.VETERINARY);
					}

				};
				Condition verterinaryCondition = new BooleanCondition(
						isVerterinaryType, booleanAdapter);

				EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE,
						verterinaryCondition);
				condtions.add(startDateCondition);
			}
		}
		// Insemination conditions
		IToggleButtonRidget inseminationRidget = (IToggleButtonRidget) getRidget(ServiceRequestFilterSection.REQUEST_TYPE_INSEMINATION); 
		if (inseminationRidget != null) {
			boolean isInsemination = inseminationRidget.isSelected();
			if (isInsemination) {
				BooleanAdapter booleanAdapter = new BooleanAdapter() {

					@Override
					public Boolean getBoolean(Object object) {
						return object.equals(RequestType.INSEMINATION);
					}

				};
				Condition verterinaryCondition = new BooleanCondition(
						isInsemination, booleanAdapter);

				EObjectAttributeValueCondition startDateCondition = new EObjectAttributeValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE,
						verterinaryCondition);
				condtions.add(startDateCondition);
			}
		}

		// Member name field
		ITextRidget memberText = (ITextRidget) getRidget(ServiceRequestFilterSection.MEMBER_LOOKUP_TEXT); //$NON-NLS-1$
		if (memberText != null) {
			String memberName = memberText.getText();
			if (!"".equals(memberName)) {
				Condition name = new org.eclipse.emf.query.conditions.strings.StringValue(
						memberName);
				EObjectCondition partyName = new EObjectAttributeValueCondition(
						ModelPackage.Literals.PARTY__NAME, name);
				EObjectCondition memberRef = new EObjectReferenceValueCondition(
						DairyPackage.Literals.MEMBERSHIP__MEMBER, partyName);
				EObjectCondition requestingMember = new EObjectReferenceValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER,
						memberRef);

				condtions.add(requestingMember);
			}
		}

		// Member name field
		ITextRidget farmText = (ITextRidget) getRidget(ServiceRequestFilterSection.FARM_LOOKUP_TEXT); //$NON-NLS-1$
		if (farmText != null) {
			String farmName = farmText.getText();
			if (!"".equals(farmName)) {
				Condition name = new org.eclipse.emf.query.conditions.strings.StringValue(
						farmName);
				EObjectCondition farmNameCond = new EObjectAttributeValueCondition(
						TrackingPackage.Literals.FARM__NAME, name);
				EObjectCondition farmCond = new EObjectReferenceValueCondition(
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM,
						farmNameCond);

				condtions.add(farmCond);
			}
		}

		// AND all conditions
		if (condtions.size() > 0) {
			EObjectCondition first = condtions.get(0);
			EObjectCondition ret = first;
			for (int i = 1; i < condtions.size(); i++) {
				ret = ret.AND(condtions.get(i));
			}
			select = new SELECT(new FROM(getServiceRequestList()), new WHERE(
					ret));

		} else {
			select = new SELECT(new FROM(getServiceRequestList()), new WHERE(
					EObjectCondition.E_TRUE));
		}
		IQueryResult result = select.execute();
		for (EObject object : result.getEObjects()) {
			objs.add(object);
		}
		Collections.sort(objs, new Comparator<Object>() {

			@Override
			public int compare(Object arg0, Object arg1) {
				if (arg0 instanceof AnimalHealthRequest
						&& arg1 instanceof AnimalHealthRequest)
					return (int) (((AnimalHealthRequest) arg0).getRequestId()
							.longValue() - ((AnimalHealthRequest) arg1)
							.getRequestId().longValue());
				return 0;
			}
		});

		return objs;
	}

	private void updateDetailBindings(final AnimalHealthRequest request) {

		ITextRidget memberIdText = (ITextRidget) getRidget("id"); //$NON-NLS-1$
		memberIdText.bindToModel(EMFObservables.observeValue(request
				.getRequestingMember(),
				DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));
		memberIdText.addValidationRule(new NotEmpty(),
				ValidationTime.ON_UI_CONTROL_EDIT);
		memberIdText.updateFromModel();
		memberIdText.setOutputOnly(true);
		//
		ITextRidget textDate = (ITextRidget) getRidget("date"); //$NON-NLS-1$
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
					return new SimpleDateFormat("MM/dd/yyyy").format(date)
							.toString();

				}
				return null;
			}
		});
		textDate.bindToModel(EMFObservables.observeValue(request,
				RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE));

		textDate.updateFromModel();
		textDate.setOutputOnly(true);

		// Configure Member name
		ITextRidget txtMemberName = (ITextRidget) getRidget("name"); //$NON-NLS-1$
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
		ITextRidget txtFarm = (ITextRidget) getRidget("farm"); //$NON-NLS-1$
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
		IToggleButtonRidget veterinaryRadioBtn = (IToggleButtonRidget) getRidget("veterinary"); //$NON-NLS-1$
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
		IToggleButtonRidget insementationRadionBtn = (IToggleButtonRidget) getRidget("insemination"); //$NON-NLS-1$
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
			ITextRidget heatTimeTextBtn = (ITextRidget) getRidget(ServiceRequestMasterDetailComposite.INSE_TIME_HEATED_DETECTED);
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

	private List<AnimalHealthRequest> getServiceRequestList() {
		// This is for demo only
		List<AnimalHealthRequest> ret = new ArrayList<AnimalHealthRequest>();
		AnimalHealthRequest req1 = RequestsFactory.eINSTANCE
				.createAnimalHealthRequest();
		req1.setRequestId(1001l);
		req1.setDate(Calendar.getInstance().getTime());
		// MemberShiip
		Membership ship = DairyFactory.eINSTANCE.createMembership();
		Person person = ModelFactory.eINSTANCE.createPerson();
		person.setPhoneNumber("13816442241");
		person.setName("Spark Wan");
		ship.setMember(person);
		ship.setMemberId("1001");
		req1.setRequestingMember(ship);

		Farm farm = TrackingFactory.eINSTANCE.createFarm();
		farm.setName("Farm1");

		req1.setFarm(farm);
		req1.setType(RequestType.VETERINARY);
		req1.setDateHeatDetected(Calendar.getInstance().getTime());
		req1.setSecondTreatment(Calendar.getInstance().getTime());
		req1.setThirdTreatment(Calendar.getInstance().getTime());
		ret.add(req1);

		AnimalHealthRequest req2 = RequestsFactory.eINSTANCE
				.createAnimalHealthRequest();
		req2.setRequestId(1002l);
		req2.setDate(Calendar.getInstance().getTime());
		// MemberShiip
		Membership ship2 = DairyFactory.eINSTANCE.createMembership();
		Person person2 = ModelFactory.eINSTANCE.createPerson();
		person2.setPhoneNumber("12345678");
		person2.setName("Tracy Smith");
		ship2.setMember(person2);
		ship2.setMemberId("1002");
		req2.setRequestingMember(ship2);

		Farm farm2 = TrackingFactory.eINSTANCE.createFarm();
		farm2.setName("Farm2");

		req2.setFarm(farm2);
		req2.setType(RequestType.INSEMINATION);
		req2.setDateHeatDetected(Calendar.getInstance().getTime());
		req2.setSecondTreatment(Calendar.getInstance().getTime());
		req2.setThirdTreatment(Calendar.getInstance().getTime());
		ret.add(req2);

		AnimalHealthRequest req3 = RequestsFactory.eINSTANCE
				.createAnimalHealthRequest();
		req3.setRequestId(1003l);
		try {
			req3.setDate(ServiceUtils.DATE_FORMAT.parse("04/01/2010"));
		} catch (ParseException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		// MemberShiip
		Membership ship3 = DairyFactory.eINSTANCE.createMembership();
		Person person3 = ModelFactory.eINSTANCE.createPerson();
		person3.setPhoneNumber("12345678");
		person3.setName("Tracy Smith");
		ship3.setMember(person3);
		ship3.setMemberId("1003");
		req3.setRequestingMember(ship3);

		Farm farm3 = TrackingFactory.eINSTANCE.createFarm();
		farm3.setName("Farm3");

		req3.setFarm(farm3);
		req3.setType(RequestType.INSEMINATION);
		req3.setDateHeatDetected(Calendar.getInstance().getTime());
		req3.setSecondTreatment(Calendar.getInstance().getTime());
		req3.setThirdTreatment(Calendar.getInstance().getTime());
		ret.add(req3);

		return ret;
	}
}
