package com.agritrace.edairy.desktop.services.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.ICompositeRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.widgets.Control;

import com.agritrace.edairy.desktop.services.ui.utils.ServiceUtils;
import com.agritrace.edairy.desktop.services.ui.views.ServiceRequestLogView;
import com.agritrace.edairy.desktop.services.ui.views.ServiceRequestMasterDetailComposite;
import com.agritrace.edairy.model.Location;
import com.agritrace.edairy.model.ModelFactory;
import com.agritrace.edairy.model.Person;
import com.agritrace.edairy.model.PostalLocation;
import com.agritrace.edairy.model.dairy.DairyFactory;
import com.agritrace.edairy.model.dairy.DairyPackage;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.model.requests.RequestType;
import com.agritrace.edairy.model.requests.RequestsFactory;
import com.agritrace.edairy.model.requests.RequestsPackage;
import com.agritrace.edairy.model.tracking.Farm;
import com.agritrace.edairy.model.tracking.TrackingFactory;

/**
 * Master-detail controller delegate
 * 
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestLogMasterDetailControllerDelegate extends SubModuleControllerDelegate {

    public static String[] MASTER_PROPTIES = { RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUEST_ID.getName(),
	    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName(),
	    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REQUESTING_MEMBER.getName(),
	    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM.getName(),
	    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE.getName() };
    public static String[] MASTER_HEADERS = { "ID", "Date", "Member", "Farm", "Type" };

    public ServiceRequestLogMasterDetailControllerDelegate(SubModuleController controller) {
	super(controller);
    }

    @Override
    public void configureRidgets() {
	final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, ServiceRequestLogView.BIND_ID_MASTER);

	if (master != null) {
	    master.setDelegate(new ServiceRequestDelegate());
	    WritableList input;
	    input = new WritableList(((ServiceLogViewController) this.getSubModuleController()).getFilteredResult(),
		    AnimalHealthRequest.class);
	    master.bindToModel(input, AnimalHealthRequest.class, MASTER_PROPTIES, MASTER_HEADERS);
	    master.updateFromModel();

	}
    }

    private void updateRidgets() {
	final IMasterDetailsRidget master = getRidget(IMasterDetailsRidget.class, ServiceRequestLogView.BIND_ID_MASTER);

	if (master != null && master.getDelegate() != null) {

	    WritableList input;
	    input = new WritableList(((ServiceLogViewController) this.getSubModuleController()).getFilteredResult(),
		    AnimalHealthRequest.class);
	    master.bindToModel(input, AnimalHealthRequest.class, MASTER_PROPTIES, MASTER_HEADERS);
	    master.updateFromModel();

	}

    }

    /**
     * A IMasterDetailsDelegate for service request.
     */
    private final class ServiceRequestDelegate extends AbstractMasterDetailsDelegate {

	private final AnimalHealthRequest workingCopy = createWorkingCopy();

	@Override
	public void configureRidgets(IRidgetContainer container) {

	    // Configure column formatter for table ridget
	    final ITableRidget masterTable = container != null ? (ITableRidget) container.getRidget(ITableRidget.class,
		    AbstractMasterDetailsComposite.BIND_ID_TABLE) : getRidget(ITableRidget.class,
		    AbstractMasterDetailsComposite.BIND_ID_TABLE);

	    // Configure column formatter
	    if (masterTable != null) {

		// Date column
		masterTable.setColumnFormatter(1, new ColumnFormatter() {

		    @Override
		    public String getText(Object element) {
			if (element instanceof AnimalHealthRequest) {
			    return ServiceUtils.DATE_FORMAT.format(((AnimalHealthRequest) element).getDate());
			}
			return null;
		    }

		});
		// Member column
		masterTable.setColumnFormatter(2, new ColumnFormatter() {

		    @Override
		    public String getText(Object element) {
			if (element instanceof AnimalHealthRequest) {
			    final String name = ((AnimalHealthRequest) element).getRequestingMember().getMember()
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
			    final String name = ((AnimalHealthRequest) element).getFarm().getName();
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
			    final String name = ((AnimalHealthRequest) element).getType().toString();
			    return name == null ? "" : name;
			}
			return null;
		    }

		});

	    }

	    final ITextRidget memberIdText = container.getRidget(ITextRidget.class,
		    ServiceRequestMasterDetailComposite.BIND_ID_MEMBER_ID);
	    memberIdText.setDirectWriting(true);
	    memberIdText.setOutputOnly(false);
	    memberIdText.bindToModel(workingCopy.getRequestingMember(),
		    DairyPackage.Literals.MEMBERSHIP__MEMBER_ID.getName());
	    memberIdText.updateFromModel();

	    memberIdText.setOutputOnly(true);
	    //
	    final ITextRidget textDate = container.getRidget(ITextRidget.class,
		    ServiceRequestMasterDetailComposite.BIND_ID_REQUEST_DATE);
	    textDate.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
	    textDate.bindToModel(workingCopy, RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE.getName());
	    textDate.updateFromModel();
	    textDate.setOutputOnly(true);

	    // Configure Member name
	    final ITextRidget txtMemberName = container.getRidget(ITextRidget.class,
		    ServiceRequestMasterDetailComposite.BIND_ID_MEMBER_NAME);
	    txtMemberName.setDirectWriting(true);
	    txtMemberName.setOutputOnly(false);
	    // txtMemberName.bindToModel(EMFObservables.observeValue(workingCopy
	    // .getRequestingMember().getMember(),
	    // ModelPackage.Literals.PARTY__NAME));

	    txtMemberName.updateFromModel();
	    txtMemberName.setOutputOnly(true);
	    // Farm Location
	    final ITextRidget txtFarm = container.getRidget(ITextRidget.class,
		    ServiceRequestMasterDetailComposite.BIND_ID_FARM_NAME);
	    txtFarm.setModelToUIControlConverter(new IConverter() {

		@Override
		public Object getFromType() {
		    return EMFObservables.observeValue(workingCopy,
			    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM).getValueType();
		}

		@Override
		public Object getToType() {
		    return String.class;
		}

		@Override
		public Object convert(Object fromObject) {
		    if (fromObject instanceof Farm) {
			final Farm farm = (Farm) fromObject;
			return farm.getName();

		    }
		    return null;
		}
	    });
	    txtFarm.bindToModel(EMFObservables.observeValue(workingCopy,
		    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FARM));
	    txtFarm.updateFromModel();
	    txtFarm.setOutputOnly(true);
	    //
	    // Request Type/Veterinary
	    final IToggleButtonRidget veterinaryRadioBtn = container.getRidget(IToggleButtonRidget.class, "veterinary"); //$NON-NLS-1$
	    //
	    veterinaryRadioBtn.setModelToUIControlConverter(new IConverter() {

		@Override
		public Object getFromType() {
		    return EMFObservables.observeValue(workingCopy,
			    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE).getValueType();
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
	    veterinaryRadioBtn.bindToModel(EMFObservables.observeValue(workingCopy,
		    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
	    // RequestsPackage.Literals.REQUEST_TYPE));
	    veterinaryRadioBtn.updateFromModel();
	    veterinaryRadioBtn.setOutputOnly(true);

	    // Request Type/Insementation
	    final IToggleButtonRidget insementationRadionBtn = container.getRidget(IToggleButtonRidget.class,
		    "insemination"); //$NON-NLS-1$
	    //
	    insementationRadionBtn.setModelToUIControlConverter(new IConverter() {

		@Override
		public Object getFromType() {
		    return EMFObservables.observeValue(workingCopy,
			    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE).getValueType();
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
	    insementationRadionBtn.bindToModel(EMFObservables.observeValue(workingCopy,
		    RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
	    // RequestsPackage.Literals.REQUEST_TYPE));
	    insementationRadionBtn.updateFromModel();
	    insementationRadionBtn.setOutputOnly(true);

	}

	@Override
	public void prepareItemSelected(Object newSelection) {

	    super.prepareItemSelected(newSelection);
	    if (newSelection instanceof AnimalHealthRequest) {
		final AnimalHealthRequest request = (AnimalHealthRequest) newSelection;
		// Notify the UI control
		final IMasterDetailsRidget container = getRidget(IMasterDetailsRidget.class,
			ServiceRequestLogView.BIND_ID_MASTER);
		final ServiceRequestMasterDetailComposite mdComposite = (ServiceRequestMasterDetailComposite) container
			.getUIControl();
		if (mdComposite != null) {
		    mdComposite.updateUI(request);
		}

		final ICompositeRidget specificContainer = getRidget(ICompositeRidget.class,
			ServiceRequestMasterDetailComposite.BIND_ID_SPECIFIC_CONTAINER);

		// Inject specific UI controls into container ridget
		final List<Object> injectedControls = new ArrayList<Object>();
		for (final Object control : mdComposite.getUIControls()) {

		    if (control instanceof Control && !((Control) control).isDisposed()) {
			final String bindId = SWTBindingPropertyLocator.getInstance().locateBindingProperty(control);
			// Only not existing widget or disposed existing ridget
			// need to injected again
			if (container.getRidget(bindId) == null || container.getRidget(bindId) != null
				&& ((Control) container.getRidget(bindId).getUIControl()).isDisposed()) {
			    injectedControls.add(control);
			}
			// injectedControls.add(control);
		    }
		}
		// SwtRidgetFactory.
		ServiceUtils
			.injectRidgets(specificContainer, injectedControls, SWTBindingPropertyLocator.getInstance());
		// Updates the bindings
		configTypeSpecificRidgets(request);
	    }

	}

	private void configTypeSpecificRidgets(final AnimalHealthRequest request) {

	    final ICompositeRidget container = getRidget(ICompositeRidget.class,
		    ServiceRequestMasterDetailComposite.BIND_ID_SPECIFIC_CONTAINER);
	    if (RequestType.INSEMINATION == request.getType()) {

		// Heated date
		final ITextRidget heatTimeTextBtn = container.getRidget(ITextRidget.class,
			ServiceRequestMasterDetailComposite.BIND_ID_INSE_TIME_HEATED_DETECTED);
		heatTimeTextBtn.setDirectWriting(true);
		heatTimeTextBtn.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
		heatTimeTextBtn.setOutputOnly(false);
		heatTimeTextBtn.bindToModel(workingCopy,
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE_HEAT_DETECTED.getName());
		heatTimeTextBtn.updateFromModel();
		heatTimeTextBtn.setOutputOnly(true);

		// First
		final ITextRidget firstTextBtn = container.getRidget(ITextRidget.class,
			ServiceRequestMasterDetailComposite.BIND_ID_INSE_FIRST_TRETMENT);
		firstTextBtn.setDirectWriting(true);
		firstTextBtn.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
		firstTextBtn.setOutputOnly(false);
		firstTextBtn.bindToModel(workingCopy,
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__FIRST_TREATMENT.getName());

		firstTextBtn.updateFromModel();
		firstTextBtn.setOutputOnly(true);

		// Second
		final ITextRidget secondTextBtn = container.getRidget(ITextRidget.class,
			ServiceRequestMasterDetailComposite.BIND_ID_INSE_SECOND_TRETMENT);
		secondTextBtn.setDirectWriting(true);
		secondTextBtn.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
		secondTextBtn.setOutputOnly(false);
		secondTextBtn.bindToModel(workingCopy,
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__SECOND_TREATMENT.getName());

		secondTextBtn.updateFromModel();
		secondTextBtn.setOutputOnly(true);

		// Third
		final ITextRidget thirdTextBtn = container.getRidget(ITextRidget.class,
			ServiceRequestMasterDetailComposite.BIND_ID_INSE_THIRD_TRETMENT);
		thirdTextBtn.setDirectWriting(true);
		thirdTextBtn.setModelToUIControlConverter(ServiceUtils.DEFAULT_DATE_STRING_CONVERTER);
		thirdTextBtn.setOutputOnly(false);
		thirdTextBtn.bindToModel(workingCopy,
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__THIRD_TREATMENT.getName());

		thirdTextBtn.updateFromModel();
		thirdTextBtn.setOutputOnly(true);

	    } else {
		// Complaint
		// Third
		final ITextRidget complaintTextBtn = container.getRidget(ITextRidget.class,
			ServiceRequestMasterDetailComposite.BIND_ID_VERY_THIRD_COMPLAINT);
		complaintTextBtn.setDirectWriting(true);
		complaintTextBtn.setOutputOnly(false);
		complaintTextBtn.bindToModel(workingCopy,
			RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__REPORTED_PROBLEM.getName());
		complaintTextBtn.updateFromModel();
		complaintTextBtn.setOutputOnly(true);
	    }

	}

	@Override
	public AnimalHealthRequest copyBean(Object source, Object target) {
	    final AnimalHealthRequest from = source != null ? (AnimalHealthRequest) source : createWorkingCopy();
	    final AnimalHealthRequest to = target != null ? (AnimalHealthRequest) target : createWorkingCopy();
	    ServiceUtils.copy(from, to);
	    return to;
	}

	@Override
	public AnimalHealthRequest createWorkingCopy() {

	    final AnimalHealthRequest req = RequestsFactory.eINSTANCE.createAnimalHealthRequest();

	    // MemberShiip
	    final Membership ship = DairyFactory.eINSTANCE.createMembership();
	    final Person person = ModelFactory.eINSTANCE.createPerson();
	    ship.setMember(person);
	    req.setRequestingMember(ship);
	    final Location location1 = ModelFactory.eINSTANCE.createLocation();
	    final PostalLocation defaultLocation = ModelFactory.eINSTANCE.createPostalLocation();

	    location1.setPostalLocation(defaultLocation);
	    final Farm farm = TrackingFactory.eINSTANCE.createFarm();
	    farm.setLocation(location1);
	    req.setFarm(farm);
	    return req;
	}

	@Override
	public void updateDetails(IRidgetContainer container) {

	    for (final IRidget ridget : container.getRidgets()) {
		updateReadOnlyRidget(ridget);
	    }
	    final ICompositeRidget masterCompcontainer = getRidget(ICompositeRidget.class,
		    ServiceRequestMasterDetailComposite.BIND_ID_SPECIFIC_CONTAINER);
	    for (final IRidget ridget : masterCompcontainer.getRidgets()) {

		if (ridget.getUIControl() instanceof Control && !((Control) ridget.getUIControl()).isDisposed()) {
		    updateReadOnlyRidget(ridget);
		}
	    }
	}

	private void updateReadOnlyRidget(IRidget ridget) {
	    if (ridget instanceof IMarkableRidget) {
		if (ridget instanceof IMarkableRidget) {
		    ((IMarkableRidget) ridget).setOutputOnly(false);
		}
		if (ridget instanceof ITextRidget) {
		    ((ITextRidget) ridget).setDirectWriting(true);
		}
		ridget.updateFromModel();
		if (ridget instanceof IMarkableRidget) {
		    ((IMarkableRidget) ridget).setOutputOnly(true);
		}
	    }
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

    @Override
    public void fireListener(int eventType) {
	if (eventType == ServiceLogViewController.EVENT_TYPE_TABLE_INPUT_CHANGED) {
	    updateRidgets();
	}

    }

}
