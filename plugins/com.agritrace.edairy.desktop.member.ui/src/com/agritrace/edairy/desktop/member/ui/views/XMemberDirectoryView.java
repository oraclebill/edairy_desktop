package com.agritrace.edairy.desktop.member.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.lnf.LnfKeyConstants;
import org.eclipse.riena.ui.swt.lnf.LnfManager;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.member.ui.ViewWidgetId;

public class XMemberDirectoryView extends SubModuleView {

	public XMemberDirectoryView() {
	}

	public static final String FILTER_GROUP_TEXT = "Search for a Member";

	public static final String ID = XMemberDirectoryView.class.getName();

	private void createFilterGroup(Composite parent) {
		// group
		final Group filterGroup = UIControlsFactory.createGroup(parent, FILTER_GROUP_TEXT);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterGroup);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(filterGroup);
		// character panel
		final Composite charPanel = UIControlsFactory.createComposite(filterGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(charPanel);
		GridLayoutFactory.fillDefaults().numColumns(27).equalWidth(false).applyTo(charPanel);

		final Label allLabel = UIControlsFactory.createLabel(charPanel, "All");
		addUIControl(allLabel, allLabel.getText());

		final char AChar = 'A';
		final char ZChar = 'Z';
		for (char i = AChar; i < ZChar; i++) {
			final Label charLabel = UIControlsFactory.createLabel(charPanel, new String(new char[] { i }));
			addUIControl(charLabel, charLabel.getText());
		}

		// search text
		final Text searchText = UIControlsFactory.createText(filterGroup, SWT.SINGLE | SWT.BORDER,
				ViewWidgetId.MEMBERLIST_SEARCHTEXT);
		GridDataFactory.swtDefaults().align(SWT.LEFT, SWT.FILL).hint(250, -1).grab(false, false).applyTo(searchText);
		searchText.setText("Type filter text");
		searchText.setTextLimit(200);

		// search cancel button
		final Composite searchPanel = UIControlsFactory.createComposite(filterGroup);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(searchPanel);
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).applyTo(searchPanel);

		final Button searchButton = UIControlsFactory.createButton(searchPanel, "Search",
				ViewWidgetId.memberInfo_searchButton);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(searchButton);

		final Button cancelButton = UIControlsFactory.createButton(searchPanel, "Clear",
				ViewWidgetId.memberInfo_clearButton);
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(false, false).applyTo(cancelButton);

	}

	private void createMembersListGroup(Composite parent) {
		final Group memberListGroup = UIControlsFactory.createGroup(parent, "Members");
		GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(memberListGroup);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).applyTo(memberListGroup);

		final Composite tablePanel = UIControlsFactory.createComposite(memberListGroup, SWT.NULL);
		tablePanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Table table = UIControlsFactory.createTable(tablePanel, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION,
				ViewWidgetId.MEMBERLIST_MEMBERTABLE);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn columnId = new TableColumn(table, SWT.LEFT);
		columnId.setText("Member No.");
		final TableColumn columnName = new TableColumn(table, SWT.LEFT);
		columnName.setText("Name");
		final TableColumn columnRoute = new TableColumn(table, SWT.LEFT);
		columnRoute.setText("Transport Route");
		final TableColumn columnStatus = new TableColumn(table, SWT.LEFT);
		columnStatus.setText("Status");
		final TableColumn columnPhone = new TableColumn(table, SWT.LEFT);
		columnPhone.setText("Phone");
		final TableColumn columnCollection = new TableColumn(table, SWT.LEFT);
		columnCollection.setText("Milk Collection");
		final TableColumn columnCredit = new TableColumn(table, SWT.LEFT);
		columnCredit.setText("Milk Credit Sales");
		final TableColumn columnCreditBalance = new TableColumn(table, SWT.LEFT);
		columnCreditBalance.setText("Credit Balance");

		final TableColumnLayout layout = new TableColumnLayout();
		layout.setColumnData(columnId, new ColumnWeightData(8));
		layout.setColumnData(columnName, new ColumnWeightData(50));
		layout.setColumnData(columnRoute, new ColumnWeightData(10));
		layout.setColumnData(columnStatus, new ColumnWeightData(12));
		layout.setColumnData(columnPhone, new ColumnWeightData(15));
		layout.setColumnData(columnCollection, new ColumnWeightData(8));
		layout.setColumnData(columnCredit, new ColumnWeightData(8));
		layout.setColumnData(columnCreditBalance, new ColumnWeightData(8));
		tablePanel.setLayout(layout);

		final Composite buttonsPanel = UIControlsFactory.createComposite(memberListGroup, SWT.NULL);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(true, false).applyTo(buttonsPanel);
		buttonsPanel.setLayout(new GridLayout(2, false));

		final Button viewButton = UIControlsFactory.createButton(buttonsPanel, "View", ViewWidgetId.MEMBERLIST_VIEW);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(viewButton);

		final Button addButton = UIControlsFactory.createButton(buttonsPanel, "Add", ViewWidgetId.MEMBERLIST_ADD);
		GridDataFactory.swtDefaults().align(SWT.END, SWT.FILL).grab(false, false).applyTo(addButton);

	}

	@Override
	protected void basicCreatePartControl(Composite parent) {
		parent.setBackground(LnfManager.getLnf().getColor(LnfKeyConstants.SUB_MODULE_BACKGROUND));
		parent.setLayout(new GridLayout(1, false));

		createFilterGroup(parent);
		createMembersListGroup(parent);
	}

}
