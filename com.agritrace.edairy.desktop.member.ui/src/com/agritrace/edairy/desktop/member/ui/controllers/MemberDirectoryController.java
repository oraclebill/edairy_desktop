package com.agritrace.edairy.desktop.member.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.AddMemberDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewMemberDialog;
import com.agritrace.edairy.desktop.operations.services.DairyRepository;

public class MemberDirectoryController extends SubModuleController {

	private final class SearchLabelListener implements MouseListener {
		@Override
		public void mouseDoubleClick(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDown(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseUp(MouseEvent arg0) {
			if (arg0.getSource() instanceof Label) {
				final String labelText = ((Label) (arg0.getSource())).getText();
				if (labelText.equals("All")) {
					if (searchText != null) {
						searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
					}

				} else {
					if (searchText != null) {
						searchText.setText(labelText);
					}
				}
				refreshMemberList();
			}

		}
	}

	class AddActionListener implements IActionListener {
		@Override
		public void callback() {
			Membership selectedMember = DairyUtil.createMembership(null, null, null);
			final AddMemberDialog memberDialog = new AddMemberDialog();
			memberDialog.getController().setContext("selectedMember", selectedMember);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				selectedMember = (Membership) memberDialog.getController().getContext("selectedMember");
//				final List<Farm> newFarms = new ArrayList<Farm>();
//				newFarms.addAll(selectedMember.getMember().getFarms());
//				selectedMember.getMember().getFarms().clear();
//				repository.saveNew(selectedMember);
//				for (final Farm newFarm : newFarms) {
//					farmRepository.saveNew(newFarm);
//					selectedMember.getMember().getFarms().add(newFarm);
//				}
				repository.saveNew(selectedMember);
				refreshMemberList();
			}
		}
	}

	class ViewActionListener implements IActionListener {
		@Override
		public void callback() {
			Membership selectedMember = (Membership) memberListRidget.getSelection().get(0);
			final BaseDialogView memberDialog = new ViewMemberDialog();
			memberDialog.getController().setContext("selectedMember", selectedMember);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				selectedMember = (Membership) memberDialog.getController().getContext("selectedMember");
				repository.update(selectedMember);
				refreshMemberList();
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
						refreshMemberList();
					}
				}
			}
		}
	}

	public static final String DEFAULT_SEARCH_DISPLAY_TXT = "Type to search members";

	public static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected member %s ?";
	public static final String DELETE_DIALOG_TITLE = "Delete Member";
	private final String[] memberColumnHeaders = { "ID", "First Name", "Last Name", "Route", "Status", "Phone", "Milk Collection",
			"Monthly Credit Sales", "Credit Balance" };

	private final String[] memberPropertyNames = { "memberNumber", "member.givenName", "member.familyName", "defaultRoute.code", "status", "member.phoneNumber", "account", "account",
			"account" };

	private final ILabelRidget[] searchLabels;
	private ITextRidget searchText;
	private IActionRidget viewRidget;
	private ITableRidget memberListRidget;
