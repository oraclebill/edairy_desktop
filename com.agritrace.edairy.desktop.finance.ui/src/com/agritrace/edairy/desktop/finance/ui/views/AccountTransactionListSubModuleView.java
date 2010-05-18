package com.agritrace.edairy.desktop.finance.ui.views;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.navigation.ui.swt.presentation.SwtViewProvider;
import org.eclipse.riena.ui.swt.ChoiceComposite;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.finance.ui.controllers.AccountTransactionListSubModuleController;
//import org.eclipse.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AccountTransactionListSubModuleView extends AbstractDirectoryView
		implements ViewConstants {
	public AccountTransactionListSubModuleView() {
	}

	public final static String ID = "dairy.transactions.register";

	private Table searchResultTable;

	private DatePickerComposite startDatePicker, endDatePicker;
	private Text memberIdText;
	private ChoiceComposite typeCodeChoice;
	private Button clearButton;
	private Button searchButton;
	private FormData fd_1;
	private FormData fd_2;
	private FormData fd_3;

	private Composite filterButtonsPanel;
	private Composite row_1;
	
	@Override
	public void basicCreatePartControl(Composite parent) {
		parent.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_WHITE));
		GridLayout masterLayout = new GridLayout();
		masterLayout.numColumns = 2;
		masterLayout.marginTop = 5;
		masterLayout.marginRight = 5;
		masterLayout.marginLeft = 5;
		parent.setLayout(masterLayout);

		Group filterPanel = UIControlsFactory.createGroup(parent, "Search / Filter");
		GridData gd_filterPanel = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_filterPanel.minimumWidth = 600;
