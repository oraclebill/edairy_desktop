package com.agritrace.edairy.desktop.member.ui.controllers;

import java.io.IOException;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.common.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.EMFObjectUtil;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionManager;
import com.agritrace.edairy.model.dairy.Membership;

public class NewMembeViewController extends MemberSearchViewController {

    public NewMembeViewController() {
	this.setSelectedMember(EMFObjectUtil.createMembership());
    }

    @Override
    public void configureRidgets() {
	super.configureRidgets();
	((IActionRidget) getRidget(ViewWidgetId.memberInfo_searchButton)).setVisible(false);

    }

    @Override
    protected void saveMember() {
	final Membership newMembership = getSelectedMember();
	if (newMembership != null) {
	    try {
		DairyDemoResourceManager.INSTANCE.getLocalDairy().getMemberships().add(newMembership);
		DairyDemoResourceManager.INSTANCE.saveFarmResource();
		DairyDemoResourceManager.INSTANCE.saveDairyResource();
		MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
	    } catch (final IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (final IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

}
