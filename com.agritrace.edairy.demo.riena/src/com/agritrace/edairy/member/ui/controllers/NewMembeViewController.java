package com.agritrace.edairy.member.ui.controllers;

import java.io.IOException;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;

import com.agritrace.edairy.member.ui.views.EMFObjectUtil;
import com.agritrace.edairy.member.ui.views.MemberSearchDetachedView;
import com.agritrace.edairy.member.ui.views.MemberSearchSelectionManager;
import com.agritrace.edairy.model.dairy.Membership;
import com.agritrace.edairy.ui.DairyDemoResourceManager;
import com.agritrace.edairy.ui.views.ViewWidgetId;

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
