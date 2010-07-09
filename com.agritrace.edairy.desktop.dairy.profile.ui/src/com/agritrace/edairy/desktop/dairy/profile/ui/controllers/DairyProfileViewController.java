package com.agritrace.edairy.desktop.dairy.profile.ui.controllers;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.IEditableRidget;
import org.eclipse.riena.ui.ridgets.IInfoFlyoutRidget.InfoFlyoutData;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ILinkRidget;
import org.eclipse.riena.ui.ridgets.INumericTextRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IWindowRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.validation.RequiredField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.dairy.profile.ui.DairyProfileViewWidgetID;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;

/**
 * Dairy Profile view controller
 * 
 * @author Bill Jones
 * 
 */
public class DairyProfileViewController extends SubModuleController {

	class DairyProfileCancelAction implements IActionListener {
		@Override
		public void callback() {
			// if (!newDairy) {
			// localDairy =
			// dairyRepository.getDairyById(localDairy.getCompanyId());
			// } else {
			// localDairy = dairyRepository.reloadLocalDairy();
			// }
			localDairy = dairyRepository.getLocalDairy();
			initBindings();
			updateBindings();
		}
	}

	class DairyProfileSaveAction implements IActionListener {
		@Override
		public void callback() {
			try {
				IWindowRidget ri = getRidget(IWindowRidget.class, "Null");
				
				validateProfile();
				dairyRepository.updateDairy();
				updateBindings();
				getInfoFlyout().addInfo(new InfoFlyoutData("message", "Dairy profile updated successfully."));
//			} catch (ValidationException e) {
			} catch (Exception e) {
				getInfoFlyout().addInfo(new InfoFlyoutData("message", "Error updating dairy profile!"));
			}
		}
	}

