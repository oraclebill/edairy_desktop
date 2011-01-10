package com.agritrace.edairy.desktop.member.ui.controllers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.riena.ui.ridgets.IActionListener;
import org.eclipse.riena.ui.ridgets.IActionRidget;
import org.eclipse.riena.ui.ridgets.ILabelRidget;
import org.eclipse.riena.ui.ridgets.ITextRidget;
import org.eclipse.riena.ui.ridgets.listener.FocusEvent;
import org.eclipse.riena.ui.ridgets.listener.IFocusListener;
import org.eclipse.swt.widgets.Shell;

import com.agritrace.edairy.desktop.common.model.base.Person;
import com.agritrace.edairy.desktop.common.model.dairy.Dairy;
import com.agritrace.edairy.desktop.common.model.dairy.DairyPackage;
import com.agritrace.edairy.desktop.common.model.dairy.Membership;
import com.agritrace.edairy.desktop.common.model.dairy.security.PermissionRequired;
import com.agritrace.edairy.desktop.common.model.dairy.security.UIPermission;
import com.agritrace.edairy.desktop.common.persistence.DairyUtil;
import com.agritrace.edairy.desktop.common.persistence.IMemberRepository;
import com.agritrace.edairy.desktop.common.persistence.IMilkCollectionRepository;
import com.agritrace.edairy.desktop.common.ui.columnformatters.ConstantColumnFormatter;
import com.agritrace.edairy.desktop.common.ui.controllers.AbstractDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.BasicDirectoryController;
import com.agritrace.edairy.desktop.common.ui.controllers.DirectoryPersistenceDelegate;
import com.agritrace.edairy.desktop.common.ui.dialogs.RecordDialog;
import com.agritrace.edairy.desktop.common.ui.views.BaseListView;
import com.agritrace.edairy.desktop.member.services.farm.IFarmRepository;
import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;
import com.agritrace.edairy.desktop.member.ui.dialog.MemberEditDialog;
import com.agritrace.edairy.desktop.member.ui.dialog.controller.MemberEditDialogController;
import com.agritrace.edairy.desktop.operations.services.IDairyRepository;
import com.google.inject.Inject;

@PermissionRequired(UIPermission.VIEW_MEMBER_LIST)
public class MemberDirectoryController2 extends BasicDirectoryController<Membership> {

	private final class DefaultTextListener implements IFocusListener {
		@Override
		public void focusGained(FocusEvent event) {
			final String text = searchText.getText();
			if (text != null && text.equals(DEFAULT_SEARCH_DISPLAY_TXT)) {
				System.err.println("]]]] TEXT: clearing...'");
				searchText.setText("");
			}
		}

		@Override
		public void focusLost(FocusEvent event) {
			final String text = searchText.getText();
			System.err.println("]]]] TEXT: '" + text + "'");
			if (text != null && text.equals("")) {
				System.err.println("]]]] TEXT: setting...'");
				searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
			}
		}
	}

	class MemberPersistenceDelegate extends DirectoryPersistenceDelegate<Membership> {

		public MemberPersistenceDelegate(AbstractDirectoryController<Membership> controller) {
			super(controller);
		}

		@Override
		public Membership createItem() {
			return DairyUtil.createMembership(null, null, null);
		}

	}

	private static final String DEFAULT_SEARCH_DISPLAY_TXT = "Type to search members";
	private static final String DELETE_DIALOG_MESSAGE = "Do you want to delete the selected member %s ?";
	private static final String DELETE_DIALOG_TITLE = "Delete Member";

	private final String[] memberColumnHeaders = { "ID", "Name", "Default Route", "Status", "Phone", "Milk Collection",
			"Monthly Credit Sales", "Credit Balance" };

	private final String[] memberPropertyNames = { "memberNumber", "member.formattedName", "defaultRoute.code",
			"status.name", "member.phoneNumber" }; 

	private ITextRidget searchText;
	private final Dairy localDairy;
	private IMilkCollectionRepository collectionsRepo;
	private IFarmRepository farmRepo;

	@Inject
	public MemberDirectoryController2(final IMemberRepository repository, final IDairyRepository dairyRepo,
			IFarmRepository farmRepo, IMilkCollectionRepository collectionsRepo) {
		setRepository(repository);
		this.collectionsRepo = collectionsRepo;
		this.farmRepo = farmRepo;
		this.localDairy = dairyRepo.getLocalDairy();

		setEClass(DairyPackage.Literals.MEMBERSHIP);
		setPersistenceDelegate(new MemberPersistenceDelegate(this));

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

		getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_RESET).addListener(new IActionListener() {
			@Override
			public void callback() {
				if (searchText != null) {
					searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
				}
			}
		});
		addDefaultAction(searchText, getRidget(IActionRidget.class, BaseListView.BIND_ID_FILTER_SEARCH));

	}

	@Override
	protected List<Membership> getFilteredResult() {
		final List<Membership> allMembers = localDairy.getMemberships();
		final List<Membership> results = new ArrayList<Membership>();
		final long start = System.currentTimeMillis();
		if (searchText == null || searchText.getText().trim().length() == 0) {
			results.addAll(allMembers);
		} else {
			final String memberName = searchText.getText();
			if (memberName.isEmpty() || memberName.equals(DEFAULT_SEARCH_DISPLAY_TXT)) {
				results.addAll(allMembers);
			} else {
				for (final Membership member : allMembers) {
					final Person person = member.getMember();
					final String matchText = person.getGivenName() + " " + person.getFamilyName() + " "
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

	private MemberEditDialogController controller;
	
	@Override
	protected RecordDialog<Membership> getRecordDialog(Shell shell) {
		assert controller != null;
//		final MemberEditDialogController controller = new MemberEditDialogController(localDairy.getBranchLocations());
		return new MemberEditDialog(getShell(), controller);
	}

	@Override
	protected void resetFilterConditions() {
		searchText.setText(DEFAULT_SEARCH_DISPLAY_TXT);
		refreshTableContents();
	}

	@Override
	protected void handleNewItemAction() {
		controller = new MemberEditDialogController(localDairy.getBranchLocations());
		super.handleNewItemAction();
	}

	@Override
	protected void handleViewItemAction() {
		controller = new MemberEditDialogController(
				localDairy.getBranchLocations(), (IMemberRepository)getRepository(), farmRepo, collectionsRepo);
		super.handleViewItemAction();
	}
}
