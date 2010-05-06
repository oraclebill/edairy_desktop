package com.agritrace.edairy.ui.controllers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.validation.NotEmpty;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;


import com.agritrace.edairy.ui.views.data.LocalDairy;
import com.agritrace.edairy.ui.views.data.LocalDairyFactory;

public class LocalDairyViewController extends SubModuleController {

	public static final String ID = LocalDairyViewController.class.getName();

	/**
	 * Setup the ridgets for editing a person (text ridgets for name, single
	 * choice ridget for gender, multiple choice ridgets for pets).
	 */
	private static final class LocalDairyDelegation extends
			AbstractMasterDetailsDelegate {

		private static final String[] GENDER = { LocalDairy.FEMALE, LocalDairy.MALE };

		private final LocalDairy workingCopy = createWorkingCopy();

		public void configureRidgets(IRidgetContainer container) {
			ITextRidget txtFirst = (ITextRidget) container.getRidget("first"); //$NON-NLS-1$
			txtFirst.setMandatory(true);
			txtFirst.bindToModel(workingCopy, LocalDairy.PROPERTY_FIRSTNAME);
			txtFirst.updateFromModel();

			ITextRidget txtLast = (ITextRidget) container.getRidget("last"); //$NON-NLS-1$
			txtLast.setMandatory(true);
			txtLast.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			txtLast.bindToModel(workingCopy, LocalDairy.PROPERTY_LASTNAME);
			txtLast.updateFromModel();
			
			ITextRidget phoneTxt = (ITextRidget) container.getRidget("phone"); //$NON-NLS-1$
			phoneTxt.setMandatory(true);
			phoneTxt.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			phoneTxt.bindToModel(workingCopy, LocalDairy.PROPERTY_PHONENUMBER);
			phoneTxt.updateFromModel();
			
			ITextRidget depTxt = (ITextRidget) container.getRidget("farm"); //$NON-NLS-1$
			depTxt.setMandatory(true);
			depTxt.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			depTxt.bindToModel(workingCopy, LocalDairy.PROPERTY_DEPARTMENT);
			depTxt.updateFromModel();
			
			ITextRidget addTxt = (ITextRidget) container.getRidget("address"); //$NON-NLS-1$
			addTxt.setMandatory(true);
			
			addTxt.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			addTxt.bindToModel(workingCopy, LocalDairy.PROPERTY_ADDRESS);
			addTxt.updateFromModel();


			ISingleChoiceRidget gender = (ISingleChoiceRidget) container
					.getRidget("gender"); //$NON-NLS-1$
			if (gender != null) {
				gender.bindToModel(Arrays.asList(GENDER), (List<String>) null,
						workingCopy, LocalDairy.PROPERTY_GENDER);
				gender.updateFromModel();
			}

		}

		public LocalDairy createWorkingCopy() {
			return new LocalDairy("", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}

		public LocalDairy copyBean(final Object source, final Object target) {
			LocalDairy from = source != null ? (LocalDairy) source : createWorkingCopy();
			LocalDairy to = target != null ? (LocalDairy) target : createWorkingCopy();
			to.setFirstname(from.getFirstname());
			to.setLastname(from.getLastname());
			to.setGender(from.getGender());
			to.setId(from.getId());
			to.setFarm(from.getFarm());
			to.setAddress(from.getAddress());
			to.setPhoneNumber(from.getPhoneNumber());
			return to;
		}

		public Object getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			LocalDairy p1 = (LocalDairy) source;
			LocalDairy p2 = (LocalDairy) target;
			boolean equals = p1.getFirstname().equals(p2.getFirstname())
					&& p1.getLastname().equals(p2.getLastname())
					&& p1.getGender().equals(p2.getGender())
					&& p1.getFarm().equals(p2.getFarm());
			return !equals;
		}

		@Override
		public String isValid(IRidgetContainer container) {
			ITextRidget txtLast = (ITextRidget) container.getRidget("last"); //$NON-NLS-1$
			if (txtLast.isErrorMarked()) {
				return "'Last Name' is not valid."; //$NON-NLS-1$
			}
			return null;
		}
	}

	private List<LocalDairy> input = LocalDairyFactory.createPersonList();

	@Override
	public void configureRidgets() {
		String[] properties = new String[] {"id","firstname", "lastname","farm" };
		String[] headers = new String[] { "ID","First Name", "Last Name","Farm"};

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master"); //$NON-NLS-1$
		if (master != null) {
			master.setDelegate(new LocalDairyDelegation());
			master.bindToModel(new WritableList(input, LocalDairy.class),
					LocalDairy.class, properties, headers);
			master.updateFromModel();

			IActionRidget actionApply = master.getRidget(IActionRidget.class,
					MasterDetailsComposite.BIND_ID_APPLY);
			addDefaultAction(master, actionApply);
		}

		//		final IMasterDetailsRidget master3 = (IMasterDetailsRidget) getRidget("master3"); //$NON-NLS-1$
		// if (master3 != null) {
		// master3.setDelegate(new LocalDairyDelegation());
		// master3.bindToModel(new WritableList(input, Person.class),
		// Person.class, properties, headers);
		// master3.updateFromModel();
		//
		// master3.setDirectWriting(true); // enable auto apply
		// }

		// IActionRidget enableDisableButton = getRidget(IActionRidget.class,
		//				"enableDisable"); //$NON-NLS-1$
		// if (enableDisableButton != null) {
		// enableDisableButton.addListener(new IActionListener() {
		// public void callback() {
		// if (master != null) {
		// master.setEnabled(!master.isEnabled());
		// }
		// if (master3 != null) {
		// master3.setEnabled(!master3.isEnabled());
		// }
		// }
		// });
		// }
	}
}