//		gd_filterPanel.widthHint = 601;
		filterPanel.setLayoutData(gd_filterPanel);
		filterButtonsPanel = UIControlsFactory
				.createComposite(parent);
		filterButtonsPanel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		Composite gridPanel = UIControlsFactory.createComposite(parent);
		gridPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		Composite buttonPanel = UIControlsFactory.createComposite(parent);

		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(filterPanel);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(filterButtonsPanel);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, true).span(2, 1).applyTo(gridPanel);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).span(2, 1).applyTo(buttonPanel);

		setupFilterPanel(filterPanel);
		setupFilterButtonsPanel(filterButtonsPanel);
		setupListPanel(gridPanel);
		setupButtonPanel(buttonPanel);

		parent.setTabList(new Control[] { filterPanel, gridPanel, buttonPanel });
	}

	protected void setupFilterPanel(Composite parent) {
		parent.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_WHITE));

		// filter is a stack of composite rows.. each row uses formlayout..
		GridLayout topLayout = new GridLayout(1, true);
		parent.setLayout(topLayout);

		// first row: date range
		//
		Composite row = UIControlsFactory.createComposite(parent);
		FormLayout layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = 10;
		row.setLayout(layout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(row);

		Label startDateLabel = new Label(row, SWT.LEFT);
		startDateLabel.setText("Date Range - Start: ");
		startDateLabel.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_WHITE));
		FormData fd = new FormData();
		fd.width = 140;
		fd.top = new FormAttachment(0, 0);
		fd.left = new FormAttachment(0, 0);
		startDateLabel.setLayoutData(fd);

		startDatePicker = new DatePickerComposite(row, SWT.BORDER | SWT.SINGLE);
		fd = new FormData();
		fd.top = new FormAttachment(startDateLabel, 0, SWT.CENTER);
		fd.left = new FormAttachment(startDateLabel, 5, SWT.RIGHT);
		fd.width = FIELD_WIDTH;
		startDatePicker.setLayoutData(fd);
		addUIControl(startDatePicker, "startDateRidget");

		Label endDateLabel = new Label(row, SWT.LEFT);
		endDateLabel.setText("End: ");
		endDateLabel.setBackground(Display.getDefault().getSystemColor(
				SWT.COLOR_WHITE));
		fd = new FormData();
		fd.top = new FormAttachment(startDatePicker, 0, SWT.CENTER);
		fd.left = new FormAttachment(startDatePicker, 20, SWT.RIGHT);
		endDateLabel.setLayoutData(fd);

		endDatePicker = new DatePickerComposite(row, SWT.BORDER | SWT.SINGLE);
		fd = new FormData();
		fd.top = new FormAttachment(endDateLabel, 0, SWT.CENTER);
		fd.left = new FormAttachment(endDateLabel, 5, SWT.RIGHT);
		fd.width = FIELD_WIDTH;
		endDatePicker.setLayoutData(fd);
		addUIControl(endDatePicker, "endDateRidget");

		// second row: member lookup
		//
		row = UIControlsFactory.createComposite(parent);
		layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = 10;
		row.setLayout(layout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(row);

		Label memberLookupLabel = UIControlsFactory.createLabel(row,
				"Member Lookup");
		fd_1 = new FormData();
		fd_1.width = 140;
		fd_1.top = new FormAttachment(0, 0);
		fd_1.left = new FormAttachment(0, 0);
		memberLookupLabel.setLayoutData(fd_1);

		memberIdText = UIControlsFactory.createText(row, SWT.NONE,
				"memberIdRidget");
		fd_3 = new FormData();
		fd_3.width = 300;
		fd_3.top = new FormAttachment(memberLookupLabel, 0, SWT.CENTER);
		fd_3.left = new FormAttachment(memberLookupLabel, 5, SWT.RIGHT);
		memberIdText.setLayoutData(fd_3);

		// third row: source choices
		//
		row_1 = UIControlsFactory.createComposite(parent);
		row_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		layout = new FormLayout();
		layout.marginWidth = layout.marginHeight = 10;
		row_1.setLayout(layout);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL)
				.grab(true, false).applyTo(row_1);

		Label transactionSourceLabel = UIControlsFactory.createLabel(row_1,
				"Transaction Source");
		fd_2 = new FormData();
		fd_2.width = 140;
		fd_2.top = new FormAttachment(0, 0);
		fd_2.left = new FormAttachment(0, 0);
		transactionSourceLabel.setLayoutData(fd_2);

		typeCodeChoice = UIControlsFactory.createChoiceComposite(row_1, LEFT,
				true, "typeSetRidget");
		RowLayout rl_typeCodeChoice = new RowLayout(SWT.HORIZONTAL);
		rl_typeCodeChoice.fill = true;
		typeCodeChoice.setLayout(rl_typeCodeChoice);
		fd = new FormData();
		fd.top = new FormAttachment(0,0);
		fd.left = new FormAttachment(transactionSourceLabel, 5, SWT.RIGHT);
		fd.width = FIELD_WIDTH;
		typeCodeChoice.setLayoutData(fd);
		
		Button button1 = new Button(typeCodeChoice, SWT.CHECK);
		button1.setLayoutData(new RowData(140, -1));
		button1.setText("Store Credits");
		
		Button button = new Button(typeCodeChoice, SWT.CHECK);
		button.setToolTipText("Payments for vet and animal services.");
		button.setLayoutData(new RowData(140, -1));
		button.setText("Veterinary Services ");

		Button button2 = new Button(typeCodeChoice, SWT.CHECK);
		button2.setLayoutData(new RowData(140, -1));
		button2.setText("Cash Payments");

		Button button3 = new Button(typeCodeChoice, SWT.CHECK);
		button3.setLayoutData(new RowData(140, -1));
		button3.setText("Share Deductions");

	}

	protected void setupFilterButtonsPanel(Composite parent) {
		FormData fd;
		parent.setBackground(Display.getDefault()
				.getSystemColor(SWT.COLOR_CYAN));
		filterButtonsPanel.setLayout(new GridLayout(1, false));
		
				searchButton = new Button(parent, 0);
				searchButton.setText("Search");
				addUIControl(searchButton, "searchAction");

		clearButton = new Button(parent, 0);
		clearButton.setText("Clear");
		addUIControl(clearButton, "clearAction");

	}

	protected void setupListPanel(Composite parent) {
		parent.setLayout(new FillLayout());
		// create table
		searchResultTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		searchResultTable.setLinesVisible(true);

		addUIControl(searchResultTable, "tableRidget");

		TableColumn txDateCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txIdCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txSourceCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txTypeCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txDescriptionCol = new TableColumn(searchResultTable,
				SWT.CENTER);
		TableColumn txAmountCol = new TableColumn(searchResultTable, SWT.CENTER);

		txDateCol.setWidth(120);
		txIdCol.setWidth(80);
		txSourceCol.setWidth(120);
		txTypeCol.setWidth(120);
		txDescriptionCol.setWidth(300);
		txAmountCol.setWidth(120);

		searchResultTable.setHeaderVisible(true);
	}

	protected void setupButtonPanel(Composite parent) {
		FormData fd;
		parent.setBackground(Display.getDefault()
				.getSystemColor(SWT.COLOR_CYAN));
		parent.setLayout(new RowLayout());

		// open button
		Button openButton = new Button(parent, 0);
		openButton.setText("View");
		addUIControl(openButton, "openAction");

	}

	private ISubModuleNode getNode() {
		return SwtViewProvider.getInstance().getNavigationNode(
				this.getViewSite().getId(),
				this.getViewSite().getSecondaryId(), ISubModuleNode.class);
	}

	@Override
	public void setFocus() {
		super.setFocus();
	}

	@Override
	protected SubModuleController createController(ISubModuleNode subModuleNode) {
		return new AccountTransactionListSubModuleController(getNode());
	}
}
