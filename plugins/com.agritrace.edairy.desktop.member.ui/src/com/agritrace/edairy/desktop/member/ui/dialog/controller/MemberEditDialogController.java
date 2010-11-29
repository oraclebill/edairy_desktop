package com.agritrace.edairy.desktop.member.ui.dialog.controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.riena.core.marker.IMarkable;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.dairy.DairyLocation;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.util.MemberUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.RecordDialogController;
import com.agritrace.edairy.desktop.common.ui.controls.profilephoto.IProfilePhotoRidget;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.controls.MemberCollectionRecordsWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberFarmWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberProfileWidgetController;
import com.agritrace.edairy.desktop.member.ui.controls.MemberTransactionWidgetController;

public class MemberEditDialogController extends RecordDialogController<Membership> {

	private class AddMemberPropertyChangedListener implements PropertyChangeListener {
		@Override
		public void propertyChange(PropertyChangeEvent arg0) {
			enableSaveButton(validate());
			if (getWorkingCopy() != null)
				formattedMemberNameRidget.setText(
						MemberUtil.formattedMemberName(
								getRidget(IComboRidget.class, ViewWidgetId.memberInfo_honorific).getText(),
								getRidget(ITextRidget.class, ViewWidgetId.memberInfo_firstName).getText(),
								getRidget(ITextRidget.class, ViewWidgetId.memberInfo_middleName).getText(),
								getRidget(ITextRidget.class, ViewWidgetId.memberInfo_lastName).getText(),
								getRidget(ITextRidget.class, ViewWidgetId.memberInfo_additionalNames).getText(),
								getRidget(IComboRidget.class, ViewWidgetId.memberInfo_suffix).getText()));
		}
	}

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

	private IMemberRepository memberRepo;
	private IFarmRepository farmRepo;
	private IMilkCollectionRepository collectionsRepo;

	public MemberEditDialogController(final List<DairyLocation> dairyLocations) {
		this(dairyLocations, null, null, null);
	}

	public MemberEditDialogController(final List<DairyLocation> dairyLocations, IMemberRepository memberRepo,
			IFarmRepository farmRepo, IMilkCollectionRepository collectionsRepo) {
		collectionCenters = new ArrayList<DairyLocation>();
		collectionCenters.add(null);
		collectionCenters.addAll(dairyLocations);
		this.memberRepo = memberRepo;
		this.farmRepo = farmRepo;
		this.collectionsRepo = collectionsRepo;
	}

	@Override
	public void configureUserRidgets() {

		getWindowRidget().setTitle(DIALOG_TITLE);

		formattedMemberNameRidget = getRidget(ILabelRidget.class, ViewWidgetId.memberInfo_formattedName);
		if (getWorkingCopy() != null)
			formattedMemberNameRidget.setText(MemberUtil.formattedMemberName(getWorkingCopy().getMember()));

		photoRidget = getRidget(IProfilePhotoRidget.class, ViewWidgetId.memberPhoto);
		memberProfileController = new MemberProfileWidgetController(this);
		memberProfileController.setInputModel(getWorkingCopy());

		if (memberRepo != null) {
			MemberFarmWidgetController farmController = new MemberFarmWidgetController(this, farmRepo, memberRepo,
					null, null);
			MemberCollectionRecordsWidgetController collectionController = new MemberCollectionRecordsWidgetController(
					this, collectionsRepo);
			MemberTransactionWidgetController transactionController = new MemberTransactionWidgetController(this,
					memberRepo);
			final Membership selectedMember = getWorkingCopy();
			farmController.setInputModel(selectedMember);
			collectionController.setInputModel(selectedMember);
			transactionController.setInputModel(selectedMember);
		}

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

		Collection<? extends IRidget> ridgetsToList = getRidgets();
		for (IRidget ridget : ridgetsToList) {
			boolean bound = false;
			try {
				ridget.updateFromModel();
				bound = true;
			} catch (Exception e) {
				System.err.println("** Ridget ID: " + ridget.getID());
				System.err.println("\tType: " + ridget.getClass().getCanonicalName());
				System.err.println("\tControl: " + ridget.getUIControl());
				System.err.println("\tBound?: " + bound);
				System.err.println(".");
			}
		}

		super.afterBind();

		final Membership selectedMember = getWorkingCopy();
		if (null == selectedMember || null == selectedMember.getMember()) {
			throw new IllegalStateException();
		}

		photoRidget.bindToModel(EMFObservables.observeValue(selectedMember.getMember(),
				ModelPackage.Literals.PERSON__PHOTO));
		photoRidget.updateFromModel();

		memberProfileController.setInputModel(selectedMember);
	}
}
