package com.agritrace.edairy.desktop.services.ui.dialogs;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IToggleButtonRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.model.requests.AnimalHealthRequest;
import com.agritrace.edairy.desktop.common.model.requests.RequestType;
import com.agritrace.edairy.desktop.common.model.requests.RequestsPackage;
import com.agritrace.edairy.desktop.common.ui.DesktopBaseActivator;
import com.agritrace.edairy.desktop.common.ui.ImageRegistry;
import com.agritrace.edairy.desktop.common.ui.controllers.LookupControllerDelegate;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.LookupComposite;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.util.DateTimeUtils;
import com.agritrace.edairy.desktop.common.ui.util.EMFUtil;
import com.agritrace.edairy.desktop.common.ui.util.ServiceUtils;
import com.agritrace.edairy.desktop.services.ui.Activator;

/**
 * Service request list dialog
 * 
 * @author Hui(Spark) Wan
 * 
 */
public class ServiceRequestListDialog extends RecordDialog {
	private Composite specialComp;
	private Group inseminationGroup;
	private Composite verternaryComp;
	private Composite inseminationComp;
	private RequestType previousType;
	private Composite comp;
	public static final String SPECIFIC_RPEFIX = "specific.";//$NON-NLS-1$
	public static final String BIND_ID_INSE_TIME_HEATED_DETECTED = SPECIFIC_RPEFIX
			+ "time.heated.detected";//$NON-NLS-1$
	public static final String BIND_ID_INSE_FIRST_TRETMENT = SPECIFIC_RPEFIX
			+ "time.first.repeat";//$NON-NLS-1$
	public static final String BIND_ID_INSE_SECOND_TRETMENT = SPECIFIC_RPEFIX
			+ "time.second.repeat";//$NON-NLS-1$
	public static final String BIND_ID_INSE_THIRD_TRETMENT = SPECIFIC_RPEFIX
			+ "time.third.repeat";//$NON-NLS-1$
	public static final String BIND_ID_VERY_THIRD_COMPLAINT = SPECIFIC_RPEFIX
			+ "complaint";//$NON-NLS-1$
	public static final String BIND_ID_REQUEST_DATE_TEXT = "request.date.text";//$NON-NLS-1$
	public static final String BIND_ID_REQUEST_DATE_BUTTON = "request.date.button";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_TEXT = "member.lookup.text";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_BUTTON = "member.lookup.button";//$NON-NLS-1$
	public static final String BIND_ID_FARM_TEXT = "farm.lookup.text";//$NON-NLS-1$
	public static final String BIND_ID_FARM_BUTTON = "farm.lookup.button";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_NAME = "member.name";//$NON-NLS-1$
	public static final String BIND_ID_MEMBER_ID = "member.id";//$NON-NLS-1$
	public static final String BIND_ID_FARM = "farm";//$NON-NLS-1$
	public static final String BIND_ID_SPECIFIC_CONTAINER = "specific.container";//$NON-NLS-1$
	private List<Object> injectedControls = new ArrayList<Object>();

	public ServiceRequestListDialog(int style, Shell parentShell,
			EObject selectedEObject) {
		super(style, parentShell, selectedEObject);

	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (this.getDialogStyle() == DIALOG_STYLE_NEW) {
			this.setTitle("Add Service Request");
		} else if (this.getDialogStyle() == DIALOG_STYLE_VIEW) {
			this.setTitle("View Service Request");
		} else {
			this.setTitle("Edit Service Request");
		}
		this.setShellStyle(SWT.RESIZE | SWT.CLOSE | SWT.TITLE);
		newShell.setSize(340, 380);
		newShell.setBackground(LnfManager.getLnf().getColor(
				LnfKeyConstants.SUB_MODULE_BACKGROUND));
	}

	@Override
	protected void createUIComponent(Composite comp) {

		// Create common controls
		createCommonControls(comp);
		this.comp = comp;
		// Create specific controls
		createTypeSpecificControls(comp);
	}

