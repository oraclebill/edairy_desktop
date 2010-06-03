package com.agritrace.edairy.desktop.member.ui.dialog.controller;

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
import org.eclipse.jface.util.Assert;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ILinkRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.IValueRidget;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;

public class AddMemberDialogController extends BaseDialogController<Membership> {

	private final class UpdateMemberPhotoAction implements ISelectionListener {
		@Override
		public void ridgetSelected(SelectionEvent event) {
			// TODO - open file selection dialog, get the bits, and stuff them
			// into the model...
			throw new UnsupportedOperationException("unimplemented");
		}
	}

	public static final String DIALOG_TITLE = "Membership";

	// reference data
	public static final Collection<String> VALID_TITLES = Arrays.asList("Mr.", "Mrs.", "Miss", "Dr.", "Prof.", "Ms.",
			"Hon.", "Lt.", "Maj.", "Col.", "Gen.");
	public static final Collection<String> VALID_NAME_SUFFIXES = Arrays.asList("Jr.", "Sr.", "Esq.", "II", "III", "IV",
			"V");

	private Map<IRidget, FeaturePath> memberBindings;

	// field to model mappings
	// public static final

	protected Farmer selectedMembershipOwner;

	// upper panel fields
	private ILabelRidget formattedMemberNameRidget;
	private ILabelRidget memberIdRidget;
	private ITextRidget givenNameRidget;
	private ITextRidget middleNameRidget;
	private ITextRidget familyNameRidget;
	private ITextRidget addtlNameRidget;
	private IComboRidget titleRidget;
	private IComboRidget suffixRidget;
	private ILabelRidget photoRidget;
	private ILinkRidget updatePhotoActionRidget;

	private MemberProfileWidgetController memberProfileController;

	// container tab
	private MemberContainerWidgetController containerController;

	// live stock tab
	private MemberLiveStockWidgetController liveStockController;

	// farm tab
	private MemberFarmWidgetController farmController;

	// collection tab
	private MemberCollectionRecordsWidgetController collectionController;

	// transaction tab
	private MemberTransactionWidgetController transactionController;

	private IValidator updateValidator = new IValidator() {
		
		@Override
		public IStatus validate(Object arg0) {
			if(formattedMemberNameRidget  != null){
				formattedMemberNameRidget.updateFromModel();
			}
			return Status.OK_STATUS;
		}
	};
	//
//	protected IConverter formattedNameConverter = new Converter(Person.class, String.class) {
//		@Override
//		public Object convert(Object from) {
//			if (from instanceof Person) {
//				return formattedMemberName((Person) from);
//			}
//			return "";
//		}
//	};

	public AddMemberDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		setSelected((Membership) getContext("selectedMember"));

		configureUpperPanel();

		memberProfileController = new MemberProfileWidgetController(this);
		farmController = new MemberFarmWidgetController(this);
		collectionController = new MemberCollectionRecordsWidgetController(this);
		liveStockController = new MemberLiveStockWidgetController(this);
		containerController = new MemberContainerWidgetController(this);
		transactionController = new MemberTransactionWidgetController(this);

		if (getSelected() != null) {
			memberBindings = initMemberBindings();
			updateBindings();
		}
		configureButtonsPanel();

	}

	// TODO: make this generic, move to util calss.
	private static boolean check(String s) {
		return (null != s) && (s.length() > 0);
	}

	private static String formattedMemberName(Person member) {
		String ret = "";
		final Person person = member;
		if (check(person.getHonorific()))
			ret += person.getHonorific() + " ";

		if (check(person.getFamilyName()))
			ret += person.getFamilyName() + ", ";

		if (check(person.getGivenName()))
			ret += person.getGivenName() + " ";

		if (check(person.getMiddleName()))
			ret += person.getMiddleName() + " ";

		if (check(person.getAdditionalNames()))
			ret += "(" + person.getAdditionalNames() + ") ";

		if (check(person.getSuffix()))
			ret += person.getSuffix() + " ";
		return ret;
	}

	protected void configureUpperPanel() {
		formattedMemberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberInfo_formattedName);
		memberIdRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberInfo_id);
		// generatedMemberId = System.currentTimeMillis()+"";
		// memberIdRidget.setText(generatedMemberId);
		givenNameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_firstName);

		middleNameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_middleName);
		familyNameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_lastName);
		addtlNameRidget = getRidget(ITextRidget.class, ViewWidgetId.memberInfo_additionalNames);
		titleRidget = getRidget(IComboRidget.class, ViewWidgetId.memberInfo_honorific);
		suffixRidget = getRidget(IComboRidget.class, ViewWidgetId.memberInfo_suffix);
		photoRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberPhoto);
		updatePhotoActionRidget = getRidget(ILinkRidget.class, ViewWidgetId.memberPhotoEditLink);

		// extended setup
