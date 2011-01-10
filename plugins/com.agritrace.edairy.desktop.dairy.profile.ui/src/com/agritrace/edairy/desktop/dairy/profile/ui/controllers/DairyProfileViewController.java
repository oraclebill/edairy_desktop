package com.agritrace.edairy.desktop.dairy.profile.ui.controllers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IDateTimeRidget;
import org.eclipse.riena.ui.ridgets.INumericTextRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.validation.RequiredField;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.ui.controllers.location.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.IDataChangeListener;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.validators.PhoneNumberValidatiionRule;
import com.agritrace.edairy.desktop.dairy.profile.ui.DairyProfileViewWidgetID;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;

/**
 * Dairy Profile view controller
 *
 * @author Bill Jones
 *
 */
@PermissionRequired(UIPermission.VIEW_DAIRY_PROFILE)
public class DairyProfileViewController extends SubModuleController {
	private class DairyProfileSaveAction implements IFocusListener, ISelectionListener, IDataChangeListener {
		private void condenseContacts() {
			// TODO: this is really not safe.. need to lock dairy as well?
			synchronized (localDairy.getContactMethods()) {
				final List<ContactMethod> emptyMethods = new LinkedList<ContactMethod>();
				for (final ContactMethod method : localDairy.getContactMethods()) {
					if (method.getCmValue() == null || method.getCmValue().trim().length() == 0) {
						emptyMethods.add(method);
					}
				}
				localDairy.getContactMethods().removeAll(emptyMethods);
			}
		}

		private void update() {
			try {
				condenseContacts();
				validateProfile();
				dairyRepository.updateDairy();
				updateBindings();
				// getInfoFlyout().addInfo(new InfoFlyoutData("message", "Dairy profile updated successfully."));
			} catch (final Exception e) {
				// getInfoFlyout().addInfo(new InfoFlyoutData("message", "Error updating dairy profile!"));
			}
		}

		@Override
		public void focusGained(FocusEvent event) {
			// Do nothing
		}

		@Override
		public void focusLost(FocusEvent event) {
			update();
		}

		@Override
		public void ridgetSelected(SelectionEvent event) {
			update();
		}

		@Override
		public void dataChanged() {
			update();
		}
	}

	public static final String ID = DairyProfileViewController.class.getName();
	// private IActionRidget cancelAction;
	private IContactMethodsGroupRidget contactsGroup;
	private final IDairyRepository dairyRepository;
	private final Dairy localDairy;

	private LocationProfileWidgetController locationController;
	private int memberCount;
	// private IActionRidget saveAction;
	private IDateTimeRidget txtESTABLISHED_DATE;
	private ITextRidget txtMANAGER_NAME;
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

	private IProfilePhotoRidget txtPROFILE_IMAGE;

	// private ILinkRidget txtPROFILE_IMAGE_LINK;

	private ITextRidget txtPUBLIC_DESCRIPTION;
	private ITextRidget txtREGISTRATION_NBR;

	/**
	 * Constructor
	 *
	 */
	@Inject
	public DairyProfileViewController(final IDairyRepository dairyRepository) {
		this.dairyRepository = dairyRepository;
		localDairy = dairyRepository.getLocalDairy();
	}

	public void validateProfile() {
//		for (IRidget ridget : getRidgets()) {
//			if (ridget instanceof IEditableRidget) {
//				IEditableRidget editable = (IEditableRidget) ridget;
//				if (!editable.revalidate()) {
//					editable.requestFocus();
//					throw new RuntimeException();
//				}
//			}
//		}
	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle("Dairy Profile");

		configureInfoPanelRidgets();
		locationController = new LocationProfileWidgetController(this);
		contactsGroup = getRidget(IContactMethodsGroupRidget.class, DairyProfileViewWidgetID.CONTACT_METHODS);
		// configureButtonsPanel();
		contactsGroup.addFocusListener(new DairyProfileSaveAction());
	}

