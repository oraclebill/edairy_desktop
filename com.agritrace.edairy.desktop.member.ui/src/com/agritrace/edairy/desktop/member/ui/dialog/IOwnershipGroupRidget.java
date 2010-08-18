package com.agritrace.edairy.desktop.member.ui.dialog;

import java.util.List;

import org.eclipse.riena.ui.ridgets.IComplexRidget;

public interface IOwnershipGroupRidget extends IComplexRidget {

	void bindToModel(List<String> ownershipList);

}
