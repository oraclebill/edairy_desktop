package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ILinkRidget;
import org.eclipse.riena.ui.ridgets.IMarkableRidget;
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
import com.agritrace.edairy.desktop.common.ui.controllers.BaseDialogController;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberContainerWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberLiveStockWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;

public class AddMemberDialogController extends BaseDialogController<Membership> {

	private class AddMemberPropertyChangedListener implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			enableSaveButton(validate());
		}

	}

	private final class UpdateMemberPhotoAction implements ISelectionListener {
		@Override
		public void ridgetSelected(SelectionEvent event) {
			// TODO - open file selection dialog, get the bits, and stuff them
			// into the model...
			throw new UnsupportedOperationException("unimplemented");
		}
	}

	public static final String DIALOG_TITLE = "Membership";
	public static final Collection<String> VALID_NAME_SUFFIXES = Arrays.asList("Jr.", "Sr.", "Esq.", "II", "III", "IV",
			"V");

	// reference data
	public static final Collection<String> VALID_TITLES = Arrays.asList("Mr.", "Mrs.", "Miss", "Dr.", "Prof.", "Ms.",
			"Hon.", "Lt.", "Maj.", "Col.", "Gen.");

	// field to model mappings
	// public static final

	private ITextRidget addtlNameRidget;

	// collection tab
	private MemberCollectionRecordsWidgetController collectionController;
	// container tab
	private MemberContainerWidgetController containerController;
	private ITextRidget familyNameRidget;
	// farm tab
	private MemberFarmWidgetController farmController;
	// upper panel fields
	private ILabelRidget formattedMemberNameRidget;
	private ITextRidget givenNameRidget;
	// live stock tab
	private MemberLiveStockWidgetController liveStockController;
	private Map<IRidget, FeaturePath> memberBindings;
	private ILabelRidget memberIdRidget;
	private MemberProfileWidgetController memberProfileController;

	private ITextRidget middleNameRidget;

	private ILabelRidget photoRidget;

	private IComboRidget suffixRidget;

	private IComboRidget titleRidget;

	// transaction tab
	private MemberTransactionWidgetController transactionController;

	private final UpdateMemberPhotoAction updateMemberPhotoAction = new UpdateMemberPhotoAction();

	private ILinkRidget updatePhotoActionRidget;

	//
	// protected IConverter formattedNameConverter = new Converter(Person.class,
	// String.class) {
	// @Override
	// public Object convert(Object from) {
	// if (from instanceof Person) {
	// return formattedMemberName((Person) from);
	// }
	// return "";
	// }
	// };

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

	// TODO: make this generic, move to util calss.

	public AddMemberDialogController() {

	}

	@Override
	public void configureRidgets() {
		super.configureRidgets();

		getWindowRidget().setTitle(DIALOG_TITLE);
		setWorkingCopy((Membership) getContext("selectedMember"));

		configureUpperPanel();

		memberProfileController = new MemberProfileWidgetController(this);
		farmController = new MemberFarmWidgetController(this);
		collectionController = new MemberCollectionRecordsWidgetController(this);
		liveStockController = new MemberLiveStockWidgetController(this);
		containerController = new MemberContainerWidgetController(this);
		transactionController = new MemberTransactionWidgetController(this);

		if (getWorkingCopy() != null) {
			memberBindings = initMemberBindings();
			updateBindings();
		}
		configureButtonsPanel();
		addPropertyChangedListener();
		enableSaveButton(validate());

	}

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

	private void updateBindings() {
		updateUpperPanelBinding();

		final Membership selectedMember = getWorkingCopy();
		memberProfileController.setInputModel(selectedMember);
		farmController.setInputModel(selectedMember);
		collectionController.setInputModel(selectedMember);
		liveStockController.setInputModel(selectedMember);
		containerController.setInputModel(selectedMember);
		transactionController.setInputModel(selectedMember);
	}

	protected void addPropertyChangedListener() {
		final AddMemberPropertyChangedListener propertyChangedListener = new AddMemberPropertyChangedListener();
		final Iterator<IRidget> ridgetIterator = (Iterator<IRidget>) getRidgets().iterator();
		while (ridgetIterator.hasNext()) {
			final IRidget ridget = ridgetIterator.next();
			if (ridget instanceof ITextRidget) {
				ridget.addPropertyChangeListener("text", propertyChangedListener);
			} else if (ridget instanceof IComboRidget) {
				ridget.addPropertyChangeListener("selection", propertyChangedListener);
			} else if (ridget instanceof IMarkable) {
				ridget.addPropertyChangeListener("marker", propertyChangedListener);
			}
		}
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
		// titleRidget.setOutputOnly(true);
		titleRidget.setEmptySelectionItem("(None)");

		// suffixRidget.setOutputOnly(true);
		suffixRidget.setEmptySelectionItem("(None)");

		givenNameRidget.setMandatory(true);
		familyNameRidget.setMandatory(true);

		// formattedMemberNameRidget.setModelToUIControlConverter(formattedNameConverter);

		updatePhotoActionRidget.setText("(click to update photo)");
		updatePhotoActionRidget.addSelectionListener(updateMemberPhotoAction);

		// add validator to update the header
		givenNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		middleNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		familyNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);
		addtlNameRidget.addValidationRule(updateValidator, ValidationTime.ON_UPDATE_TO_MODEL);

	}

	protected void saveMember() {
		final Membership selectedMember = getWorkingCopy();
		if (selectedMember != null) {
			repository.saveNew(selectedMember);
		}
	}

	protected void updateUpperPanelBinding() {
		final Membership selectedMember = getWorkingCopy();
		Assert.isLegal((null != selectedMember) && (null != selectedMember.getMember()));
		if (selectedMember.getMember() != null) {
			// loop through the text ridgets
			for (final IRidget r : memberBindings.keySet()) {
				if (r instanceof IValueRidget) {

					final IObservableValue oberservModel = EMFProperties.value(memberBindings.get(r)).observe(
							selectedMember);
					// need to bind model to UI control converter again, because
					// the fromType instance changes every time
					if (r == formattedMemberNameRidget) {
						formattedMemberNameRidget.setModelToUIControlConverter(new Converter(oberservModel
								.getValueType(), String.class) {
							@Override
							public Object convert(Object from) {
								if (from instanceof Person) {
									return MemberUtil.formattedMemberName((Person) from);
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