	private void createTypeSpecificControls(Composite comp) {
		// "Veterinary"
		// Complaint
		specialComp = UIControlsFactory.createComposite(comp);
		specialComp.setLayout(new GridLayout(1, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).applyTo(specialComp);
		this.addUIControl(specialComp, BIND_ID_SPECIFIC_CONTAINER); //$NON-NLS-1$	
	}

	private void createCommonControls(Composite parent) {
		Composite comonComp = UIControlsFactory.createComposite(parent);
		comonComp.setLayout(new GridLayout(3, false));
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true,
				false).applyTo(comonComp);

		// Create Start Date lookup
		LookupComposite startDateLookup = new LookupComposite("Date", Activator
				.getDefault().getImageRegistry().get(Activator.CALENDAR_ICON),
				BIND_ID_REQUEST_DATE_TEXT, BIND_ID_REQUEST_DATE_BUTTON);
		startDateLookup.createSection(comonComp);

		// UIControlsFactory.createLabel(comonComp, "Date");
		// Composite dateComposte =
		// UIControlsFactory.createComposite(comonComp);
		// dateComposte.setLayout(GridLayoutFactory.swtDefaults().numColumns(2)
		// .margins(0, 0).create());
		//
		// GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(
		// true, false).span(2, 1).applyTo(dateComposte);
		//
		// Text txtDate = UIControlsFactory.createText(dateComposte);
		// GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		// dateData.horizontalSpan = 1;
		// dateData.grabExcessHorizontalSpace = true;
		// txtDate.setLayoutData(dateData);
		//		addUIControl(txtDate, BIND_ID_REQUEST_DATE); //$NON-NLS-1$

		// Button button = new Button(dateComposte, SWT.PUSH);
		// Image calendar = Activator.getImage(ImageRegistry.calendar);
		// button.setImage(calendar);
		// GridDataFactory.swtDefaults().align(SWT.BEGINNING,
		// SWT.BEGINNING).hint(
		// 17, 16).applyTo(button);

		//		UIControlsFactory.createLabel(comonComp, "Member Lookup"); //$NON-NLS-1$
		// Text memberLookupText = UIControlsFactory.createText(comonComp);
		// GridData memberLookupData = new GridData(GridData.FILL_HORIZONTAL);
		// memberLookupData.horizontalSpan = 2;
		// memberLookupText.setLayoutData(memberLookupData);
		//		addUIControl(memberLookupText, BIND_ID_MEMBER_LOOKUP); //$NON-NLS-1$
		//
		//		UIControlsFactory.createLabel(comonComp, "Member ID"); //$NON-NLS-1$
		// Text txtID = UIControlsFactory.createText(comonComp);
		// GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		// textData.horizontalSpan = 2;
		// txtID.setLayoutData(textData);
		//		addUIControl(txtID, BIND_ID_MEMBER_ID); //$NON-NLS-1$
		//
		//		UIControlsFactory.createLabel(comonComp, "Member Name"); //$NON-NLS-1$
		// Text txtName = UIControlsFactory.createText(comonComp);
		// txtName.setLayoutData(GridDataFactory.copyData(textData));
		//		addUIControl(txtName, BIND_ID_MEMBER_NAME); //$NON-NLS-1$
		//
		//		UIControlsFactory.createLabel(comonComp, "Farm"); //$NON-NLS-1$
		// // Text txtFarm = UIControlsFactory.createText(comonComp, SWT.MULTI);
		// // GridData data = new GridData(GridData.FILL_HORIZONTAL);
		// // data.heightHint = 50;
		// // data.horizontalSpan = 2;
		// // txtFarm.setLayoutData(data);
		//		//		addUIControl(txtFarm, BIND_ID_FARM_NAME); //$NON-NLS-1$
		//
		// Combo farmCombo = UIControlsFactory.createCombo(comonComp);
		// // //GridDataFactory.swtDefaults().grab(true,
		// false).span(2,1).applyTo(farmCombo);
		// // GridData data = new GridData(GridData.FILL_HORIZONTAL);
		// // data.horizontalSpan =2;
		// // farmCombo.setLayoutData(data);
		// GridDataFactory.swtDefaults().align(SWT.FILL,
		// SWT.BEGINNING).grab(true, false).span(2,1).applyTo(farmCombo);
		// addUIControl(farmCombo, BIND_ID_FARM);

		// Create farm lookup
		LookupComposite farmLookup = new LookupComposite("Farm", Activator
				.getDefault().getImageRegistry()
				.get(Activator.FARM_SEARCH_ICON), BIND_ID_FARM_TEXT,
				BIND_ID_FARM_BUTTON);
		farmLookup.createSection(comonComp);
		// Create member lookup
		LookupComposite memberLookup = new LookupComposite("Member", Activator
				.getDefault().getImageRegistry()
				.get(Activator.MEMBER_SEARCH_ICON), BIND_ID_MEMBER_TEXT,
				BIND_ID_MEMBER_BUTTON);
		memberLookup.createSection(comonComp);

		UIControlsFactory.createLabel(comonComp, "Request Type"); //$NON-NLS-1$
		Composite typeComposite = UIControlsFactory.createComposite(comonComp);
		GridLayoutFactory.swtDefaults().numColumns(2).margins(0, 0).applyTo(
				typeComposite);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true,
				false).span(2, 1).applyTo(typeComposite);