//		titleRidget.setOutputOnly(true);
		titleRidget.setEmptySelectionItem("(None)");

//		suffixRidget.setOutputOnly(true);
		suffixRidget.setEmptySelectionItem("(None)");

		givenNameRidget.setMandatory(true);
		familyNameRidget.setMandatory(true);

//		formattedMemberNameRidget.setModelToUIControlConverter(formattedNameConverter);

		updatePhotoActionRidget.setText("(click to update photo)");
		updatePhotoActionRidget.addSelectionListener(updateMemberPhotoAction);
		
		//add validator to update the header
		givenNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		middleNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		familyNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		addtlNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);
	

	}

	private void updateBindings() {
		updateUpperPanelBinding();

		final Membership selectedMember = getSelected();
		memberProfileController.setInputModel(selectedMember);
		farmController.setInputModel(selectedMember);
		collectionController.setInputModel(selectedMember);
		liveStockController.setInputModel(selectedMember);
		containerController.setInputModel(selectedMember);
		transactionController.setInputModel(selectedMember);
	}

	private final UpdateMemberPhotoAction updateMemberPhotoAction = new UpdateMemberPhotoAction();

	private Map<IRidget, FeaturePath> initMemberBindings() {
		final Map<IRidget, FeaturePath> aMap = new HashMap<IRidget, FeaturePath>();

		// formatted name
		aMap.put(formattedMemberNameRidget, FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER)); // uses
																												// converter
		// member id
		aMap.put(memberIdRidget, FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER_ID));

		// member first name
		aMap.put(givenNameRidget, FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__GIVEN_NAME));

		// member middle name
		aMap.put(middleNameRidget, FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__MIDDLE_NAME));

		// member family name
		aMap.put(familyNameRidget, FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__FAMILY_NAME));

		// member additional names
		aMap.put(addtlNameRidget, FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__ADDITIONAL_NAMES));

		// member title (prefix)
		aMap.put(titleRidget,
				FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER, ModelPackage.Literals.PERSON__HONORIFIC));

		// member suffix
		aMap.put(suffixRidget,
				FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER, ModelPackage.Literals.PERSON__SUFFIX));

		// member photo
		aMap.put(photoRidget,
				FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER, ModelPackage.Literals.PERSON__PHOTO));

		// member photo update button
		// aMap.put(updatePhotoActionRidget, FeaturePath.fromList(
		// DairyPackage.Literals.MEMBERSHIP__MEMBER,
		// ModelPackage.Literals.PERSON__SUFFIX));

		return (aMap);
	}

	protected void updateUpperPanelBinding() {
		final Membership selectedMember = getSelected();
		Assert.isLegal((null != selectedMember) && (null != selectedMember.getMember()));
		if (selectedMember.getMember() != null) {
			// loop through the text ridgets
			for (final IRidget r : memberBindings.keySet()) {
				if (r instanceof IValueRidget) {
					
					IObservableValue oberservModel = EMFProperties.value(memberBindings.get(r)).observe(selectedMember);
					//need to bind model to UI control converter again, because the fromType instance changes every time
					if(r == formattedMemberNameRidget){
						formattedMemberNameRidget.setModelToUIControlConverter( new Converter(oberservModel.getValueType(), String.class) {
							@Override
							public Object convert(Object from) {
								if (from instanceof Person) {
									return formattedMemberName((Person) from);
								}
								return "";
							}
						});
					}
					((IValueRidget) r).bindToModel(oberservModel);
				}
			}

			// manually bind the combos (for now)..
			titleRidget.bindToModel(new WritableList(VALID_TITLES, String.class), String.class, null,
					EMFObservables.observeValue(selectedMember, ModelPackage.Literals.PERSON__HONORIFIC));
			suffixRidget.bindToModel(new WritableList(VALID_NAME_SUFFIXES, String.class), String.class, null,
					EMFObservables.observeValue(selectedMember, ModelPackage.Literals.PERSON__SUFFIX));

			// tap, tap..
			memberIdRidget.updateFromModel();
			for (final IRidget r : memberBindings.keySet()) {
				if (r instanceof IValueRidget){
					((IValueRidget) r).updateFromModel();
				}
			}
			titleRidget.updateFromModel();
			suffixRidget.updateFromModel();
		}
	}

	protected void saveMember() {
		final Membership selectedMember = getSelected();
		if (selectedMember != null) {
			repository.saveNew(selectedMember);
		}
	}

}
