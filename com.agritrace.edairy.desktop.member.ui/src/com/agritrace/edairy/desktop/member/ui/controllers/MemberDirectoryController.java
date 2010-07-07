package com.agritrace.edairy.desktop.member.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.conditions.Condition;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectAttributeValueCondition;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EObjectReferenceValueCondition;
import org.eclipse.emf.query.conditions.strings.StringAdapter;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITableRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.controller.AbstractWindowController;
import org.eclipse.riena.ui.ridgets.listener.ISelectionListener;
import org.eclipse.riena.ui.ridgets.listener.SelectionEvent;
import org.eclipse.riena.ui.ridgets.swt.ColumnFormatter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import com.agritrace.edairy.desktop.common.model.base.ModelPackage;
import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.tracking.Farm;
import com.agritrace.edairy.desktop.common.ui.dialogs.BaseDialogView;
import com.agritrace.edairy.desktop.common.ui.managers.DairyUtil;
import com.agritrace.edairy.desktop.member.services.farm.FarmRepository;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.services.member.IMemberRepository;
import com.agritrace.edairy.desktop.member.services.member.MemberRepository;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.AddMemberDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.ViewMemberDialog;

public class MemberDirectoryController extends SubModuleController {

	class AddActionListener implements IActionListener {
		@Override
		public void callback() {
			Membership selectedMember = DairyUtil.createMembership(null, null, null);
			final AddMemberDialog memberDialog = new AddMemberDialog();
			memberDialog.getController().setContext("selectedMember", selectedMember);

			final int returnCode = memberDialog.open();
			if (returnCode == AbstractWindowController.OK) {
				selectedMember = (Membership) memberDialog.getController().getContext("selectedMember");
				final List<Farm> newFarms = new ArrayList<Farm>();
				newFarms.addAll(selectedMember.getMember().getFarms());
				selectedMember.getMember().getFarms().clear();
				repository.saveNew(selectedMember);
				for (final Farm newFarm : newFarms) {
					farmRepository.saveNew(newFarm);
					selectedMember.getMember().getFarms().add(newFarm);
				}
				repository.save(selectedMember);
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
					if (MessageDialog.openConfirm(Display.getDefault().getActiveShell(), DELETE_DIALOG_TITLE, message)) {
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
	private final IFarmRepository farmRepository;
	private final String[] memberColumnHeaders = { "ID", "Name", "Status", "Phone", "Milk Collection",
			"Monthly Credit Sales", "Credit Balance" };

	private ITableRidget memberListRidget;
	private final String[] memberPropertyNames = { "memberId", "member", "status", "member", "account", "account",
			"account" };
	private final List<Membership> membershipList = new ArrayList<Membership>();
	private final IMemberRepository repository;

	private final ILabelRidget[] searchLabels;

	private ITextRidget searchText;

	private IActionRidget viewRidget;

	public MemberDirectoryController() {
		repository = new MemberRepository();
		farmRepository = new FarmRepository();
		searchLabels = new ILabelRidget[27];
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
			for (final ILabelRidget searchLabel : searchLabels) {
				if ((searchLabel != null) && (searchLabel.getUIControl() != null)) {
					((Label) (searchLabel.getUIControl())).addMouseListener(new MouseListener() {

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
					});
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

		memberListRidget = getRidget(ITableRidget.class, ViewWidgetId.MEMBERLIST_MEMBERTABLE);
		final IActionRidget searchButton = getRidget(IActionRidget.class, ViewWidgetId.memberInfo_searchButton);
		searchButton.addListener(new IActionListener() {

			@Override
			public void callback() {
				refreshMemberList();

			}
		});

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

		// if (repository == null) {
		// initRepository();
		// }
		if (repository != null) {

			memberListRidget.bindToModel(new WritableList(membershipList, Membership.class), Membership.class,
					memberPropertyNames, memberColumnHeaders);
			memberListRidget.setColumnFormatter(1, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					if (element instanceof Membership) {
						final Person member = ((Membership) element).getMember();
						if (member != null) {
							return member.getFamilyName() + "," + member.getGivenName();
						}
					}
					return null;
				}
			});
			memberListRidget.setColumnFormatter(3, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					if (element instanceof Membership) {
						final Person member = ((Membership) element).getMember();
						if (member != null) {
							return member.getPhoneNumber();
						}
					}
					return null;
				}
			});
			memberListRidget.setColumnFormatter(4, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					return "N/A";
				}
			});
			memberListRidget.setColumnFormatter(5, new ColumnFormatter() {
				@Override
				public String getText(Object element) {
					return "N/A";
				}
			});

			memberListRidget.setColumnFormatter(6, new ColumnFormatter() {
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

		final List<Membership> allMembers = repository.all();
		final List<Membership> results = new ArrayList<Membership>();

		// Start Date
		final List<EObjectCondition> condtions = new ArrayList<EObjectCondition>();

		SELECT select = null;

		if (searchText != null) {
			String memberName = searchText.getText();
			if (!memberName.isEmpty() && !memberName.equals(DEFAULT_SEARCH_DISPLAY_TXT)) {
				if (!memberName.startsWith("^")) {
					memberName = "^" + memberName;
				}
				final Condition name = new org.eclipse.emf.query.conditions.strings.StringRegularExpressionValue(
						memberName, false, StringAdapter.DEFAULT);
				final EObjectCondition farmNameCond = new EObjectAttributeValueCondition(
						ModelPackage.Literals.PERSON__FAMILY_NAME, name);
				final EObjectCondition farmCond = new EObjectReferenceValueCondition(
						DairyPackage.Literals.MEMBERSHIP__MEMBER, farmNameCond);

				condtions.add(farmCond);
			} else {
				return allMembers;
			}
		}

		select = new SELECT(new FROM(allMembers), new WHERE(condtions.get(0)));

		final IQueryResult result = select.execute();
		for (final EObject object : result.getEObjects()) {
			results.add((Membership) object);
		}
		return results;

	}

}
