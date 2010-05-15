package com.agritrace.edairy.desktop.member.ui.controllers;

import java.io.IOException;

import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.views.EMFObjectUtil;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.desktop.member.ui.views.MemberSearchSelectionManager;
import com.agritrace.edairy.desktop.model.DairyDemoResourceManager;
import com.agritrace.edairy.model.dairy.Membership;

public class NewMembeViewController extends MemberSearchViewController {
	
	public NewMembeViewController(){
		this.setSelectedMember(EMFObjectUtil.createMembership());
	}
	public void configureRidgets(){
		super.configureRidgets();
		((IActionRidget)getRidget(ViewWidgetId.memberInfo_searchButton)).setVisible(false);
		
		
	}
	
	protected void saveMember(){
		Membership newMembership = getSelectedMember();
		if(newMembership != null){
			try {
				DairyDemoResourceManager.INSTANCE.getLocalDairy().getMemberships().add(newMembership);
				DairyDemoResourceManager.INSTANCE.saveFarmResource();
				DairyDemoResourceManager.INSTANCE.saveDairyResource();
				MemberSearchSelectionManager.INSTANCE.refreshView(MemberSearchDetachedView.ID);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
