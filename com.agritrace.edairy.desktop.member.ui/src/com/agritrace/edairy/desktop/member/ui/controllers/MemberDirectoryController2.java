package com.agritrace.edairy.desktop.member.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.Permission;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.RepositoryFactory;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.AddMemberDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewMemberDialog;

@PermissionRequired(Permission.VIEW_MEMBER_LIST)
public class MemberDirectoryController2 extends BasicDirectoryController<Membership> {

	private final class DefaultTextListener implements IFocusListener {
		@Override
		public void focusGained(FocusEvent event) {
			String text = searchText.getText();
			if (text != null && text.equals(DEFAULT_SEARCH_DISPLAY_TXT)) {
				System.err.println("]]]] TEXT: clearing...'");
				searchText.setText("");
			}
		}

		@Override
		public void focusLost(FocusEvent event) {
			String text = searchText.getText();
			System.err.println("]]]] TEXT: '" + text + "'");
			if (text != null && text.equals("")) {
				System.err.println("]]]] TEXT: setting...'");
				searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
			}
		}
	}

	private static final String DEFAULT_SEARCH_DISPLAY_TXT = "Type to search members";
	private static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected member %s ?";
	private static final String DELETE_DIALOG_TITLE = "Delete Member";

	private final String[] memberColumnHeaders = { "ID", "First Name", "Last Name", "Transport Route",
			"Status", "Phone", "Milk Collection", "Monthly Credit Sales", "Credit Balance" };

	private final String[] memberPropertyNames = { "memberNumber", "member.givenName", "member.familyName",
			"defaultRoute.name", "status.name", "member.phoneNumber" }; // "account",
																		// "account",
	// "account" };

	private ITextRidget searchText;
	private Dairy localDairy;
	private IMemberRepository repository;

	public MemberDirectoryController2() {
		repository = RepositoryFactory.getMemberRepository();
		localDairy = RepositoryFactory.getDairyRepository().getLocalDairy();

		setEClass(DairyPackage.Literals.MEMBERSHIP);

		for (int i = 0; i < memberPropertyNames.length; i++) {
			addTableColumn(memberColumnHeaders[i], memberPropertyNames[i], String.class);
		}

		int index = memberPropertyNames.length;
		addTableColumn(memberColumnHeaders[index++], DairyPackage.Literals.MEMBERSHIP__ACCOUNT,
				new ConstantColumnFormatter("N/A"));
		addTableColumn(memberColumnHeaders[index++], DairyPackage.Literals.MEMBERSHIP__ACCOUNT,
				new ConstantColumnFormatter("N/A"));
		addTableColumn(memberColumnHeaders[index++], DairyPackage.Literals.MEMBERSHIP__ACCOUNT,
				new ConstantColumnFormatter("N/A"));
	}

	@Override
	protected void configureFilterRidgets() {
		// Conhide
		getRidget(ILabelRidget.class, "All").setVisible(false);
		for (char i = 'A'; i < 'Z'; i++) {
			getRidget(ILabelRidget.class, new String(new char[] { i })).setVisible(false);
		}

		searchText = getRidget(ITextRidget.class, ViewWidgetId.MEMBERLIST_SEARCHTEXT);
		searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
		searchText.setDirectWriting(true);
		searchText.addFocusListener(new DefaultTextListener());
		searchText.addPropertyChangeListener("text", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				refreshTableContents();
			}
		});

		getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_FILTER_RESET).addListener(new IActionListener() {
			@Override
			public void callback() {
				if (searchText != null) {
					searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
				}
			}
		});
		addDefaultAction(searchText, getRidget(IActionRidget.class, AbstractDirectoryView.BIND_ID_FILTER_SEARCH));

	}

	@Override
	protected List<Membership> getFilteredResult() {
		final List<Membership> allMembers = localDairy.getMemberships();
		final List<Membership> results = new ArrayList<Membership>();
		long start = System.currentTimeMillis();
		if (searchText == null || searchText.getText().trim().length() == 0) {
			results.addAll(allMembers);
		} else {
			String memberName = searchText.getText();
			if (memberName.isEmpty() || memberName.equals(DEFAULT_SEARCH_DISPLAY_TXT)) {
				results.addAll(allMembers);
			} else {
				for (Membership member : allMembers) {
					Person person = member.getMember();
					String matchText = person.getGivenName() + " " + person.getFamilyName() + " "
							+ person.getAdditionalNames();
					if (matchText.toUpperCase().contains(memberName.toUpperCase())) {
						results.add(member);
					}
				}
			}
		}
		System.err.println("search time: " + (System.currentTimeMillis() - start));
		return results;
	}

	@Override
	protected RecordDialog<Membership> getRecordDialog(Shell shell) {
		return null;
	}

	@Override
	protected void resetFilterConditions() {
		searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
		refreshTableContents();
	}

	@Override
	protected void handleNewItemAction() {
		Membership selectedMember = DairyUtil.createMembership(null, null, null);
		final AddMemberDialog memberDialog = new AddMemberDialog();
		memberDialog.getController().setContext("selectedMember", selectedMember);

		final int returnCode = memberDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			selectedMember = (Membership) memberDialog.getController().getContext("selectedMember");
			// final List<Farm> newFarms = new ArrayList<Farm>();
			// newFarms.addAll(selectedMember.getMember().getFarms());
			// selectedMember.getMember().getFarms().clear();
			// repository.saveNew(selectedMember);
			// for (final Farm newFarm : newFarms) {
			// farmRepository.saveNew(newFarm);
			// selectedMember.getMember().getFarms().add(newFarm);
			// }
			repository.saveNew(selectedMember);
			refreshTableContents();
		}
	}

	@Override
	protected void handleViewItemAction() {
		Membership selectedMember = (Membership) table.getSelection().get(0);
		final BaseDialogView memberDialog = new ViewMemberDialog();
		memberDialog.getController().setContext("selectedMember", selectedMember);

		final int returnCode = memberDialog.open();
		if (returnCode == AbstractWindowController.OK) {
			selectedMember = (Membership) memberDialog.getController().getContext("selectedMember");
			repository.update(selectedMember);
			refreshTableContents();
		} else if (returnCode == 2) {
			// confirm for delete
			if (selectedMember != null) {
				String message = "";
				if (selectedMember.getMember() != null) {
					message = "\"" + selectedMember.getMember().getGivenName() + " "
							+ selectedMember.getMember().getFamilyName() + "\"";
				}
				message = String.format(DELETE_DIALOG_MESSAGE, message);
				if (MessageDialog.openConfirm(AbstractDirectoryController.getShell(), DELETE_DIALOG_TITLE, message)) {
					repository.delete(selectedMember);
					refreshTableContents();
				}
			}
		}
	}

}
