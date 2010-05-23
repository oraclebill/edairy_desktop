package com.agritrace.edairy.desktop.member.ui.controllers;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class MemberSearchViewController extends SubModuleController{


	private ITableRidget memberList ;
	private Dairy dairy;
	private final String[] memberPropertyNames = { "memberId", "member", "status", "member",	"account", "account", "account" };
	private final String[] memberColumnHeaders = { "ID", "Name", "Status", "Phone", "Milk Collection","Monthly Credit Sales", "Credit Balance" };

	@Override
	public void configureRidgets() {
		loadDairy();
		configueMemberTable();

	}

	private void configueMemberTable(){

		memberList = getRidget(ITableRidget.class, ViewWidgetId.MEMBERLIST_MEMBERTABLE);

		if(dairy == null){
			loadDairy();
		}
		if(dairy != null){
			memberList.bindToModel(new WritableList(dairy.getMemberships(), Membership.class), Membership.class, memberPropertyNames, memberColumnHeaders);
			memberList.setColumnFormatter(1, new ColumnFormatter(){
				public String getText(Object element) {
					if(element instanceof Membership){
						Person member = ((Membership)element).getMember();
						if(member != null){
							return member.getFamilyName()+","+member.getGivenName();
						}
					}
					return null;
				}
			});
			memberList.setColumnFormatter(3, new ColumnFormatter(){
				public String getText(Object element) {
					if(element instanceof Membership){
						Person member = ((Membership)element).getMember();
						if(member != null){
							return member.getPhoneNumber();
						}
					}
					return null;
				}
			});
			memberList.setColumnFormatter(4, new ColumnFormatter(){

				public String getText(Object element) {
					return "1000";
				}
			});
			memberList.setColumnFormatter(5, new ColumnFormatter(){

				public String getText(Object element) {
					return "10000";
				}
			});

			memberList.setColumnFormatter(6, new ColumnFormatter(){

				public String getText(Object element) {
					return "2000";
				}
			});
			memberList.updateFromModel();

		}



	}

	private void loadDairy(){
		dairy = DairyDemoResourceManager.INSTANCE.getLocalDairy();
	}

}