	class UpdateImageActionListener implements ISelectionListener {
		@Override
		public void ridgetSelected(SelectionEvent event) {
			FileDialog fileDialog = new FileDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.OPEN
					| SWT.SHEET);
			fileDialog.setText("Open Profile Image");
			String fileName = fileDialog.open();
			if (fileName != null) {
				ImageLoader imgLoader = new ImageLoader();
				ImageData[] imgData = imgLoader.load(fileName);
				if (imgData != null && imgData.length > 0) {
					for (ImageData fileData : imgData) {
						// fileData.
					}
				}

			}

		}
	}

	public static final String ID = DairyProfileViewController.class.getName();
	private IActionRidget cancelAction;
	private CommunicationGroupController communicationGroup;
	private final IDairyRepository dairyRepository = DairyRepository.getInstance();
	private Dairy localDairy;

	private LocationProfileWidgetController locationController;
	private int memberCount;
	private IActionRidget saveAction;
	private IDateTimeRidget txtESTABLISHED_DATE;
	private ITextRidget txtFEDERAL_PIN;
	// main page
	private ITextRidget txtID;
	private ITextRidget txtLEGAL_NAME;

	private IDateTimeRidget txtLIC_EFFECTIVE_DATE;
	private IDateTimeRidget txtLIC_EXPIRATION_DATE;

	private INumericTextRidget txtMEMBER_COUNT;
	private ITextRidget txtNAME;

	private ITextRidget txtNHIF_NUMBER;
	private ITextRidget txtNSSF_NUMBER;
	private ITextRidget txtPHONE;

	private ILabelRidget txtPROFILE_IMAGE;

	private ILinkRidget txtPROFILE_IMAGE_LINK;

	private ITextRidget txtPUBLIC_DESCRIPTION;

	private ITextRidget txtREGISTRATION_NBR;

	/**
	 * Constructor
	 * 
	 */
	public DairyProfileViewController() {
		super();
		localDairy = dairyRepository.getLocalDairy();
	}

	public void validateProfile() {
		for (IRidget ridget : getRidgets()) {
			if (ridget instanceof IEditableRidget) {
				IEditableRidget editable = (IEditableRidget) ridget;
				if ( !editable.revalidate() ) { 
					editable.requestFocus();					
					throw new RuntimeException();
				}
			}
		}		
	}

	@Override
	public void afterBind() {
		super.afterBind();
		initBindings();
		updateBindings();
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle("Dairy Profile");

		configureInfoPanelRidgets();
		locationController = new LocationProfileWidgetController(this);
		communicationGroup = new CommunicationGroupController(this);

		configureButtonsPanel();
	}

	/**
	 * Get member count for UI.
	 * 
	 * TODO: for now, we fake it..
	 * 
	 * @return
	 */
	public int getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(int val) {
		memberCount = val;
	}

	/**
	 * @Override public void addDefaultAction(IRidget focusRidget, IActionRidget
	 *           action) { // TODO Auto-generated method stub
	 *           super.addDefaultAction(focusRidget, action);
	 *           System.err.println(">>>>>>>>>>>>>>>>>> addDefaultAction: " +
	 *           focusRidget + ", " + action); }
	 * @Override public IInfoFlyoutRidget getInfoFlyout() { // TODO
	 *           Auto-generated method stub
	 *           System.err.println(">>>>>>>>>>>>>>>>>> getInfoFlyout: ");
	 * 
	 *           return super.getInfoFlyout(); }
	 * @Override public IRidget getInitialFocus() { // TODO Auto-generated
	 *           method stub
	 *           System.err.println(">>>>>>>>>>>>>>>>>> getInitialFocus: ");
	 * 
	 *           return super.getInitialFocus(); }
	 * @Override public ModuleController getModuleController() { // TODO
	 *           Auto-generated method stub
	 *           System.err.println(">>>>>>>>>>>>>>>>>> getModuleController: ");
	 * 
	 *           return super.getModuleController(); }
	 * @Override public IWindowRidget getWindowRidget() { // TODO Auto-generated
	 *           method stub
	 *           System.err.println(">>>>>>>>>>>>>>>>>> getWindowRidget: ");
	 * 
	 *           return super.getWindowRidget(); }
	 * @Override public void setInitialFocus(IRidget ridget) { // TODO
	 *           Auto-generated method stub super.setInitialFocus(ridget);
	 *           System.err.println(">>>>>>>>>>>>>>>>>> setInitialFocus: " +
	 *           ridget);
	 * 
	 *           }
	 * @Override public void setNavigationNode(ISubModuleNode navigationNode) {
	 *           // TODO Auto-generated method stub
	 *           super.setNavigationNode(navigationNode);
	 *           System.err.println(">>>>>>>>>>>>>>>>>> setNavigationNode: " +
	 *           navigationNode);
	 * 
	 *           }
	 * @Override public void setWindowRidget(IWindowRidget windowRidget) { //
	 *           TODO Auto-generated method stub
	 *           super.setWindowRidget(windowRidget);
	 *           System.err.println(">>>>>>>>>>>>>>>>>> setWindowRidget: " +
	 *           windowRidget);
	 * 
	 *           }
	 * @Override public void updateAllRidgetsFromModel() { // TODO
	 *           Auto-generated method stub super.updateAllRidgetsFromModel();
	 *           System
	 *           .err.println(">>>>>>>>>>>>>>>>>> updateAllRidgetsFromModel: ");
	 * 
	 *           }
	 * @Override protected void updateIcon(IWindowRidget windowRidget) { // TODO
	 *           Auto-generated method stub super.updateIcon(windowRidget);
	 *           System.err.println(">>>>>>>>>>>>>>>>>> updateIcon: " +
	 *           windowRidget);
	 * 
	 *           }
	 */
	/**
	 * Configure teh button panel.
	 * 
	 */
	private void configureButtonsPanel() {
		saveAction = (IActionRidget) getRidget(DairyProfileViewWidgetID.DAIRY_SAVE);
		saveAction.addListener(new DairyProfileSaveAction());
		cancelAction = (IActionRidget) getRidget(DairyProfileViewWidgetID.DAIRY_CANCEL);
		cancelAction.addListener(new DairyProfileCancelAction());
	}

	/**
	 * Configures the ridgets in teh upper panel.
	 * 
	 */
	private void configureInfoPanelRidgets() {

		// top panel
		txtID = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_ID);
		txtID.setOutputOnly(true);
		txtNAME = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_NAME);
		txtNAME.addValidationRule(new RequiredField(), ValidationTime.ON_UI_CONTROL_EDIT);

		txtPHONE = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_PHONE_NUMBER);
		txtPHONE.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);

		txtPUBLIC_DESCRIPTION = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_PUBLIC_DESCRIPTION);
		txtPUBLIC_DESCRIPTION.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);

		txtESTABLISHED_DATE = getRidget(IDateTimeRidget.class, DairyProfileViewWidgetID.DAIRY_ESTABLISHED_DATE);

		txtPROFILE_IMAGE = getRidget(ILabelRidget.class, DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);
		txtPROFILE_IMAGE_LINK = getRidget(ILinkRidget.class, DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE_LINK);

		txtPROFILE_IMAGE_LINK.addSelectionListener(new UpdateImageActionListener());

		txtMEMBER_COUNT = getRidget(INumericTextRidget.class, DairyProfileViewWidgetID.DAIRY_MEMBER_COUNT);
		txtMEMBER_COUNT.setOutputOnly(true);
		txtMEMBER_COUNT.setGrouping(true);
		txtMEMBER_COUNT.setFocusable(false);

		// registration tab
		txtLEGAL_NAME = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_LEGAL_NAME);
		txtLEGAL_NAME.addValidationRule(new RequiredField(), ValidationTime.ON_UI_CONTROL_EDIT);

		txtREGISTRATION_NBR = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_REGISTRATION_NUMBER);
		txtREGISTRATION_NBR.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);

		txtNSSF_NUMBER = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_NSSF_NUMBER);
		txtNHIF_NUMBER = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_NHIF_NUMBER);
		txtFEDERAL_PIN = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_FEDERAL_PIN);
		txtLIC_EFFECTIVE_DATE = getRidget(IDateTimeRidget.class, DairyProfileViewWidgetID.DAIRY_LIC_EFFECTIVE_DATE);
		txtLIC_EXPIRATION_DATE = getRidget(IDateTimeRidget.class, DairyProfileViewWidgetID.DAIRY_LIC_EXPIRATION_DATE);

	}

	/**
	 * Initialize bindings (bind to model).
	 * 
	 */
	private void initBindings() {
		// info panel
		txtID.bindToModel(localDairy, "companyId");
		txtNAME.bindToModel(localDairy, "companyName");
		txtPHONE.bindToModel(localDairy, "phoneNumber");
		txtPUBLIC_DESCRIPTION.bindToModel(localDairy, "description");
		txtPROFILE_IMAGE.bindToModel(localDairy, "profilePhoto");

		txtNSSF_NUMBER.bindToModel(localDairy, "managerName");
		txtESTABLISHED_DATE.bindToModel(localDairy, "establishedDate");
		txtMEMBER_COUNT.bindToModel(this, "memberCount");
		setMemberCount(localDairy.getMemberships().size());
		// registration panel
		txtLEGAL_NAME.bindToModel(localDairy, "legalName");
		txtREGISTRATION_NBR.bindToModel(localDairy, "registrationNumber");
		txtNSSF_NUMBER.bindToModel(localDairy, "nssfNumber");
		txtNHIF_NUMBER.bindToModel(localDairy, "nhifNumber");
		txtFEDERAL_PIN.bindToModel(localDairy, "federalPin");
		txtLIC_EFFECTIVE_DATE.bindToModel(localDairy, "licenseEffectiveDate");
		txtLIC_EXPIRATION_DATE.bindToModel(localDairy, "licenseExpirationDate");

		locationController.setInputModel(localDairy.getLocation());
		communicationGroup.setInputModel(localDairy.getContactMethods());
	}

	/**
	 * Update the info displayed from the model.
	 * 
	 */
	private void updateBindings() {
		// info panel
		txtNAME.updateFromModel();
		txtID.updateFromModel();
		txtPHONE.updateFromModel();
		txtESTABLISHED_DATE.updateFromModel();
		txtNSSF_NUMBER.updateFromModel();
		txtMEMBER_COUNT.updateFromModel();
		// txtPROFILE_IMAGE.updateFromModel();
		txtPUBLIC_DESCRIPTION.updateFromModel();

		// registration panel
		txtLEGAL_NAME.updateFromModel();
		txtREGISTRATION_NBR.updateFromModel();
		txtNSSF_NUMBER.updateFromModel();
		txtNHIF_NUMBER.updateFromModel();
		txtFEDERAL_PIN.updateFromModel();
		txtLIC_EFFECTIVE_DATE.updateFromModel();
		txtLIC_EXPIRATION_DATE.updateFromModel();

		locationController.updateBinding();
		communicationGroup.updateBinding();
	}
}
