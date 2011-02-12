package com.agritrace.edairy.desktop.common.ui.controls.fieldgroup;

import org.eclipse.riena.internal.ui.ridgets.swt.CompositeRidgetTest;
import org.eclipse.riena.ui.ridgets.IRidget;
import org.eclipse.riena.ui.swt.utils.SWTBindingPropertyLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;


@SuppressWarnings("restriction")
public class FieldGroupRidgetTest extends CompositeRidgetTest {
	@Override
	protected IRidget createRidget() {
		return new FieldGroupRidget();
	}

	@Override
	protected Widget createWidget(Composite parent) {
		Widget result = new FieldGroup(parent, SWT.NONE);
		result.setData(SWTBindingPropertyLocator.BINDING_PROPERTY, "pbId");
		return result;
	}

//	@Override
//	protected ICompositeRidget getRidget() {
//		return (ICompositeRidget) super.getRidget();
//	}
//
//	@Override
//	protected Composite getWidget() {
//		return (Composite) super.getWidget();
//	}

}
