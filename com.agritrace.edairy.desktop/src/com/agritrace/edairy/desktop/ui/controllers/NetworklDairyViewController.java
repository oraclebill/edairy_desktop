package com.agritrace.edairy.desktop.ui.controllers;

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
import org.eclipse.riena.ui.swt.AbstractMasterDetailsComposite;

import com.agritrace.edairy.desktop.ui.views.data.LocalDairy;
import com.agritrace.edairy.desktop.ui.views.data.NetworkDairy;
import com.agritrace.edairy.desktop.ui.views.data.NetworkDairyFactory;
import com.agritrace.edairy.desktop.ui.views.data.NetworkDairy.ORGANIZATIONTYPE;

public class NetworklDairyViewController extends SubModuleController {

    public static final String ID = NetworklDairyViewController.class.getName();

    /**
     * Setup the ridgets for editing a person (text ridgets for name, single
     * choice ridget for gender, multiple choice ridgets for pets).
     */
    private static final class LocalDairyDelegation extends AbstractMasterDetailsDelegate {

	private static final String[] GENDER = { NetworkDairy.FEMALE, NetworkDairy.MALE };

	private final NetworkDairy workingCopy = createWorkingCopy();

	@Override
	public void configureRidgets(IRidgetContainer container) {
	    final ITextRidget txtFirst = (ITextRidget) container.getRidget("first"); //$NON-NLS-1$
	    txtFirst.setMandatory(true);
	    txtFirst.bindToModel(workingCopy, LocalDairy.PROPERTY_FIRSTNAME);
	    txtFirst.updateFromModel();

	    final ITextRidget txtLast = (ITextRidget) container.getRidget("last"); //$NON-NLS-1$
	    txtLast.setMandatory(true);
	    txtLast.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
	    txtLast.bindToModel(workingCopy, LocalDairy.PROPERTY_LASTNAME);
	    txtLast.updateFromModel();

	    final ITextRidget phoneTxt = (ITextRidget) container.getRidget("phone"); //$NON-NLS-1$
	    phoneTxt.setMandatory(true);
	    phoneTxt.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
	    phoneTxt.bindToModel(workingCopy, LocalDairy.PROPERTY_PHONENUMBER);
	    phoneTxt.updateFromModel();

	    final ITextRidget depTxt = (ITextRidget) container.getRidget("farm"); //$NON-NLS-1$
	    depTxt.setMandatory(true);
	    depTxt.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
	    depTxt.bindToModel(workingCopy, LocalDairy.PROPERTY_DEPARTMENT);
	    depTxt.updateFromModel();

	    final ITextRidget addTxt = (ITextRidget) container.getRidget("address"); //$NON-NLS-1$
	    addTxt.setMandatory(true);
	    addTxt.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
	    addTxt.bindToModel(workingCopy, LocalDairy.PROPERTY_ADDRESS);
	    addTxt.updateFromModel();

	    final IComboRidget comboStatus = (IComboRidget) container.getRidget("organizationType"); //$NON-NLS-1$
	    comboStatus.bindToModel(workingCopy, "organizationTypes", ORGANIZATIONTYPE.class, null, workingCopy,
		    "organizationType");
	    comboStatus.updateFromModel();

	    final ITextRidget orgNameTxt = (ITextRidget) container.getRidget("organizationName"); //$NON-NLS-1$
	    orgNameTxt.setMandatory(false);
	    orgNameTxt.addValidationRule(new NotEmpty(), ValidationTime.ON_UI_CONTROL_EDIT);
	    orgNameTxt.bindToModel(workingCopy, "organizationName");
	    orgNameTxt.updateFromModel();

	    final ISingleChoiceRidget gender = (ISingleChoiceRidget) container.getRidget("gender"); //$NON-NLS-1$
	    if (gender != null) {
		gender.bindToModel(Arrays.asList(GENDER), (List<String>) null, workingCopy, LocalDairy.PROPERTY_GENDER);
		gender.updateFromModel();
	    }

	}

	@Override
	public NetworkDairy createWorkingCopy() {
	    return new NetworkDairy("", ""); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public NetworkDairy copyBean(final Object source, final Object target) {
	    final NetworkDairy from = source != null ? (NetworkDairy) source : createWorkingCopy();
	    final NetworkDairy to = target != null ? (NetworkDairy) target : createWorkingCopy();
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

	@Override
	public Object getWorkingCopy() {
	    return workingCopy;
	}

	@Override
	public boolean isChanged(Object source, Object target) {
	    final NetworkDairy p1 = (NetworkDairy) source;
	    final NetworkDairy p2 = (NetworkDairy) target;
	    final boolean equals = p1.getFirstname().equals(p2.getFirstname())
		    && p1.getLastname().equals(p2.getLastname()) && p1.getGender().equals(p2.getGender())
		    && p1.getFarm().equals(p2.getFarm());
	    return !equals;
	}

	@Override
	public String isValid(IRidgetContainer container) {
	    final ITextRidget txtLast = (ITextRidget) container.getRidget("last"); //$NON-NLS-1$
	    if (txtLast.isErrorMarked()) {
		return "'Last Name' is not valid."; //$NON-NLS-1$
	    }
	    return null;
	}
    }

    private final List<NetworkDairy> input = NetworkDairyFactory.createPersonList();

    @Override
    public void configureRidgets() {
	final String[] properties = new String[] { "id", "firstname", "lastname", "farm", "organizationType",
		"organizationName" };
	final String[] headers = new String[] { "ID", "First Name", "Last Name", "Farm", "Organization Type",
		"Organization Name" };

	final IMasterDetailsRidget master = (IMasterDetailsRidget) getRidget("master"); //$NON-NLS-1$
	if (master != null) {
	    master.setDelegate(new LocalDairyDelegation());
	    master.bindToModel(new WritableList(input, NetworkDairy.class), NetworkDairy.class, properties, headers);
	    master.updateFromModel();

	    final IActionRidget actionApply = master.getRidget(IActionRidget.class,
		    AbstractMasterDetailsComposite.BIND_ID_APPLY);
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
