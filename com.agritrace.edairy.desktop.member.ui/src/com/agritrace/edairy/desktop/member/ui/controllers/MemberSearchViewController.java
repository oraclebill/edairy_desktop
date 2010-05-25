package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.widgets.Display;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.ui.managers.DairyDemoResourceManager;
import com.agritrace.edairy.desktop.common.ui.util.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.MemberRegisterDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewMemberDialog;
import com.agritrace.edairy.desktop.member.ui.views.EMFObjectUtil;

public class MemberSearchViewController extends SubModuleController {

	private ITableRidget memberList;
	private Dairy dairy;
	private IActionRidget viewRidget;
	private final String[] memberPropertyNames = { "memberId", "member",
			"status", "member", "account", "account", "account" };
	private final String[] memberColumnHeaders = { "ID", "Name", "Status",
			"Phone", "Milk Collection", "Monthly Credit Sales",
	"Credit Balance" };
	private List<Membership> membershipList = new ArrayList<Membership>();

	public static final String DELETE_DIALOG_TITLE = "Delete Membership";
	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected member %s ?";

	@Override
	public void configureRidgets() {
		loadDairy();
		configueMemberTable();

	}

	private void configueMemberTable() {

		memberList = getRidget(ITableRidget.class,
				ViewWidgetId.MEMBERLIST_MEMBERTABLE);

		if (dairy == null) {
			loadDairy();
		}
		if (dairy != null) {
			membershipList = dairy.getMemberships();
			memberList.bindToModel(new WritableList(membershipList,
					Membership.class), Membership.class, memberPropertyNames,
					memberColumnHeaders);
			memberList.setColumnFormatter(1, new ColumnFormatter() {
				public String getText(Object element) {
					if (element instanceof Membership) {
						Person member = ((Membership) element).getMember();
						if (member != null) {
							return member.getFamilyName() + ","
							+ member.getGivenName();
						}
					}
					return null;
				}
			});
			memberList.setColumnFormatter(3, new ColumnFormatter() {
				public String getText(Object element) {
					if (element instanceof Membership) {
						Person member = ((Membership) element).getMember();
						if (member != null) {
							return member.getPhoneNumber();
						}
					}
					return null;
				}
			});
			memberList.setColumnFormatter(4, new ColumnFormatter() {

				public String getText(Object element) {
					return "1000";
				}
			});
			memberList.setColumnFormatter(5, new ColumnFormatter() {

				public String getText(Object element) {
					return "10000";
				}
			});

			memberList.setColumnFormatter(6, new ColumnFormatter() {

				public String getText(Object element) {
					return "2000";
				}
			});
			memberList.addSelectionListener(new ISelectionListener() {

				@Override
				public void ridgetSelected(SelectionEvent event) {
					if (event.getSource() == memberList) {
						viewRidget
						.setEnabled(memberList.getSelection().size() > 0);
					}
				}

			});
			memberList.updateFromModel();
			getRidget(IActionRidget.class, ViewWidgetId.MEMBERLIST_ADD)
			.addListener(new IActionListener() {

				@Override
				public void callback() {
					Membership selectedMember = EMFObjectUtil.createMembership();
					int index = membershipList.indexOf(selectedMember);
					final MemberRegisterDialog memberDialog = new MemberRegisterDialog();
					memberDialog.getController().setContext(
							"selectedMember", selectedMember);

					int returnCode = memberDialog.open();
					if (returnCode == AbstractWindowController.OK) {
						selectedMember = (Membership) memberDialog
						.getController().getContext(
								"selectedMember");
						membershipList.set(index, selectedMember);
						memberList.updateFromModel();
					} else {
						// System.out.println("return code "+returnCode);
					}

				}
			});
			viewRidget = getRidget(IActionRidget.class,
					ViewWidgetId.MEMBERLIST_VIEW);
			if (viewRidget != null) {
				viewRidget.setEnabled(false);
				viewRidget.addListener(new IActionListener() {

					@Override
					public void callback() {
						Membership selectedMember = (Membership) memberList
						.getSelection().get(0);
						int index = membershipList.indexOf(selectedMember);
						final ViewMemberDialog memberDialog = new ViewMemberDialog();
						memberDialog.getController().setContext(
								"selectedMember", selectedMember);

						int returnCode = memberDialog.open();
						if (returnCode == AbstractWindowController.OK) {
							selectedMember = (Membership) memberDialog.getController().getContext("selectedMember");
							membershipList.set(index, selectedMember);
							memberList.updateFromModel();
						} else if (returnCode == 2) {
							// confirm for delete
							if (selectedMember != null) {
								String message = "";
								if (selectedMember.getMember() != null) {
									message = "\""+ selectedMember.getMember().getGivenName()+ " "+ selectedMember.getMember().getFamilyName() + "\"";
								}
								message = String.format(DELETE_DIALOG_MESSAGE,message);
								if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(),DELETE_DIALOG_TITLE, message)) {
									membershipList.remove(selectedMember);
									memberList.updateFromModel();
								}
							}
						}
					}
				});
			}
		}
	}

	private void loadDairy() {
		dairy = DairyDemoResourceManager.INSTANCE.getLocalDairy();
	}

}
