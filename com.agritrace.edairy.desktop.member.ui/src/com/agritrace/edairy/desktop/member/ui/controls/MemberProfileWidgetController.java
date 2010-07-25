package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.riena.ui.ridgets.IRidgetContainer;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.location.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.common.ui.controls.contactmethods.IContactMethodsGroupRidget;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberInfoGroupController;

public class MemberProfileWidgetController implements WidgetController<Object> {

	private final IContactMethodsGroupRidget contacts;
	private IRidgetContainer container;

	private final MemberInfoGroupController infoGroup;
	private final LocationProfileWidgetController locationController;
	private Membership member;

	public MemberProfileWidgetController(IController controller) {
		this.container = controller;
		infoGroup = new MemberInfoGroupController(controller);
		locationController = new LocationProfileWidgetController(controller);
		contacts = controller.getRidget(IContactMethodsGroupRidget.class,
				IContactMethodsGroupRidget.WIDGET_ID);
		configure();
	}

	@Override
	public void configure() {
		if (container == null) {
			return;
		}
		// infoGroup.configure();
		// locationController.configure();
		// communicationGroup.configure();
	}

	@Override
	public IRidgetContainer getContainer() {
		// TODO Auto-generated method stub
		return container;
	}

	@Override
	public Object getInputModel() {
		return member;
	}

	@Override
	public void setController(IRidgetContainer container) {
		this.container = container;

	}

	@Override
	public void setInputModel(Object model) {
		this.member = (Membership) model;
		if (container != null) {
			updateBinding();
		}

	}

	@Override
	public void updateBinding() {
		infoGroup.setInputModel(member);
		if (member.getMember().getLocation() != null) {
			locationController.setInputModel(member.getMember().getLocation());

		}
		contacts.bindToModel(member.getMember());
		contacts.updateFromModel();
	}

}
