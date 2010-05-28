package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.LocationProfileWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;

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
		communicationGroup =  new CommunicationGroupController(controller);
		configue();
	}

	@Override
	public void configue() {
		if (controller == null) {
			return;
		}
		infoGroup.configue();
		locationController.configue();
		communicationGroup.configue();
	}

	@Override
	public Object getInputModel() {
		return member;
	}

	@Override
	public void setInputModel(Object model) {
		this.member = (Membership)model;
		if(controller != null){
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
		communicationGroup.setInputModel(member.getMember().getContactMethods());
	}

}
