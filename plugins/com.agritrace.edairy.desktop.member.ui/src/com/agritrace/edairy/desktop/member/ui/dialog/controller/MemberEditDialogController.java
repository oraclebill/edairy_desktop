package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farmer;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.common.ui.util.MemberUtil;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidgetController;

public class MemberEditDialogController extends RecordDialogController<Membership> {

	private class AddMemberPropertyChangedListener implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			enableSaveButton(validate());
		}
	}

	private final IValidator updateValidator = new IValidator() {
		@Override
		public IStatus validate(Object arg0) {
			if (formattedMemberNameRidget != null) {
				formattedMemberNameRidget.updateFromModel();
			}
			return Status.OK_STATUS;
		}
	};

	public static final String DIALOG_TITLE = "Membership";

	// reference data
	public static final List<String> VALID_NAME_SUFFIXES = Arrays.asList("Jr.", "Sr.", "Esq.", "II", "III", "IV", "V");
	public static final List<String> VALID_TITLES = Arrays.asList("Mr.", "Mrs.", "Miss", "Dr.", "Prof.", "Ms.", "Hon.",
			"Lt.", "Maj.", "Col.", "Gen.");

	// unmanaged upper panel fields
	private ILabelRidget formattedMemberNameRidget;
	private IProfilePhotoRidget photoRidget;

	private MemberProfileWidgetController memberProfileController;
	private final List<DairyLocation> collectionCenters;

	public MemberEditDialogController(final List<DairyLocation> dairyLocations) {
		collectionCenters = new ArrayList<DairyLocation>();
		collectionCenters.add(null);
		collectionCenters.addAll(dairyLocations);
	}

	@Override
	public void configureUserRidgets() {

		getWindowRidget().setTitle(DIALOG_TITLE);
		
		formattedMemberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberInfo_formattedName);
		photoRidget = getRidget(IProfilePhotoRidget.class, ViewWidgetId.memberPhoto);
		memberProfileController = new MemberProfileWidgetController(this);
		memberProfileController.setInputModel(getWorkingCopy());
		
		addRidgetMappings();		
		addPropertyChangedListener();
		enableSaveButton(validate());

	}

	private void addRidgetMappings() {
		addTextMap(ViewWidgetId.memberInfo_memberNbr, (DairyPackage.Literals.MEMBERSHIP__MEMBER_NUMBER));
		addTextMap(ViewWidgetId.memberInfo_firstName, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__GIVEN_NAME);
		addTextMap(ViewWidgetId.memberInfo_middleName, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__MIDDLE_NAME);
		addTextMap(ViewWidgetId.memberInfo_lastName, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__FAMILY_NAME);
		addTextMap(ViewWidgetId.memberInfo_additionalNames, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__ADDITIONAL_NAMES);
		addTextMap(ViewWidgetId.memberInfo_nssfId, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NSSF_NUMBER);
		addTextMap(ViewWidgetId.memberInfo_nhifId, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NHIF_NUMBER);
		addTextMap(ViewWidgetId.memberInfo_nationalId, DairyPackage.Literals.MEMBERSHIP__MEMBER,
				ModelPackage.Literals.PERSON__NATIONAL_ID);

		addComboMap(ViewWidgetId.memberInfo_honorific, VALID_TITLES, "toString",
				DairyPackage.Literals.MEMBERSHIP__MEMBER, ModelPackage.Literals.PERSON__HONORIFIC);
		addComboMap(ViewWidgetId.memberInfo_suffix, VALID_NAME_SUFFIXES, "toString",
				DairyPackage.Literals.MEMBERSHIP__MEMBER, ModelPackage.Literals.PERSON__SUFFIX);

		addComboMap(ViewWidgetId.memberInfo_defaultRoute, collectionCenters, "getCode",
				DairyPackage.Literals.MEMBERSHIP__DEFAULT_ROUTE);

	}

	private void addPropertyChangedListener() {
		final AddMemberPropertyChangedListener propertyChangedListener = new AddMemberPropertyChangedListener();

		for (final IRidget ridget : getRidgets()) {
			if (ridget instanceof ITextRidget) {
				ridget.addPropertyChangeListener("text", propertyChangedListener);
			} else if (ridget instanceof IComboRidget) {
				ridget.addPropertyChangeListener("selection", propertyChangedListener);
			} else if (ridget instanceof IMarkable) {
				ridget.addPropertyChangeListener("marker", propertyChangedListener);
			}
		}
	}



	@Override
	public void afterBind() {
		super.afterBind();

		final Membership selectedMember = getWorkingCopy();
		if (null == selectedMember || null == selectedMember.getMember()) {
			throw new IllegalStateException();
		}

		photoRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(), ModelPackage.Literals.PERSON__PHOTO));
		photoRidget.updateFromModel();

		// HACK
		final IObservableValue oberservModel = EMFProperties.value(FeaturePath.fromList(DairyPackage.Literals.MEMBERSHIP__MEMBER))
				.observe(selectedMember);
		formattedMemberNameRidget
				.setModelToUIControlConverter(new Converter(oberservModel.getValueType(), String.class) {
					@Override
					public Object convert(Object from) {
						if (from instanceof Person) {
							return MemberUtil.formattedMemberName((Person) from);
						}
						return "";
					}
				});

//		memberNbrRidget.updateFromModel();
		memberProfileController.setInputModel(getWorkingCopy());
	}

//
// @Override
// protected boolean validate() {
// for (final IRidget ridget : getRidgets()) {
// IMarkableRidget markable;
// if (ridget instanceof IMarkableRidget) {
// markable = (IMarkableRidget) ridget;
// if (markable.isErrorMarked()) {
// return false;
// }
// if (markable.isMandatory()) {
// if (ridget instanceof ITextRidget) {
// if (((ITextRidget) ridget).getText().isEmpty()) {
// return false;
// }
// } else if (ridget instanceof IComboRidget) {
// if (((IComboRidget) ridget).getSelection() == null) {
// return false;
// }
// }
// }
// }
// }
// return true;
//
// }
}
