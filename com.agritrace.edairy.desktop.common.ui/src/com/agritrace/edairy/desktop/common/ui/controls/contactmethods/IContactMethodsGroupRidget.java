package com.agritrace.edairy.desktop.common.ui.controls.contactmethods;

import java.util.List;

import org.eclipse.riena.ui.ridgets.IComplexRidget;

import com.agritrace.edairy.desktop.common.model.base.ContactMethod;
import com.agritrace.edairy.desktop.common.model.base.Contactable;

public interface IContactMethodsGroupRidget extends IComplexRidget {
	public static final String WIDGET_ID = "contact-methods";

	void bindToModel(List<ContactMethod> contactMethods);
	void bindToModel(Contactable contactable);

}