	@Override
	public void afterBind() {
		super.afterBind();
		initBindings();
		updateBindings();
		addDataChangeListener();
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
	 * Configure teh button panel.
	 *
	 */
	/*
	private void configureButtonsPanel() {
		saveAction = (IActionRidget) getRidget(DairyProfileViewWidgetID.DAIRY_SAVE);
		saveAction.setVisible(false);
		cancelAction = (IActionRidget) getRidget(DairyProfileViewWidgetID.DAIRY_CANCEL);
		cancelAction.setVisible(false);
	}
	*/

	/**
	 * Configures the ridgets in teh upper panel.
	 *
	 */
	private void configureInfoPanelRidgets() {
		new DairyProfileSaveAction();

		// top panel
		txtID = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_ID);
		txtID.setOutputOnly(true);
		txtNAME = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_NAME);
		txtNAME.addValidationRule(new RequiredField(), ValidationTime.ON_UI_CONTROL_EDIT);

		txtPHONE = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_PHONE_NUMBER);
		txtPHONE.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);
		txtPHONE.addValidationRule(new PhoneNumberValidatiionRule(), ValidationTime.ON_UI_CONTROL_EDIT);
		txtPHONE.setDirectWriting(true);

		txtPUBLIC_DESCRIPTION = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_PUBLIC_DESCRIPTION);
		txtPUBLIC_DESCRIPTION.addValidationRule(new RequiredField(), ValidationTime.ON_UPDATE_TO_MODEL);

		txtESTABLISHED_DATE = getRidget(IDateTimeRidget.class, DairyProfileViewWidgetID.DAIRY_ESTABLISHED_DATE);

		txtMANAGER_NAME = getRidget(ITextRidget.class, DairyProfileViewWidgetID.DAIRY_MANAGER_NAME);

		txtPROFILE_IMAGE = getRidget(IProfilePhotoRidget.class, DairyProfileViewWidgetID.DAIRY_PROFILE_IMAGE);

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

		txtMANAGER_NAME.bindToModel(localDairy, "managerName");
		txtESTABLISHED_DATE.bindToModel(localDairy, "establishedDate");
		txtMEMBER_COUNT.bindToModel(this, "memberCount");
		//setMemberCount(localDairy.getMemberships().size());
		// registration panel
		txtLEGAL_NAME.bindToModel(localDairy, "legalName");
		txtREGISTRATION_NBR.bindToModel(localDairy, "registrationNumber");
		txtNSSF_NUMBER.bindToModel(localDairy, "nssfNumber");
		txtNHIF_NUMBER.bindToModel(localDairy, "nhifNumber");
		txtFEDERAL_PIN.bindToModel(localDairy, "federalPin");
		txtLIC_EFFECTIVE_DATE.bindToModel(localDairy, "licenseEffectiveDate");
		txtLIC_EXPIRATION_DATE.bindToModel(localDairy, "licenseExpirationDate");

		locationController.setInputModel(localDairy.getLocation());
		contactsGroup.bindToModel(localDairy.getContactMethods());
	}

	/**
	 * Update the info displayed from the model.
	 *
	 */
	private void updateBindings() {
		updateAllRidgetsFromModel();
		locationController.updateBinding();
	}

	private void addDataChangeListener() {
		final DairyProfileSaveAction changeListener = new DairyProfileSaveAction();

		txtNAME.addFocusListener(changeListener);
		txtPHONE.addFocusListener(changeListener);
		txtPUBLIC_DESCRIPTION.addFocusListener(changeListener);
		txtMANAGER_NAME.addFocusListener(changeListener);
		txtPROFILE_IMAGE.addLinkSelectionListener(changeListener);
		txtLEGAL_NAME.addFocusListener(changeListener);
		txtREGISTRATION_NBR.addFocusListener(changeListener);
		txtNSSF_NUMBER.addFocusListener(changeListener);
		txtNHIF_NUMBER.addFocusListener(changeListener);
		txtFEDERAL_PIN.addFocusListener(changeListener);

		txtESTABLISHED_DATE.addFocusListener(changeListener);
		txtLIC_EFFECTIVE_DATE.addFocusListener(changeListener);
		txtLIC_EXPIRATION_DATE.addFocusListener(changeListener);

		locationController.addDataChangeListener(changeListener);
		contactsGroup.addDataChangeListener(changeListener);
	}
}
