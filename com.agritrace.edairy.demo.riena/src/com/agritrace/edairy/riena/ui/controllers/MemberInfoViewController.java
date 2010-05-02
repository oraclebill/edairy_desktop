package com.agritrace.edairy.riena.ui.controllers;

import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.beans.common.Address;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.AbstractMasterDetailsDelegate;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.IComboRidget;
import org.eclipse.riena.ui.ridgets.IMasterDetailsRidget;
import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.swt.MasterDetailsComposite;

import com.agritrace.edairy.riena.ui.views.data.MemberFactory;
import com.agritrace.edairy.riena.ui.views.data.MemberShip;
import com.agritrace.edairy.riena.ui.views.data.MemberShip.STATUS;

public class MemberInfoViewController extends SubModuleController {

	public static final String ID = MemberInfoViewController.class.getName();

	/**
	 * Setup the ridgets for editing a person (text ridgets for name, single
	 * choice ridget for gender, multiple choice ridgets for pets).
	 */
	private static final class MemberDelegation extends
			AbstractMasterDetailsDelegate {

		// private static final String[] GENDER = { Staff.FEMALE, Staff.MALE };

		private final MemberShip workingCopy = createWorkingCopy();

		public void configureRidgets(IRidgetContainer container) {

			// member Id
			ITextRidget txtId = (ITextRidget) container.getRidget("id"); //$NON-NLS-1$
			txtId.setMandatory(true);
			txtId.bindToModel(workingCopy, MemberShip.PROPERTY_ID);
			txtId.updateFromModel();

			/**
			 * TODO setting date
			 */

			// join date
			//			UIControlsFactory.createLabel(upperPanel, "Joined Date:"); //$NON-NLS-1$
			// Text txtDate = UIControlsFactory.createText(upperPanel,
			// SWT.BORDER,
			//					"date"); //$NON-NLS-1$
			// txtDate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
			// false,
			// 1, 1));

			// status

			IComboRidget comboStatus = (IComboRidget) container
					.getRidget("status"); //$NON-NLS-1$
			comboStatus.bindToModel(
							workingCopy,
							"statuses", STATUS.class, null, workingCopy, MemberShip.PROPERTY_STATUS); //$NON-NLS-1$ //$NON-NLS-2$
			comboStatus.updateFromModel();
			

			// first name
			ITextRidget txtFirst = (ITextRidget) container.getRidget("first"); //$NON-NLS-1$
			txtFirst.setMandatory(true);
			txtFirst.bindToModel(workingCopy, MemberShip.PROPERTY_FIRSTNAME);
			txtFirst.updateFromModel();

			// last name
			ITextRidget txtLast = (ITextRidget) container.getRidget("last"); //$NON-NLS-1$
			txtLast.setMandatory(true);
			txtLast.bindToModel(workingCopy, MemberShip.PROPERTY_LASTNAME);
			txtLast.updateFromModel();

			// phone
			ITextRidget txtPhone = (ITextRidget) container.getRidget("phone"); //$NON-NLS-1$
			txtPhone.setMandatory(true);
			txtPhone.bindToModel(workingCopy, MemberShip.PROPERTY_PHONENUMBER);
			txtPhone.updateFromModel();

			// address
			ITextRidget txtAddress = (ITextRidget) container
					.getRidget("address"); //$NON-NLS-1$
			txtAddress.setMandatory(true);
			txtAddress.bindToModel(workingCopy.getAddressInfo(),
					Address.PROPERTY_STREET);
			txtAddress.updateFromModel();

			// town
			ITextRidget txtTown = (ITextRidget) container.getRidget("city"); //$NON-NLS-1$
			txtTown.setMandatory(true);
			txtTown.bindToModel(workingCopy.getAddressInfo(),
					Address.PROPERTY_TOWN);
			txtTown.updateFromModel();

			// province
			//			ITextRidget txtProvince= (ITextRidget) container.getRidget("province"); //$NON-NLS-1$
			// txtProvince.setMandatory(true);
			// txtProvince.bindToModel(workingCopy.getAddressInfo().get(),
			// Address.PROPERTY_TOWN);
			// txtProvince.updateFromModel();

			// postal
			ITextRidget txtPostal = (ITextRidget) container
					.getRidget("postalCode"); //$NON-NLS-1$
			txtPostal.setMandatory(true);
			txtPostal.bindToModel(workingCopy.getAddressInfo(),
					Address.PROPERTY_POSTAL_CODE);
			txtPostal.updateFromModel();

		}

		public MemberShip createWorkingCopy() {
			return new MemberShip("", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}

		public MemberShip copyBean(final Object source, final Object target) {
			MemberShip from = source != null ? (MemberShip) source
					: createWorkingCopy();
			MemberShip to = target != null ? (MemberShip) target : createWorkingCopy();
			to.setFirstname(from.getFirstname());
			to.setLastname(from.getLastname());
			to.setGender(from.getGender());
			to.setId(from.getId());
			to.setBalance(from.getBalance());
			to.setAddress(from.getAddress());
			to.setAddressInfo(from.getAddressInfo());
			to.setPhoneNumber(from.getPhoneNumber());
			to.setActive(from.isActive());
			return to;
		}

		public Object getWorkingCopy() {
			return workingCopy;
		}

		@Override
		public boolean isChanged(Object source, Object target) {
			MemberShip p1 = (MemberShip) source;
			MemberShip p2 = (MemberShip) target;
			boolean equals = p1.getFirstname().equals(p2.getFirstname())
					&& p1.getLastname().equals(p2.getLastname())
					&& p1.getGender().equals(p2.getGender())
					&& p1.getPhoneNumber().equals(p2.getPhoneNumber());
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

	private List<MemberShip> input = MemberFactory.createMemberList();

	@Override
	public void configureRidgets() {
		String[] properties = new String[] { "id", "firstname", "lastname",
				"status", "credit", "balance" };
		String[] headers = new String[] { "ID", "First Name", "Last Name",
				"Status", "Credit", "Balance" };

		final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master"); //$NON-NLS-1$
		if (master != null) {
			master.setDelegate(new MemberDelegation());
			master.bindToModel(new WritableList(input, MemberShip.class),
					MemberShip.class, properties, headers);
			master.updateFromModel();

			IActionRidget actionApply = master.getRidget(IActionRidget.class,
					MasterDetailsComposite.BIND_ID_APPLY);
			addDefaultAction(master, actionApply);
		}

	}
}