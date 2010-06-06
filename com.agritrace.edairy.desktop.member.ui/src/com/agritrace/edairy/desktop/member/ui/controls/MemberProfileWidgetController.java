package com.agritrace.edairy.desktop.member.ui.controls;

import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;
import com.agritrace.edairy.desktop.member.ui.controllers.MemberInfoGroupController;

public class MemberProfileWidgetController implements WidgetController {

	private IController controller;
	private Membership member;

	private MemberInfoGroupController infoGroup;
	private LocationProfileWidgetController locationController;
	private CommunicationGroupController communicationGroup;

	public MemberProfileWidgetController(IController controller) {
		this.controller = controller;
		infoGroup = new MemberInfoGroupController(controller);
		locationController = new LocationProfileWidgetController(controller);
		communicationGroup = new CommunicationGroupController(controller);
		configure();
	}

	@Override
	public void configure() {
		if (controller == null) {
			return;
		}
		infoGroup.configure();
		locationController.configure();
		communicationGroup.configure();
	}

	@Override
	public Object getInputModel() {
		return member;
	}

	@Override
	public void setInputModel(Object model) {
		this.member = (Membership) model;
		if (controller != null) {
			updateBinding();
		}

	}

	@Override
	public IController getController() {
		// TODO Auto-generated method stub
		return controller;
	}

	@Override
	public void setController(IController controller) {
		this.controller = controller;

	}

	@Override
	public void updateBinding() {
		infoGroup.setInputModel(member);
		if (member.getMember().getLocation() != null) {
			locationController.setInputModel(member.getMember().getLocation());

		}
		communicationGroup.setInputModel(member.getMember());
		communicationGroup.updateBinding();
	}

}