//	private final IFarmRepository farmRepository;
	private final IMemberRepository repository;
	private final List<Membership> membershipList;
	private List<Membership> allMembers;
	private final Dairy localDairy;
	

	public MemberDirectoryController() {
		membershipList 	= new ArrayList<Membership>();
		searchLabels 	= new ILabelRidget[27];
		repository 		= DairyRepository.getInstance();
//		farmRepository 	= new FarmRepository();
		localDairy 		= DairyRepository.getInstance().getLocalDairy(); 
		allMembers 		= localDairy.getMemberships();
	}

	// void initRepository() {
	// if (null == repository)
	// repository = new MemberRepository();
	// }

	// IRepository<Membership> getRepository() {
	// return repository;
	// }

	@Override
	public void afterBind() {
		super.afterBind();
		if (searchLabels != null) {
			MouseListener mouseListener = new SearchLabelListener();
			for (final ILabelRidget searchLabel : searchLabels) {
				if ((searchLabel != null) && (searchLabel.getUIControl() != null)) {
					((Label) (searchLabel.getUIControl())).addMouseListener(mouseListener);
				}
			}

		}

	}

	@Override
	public void configureRidgets() {
		// initRepository();
		configureMemberTable();
		refreshMemberList();
	}

	public void refreshMemberList() {
		membershipList.clear();
		membershipList.addAll(getFilteredResult());
		memberListRidget.updateFromModel();
	}

	private void configureMemberTable() {		
		searchLabels[0] = getRidget(ILabelRidget.class, "All");
		for (char i = 'A'; i < 'Z'; i++) {
			searchLabels[i - 'A' + 1] = getRidget(ILabelRidget.class, new String(new char[] { i }));
		}
		searchText = getRidget(ITextRidget.class, ViewWidgetId.MEMBERLIST_SEARCHTEXT);
		searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
		searchText.setDirectWriting(true);
		searchText.addFocusListener(new IFocusListener() {
			@Override
			public void focusGained(FocusEvent event) {
				String text = searchText.getText();
				if (text != null && text.equals(DEFAULT_SEARCH_DISPLAY_TXT)) {
					searchText.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent event) {
				String text = searchText.getText();
				if (text != null && text.equals("")) {
					searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
				}
			}
			
		});
		searchText.addPropertyChangeListener("text", new PropertyChangeListener() {			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				refreshMemberList();
			}
		});


		memberListRidget = getRidget(ITableRidget.class, ViewWidgetId.MEMBERLIST_MEMBERTABLE);
		
		final IActionRidget searchButton = getRidget(IActionRidget.class, ViewWidgetId.memberInfo_searchButton);
		searchButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				refreshMemberList();

			}
		});

		addDefaultAction(searchText, searchButton);

		final IActionRidget clearButton = getRidget(IActionRidget.class, ViewWidgetId.memberInfo_clearButton);
		clearButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				if (searchText != null) {
					searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
					refreshMemberList();
				}

			}
		});

		if (repository != null) {

			memberListRidget.bindToModel(new WritableList(membershipList, Membership.class), Membership.class,
					memberPropertyNames, memberColumnHeaders);

			memberListRidget.setColumnFormatter(6, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					return "N/A";
				}
			});
			memberListRidget.setColumnFormatter(7, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					return "N/A";
				}
			});

			memberListRidget.setColumnFormatter(8, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					return "N/A";
				}
			});
			memberListRidget.addSelectionListener(new ISelectionListener() {
				@Override
				public void ridgetSelected(SelectionEvent event) {
					if (event.getSource() == memberListRidget) {
						viewRidget.setEnabled(memberListRidget.getSelection().size() > 0);
					}
				}
			});
			memberListRidget.addDoubleClickListener(new ViewActionListener());

			// memberListRidget.updateFromModel();
			getRidget(IActionRidget.class, ViewWidgetId.MEMBERLIST_ADD).addListener(new AddActionListener());
			viewRidget = getRidget(IActionRidget.class, ViewWidgetId.MEMBERLIST_VIEW);
			if (viewRidget != null) {
				viewRidget.setEnabled(false);
				viewRidget.addListener(new ViewActionListener());
			}
		}
	}
	
	
	protected List<Membership> getFilteredResult() {
		final List<Membership> results = new ArrayList<Membership>();
		long start = System.currentTimeMillis();
		if (searchText == null) {
			results.addAll(allMembers);
		}
		else {
			String memberName = searchText.getText();
			if (memberName.isEmpty() || memberName.equals(DEFAULT_SEARCH_DISPLAY_TXT)) {
				results.addAll(allMembers);
			}
			else {				
				for(Membership member : allMembers) {
					Person person = member.getMember();
					String matchText = person.getGivenName() + " " + person.getFamilyName() + " " + person.getAdditionalNames();
					if (matchText.toUpperCase().contains(memberName.toUpperCase())) {
						results.add(member);
					}
				}
			} 
		}
		System.err.println("search time: " + (System.currentTimeMillis() - start));
		return results;
	}

}
