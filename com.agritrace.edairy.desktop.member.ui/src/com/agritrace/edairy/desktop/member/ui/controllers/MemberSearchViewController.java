package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.beans.SimpleFormattedDateBean;
import com.agritrace.edairy.desktop.common.ui.dialogs.CalendarSelectionDialog;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.MemberRegisterDialog;

public class MemberSearchViewController extends SubModuleController{


	private ITableRidget memberList ;
	private Dairy dairy;
	private final String[] memberPropertyNames = { "memberId", "member", "status", "member",	"account", "account", "account" };
	private final String[] memberColumnHeaders = { "ID", "Name", "Status", "Phone", "Milk Collection","Monthly Credit Sales", "Credit Balance" };
	private List<Membership> membershipList = new ArrayList<Membership>();

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
			membershipList = dairy.getMemberships();
			memberList.bindToModel(new WritableList(membershipList, Membership.class), Membership.class, memberPropertyNames, memberColumnHeaders);
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
			getRidget(IActionRidget.class,ViewWidgetId.MEMBERLIST_ADD).addListener(new IActionListener() {

				@Override
				public void callback() {
					// TODO Auto-generated method stub

				}
			});
			getRidget(IActionRidget.class,ViewWidgetId.MEMBERLIST_VIEW).addListener(new IActionListener() {

				@Override
				public void callback() {
					Membership selectedMember = (Membership)memberList.getSelection().get(0);
					int index = membershipList.indexOf(selectedMember);
					final MemberRegisterDialog memberDialog = new MemberRegisterDialog();
					memberDialog.getController().setContext("selectedMember",
							selectedMember);

					int returnCode  = memberDialog.open();
					if (returnCode == AbstractWindowController.OK) {
						selectedMember= (Membership) memberDialog.getController().getContext(
								"selectedMember");
						membershipList.set(index,selectedMember);
						memberList.updateFromModel();
					}else{
//						System.out.println("return code "+returnCode);
					}
				}

			});


		}



	}

	private void loadDairy(){
		dairy = DairyDemoResourceManager.INSTANCE.getLocalDairy();
	}

}