		Button veterinaryBtn = UIControlsFactory
				.createButtonRadio(typeComposite);
		veterinaryBtn.setText("Veterinary");
		addUIControl(veterinaryBtn, "veterinary"); //$NON-NLS-1$
		Button inseminationBtn = UIControlsFactory
				.createButtonRadio(typeComposite);
		inseminationBtn.setText("Insemination");
		addUIControl(inseminationBtn, "insemination"); //$NON-NLS-1$

	}

	@Override
	protected AbstractWindowController createController() {
		RecordDialogController controller = new RecordDialogController(
				this) {

//			@Override
//			public EObject createWorkingCopy() {
//				AnimalHealthRequest req = RequestsFactory.eINSTANCE
//						.createAnimalHealthRequest();
//
//				// MemberShiip
//				Membership ship = DairyFactory.eINSTANCE.createMembership();
//				Person person = ModelFactory.eINSTANCE.createPerson();
//				ship.setMember(person);
//				req.setRequestingMember(ship);
//				Location location1 = ModelFactory.eINSTANCE.createLocation();
//				PostalLocation defaultLocation = ModelFactory.eINSTANCE
//						.createPostalLocation();
//
//				location1.setPostalLocation(defaultLocation);
//				Farm farm = TrackingFactory.eINSTANCE.createFarm();
//				farm.setLocation(location1);
//				req.setFarm(farm);
//
//				return req;
//
//			}

			@Override
			public void configureRidgets() {
				super.configureRidgets();
				final AnimalHealthRequest request = (AnimalHealthRequest) getWorkingCopy();
				// ITextRidget memberIdText = getRidget(ITextRidget.class,
				//						BIND_ID_MEMBER_ID); //$NON-NLS-1$
				// memberIdText.setDirectWriting(true);
				// memberIdText.setOutputOnly(false);
				// memberIdText.bindToModel(request.getRequestingMember(),
				// DairyPackage.Literals.MEMBERSHIP__MEMBER_ID.getName());
				// memberIdText.updateFromModel();
				//
				// memberIdText.setOutputOnly(true);

				//
				// ITextRidget textDate = getRidget(ITextRidget.class,
				// BIND_ID_REQUEST_DATE_TEXT);
				// textDate.setModelToUIControlConverter(DateTimeUtils.DEFAULT_DATE_STRING_CONVERTER);
				// // /textDate.setOutputOnly(false);
				// textDate.bindToModel(request,
				// RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE
				// .getName());
				// textDate.updateFromModel();
				// Start date
				LookupControllerDelegate delegate = new LookupControllerDelegate(
						this,
						PojoObservables
								.observeValue(
										request,
										RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__DATE
												.getName()),
						BIND_ID_REQUEST_DATE_TEXT, BIND_ID_REQUEST_DATE_BUTTON);
				delegate.configureRidgets();

				// // Configure Member name
				// ITextRidget txtMemberName = getRidget(ITextRidget.class,
				// BIND_ID_MEMBER_NAME);
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
				// BIND_ID_FARM);
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
				veterinaryRadioBtn
						.setModelToUIControlConverter(new IConverter() {

							@Override
							public Object getFromType() {
								return EMFObservables
										.observeValue(
												request,
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
									return RequestType.VETERINARY
											.equals(fromObject);

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
				veterinaryRadioBtn.bindToModel(EMFObservables.observeValue(
						request,
						RequestsPackage.Literals.ANIMAL_HEALTH_REQUEST__TYPE));
				// RequestsPackage.Literals.REQUEST_TYPE));
				veterinaryRadioBtn.updateFromModel();
				// veterinaryRadioBtn.setOutputOnly(true);

				// Request Type/Insementation
				IToggleButtonRidget insementationRadionBtn = getRidget(
						IToggleButtonRidget.class, "insemination"); //$NON-NLS-1$
				//
				insementationRadionBtn
						.setModelToUIControlConverter(new IConverter() {

							@Override
							public Object getFromType() {
								return EMFObservables
										.observeValue(
												request,
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
									return RequestType.INSEMINATION
											.equals(fromObject);

								}
								return null;
							}
						});
				// insementationRadionBtn.setOutputOnly(false);
				insementationRadionBtn.bindToModel(EMFObservables.observeValue(
						request,
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
				updateUI(request);
				// SwtRidgetFactory.
				ServiceUtils.injectRidgets(Activator.getDefault().getBundle()
						.getBundleContext(), getController(), injectedControls,
						SWTBindingPropertyLocator.getInstance());
				// Updates the bindings
				configTypeSpecificRidgets(request);

			}

			private void configTypeSpecificRidgets(
					final AnimalHealthRequest request) {

				// ICompositeRidget container =
				// getRidget(ICompositeRidget.class,
				// BIND_ID_SPECIFIC_CONTAINER);
				if (RequestType.INSEMINATION == request.getType()) {

					// Heated date
					ITextRidget heatTimeTextBtn = getRidget(ITextRidget.class,
							BIND_ID_INSE_TIME_HEATED_DETECTED);
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
							BIND_ID_INSE_FIRST_TRETMENT);
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
							BIND_ID_INSE_SECOND_TRETMENT);
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
							BIND_ID_INSE_THIRD_TRETMENT);
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
							BIND_ID_VERY_THIRD_COMPLAINT);
					complaintTextBtn.addPropertyChangeListener(
							ITextRidget.PROPERTY_TEXT,
							new PropertyChangeListener() {

								@Override
								public void propertyChange(
										java.beans.PropertyChangeEvent arg0) {

									request.setReportedProblem(arg0
											.getNewValue().toString());

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

		};
		controller.addListener(new IActionListener() {

			@Override
			public void callback() {
				EMFUtil.copy(getWorkingCopy(), getSelectedEObject());

			}
		});
		return controller;
	}

	public void updateUI(AnimalHealthRequest request) {

		boolean isVeterinary = RequestType.VETERINARY.equals(request.getType());

		// If type doesn't change,we didn't need to do anything here
		if (request.getType().equals(this.previousType)) {
			return;
		}
		DateTimeUtils.disposeAllChildrens(this.specialComp);
		if (isVeterinary) {
			// Create veterinaryControls
			createVeterinaryControls(specialComp);
		} else {
			createInseminationControls(specialComp);
		}
		this.comp.layout(true, true);
		// this.comp.getParent().layout(true,true);
		this.previousType = request.getType();

	}

	private void createVeterinaryControls(Composite parent) {
		verternaryComp = UIControlsFactory.createComposite(parent);
		GridLayout layout = new GridLayout(1, false);
		verternaryComp.setLayout(layout);
		verternaryComp.setLayoutData(new GridData(GridData.FILL_BOTH));

		UIControlsFactory.createLabel(verternaryComp, "Complaint");
		Text complaintText = UIControlsFactory.createText(verternaryComp);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = 100;
		data.widthHint = 300;
		parent.getParent().layout(true);
		complaintText.setLayoutData(data);
		this.addUIControl(complaintText, BIND_ID_VERY_THIRD_COMPLAINT);
		injectedControls.add(complaintText);

	}

	private void createInseminationControls(Composite parent) {

		inseminationComp = UIControlsFactory.createComposite(parent);
		inseminationComp.setLayout(GridLayoutFactory.swtDefaults()
				.margins(0, 0).create());
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				inseminationComp);
		this.addUIControl(inseminationComp, "insemination-comp");
		injectedControls.add(inseminationComp);

		inseminationGroup = UIControlsFactory.createGroup(inseminationComp,
				"Request Details");
		GridLayout layout = new GridLayout(3, false);
		inseminationGroup.setLayout(layout);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				inseminationGroup);

		UIControlsFactory.createLabel(inseminationGroup, "Time Heat Detected"); //$NON-NLS-1$
		Text txtDate = UIControlsFactory.createText(inseminationGroup);
		GridData dateData = new GridData(GridData.FILL_HORIZONTAL);
		dateData.horizontalSpan = 1;
		txtDate.setLayoutData(dateData);
		addUIControl(txtDate, BIND_ID_INSE_TIME_HEATED_DETECTED);
		injectedControls.add(txtDate);

		// Calendar Button
		Button button = new Button(inseminationGroup, SWT.PUSH);
		Image calendar = Activator.getImage(ImageRegistry.calendar);
		button.setImage(calendar);
		GridDataFactory.swtDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(
				17, 16).applyTo(button);
		// Insemination
		Label insemLabel = UIControlsFactory.createLabel(inseminationGroup,
				"Insemination"); //$NON-NLS-1$
		GridDataFactory.fillDefaults().span(3, 1).applyTo(insemLabel);

		GridDataFactory textGridFactory = GridDataFactory.fillDefaults().span(
				2, 1);
		GridDataFactory indentGridFactory = GridDataFactory.fillDefaults()
				.indent(10, 0);
		// First
		Label firstLabel = UIControlsFactory.createLabel(inseminationGroup,
				"First"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstLabel);

		Text firstText = UIControlsFactory.createText(inseminationGroup);

		textGridFactory.applyTo(firstText);
		addUIControl(firstText, BIND_ID_INSE_FIRST_TRETMENT);
		injectedControls.add(firstText);

		// First Repeat
		Label firstRepeatLabel = UIControlsFactory.createLabel(
				inseminationGroup, "First Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(firstRepeatLabel);

		Text firstRepeatText = UIControlsFactory.createText(inseminationGroup);
		textGridFactory.applyTo(firstRepeatText);
		addUIControl(firstRepeatText, BIND_ID_INSE_SECOND_TRETMENT);
		injectedControls.add(firstRepeatText);

		// 2nd Repeat
		Label secondRepeatLabel = UIControlsFactory.createLabel(
				inseminationGroup, "2nd Repeat"); //$NON-NLS-1$
		indentGridFactory.applyTo(secondRepeatLabel);

		Text secondRepeatText = UIControlsFactory.createText(inseminationGroup);
		textGridFactory.applyTo(secondRepeatText);

		addUIControl(secondRepeatText, BIND_ID_INSE_THIRD_TRETMENT);
		injectedControls.add(secondRepeatText);
	}
}
