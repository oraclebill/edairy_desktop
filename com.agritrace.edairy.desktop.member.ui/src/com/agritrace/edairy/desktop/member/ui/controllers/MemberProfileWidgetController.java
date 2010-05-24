package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.controller.IController;

import com.agritrace.edairy.desktop.common.model.base.DescriptiveLocation;
import com.agritrace.edairy.desktop.common.model.base.MapLocation;
import com.agritrace.edairy.desktop.common.model.base.PostalLocation;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.controllers.AddressGroupWidgetController;
import com.agritrace.edairy.desktop.common.ui.controllers.CommunicationGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.DirectionGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.MapGroupController;
import com.agritrace.edairy.desktop.common.ui.controllers.WidgetController;

public class MemberProfileWidgetController implements WidgetController {

	private IController controller;
	private Membership member;

	private MemberInfoGroupController infoGroup;
	private AddressGroupWidgetController addressGroup;
	private DirectionGroupController directionGroup;
	private MapGroupController mapGroup;
	private CommunicationGroupController communicationGroup;

	public MemberProfileWidgetController(IController controller) {
		this.controller = controller;
		infoGroup = new MemberInfoGroupController(controller);
		addressGroup = new AddressGroupWidgetController(controller);
		directionGroup = new DirectionGroupController(controller);
		mapGroup = new MapGroupController(controller);
		communicationGroup = new CommunicationGroupController(controller);
		configue();
	}

	@Override
	public void configue() {
		if (controller == null) {
			return;
		}
		infoGroup.configue();
		addressGroup.configue();
		directionGroup.configue();
		mapGroup.configue();
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
	public SubModuleController getController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setController(IController controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBinding() {
		infoGroup.setInputModel(member);
		if (member.getMember().getLocation() != null) {
			PostalLocation location = member.getMember().getLocation().getPostalLocation();
			addressGroup.setInputModel(location);
			
			MapLocation map = member.getMember().getLocation().getMapLocation();
			mapGroup.setInputModel(map);
			
			DescriptiveLocation dLocation =  member.getMember().getLocation().getDescriptiveLocation();
			directionGroup.setInputModel(dLocation);
			
		}
		communicationGroup.setInputModel(member.getMember());
	}

}
