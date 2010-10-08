package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidgetController;

public class AddMemberDialogController extends BaseDialogController<Membership> {

	private class AddMemberPropertyChangedListener implements
			PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			enableSaveButton(validate());
		}

	}

	public static final String DIALOG_TITLE = "Membership";
	public static final Collection<String> VALID_NAME_SUFFIXES = Arrays.asList(
			"Jr.", "Sr.", "Esq.", "II", "III", "IV", "V");

	// reference data
	public static final Collection<String> VALID_TITLES = Arrays.asList("Mr.",
			"Mrs.", "Miss", "Dr.", "Prof.", "Ms.", "Hon.", "Lt.", "Maj.",
			"Col.", "Gen.");

	// field to model mappings
	// public static final

	private ITextRidget addtlNameRidget;
    private ITextRidget familyNameRidget;

	// upper panel fields
	private ILabelRidget formattedMemberNameRidget;
	private ITextRidget givenNameRidget;
	// live stock tab
//	private MemberLiveStockWidgetController liveStockController;
	private Map<IRidget, FeaturePath> memberBindings;
	private ITextRidget memberNbrRidget;
	private MemberProfileWidgetController memberProfileController;

	private ITextRidget middleNameRidget;
	private ITextRidget nssfRidget;
	private ITextRidget nationalIdRidget;
	private ITextRidget nhifRidget;

	private IProfilePhotoRidget photoRidget;

	private IComboRidget suffixRidget;

	private IComboRidget titleRidget;

	private final IValidator updateValidator = new IValidator() {
		@Override
		public IStatus validate(Object arg0) {
			if (formattedMemberNameRidget != null) {
				formattedMemberNameRidget.updateFromModel();
			}
			return Status.OK_STATUS;
		}
	};

	protected Farmer selectedMembershipOwner;

	public AddMemberDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		setWorkingCopy((Membership) getContext("selectedMember"));

		configureUpperPanel();
		configureTabs();

		if (getWorkingCopy() != null) {
			memberBindings = initMemberBindings();
			updateBindings();
		}
		configureButtonsPanel();
		addPropertyChangedListener();
		enableSaveButton(validate());

	}

	protected void configureTabs(){
		memberProfileController = new MemberProfileWidgetController(this);
	}

	private Map<IRidget, FeaturePath> initMemberBindings() {
		final Map<IRidget, FeaturePath> aMap = new HashMap<IRidget, FeaturePath>();

		// formatted name
		aMap.put(formattedMemberNameRidget,
				FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER)); // uses
		// converter
		// member id
		aMap.put(memberNbrRidget, FeaturePath
				.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER_NUMBER));

		// member first name
		aMap.put(givenNameRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__GIVEN_NAME));

		// member middle name
		aMap.put(middleNameRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__MIDDLE_NAME));

		// member family name
		aMap.put(familyNameRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__FAMILY_NAME));

		// member additional names
		aMap.put(addtlNameRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__ADDITIONAL_NAMES));

		// member title (prefix)
		aMap.put(titleRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__HONORIFIC));

		// member suffix
		aMap.put(suffixRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__SUFFIX));

		// member photo
		aMap.put(photoRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__PHOTO));

		// nssf
		aMap.put(nssfRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NSSF_NUMBER));

		// nhif
		aMap.put(nhifRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NHIF_NUMBER));

		// nationalId
		aMap.put(nationalIdRidget, FeaturePath.fromList(
				DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NATIONAL_ID));

		return aMap;
	}

	protected void updateBindings() {
		updateUpperPanelBinding();
		final Membership selectedMember = getWorkingCopy();
		memberProfileController.setInputModel(selectedMember);
	}

	protected void addPropertyChangedListener() {
		final AddMemberPropertyChangedListener propertyChangedListener = new AddMemberPropertyChangedListener();

		for (final IRidget ridget: getRidgets()) {
			if (ridget instanceof ITextRidget) {
				ridget.addPropertyChangeListener("text",
						propertyChangedListener);
			} else if (ridget instanceof IComboRidget) {
				ridget.addPropertyChangeListener("selection",
						propertyChangedListener);
			} else if (ridget instanceof IMarkable) {
				ridget.addPropertyChangeListener("marker",
						propertyChangedListener);
			}
		}
	}

	protected void configureUpperPanel() {
		formattedMemberNameRidget = getRidget(ILabelRidget.class,
				ViewWidgetId.memberInfo_formattedName);
		memberNbrRidget = getRidget(ITextRidget.class,
				ViewWidgetId.memberInfo_memberNbr);
		givenNameRidget = getRidget(ITextRidget.class,
				ViewWidgetId.memberInfo_firstName);

		middleNameRidget = getRidget(ITextRidget.class,
				ViewWidgetId.memberInfo_middleName);
		familyNameRidget = getRidget(ITextRidget.class,
				ViewWidgetId.memberInfo_lastName);
		addtlNameRidget = getRidget(ITextRidget.class,
				ViewWidgetId.memberInfo_additionalNames);
		titleRidget = getRidget(IComboRidget.class,
				ViewWidgetId.memberInfo_honorific);
		suffixRidget = getRidget(IComboRidget.class,
				ViewWidgetId.memberInfo_suffix);
		photoRidget = getRidget(IProfilePhotoRidget.class,
				ViewWidgetId.memberPhoto);

		nssfRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_nssfId);
		nhifRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_nhifId);
		nationalIdRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_nationalId);

		// extended setup
		// titleRidget.setOutputOnly(true);
		titleRidget.setEmptySelectionItem("(None)");

		// suffixRidget.setOutputOnly(true);
		suffixRidget.setEmptySelectionItem("(None)");

		givenNameRidget.setMandatory(true);
		familyNameRidget.setMandatory(true);

		// formattedMemberNameRidget.setModelToUIControlConverter(formattedNameConverter);

		// add validator to update the header
		givenNameRidget.addValidationRule(updateValidator,
				ValidationTime.ON_UPDATE_TO_MODEL);
		middleNameRidget.addValidationRule(updateValidator,
				ValidationTime.ON_UPDATE_TO_MODEL);
		familyNameRidget.addValidationRule(updateValidator,
				ValidationTime.ON_UPDATE_TO_MODEL);
		addtlNameRidget.addValidationRule(updateValidator,
				ValidationTime.ON_UPDATE_TO_MODEL);

	}

	protected void saveMember() {
		final Membership selectedMember = getWorkingCopy();
		if (selectedMember != null) {
			repository.saveNew(selectedMember);
		}
	}

	protected void updateUpperPanelBinding() {
		final Membership selectedMember = getWorkingCopy();

		if(null == selectedMember || null == selectedMember.getMember()) {
			throw new IllegalStateException();
		}

		if (selectedMember.getMember() != null) {
			// loop through the text ridgets
			for (final IRidget r : memberBindings.keySet()) {

				if (r instanceof IValueRidget) {

					final IObservableValue oberservModel = EMFProperties.value(
							memberBindings.get(r)).observe(selectedMember);
					// need to bind model to UI control converter again, because
					// the fromType instance changes every time
					if (r == formattedMemberNameRidget) {
						formattedMemberNameRidget
								.setModelToUIControlConverter(new Converter(
										oberservModel.getValueType(),
										String.class) {
							@Override
							public Object convert(Object from) {
								if (from instanceof Person) {
											return MemberUtil
													.formattedMemberName((Person) from);
								}
								return "";
							}
						});
					}
					((IValueRidget) r).bindToModel(oberservModel);
				}
			}

			// manually bind the combos (for now)..
			titleRidget.bindToModel(
					new WritableList(VALID_TITLES, String.class), String.class,
					null, EMFObservables.observeValue(selectedMember,
							ModelPackage.Literals.PERSON__HONORIFIC));
			suffixRidget.bindToModel(new WritableList(VALID_NAME_SUFFIXES,
					String.class), String.class, null, EMFObservables
					.observeValue(selectedMember,
							ModelPackage.Literals.PERSON__SUFFIX));

			// tap, tap..
			memberNbrRidget.updateFromModel();
			for (final IRidget r : memberBindings.keySet()) {
				if (r instanceof IValueRidget) {
					((IValueRidget) r).updateFromModel();
				}
			}
			titleRidget.updateFromModel();
			suffixRidget.updateFromModel();
		}
	}

	@Override
	protected boolean validate() {
		for (final IRidget ridget : getRidgets()) {
			IMarkableRidget markable;
			if (ridget instanceof IMarkableRidget) {
				markable = (IMarkableRidget) ridget;
				if (markable.isErrorMarked()) {
					return false;
				}
				if (markable.isMandatory()) {
					if (ridget instanceof ITextRidget) {
						if (((ITextRidget) ridget).getText().isEmpty()) {
							return false;
						}
					} else if (ridget instanceof IComboRidget) {
						if (((IComboRidget) ridget).getSelection() == null) {
							return false;
						}
					}
				}
			}
		}
		return true;

	}
}
