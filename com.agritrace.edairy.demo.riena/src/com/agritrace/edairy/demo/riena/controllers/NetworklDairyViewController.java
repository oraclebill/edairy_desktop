package com.agritrace.edairy.demo.riena.controllers;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.core.marker.ValidationTime;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ISingleChoiceRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.validation.NotEmpty;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;


import com.agritrace.edairy.demo.riena.views.data.NetworkDairy;
import com.agritrace.edairy.demo.riena.views.data.NetworkDairy.ORGANIZATIONTYPE;
import com.agritrace.edairy.demo.riena.views.data.NetworkDairyFactory;

public class NetworklDairyViewController extends SubModuleController {

	public static final String ID = NetworklDairyViewController.class.getName();

	/**
	 * Setup the ridgets for editing a person (text ridgets for name, single
	 * choice ridget for gender, multiple choice ridgets for pets).
	 */
	private static final class LocalDairyDelegation extends
			AbstractMasterDetailsDelegate {

		private static final String[] GENDER = { NetworkDairy.FEMALE,
			NetworkDairy.MALE };

		private final NetworkDairy workingCopy = createWorkingCopy();

		public void configureRidgets(IRidgetContainer container) {
			ITextRidget txtFirst = (ITextRidget) container.getRidget("first"); //$NON-NLS-1$
			txtFirst.setMandatory(true);
			txtFirst.bindToModel(workingCopy, NetworkDairy.PROPERTY_FIRSTNAME);
			txtFirst.updateFromModel();

			ITextRidget txtLast = (ITextRidget) container.getRidget("last"); //$NON-NLS-1$
			txtLast.setMandatory(true);
			txtLast.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			txtLast.bindToModel(workingCopy, NetworkDairy.PROPERTY_LASTNAME);
			txtLast.updateFromModel();

			ITextRidget phoneTxt = (ITextRidget) container.getRidget("phone"); //$NON-NLS-1$
			phoneTxt.setMandatory(true);
			phoneTxt.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			phoneTxt.bindToModel(workingCopy, NetworkDairy.PROPERTY_PHONENUMBER);
			phoneTxt.updateFromModel();

			ITextRidget depTxt = (ITextRidget) container.getRidget("farm"); //$NON-NLS-1$
			depTxt.setMandatory(true);
			depTxt.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			depTxt.bindToModel(workingCopy, NetworkDairy.PROPERTY_DEPARTMENT);
			depTxt.updateFromModel();

			ITextRidget addTxt = (ITextRidget) container.getRidget("address"); //$NON-NLS-1$
			addTxt.setMandatory(true);
			addTxt.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			addTxt.bindToModel(workingCopy, NetworkDairy.PROPERTY_ADDRESS);
			addTxt.updateFromModel();

			IComboRidget comboStatus = (IComboRidget) container
					.getRidget("organizationType"); //$NON-NLS-1$
			comboStatus.bindToModel(
							workingCopy,
							"organizationTypes", ORGANIZATIONTYPE.class, null, workingCopy, "organizationType"); 
			comboStatus.updateFromModel();
			
			ITextRidget orgNameTxt = (ITextRidget) container.getRidget("organizationName"); //$NON-NLS-1$
			orgNameTxt.setMandatory(false);
			orgNameTxt.addValidationRule(new NotEmpty(),
					ValidationTime.ON_UI_CONTROL_EDIT);
			orgNameTxt.bindToModel(workingCopy,"organizationName");
			orgNameTxt.updateFromModel();

			ISingleChoiceRidget gender = (ISingleChoiceRidget) container
					.getRidget("gender"); //$NON-NLS-1$
			if (gender != null) {
				gender.bindToModel(Arrays.asList(GENDER), (List<String>) null,
						workingCopy, NetworkDairy.PROPERTY_GENDER);
				gender.updateFromModel();
			}

		}

		public NetworkDairy createWorkingCopy() {
			return new NetworkDairy("", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}

		public NetworkDairy copyBean(final Object source, final Object target) {
			NetworkDairy from = source != null ? (NetworkDairy) source
					: createWorkingCopy();
			NetworkDairy to = target != null ? (NetworkDairy) target
					: createWorkingCopy();
			to.setFirstname(from.getFirstname());
			to.setLastname(from.getLastname());
			to.setGender(from.getGender());
			to.setId(from.getId());
			to.setFarm(from.getFarm());
			to.setAddress(from.getAddress());
			to.setPhoneNumber(from.getPhoneNumber());
			to.setOrganizationName(from.getOrganizationName());
			to.setOrganizationType(from.getOrganizationType());
			return to;
		}

		public Object getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			NetworkDairy p1 = (NetworkDairy) source;
			NetworkDairy p2 = (NetworkDairy) target;
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

	private List<NetworkDairy> input = NetworkDairyFactory.createPersonList();

	@Override
	public void configureRidgets() {
		String[] properties = new String[] { "id", "firstname", "lastname",
				"farm", "organizationType", "organizationName" };
		String[] headers = new String[] { "ID", "First Name", "Last Name",
				"Farm", "Organization Type", "Organization Name" };

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master"); //$NON-NLS-1$
		if (master != null) {
			master.setDelegate(new LocalDairyDelegation());
			master.bindToModel(new WritableList(input, NetworkDairy.class),
					NetworkDairy.class, properties, headers);
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
