package com.agritrace.edairy.desktop.finance.ui.views;

import java.util.HashMap;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.riena.navigation.ISubModuleNode;
import org.eclipse.riena.navigation.ui.controllers.SubModuleController;
import org.eclipse.riena.navigation.ui.swt.presentation.SwtViewProvider;
import org.eclipse.riena.navigation.ui.swt.views.SubModuleView;
import org.eclipse.riena.ui.swt.CompletionCombo;
import org.eclipse.riena.ui.swt.DatePickerComposite;
import org.eclipse.riena.ui.swt.utils.UIControlsFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
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
import org.eclipse.ui.PlatformUI;

import com.agritrace.edairy.desktop.finance.ui.ViewConstants;
import com.agritrace.edairy.desktop.finance.ui.controllers.MemberTransactionRegisterController;
import com.swtdesigner.SWTResourceManager;

public class AccountTransactionListSubModuleView extends SubModuleView implements ViewConstants {

	public final static String ID = "dairy.transactions.register";

	private Table searchResultTable;

	private DatePickerComposite startDatePicker, endDatePicker;
	private Text memberIdText;
	private Button clearButton;
	private Button searchButton;
	private FormData fd_1;
	private FormData fd_2;
	private FormData fd_3;
	private FormData fd_3_1;

	private Composite filterButtonsPanel;
	private Composite row_1;
	private Composite buttonPanel;
	private Group resultsGroup;

	private CompletionCombo refNumberLookup;

	public AccountTransactionListSubModuleView() {
	}

