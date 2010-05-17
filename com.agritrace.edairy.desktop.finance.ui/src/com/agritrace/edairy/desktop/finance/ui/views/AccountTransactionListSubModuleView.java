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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.agritrace.edairy.desktop.common.ui.views.AbstractDirectoryView;
import com.agritrace.edairy.desktop.finance.ui.controllers.TransactionRegisterSubModuleController;

public class AccountTransactionListSubModuleView extends AbstractDirectoryView implements ViewConstants {

    public final static String ID = "dairy.transactions.register";

    private Table searchResultTable;

    private DatePickerComposite startDatePicker, endDatePicker;
    private Text memberIdText;
    private ChoiceComposite typeCodeChoice;

    @Override
    public void basicCreatePartControl(Composite parent) {
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	GridLayout masterLayout = new GridLayout();
	masterLayout.numColumns = 2;
	parent.setLayout(masterLayout);
	
	Composite filterPanel 	= UIControlsFactory.createComposite(parent);
	Composite filterButtonsPanel 	= UIControlsFactory.createComposite(parent);
	Composite gridPanel 	= UIControlsFactory.createComposite(parent);
	Composite buttonPanel 	= UIControlsFactory.createComposite(parent);
	
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false)
		.applyTo(filterPanel);
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false)
		.applyTo(filterButtonsPanel);
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2,1)
		.applyTo(gridPanel);
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).span(2,1)
		.applyTo(buttonPanel);
	
	setupFilterPanel(filterPanel);
	setupFilterButtonsPanel(filterButtonsPanel);
	setupListPanel(gridPanel);
	setupButtonPanel(buttonPanel);

	parent.setTabList(new Control[] { filterPanel, gridPanel, buttonPanel } );	
    }
    
    protected void setupFilterPanel(Composite parent) 
    {
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	
	// filter is a stack of composite rows.. each row uses formlayout..
	GridLayout topLayout = new GridLayout(1, true);
	parent.setLayout(topLayout);
	
	// first row: date range
	//
	Composite row = UIControlsFactory.createComposite(parent);	
	FormLayout layout = new FormLayout();
	layout.marginWidth = layout.marginHeight = 10;
	row.setLayout(layout);
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(row);

	Label startDateLabel = new Label(row, SWT.LEFT);
	startDateLabel.setText("Date Range - Start: ");
	startDateLabel.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
	FormData fd = new FormData();
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
	
	// second row: member lookup
	//
	row = UIControlsFactory.createComposite(parent);	
	layout = new FormLayout();
	layout.marginWidth = layout.marginHeight = 10;
	row.setLayout(layout);	
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(row);
	
	Label memberLookupLabel = UIControlsFactory.createLabel(row, "Member Lookup");
	fd = new FormData();
	fd.top = new FormAttachment(0, 0);
	fd.left = new FormAttachment(0, 0);
	memberLookupLabel.setLayoutData(fd);
	
	memberIdText = UIControlsFactory.createText(row, SWT.NONE, "memberIdRidget");
	fd = new FormData();
	fd.top = new FormAttachment(memberLookupLabel, 0, SWT.CENTER);
	fd.left = new FormAttachment(memberLookupLabel, 5, SWT.RIGHT);
	fd.width = FIELD_WIDTH * 3;
	memberIdText.setLayoutData(fd);
	
	// third row: source choices
	//
	row = UIControlsFactory.createComposite(parent);	
	layout = new FormLayout();
	layout.marginWidth = layout.marginHeight = 10;
	row.setLayout(layout);	
	GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, false).applyTo(row);
	
	Label transactionSourceLabel = UIControlsFactory.createLabel(row, "Transaction Source");
	fd = new FormData();
	fd.top = new FormAttachment(0, 0);
	fd.left = new FormAttachment(0, 0);
	transactionSourceLabel.setLayoutData(fd);
	
	typeCodeChoice = UIControlsFactory.createChoiceComposite(row, LEFT, true, "typeSetRidget");
	fd = new FormData();
	fd.top = new FormAttachment(transactionSourceLabel, 0, SWT.CENTER);
	fd.left = new FormAttachment(transactionSourceLabel, 5, SWT.RIGHT);
	fd.width = FIELD_WIDTH;
	typeCodeChoice.setLayoutData(fd);
	
	
    }

    protected void setupFilterButtonsPanel(Composite parent) {
	FormData fd;
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
	parent.setLayout(new RowLayout());
	
	Button clearButton = new Button(parent, 0);
	clearButton.setText("Clear");
	addUIControl(clearButton, "clearAction");

	Button searchButton = new Button(parent, 0);
	searchButton.setText("Search");
	addUIControl(searchButton, "searchAction");


    }

    protected void setupListPanel(Composite parent) 
    {
	parent.setLayout(new FillLayout());
	// create table
	searchResultTable = new Table(parent, SWT.BORDER | SWT.FULL_SELECTION);
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
	txDescriptionCol.setWidth(500);
	txAmountCol.setWidth(120);
	
	searchResultTable.setHeaderVisible(true);	
    }
    
    protected void setupButtonPanel(Composite parent) {
	FormData fd;
	parent.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
	parent.setLayout(new RowLayout());
	
	// open button
	Button openButton = new Button(parent, 0);
	openButton.setText("View");
	addUIControl(openButton, "openAction");

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
	return new TransactionRegisterSubModuleController(getNode());
    }
}