	@Override
	public void basicCreatePartControl(Composite parent) {
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
		GridLayout masterLayout = new GridLayout();
		masterLayout.numColumns = 2;
		masterLayout.marginTop = 5;
		masterLayout.marginRight = 5;
		masterLayout.marginLeft = 5;
		parent.setLayout(masterLayout);

		Group filterPanel = UIControlsFactory.createGroup(parent, "Search / Filter");
		GridData gd_filterPanel = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		gd_filterPanel.minimumWidth = 600;
		filterPanel.setLayoutData(gd_filterPanel);
		filterButtonsPanel = UIControlsFactory.createComposite(parent);
		filterButtonsPanel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		resultsGroup = new Group(parent, SWT.NONE);
		resultsGroup.setText("Filter Results");
		buttonPanel = UIControlsFactory.createComposite(parent);
		buttonPanel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterPanel);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(filterButtonsPanel);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(resultsGroup);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2, 1).applyTo(buttonPanel);
		RowLayout rl_buttonPanel = new RowLayout();
		buttonPanel.setLayout(rl_buttonPanel);

		Button btnAddNew = new Button(buttonPanel, SWT.NONE);
		btnAddNew.setText("Add New");

		Button btnBatchEntry = new Button(buttonPanel, SWT.NONE);
		btnBatchEntry.setText("Batch Entry");

		setupFilterPanel(filterPanel);
		setupFilterButtonsPanel(filterButtonsPanel);
		setupResultsPanel(resultsGroup);
		setupResultsButtonPanel(resultsGroup);
		setupButtonPanel(resultsGroup);

		parent.setTabList(new Control[] { filterPanel, resultsGroup, buttonPanel });
	}

	private void setupResultsButtonPanel(Composite parent) {

		Composite resultButtonsPanel = new Composite(parent, SWT.NONE);
		resultButtonsPanel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		resultButtonsPanel.setLayout(new RowLayout());

		Button btnEditTransaction = UIControlsFactory.createButton(resultButtonsPanel, "Edit", "openAction");

		Button btnDeleteTransaction = new Button(resultButtonsPanel, SWT.NONE);
		btnDeleteTransaction.setText("Delete");

	}

	protected void setupFilterPanel(Composite parent) {
		parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

		// filter is a stack of composite rows.. each row uses formlayout..
		GridLayout topLayout = new GridLayout(1, false);
		parent.setLayout(topLayout);

		// first row: date range
		//
		{
			Composite row = UIControlsFactory.createComposite(parent);
			FormLayout layout = new FormLayout();
			layout.marginWidth = layout.marginHeight = 10;
			row.setLayout(layout);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(row);

			Label startDateLabel = new Label(row, SWT.LEFT);
			startDateLabel.setText("Date Range - Start: ");
			startDateLabel.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
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
			endDateLabel.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
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
		}
		// second row: member lookup
		//
		{
			Composite row = UIControlsFactory.createComposite(parent);
			FormLayout layout = new FormLayout();
			layout.marginWidth = layout.marginHeight = 10;
			row.setLayout(layout);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(row);

			Label memberLookupLabel = UIControlsFactory.createLabel(row, "Member Lookup");
			fd_1 = new FormData();
			fd_1.width = 140;
			fd_1.top = new FormAttachment(0, 0);
			fd_1.left = new FormAttachment(0, 0);
			memberLookupLabel.setLayoutData(fd_1);

			memberIdText = UIControlsFactory.createText(row, SWT.SEARCH, "memberIdRidget");
			fd_3 = new FormData();
			fd_3.width = 300;
			fd_3.top = new FormAttachment(memberLookupLabel, 0, SWT.CENTER);
			fd_3.left = new FormAttachment(memberLookupLabel, 5, SWT.RIGHT);
			memberIdText.setLayoutData(fd_3);
		}

		// third row: reference number lookup
		//
		{
			Composite rowComposite = UIControlsFactory.createComposite(parent);
			FormLayout rowLayout = new FormLayout();
			rowLayout.marginWidth = rowLayout.marginHeight = 10;
			rowComposite.setLayout(rowLayout);
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(rowComposite);

			Label label = UIControlsFactory.createLabel(rowComposite, "Reference Number");
			FormData labelFormData = new FormData();
			labelFormData.width = 140;
			labelFormData.top = new FormAttachment(0, 0);
			labelFormData.left = new FormAttachment(0, 0);
			label.setLayoutData(labelFormData);

			refNumberLookup = UIControlsFactory.createCompletionCombo(rowComposite, "refNumLookupTxt");
			FormData fieldFormData = new FormData();
			fieldFormData.left = new FormAttachment(label);
			fieldFormData.width = 300;
			fieldFormData.top = new FormAttachment(label, 0, SWT.CENTER);
			refNumberLookup.setLayoutData(fieldFormData);
		}

		// fourth row: source choices
		//
		{
			Composite rowComposite = new TransactionTypeComposite(parent, true, "Transaction Source");
			GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(rowComposite);
			addListener(rowComposite);
			rpc(rowComposite);

		}
	}

	private static final Color CYAN = PlatformUI.getWorkbench().getDisplay().getSystemColor(SWT.COLOR_CYAN);
	private MouseTrackListener mt = new MouseTrackAdapter() {
		HashMap<Object, Color> oldColors = new HashMap<Object, Color>();

		@Override
		public void mouseEnter(MouseEvent e) {
			System.err.println(">> mouseEnter" + e);
			Object o = e.getSource();
			if (o instanceof Control) {
				Control c = (Control) o;
				oldColors.put(c, c.getBackground());
				c.setBackground(CYAN);
			}

		}

		@Override
		public void mouseExit(MouseEvent e) {
			System.err.println(">> mouseExit" + e);
			Object o = e.getSource();
			if (o instanceof Control) {
				Control c = (Control) o;
				Color color = oldColors.get(c);
				if (color != null) {
					c.setBackground(color);
					oldColors.remove(c);
					rpc(c);
				} else {
					System.err.println("no color found for " + c);
				}
			}
		}

		@Override
		public void mouseHover(MouseEvent e) {
			System.err.println(">> mouseHover" + e);
		}

	};

	private void rpc(Control control) {
		rpc(control, 0);
	}
	
	private void rpc(Control control, int level) {
		pc(level, control);
		if (control instanceof Composite) {
			for (Control c : ((Composite) control).getChildren()) {
				rpc(c, level + 1);
			}
		}
	}
	
	private void pc(int level, Control c) {
		System.err.println("[" + level + "]"
				+ " found child: " + c 
				+ ", bounds=" + c.getBounds() 
				+ ", location=" + c.getLocation() 
				+ ", background=" + c.getBackground()
				+ ", foreground=" + c.getForeground()
			);
	}

	private void addListener(Control control) {
		control.addMouseTrackListener(mt);
		if (control instanceof Composite) {
			for (Control c : ((Composite) control).getChildren()) {
				addListener(c);
			}
		}
	}

	protected void setupFilterButtonsPanel(Composite parent) {
		FormData fd;
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		filterButtonsPanel.setLayout(new GridLayout(1, false));

		searchButton = new Button(parent, 0);
		searchButton.setText("Search");
		addUIControl(searchButton, "searchAction");

		clearButton = new Button(parent, 0);
		clearButton.setText("Clear");
		addUIControl(clearButton, "clearAction");

	}

	protected void setupResultsPanel(Composite parent) {
		resultsGroup.setLayout(new GridLayout(1, false));
		// create table
		searchResultTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
		searchResultTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		searchResultTable.setLinesVisible(true);

		addUIControl(searchResultTable, "tableRidget");

		TableColumn txDateCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txIdCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txSourceCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txTypeCol = new TableColumn(searchResultTable, SWT.CENTER);
		TableColumn txDescriptionCol = new TableColumn(searchResultTable, SWT.CENTER);
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
		parent.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));

	}

	private ISubModuleNode getNode() {
		return SwtViewProvider.getInstance().getNavigationNode(this.getViewSite().getId(),
				this.getViewSite().getSecondaryId(), ISubModuleNode.class);
	}

	@Override
	public void setFocus() {
		super.setFocus();
	}

	@Override
	protected SubModuleController createController(ISubModuleNode subModuleNode) {
		return new MemberTransactionRegisterController(getNode());
	}
}
